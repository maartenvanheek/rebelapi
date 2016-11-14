package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.CloseBody;
import io.swagger.model.DepositBody;
import io.swagger.model.IngNLAccountInfo;
import io.swagger.model.OpenBody;
import io.swagger.model.WithdrawBody;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public abstract class IngNLAccountApiService {
    public abstract Response ingNLAccountIdClosePost(String id,CloseBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response ingNLAccountIdDepositPost(String id,DepositBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response ingNLAccountIdGet(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response ingNLAccountIdOpenPost(String id,OpenBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response ingNLAccountIdWithdrawPost(String id,WithdrawBody body,SecurityContext securityContext) throws NotFoundException;
}
