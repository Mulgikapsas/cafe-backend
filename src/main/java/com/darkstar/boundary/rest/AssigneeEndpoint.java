package com.darkstar.boundary.rest;

import com.darkstar.service.UserService;
import com.darkstar.service.model.Assignee;
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

@Tag(name = "Assignee service")
@Path("assignees")
public class AssigneeEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssigneeEndpoint.class);

    @Inject
    UserService userService;

    @GET
    @Path("{id}")
    @Operation(summary = "Retrieve assignee by id")
    @APIResponse(responseCode = "200", content =
    @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Assignee.class)))
    @Produces(APPLICATION_JSON)
    public Uni<Response> getAssignee(@PathParam("id") final long uid) {
        return userService.getAssignee(uid)
                .onItem().transform(entity -> entity == null ? Response.status(404) : Response.ok(entity))
                .onItem().transform(Response.ResponseBuilder::build);
    }


}
