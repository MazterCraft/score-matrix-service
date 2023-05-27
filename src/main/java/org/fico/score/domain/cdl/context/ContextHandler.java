package org.fico.score.domain.cdl.context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fico.score.application.usecases.command.FieldType;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;

public class ContextHandler {
    private List<ContextField> fields;

    public ContextHandler(List<ContextField> fields) throws Exception {
        this.fields = fields;
        if (this.fields.size() == 0) {
            throw new Exception("found no field definition");
        }
    }

    public DataContext validate(Map<String, Object> kv) throws Exception {
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
                System.out.println("----------------- iv: " + iv);
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

        return MapDataContext.of(kv);
    }
}
