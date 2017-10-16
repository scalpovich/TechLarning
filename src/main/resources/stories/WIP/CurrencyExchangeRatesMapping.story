!-- @author: E074127

Narrative:
As a Customer portal user
I want to add a Currency Exchange Rate Mapping into the system 
so that it can be used in currency exchange

Meta:
@CurrencyExchangeRatesMapping
@Stage
@all

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the system and bank
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingSystemBank
@R7Regression
@Stage
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the system and bank
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the system and mastercard
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingSystemMC
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the system and mastercard
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the system and visa
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingSystemVisa
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the system and visa
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the Mastercard and bank
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingMCBank
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the Mastercard and bank
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the Mastercard and mastercard
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingMC
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the Mastercard and mastercard
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the Mastercard and visa
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingMCVisa
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the Mastercard and visa
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the visa and bank
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingVisaBank
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the visa and bank
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the visa and mastercard
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingVisaMC
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the visa and mastercard
Then verify that the CER Mapping is added into the system

Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the visa and visa
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingVisa
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates Mapping screen
And user adds the Currency Exchange Rate Mapping for the visa and visa
Then verify that the CER Mapping is added into the system


Scenario: To verify that the user is able to add a new Currency Exchange Rate Mapping for the system and bank
Meta:
@TCName TC_AddCurrencyExchangeRatesMapping
@sheetName CurrencyExchangeRateMapping
@AddCERMappingSystemBank1
@R7Regression
Given login to portal as existing bank as a user
When user creates CER mapping for visa and visa through screen
Then verify that the CER Mapping is added into the system