!-- author: e076177
Narrative:
In order to add and Verify Late Payment Fee Plan under customer portal cardmanagement tab
As a user
I want to assert pages
					 
Scenario:1  Customer Portal-Adding a Late Payment Fee Plan
Given login to portal as existing bank as a user
When user navigates to Late Payment Fee Plan and adds a new Late Payment Fee Plan

Scenario:2 UI verification - Customer Portal -  LatePaymentFeePlan, card management tab
Given user is logged in institution
When user is at the home tab
Then LatePaymentFeePlan page of card management tab is rendered correctly
And user signs out from customer portal
