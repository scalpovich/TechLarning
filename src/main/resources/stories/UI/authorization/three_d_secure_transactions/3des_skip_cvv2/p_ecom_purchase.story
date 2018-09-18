Sample story

Narrative:
In order to communicate effectively to the business some functionality
As a development team
I want to use Behaviour-Driven Development

Meta:
@StoryName bvt
					 
Scenario:  Skip CVV2/CVC2 Validation in 3DES Params
Meta:
@ttt
Given setting json values in excel for Prepaid
And user is logged in institution
When user edits 3D ecommerce security parameters to skip CVV2/CVC2 validation for product Prepaid and interchange Mastercard
