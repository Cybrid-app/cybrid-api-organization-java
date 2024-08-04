# SubscriptionDeliveriesOrganizationApi

All URIs are relative to *https://organization.sandbox.cybrid.app*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createSubscriptionDelivery**](SubscriptionDeliveriesOrganizationApi.md#createSubscriptionDelivery) | **POST** /api/subscription_deliveries/ | Create SubscriptionDelivery |
| [**getSubscriptionDelivery**](SubscriptionDeliveriesOrganizationApi.md#getSubscriptionDelivery) | **GET** /api/subscription_deliveries/{subscription_delivery_guid} | Get Subscription Delivery  |
| [**listSubscriptionDeliveries**](SubscriptionDeliveriesOrganizationApi.md#listSubscriptionDeliveries) | **GET** /api/subscription_deliveries | Get subscription deliveries list |



## createSubscriptionDelivery

> SubscriptionDeliveryOrganizationModel createSubscriptionDelivery(postSubscriptionDeliveryOrganizationModel)

Create SubscriptionDelivery

Creates a SubscriptionDelivery.  post  Required scope: **subscription_events:execute

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionDeliveriesOrganizationApi;

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

        SubscriptionDeliveriesOrganizationApi apiInstance = new SubscriptionDeliveriesOrganizationApi(defaultClient);
        PostSubscriptionDeliveryOrganizationModel postSubscriptionDeliveryOrganizationModel = new PostSubscriptionDeliveryOrganizationModel(); // PostSubscriptionDeliveryOrganizationModel | 
        try {
            SubscriptionDeliveryOrganizationModel result = apiInstance.createSubscriptionDelivery(postSubscriptionDeliveryOrganizationModel);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionDeliveriesOrganizationApi#createSubscriptionDelivery");
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
| **postSubscriptionDeliveryOrganizationModel** | [**PostSubscriptionDeliveryOrganizationModel**](PostSubscriptionDeliveryOrganizationModel.md)|  | |

### Return type

[**SubscriptionDeliveryOrganizationModel**](SubscriptionDeliveryOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | SubscriptionDelivery created |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |


## getSubscriptionDelivery

> SubscriptionDeliveryOrganizationModel getSubscriptionDelivery(subscriptionDeliveryGuid)

Get Subscription Delivery 

Retrieves a subscription delivery.  Required scope: **subscription_events:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionDeliveriesOrganizationApi;

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

        SubscriptionDeliveriesOrganizationApi apiInstance = new SubscriptionDeliveriesOrganizationApi(defaultClient);
        String subscriptionDeliveryGuid = "subscriptionDeliveryGuid_example"; // String | Identifier for the subscription delivery.
        try {
            SubscriptionDeliveryOrganizationModel result = apiInstance.getSubscriptionDelivery(subscriptionDeliveryGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionDeliveriesOrganizationApi#getSubscriptionDelivery");
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
| **subscriptionDeliveryGuid** | **String**| Identifier for the subscription delivery. | |

### Return type

[**SubscriptionDeliveryOrganizationModel**](SubscriptionDeliveryOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Subscription delivery found |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |
| **404** | Subscription delivery not found |  -  |


## listSubscriptionDeliveries

> SubscriptionDeliveryListOrganizationModel listSubscriptionDeliveries(page, perPage, guid, subscriptionEventGuid, subscriptionGuid)

Get subscription deliveries list

Retrieves a listing of subscription deliveries s.  Required scope: **subscription_events:read**

### Example

```java
// Import classes:
import app.cybrid.cybrid_api_organization.client.ApiClient;
import app.cybrid.cybrid_api_organization.client.ApiException;
import app.cybrid.cybrid_api_organization.client.Configuration;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.models.*;
import app.cybrid.cybrid_api_organization.client.api.SubscriptionDeliveriesOrganizationApi;

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

        SubscriptionDeliveriesOrganizationApi apiInstance = new SubscriptionDeliveriesOrganizationApi(defaultClient);
        java.math.BigInteger page = new java.math.BigInteger(); // java.math.BigInteger | The page index to retrieve.
        java.math.BigInteger perPage = new java.math.BigInteger(); // java.math.BigInteger | The number of entities per page to return.
        String guid = "guid_example"; // String | Comma separated subscription_delivery_guids to list subscription deliveries for.
        String subscriptionEventGuid = "subscriptionEventGuid_example"; // String | Comma separated subscription_event_guids to list subscription deliveries for.
        String subscriptionGuid = "subscriptionGuid_example"; // String | Comma separated subscription_guids to list subscription deliveries for.
        try {
            SubscriptionDeliveryListOrganizationModel result = apiInstance.listSubscriptionDeliveries(page, perPage, guid, subscriptionEventGuid, subscriptionGuid);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SubscriptionDeliveriesOrganizationApi#listSubscriptionDeliveries");
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
| **guid** | **String**| Comma separated subscription_delivery_guids to list subscription deliveries for. | [optional] |
| **subscriptionEventGuid** | **String**| Comma separated subscription_event_guids to list subscription deliveries for. | [optional] |
| **subscriptionGuid** | **String**| Comma separated subscription_guids to list subscription deliveries for. | [optional] |

### Return type

[**SubscriptionDeliveryListOrganizationModel**](SubscriptionDeliveryListOrganizationModel.md)

### Authorization

[BearerAuth](../README.md#BearerAuth), [oauth2](../README.md#oauth2)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Get list of subscription deliveries |  -  |
| **400** | Invalid requests |  -  |
| **401** | Unauthorized - Authentication failed,  |  -  |
| **403** | Invalid scope |  -  |

