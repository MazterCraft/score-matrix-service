package org.fico.score.domain.cdl.context;

import lombok.Getter;

@Getter
public class DMNMeta {
    String namespace;
    String filename;
    String location;

    public DMNMeta(String namespace, String filename, String location) {
        if (!filename.trim().endsWith(".dmn")) {
            throw new RuntimeException("file type is invalid. Eg: Rule.dmn");
        }
        if (location.trim().endsWith("/")) {
            throw new RuntimeException("location must have no slash at the end");
        }
        var path = location + "/"  + filename;
        var dmnResource = getClass().getClassLoader().getResource(path);
        if (dmnResource == null) {
            throw new IllegalArgumentException("path " + "is not found");
        }

        this.filename = filename.split("\\.")[0];
        this.location = location;
        this.namespace = namespace;
    }
}
