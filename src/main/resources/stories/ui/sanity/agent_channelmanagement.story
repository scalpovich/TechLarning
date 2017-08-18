Smoke Testing of agent portal channelmanagement tab

Narrative:
In order to work on Agent Portal
As an Agent User
I want to validate channel management tab Agent Portal Pages Loaded based on roles Admin, Agency

Meta:
@StoryName S224290
@SmokeTest
@AgentSmoke

Scenario: Agent Portal - Channel Management - Administrator - User - Create Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > create page
Then administrator > user > create page is loaded and master detail content title is Portal Admin Information
And AdministratorUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Administrator - User - View/Edit Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > view/edit page
Then administrator > user > view/edit page is loaded and master detail content title is Portal Admin User Information
And AdministratorUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Administrator - User - Reset/User Password Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > reset/user password page
Then administrator > user > reset/user password page is loaded and master detail content title is PortalAdmin User Information
And AdministratorUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Administrator - User - Active/Deactive User Page

Given user is logged in agent portal as admin user
When user navigates to administrator > user > active/deactive user page
Then administrator > user > active/deactive user page is loaded and master detail content title is Portal Admin User Information
And AdministratorUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Agency - Entity - Create Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > create page
Then agency > entity > create page is loaded and master detail content title is Agency Information
And AgencyEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Agency - Entity - View/Edit Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > view/edit page
Then agency > entity > view/edit page is loaded and master detail content title is Agency Information
And AgencyEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Agency - Entity - Active/Suspend Agency Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > active/suspend agency page
Then agency > entity > active/suspend agency page is loaded and master detail content title is Agency Information
And AgencyEntityActivateSuspendAgency page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Agency - Entity - Assign Programs Page

Given user is logged in agent portal as admin user
When user navigates to agency > entity > assign programs page
Then agency > entity > assign programs page is loaded and master detail content title is Agency Information
And AssignProgramsAgency page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Agency - User - Create Page

Given user is logged in agent portal as <type> user
When user navigates to agency > user > create page
Then agency > user > create page is loaded and master detail content title is Agency Information
And AgencyUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Agency - User - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to agency > user > view/edit page
Then agency > user > view/edit page is loaded and master detail content title is Agency User Information
And AgencyUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Agency - User - Reset/User Password Page

Given user is logged in agent portal as admin user
When user navigates to agency > user > reset/user password page
Then agency > user > reset/user password page is loaded and master detail content title is Agency User Information
And AgencyUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Agency - User - Active/Deactive User Page

Given user is logged in agent portal as <type> user
When user navigates to agency > user > active/deactive user page
Then agency > user > active/deactive user page is loaded and master detail content title is Agency User Information
And AgencyUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Branch - Entity - Create Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > create page
Then branch > entity > create page is loaded and master detail content title is Branch Information
And BranchEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Branch - Entity - View/Edit Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > view/edit page
Then branch > entity > view/edit page is loaded and master detail content title is Branch Information
And BranchEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Branch - Entity - Active/Suspend Branch Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > active/suspend branch page
Then branch > entity > active/suspend branch page is loaded and master detail content title is Branch Information
And BranchEntityActivateSuspendBranch page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Branch - Entity - Assign Programs Page

Given user is logged in agent portal as <type> user
When user navigates to branch > entity > assign programs page
Then branch > entity > assign programs page is loaded and master detail content title is Branch Information
And AssignProgramsBranch page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Branch - User - Create Page

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

Scenario: Agent Portal - Channel Management - Branch - User - View/Edit Page

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

Scenario: Agent Portal - Channel Management - Branch - User - Reset/User Password Page

Given user is logged in agent portal as <type> user
When user navigates to branch > user > reset/user password page
Then branch > user > reset/user password page is loaded and master detail content title is Branch User Information
And BranchUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
| type   |
| admin  |
| agency |

Scenario: Agent Portal - Channel Management - Branch - User - Active/Deactive User Page

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

Scenario: Agent Portal - Channel Management - Agent - Entity - Create Page

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

Scenario: Agent Portal - Channel Management - Agent - Entity - View/Edit Page

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

Scenario: Agent Portal - Channel Management - Agent - Entity - Active/Suspend Branch Page

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

Scenario: Agent Portal - Channel Management - Agent - Entity - Assign Programs Page

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

Scenario: Agent Portal - Channel Management - Agent - User - Create Page

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

Scenario: Agent Portal - Channel Management - Agent - User - View/Edit Page

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

Scenario: Agent Portal - Channel Management - Agent - User - Reset/User Password Page

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

Scenario: Agent Portal - Channel Management - Agent - User - Active/Deactive User Page

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

Scenario: Agent Portal - Channel Management - Corporate - User - Create Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > create page
Then corporate > user > create page is loaded and master detail content title is Corporate User Information
And CorporateUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Corporate - User - View/Edit Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > view/edit page
Then corporate > user > view/edit page is loaded and master detail content title is Corporate User Information
And CorporateUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Corporate - User - Reset/User Password Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > reset/user password page
Then corporate > user > view/edit page is loaded and master detail content title is Corporate User Information
And CorporateUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Corporate - User - Active/Deactive User Page

Given user is logged in agent portal as admin user
When user navigates to corporate > user > active/deactive user page
Then corporate > user > active/deative user page is loaded and master detail content title is Corporate User Information
And CorporateUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: Agent Portal - Channel Management - Roles & Privileges - Create Role Page

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

Scenario: Agent Portal - Channel Management - Roles & Previleges - Assign Privileges Page

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

Scenario: Agent Portal - Channel Management - Event Alerts Page

Given user is logged in agent portal as admin user
When user navigates to event alerts page
Then event alerts page is loaded and master detail content title is Event Alerts
And EventAlerts page of channelmanagement tab is rendered correctly
And user sign out from agent portal