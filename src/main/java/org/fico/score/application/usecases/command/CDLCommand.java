package org.fico.score.application.usecases.command;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CDLCommand {
    @NotNull
    private Integer pcbScore;

    @NotNull
    private Integer telcoScore;
}
