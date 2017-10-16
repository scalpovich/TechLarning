package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StatementMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StatementMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class StatementMessageFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createStatementMessagePlan(StatementMessagePlan stmnt, DeviceCreation deviceCreation) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		StatementMessagePlanPage stmntMsgPlanpage = navigator.navigateToPage(StatementMessagePlanPage.class);
		stmntMsgPlanpage.clickaddStatementMessagePlan();
		String stmntMessagePLan = stmntMsgPlanpage.statementMessagePlanDetails(deviceCreation);
		stmntMsgPlanpage.clickSaveButton();
		stmntMsgPlanpage.clickaddStatementMessageDetails();
		stmntMsgPlanpage.addStatementMsgDetails(stmnt);
		waitForPageToLoad(getFinder().getWebDriver());
		stmntMsgPlanpage.verifyStatementPlanSuccess();
		return stmntMessagePLan;

	}
}
