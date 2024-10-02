package app.cybrid.cybrid_api_organization.client.api;

import app.cybrid.cybrid_api_organization.client.ApiClient;

import app.cybrid.cybrid_api_organization.client.model.ErrorResponseOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.SubscriptionEventListOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.SubscriptionEventOrganizationModel;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-10-02T20:45:47.231035Z[Etc/UTC]")
public class SubscriptionEventsOrganizationApi {
    private ApiClient apiClient;

    public SubscriptionEventsOrganizationApi() {
        this(new ApiClient());
    }

    @Autowired
    public SubscriptionEventsOrganizationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get Subscription Event 
     * Retrieves a Subscription Event.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Subscription Event found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription Event not found
     * @param subscriptionEventGuid Identifier for the Subscription Event.
     * @return SubscriptionEventOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubscriptionEventRequestCreation(String subscriptionEventGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'subscriptionEventGuid' is set
        if (subscriptionEventGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'subscriptionEventGuid' when calling getSubscriptionEvent", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("subscription_event_guid", subscriptionEventGuid);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<SubscriptionEventOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionEventOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscription_events/{subscription_event_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Subscription Event 
     * Retrieves a Subscription Event.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Subscription Event found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription Event not found
     * @param subscriptionEventGuid Identifier for the Subscription Event.
     * @return SubscriptionEventOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionEventOrganizationModel> getSubscriptionEvent(String subscriptionEventGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionEventOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionEventOrganizationModel>() {};
        return getSubscriptionEventRequestCreation(subscriptionEventGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionEventOrganizationModel>> getSubscriptionEventWithHttpInfo(String subscriptionEventGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionEventOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionEventOrganizationModel>() {};
        return getSubscriptionEventRequestCreation(subscriptionEventGuid).toEntity(localVarReturnType);
    }
    /**
     * Get subscription events list
     * Retrieves a listing of subscription events s.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Get list of subscription events
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated subscription_event_guids to list subscription events for.
     * @return SubscriptionEventListOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listSubscriptionEventsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid) throws WebClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "page", page));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "per_page", perPage));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "guid", guid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<SubscriptionEventListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionEventListOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscription_events", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get subscription events list
     * Retrieves a listing of subscription events s.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Get list of subscription events
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated subscription_event_guids to list subscription events for.
     * @return SubscriptionEventListOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionEventListOrganizationModel> listSubscriptionEvents(java.math.BigInteger page, java.math.BigInteger perPage, String guid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionEventListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionEventListOrganizationModel>() {};
        return listSubscriptionEventsRequestCreation(page, perPage, guid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionEventListOrganizationModel>> listSubscriptionEventsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionEventListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionEventListOrganizationModel>() {};
        return listSubscriptionEventsRequestCreation(page, perPage, guid).toEntity(localVarReturnType);
    }
}
