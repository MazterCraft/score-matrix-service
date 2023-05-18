package org.fico.score.domain.cdl.context;

import javax.validation.constraints.NotNull;

import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.DefaultCastable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CDLContext implements DataContext, DefaultCastable {
    @NotNull
    private Integer pcbScore;

    @NotNull
    private Integer telcoScore;
}
