package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.administration.ScreenLevelPrivilegesPage;

@Component
public class ScreenLevelPrivilegesWorkflow {

	@Autowired
	ScreenLevelPrivilegesPage screenLevelPrivilegesPage;

	public void provideScreenLevelPrivilegesFlows(String entityType) {
		screenLevelPrivilegesPage.assignScreenLevelPrivileges(entityType);
	}

}
