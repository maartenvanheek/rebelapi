package io.swagger.api.factories;

import io.swagger.api.IngNLAccountApiService;
import io.swagger.api.impl.IngNLAccountApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class IngNLAccountApiServiceFactory {
    private final static IngNLAccountApiService service = new IngNLAccountApiServiceImpl();

    public static IngNLAccountApiService getIngNLAccountApi() {
        return service;
    }
}
