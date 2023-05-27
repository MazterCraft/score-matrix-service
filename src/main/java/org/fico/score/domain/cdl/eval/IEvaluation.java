package org.fico.score.domain.cdl.eval;

import org.fico.score.domain.cdl.context.DMNMeta;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.ExtendedDataContext;

@FunctionalInterface
public interface IEvaluation {
    ExtendedDataContext eval(DMNMeta meta, DataContext context);
}
