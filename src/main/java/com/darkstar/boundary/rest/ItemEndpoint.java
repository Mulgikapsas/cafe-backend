package com.darkstar.boundary.rest;

import com.darkstar.service.model.Item;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "Items service")
@Path("")
public class ItemEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemEndpoint.class);

    @Inject
    MetricRegistry metricRegistry;

    @GET
    @Path("items")
    @Operation(summary = "Can use it to retrieve menu items for a Cafe")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Item.class)))
    @Produces(APPLICATION_JSON)
    public Response getItems(final String body) {
        final Item item = new Item()
                .setName("test")
                .setDescription("description")
                .setPrice(BigDecimal.TEN);
        return Response.ok(List.of(item)).build();
    }


}
