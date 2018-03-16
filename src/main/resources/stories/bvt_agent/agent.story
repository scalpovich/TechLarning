Narrative:
In order to work on UI verification Agent Portal
As an Agent User
I want to validate all the UI verification Agent Portal Pages Loaded based on roles Admin, Agency, Agent, Branch

Meta:
@StoryName S224290
@BVTest

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - Create Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > create page
Then administrator > user > create page is loaded and master detail content title is Portal Admin Information
And AdministratorUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - View/Edit Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > view/edit page
Then administrator > user > view/edit page is loaded and master detail content title is Portal Admin User Information
And AdministratorUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - Reset/User Password Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > reset/user password page
Then administrator > user > reset/user password page is loaded and master detail content title is PortalAdmin User Information
And AdministratorUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - Active/Deactive User Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > active/deactive user page
Then administrator > user > active/deactive user page is loaded and master detail content title is Portal Admin User Information
And AdministratorUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - Create Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > create page
Then agency > entity > create page is loaded and master detail content title is Agency Information
And AgencyEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - View/Edit Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > view/edit page
Then agency > entity > view/edit page is loaded and master detail content title is Agency Information
And AgencyEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - Active/Suspend Agency Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > active/suspend agency page
Then agency > entity > active/suspend agency page is loaded and master detail content title is Agency Information
And AgencyEntityActivateSuspendAgency page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - Assign Programs Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > assign programs page
Then agency > entity > assign programs page is loaded and master detail content title is Agency Information
And AssignProgramsAgency page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - User - Create Page

Given user is logged in agent portal as <type> user
When user navigates to agency > user > create page
Then agency > user > create page is loaded and master detail content title is Agency Information
And AgencyUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Agency - User - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to agency > user > view/edit page
Then agency > user > view/edit page is loaded and master detail content title is Agency User Information
And AgencyUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Agency - User - Reset/User Password Page

Given user is logged in agent portal as admin user
When user navigates to agency > user > reset/user password page
Then agency > user > reset/user password page is loaded and master detail content title is Agency User Information
And AgencyUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - User - Active/Deactive User Page

Given user is logged in agent portal as <type> user
When user navigates to agency > user > active/deactive user page
Then agency > user > active/deactive user page is loaded and master detail content title is Agency User Information
And AgencyUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - Create Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > create page
Then branch > entity > create page is loaded and master detail content title is Branch Information
And BranchEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > view/edit page
Then branch > entity > view/edit page is loaded and master detail content title is Branch Information
And BranchEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - Active/Suspend Branch Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > active/suspend branch page
Then branch > entity > active/suspend branch page is loaded and master detail content title is Branch Information
And BranchEntityActivateSuspendBranch page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - Assign Programs Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > assign programs page
Then branch > entity > assign programs page is loaded and master detail content title is Branch Information
And AssignProgramsBranch page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - Create Page

Given user is logged in agent portal as <type> user
When user navigates to branch > user > create page
Then branch > user > create page is loaded and master detail content title is Branch Information
And BranchUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to branch > user > view/Edit page
Then branch > user > view/edit page is loaded and master detail content title is Branch User Information
And BranchUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - Reset/User Password Page

Given user is logged in agent portal as <type> user
When user navigates to branch > user > reset/user password page
Then branch > user > reset/user password page is loaded and master detail content title is Branch User Information
And BranchUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - Active/Deactive User Page

Given user is logged in agent portal as <type> user
When user navigates to branch > user > active/deactive user page
Then branch > user > active/deative user page is loaded and master detail content title is Branch User Information
And BranchUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - Create Page

Given user is logged in agent portal as <type> user
When user navigates to agent > entity > create page
Then agent > entity > create page is loaded and master detail content title is Agent Information
And AgentEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to agent > entity > view/edit page
Then agent > entity > view/edit page is loaded and master detail content title is Agent Information
And AgentEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - Active/Suspend Branch Page

Given user is logged in agent portal as <type> user
When user navigates to agent > entity > active/suspend branch page
Then agent > entity > active/suspend page is loaded and master detail content title is Agent Information
And AgentEntityActiveSuspendAgent page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - Assign Programs Page

Given user is logged in agent portal as <type> user
When user navigates to agent > entity > assign programs page
Then agent > entity > assign programs page is loaded and master detail content title is Agent Information
And AssignProgramsAgent page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - Create Page

Given user is logged in agent portal as <type> user
When user navigates to agent > user > create page
Then agent > user > create page is loaded and master detail content title is Agent Information
And AgentUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to agent > user > view/edit page
Then agent > user > view/edit page is loaded and master detail content title is Agent User Information
And AgentUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - Reset/User Password Page

Given user is logged in agent portal as <type> user
When user navigates to agent > user > reset/user password page
Then agent > user > reset/user password page is loaded and master detail content title is Agent User Information
And AgentUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - Active/Deactive User Page

Given user is logged in agent portal as <type> user
When user navigates to agent > user > active/deactive user page
Then agent > user > active/deactive user page is loaded and master detail content title is Agent User Information
And AgentUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - Create Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > create page
Then corporate > user > create page is loaded and master detail content title is Corporate User Information
And CorporateUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - View/Edit Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > view/edit page
Then corporate > user > view/edit page is loaded and master detail content title is Corporate User Information
And CorporateUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - Reset/User Password Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > reset/user password page
Then corporate > user > view/edit page is loaded and master detail content title is Corporate User Information
And CorporateUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - Active/Deactive User Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > active/deactive user page
Then corporate > user > active/deative user page is loaded and master detail content title is Corporate User Information
And CorporateUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Roles & Privileges - Create Role Page

Given user is logged in agent portal as <type> user
When user navigates to roles and privileges > create role page
Then create role page is loaded and master detail content title is Role Information
And CreateRole page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: UI verification Agent Portal - Channel Management - Roles & Previleges - Assign Privileges Page

Given user is logged in agent portal as <type> user
When user navigates to roles and privileges > assign privileges page
Then assign privileges page is loaded and master detail content title is Role Information
And AssignPrivileges page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: UI verification Agent Portal - Channel Management - Event Alerts Page

Given user is logged in agent portal as admin user
When user navigates to event alerts page
Then event alerts page is loaded and master detail content title is Event Alerts
And EventAlerts page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Inventory - Order - Cancellation Page

Given user is logged in agent portal as <type> user
When user navigates to order cancellation page
Then order cancellation page is loaded and master detail content title is Cancellation
And OrderCancellation page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Order - Order Page

Given user is logged in agent portal as <type> user
When user navigates to order page
Then order page is loaded and master detail content title is Order
And Order page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Order - Acceptance Page

Given user is logged in agent portal as <type> user
When user navigates to order acceptance page
Then order acceptance page is loaded and master detail content title is Acceptance
And Acceptance page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Order - Status Page

Given user is logged in agent portal as <type> user
When user navigates to order status page
Then order status page is loaded and master detail content title is Status
And Status page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Stock Transfer - Intra Branch Page

Given user is logged in agent portal as <type> user
When user navigates to stock transfer intra branch page
Then stock transfer intra branch page is loaded and master detail content title is Intra Branch Details
And StockTransferIntraBranch page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Stock Transfer - Acceptance Page

Given user is logged in agent portal as <type> user
When user navigates to stock transfer acceptance page
Then stock transfer acceptance page is loaded and master detail content title is Acceptance
And StockTransferAcceptance page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Stock Return Page

Given user is logged in agent portal as <type> user
When user navigates to stock return page
Then stock return page is loaded and master detail content title is Stock Return
And StockReturn page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Inventory - Inventory Status Page

Given user is logged in agent portal as <type> user
When user navigates to inventory status page
Then inventory status page is loaded and master detail content title is Inventory Status
And InventoryStatus page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: UI verification Agent Portal - Profile - View Profile Page

Given user is logged in agent portal as <type> user
When user navigates to view profile page
Then view profile page is loaded and master detail content title is Profile Information
And ViewProfile page of profile tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |
| branch |
| agent  |

Scenario: UI verification Agent Portal - Profile - Entity Details Page

Given user is logged in agent portal as <type> user
When user navigates to entity details page
Then entity detials page is loaded and master detail content title is <expectedvalue>
And EntityDetails page of profile tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |        expectedvalue	      |
| agency | Agency Profile Information |
| branch | Branch Profile Information |
| agent  | Agent Profile Information  |

Scenario: UI verification Agent Portal - Profile - Change Password Page

Given user is logged in agent portal as agent user
When user navigates to change password page
Then change password page is loaded and master detail content title is Change Password
And ChangePassword page of profile tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Device Sale Page

Given user is logged in agent portal as agent user
When user navigates to device sale page
Then device sale page is loaded and master detail content title is Sale
And DeviceSale page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Application Correction Page

Given user is logged in agent portal as agent user
When user navigates to application correction page
Then application correction page is loaded and master detail content title is Application Correction Details
And ApplicationCorrection page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Checker Page

Given user is logged in agent portal as agent user
When user navigates to checker page
Then checker page is loaded and master detail content title is Card Sale Checker
And Checker page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - De-dupe Re-Verification & Approval Page

Given user is logged in agent portal as agent user
When user navigates to dedupe reverification approval page
Then dedupe reverification approval page is loaded and master detail content title is De-dupe Re-verification & Approval
And DedupeReverificationApproval page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - KYC Update Page

Given user is logged in agent portal as agent user
When user navigates to kyc update page
Then kyc update page is loaded and master detail content title is KYC Updation
And KYCUpdate page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Device Sale/Issuance - Instant Device Replacement Page

Given user is logged in agent portal as agent user
When user navigates to instant device replacement page
Then instant device replacement page is loaded and master detail content title is Instant Device Replacement
And InstantDeviceReplacement page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Travel Card Currency Management - Currency Setup Page

Given user is logged in agent portal as agent user
When user navigates to currency setup page
Then currency setup page is loaded and master detail content title is Currency Setup
And CurrencySetup page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Travel Card Currency Management - Change Currency Priority Page

Given user is logged in agent portal as agent user
When user navigates to change currency priority page
Then change currency priority page is loaded and master detail content title is Change Currency Priority
And ChangeCurrencyPriority page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Travel Card Currency Management - Activate/ De-activate Sub account Page

Given user is logged in agent portal as agent user
When user navigates to activate deactivate sub account page
Then activate deactivate sub account page is loaded and master detail content title is Activate / De-activate Wallet
And ActivateDeactivateSubAccount page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Services - Limited Validity Virtual Card Cancellation Page

Given user is logged in agent portal as agent user
When user navigates to limited validity virtual card cancellation page
Then limited validity virtual card cancellation page is loaded and master detail content title is Limited Validity Virtual Card Cancellation
And LimitedValidityVirtualCardCancellation page of services tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Settlement - Initiate - Agency Settlement Page

Given user is logged in agent portal as agency user
When user navigates to initiate settlement page
Then initiate settlement page is loaded and master detail content title is Initiate Settlement
And InitiateSettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Settlement - Reports - Agency Settlement Page

Given user is logged in agent portal as admin user
When user navigates to agency settlement page
Then agency settlement page is loaded and master detail content title is Initiate Settlement Reports
And AgencySettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Settlement - Reports - Branch Settlement Page

Given user is logged in agent portal as agency user
When user navigates to branch settlement page
Then branch settlement page is loaded and master detail content title is Initiate Settlement Reports
And BranchSettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Settlement - Reports - Transaction & Settlement Page

Given user is logged in agent portal as agency user
When user navigates to transaction and settlement page
Then transaction and settlement page is loaded and master detail content title is Transaction Settlement Reports
And TransactionAndSettlement page of settlement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Load Balance - Request Page

Given user is logged in agent portal as agent user
When user navigates to load balance request page
Then load balance request page is loaded and master detail content title is Load Balance Request
And LoadBalanceRequest page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Load Balance - View Pending Requests Page

Given user is logged in agent portal as agent user
When user navigates to load balance view pending requests page
Then load balance view pending requests page is loaded and master detail content title is Load Balance View
And LoadBalanceViewPendingRequests page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Load Balance - Approve Page

Given user is logged in agent portal as agent user
When user navigates to load balance approve page
Then load balance approve page is loaded and master detail content title is Load Balance Approve
And LoadBalanceApprove page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Balance Refund - Request Page

Given user is logged in agent portal as agent user
When user navigates to balance refund request page
Then balance refund request page is loaded and master detail content title is Cancel Wallet Request
And BalanceRefundRequest page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Balance Refund - Approve Page

Given user is logged in agent portal as agent user
When user navigates to balance refund approve page
Then balance refund approve page is loaded and master detail content title is Refund Wallet - Approve
And BalanceRefundApprove page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Card to Cash Transaction Page

Given user is logged in agent portal as agent user
When user navigates to card to cash transaction page
Then card to cash transaction page is loaded and master detail content title is Cash Remittance Booking
And CardToCashTransaction page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Card to Cash Lookup Page

Given user is logged in agent portal as agent user
When user navigates to card to cash lookup page
Then card to cash lookup page is loaded and master detail content title is Cash Remittances
And CardToCashLookup page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Cancel Card to Cash Page

Given user is logged in agent portal as agent user
When user navigates to cancel card to cash page
Then cancel card to cash page is loaded and master detail content title is Cancel Remittance Booking
And CancelCardToCash page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Card to Cash - Cash Remittance Payout Page

Given user is logged in agent portal as agent user
When user navigates to cash remittance payout page
Then cash remittance payout page is loaded and master detail content title is Cash Remittance Payout
And CashRemittancePayout page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - Transfer Funds Page

Given user is logged in agent portal as agent user
When user navigates to transfer funds page
Then transfer funds page is loaded and master detail content title is Transfer Funds
And TransferFunds page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - View Charges Page

Given user is logged in agent portal as agent user
When user navigates to view charges page
Then view charges page is loaded and master detail content title is View Charges
And TransactionsViewCharges page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - Transaction History Page

Given user is logged in agent portal as agent user
When user navigates to transaction history page
Then transaction history page is loaded and master detail content title is Transaction History
And TransactionHistory page of transactions tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Transactions - Others - Balance Enquiry Page

Given user is logged in agent portal as agent user
When user navigates to balance enquiry page
Then balance enquiry page is loaded and master detail content title is Balance Enquiry
And BalanceEnquiry page of transactions tab is rendered correctly
And user sign out from agent portal