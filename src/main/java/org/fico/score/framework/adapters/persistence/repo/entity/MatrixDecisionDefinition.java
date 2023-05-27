package org.fico.score.framework.adapters.persistence.repo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Table(name = "MATRIX_DECISION_DEFINITION")
@Entity
public class MatrixDecisionDefinition {
    @Id
    @GeneratedValue
    @SequenceGenerator(
        name = "",
        sequenceName = "SEQ_MATRIX_DECISION_DEFINITION_$1",
        initialValue = 1,
        allocationSize = 1
    )
    private Long id;

    @Column(name = "NAMESPACE", length = 255)
    private String namespace;

    @Column(name = "FILE_NAME", length = 255)
    private String fileName;

    @Column(name = "LOCATION_PATH", length = 255)
    private String locationPath;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP")
    private LocalDateTime createdTime;

    @CreationTimestamp
    @Column(name = "LAST_UPDATED_TIMESTAMP")
    private LocalDateTime updatedTime;
}