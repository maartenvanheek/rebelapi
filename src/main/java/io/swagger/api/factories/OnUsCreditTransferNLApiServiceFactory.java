package io.swagger.api.factories;

import io.swagger.api.OnUsCreditTransferNLApiService;
import io.swagger.api.impl.OnUsCreditTransferNLApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class OnUsCreditTransferNLApiServiceFactory {
    private final static OnUsCreditTransferNLApiService service = new OnUsCreditTransferNLApiServiceImpl();

    public static OnUsCreditTransferNLApiService getOnUsCreditTransferNLApi() {
        return service;
    }
}
