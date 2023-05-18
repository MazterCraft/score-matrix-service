package org.fico.score.application.mappers;

import javax.validation.Valid;

import org.fico.score.application.usecases.command.CDLCommand;
import org.fico.score.domain.cdl.context.CDLContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface AScoreMapper {

    @Mapping(source = "pcbScore", target = "pcbScore")
    @Mapping(source = "telcoScore", target = "telcoScore")
    CDLContext cdl(@Valid CDLCommand command);
}
