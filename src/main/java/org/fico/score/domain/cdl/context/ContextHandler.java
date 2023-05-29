package org.fico.score.domain.cdl.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fico.score.application.usecases.command.FieldType;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ContextHandler {
    private List<ContextField> fields;

    public ContextHandler(List<ContextField> fields) throws Exception {
        this.fields = fields;
        if (this.fields.size() == 0) {
            throw new Exception("found no field definition");
        }
    }

    public Multi<String> /* DataContext */ validate(Map<String, Object> kv) throws Exception {
        log.info("--- validate context");
        Map<String, Object> newCtx = new HashMap<>();
        for (int i = 0; i < this.fields.size(); i++) {
            var field = this.fields.get(i);
            System.out.println("field: " + field.name);
            if (!kv.containsKey(field.name)) {
                throw new Exception("required field, %s " + field.name);
            }

            Object iv = kv.get(field.name); // incoming value
            Object value = null;
            if (field.type == FieldType.TEXT) {
                value = String.valueOf(iv);
            }

            if (field.type == FieldType.DECIMAL) {
                if (iv instanceof Double) {
                    value = Double.valueOf(String.format("%.3f", iv));
                }
                if (iv instanceof Integer) {
                    value = Double.valueOf(String.format("%d", iv));
                }
            }

            if (field.type == FieldType.NUMBER) {
                value = Integer.valueOf(String.format("%d", iv));
            }

            if (value == null) {
                throw new Exception("field " + field.name + " doesn't have defined type");
            }

            newCtx.put(field.name, value);
            // TODO: validate incoming value under regex validation
        }

        // return MapDataContext.of(kv);
        return Multi.createFrom().item("Ok!");
    }

    public Uni<String> validate2(int x) {
        log.info("--- something I don't really understand when using reactive smallrye");
        if (x > 1) {
            var error  = new Exception("x must greater than one");
            return Uni.createFrom().failure(error);
        }
        return Uni
            .createFrom()
            .item("OK!")
        ;
    }
}
