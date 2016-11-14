package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.IngNLAccountApiService;
import io.swagger.api.factories.IngNLAccountApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.CloseBody;
import io.swagger.model.DepositBody;
import io.swagger.model.IngNLAccountInfo;
import io.swagger.model.OpenBody;
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

@Path("/IngNLAccount")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the IngNLAccount API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class IngNLAccountApi  {
   private final IngNLAccountApiService delegate = IngNLAccountApiServiceFactory.getIngNLAccountApi();

    @POST
    @Path("/{id}/Close")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *close* transition", response = void.class, tags={ "IngNLAccount", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response ingNLAccountIdClosePost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) CloseBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.ingNLAccountIdClosePost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Deposit")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *deposit* transition", response = void.class, tags={ "IngNLAccount", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response ingNLAccountIdDepositPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) DepositBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.ingNLAccountIdDepositPost(id,body,securityContext);
    }
    @GET
    @Path("/{id}")
    @Consumes({ "text/plain; charset=utf-8", "application/json" })
    @Produces({ "text/plain; charset=utf-8" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve specification data", notes = "Retrieves the current specification instance its fields and state", response = IngNLAccountInfo.class, tags={ "IngNLAccount", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Data structure representing the *fields* and current FSM *state*", response = IngNLAccountInfo.class) })
    public Response ingNLAccountIdGet(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.ingNLAccountIdGet(id,securityContext);
    }
    @POST
    @Path("/{id}/Open")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *open* transition", response = void.class, tags={ "IngNLAccount", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response ingNLAccountIdOpenPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) OpenBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.ingNLAccountIdOpenPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Withdraw")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *withdraw* transition", response = void.class, tags={ "IngNLAccount", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response ingNLAccountIdWithdrawPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) WithdrawBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.ingNLAccountIdWithdrawPost(id,body,securityContext);
    }
}
