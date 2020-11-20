package com.darkstar.service;

import com.darkstar.service.model.Order;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Random;

import static io.vertx.core.logging.LoggerFactory.getLogger;

@ApplicationScoped
public class OrderService {
    private static final Logger LOGGER = getLogger(OrderService.class);

    @Inject
    PgPool client;

    /**
     * Retrieve all items for cafe
     *
     * @return {@link Order} list
     */
    public Multi<Order> getOrders() {
        return client.query("SELECT payload FROM orders;")
                .execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(this::getOrder);
    }

    private Order getOrder(final io.vertx.mutiny.sqlclient.Row row) {
        return row.get(JsonObject.class, 0)
                .mapTo(Order.class);
    }


    public Uni<Response> publishOrder(final Order body) {
        final int uid = getRandomNumberInRange();
        body.setUid((long) uid);
        return client.preparedQuery("INSERT INTO orders (id, payload) VALUES ($1, $2) RETURNING id;")
                .execute(Tuple.of(uid, JsonObject.mapFrom(body)))
                .onItem().transform(pgRowSet -> Response.ok(pgRowSet.iterator().next().getLong("id")).build());
    }

    public Uni<Order> getById(final Long id) {
        return client.preparedQuery("SELECT payload FROM orders WHERE id = $1;")
                .execute(Tuple.of(id))
                .onItem().transform(rows -> getOrderObject(rows.iterator().next()))
                .onFailure().recoverWithItem(error -> {
                    LOGGER.error("Error when fetching data.", error);
                    return null;
                });
    }

    public Uni<Response> updateOrder(final Long id, final Order body) {
        body.setUid(id);
        return client.preparedQuery("UPDATE orders SET payload = $1 WHERE id = $2;")
                .execute(Tuple.of(JsonObject.mapFrom(body), id))
                .onItem().transform(pgRowSet -> Response.ok().build());
    }

    public Uni<Response> cancelOrder(final Long id, final Order body) {
        body.setState("CANCELLED");
        body.setUid(id);
        return client.preparedQuery("UPDATE orders SET payload = $1 WHERE id = $2;")
                .execute(Tuple.of(JsonObject.mapFrom(body), id))
                .onItem().transform(pgRowSet -> Response.ok().build());
    }

    private int getRandomNumberInRange() {
        final Random r = new Random();
        return r.nextInt((100000 - 1000) + 1) + 1000;
    }

    private Order getOrderObject(final io.vertx.mutiny.sqlclient.Row row) {
        return row.get(JsonObject.class, 0)
                .mapTo(Order.class);
    }
}
