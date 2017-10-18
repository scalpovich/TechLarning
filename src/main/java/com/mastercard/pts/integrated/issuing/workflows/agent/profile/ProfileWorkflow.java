package com.mastercard.pts.integrated.issuing.workflows.agent.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.agent.profile.ChangePasswordPage;
import com.mastercard.pts.integrated.issuing.pages.agent.profile.EntityDetailsPage;
import com.mastercard.pts.integrated.issuing.pages.agent.profile.ViewProfilePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class ProfileWorkflow {
	private ViewProfilePage vpage;
	private EntityDetailsPage epage;
	private ChangePasswordPage cpage;
	
	@Autowired
	private Navigator navigator;
	
	public void navigateToViewProfilePage() {
		vpage = navigator.navigateToPage(ViewProfilePage.class);
	}

	public String getViewProfileMasterDetailContentTitleText() {
		return vpage.getMasterDetailContentTitleText();
	}
	
	public void navigateToEntityDetailsPage() {
		epage = navigator.navigateToPage(EntityDetailsPage.class);
	}
	
	public String getEntityDetailsMasterDetailContentTitleText() {
		return epage.getMasterDetailContentTitleText();
	}
	
	public void navigateToChangePasswordPage() {
		cpage = navigator.navigateToPage(ChangePasswordPage.class);
	}
	
	public String getChangePasswordMasterDetailContentTitleText() {
		return cpage.getMasterDetailContentTitleText();
	}
}

