package org.fico.score.application.ports.out;

import org.fico.score.application.usecases.data.ModelConfig;

public interface DMNOutputPort {
    ModelConfig ctxFields(String modelName) throws Exception;
}
