

# SubscriptionDeliveryOrganizationModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the subscription delivery. |  |
|**response** | **String** | The response of the subscription delivery. |  [optional] |
|**subscriptionEventGuid** | **String** | The subscription event guid of the subscription delivery. |  |
|**subscriptionGuid** | **String** | The subscription guid of the subscription delivery. |  |
|**state** | [**StateEnum**](#StateEnum) | The state of the subscription delivery. |  |
|**nextAttemptAt** | **OffsetDateTime** | ISO8601 datetime the next attempt will be made. |  [optional] |
|**attemptCount** | **java.math.BigInteger** | The number of attempts made to deliver the event. |  |
|**completedAt** | **OffsetDateTime** | ISO8601 datetime the event was delivered. |  [optional] |
|**failedAt** | **OffsetDateTime** | ISO8601 datetime the event delivery was marked as failed. |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| STORING | &quot;storing&quot; |
| COMPLETED | &quot;completed&quot; |
| FAILING | &quot;failing&quot; |
| FAILED | &quot;failed&quot; |



