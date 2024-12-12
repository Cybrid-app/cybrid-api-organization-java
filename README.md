# cybrid-api-organization-java

Cybrid Organization API

- API version: v0.123.78

- Build date: 2024-12-12T15:43:06.667205Z[Etc/UTC]

# Cybrid API documentation

Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.

In these documents, you'll find details on how our REST API operates and generally how our platform functions.

If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).

💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.

## Getting Started

This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.

If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:

1. [Introduction](https://docs.cybrid.xyz/docs/introduction)
2. [Platform Introduction](https://docs.cybrid.xyz/docs/how-is-cybrid-architected)
3. [Testing with Hosted Web Demo App](https://docs.cybrid.xyz/docs/testing-with-hosted-web-demo-app)

In [Getting Started in the Cybrid Sandbox](https://docs.cybrid.xyz/docs/how-do-i-get-started-with-the-sandbox), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.

## Working with the Cybrid Platform

There are three primary ways you can interact with the Cybrid platform:

1. Directly via our RESTful API (this documentation)
2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript))
3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))

Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.

*The complete set of APIs can be found on the following pages:*

| API                                                              | Description                                                 |
|------------------------------------------------------------------|-------------------------------------------------------------|
| [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                |
| [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) |
| [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |

For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.

## Authenticating with the API

The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.

An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.

Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.

A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).

<font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>

Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.

The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.

```
# Example request when using Bank credentials
curl -X POST https://id.production.cybrid.app/oauth/token -d '{
    \"grant_type\": \"client_credentials\",
    \"client_id\": \"<Your Client ID>\",
    \"client_secret\": \"<Your Secret>\",
    \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute\"
  }' -H \"Content-Type: application/json\"

# When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read'
```
<font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>

## Authentication Scopes

The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.

The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.

| Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       |
|-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------|
| Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                |
| Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     |
| Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         |
| Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    |
| Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       |
| External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  |
| External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         |
| Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  |
| User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     |
| Price                 | prices:read (Bank, Customer)                               |                                               |                                                  |
| Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    |
| Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    |
| Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) |
| Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               |
| Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |

## Available Endpoints

The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:

| API Service  | Model                | API Endpoint Path              | Description                                                                                       |
|--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------|
| Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             |
| Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 |
| Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     |
| Identity     | Organization         | /api/users                     | Create and list organization users                                                                |
| Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     |
| Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             |
| Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     |
| Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             |
| Bank         | Customer             | /api/customers                 | Create and list customers                                                                         |
| Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    |
| Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            |
| Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform |
| Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     |
| Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  |
| Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             |
| Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            |
| Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 |
| Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      |
| Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           |
| Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          |
| Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              |
| Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |

## Understanding Object Models & Endpoints

**Organizations**

An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.

An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.

**Banks**

A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.

An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.

**Customers**

`Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.

`Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.

`Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer.



*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*

## Requirements

Building the API client library requires:

1. Java 1.8+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>app.cybrid</groupId>
  <artifactId>cybrid-api-organization-java</artifactId>
  <version>v0.123.78</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'cybrid-api-organization-java' jar has been published to maven central.
    mavenLocal()       // Needed if the 'cybrid-api-organization-java' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "app.cybrid:cybrid-api-organization-java:v0.123.78"
  }
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

- `target/cybrid-api-organization-java-v0.123.78.jar`
- `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import app.cybrid.cybrid_api_organization.client.*;
import app.cybrid.cybrid_api_organization.client.auth.*;
import app.cybrid.cybrid_api_organization.client.model.*;
import app.cybrid.cybrid_api_organization.client.api.OrganizationsOrganizationApi;

public class OrganizationsOrganizationApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://organization.sandbox.cybrid.app");
        
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

## Documentation for API Endpoints

