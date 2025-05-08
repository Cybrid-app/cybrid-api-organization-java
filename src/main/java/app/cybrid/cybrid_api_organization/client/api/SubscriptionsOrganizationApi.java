package app.cybrid.cybrid_api_organization.client.api;

import app.cybrid.cybrid_api_organization.client.ApiClient;

import app.cybrid.cybrid_api_organization.client.model.ErrorResponseOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.PostSubscriptionOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.SubscriptionListOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.SubscriptionOrganizationModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-05-08T13:26:55.121081Z[Etc/UTC]")
public class SubscriptionsOrganizationApi {
    private ApiClient apiClient;

    public SubscriptionsOrganizationApi() {
        this(new ApiClient());
    }

    @Autowired
    public SubscriptionsOrganizationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Subscription
     * Creates a Subscription.  ## Subscription creation  Subscriptions can be created for webhook endpoints.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the subscription details in our private store | | completed | The Platform has created the subscription | | failed | The Platform was not able to successfully create the subscription |    Required scope: **subscriptions:execute
     * <p><b>201</b> - Subscription created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postSubscriptionOrganizationModel The postSubscriptionOrganizationModel parameter
     * @return SubscriptionOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec createSubscriptionRequestCreation(PostSubscriptionOrganizationModel postSubscriptionOrganizationModel) throws WebClientResponseException {
        Object postBody = postSubscriptionOrganizationModel;
        // verify the required parameter 'postSubscriptionOrganizationModel' is set
        if (postSubscriptionOrganizationModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'postSubscriptionOrganizationModel' when calling createSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
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

        ParameterizedTypeReference<SubscriptionOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscriptions/", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create Subscription
     * Creates a Subscription.  ## Subscription creation  Subscriptions can be created for webhook endpoints.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the subscription details in our private store | | completed | The Platform has created the subscription | | failed | The Platform was not able to successfully create the subscription |    Required scope: **subscriptions:execute
     * <p><b>201</b> - Subscription created
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param postSubscriptionOrganizationModel The postSubscriptionOrganizationModel parameter
     * @return SubscriptionOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionOrganizationModel> createSubscription(PostSubscriptionOrganizationModel postSubscriptionOrganizationModel) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionOrganizationModel>() {};
        return createSubscriptionRequestCreation(postSubscriptionOrganizationModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionOrganizationModel>> createSubscriptionWithHttpInfo(PostSubscriptionOrganizationModel postSubscriptionOrganizationModel) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionOrganizationModel>() {};
        return createSubscriptionRequestCreation(postSubscriptionOrganizationModel).toEntity(localVarReturnType);
    }
    /**
     * Delete Subscription
     * Deletes a subscription.  Required scope: **subscriptions:execute**
     * <p><b>204</b> - Subscription deleted
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription not found
     * @param subscriptionGuid Identifier for the subscription.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec deleteSubscriptionRequestCreation(String subscriptionGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'subscriptionGuid' is set
        if (subscriptionGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'subscriptionGuid' when calling deleteSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("subscription_guid", subscriptionGuid);

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

        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/api/subscriptions/{subscription_guid}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete Subscription
     * Deletes a subscription.  Required scope: **subscriptions:execute**
     * <p><b>204</b> - Subscription deleted
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription not found
     * @param subscriptionGuid Identifier for the subscription.
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<Void> deleteSubscription(String subscriptionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteSubscriptionRequestCreation(subscriptionGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<Void>> deleteSubscriptionWithHttpInfo(String subscriptionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<Void> localVarReturnType = new ParameterizedTypeReference<Void>() {};
        return deleteSubscriptionRequestCreation(subscriptionGuid).toEntity(localVarReturnType);
    }
    /**
     * Get Subscription 
     * Retrieves a subscription.  Required scope: **subscriptions:read**
     * <p><b>200</b> - Subscription found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription not found
     * @param subscriptionGuid Identifier for the subscription.
     * @return SubscriptionOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getSubscriptionRequestCreation(String subscriptionGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'subscriptionGuid' is set
        if (subscriptionGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'subscriptionGuid' when calling getSubscription", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("subscription_guid", subscriptionGuid);

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

        ParameterizedTypeReference<SubscriptionOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscriptions/{subscription_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get Subscription 
     * Retrieves a subscription.  Required scope: **subscriptions:read**
     * <p><b>200</b> - Subscription found
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * <p><b>404</b> - Subscription not found
     * @param subscriptionGuid Identifier for the subscription.
     * @return SubscriptionOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionOrganizationModel> getSubscription(String subscriptionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionOrganizationModel>() {};
        return getSubscriptionRequestCreation(subscriptionGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionOrganizationModel>> getSubscriptionWithHttpInfo(String subscriptionGuid) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionOrganizationModel>() {};
        return getSubscriptionRequestCreation(subscriptionGuid).toEntity(localVarReturnType);
    }
    /**
     * Get subscriptions list
     * Retrieves a listing of subscriptions.  Required scope: **subscriptions:read**
     * <p><b>200</b> - Get list of subscriptions
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated subscription_guids to list subscriptions for.
     * @param environment Environment to list subscriptions for.
     * @param state State to list subscriptions for.
     * @return SubscriptionListOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec listSubscriptionsRequestCreation(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String environment, String state) throws WebClientResponseException {
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
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "environment", environment));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "state", state));

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BearerAuth", "oauth2" };

        ParameterizedTypeReference<SubscriptionListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionListOrganizationModel>() {};
        return apiClient.invokeAPI("/api/subscriptions", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get subscriptions list
     * Retrieves a listing of subscriptions.  Required scope: **subscriptions:read**
     * <p><b>200</b> - Get list of subscriptions
     * <p><b>400</b> - Invalid requests
     * <p><b>401</b> - Unauthorized - Authentication failed, 
     * <p><b>403</b> - Invalid scope
     * @param page The page index to retrieve.
     * @param perPage The number of entities per page to return.
     * @param guid Comma separated subscription_guids to list subscriptions for.
     * @param environment Environment to list subscriptions for.
     * @param state State to list subscriptions for.
     * @return SubscriptionListOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<SubscriptionListOrganizationModel> listSubscriptions(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String environment, String state) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionListOrganizationModel>() {};
        return listSubscriptionsRequestCreation(page, perPage, guid, environment, state).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<SubscriptionListOrganizationModel>> listSubscriptionsWithHttpInfo(java.math.BigInteger page, java.math.BigInteger perPage, String guid, String environment, String state) throws WebClientResponseException {
        ParameterizedTypeReference<SubscriptionListOrganizationModel> localVarReturnType = new ParameterizedTypeReference<SubscriptionListOrganizationModel>() {};
        return listSubscriptionsRequestCreation(page, perPage, guid, environment, state).toEntity(localVarReturnType);
    }
}
