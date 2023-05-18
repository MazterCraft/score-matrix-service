package org.fico.score.framework.adapters.rest;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.fico.score.application.ports.in.CDLScoreInputPort;
import org.fico.score.application.usecases.command.CDLCommand;

import io.smallrye.mutiny.Uni;

@Path("/decision2")
@Tag(name = "Decision Matrix Public API")
public class CDLRestApdapter {

    @Inject CDLScoreInputPort score;

    @POST
    @Path("cdl")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(operationId = "cdlEval", description = "CDL Decision Matrix Operation")
    public Uni<String> cdlEval(@Valid CDLCommand command) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        var decision = score.cdlEval(command);
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        System.out.println("decision: " + decision);
        return Uni.createFrom()
            .item(decision)
            .onItem()
            .transform(String::toUpperCase);
    }
}
