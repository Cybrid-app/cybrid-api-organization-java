

# PostSubscriptionOrganizationModel

Request body for subscription creation.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**environment** | [**EnvironmentEnum**](#EnvironmentEnum) | The environment that the subscription is configured for. |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the subscription. |  |
|**name** | **String** | Name provided for the subscription. |  |
|**url** | **String** | URL provided for the subscription. |  |



## Enum: EnvironmentEnum

| Name | Value |
|---- | -----|
| SANDBOX | &quot;sandbox&quot; |
| PRODUCTION | &quot;production&quot; |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| WEBHOOK | &quot;webhook&quot; |



