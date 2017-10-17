package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_ACTIVITY_APPLICATION,
		CardManagementNav.L3_INCOMPLETE_APPLICATION })
public class IncompleteApplicationPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory.getLogger(IncompleteApplicationPage.class);

@Override
	public void verifyUiOperationStatus() {
		logger.info("Incomplete Application");
		verifySearchButton("Search");
	}
}
