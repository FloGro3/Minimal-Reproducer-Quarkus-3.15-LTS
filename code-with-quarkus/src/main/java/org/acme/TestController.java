package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/test")
public class TestController {

    @GET
    @Operation(operationId = "test", summary = "test")
    @APIResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = RuntimeException.class)))
    public Response errorResponse() {
        return Response.serverError().entity(new RuntimeException("Test")).build();
    }
}
