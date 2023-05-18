package org.fico.score.domain.cdl.eval;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import org.fico.score.domain.cdl.context.CDLContext;
import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.MapDataContext;
import org.kie.kogito.incubation.decisions.DecisionIds;
import org.kie.kogito.incubation.decisions.services.DecisionService;

@ApplicationScoped
public class CDLEvaluation {

    @Inject AppRoot root;
    @Inject DecisionService svc;
    
    public String eval(@Valid CDLContext context) {
        System.out.println("cccccccccccccccccccccccccccccccc");
        var id = root
            .get(DecisionIds.class)
            .get("fico.ascore.cdl", "CDL");
        System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        return svc
            .evaluate(id, context)
            .as(MapDataContext.class)
            .get("ScoreDecision", String.class);
    }
}
