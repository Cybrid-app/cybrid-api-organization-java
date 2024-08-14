/*
 * Cybrid Organization API
 * # Cybrid API documentation  Welcome to Cybrid, an all-in-one crypto platform that enables you to easily **build** and **launch** white-label crypto products or services.  In these documents, you'll find details on how our REST API operates and generally how our platform functions.  If you're looking for our UI SDK Widgets for Web or Mobile (iOS/Android), generated API clients, or demo applications, head over to our [Github repo](https://github.com/Cybrid-app).  💡 We recommend bookmarking the [Cybrid LinkTree](https://linktr.ee/cybridtechnologies) which contains many helpful links to platform resources.  ## Getting Started  This is Cybrid's public interactive API documentation, which allows you to fully test our APIs. If you'd like to use a different tool to exercise our APIs, you can download the [Open API 3.0 yaml](https://bank.production.cybrid.app/api/schema/v1/swagger.yaml) for import.  If you're new to our APIs and the Cybrid Platform, follow the below guides to get set up and familiar with the platform:  1. [Understanding the Platform](https://kb.cybrid.xyz/understanding-the-platform) 2. [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide) 3. [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading) 4. [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) (or, alternatively, [Testing with Hosted Web Demo App](https://kb.cybrid.xyz/testing-with-hosted-web-demo-app))  In [Getting Started in the Cybrid Sandbox](https://kb.cybrid.xyz/getting-started-guide), we walk you through how to use the [Cybrid Sandbox](https://id.sandbox.cybrid.app/) to create a test bank and generate API keys. In [Getting Ready for Trading](https://kb.cybrid.xyz/getting-ready-for-trading), we walk through creating customers, customer identities, accounts, as well as executing quotes and trades.  If you've already run through the first two guides, you can follow the [Running the Web Demo App](https://kb.cybrid.xyz/locally-running-the-web-demo-app) guide to test our web SDK with your sandbox `bank` and `customer`.  ## Working with the Cybrid Platform  There are three primary ways you can interact with the Cybrid platform:  1. Directly via our RESTful API (this documentation) 2. Using our API clients available in a variety of languages ([Angular](https://github.com/Cybrid-app/cybrid-api-bank-angular), [Java](https://github.com/Cybrid-app/cybrid-api-bank-java), [Kotlin](https://github.com/Cybrid-app/cybrid-api-bank-kotlin), [Python](https://github.com/Cybrid-app/cybrid-api-bank-python), [Ruby](https://github.com/Cybrid-app/cybrid-api-bank-ruby), [Swift](https://github.com/Cybrid-app/cybrid-api-bank-swift) or [Typescript](https://github.com/Cybrid-app/cybrid-api-bank-typescript)) 3. Integrating a platform specific SDK ([Web](https://github.com/Cybrid-app/cybrid-sdk-web), [Android](https://github.com/Cybrid-app/cybrid-sdk-android), [iOS](https://github.com/Cybrid-app/cybrid-sdk-ios))  Our complete set of APIs allows you to manage resources across three distinct areas: your `Organization`, your `Banks` and your `Identities`. For most of your testing and interaction you'll be using the `Bank` API, which is where the majority of APIs reside.  *The complete set of APIs can be found on the following pages:*  | API                                                              | Description                                                 | |------------------------------------------------------------------|-------------------------------------------------------------| | [Organization API](https://organization.production.cybrid.app/api/schema/swagger-ui)   | APIs to manage organizations                                | | [Bank API](https://bank.production.cybrid.app/api/schema/swagger-ui)                   | APIs to manage banks (and all downstream customer activity) | | [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui)                       | APIs to manage organization and bank identities             |  For questions please contact [Support](mailto:support@cybrid.xyz) at any time for assistance, or contact the [Product Team](mailto:product@cybrid.xyz) for product suggestions.  ## Authenticating with the API  The Cybrid Platform uses OAuth 2.0 Bearer Tokens to authenticate requests to the platform. Credentials to create `Organization` and `Bank` tokens can be generated via the [Cybrid Sandbox](https://id.production.cybrid.app). Access tokens can be generated for a `Customer` as well via the [Cybrid IdP](https://id.production.cybrid.app) as well.  An `Organization` access token applies broadly to the whole Organization and all of its `Banks`, whereas, a `Bank` access token is specific to an individual Bank. `Customer` tokens, similarly, are scoped to a specific customer in a bank.  Both `Organization` and `Bank` tokens can be created using the OAuth Client Credential Grant flow. Each Organization and Bank has its own unique `Client ID` and `Secret` that allows for machine-to-machine authentication.  A `Bank` can then generate `Customer` access tokens via API using our [Identities API](https://id.production.cybrid.app/api/schema/swagger-ui).  <font color=\"orange\">**⚠️ Never share your Client ID or Secret publicly or in your source code repository.**</font>  Your `Client ID` and `Secret` can be exchanged for a time-limited `Bearer Token` by interacting with the Cybrid Identity Provider or through interacting with the **Authorize** button in this document.  The following curl command can be used to quickly generate a `Bearer Token` for use in testing the API or demo applications.  ``` # Example request when using Bank credentials curl -X POST https://id.production.cybrid.app/oauth/token -d '{     \"grant_type\": \"client_credentials\",     \"client_id\": \"<Your Client ID>\",     \"client_secret\": \"<Your Secret>\",     \"scope\": \"banks:read banks:write bank_applications:execute accounts:read accounts:execute counterparties:read counterparties:write counterparties:execute customers:read customers:write customers:execute prices:read quotes:execute quotes:read trades:execute trades:read transfers:execute transfers:read external_bank_accounts:read external_bank_accounts:write external_bank_accounts:execute external_wallets:read external_wallets:execute workflows:read workflows:execute deposit_addresses:read deposit_addresses:execute deposit_bank_accounts:read deposit_bank_accounts:execute invoices:read invoices:write invoices:execute identity_verifications:read identity_verifications:write identity_verifications:execute\"   }' -H \"Content-Type: application/json\"  # When using Organization credentials set `scope` to 'organizations:read organizations:write organization_applications:execute banks:read banks:write banks:execute bank_applications:execute users:read users:execute counterparties:read customers:read accounts:read prices:read quotes:execute quotes:read trades:execute trades:read transfers:read transfers:execute external_bank_accounts:read external_wallets:read workflows:read deposit_addresses:read deposit_bank_accounts:read invoices:read subscriptions:read subscriptions:write subscriptions:execute subscription_events:read subscription_events:execute identity_verifications:read' ``` <font color=\"orange\">**⚠️ Note: The above curl will create a bearer token with full scope access. Delete scopes if you'd like to restrict access.**</font>  ## Authentication Scopes  The Cybrid platform supports the use of scopes to control the level of access a token is limited to. Scopes do not grant access to resources; instead, they provide limits, in support of the least privilege principal.  The following scopes are available on the platform and can be requested when generating either an Organization, Bank or Customer token. Generally speaking, the _Read_ scope is required to read and list resources, the _Write_ scope is required to update a resource and the _Execute_ scope is required to create a resource.  | Resource              | Read scope (Token Type)                                    | Write scope (Token Type)                      | Execute scope (Token Type)                       | |-----------------------|------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------| | Account               | accounts:read (Organization, Bank, Customer)               |                                               | accounts:execute (Bank, Customer)                | | Bank                  | banks:read (Organization, Bank)                            | banks:write (Organization, Bank)              | banks:execute (Organization)                     | | Customer              | customers:read (Organization, Bank, Customer)              | customers:write (Bank, Customer)              | customers:execute (Bank)                         | | Counterparty          | counterparties:read (Organization, Bank, Customer)         | counterparties:write (Bank, Customer)         | counterparties:execute (Bank)                    | | Deposit Address       | deposit_addresses:read (Organization, Bank, Customer)      | deposit_addresses:write (Bank, Customer)      | deposit_addresses:execute (Bank, Customer)       | | External Bank Account | external_bank_accounts:read (Organization, Bank, Customer) | external_bank_accounts:write (Bank, Customer) | external_bank_accounts:execute (Bank, Customer)  | | External Wallet       | external_wallet:read (Organization, Bank, Customer)        |                                               | external_wallet:execute (Bank, Customer)         | | Organization          | organizations:read (Organization)                          | organizations:write (Organization)            |                                                  | | User                  | users:read (Organization)                                  |                                               | users:execute (Organization)                     | | Price                 | prices:read (Bank, Customer)                               |                                               |                                                  | | Quote                 | quotes:read (Organization, Bank, Customer)                 |                                               | quotes:execute (Organization, Bank, Customer)    | | Trade                 | trades:read (Organization, Bank, Customer)                 |                                               | trades:execute (Organization, Bank, Customer)    | | Transfer              | transfers:read (Organization, Bank, Customer)              |                                               | transfers:execute (Organization, Bank, Customer) | | Workflow              | workflows:read (Organization, Bank, Customer)              |                                               | workflows:execute (Bank, Customer)               | | Invoice               | invoices:read (Organization, Bank, Customer)               | invoices:write (Bank, Customer)               | invoices:execute (Bank, Customer)                |  ## Available Endpoints  The available APIs for the [Identity](https://id.production.cybrid.app/api/schema/swagger-ui), [Organization](https://organization.production.cybrid.app/api/schema/swagger-ui) and [Bank](https://bank.production.cybrid.app/api/schema/swagger-ui) API services are listed below:  | API Service  | Model                | API Endpoint Path              | Description                                                                                       | |--------------|----------------------|--------------------------------|---------------------------------------------------------------------------------------------------| | Identity     | Bank                 | /api/bank_applications         | Create and list banks                                                                             | | Identity     | CustomerToken        | /api/customer_tokens           | Create customer JWT access tokens                                                                 | | Identity     | Organization         | /api/organization_applications | Create and list organizations                                                                     | | Identity     | Organization         | /api/users                     | Create and list organization users                                                                | | Organization | Organization         | /api/organizations             | APIs to retrieve and update organization name                                                     | | Bank         | Account              | /api/accounts                  | Create and list accounts, which hold a specific asset for a customers                             | | Bank         | Asset                | /api/assets                    | Get a list of assets supported by the platform (ex: BTC, ETH)                                     | | Bank         | Bank                 | /api/banks                     | Create, update and list banks, the parent to customers, accounts, etc                             | | Bank         | Customer             | /api/customers                 | Create and list customers                                                                         | | Bank         | Counterparty         | /api/counterparties            | Create and list counterparties                                                                    | | Bank         | DepositAddress       | /api/deposit_addresses         | Create, get and list deposit addresses                                                            | | Bank         | ExternalBankAccount  | /api/external_bank_accounts    | Create, get and list external bank accounts, which connect customer bank accounts to the platform | | Bank         | ExternalWallet       | /api/external_wallets          | Create, get, list and delete external wallets, which connect customer wallets to the platform     | | Bank         | IdentityVerification | /api/identity_verifications    | Create and list identity verifications, which are performed on customers for KYC                  | | Bank         | Invoice              | /api/invoices                  | Create, get, cancel and list invoices                                                             | | Bank         | PaymentInstruction   | /api/payment_instructions      | Create, get and list payment instructions for invoices                                            | | Bank         | Price                | /api/prices                    | Get the current prices for assets on the platform                                                 | | Bank         | Quote                | /api/quotes                    | Create and list quotes, which are required to execute trades                                      | | Bank         | Symbol               | /api/symbols                   | Get a list of symbols supported for trade (ex: BTC-USD)                                           | | Bank         | Trade                | /api/trades                    | Create and list trades, which buy or sell cryptocurrency                                          | | Bank         | Transfer             | /api/transfers                 | Create, get and list transfers (e.g., funding, book)                                              | | Bank         | Workflow             | /api/workflows                 | Create, get and list workflows                                                                    |  ## Understanding Object Models & Endpoints  **Organizations**  An `Organization` is meant to represent the organization partnering with Cybrid to use our platform.  An `Organization` typically does not directly interact with `customers`. Instead, an Organization has one or more `banks`, which encompass the financial service offerings of the platform.  **Banks**  A `Bank` is owned by an `Organization` and can be thought of as an environment or container for `customers` and product offerings. Banks are created in either `Sandbox` or `Production` mode, where `Sandbox` is the environment that you would test, prototype and build in prior to moving to `Production`.  An `Organization` can have multiple `banks`, in either `Sandbox` or `Production` environments. A `Sandbox Bank` will be backed by stubbed data and process flows. For instance, funding source transfer processes as well as trades will be simulated rather than performed, however asset prices are representative of real-world values. You have an unlimited amount of simulated fiat currency for testing purposes.  **Customers**  `Customers` represent your banking users on the platform. At present, we offer support for `Individuals` as Customers.  `Customers` must be verified (i.e., KYC'd) in our system before they can play any part on the platform, which means they must have an associated and a passing `Identity Verification`. See the Identity Verifications section for more details on how a customer can be verified.  `Customers` must also have an `Account` to be able to transact, in the desired asset class. See the Accounts APIs for more details on setting up accounts for the customer. 
 *
 * The version of the OpenAPI document: v0.119.21
 * Contact: support@cybrid.app
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package app.cybrid.cybrid_api_organization.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SubscriptionDeliveryOrganizationModel
 */
