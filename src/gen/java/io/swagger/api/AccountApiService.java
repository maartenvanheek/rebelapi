package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.BlockBody;
import io.swagger.model.CloseBody;
import io.swagger.model.DepositBody;
import io.swagger.model.AccountInfo;
import io.swagger.model.InterestBody;
import io.swagger.model.OpenAccountBody;
import io.swagger.model.UnblockBody;
import io.swagger.model.WithdrawBody;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public abstract class AccountApiService {
    public abstract Response accountIdBlockPost(String id,BlockBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdClosePost(String id,CloseBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdDepositPost(String id,DepositBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdGet(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdInterestPost(String id,InterestBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdOpenAccountPost(String id,OpenAccountBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdUnblockPost(String id,UnblockBody body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response accountIdWithdrawPost(String id,WithdrawBody body,SecurityContext securityContext) throws NotFoundException;
}
