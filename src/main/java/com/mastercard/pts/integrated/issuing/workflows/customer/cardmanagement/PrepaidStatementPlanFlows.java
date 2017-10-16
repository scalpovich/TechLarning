package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PrepaidStatementPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PrepaidMessagePlanPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class PrepaidStatementPlanFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createPrepaidStatementPlan(PrepaidStatementPlan prepaidstmnt) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		PrepaidMessagePlanPage prepaidStmntPlanpage = navigator.navigateToPage(PrepaidMessagePlanPage.class);
		prepaidStmntPlanpage.clickaddPrepaidStatementPlan();
		String prepaidmsgplan = prepaidStmntPlanpage.addPrepaidStatementPlanDetails();
		prepaidStmntPlanpage.clickSaveButton();
		prepaidStmntPlanpage.clickaddPrepaidStatementSubDetails();
		prepaidStmntPlanpage.addpreapidMessageDetails(prepaidstmnt);

		return prepaidmsgplan;
	}

}
