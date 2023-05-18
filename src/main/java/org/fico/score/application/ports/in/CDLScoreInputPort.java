package org.fico.score.application.ports.in;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import org.fico.score.application.mappers.AScoreMapper;
import org.fico.score.application.usecases.CDLScoreUsecase;
import org.fico.score.application.usecases.command.CDLCommand;
import org.fico.score.domain.cdl.eval.CDLEvaluation;

@ApplicationScoped
public class CDLScoreInputPort implements CDLScoreUsecase {

    @Inject AScoreMapper mapper;
    @Inject CDLEvaluation evaluation;

    @Override
    public String cdlEval(@Valid CDLCommand command) {
        var context = mapper.cdl(command);
        return evaluation.eval(context);
    }
}
