package com.darkstar.boundary.rest;


import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title = "Cafe Backend",
                version = "1.0.0")
)
@ApplicationPath("/api")
public class RESTApplication extends Application {
}
