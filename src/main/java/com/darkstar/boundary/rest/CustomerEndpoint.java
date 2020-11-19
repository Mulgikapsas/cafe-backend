package com.darkstar.boundary.rest;

import com.darkstar.service.UserService;
import com.darkstar.service.model.Customer;
import io.smallrye.mutiny.Uni;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Tag(name = "Customer service")
@Path("customers")
public class CustomerEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerEndpoint.class);

    @Inject
    UserService userService;

    @GET
    @Path("{id}")
    @Operation(summary = "Retrieve customer by id")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Customer.class)))
    @Produces(APPLICATION_JSON)
    public Uni<Response> getCustomer(@PathParam("id") long uid) {
        return userService.getCustomer(uid)
                .onItem().transform(entity -> entity == null ? Response.status(404) : Response.ok(entity))
                .onItem().transform(Response.ResponseBuilder::build);
    }

}
