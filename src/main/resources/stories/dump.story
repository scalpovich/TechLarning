Narrative:
In order to verify dumps
As a user
I want to run download batches

Meta:
@StoryName dumps
@SanityTest
@dump


Scenario: Verify Accounts dump

Given user is logged in institution
When <batchType> download batch is executed for <cardType> user
Then <fileType> file is successfully downloaded <folder>

Examples:
|batchType                                            |cardType	              |fileType     |folder               |
|Account Dump [ACCOUNT_DUMP]                          |Debit [D]              |ACC          |SAFE_DOWNLOAD        |
|Account Dump [ACCOUNT_DUMP]                          |Prepaid [P]            |ACC          |SAFE_DOWNLOAD        |


Scenario: Verify card Holder dump

Given user is logged in institution
When <batchType> download batch is executed for <cardType> user
Then <fileType> file is successfully downloaded <folder>

Examples:
|batchType                                            |cardType	                  |fileType  |folder              |
|Cardholder Dump [CARDHOLDER_DUMP]                    |Prepaid [P]                |CHD       |CARDHOLDER_DUMP     |
|Cardholder Dump [CARDHOLDER_DUMP]                    |Debit [D]                  |CHD       |CARDHOLDER_DUMP     |

Scenario: Verify Authorization dump

Given user is logged in institution
When <batchType> download batch is executed for <cardType> user
Then <fileType> file is successfully downloaded <folder>

Examples:
|batchType                                            |cardType	               	  |fileType|folder                |
|Authorization Download [AUTHORIZATION_DOWNLOAD]      |Prepaid [P]                |AUTH    |AUTHORIZATION_DOWNLOAD|
|Authorization Download [AUTHORIZATION_DOWNLOAD]      |Debit [D]                  |AUTH    |AUTHORIZATION_DOWNLOAD|