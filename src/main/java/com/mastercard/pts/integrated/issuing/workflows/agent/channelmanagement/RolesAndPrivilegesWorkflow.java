package com.mastercard.pts.integrated.issuing.workflows.agent.channelmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.AssignPrivilegesPage;
import com.mastercard.pts.integrated.issuing.pages.agent.channelmanagement.CreateRolePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class RolesAndPrivilegesWorkflow {
	private CreateRolePage cpage;
	private AssignPrivilegesPage apage;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToCreateRolePage() {
		cpage = navigator.navigateToPage(CreateRolePage.class);
	}

	public String getCreateRoleMasterDetailContentTitleText() {
		return cpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToAssignPrivilegesPage() {
		apage = navigator.navigateToPage(AssignPrivilegesPage.class);
	}

	public String getAssignPrivilegesMasterDetailContentTitleText() {
		return apage.getMasterDetailContentTitleText();
	}
	
}