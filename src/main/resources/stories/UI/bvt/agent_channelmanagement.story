Narrative:
In order to work on UI verification Agent Portal
As an Agent User
I want to validate channel management tab UI verification Agent Portal Pages Loaded based on roles Admin, Agency

Meta:
@StoryName S224290
@AgentBV

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - Create Page
Meta:
@TestId TC378822
Given user is logged in agent portal as admin user
When user navigates to administrator > user > create page
Then administrator > user > create page is loaded and master detail content title is Portal Admin Information
And AdministratorUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - View/Edit Page
Meta:
@TestId TC378824
Given user is logged in agent portal as admin user
When user navigates to administrator > user > view/edit page
Then administrator > user > view/edit page is loaded and master detail content title is Portal Admin User Information
And AdministratorUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - Reset/User Password Page
Meta:
@TestId TC378823
Given user is logged in agent portal as admin user
When user navigates to administrator > user > reset/user password page
Then administrator > user > reset/user password page is loaded and master detail content title is PortalAdmin User Information
And AdministratorUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Administrator - User - Active/Deactive User Page
Meta:
@TestId TC378821
Given user is logged in agent portal as admin user
When user navigates to administrator > user > active/deactive user page
Then administrator > user > active/deactive user page is loaded and master detail content title is Portal Admin User Information
And AdministratorUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - Create Page
Meta:
@TestId TC378826
Given user is logged in agent portal as admin user
When user navigates to agency > entity > create page
Then agency > entity > create page is loaded and master detail content title is Agency Information
And AgencyEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - View/Edit Page
Meta:
@TestId TC378827
Given user is logged in agent portal as admin user
When user navigates to agency > entity > view/edit page
Then agency > entity > view/edit page is loaded and master detail content title is Agency Information
And AgencyEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - Active/Suspend Agency Page
Meta:
@TestId TC378825
Given user is logged in agent portal as admin user
When user navigates to agency > entity > active/suspend agency page
Then agency > entity > active/suspend agency page is loaded and master detail content title is Agency Information
And AgencyEntityActivateSuspendAgency page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Agency - Entity - Assign Programs Page
Meta:
@TestId TC378840
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
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378829| admin  |
|@TestId TC411839| agency |

Scenario: UI verification Agent Portal - Channel Management - Agency - User - View/Edit Page
Given user is logged in agent portal as <type> user
When user navigates to agency > user > view/edit page
Then agency > user > view/edit page is loaded and master detail content title is Agency User Information
And AgencyUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378831| admin  |
|@TestId TC411840| agency |

Scenario: UI verification Agent Portal - Channel Management - Agency - User - Reset/User Password Page
Meta:
@TestId TC378830
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
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378828| admin  |
|@TestId TC411841| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - Create Page
Given user is logged in agent portal as <type> user
When user navigates to branch > entity > create page
Then branch > entity > create page is loaded and master detail content title is Branch Information
And BranchEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378844| admin  |
|@TestId TC411842| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - View/Edit Page
Given user is logged in agent portal as <type> user
When user navigates to branch > entity > view/edit page
Then branch > entity > view/edit page is loaded and master detail content title is Branch Information
And BranchEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378845| admin  |
|@TestId TC411843| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - Active/Suspend Branch Page
Given user is logged in agent portal as <type> user
When user navigates to branch > entity > active/suspend branch page
Then branch > entity > active/suspend branch page is loaded and master detail content title is Branch Information
And BranchEntityActivateSuspendBranch page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378843| admin  |
|@TestId TC411845| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - Entity - Assign Programs Page
Given user is logged in agent portal as <type> user
When user navigates to branch > entity > assign programs page
Then branch > entity > assign programs page is loaded and master detail content title is Branch Information
And AssignProgramsBranch page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378842| admin  |
|@TestId TC411844| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - Create Page
Given user is logged in agent portal as <type> user
When user navigates to branch > user > create page
Then branch > user > create page is loaded and master detail content title is Branch Information
And BranchUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378847| admin  |
|@TestId TC378847| agency |
|@TestId TC411847| branch |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - View/Edit Page
Given user is logged in agent portal as <type> user
When user navigates to branch > user > view/Edit page
Then branch > user > view/edit page is loaded and master detail content title is Branch User Information
And BranchUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378849| admin  |
|@TestId TC411848| agency |
|@TestId TC411849| branch |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - Reset/User Password Page
Given user is logged in agent portal as <type> user
When user navigates to branch > user > reset/user password page
Then branch > user > reset/user password page is loaded and master detail content title is Branch User Information
And BranchUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378848| admin  |
|@TestId TC411850| agency |

