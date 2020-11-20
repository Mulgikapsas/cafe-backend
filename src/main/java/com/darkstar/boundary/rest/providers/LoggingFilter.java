package com.darkstar.boundary.rest.providers;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

import static io.vertx.core.logging.LoggerFactory.getLogger;

@Provider
public class LoggingFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = getLogger(LoggingFilter.class);

    @Context
    UriInfo info;
    @Context
    HttpServerRequest request;
    @Context
    SecurityContext securityContext;

    @Override
    public void filter(final ContainerRequestContext context) {
        final String method = context.getMethod();
        final String path = info.getPath();
        final String address = request.remoteAddress().toString();
        final String restCall = method + " " + path;
        final MultivaluedMap<String, String> queryParams = info.getQueryParameters();
        LOGGER.info("[Unknown] hit [" + restCall + "] from IP: " + address + " Params: " + queryParams);
    }
}
