package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.AuthorizeBody;
import io.swagger.model.BookBody;
import io.swagger.model.CreateBody;
import io.swagger.model.OnUsCreditTransferNLInfo;
import io.swagger.model.RejectClosedAccountBody;
import io.swagger.model.RejectExecutionDateInThePastBody;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public abstract class OnUsCreditTransferNLApiService {
    public abstract Response onUsCreditTransferNLIdAuthorizePost(String id,AuthorizeBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response onUsCreditTransferNLIdBookPost(String id,BookBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response onUsCreditTransferNLIdCreatePost(String id,CreateBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response onUsCreditTransferNLIdGet(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response onUsCreditTransferNLIdRejectClosedAccountPost(String id,RejectClosedAccountBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response onUsCreditTransferNLIdRejectExecutionDateInThePastPost(String id,RejectExecutionDateInThePastBody body,SecurityContext securityContext) throws NotFoundException;
}
