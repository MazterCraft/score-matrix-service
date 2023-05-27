package org.fico.score.framework.adapters.persistence.repo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "MATRIX_DECISION")
@Entity
public class MatrixDecision extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
        name = "matrixDecisionSeq",
        sequenceName = "SEQ_MATRIX_DECISION_$1",
        initialValue = 1,
        allocationSize = 1
    )
    @GeneratedValue
    private Long id;

    @Column(name = "MODEL_NAME", length = 20, nullable = false)
    private String modelName;

    @Column(name = "DECISION_INDEX", length = 20, nullable = false)
    private String index;
    
    @Column(name = "DECISION_NAME")
    private String name;

    @Column(name = "DECISION_DESCRIPTION")
    private String description;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "LAST_UPDATED_TIMESTAMP")
    private LocalDateTime updatedTime;
}
