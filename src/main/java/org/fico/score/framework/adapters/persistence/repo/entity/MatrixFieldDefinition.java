package org.fico.score.framework.adapters.persistence.repo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

enum FieldType {
    TEXT,
    NUMBER,
    DECIMAL
}

@Table(name = "MATRIX_FIELD_DEFINITION")
@Entity
public class MatrixFieldDefinition {
    @Id
    @SequenceGenerator(
        name="matrixFieldGenerator",
        sequenceName = "SEQ_MATRIX_FIELDS_$1",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue
    private Long id;

    @Column(name = "FIELD_NAME", length = 255, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "FIELD_TYPE", length = 20, nullable = false)
    private FieldType type;

    @Column(name = "DEFAULT_VALUE", length = 1000)
    private String defaultValue;

    @Column(name = "REGEX_VALIDATION", length = 4000)
    private String validaion;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP")
    private LocalDateTime createdTime;

    @CreationTimestamp
    @Column(name = "LAST_UPDATED_TIMESTAMP")
    private LocalDateTime updatedTime;
}
