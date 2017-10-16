package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_INTERNATIONAL_USE_ACTIVATION })
public class InternationalUseActivationPage extends AbstractBasePage {

	@PageElement(findBy = FindBy.ID, valueToFind = "IntUseInput1")
	private MCWebElement intUseInput1Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "IntUseInput0")
	private MCWebElement intUseInput0Rbtn;
	

	

}
