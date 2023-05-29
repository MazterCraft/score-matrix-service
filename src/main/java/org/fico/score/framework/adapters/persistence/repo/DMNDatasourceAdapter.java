package org.fico.score.framework.adapters.persistence.repo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.fico.score.application.mappers.ScoreConfigMapper;
import org.fico.score.application.ports.out.InternalScoreOutputPort;
import org.fico.score.domain.cdl.context.ModelConfig;
import org.fico.score.framework.adapters.persistence.repo.entity.MatrixConfig;

@ApplicationScoped
public class DMNDatasourceAdapter implements InternalScoreOutputPort {

    @Inject ScoreConfigMapper mapper;

    @Override
    public ModelConfig loadConfig(String modelName) {
        return mapper.from(MatrixConfig.loadConfig(modelName));
    }
}
