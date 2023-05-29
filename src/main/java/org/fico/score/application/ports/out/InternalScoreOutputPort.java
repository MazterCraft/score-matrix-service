package org.fico.score.application.ports.out;

import org.fico.score.domain.cdl.context.ModelConfig;

@FunctionalInterface
public interface InternalScoreOutputPort {
    ModelConfig loadConfig(String modelName);
}
