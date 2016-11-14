package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.OnUsCreditTransferNLApiService;
import io.swagger.api.factories.OnUsCreditTransferNLApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.AuthorizeBody;
import io.swagger.model.BookBody;
import io.swagger.model.CreateBody;
import io.swagger.model.OnUsCreditTransferNLInfo;
import io.swagger.model.RejectClosedAccountBody;
import io.swagger.model.RejectExecutionDateInThePastBody;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/OnUsCreditTransferNL")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the OnUsCreditTransferNL API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-14T12:30:06.878Z")
public class OnUsCreditTransferNLApi  {
   private final OnUsCreditTransferNLApiService delegate = OnUsCreditTransferNLApiServiceFactory.getOnUsCreditTransferNLApi();

    @POST
    @Path("/{id}/Authorize")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *authorize* transition", response = void.class, tags={ "OnUsCreditTransferNL", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response onUsCreditTransferNLIdAuthorizePost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) AuthorizeBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.onUsCreditTransferNLIdAuthorizePost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Book")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *book* transition", response = void.class, tags={ "OnUsCreditTransferNL", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response onUsCreditTransferNLIdBookPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) BookBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.onUsCreditTransferNLIdBookPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/Create")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *create* transition", response = void.class, tags={ "OnUsCreditTransferNL", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response onUsCreditTransferNLIdCreatePost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) CreateBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.onUsCreditTransferNLIdCreatePost(id,body,securityContext);
    }
    @GET
    @Path("/{id}")
    @Consumes({ "text/plain; charset=utf-8", "application/json" })
    @Produces({ "text/plain; charset=utf-8" })
    @io.swagger.annotations.ApiOperation(value = "Retrieve specification data", notes = "Retrieves the current specification instance its fields and state", response = OnUsCreditTransferNLInfo.class, tags={ "OnUsCreditTransferNL", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Data structure representing the *fields* and current FSM *state*", response = OnUsCreditTransferNLInfo.class) })
    public Response onUsCreditTransferNLIdGet(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.onUsCreditTransferNLIdGet(id,securityContext);
    }
    @POST
    @Path("/{id}/RejectClosedAccount")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *rejectClosedAccount* transition", response = void.class, tags={ "OnUsCreditTransferNL", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response onUsCreditTransferNLIdRejectClosedAccountPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) RejectClosedAccountBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.onUsCreditTransferNLIdRejectClosedAccountPost(id,body,securityContext);
    }
    @POST
    @Path("/{id}/RejectExecutionDateInThePast")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Apply *rejectExecutionDateInThePast* transition", response = void.class, tags={ "OnUsCreditTransferNL", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Transition has been successful", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 403, message = "Bad request", response = void.class) })
    public Response onUsCreditTransferNLIdRejectExecutionDateInThePastPost(@ApiParam(value = "id of the state machine",required=true) @PathParam("id") String id
,@ApiParam(value = "transition data object that encapsulates the parameters that are necessary for the transition to take place" ,required=true) RejectExecutionDateInThePastBody body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.onUsCreditTransferNLIdRejectExecutionDateInThePastPost(id,body,securityContext);
    }
}
