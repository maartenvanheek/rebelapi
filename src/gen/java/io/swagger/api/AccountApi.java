package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.AccountApiService;
import io.swagger.api.factories.AccountApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/Account")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the Account API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class AccountApi  {
   private final AccountApiService delegate = AccountApiServiceFactory.getAccountApi();

    @POST
    @Path("/{id}/Block")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *block* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdBlockPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) BlockBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdBlockPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Close")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *close* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdClosePost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) CloseBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdClosePost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Deposit")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *deposit* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdDepositPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) DepositBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdDepositPost(id,body,securityContext);
    }
    @GET
    @Path("/{id}")
    @Consumes({ "text/plain; charset=utf-8", "application/json" })
    @Produces({ "text/plain; charset=utf-8" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve specification data", notes = "Retrieves the current specification instance its fields and state", response = AccountInfo.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Data structure representing the *fields* and current FSM *state*", response = AccountInfo.class) })
    public Response accountIdGet(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdGet(id,securityContext);
    }
    @POST
    @Path("/{id}/Interest")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *interest* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdInterestPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) InterestBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdInterestPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/OpenAccount")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *openAccount* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdOpenAccountPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) OpenAccountBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdOpenAccountPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Unblock")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *unblock* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdUnblockPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) UnblockBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdUnblockPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Withdraw")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *withdraw* transition", response = void.class, tags={ "Account", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response accountIdWithdrawPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) WithdrawBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.accountIdWithdrawPost(id,body,securityContext);
    }
}
