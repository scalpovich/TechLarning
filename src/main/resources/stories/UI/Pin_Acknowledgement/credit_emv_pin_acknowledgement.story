credit emv pin acknowledgement Positive Scenario

Narrative:
In order to provide to client easy-to-use multi-purpose credit card with pin
As an issuer
I want to create EMV Credit card with pin and verify positive pin acknowledgement


Meta:
@StoryName credit_emv_retail_pin_ack
@TCName TC857949

Scenario: Set up credit emv retail general purpose card device production

Given setting json values in excel for Credit
When user test
When user processes Send To Carrier batch for Pin File Type and product credit
