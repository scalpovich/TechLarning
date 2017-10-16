package com.mastercard.pts.integrated.issuing.workflows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.MemberFundCollectionPage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;

@Component
public class RupayMemberFundCollectionFlows {

	@Autowired
	MenuSubMenuPage menusubmenuPage;

	@Autowired
	MemberFundCollectionPage memberFundPage;

	public void addMemberFundCollection() {
		menusubmenuPage.waitForElementVisible(menusubmenuPage.getCardManagement());
		menusubmenuPage.clickMenuSubOption(menusubmenuPage.getActivity(), menusubmenuPage.getActivityRupay());
		menusubmenuPage.getRupayMemberFudCollection().click();
		memberFundPage.addMemberFundCollectionDisbursement();

	}
}
	