package org.fico.score.application.ports.in;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.fico.score.application.ports.out.InternalScoreOutputPort;
import org.fico.score.application.usecases.InternalScoreUsecases;
import org.fico.score.domain.cdl.eval.IEvaluation;

import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;

@ApplicationScoped
@Slf4j
public class DMNInputPort implements InternalScoreUsecases {

    @Inject
    InternalScoreOutputPort repo;
    @Inject IEvaluation evaluation;

    @Override
    public Uni<String> eval(String modelname, Map<String, Object> context) {
        log.info("--- begin: use-case InternalScore Evaluation");

        var modelConfig = repo.loadConfig(modelname);
        modelConfig.validate(context);

        String decision = evaluation
                .eval(modelConfig.getModelmeta(), MapDataContext.of(context))
                .as(MapDataContext.class)
                .get("ScoreDecision", String.class)
                ;

        log.info("--- end: use-case InternalScore Evaluation");
        return Uni
                .createFrom()
                .item(decision);
    }
}
