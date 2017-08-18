Smoke Testing of agent portal inventory tab

Narrative:
In order to work on Agent Portal
As an Agent User
I want to validate inventory tab Agent Portal Pages Loaded based on roles Branch, Agency

Meta:
@StoryName S224290
@SmokeTest
@AgentSmoke

Scenario: Agent Portal - Inventory - Order - Cancellation Page

Given user is logged in agent portal as <type> user
When user navigates to order cancellation page
Then order cancellation page is loaded and master detail content title is Cancellation
And OrderCancellation page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Order - Order Page

Given user is logged in agent portal as <type> user
When user navigates to order page
Then order page is loaded and master detail content title is Order
And Order page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Order - Acceptance Page

Given user is logged in agent portal as <type> user
When user navigates to order acceptance page
Then order acceptance page is loaded and master detail content title is Acceptance
And Acceptance page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Order - Status Page

Given user is logged in agent portal as <type> user
When user navigates to order status page
Then order status page is loaded and master detail content title is Status
And Status page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Stock Transfer - Intra Branch Page

Given user is logged in agent portal as <type> user
When user navigates to stock transfer intra branch page
Then stock transfer intra branch page is loaded and master detail content title is Intra Branch Details
And StockTransferIntraBranch page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Stock Transfer - Acceptance Page

Given user is logged in agent portal as <type> user
When user navigates to stock transfer acceptance page
Then stock transfer acceptance page is loaded and master detail content title is Acceptance
And StockTransferAcceptance page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Stock Return Page

Given user is logged in agent portal as <type> user
When user navigates to stock return page
Then stock return page is loaded and master detail content title is Stock Return
And StockReturn page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |

Scenario: Agent Portal - Inventory - Inventory Status Page

Given user is logged in agent portal as <type> user
When user navigates to inventory status page
Then inventory status page is loaded and master detail content title is Inventory Status
And InventoryStatus page of inventory tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| agency |
| branch |