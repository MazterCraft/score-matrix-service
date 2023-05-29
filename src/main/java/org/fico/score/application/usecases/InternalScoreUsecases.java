package org.fico.score.application.usecases;

import java.util.Map;

import io.smallrye.mutiny.Uni;

public interface InternalScoreUsecases {
    Uni<String> eval(String modelname, Map<String, Object> context) throws Exception;
}
