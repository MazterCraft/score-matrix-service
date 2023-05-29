package org.fico.score.domain.cdl.context;

import java.util.List;
import java.util.Map;

import org.fico.score.domain.cdl.context.ContextField;
import org.fico.score.domain.cdl.context.DMNMeta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.kie.kogito.incubation.common.DataContext;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ModelConfig {
    private DMNMeta modelmeta;

    private List<ContextField> fields;

    public void validate(Map<String, Object> kv) {
        for (ContextField field : this.fields) {
            field.in(kv);
        }
    }
}
