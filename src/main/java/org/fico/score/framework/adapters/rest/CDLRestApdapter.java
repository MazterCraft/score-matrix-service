package org.fico.score.framework.adapters.rest;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST; import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.fico.score.application.ports.in.DMNInputPort;
import org.fico.score.framework.adapters.persistence.repo.entity.MatrixConfig;
import org.fico.score.framework.adapters.persistence.repo.entity.MatrixDecision;
import org.jboss.resteasy.reactive.RestPath;

import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;


@Path("/decision")
@Tag(name = "Decision Matrix Public API")
@ApplicationScoped
@Slf4j
public class CDLRestApdapter {

    @Inject DMNInputPort dmn;

    @Transactional
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> test() {
        log.info("--- used for test only");

        var decision = new MatrixDecision();
        decision.setIndex("T.1");
        decision.setModelName("CDLDecisionMatrix");
        decision.setName("CDL.R.1");
        decision.persist();

        log.info("--- used for test only");
        return Uni
            .createFrom()
            .item("OK!");
    }

    @Transactional
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test/{modelName}")
    public Uni<String> loadModelConfig(String modelName) {
        log.info("--- load MatrixConfig");
        var mx = MatrixConfig.loadConfig(modelName);
        log.info("found 2 MatrixConfig: " + mx.size());
        return Uni
            .createFrom()
            .item("OK!")
        ;
    }

    @Transactional
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eval/{modelName}")
    public Uni<String> eval(@RestPath String modelName, Map<String, Object> context) throws Exception {
        log.info("--- dmn Evaluation start");
        var decision = dmn.eval(modelName, context);
        log.info("--- decision " + decision);
        log.info("--- dmn Evaluation end");
        return decision;
//        return Uni
//                .createFrom()
//                .item("Ok!")
//                ;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/matrix")
    public Uni<Response> matrix(Map<String, Object> context) {
        log.info("--- run matrix to provide decision");
        return Uni
            .createFrom()
            .item(context)
            .onItem()
            .transform(item -> Response.ok(item))
            .onItem()
            .transform(ResponseBuilder::build)
        ;
    }
}
