package org.fico.score.domain.cdl.context;

import io.smallrye.mutiny.Uni;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.fico.score.application.usecases.command.FieldType;

import lombok.AllArgsConstructor;

import java.util.Map;


@AllArgsConstructor
@Slf4j
@Getter
public class ContextField {
    String name;
    FieldType type;
    String defaultValue;
    String regexValidation;

    public void in(Map<String, Object> kv) {
        if (!kv.containsKey(this.name)) {
            throw new RuntimeException(this.name + " is required");
        }
    }
}
