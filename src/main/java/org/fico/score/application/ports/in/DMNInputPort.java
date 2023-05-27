package org.fico.score.application.ports.in;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.fico.score.application.ports.out.DMNOutputPort;
import org.fico.score.application.usecases.DMNUsecase;
import org.fico.score.domain.cdl.context.ContextHandler;
import org.fico.score.domain.cdl.eval.IEvaluation;
import org.kie.kogito.incubation.common.MapDataContext;

import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class DMNInputPort implements DMNUsecase {

    @Inject DMNOutputPort repo;
    @Inject IEvaluation evaluation;

    @Override
    public String eval(String modelname, Map<String, Object> context) throws Exception {
        log.info("--- usecase DMNEvaludation start");

        var modelConfig = repo.ctxFields(modelname);
        var validatedCtx = new ContextHandler(modelConfig.getFields()).validate(context);
        var decision = evaluation
            .eval(modelConfig.getModelmeta(), validatedCtx)
            .as(MapDataContext.class)
            .get("DECISION", String.class);
        
        log.info("==============> decision: " + decision);

        log.info("--- usecase DMNEvaludation end");
        return "Ok!";
    }
    
}
