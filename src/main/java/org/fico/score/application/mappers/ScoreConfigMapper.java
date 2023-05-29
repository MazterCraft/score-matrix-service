package org.fico.score.application.mappers;

import java.util.List;

import org.fico.score.application.usecases.data.ModelConfig;
import org.fico.score.domain.cdl.context.ContextField;
import org.fico.score.domain.cdl.context.DMNMeta;
import org.fico.score.framework.adapters.persistence.repo.entity.MatrixConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.enterprise.context.ApplicationScoped;

@Mapper(componentModel = "cdi")
public abstract class ScoreConfigMapper {

    @Mapping(source = "namespace", target = "namespace")
    @Mapping(source = "filename", target = "filename")
    @Mapping(source = "locationPath", target = "location")
    public abstract DMNMeta meta(MatrixConfig config) throws Exception;

    @Mapping(source = "fieldName", target = "name")
    @Mapping(source = "fieldType", target = "type")
    @Mapping(source = "defaultValue", target = "defaultValue")
    @Mapping(source = "regexValidation", target = "regexValidation")
    public abstract ContextField field(MatrixConfig config);

    public ModelConfig from(List<MatrixConfig> source) throws Exception {
        if (source.size() == 0) {
            throw new Exception("matrix config not defined");
        }

        var meta = meta(source.get(0));
        var fields = source
            .stream()
            .map(this::field)
            .toList()
        ;

        return new ModelConfig(meta, fields);
    }
}
