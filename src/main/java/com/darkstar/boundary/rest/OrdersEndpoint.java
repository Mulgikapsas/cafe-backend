package com.darkstar.boundary.rest;

import com.darkstar.service.OrderService;
import com.darkstar.service.model.Order;
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

@Tag(name = "Orders service")
@Path("orders")
public class OrdersEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersEndpoint.class);

    @Inject
    OrderService orderService;

    @GET
    @Path("/orders")
    @Operation(summary = "Retrieve all orders")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    @Produces(APPLICATION_JSON)
    public Multi<Order> getItems(final String body) {
        return orderService.getOrders();
    }

}
