# SubscriptionEventsOrganizationApi

All URIs are relative to *https://organization.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSubscriptionEvent**](SubscriptionEventsOrganizationApi.md#getSubscriptionEvent) | **GET** /api/subscription_events/{subscription_event_guid} | Get Subscription Event  |
| [**listSubscriptionEvents**](SubscriptionEventsOrganizationApi.md#listSubscriptionEvents) | **GET** /api/subscription_events | Get subscription events list |



## getSubscriptionEvent

> SubscriptionEventOrganizationModel getSubscriptionEvent(subscriptionEventGuid)

Get Subscription Event 

Retrieves a Subscription Event.  Required scope: **subscription_events:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionEventsOrganizationApi;

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

        SubscriptionEventsOrganizationApi apiInstance = new SubscriptionEventsOrganizationApi(defaultClient);
        String subscriptionEventGuid = "subscriptionEventGuid_example"; // String | Identifier for the Subscription Event.
        try {
            SubscriptionEventOrganizationModel result = apiInstance.getSubscriptionEvent(subscriptionEventGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionEventsOrganizationApi#getSubscriptionEvent");
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
| **subscriptionEventGuid** | **String**| Identifier for the Subscription Event. | |

### Return type

[**SubscriptionEventOrganizationModel**](SubscriptionEventOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Subscription Event found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | Subscription Event not found |  -  |


## listSubscriptionEvents

> SubscriptionEventListOrganizationModel listSubscriptionEvents(page, perPage, guid)

Get subscription events list

Retrieves a listing of subscription events s.  Required scope: **subscription_events:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionEventsOrganizationApi;

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

        SubscriptionEventsOrganizationApi apiInstance = new SubscriptionEventsOrganizationApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated subscription_event_guids to list subscription events for.
        try {
            SubscriptionEventListOrganizationModel result = apiInstance.listSubscriptionEvents(page, perPage, guid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionEventsOrganizationApi#listSubscriptionEvents");
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
| **guid** | **String**| Comma separated subscription_event_guids to list subscription events for. | [optional] |

### Return type

[**SubscriptionEventListOrganizationModel**](SubscriptionEventListOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get list of subscription events |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |

