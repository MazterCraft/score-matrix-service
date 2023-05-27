package org.fico.score.domain.cdl.eval;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.fico.score.domain.cdl.context.DMNMeta;
import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.ExtendedDataContext;
import org.kie.kogito.incubation.decisions.DecisionIds;
import org.kie.kogito.incubation.decisions.services.DecisionService;

@ApplicationScoped
public class DMNEvaluation implements IEvaluation {

    @Inject DecisionService svc;
    @Inject AppRoot root;


    public ExtendedDataContext eval(DMNMeta meta, DataContext context) {
        var id = root
            .get(DecisionIds.class)
            .get(meta.getNamespace(), meta.getFilename())
        ;

        return this.svc
            .evaluate(id, context)
        ;
    }
}
