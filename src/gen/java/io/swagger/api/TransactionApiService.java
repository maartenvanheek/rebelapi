package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.BookBody;
import io.swagger.model.FailBody;
import io.swagger.model.TransactionInfo;
import io.swagger.model.StartBody;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public abstract class TransactionApiService {
    public abstract Response transactionIdBookPost(String id,BookBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response transactionIdFailPost(String id,FailBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response transactionIdGet(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response transactionIdStartPost(String id,StartBody body,SecurityContext securityContext) throws NotFoundException;
}
