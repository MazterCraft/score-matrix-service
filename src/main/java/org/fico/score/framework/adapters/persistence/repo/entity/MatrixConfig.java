package org.fico.score.framework.adapters.persistence.repo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;

@Getter
@Table(name = "V_MATRIX_DECISION_CONFIG")
@Immutable
@Entity
public class MatrixConfig extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAMESPACE")
    private String namespace;    

    @Column(name = "FILE_NAME")
    private String filename;

    @Column(name = "LOCATION_PATH")
    private String locationPath;

    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    @Column(name = "ACTIVE")
    private Integer active;

    @Column(name = "FIELD_NAME")
    private String fieldName;

    @Column(name = "FIELD_TYPE")
    private String fieldType;

    @Column(name = "REGEX_VALIDATION")
    private String regexValidation;

    public static List<MatrixConfig> loadConfig(String alias) {
        return list("alias", alias);
    }
}
