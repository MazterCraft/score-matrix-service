package org.fico.score.application.ports.out;

import org.fico.score.application.usecases.data.ModelConfig;

@FunctionalInterface
public interface DMNOutputPort {
    ModelConfig ctxFields(String modelName) throws Exception;
}
