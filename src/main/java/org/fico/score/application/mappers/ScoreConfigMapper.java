package org.fico.score.application.mappers;

import java.util.List;

import org.fico.score.domain.cdl.context.ModelConfig;
import org.fico.score.domain.cdl.context.ContextField;
import org.fico.score.domain.cdl.context.DMNMeta;
import org.fico.score.framework.adapters.persistence.repo.entity.MatrixConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public abstract class ScoreConfigMapper {

    @Mapping(source = "namespace", target = "namespace")
    @Mapping(source = "filename", target = "filename")
    @Mapping(source = "locationPath", target = "location")
    public abstract DMNMeta meta(MatrixConfig config);

    @Mapping(source = "fieldName", target = "name")
    @Mapping(source = "fieldType", target = "type")
    @Mapping(source = "defaultValue", target = "defaultValue")
    @Mapping(source = "regexValidation", target = "regexValidation")
    public abstract ContextField field(MatrixConfig config);

    public ModelConfig from(List<MatrixConfig> source) {
        if (source.size() == 0) {
            throw new RuntimeException("matrix config not defined");
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
