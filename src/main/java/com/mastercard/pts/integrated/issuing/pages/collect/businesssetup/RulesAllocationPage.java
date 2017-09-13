package com.mastercard.pts.integrated.issuing.pages.collect.businesssetup;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP, treeMenuItems = { BusinessSetupNav.L1_RULES,
		BusinessSetupNav.L2_RULES_ALLOCATION})
public class RulesAllocationPage extends AbstractBusinessPage {

	public void verifyUiOperationStatus() {
		verifyOperationsStatus("Allocation");
	}
}