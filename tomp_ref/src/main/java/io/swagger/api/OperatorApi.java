/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Error;
import io.swagger.model.StationInformation;
import io.swagger.model.SystemAlert;
import io.swagger.model.SystemCalendar;
import io.swagger.model.SystemHours;
import io.swagger.model.SystemInformation;
import io.swagger.model.SystemPricingPlan;
import io.swagger.model.SystemRegion;
import io.swagger.model.TypeOfAsset;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-04-24T08:44:01.688Z[GMT]")
@Api(value = "operator", description = "the operator API")
public interface OperatorApi {

    @ApiOperation(value = "informs customers about changes to the system outside of normal operations", nickname = "operatorAlertsGet", notes = "This feed is intended to inform customers about changes to the system that do not fall within the normal system operations. For example, system closures due to weather would be listed here, but a system that only operated for part of the year would have that schedule listed in the system-calendar.json feed. This file is an array of alert objects defined as below. Obsolete alerts should be removed so the client application can safely present to the end user everything present in the feed. The consumer could use the start/end information to determine if this is a past, ongoing or future alert and adjust the presentation accordingly. [from GBFS]", response = SystemAlert.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "returns currently active system alerts", response = SystemAlert.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/alerts",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SystemAlert>> operatorAlertsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "", nickname = "operatorAvailableAssetsGet", notes = "Returns a list of available assets.", response = TypeOfAsset.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Available assets or asset-types. In case assets are replied, the realtime location is also available.", response = TypeOfAsset.class, responseContainer = "List"),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class),
        @ApiResponse(code = 403, message = "The request will not be fulfilled, because the request is not legal in the current state. Authorization will not help.", response = Error.class),
        @ApiResponse(code = 404, message = "The requested resources does not exist or the requester is not authorized to see it or know it exists.") })
    @RequestMapping(value = "/operator/available-assets",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TypeOfAsset>> operatorAvailableAssetsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "describes the system", nickname = "operatorInformationGet", notes = "Describes the system including System operator, System location, year implemented, URLs, contact info, time zone. [from GBFS]", response = SystemInformation.class, authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = SystemInformation.class),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/information",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<SystemInformation> operatorInformationGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "describes the operating calendar for a system. An array of year objects defined as follows (if start/end year are omitted, then assume the start and end months do not change from year to year). [from GFBS]", nickname = "operatorOperatingCalendarGet", notes = "", response = SystemCalendar.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = SystemCalendar.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/operating-calendar",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SystemCalendar>> operatorOperatingCalendarGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "describes the system hours of operation", nickname = "operatorOperatingHoursGet", notes = "Describes the hours of operation of all available systems of the transport operator [from GBFS]", response = SystemHours.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = SystemHours.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/operating-hours",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SystemHours>> operatorOperatingHoursGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "gives pricing information", nickname = "operatorPricingPlansGet", notes = "Describes pricing of systems or assets [from GBFS]", response = SystemPricingPlan.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "returns standard pricing plans for an operator", response = SystemPricingPlan.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/pricing-plans",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SystemPricingPlan>> operatorPricingPlansGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "describes regions for a system that is broken up by geographic or political region. It is defined as a separate feed to allow for additional region metadata (such as shape definitions). [from GBFS]", nickname = "operatorRegionsGet", notes = "", response = SystemRegion.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = SystemRegion.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/regions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<SystemRegion>> operatorRegionsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);


    @ApiOperation(value = "describes all available stations", nickname = "operatorStationsGet", notes = "All stations contained in this list are considered public (ie, can be shown on a map for public use). If there are private stations (such as Capital Bikeshare's White House station) these should not be exposed here and their status should not be included [from GBFS]", response = StationInformation.class, responseContainer = "List", authorizations = {
        @Authorization(value = "ApiKeyAuth"),
@Authorization(value = "BasicAuth"),
@Authorization(value = "BearerAuth"),
@Authorization(value = "OAuth", scopes = { 
            }),
@Authorization(value = "OpenId")    }, tags={ "operator information","TO", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = StationInformation.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Bad request (invalid query or body parameters).", response = Error.class),
        @ApiResponse(code = 401, message = "Authorization error (invalid API key) or insufficient access rights given current authorization.", response = Error.class) })
    @RequestMapping(value = "/operator/stations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<StationInformation>> operatorStationsGet(@ApiParam(value = "ISO 639-1 two letter language code" ,required=true) @RequestHeader(value="Accept-Language", required=true) String acceptLanguage
,@ApiParam(value = "API description, can be TOMP or maybe other (specific/derived) API definitions" ,required=true) @RequestHeader(value="Api", required=true) String api
,@ApiParam(value = "Version of the API." ,required=true) @RequestHeader(value="Api-Version", required=true) String apiVersion
);

}
