package org.fico.score.application.usecases;

import javax.validation.Valid;

import org.fico.score.application.usecases.command.CDLCommand;

public interface CDLScoreUsecase {
    String cdlEval(@Valid CDLCommand context);
}
