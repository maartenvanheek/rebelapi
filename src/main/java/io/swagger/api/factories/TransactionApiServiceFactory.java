package io.swagger.api.factories;

import io.swagger.api.TransactionApiService;
import io.swagger.api.impl.TransactionApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class TransactionApiServiceFactory {
    private final static TransactionApiService service = new TransactionApiServiceImpl();

    public static TransactionApiService getTransactionApi() {
        return service;
    }
}
