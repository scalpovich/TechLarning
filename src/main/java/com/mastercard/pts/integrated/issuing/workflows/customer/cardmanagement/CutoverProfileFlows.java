package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutOverProfile;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CutoverProfilePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class CutoverProfileFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void CreateCutOverProfile(CutOverProfile cutover) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		CutoverProfilePage cutoverprofilepage = navigator.navigateToPage(CutoverProfilePage.class);
		cutoverprofilepage.ClickAddcutoverprofile();
		cutoverprofilepage.selectBusinessDate(cutover);
		cutoverprofilepage.selectCutoverHours(cutover);
		cutoverprofilepage.selectCutoverMinutes(cutover);
		cutoverprofilepage.clickSaveBtn();
	}
}
