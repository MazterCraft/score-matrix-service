package org.fico.score;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import io.smallrye.mutiny.Uni;

@Path("/decision")
@Tag(name = "Decision Service", description = "Decision Service API")
public class Greeting {

    @POST
    @Path("/cdl")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(operationId = "cdlDecision", description = "CDL Decision Matrix")
    public Uni<String> cdlDecision() {
        return Uni.createFrom()
            .item("String")
            .onItem()
            .transform(String::toUpperCase);
    }
}
