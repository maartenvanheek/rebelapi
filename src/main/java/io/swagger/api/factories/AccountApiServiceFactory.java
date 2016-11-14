package io.swagger.api.factories;

import io.swagger.api.AccountApiService;
import io.swagger.api.impl.AccountApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class AccountApiServiceFactory {
    private final static AccountApiService service = new AccountApiServiceImpl();

    public static AccountApiService getAccountApi() {
        return service;
    }
}