All URIs are relative to *https://organization.sandbox.cybrid.app*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*OrganizationsOrganizationApi* | [**getOrganization**](docs/OrganizationsOrganizationApi.md#getOrganization) | **GET** /api/organizations/{organization_guid} | Get organization
*OrganizationsOrganizationApi* | [**updateOrganization**](docs/OrganizationsOrganizationApi.md#updateOrganization) | **PATCH** /api/organizations/{organization_guid} | Patch organization
*SubscriptionDeliveriesOrganizationApi* | [**createSubscriptionDelivery**](docs/SubscriptionDeliveriesOrganizationApi.md#createSubscriptionDelivery) | **POST** /api/subscription_deliveries/ | Create SubscriptionDelivery
*SubscriptionDeliveriesOrganizationApi* | [**getSubscriptionDelivery**](docs/SubscriptionDeliveriesOrganizationApi.md#getSubscriptionDelivery) | **GET** /api/subscription_deliveries/{subscription_delivery_guid} | Get Subscription Delivery 
*SubscriptionDeliveriesOrganizationApi* | [**listSubscriptionDeliveries**](docs/SubscriptionDeliveriesOrganizationApi.md#listSubscriptionDeliveries) | **GET** /api/subscription_deliveries | Get subscription deliveries list
*SubscriptionEventsOrganizationApi* | [**getSubscriptionEvent**](docs/SubscriptionEventsOrganizationApi.md#getSubscriptionEvent) | **GET** /api/subscription_events/{subscription_event_guid} | Get Subscription Event 
*SubscriptionEventsOrganizationApi* | [**listSubscriptionEvents**](docs/SubscriptionEventsOrganizationApi.md#listSubscriptionEvents) | **GET** /api/subscription_events | Get subscription events list
*SubscriptionsOrganizationApi* | [**createSubscription**](docs/SubscriptionsOrganizationApi.md#createSubscription) | **POST** /api/subscriptions/ | Create Subscription
*SubscriptionsOrganizationApi* | [**deleteSubscription**](docs/SubscriptionsOrganizationApi.md#deleteSubscription) | **DELETE** /api/subscriptions/{subscription_guid} | Delete Subscription
*SubscriptionsOrganizationApi* | [**getSubscription**](docs/SubscriptionsOrganizationApi.md#getSubscription) | **GET** /api/subscriptions/{subscription_guid} | Get Subscription 
*SubscriptionsOrganizationApi* | [**listSubscriptions**](docs/SubscriptionsOrganizationApi.md#listSubscriptions) | **GET** /api/subscriptions | Get subscriptions list


## Documentation for Models

 - [ErrorResponseOrganizationModel](docs/ErrorResponseOrganizationModel.md)
 - [OrganizationOrganizationModel](docs/OrganizationOrganizationModel.md)
 - [PatchOrganizationOrganizationModel](docs/PatchOrganizationOrganizationModel.md)
 - [PostSubscriptionDeliveryOrganizationModel](docs/PostSubscriptionDeliveryOrganizationModel.md)
 - [PostSubscriptionOrganizationModel](docs/PostSubscriptionOrganizationModel.md)
 - [SubscriptionDeliveryListOrganizationModel](docs/SubscriptionDeliveryListOrganizationModel.md)
 - [SubscriptionDeliveryOrganizationModel](docs/SubscriptionDeliveryOrganizationModel.md)
 - [SubscriptionEnvironmentOrganizationModel](docs/SubscriptionEnvironmentOrganizationModel.md)
 - [SubscriptionEventListOrganizationModel](docs/SubscriptionEventListOrganizationModel.md)
 - [SubscriptionEventOrganizationModel](docs/SubscriptionEventOrganizationModel.md)
 - [SubscriptionListOrganizationModel](docs/SubscriptionListOrganizationModel.md)
 - [SubscriptionOrganizationModel](docs/SubscriptionOrganizationModel.md)
 - [SubscriptionStateOrganizationModel](docs/SubscriptionStateOrganizationModel.md)
 - [SubscriptionTypeOrganizationModel](docs/SubscriptionTypeOrganizationModel.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### BearerAuth


- **Type**: HTTP basic authentication

### oauth2


- **Type**: OAuth
- **Flow**: application
- **Authorization URL**: 
- **Scopes**: 
  - organizations:write: organizations write
  - organizations:read: organizations read
  - subscriptions:write: subscriptions write
  - subscriptions:read: subscriptions read
  - subscriptions:execute: subscriptions execute
  - subscription_events:read: subscription_events read
  - subscription_events:execute: subscription_events execute


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

support@cybrid.app

