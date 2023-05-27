package org.fico.score.framework.adapters.persistence.repo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.fico.score.application.mappers.ScoreConfigMapper;
import org.fico.score.application.ports.out.DMNOutputPort;
import org.fico.score.application.usecases.data.ModelConfig;
import org.fico.score.framework.adapters.persistence.repo.entity.MatrixConfig;

@ApplicationScoped
public class DMNDatasourceAdapter implements DMNOutputPort {

    @Inject ScoreConfigMapper mapper;

    @Override
    public ModelConfig ctxFields(String modelName) throws Exception {
        return mapper.from(MatrixConfig.loadConfig(modelName));
    }
}
