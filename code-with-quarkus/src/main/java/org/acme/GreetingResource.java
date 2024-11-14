package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.openapi.quarkus.test_v1_swagger_yaml.api.DefaultApi;

@Path("/hello")
@ApplicationScoped
public class GreetingResource {

    @Inject
    @RestClient
    DefaultApi defaultApi;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        try {
            return defaultApi.test();
        } catch (WebApplicationException webApplicationException) {
            Response response = Response.fromResponse(webApplicationException.getResponse()).build();
            return response;
        }
    }
}
