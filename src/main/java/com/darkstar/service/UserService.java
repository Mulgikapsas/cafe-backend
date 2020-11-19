package com.darkstar.service;

import com.darkstar.service.model.Assignee;
import com.darkstar.service.model.Customer;
import io.smallrye.mutiny.Uni;
import io.vertx.core.logging.Logger;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static io.vertx.core.logging.LoggerFactory.getLogger;

@ApplicationScoped
public class UserService {
    private static final Logger LOGGER = getLogger(UserService.class);

    @Inject
    PgPool client;

    /**
     * Retrieve customer by {@param uid}
     *
     * @param uid - user id
     * @return {@link Customer}
     */
    public Uni<Customer> getCustomer(final long uid) {
        return client.preparedQuery("SELECT uid,name FROM customers WHERE uid = $1;")
                .execute(Tuple.of(uid))
                .onItem().transform(rows -> getCustomer(rows.iterator().next()))
                .onFailure().recoverWithItem(error -> {
                    LOGGER.error("Error when fetching data.", error);
                    return null;
                });
    }

    /**
     * Retrieve assignee by {@param uid}
     *
     * @param uid - user id
     * @return {@link Customer}
     */
    public Uni<Assignee> getAssignee(final long uid) {
        return client.preparedQuery("SELECT uid,name FROM assignees WHERE uid = $1;")
                .execute(Tuple.of(uid))
                .onItem().transform(rows -> getAssignee(rows.iterator().next()))
                .onFailure().recoverWithItem(error -> {
                    LOGGER.error("Error when fetching data.", error);
                    return null;
                });
    }

    private Customer getCustomer(final io.vertx.mutiny.sqlclient.Row row) {
        return (Customer) new Customer()
                .setUid(row.getInteger("uid"))
                .setName(row.getString("name"));
    }

    private Assignee getAssignee(final io.vertx.mutiny.sqlclient.Row row) {
        return (Assignee) new Assignee()
                .setUid(row.getInteger("uid"))
                .setName(row.getString("name"));
    }

}
