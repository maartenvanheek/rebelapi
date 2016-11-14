package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.TransactionApiService;
import io.swagger.api.factories.TransactionApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.BookBody;
import io.swagger.model.FailBody;
import io.swagger.model.TransactionInfo;
import io.swagger.model.StartBody;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/Transaction")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the Transaction API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-07T08:05:00.767Z")
public class TransactionApi  {
   private final TransactionApiService delegate = TransactionApiServiceFactory.getTransactionApi();

    @POST
    @Path("/{id}/Book")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *book* transition", response = void.class, tags={ "Transaction", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response transactionIdBookPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) BookBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.transactionIdBookPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Fail")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *fail* transition", response = void.class, tags={ "Transaction", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response transactionIdFailPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) FailBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.transactionIdFailPost(id,body,securityContext);
    }
    @GET
    @Path("/{id}")
    @Consumes({ "text/plain; charset=utf-8", "application/json" })
    @Produces({ "text/plain; charset=utf-8" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve specification data", notes = "Retrieves the current specification instance its fields and state", response = TransactionInfo.class, tags={ "Transaction", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Data structure representing the *fields* and current FSM *state*", response = TransactionInfo.class) })
    public Response transactionIdGet(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.transactionIdGet(id,securityContext);
    }
    @POST
    @Path("/{id}/Start")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *start* transition", response = void.class, tags={ "Transaction", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response transactionIdStartPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) StartBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.transactionIdStartPost(id,body,securityContext);
    }
}
