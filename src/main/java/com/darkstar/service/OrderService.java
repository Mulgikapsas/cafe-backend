package com.darkstar.service;

import com.darkstar.service.model.Order;
import io.smallrye.mutiny.Multi;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.mutiny.pgclient.PgPool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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


}
