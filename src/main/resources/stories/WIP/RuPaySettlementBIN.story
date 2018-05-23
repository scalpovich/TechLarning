!-- @author: E074127

Narrative:
As a Customer portal user
I want to add a RuPay Settlement BIN into the system 
so that it can be used in RuPay device creation

Meta:
@RuPaySettlementBIN
@StoryName RuPaySettlementBIN
@Stage
@all

Scenario: To verify that the user is able to add a new RuPay Settlement BIN for the system
Meta:
@R7Regression
@Stage
Given user is logged in institution
When user creates Device BIN for Rupay for product Debit for BinType as Dual Message Type
When user adds the RuPay Settlement BIN
Then verify that the RuPay Settlement BIN is added into the system