!-- @author: E074127
Narrative:
As a Customer portal user
I want to add a Currency Exchange Rate into the system 
so that it can be used in currency exchange

Meta:
@CurrencyExchangeRates

Scenario: To verify that the user is able to add a new Currency Exchange Rate for the Mastercard through screen
Meta:
@TCName TC_AddCurrencyExchangeRates
@sheetName CurrencyExchangeRates
@all
@R7Regression
@Sanity
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates screen
And user adds the Currency Exchange Rate for Mastercard
Then verify that the currency exchange rate is added into the system


Scenario: To verify that the user is able to add a new Currency Exchange Rate for the visa through screen
Meta:
@TCName TC_AddCurrencyExchangeRates
@sheetName CurrencyExchangeRates
@all
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates screen
And user adds the Currency Exchange Rate for Visa
Then verify that the currency exchange rate is added into the system


Scenario: To verify that the user is able to add a new Currency Exchange Rate for the bank through screen
Meta:
@TCName TC_AddCurrencyExchangeRates
@sheetName CurrencyExchangeRates
@all
@R7Regression
Given login to portal as existing bank as a user
When user navigates to Currency Exchange Rates screen
And user adds the Currency Exchange Rate for Bank
Then verify that the currency exchange rate is added into the system


Scenario: To verify that the user is able to add a new Currency Exchange Rate for the bank through file upload
Meta:
@TCName TC_UploadCERBank
@sheetName CurrencyExchangeRateUpload
@all
@Sanity
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the currency exchange rates file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the CurrencyExchangeRate file is uploaded sucessfully


Scenario: To verify that the user is able to add a new Currency Exchange Rate for the Mastercard through file upload
Meta:
@TCName TC_UploadCERMastercard
@sheetName CurrencyExchangeRateUpload
@CERFileUploadMC
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the currency exchange rates file for Mastercard
And user runs Process Batches for upload for MC Currency Exchange Rate file
Then verify that the CurrencyExchangeRate file is uploaded sucessfully

!-- 1.	Invalid header.
!-- 2.	Invalid Institution in Header
Scenario: To verify that an appropriate error message is shown for the bank file upload - Invalid Header
Meta:
@TCName TC_UploadCERBankInvalidHeader
@sheetName CurrencyExchangeRateUpload
@CERUploadBankInvalidHeader
@all
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the invalid header in CER file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the batch uploads fails with an appropriate error message for invalid header

!-- 3.	Invalid Currency Code 
Scenario: To verify that an appropriate error message is shown for the bank file upload - Invalid Currency Code
Meta:
@TCName TC_UploadCERBankInvalidScenario
@sheetName CurrencyExchangeRateUpload
@CERUploadBankInvalidCurr
@all
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the invalid currency in CER file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the batch uploads fails with an appropriate error message for invalid currency code

!-- 6.	Invalid Program code
Scenario: To verify that an appropriate error message is shown for the bank file upload - Invalid Program Code
Meta:
@TCName TC_UploadCERBankInvalidScenario
@sheetName CurrencyExchangeRateUpload
@CERUploadBankInvalidProgram
@all
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the invalid program in CER file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the batch uploads fails with an appropriate error message for invalid program

!-- 7.	Single Currency Program
Scenario: To verify that an appropriate error message is shown for the bank file upload - Single Currency Program
Meta:
@TCName TC_UploadCERBankInvalidScenario
@sheetName CurrencyExchangeRateUpload
@CERUploadBankSingleCurrProgram
@all
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the single currency program in CER file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the batch uploads fails with an appropriate error message for single currency program

!-- 4.	Invalid Footer Count
Scenario: To verify that an appropriate error message is shown for the bank file upload - Invalid Footer Count
Meta:
@TCName TC_UploadCERBankInvalidScenario
@sheetName CurrencyExchangeRateUpload
@CERUploadBankInvalidFooterCount
@all
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the invalid footer in CER file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the batch uploads fails with an appropriate error message for invalid footer

!-- 5.	Back dated
Scenario: To verify that an appropriate error message is shown for the bank file upload - Back Dated File
Meta:
@TCName TC_UploadCERBankInvalidScenario
@sheetName CurrencyExchangeRateUpload
@CERUploadBankInvalidBackDated
@all
Given login to portal as existing bank as a user
When user navigates to the Process Batches screen
And user uploads the back dated transactions in CER file for bank
And user runs Process Batches for upload for Currency Exchange Rate file
Then verify that the batch uploads fails with an appropriate error message for back dated entry

