# OrganizationsOrganizationApi

All URIs are relative to *https://organization.demo.cybrid.app*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getOrganization**](OrganizationsOrganizationApi.md#getOrganization) | **GET** /api/organizations/{organization_guid} | Get organization
[**updateOrganization**](OrganizationsOrganizationApi.md#updateOrganization) | **PATCH** /api/organizations/{organization_guid} | Patch organization



## getOrganization

> OrganizationOrganizationModel getOrganization(organizationGuid)

Get organization

Retrieve an organization.  Required scope: **organizations:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.OrganizationsOrganizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.demo.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        OrganizationsOrganizationApi apiInstance = new OrganizationsOrganizationApi(defaultClient);
        String organizationGuid = "organizationGuid_example"; // String | Identifier for the organization.
        try {
            OrganizationOrganizationModel result = apiInstance.getOrganization(organizationGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrganizationsOrganizationApi#getOrganization");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationGuid** | **String**| Identifier for the organization. |

### Return type

[**OrganizationOrganizationModel**](OrganizationOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | organization found |  -  |
| **404** | organization not found |  -  |
| **401** | Invalid subject |  -  |
| **403** | Invalid scope |  -  |


## updateOrganization

> OrganizationOrganizationModel updateOrganization(organizationGuid, patchOrganizationOrganizationModel)

Patch organization

Update an organization.  Required scope: **organizations:write**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.OrganizationsOrganizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.demo.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        OrganizationsOrganizationApi apiInstance = new OrganizationsOrganizationApi(defaultClient);
        String organizationGuid = "organizationGuid_example"; // String | Identifier for the organization.
        PatchOrganizationOrganizationModel patchOrganizationOrganizationModel = new PatchOrganizationOrganizationModel(); // PatchOrganizationOrganizationModel | 
        try {
            OrganizationOrganizationModel result = apiInstance.updateOrganization(organizationGuid, patchOrganizationOrganizationModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrganizationsOrganizationApi#updateOrganization");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **organizationGuid** | **String**| Identifier for the organization. |
 **patchOrganizationOrganizationModel** | [**PatchOrganizationOrganizationModel**](PatchOrganizationOrganizationModel.md)|  |

### Return type

[**OrganizationOrganizationModel**](OrganizationOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | organization found |  -  |
| **404** | organization not found |  -  |
| **400** | invalid organization name length |  -  |
| **401** | Invalid subject |  -  |
| **403** | Invalid scope |  -  |

