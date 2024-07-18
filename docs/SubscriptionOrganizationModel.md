

# SubscriptionOrganizationModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the subscription. |  |
|**name** | **String** | Name provided for the subscription. |  |
|**type** | [**TypeEnum**](#TypeEnum) | The type of subscription. |  |
|**url** | **String** | The url for the subscription. |  |
|**environment** | **String** | The environment that the subscription is configured for; one of sandbox or production. |  |
|**state** | **String** | The state of the subscription; one of storing, completed, or failed. |  |
|**failureCode** | **String** | The failure code of a subscription (if any) |  [optional] |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  [optional] |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| WEBHOOK | &quot;webhook&quot; |



