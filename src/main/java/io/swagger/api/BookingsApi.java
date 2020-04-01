/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.18).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Booking;
import io.swagger.model.BookingOperation;
import io.swagger.model.BookingOption;
import io.swagger.model.BookingState;
import io.swagger.model.Error;
import io.swagger.model.Notification;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-24T15:10:42.894Z[GMT]")
@Api(value = "bookings", description = "the bookings API")
public interface BookingsApi {

    @ApiOperation(value = "", nickname = "bookingsGet", notes = "Optional - Returns bookings that has been created earlier, selected on state.", response = Booking.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking [optional]","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The bookings matching the query", response = Booking.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/bookings/",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Booking>> bookingsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "state", required = true) BookingState state
);


    @ApiOperation(value = "", nickname = "bookingsIdEventsPost", notes = "This endpoint **must** be used to alter the state of a booking:<br>- The operation 'CANCEL' Cancels the booking (see <4> in the process flow - booking), <br>- the operation 'EXPIRE' informs that the booking-option is expired (seel <5> in the process flow - booking) and <br>- the 'COMMIT' actually makes this booking option a real confirmed booking. (see also (3.2) in process flow - booking). This event should also be used to commit in the 'postponed-commit' scenario.<br> - 'DENY' tells the MP that the leg is cancelled in the post-commit scenario. <p> `CANCEL` - Cancels a confirmed booking. Cancelling twice should still return 204. <br> `EXPIRE` - Typically for sending back a signal from TO to MP to tell the pending state is expired. Expiring twide should return 204. Expiring a booking in a non-pending state will result in 403. <BR> `COMMIT` - Turns the booking in a confirmed state, after all legs are in state pending. Committing twice will result in 204. If the booking is in state CANCELLED or EXPIRED, a commit will result a 403. <BR> `DENY` - Used for the 'postponed-commit' scenario. Whenever a TO cannot give garantees directly to fullfil a booking, it can return a 'COMMIT', but the state of the booking object should be 'POSTPONED-COMMIT'. In the conditions returned in the planning phase is stated until when this phase can be. After this time it will be come expired. Otherwise it can be commmitted when the leg is confirmed or denied (using this event).", response = Booking.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking","MP","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified booking", response = Booking.class),
        @ApiResponse(code = 204, message = "Request was successful, no content to return."),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 403, message = "The request will not be fulfilled, because the request is not legal in the current state. Authorization will not help.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/bookings/{id}/events",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Booking> bookingsIdEventsPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Leg identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody BookingOperation body
);


    @ApiOperation(value = "", nickname = "bookingsIdGet", notes = "Returns the booking. See (3.5.2) in the process flow - booking. In the 'meta'-field the digital tickes can be returned (see (3.3) in the process flow - booking)", response = Booking.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The booking was found", response = Booking.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
        @ApiResponse(code = 410, message = "The requested resource is no longer available. This is permanent.") })
    @RequestMapping(value = "/bookings/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Booking> bookingsIdGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "bookingsIdNotificationsGet", notes = "retrieves all notifications concerning events related to this booking.", response = Notification.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "general","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The bookings matching the query", response = Notification.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/bookings/{id}/notifications",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Notification>> bookingsIdNotificationsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "bookingsIdNotificationsPost", notes = "notification between MaaS provider and Transport operator in case of user no-show or if specific asset is not available or some other event occurs not covered by other API calls.", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "general","TO","MP", })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "notification received"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/bookings/{id}/notifications",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> bookingsIdNotificationsPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody Notification body
);


    @ApiOperation(value = "", nickname = "bookingsIdPut", notes = "Optional - This endpoint should be used to adjust the parameters of the booking. Changes not acceptable to the TO should return 400. If a booking is started and can no longer be adjusted the TO should return 403. The state of the booking should **never** be adjusted using this method. Use /bookings/{id}/events for that. See also (7.2) in the flow diagram - booking.", response = Booking.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The booking was modified", response = Booking.class),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 403, message = "The request will not be fulfilled, because the request is not legal in the current state. Authorization will not help.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
        @ApiResponse(code = 409, message = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.") })
    @RequestMapping(value = "/bookings/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Booking> bookingsIdPut(@ApiParam(value = "changed booking" ,required=true )  @Valid @RequestBody Booking body
,@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "bookingsIdSubscriptionDelete", notes = "Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking [optional]","TO","MP", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "unsubscribe succeeded"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
        @ApiResponse(code = 200, message = "Unexpected error", response = Error.class) })
    @RequestMapping(value = "/bookings/{id}/subscription",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> bookingsIdSubscriptionDelete(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
);


    @ApiOperation(value = "", nickname = "bookingsIdSubscriptionPost", notes = "Optional - subscribe to a specific booking (=leg & (type of) asset). This is an optional endpoint. This endpoint facilitates notifications in all the phases. (see (7.1) in the flow chart - execution)", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking [optional]","TO","MP", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeeded, subscription is made. Operations on this will be send to the webhook"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/bookings/{id}/subscription",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> bookingsIdSubscriptionPost(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
,@ApiParam(value = "Booking identifier",required=true) @PathVariable("id") String id
,@ApiParam(value = ""  )  @Valid @RequestBody Booking body
);


    @ApiOperation(value = "", nickname = "bookingsPost", notes = "Creates a new `Booking` for the TO in **Pending** state. The ID of the posted booking should be the ID provided in the previous step (planning-options). <p>The Booking may be modified in the response, e.g. location being adjusted for a more suitable pick-up location. In addition, the service may contain a **meta** attribute for arbitrary TO metadata that the TO needs later, and **token** attribute depicting how long the current state is valid. <p>The optional webhook can be used to post updates from TO to MP. If it isn't used, the subscription possibility in this API can be used or the events can be posted directly. <p> see (3.2) in the process flow - booking", response = Booking.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "booking","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "A new booking was succesfully created, status pending", response = Booking.class),
        @ApiResponse(code = 202, message = "Request was successfully accepted for processing but has not yet completed."),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists."),
        @ApiResponse(code = 409, message = "The request will not be fulfilled. The request itself is legal, but the content conflicts with the server and might be stale. The user might try again after looking up the current state of the resource.") })
    @RequestMapping(value = "/bookings/",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Booking> bookingsPost(@ApiParam(value = "One of available options, returned by /planning-options, with an ID." ,required=true )  @Valid @RequestBody BookingOption body
,@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);

}