package com.darkstar.boundary.rest;

import com.darkstar.service.OrderService;
import com.darkstar.service.model.Order;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "Orders service")
@Path("orders")
public class OrdersEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersEndpoint.class);

    @Inject
    OrderService orderService;

    @GET
    @Path("/")
    @Operation(summary = "Retrieve all orders")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    @Produces(APPLICATION_JSON)
    public Multi<Order> getItems(final String body) {
        return orderService.getOrders();
    }

    @GET
    @Path("{id}")
    @Operation(summary = "Get order by id")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    @Produces(APPLICATION_JSON)
    public Uni<Order> getById(@PathParam("id") final Long id) {
        return orderService.getById(id);
    }

    @POST
    @Path("create")
    @Operation(summary = "Publish order")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Uni<Response> createOrder(final Order body) {
        return orderService.publishOrder(body);
    }

    @PUT
    @Path("{id}/update")
    @Operation(summary = "Update order")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Uni<Response> updateOrder(@PathParam("id") final Long id, final Order body) {
        return orderService.updateOrder(id, body);
    }

    @PUT
    @Path("{id}/cancel")
    @Operation(summary = "Cancel order")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Order.class)))
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Uni<Response> cancelOrder(@PathParam("id") final Long id, final Order body) {
        return orderService.cancelOrder(id, body);
    }

}
