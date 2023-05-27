package org.fico.score.application.usecases.data;

import java.util.List;

import org.fico.score.domain.cdl.context.ContextField;
import org.fico.score.domain.cdl.context.DMNMeta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ModelConfig {
    private DMNMeta modelmeta;

    private List<ContextField> fields;
}