@JsonPropertyOrder({
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_GUID,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_RESPONSE,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_SUBSCRIPTION_EVENT_GUID,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_SUBSCRIPTION_GUID,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_STATE,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_NEXT_ATTEMPT_AT,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_ATTEMPT_COUNT,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_COMPLETED_AT,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_FAILED_AT,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_CREATED_AT,
  SubscriptionDeliveryOrganizationModel.JSON_PROPERTY_UPDATED_AT
})
@JsonTypeName("SubscriptionDelivery")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-08-14T18:40:31.508040Z[Etc/UTC]")
public class SubscriptionDeliveryOrganizationModel {
  public static final String JSON_PROPERTY_GUID = "guid";
  private String guid;

  public static final String JSON_PROPERTY_RESPONSE = "response";
  private String response;

  public static final String JSON_PROPERTY_SUBSCRIPTION_EVENT_GUID = "subscription_event_guid";
  private String subscriptionEventGuid;

  public static final String JSON_PROPERTY_SUBSCRIPTION_GUID = "subscription_guid";
  private String subscriptionGuid;

  /**
   * The state of the subscription delivery.
   */
  public enum StateEnum {
    STORING("storing"),
    
    COMPLETED("completed"),
    
    FAILING("failing"),
    
    FAILED("failed");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_STATE = "state";
  private StateEnum state;

