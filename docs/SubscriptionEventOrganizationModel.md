

# SubscriptionEventOrganizationModel


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**guid** | **String** | Auto-generated unique identifier for the subscription event. |  |
|**eventType** | **String** | The type of the subscription event. One of transfer.created or transfer.updated. |  |
|**objectGuid** | **String** | The object guid for which the event is received. |  |
|**environment** | **String** | The environment that the subscription event is configured for; one of sandbox or production. |  [optional] |
|**organizationGuid** | **String** | The organization guid of the subscription event. |  |
|**createdAt** | **OffsetDateTime** | ISO8601 datetime the record was created at. |  |
|**updatedAt** | **OffsetDateTime** | ISO8601 datetime the record was last updated at. |  [optional] |



