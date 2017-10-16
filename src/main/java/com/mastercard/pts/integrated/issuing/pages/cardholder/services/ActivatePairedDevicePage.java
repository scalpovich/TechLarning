package com.mastercard.pts.integrated.issuing.pages.cardholder.services;


import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_ACTIVATE_PAIRED_CARD })
public class ActivatePairedDevicePage extends AbstractBasePage {

	@PageElement(findBy = FindBy.ID, valueToFind = "reasonCode")
	private MCWebElement replacementReasonDDwn;

	
}
