# SubscriptionsOrganizationApi

All URIs are relative to *https://organization.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSubscription**](SubscriptionsOrganizationApi.md#createSubscription) | **POST** /api/subscriptions/ | Create Subscription |
| [**deleteSubscription**](SubscriptionsOrganizationApi.md#deleteSubscription) | **DELETE** /api/subscriptions/{subscription_guid} | Delete Subscription |
| [**getSubscription**](SubscriptionsOrganizationApi.md#getSubscription) | **GET** /api/subscriptions/{subscription_guid} | Get Subscription  |
| [**listSubscriptions**](SubscriptionsOrganizationApi.md#listSubscriptions) | **GET** /api/subscriptions | Get subscriptions list |



## createSubscription

> SubscriptionOrganizationModel createSubscription(postSubscriptionOrganizationModel)

Create Subscription

Creates a Subscription.  ## Subscription creation  Subscriptions can be created for webhook endpoints.  ## State  | State | Description | |-------|-------------| | storing | The Platform is storing the subscription details in our private store | | completed | The Platform has created the subscription | | failed | The Platform was not able to successfully create the subscription | | deleting | The Platform is deleting the subscription | | deleted | The Platform has deleted the subscription|    Required scope: **subscriptions:execute

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionsOrganizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        SubscriptionsOrganizationApi apiInstance = new SubscriptionsOrganizationApi(defaultClient);
        PostSubscriptionOrganizationModel postSubscriptionOrganizationModel = new PostSubscriptionOrganizationModel(); // PostSubscriptionOrganizationModel | 
        try {
            SubscriptionOrganizationModel result = apiInstance.createSubscription(postSubscriptionOrganizationModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionsOrganizationApi#createSubscription");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **postSubscriptionOrganizationModel** | [**PostSubscriptionOrganizationModel**](PostSubscriptionOrganizationModel.md)|  | |

### Return type

[**SubscriptionOrganizationModel**](SubscriptionOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Subscription created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## deleteSubscription

> deleteSubscription(subscriptionGuid)

Delete Subscription

Deletes a subscription.  Required scope: **subscriptions:execute**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionsOrganizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        SubscriptionsOrganizationApi apiInstance = new SubscriptionsOrganizationApi(defaultClient);
        String subscriptionGuid = "subscriptionGuid_example"; // String | Identifier for the subscription.
        try {
            apiInstance.deleteSubscription(subscriptionGuid);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionsOrganizationApi#deleteSubscription");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionGuid** | **String**| Identifier for the subscription. | |

### Return type

null (empty response body)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Subscription deleted |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | Subscription not found |  -  |


## getSubscription

> SubscriptionOrganizationModel getSubscription(subscriptionGuid, includeSigningKey)

Get Subscription 

Retrieves a subscription.  Required scope: **subscriptions:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionsOrganizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        SubscriptionsOrganizationApi apiInstance = new SubscriptionsOrganizationApi(defaultClient);
        String subscriptionGuid = "subscriptionGuid_example"; // String | Identifier for the subscription.
        Boolean includeSigningKey = true; // Boolean | Flag to include signing key in the response.
        try {
            SubscriptionOrganizationModel result = apiInstance.getSubscription(subscriptionGuid, includeSigningKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionsOrganizationApi#getSubscription");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **subscriptionGuid** | **String**| Identifier for the subscription. | |
| **includeSigningKey** | **Boolean**| Flag to include signing key in the response. | [optional] |

### Return type

[**SubscriptionOrganizationModel**](SubscriptionOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Subscription found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | Subscription not found |  -  |


## listSubscriptions

> SubscriptionListOrganizationModel listSubscriptions(page, perPage, guid, includeSigningKey)

Get subscriptions list

Retrieves a listing of subscriptions.  Required scope: **subscriptions:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionsOrganizationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.sandbox.cybrid.app");
        
        // Configure HTTP bearer authorization: BearerAuth
        HttpBearerAuth BearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("BearerAuth");
        BearerAuth.setBearerToken("BEARER TOKEN");

        // Configure OAuth2 access token for authorization: oauth2
        OAuth oauth2 = (OAuth) defaultClient.getAuthentication("oauth2");
        oauth2.setAccessToken("YOUR ACCESS TOKEN");

        SubscriptionsOrganizationApi apiInstance = new SubscriptionsOrganizationApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated subscription_guids to list subscriptions for.
        Boolean includeSigningKey = true; // Boolean | Flag to include signing key in the response.
        try {
            SubscriptionListOrganizationModel result = apiInstance.listSubscriptions(page, perPage, guid, includeSigningKey);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionsOrganizationApi#listSubscriptions");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **java.math.BigInteger**| The page index to retrieve. | [optional] |
| **perPage** | **java.math.BigInteger**| The number of entities per page to return. | [optional] |
| **guid** | **String**| Comma separated subscription_guids to list subscriptions for. | [optional] |
| **includeSigningKey** | **Boolean**| Flag to include signing key in the response. | [optional] |

### Return type

[**SubscriptionListOrganizationModel**](SubscriptionListOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get list of subscriptions |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |

