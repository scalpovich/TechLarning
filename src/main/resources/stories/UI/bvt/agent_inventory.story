Narrative:
In order to work on UI verification Agent Portal
As an Agent User
I want to validate inventory tab UI verification Agent Portal Pages Loaded based on roles Branch, Agency

Meta:
@StoryName S224290
@AgentBV

Scenario: UI verification Agent Portal - Inventory - Order - Cancellation Page
Given user is logged in agent portal as <type> user
When user navigates to order cancellation page
Then order cancellation page is loaded and master detail content title is Cancellation
And OrderCancellation page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378859| agency |
|@TestId TC411878| branch |

Scenario: UI verification Agent Portal - Inventory - Order - Order Page
Given user is logged in agent portal as <type> user
When user navigates to order page
Then order page is loaded and master detail content title is Order
And Order page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378860| agency |
|@TestId TC411879| branch |

Scenario: UI verification Agent Portal - Inventory - Order - Acceptance Page
Given user is logged in agent portal as <type> user
When user navigates to order acceptance page
Then order acceptance page is loaded and master detail content title is Acceptance
And Acceptance page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378857| agency |
|@TestId TC411880| branch |

Scenario: UI verification Agent Portal - Inventory - Order - Status Page
Given user is logged in agent portal as <type> user
When user navigates to order status page
Then order status page is loaded and master detail content title is Status
And Status page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378858| agency |
|@TestId TC411881| branch |

Scenario: UI verification Agent Portal - Inventory - Stock Transfer - Intra Branch Page
Given user is logged in agent portal as <type> user
When user navigates to stock transfer intra branch page
Then stock transfer intra branch page is loaded and master detail content title is Intra Branch Details
And StockTransferIntraBranch page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378864| agency |
|@TestId TC411882| branch |

Scenario: UI verification Agent Portal - Inventory - Stock Transfer - Acceptance Page
Given user is logged in agent portal as <type> user
When user navigates to stock transfer acceptance page
Then stock transfer acceptance page is loaded and master detail content title is Acceptance
And StockTransferAcceptance page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378863| agency |
|@TestId TC411883| branch |

Scenario: UI verification Agent Portal - Inventory - Stock Return Page
Given user is logged in agent portal as <type> user
When user navigates to stock return page
Then stock return page is loaded and master detail content title is Stock Return
And StockReturn page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378862| agency |
|@TestId TC411884| branch |

Scenario: UI verification Agent Portal - Inventory - Inventory Status Page
Given user is logged in agent portal as <type> user
When user navigates to inventory status page
Then inventory status page is loaded and master detail content title is Inventory Status
And InventoryStatus page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378861| agency |
|@TestId TC411885| branch |