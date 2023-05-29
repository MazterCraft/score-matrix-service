package org.fico.score.application.ports.in;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.groups.UniJoin;
import org.fico.score.application.ports.out.DMNOutputPort;
import org.fico.score.application.usecases.DMNUsecase;
import org.fico.score.domain.cdl.context.ContextField;
import org.fico.score.domain.cdl.context.ContextHandler;
import org.fico.score.domain.cdl.eval.IEvaluation;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.unchecked.Unchecked;
import lombok.extern.slf4j.Slf4j;
import org.kie.dmn.api.core.DMNContext;

@ApplicationScoped
@Slf4j
public class DMNInputPort implements DMNUsecase {

    @Inject DMNOutputPort repo;
    @Inject IEvaluation evaluation;

    @Override
    public Uni<String> eval(String modelname, Map<String, Object> context) throws Exception {
        log.info("--- usecase DMNEvaludation start 3");
        Uni<String> original = Uni.createFrom().item("OK!");

        List<Uni<String>> errors = repo
                .ctxFields(modelname)
                .getFields()
                .stream().map(i -> i.in(context).onItem().transform(f -> "x"))
                .toList();
        Uni<String> failure = Uni.join().all(errors).andFailFast().onItem().transform(f -> f.get(0));

        log.info("--- usecase DMNEvaludation end");
        return Uni.join().all(original, failure).andFailFast().onItem().transform(f -> f.get(0));
    }
    
}
