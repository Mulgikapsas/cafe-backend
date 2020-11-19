package com.darkstar.boundary.rest;

import com.darkstar.service.ItemService;
import com.darkstar.service.model.Item;
import io.smallrye.mutiny.Multi;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "Items service")
@Path("")
public class ItemEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemEndpoint.class);

    @Inject
    ItemService itemService;

    @GET
    @Path("items")
    @Operation(summary = "Can use it to retrieve menu items for a Cafe")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Item.class)))
    @Produces(APPLICATION_JSON)
    public Multi<Item> getItems(final String body) {
        return itemService.getItems();
    }


}