Scenario: UI verification Agent Portal - Channel Management - Branch - User - Active/Deactive User Page
Given user is logged in agent portal as <type> user
When user navigates to branch > user > active/deactive user page
Then branch > user > active/deative user page is loaded and master detail content title is Branch User Information
And BranchUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378846| admin  |
|@TestId TC411851| agency |
|@TestId TC411852| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - Create Page
Given user is logged in agent portal as <type> user
When user navigates to agent > entity > create page
Then agent > entity > create page is loaded and master detail content title is Agent Information
And AgentEntityCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378833| admin  |
|@TestId TC411853| agency |
|@TestId TC411854| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - View/Edit Page
Given user is logged in agent portal as <type> user
When user navigates to agent > entity > view/edit page
Then agent > entity > view/edit page is loaded and master detail content title is Agent Information
And AgentEntityViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378834| admin  |
|@TestId TC411855| agency |
|@TestId TC411856| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - Active/Suspend Branch Page
Given user is logged in agent portal as <type> user
When user navigates to agent > entity > active/suspend branch page
Then agent > entity > active/suspend page is loaded and master detail content title is Agent Information
And AgentEntityActiveSuspendAgent page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378832| admin  |
|@TestId TC411857| agency |
|@TestId TC411858| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - Entity - Assign Programs Page
Given user is logged in agent portal as <type> user
When user navigates to agent > entity > assign programs page
Then agent > entity > assign programs page is loaded and master detail content title is Agent Information
And AssignProgramsAgent page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378841| admin  |
|@TestId TC411859| agency |
|@TestId TC411860| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - Create Page
Given user is logged in agent portal as <type> user
When user navigates to agent > user > create page
Then agent > user > create page is loaded and master detail content title is Agent Information
And AgentUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378836| admin  |
|@TestId TC411861| agency |
|@TestId TC411862| branch |
|@TestId TC411863| agent |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - View/Edit Page
Given user is logged in agent portal as <type> user
When user navigates to agent > user > view/edit page
Then agent > user > view/edit page is loaded and master detail content title is Agent User Information
And AgentUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378838| admin  |
|@TestId TC411864| agency |
|@TestId TC411865| branch |
|@TestId TC411866| agent |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - Reset/User Password Page
Given user is logged in agent portal as <type> user
When user navigates to agent > user > reset/user password page
Then agent > user > reset/user password page is loaded and master detail content title is Agent User Information
And AgentUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378837| admin  |
|@TestId TC411867| agency |
|@TestId TC411868| branch |

Scenario: UI verification Agent Portal - Channel Management - Agent - User - Active/Deactive User Page
Given user is logged in agent portal as <type> user
When user navigates to agent > user > active/deactive user page
Then agent > user > active/deactive user page is loaded and master detail content title is Agent User Information
And AgentUserActiveDeactiveUser page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378835| admin  |
|@TestId TC411869| agency |
|@TestId TC411870| branch |
|@TestId TC411871| agent |

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - Create Page
Meta:
@TestId TC378851
Given user is logged in agent portal as admin user
When user navigates to corporate > user > create page
Then corporate > user > create page is loaded and master detail content title is Corporate User Information
And CorporateUserCreate page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - View/Edit Page
Meta:
@TestId TC378853
Given user is logged in agent portal as admin user
When user navigates to corporate > user > view/edit page
Then corporate > user > view/edit page is loaded and master detail content title is Corporate User Information
And CorporateUserViewEdit page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - Reset/User Password Page
Meta:
@TestId TC378852
Given user is logged in agent portal as admin user
When user navigates to corporate > user > reset/user password page
Then corporate > user > view/edit page is loaded and master detail content title is Corporate User Information
And CorporateUserResetUserPassword page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Scenario: UI verification Agent Portal - Channel Management - Corporate - User - Active/Deactive User Page
Meta:
@TestId TC378850
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
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378854| admin  |
|@TestId TC411872| agency |
|@TestId TC411873| branch |
|@TestId TC411874| agent |

Scenario: UI verification Agent Portal - Channel Management - Roles & Previleges - Assign Privileges Page
Given user is logged in agent portal as <type> user
When user navigates to roles and privileges > assign privileges page
Then assign privileges page is loaded and master detail content title is Role Information
And AssignPrivileges page of channelmanagement tab is rendered correctly
And user sign out from agent portal

Examples:
!-- {metaByRow=true}
|Meta:| type   |
|@TestId TC378839| admin  |
|@TestId TC411875| agency |
|@TestId TC411876| branch |
|@TestId TC411877| agent |

Scenario: UI verification Agent Portal - Channel Management - Event Alerts Page
Meta:
@TestId TC378855
Given user is logged in agent portal as admin user
When user navigates to event alerts page
Then event alerts page is loaded and master detail content title is Event Alerts
And EventAlerts page of channelmanagement tab is rendered correctly
And user sign out from agent portal