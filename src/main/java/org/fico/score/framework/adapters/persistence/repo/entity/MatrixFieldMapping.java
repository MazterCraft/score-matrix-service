package org.fico.score.framework.adapters.persistence.repo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Table(name = "MATRIX_FIELD_MAPPING")
@Entity
public class MatrixFieldMapping extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @SequenceGenerator(
        name = "matrixFieldMappingGenerator",
        sequenceName = "SEQ_MATRIX_FIELD_MAPPING_$1",
        initialValue = 1,
        allocationSize = 1
    )
    private Long id;

    @OneToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "MODEL")
    private MatrixDecisionDefinition model; 

    @OneToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "FIELD")
    private MatrixFieldDefinition field;

    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    @Column(name = "ACTIVE")
    private Integer active;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED_TIMESTAMP")
    private LocalDateTime updatedDate;
}