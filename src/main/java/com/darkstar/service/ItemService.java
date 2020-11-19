package com.darkstar.service;

import com.darkstar.service.model.Item;
import io.smallrye.mutiny.Multi;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.mutiny.pgclient.PgPool;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static io.vertx.core.logging.LoggerFactory.getLogger;

@ApplicationScoped
public class ItemService {
    private static final Logger LOGGER = getLogger(ItemService.class);

    @Inject
    PgPool client;

    public Multi<Item> getItems() {
        return client.query("SELECT payload FROM items;")
                .execute()
                .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem().transform(this::getItem);
    }

    private Item getItem(final io.vertx.mutiny.sqlclient.Row row) {
        return row.get(JsonObject.class, 0)
                .mapTo(Item.class);
    }


}
