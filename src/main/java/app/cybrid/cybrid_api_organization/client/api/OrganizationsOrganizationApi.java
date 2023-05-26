package app.cybrid.cybrid_api_organization.client.api;

import app.cybrid.cybrid_api_organization.client.ApiClient;

import app.cybrid.cybrid_api_organization.client.model.ErrorResponseOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.OrganizationOrganizationModel;
import app.cybrid.cybrid_api_organization.client.model.PatchOrganizationOrganizationModel;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-05-26T11:46:33.703391Z[Etc/UTC]")
public class OrganizationsOrganizationApi {
    private ApiClient apiClient;

    public OrganizationsOrganizationApi() {
        this(new ApiClient());
    }

    @Autowired
    public OrganizationsOrganizationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get organization
     * Retrieve an organization.  Required scope: **organizations:read**
     * <p><b>200</b> - organization found
     * <p><b>400</b> - invalid organization
     * <p><b>401</b> - Invalid requests - Malformed Authentication Header
     * <p><b>403</b> - Invalid scope
     * @param organizationGuid Identifier for the organization.
     * @return OrganizationOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec getOrganizationRequestCreation(String organizationGuid) throws WebClientResponseException {
        Object postBody = null;
        // verify the required parameter 'organizationGuid' is set
        if (organizationGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'organizationGuid' when calling getOrganization", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("organization_guid", organizationGuid);

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

        ParameterizedTypeReference<OrganizationOrganizationModel> localVarReturnType = new ParameterizedTypeReference<OrganizationOrganizationModel>() {};
        return apiClient.invokeAPI("/api/organizations/{organization_guid}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get organization
     * Retrieve an organization.  Required scope: **organizations:read**
     * <p><b>200</b> - organization found
     * <p><b>400</b> - invalid organization
     * <p><b>401</b> - Invalid requests - Malformed Authentication Header
     * <p><b>403</b> - Invalid scope
     * @param organizationGuid Identifier for the organization.
     * @return OrganizationOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OrganizationOrganizationModel> getOrganization(String organizationGuid) throws WebClientResponseException {
        ParameterizedTypeReference<OrganizationOrganizationModel> localVarReturnType = new ParameterizedTypeReference<OrganizationOrganizationModel>() {};
        return getOrganizationRequestCreation(organizationGuid).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<OrganizationOrganizationModel>> getOrganizationWithHttpInfo(String organizationGuid) throws WebClientResponseException {
        ParameterizedTypeReference<OrganizationOrganizationModel> localVarReturnType = new ParameterizedTypeReference<OrganizationOrganizationModel>() {};
        return getOrganizationRequestCreation(organizationGuid).toEntity(localVarReturnType);
    }
    /**
     * Patch organization
     * Update an organization.  Required scope: **organizations:write**
     * <p><b>200</b> - organization found
     * <p><b>400</b> - Invalid requests - invalid organization name length
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * @param organizationGuid Identifier for the organization.
     * @param patchOrganizationOrganizationModel The patchOrganizationOrganizationModel parameter
     * @return OrganizationOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec updateOrganizationRequestCreation(String organizationGuid, PatchOrganizationOrganizationModel patchOrganizationOrganizationModel) throws WebClientResponseException {
        Object postBody = patchOrganizationOrganizationModel;
        // verify the required parameter 'organizationGuid' is set
        if (organizationGuid == null) {
            throw new WebClientResponseException("Missing the required parameter 'organizationGuid' when calling updateOrganization", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'patchOrganizationOrganizationModel' is set
        if (patchOrganizationOrganizationModel == null) {
            throw new WebClientResponseException("Missing the required parameter 'patchOrganizationOrganizationModel' when calling updateOrganization", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<String, Object>();

        pathParams.put("organization_guid", organizationGuid);

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

        ParameterizedTypeReference<OrganizationOrganizationModel> localVarReturnType = new ParameterizedTypeReference<OrganizationOrganizationModel>() {};
        return apiClient.invokeAPI("/api/organizations/{organization_guid}", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Patch organization
     * Update an organization.  Required scope: **organizations:write**
     * <p><b>200</b> - organization found
     * <p><b>400</b> - Invalid requests - invalid organization name length
     * <p><b>401</b> - Unauthorized - Authentication failed, invalid subject
     * <p><b>403</b> - Invalid scope
     * @param organizationGuid Identifier for the organization.
     * @param patchOrganizationOrganizationModel The patchOrganizationOrganizationModel parameter
     * @return OrganizationOrganizationModel
     * @throws WebClientResponseException if an error occurs while attempting to invoke the API
     */
    public Mono<OrganizationOrganizationModel> updateOrganization(String organizationGuid, PatchOrganizationOrganizationModel patchOrganizationOrganizationModel) throws WebClientResponseException {
        ParameterizedTypeReference<OrganizationOrganizationModel> localVarReturnType = new ParameterizedTypeReference<OrganizationOrganizationModel>() {};
        return updateOrganizationRequestCreation(organizationGuid, patchOrganizationOrganizationModel).bodyToMono(localVarReturnType);
    }

    public Mono<ResponseEntity<OrganizationOrganizationModel>> updateOrganizationWithHttpInfo(String organizationGuid, PatchOrganizationOrganizationModel patchOrganizationOrganizationModel) throws WebClientResponseException {
        ParameterizedTypeReference<OrganizationOrganizationModel> localVarReturnType = new ParameterizedTypeReference<OrganizationOrganizationModel>() {};
        return updateOrganizationRequestCreation(organizationGuid, patchOrganizationOrganizationModel).toEntity(localVarReturnType);
    }
}
