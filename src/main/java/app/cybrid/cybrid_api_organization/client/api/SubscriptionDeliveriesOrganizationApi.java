package app.cybrid.cybrid_api_organization.client.api;

import app.cybrid.cybrid_api_organization.client.ApiClient;

import app.cybrid.cybrid_api_organization.client.model.ErrorResponseOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.PostSubscriptionDeliveryOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.SubscriptionDeliveryListOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.SubscriptionDeliveryOrganizationModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-06-02T21:53:10.585424Z[Etc/UTC]")
public class SubscriptionDeliveriesOrganizationApi {
    private ApiClient apiClient;

    public SubscriptionDeliveriesOrganizationApi() {
        this(new ApiClient());
    }

    @Autowired
    public SubscriptionDeliveriesOrganizationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create SubscriptionDelivery
     * Creates a SubscriptionDelivery.  ## Subscription Delivery  Create a SubscriptionDelivery to retry the delivery of a SubscriptionEvent to a Subscription.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the SubscriptionDelivery details in our private store | | completed | The Platform has successfully delivered the SubscriptionEvent to specified Subscription | | failing | The Platform is failing to deliver the SubscriptionDelivery,  a new attempt will be made (see &#x60;next_attempt_at&#x60;) | | failed | The Platform has failed to deliver the SubscriptionDelivery, no more attempts will be made |    Required scope: **subscription_events:execute
     * <p><b>201</b> - SubscriptionDelivery created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postSubscriptionDeliveryOrganizationModel The postSubscriptionDeliveryOrganizationModel parameter
     * @return SubscriptionDeliveryOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createSubscriptionDeliveryRequestCreation(PostSubscriptionDeliveryOrganizationModel postSubscriptionDeliveryOrganizationModel) throws WebClientResponseException {
        Object postBody = postSubscriptionDeliveryOrganizationModel;
        // verify the required parameter 'postSubscriptionDeliveryOrganizationModel' is set
        if (postSubscriptionDeliveryOrganizationModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postSubscriptionDeliveryOrganizationModel' when calling createSubscriptionDelivery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscription_deliveries/", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create SubscriptionDelivery
     * Creates a SubscriptionDelivery.  ## Subscription Delivery  Create a SubscriptionDelivery to retry the delivery of a SubscriptionEvent to a Subscription.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the SubscriptionDelivery details in our private store | | completed | The Platform has successfully delivered the SubscriptionEvent to specified Subscription | | failing | The Platform is failing to deliver the SubscriptionDelivery,  a new attempt will be made (see &#x60;next_attempt_at&#x60;) | | failed | The Platform has failed to deliver the SubscriptionDelivery, no more attempts will be made |    Required scope: **subscription_events:execute
     * <p><b>201</b> - SubscriptionDelivery created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postSubscriptionDeliveryOrganizationModel The postSubscriptionDeliveryOrganizationModel parameter
     * @return SubscriptionDeliveryOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionDeliveryOrganizationModel> createSubscriptionDelivery(PostSubscriptionDeliveryOrganizationModel postSubscriptionDeliveryOrganizationModel) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel>() {};
        return createSubscriptionDeliveryRequestCreation(postSubscriptionDeliveryOrganizationModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionDeliveryOrganizationModel>> createSubscriptionDeliveryWithHttpInfo(PostSubscriptionDeliveryOrganizationModel postSubscriptionDeliveryOrganizationModel) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel>() {};
        return createSubscriptionDeliveryRequestCreation(postSubscriptionDeliveryOrganizationModel).toEntity(localVarReturnType);
    }
    /**
     * Get Subscription Delivery 
     * Retrieves a subscription delivery.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Subscription delivery found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription delivery not found
     * @param subscriptionDeliveryGuid Identifier for the subscription delivery.
     * @return SubscriptionDeliveryOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubscriptionDeliveryRequestCreation(String subscriptionDeliveryGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'subscriptionDeliveryGuid' is set
        if (subscriptionDeliveryGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'subscriptionDeliveryGuid' when calling getSubscriptionDelivery", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("subscription_delivery_guid", subscriptionDeliveryGuid);

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

        ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscription_deliveries/{subscription_delivery_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Subscription Delivery 
     * Retrieves a subscription delivery.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Subscription delivery found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription delivery not found
     * @param subscriptionDeliveryGuid Identifier for the subscription delivery.
     * @return SubscriptionDeliveryOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionDeliveryOrganizationModel> getSubscriptionDelivery(String subscriptionDeliveryGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel>() {};
        return getSubscriptionDeliveryRequestCreation(subscriptionDeliveryGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionDeliveryOrganizationModel>> getSubscriptionDeliveryWithHttpInfo(String subscriptionDeliveryGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryOrganizationModel>() {};
        return getSubscriptionDeliveryRequestCreation(subscriptionDeliveryGuid).toEntity(localVarReturnType);
    }
    /**
     * Get subscription deliveries list
     * Retrieves a listing of subscription deliveries s.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Get list of subscription deliveries
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated subscription_delivery_guids to list subscription deliveries for.
     * @param subscriptionEventGuid Comma separated subscription_event_guids to list subscription deliveries for.
     * @param subscriptionGuid Comma separated subscription_guids to list subscription deliveries for.
     * @return SubscriptionDeliveryListOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listSubscriptionDeliveriesRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String subscriptionEventGuid, String subscriptionGuid) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "subscription_event_guid", subscriptionEventGuid));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "subscription_guid", subscriptionGuid));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<SubscriptionDeliveryListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryListOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscription_deliveries", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get subscription deliveries list
     * Retrieves a listing of subscription deliveries s.  Required scope: **subscription_events:read**
     * <p><b>200</b> - Get list of subscription deliveries
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated subscription_delivery_guids to list subscription deliveries for.
     * @param subscriptionEventGuid Comma separated subscription_event_guids to list subscription deliveries for.
     * @param subscriptionGuid Comma separated subscription_guids to list subscription deliveries for.
     * @return SubscriptionDeliveryListOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionDeliveryListOrganizationModel> listSubscriptionDeliveries(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String subscriptionEventGuid, String subscriptionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionDeliveryListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryListOrganizationModel>() {};
        return listSubscriptionDeliveriesRequestCreation(page, perPage, guid, subscriptionEventGuid, subscriptionGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionDeliveryListOrganizationModel>> listSubscriptionDeliveriesWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String subscriptionEventGuid, String subscriptionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionDeliveryListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionDeliveryListOrganizationModel>() {};
        return listSubscriptionDeliveriesRequestCreation(page, perPage, guid, subscriptionEventGuid, subscriptionGuid).toEntity(localVarReturnType);
    }
}
