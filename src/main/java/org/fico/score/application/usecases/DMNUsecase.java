package org.fico.score.application.usecases;

import java.util.Map;

public interface DMNUsecase {
    String eval(String modelname, Map<String, Object> context) throws Exception;
}
