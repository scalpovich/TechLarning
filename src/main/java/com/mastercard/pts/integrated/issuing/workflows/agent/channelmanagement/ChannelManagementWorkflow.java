package com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement;

import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AdministratorUserActiveDeactiveUserPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AdministratorUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AdministratorUserResetUserPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AdministratorUserViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyEntityActivateSuspendAgencyPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyEntityCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyEntityViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyUserActiveDeactiveUserPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyUserResetUserPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgencyUserViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentEntityActiveSuspendAgentPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentEntityCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentEntityViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentUserActiveDeactiveUserPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentUserResetUserPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AgentUserViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignProgramsAgencyPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignProgramsAgentPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignProgramsBranchPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchEntityActivateSuspendBranchPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchEntityCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchEntityViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchUserActiveDeactiveUserPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchUserResetUserPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.BranchUserViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.CorporateUserActiveDeactiveUserPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.CorporateUserCreatePage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.CorporateUserResetUserPasswordPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.CorporateUserViewEditPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class ChannelManagementWorkflow {
	private AdministratorUserActiveDeactiveUserPage auadupage;
	private AdministratorUserCreatePage aucpage;
	private AdministratorUserResetUserPasswordPage auruppage;
	private AdministratorUserViewEditPage auvepage;
	
	private AgencyEntityActivateSuspendAgencyPage ayeasapage;
	private AgencyEntityCreatePage ayecpage;
	private AgencyEntityViewEditPage ayevepage;
	private AgencyUserActiveDeactiveUserPage ayuadupage;
	private AgencyUserCreatePage ayucpage;
	private AgencyUserResetUserPasswordPage ayurppage;
	private AgencyUserViewEditPage ayuvepage;
	
	private AgentEntityActiveSuspendAgentPage ateasapage;
	private AgentEntityCreatePage atecpage;
	private AgentEntityViewEditPage atevepage;
	private AgentUserActiveDeactiveUserPage atuadupage;
	private AgentUserCreatePage atucpage;
	private AgentUserResetUserPasswordPage aturppage;
	private AgentUserViewEditPage atuvepage;
	
	private BranchEntityActivateSuspendBranchPage beasapage;
	private BranchEntityCreatePage becpage;
	private BranchEntityViewEditPage bevepage;
	private BranchUserActiveDeactiveUserPage buadupage;
	private BranchUserCreatePage bucpage;
	private BranchUserResetUserPasswordPage burppage;
	private BranchUserViewEditPage buvepage;
	
	private CorporateUserActiveDeactiveUserPage cuadupage;
	private CorporateUserCreatePage cucpage;
	private CorporateUserResetUserPasswordPage curppage;
	private CorporateUserViewEditPage cuvepage;
	
	private AssignProgramsAgencyPage apaypage;
	private AssignProgramsAgentPage apatpage;
	private AssignProgramsBranchPage apbpage;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToAdministratorUserActiveDeactiveUserPage() {
		auadupage = navigator.navigateToPage(AdministratorUserActiveDeactiveUserPage.class);
	}

	public String getAdministratorUserActiveDeactiveUserMasterDetailContentTitleText() {
		return auadupage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAdministratorUserCreatePage() {
		aucpage = navigator.navigateToPage(AdministratorUserCreatePage.class);
	}

	public String getAdministratorUserCreateMasterDetailContentTitleText() {
		return aucpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAdministratorUserViewEditPage() {
		auvepage = navigator.navigateToPage(AdministratorUserViewEditPage.class);
	}

	public String getAdministratorUserViewEditDetailContentTitleText() {
		return auvepage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAdministratorUserResetUserPasswordPage() {
		auruppage = navigator.navigateToPage(AdministratorUserResetUserPasswordPage.class);
	}

	public String getAdministratorUserResetUserPasswordDetailContentTitleText() {
		return auruppage.getMasterDetailContentTitleText();
	}

	
	//agency
	public void navigateToAgencyEntityActivateSuspendAgencyPage() {
		ayeasapage = navigator.navigateToPage(AgencyEntityActivateSuspendAgencyPage.class);
	}

	public String getAgencyEntityActivateSuspendAgencyDetailContentTitleText() {
		return ayeasapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgencyEntityCreatePage() {
		ayecpage = navigator.navigateToPage(AgencyEntityCreatePage.class);
	}

	public String getAgencyEntityCreateDetailContentTitleText() {
		return ayecpage.getMasterDetailContentTitleText();
	}

	public void navigateToAgencyEntityViewEditPage() {
		ayevepage = navigator.navigateToPage(AgencyEntityViewEditPage.class);
	}

	public String getAgencyEntityViewEditDetailContentTitleText() {
		return ayevepage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgencyUserActiveDeactiveUserPage() {
		ayuadupage = navigator.navigateToPage(AgencyUserActiveDeactiveUserPage.class);
	}

	public String getAgencyUserActiveDeactiveUserDetailContentTitleText() {
		return ayuadupage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgencyUserCreatePage() {
		ayucpage = navigator.navigateToPage(AgencyUserCreatePage.class);
	}

	public String getAgencyUserCreateDetailContentTitleText() {
		return ayucpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgencyUserResetUserPasswordPage() {
		ayurppage = navigator.navigateToPage(AgencyUserResetUserPasswordPage.class);
	}

	public String getAgencyUserResetUserPasswordDetailContentTitleText() {
		return ayurppage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgencyUserViewEditPage() {
		ayuvepage = navigator.navigateToPage(AgencyUserViewEditPage.class);
	}

	public String getAgencyUserViewEditDetailContentTitleText() {
		return ayuvepage.getMasterDetailContentTitleText();
	}
	
	//branch
	public void navigateToBranchEntityActivateSuspendBranchPage() {
		beasapage = navigator.navigateToPage(BranchEntityActivateSuspendBranchPage.class);
	}

	public String getBranchEntityActivateSuspendBranchDetailContentTitleText() {
		return beasapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBranchEntityCreatePage() {
		becpage = navigator.navigateToPage(BranchEntityCreatePage.class);
	}

	public String getBranchEntityCreateDetailContentTitleText() {
		return becpage.getMasterDetailContentTitleText();
	}

	public void navigateToBranchEntityViewEditPage() {
		bevepage = navigator.navigateToPage(BranchEntityViewEditPage.class);
	}

	public String getBranchEntityViewEditDetailContentTitleText() {
		return bevepage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBranchUserActiveDeactiveUserPage() {
		buadupage = navigator.navigateToPage(BranchUserActiveDeactiveUserPage.class);
	}

	public String getBranchUserActiveDeactiveUserDetailContentTitleText() {
		return buadupage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBranchUserCreatePage() {
		bucpage = navigator.navigateToPage(BranchUserCreatePage.class);
	}

	public String getBranchUserCreateDetailContentTitleText() {
		return bucpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBranchUserResetUserPasswordPage() {
		burppage = navigator.navigateToPage(BranchUserResetUserPasswordPage.class);
	}

	public String getBranchUserResetUserPasswordDetailContentTitleText() {
		return burppage.getMasterDetailContentTitleText();
	}
	
	public void navigateToBranchUserViewEditPage() {
		buvepage = navigator.navigateToPage(BranchUserViewEditPage.class);
	}

	public String getBranchUserViewEditDetailContentTitleText() {
		return buvepage.getMasterDetailContentTitleText();
	}
	//agent
	public void navigateToAgentEntityActiveSuspendAgentPage() {
		ateasapage = navigator.navigateToPage(AgentEntityActiveSuspendAgentPage.class);
	}

	public String getAgentEntityActivateSuspendAgentDetailContentTitleText() {
		return ateasapage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgentEntityCreatePage() {
		atecpage = navigator.navigateToPage(AgentEntityCreatePage.class);
	}

	public String getAgentEntityCreateDetailContentTitleText() {
		return atecpage.getMasterDetailContentTitleText();
	}

	public void navigateToAgentEntityViewEditPage() {
		atevepage = navigator.navigateToPage(AgentEntityViewEditPage.class);
	}

	public String getAgentEntityViewEditDetailContentTitleText() {
		return atevepage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgentUserActiveDeactiveUserPage() {
		atuadupage = navigator.navigateToPage(AgentUserActiveDeactiveUserPage.class);
	}

	public String getAgentUserActiveDeactiveUserDetailContentTitleText() {
		return atuadupage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgentUserCreatePage() {
		atucpage = navigator.navigateToPage(AgentUserCreatePage.class);
	}

	public String getAgentUserCreateDetailContentTitleText() {
		return atucpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgentUserResetUserPasswordPage() {
		aturppage = navigator.navigateToPage(AgentUserResetUserPasswordPage.class);
	}

	public String getAgentUserResetUserPasswordDetailContentTitleText() {
		return aturppage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAgentUserViewEditPage() {
		atuvepage = navigator.navigateToPage(AgentUserViewEditPage.class);
	}

	public String getAgentUserViewEditDetailContentTitleText() {
		return atuvepage.getMasterDetailContentTitleText();
	}

	//corporate
	public void navigateToCorporateUserActiveDeactiveUserPage() {
		cuadupage = navigator.navigateToPage(CorporateUserActiveDeactiveUserPage.class);
	}

	public String getCorporateUserActiveDeactiveUserDetailContentTitleText() {
		return cuadupage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCorporateUserCreatePage() {
		cucpage = navigator.navigateToPage(CorporateUserCreatePage.class);
	}

	public String getCorporateUserCreateDetailContentTitleText() {
		return cucpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCorporateUserResetUserPasswordPage() {
		curppage = navigator.navigateToPage(CorporateUserResetUserPasswordPage.class);
	}

	public String getCorporateUserResetUserPasswordDetailContentTitleText() {
		return curppage.getMasterDetailContentTitleText();
	}
	
	public void navigateToCorporateUserViewEditPage() {
		cuvepage = navigator.navigateToPage(CorporateUserViewEditPage.class);
	}

	public String getCorporateUserViewEditDetailContentTitleText() {
		return cuvepage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAssignProgramsAgencyPage() {
		apaypage = navigator.navigateToPage(AssignProgramsAgencyPage.class);
	}

	public String getAssignProgramsAgencyDetailContentTitleText() {
		return apaypage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAssignProgramsAgentPage() {
		apatpage = navigator.navigateToPage(AssignProgramsAgentPage.class);
	}
	
	//assign programs
	public String getAssignProgramsAgentDetailContentTitleText() {
		return apatpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAssignProgramsBranchPage() {
		apbpage = navigator.navigateToPage(AssignProgramsBranchPage.class);
	}

	public String getAssignProgramsBranchDetailContentTitleText() {
		return apbpage.getMasterDetailContentTitleText();
	}
	
	
}