  public static final String JSON_PROPERTY_NEXT_ATTEMPT_AT = "next_attempt_at";
  private OffsetDateTime nextAttemptAt;

  public static final String JSON_PROPERTY_ATTEMPT_COUNT = "attempt_count";
  private java.math.BigInteger attemptCount;

  public static final String JSON_PROPERTY_COMPLETED_AT = "completed_at";
  private OffsetDateTime completedAt;

  public static final String JSON_PROPERTY_FAILED_AT = "failed_at";
  private OffsetDateTime failedAt;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
  private OffsetDateTime updatedAt;

  public SubscriptionDeliveryOrganizationModel() { 
  }

  public SubscriptionDeliveryOrganizationModel guid(String guid) {
    
    this.guid = guid;
    return this;
  }

   /**
   * Auto-generated unique identifier for the subscription delivery.
   * @return guid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Auto-generated unique identifier for the subscription delivery.")
  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGuid() {
    return guid;
  }


  @JsonProperty(JSON_PROPERTY_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGuid(String guid) {
    this.guid = guid;
  }


  public SubscriptionDeliveryOrganizationModel response(String response) {
    
    this.response = response;
    return this;
  }

   /**
   * The response of the subscription delivery.
   * @return response
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The response of the subscription delivery.")
  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getResponse() {
    return response;
  }


  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResponse(String response) {
    this.response = response;
  }


  public SubscriptionDeliveryOrganizationModel subscriptionEventGuid(String subscriptionEventGuid) {
    
    this.subscriptionEventGuid = subscriptionEventGuid;
    return this;
  }

   /**
   * The subscription event guid of the subscription delivery.
   * @return subscriptionEventGuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The subscription event guid of the subscription delivery.")
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_EVENT_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSubscriptionEventGuid() {
    return subscriptionEventGuid;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_EVENT_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubscriptionEventGuid(String subscriptionEventGuid) {
    this.subscriptionEventGuid = subscriptionEventGuid;
  }


  public SubscriptionDeliveryOrganizationModel subscriptionGuid(String subscriptionGuid) {
    
    this.subscriptionGuid = subscriptionGuid;
    return this;
  }

   /**
   * The subscription guid of the subscription delivery.
   * @return subscriptionGuid
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The subscription guid of the subscription delivery.")
  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSubscriptionGuid() {
    return subscriptionGuid;
  }


  @JsonProperty(JSON_PROPERTY_SUBSCRIPTION_GUID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubscriptionGuid(String subscriptionGuid) {
    this.subscriptionGuid = subscriptionGuid;
  }


  public SubscriptionDeliveryOrganizationModel state(StateEnum state) {
    
    this.state = state;
    return this;
  }

   /**
   * The state of the subscription delivery.
   * @return state
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The state of the subscription delivery.")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public StateEnum getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(StateEnum state) {
    this.state = state;
  }


  public SubscriptionDeliveryOrganizationModel nextAttemptAt(OffsetDateTime nextAttemptAt) {
    
    this.nextAttemptAt = nextAttemptAt;
    return this;
  }

   /**
   * ISO8601 datetime the next attempt will be made.
   * @return nextAttemptAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the next attempt will be made.")
  @JsonProperty(JSON_PROPERTY_NEXT_ATTEMPT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getNextAttemptAt() {
    return nextAttemptAt;
  }


  @JsonProperty(JSON_PROPERTY_NEXT_ATTEMPT_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNextAttemptAt(OffsetDateTime nextAttemptAt) {
    this.nextAttemptAt = nextAttemptAt;
  }


  public SubscriptionDeliveryOrganizationModel attemptCount(java.math.BigInteger attemptCount) {
    
    this.attemptCount = attemptCount;
    return this;
  }

   /**
   * The number of attempts made to deliver the event.
   * @return attemptCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The number of attempts made to deliver the event.")
  @JsonProperty(JSON_PROPERTY_ATTEMPT_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public java.math.BigInteger getAttemptCount() {
    return attemptCount;
  }


  @JsonProperty(JSON_PROPERTY_ATTEMPT_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAttemptCount(java.math.BigInteger attemptCount) {
    this.attemptCount = attemptCount;
  }


  public SubscriptionDeliveryOrganizationModel completedAt(OffsetDateTime completedAt) {
    
    this.completedAt = completedAt;
    return this;
  }

   /**
   * ISO8601 datetime the event was delivered.
   * @return completedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the event was delivered.")
  @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCompletedAt() {
    return completedAt;
  }


  @JsonProperty(JSON_PROPERTY_COMPLETED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompletedAt(OffsetDateTime completedAt) {
    this.completedAt = completedAt;
  }


  public SubscriptionDeliveryOrganizationModel failedAt(OffsetDateTime failedAt) {
    
    this.failedAt = failedAt;
    return this;
  }

   /**
   * ISO8601 datetime the event delivery was marked as failed.
   * @return failedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the event delivery was marked as failed.")
  @JsonProperty(JSON_PROPERTY_FAILED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getFailedAt() {
    return failedAt;
  }


  @JsonProperty(JSON_PROPERTY_FAILED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFailedAt(OffsetDateTime failedAt) {
    this.failedAt = failedAt;
  }


  public SubscriptionDeliveryOrganizationModel createdAt(OffsetDateTime createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * ISO8601 datetime the record was created at.
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the record was created at.")
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }


  public SubscriptionDeliveryOrganizationModel updatedAt(OffsetDateTime updatedAt) {
    
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * ISO8601 datetime the record was last updated at.
   * @return updatedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "ISO8601 datetime the record was last updated at.")
  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }


  @JsonProperty(JSON_PROPERTY_UPDATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionDeliveryOrganizationModel subscriptionDelivery = (SubscriptionDeliveryOrganizationModel) o;
    return Objects.equals(this.guid, subscriptionDelivery.guid) &&
        Objects.equals(this.response, subscriptionDelivery.response) &&
        Objects.equals(this.subscriptionEventGuid, subscriptionDelivery.subscriptionEventGuid) &&
        Objects.equals(this.subscriptionGuid, subscriptionDelivery.subscriptionGuid) &&
        Objects.equals(this.state, subscriptionDelivery.state) &&
        Objects.equals(this.nextAttemptAt, subscriptionDelivery.nextAttemptAt) &&
        Objects.equals(this.attemptCount, subscriptionDelivery.attemptCount) &&
        Objects.equals(this.completedAt, subscriptionDelivery.completedAt) &&
        Objects.equals(this.failedAt, subscriptionDelivery.failedAt) &&
        Objects.equals(this.createdAt, subscriptionDelivery.createdAt) &&
        Objects.equals(this.updatedAt, subscriptionDelivery.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(guid, response, subscriptionEventGuid, subscriptionGuid, state, nextAttemptAt, attemptCount, completedAt, failedAt, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionDeliveryOrganizationModel {\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    subscriptionEventGuid: ").append(toIndentedString(subscriptionEventGuid)).append("\n");
    sb.append("    subscriptionGuid: ").append(toIndentedString(subscriptionGuid)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    nextAttemptAt: ").append(toIndentedString(nextAttemptAt)).append("\n");
    sb.append("    attemptCount: ").append(toIndentedString(attemptCount)).append("\n");
    sb.append("    completedAt: ").append(toIndentedString(completedAt)).append("\n");
    sb.append("    failedAt: ").append(toIndentedString(failedAt)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

