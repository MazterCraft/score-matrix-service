package org.fico.score.domain.cdl.context;

import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.fico.score.application.usecases.command.FieldType;

import lombok.AllArgsConstructor;

import java.util.Map;


@AllArgsConstructor
@Slf4j
public class ContextField {
    String name;
    FieldType type;
    String defaultValue;
    String regexValidation;

    public Uni<Void> in(Map<String, Object> kv) {
        if (!kv.containsKey(this.name)) {
            return Uni.createFrom().failure(new RuntimeException("provided data doesn't have " + this.name));
        }
        return Uni
                .createFrom()
                .voidItem();
    }
}
