package org.fico.score.domain.cdl.context;

import org.fico.score.application.usecases.command.FieldType;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ContextField {
    String name;
    FieldType type;
    String defaultValue;
    String regexValidation;
}
