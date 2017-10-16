package com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = VirtualCardNav.TAB_VIRTUAL_CARD, treeMenuItems = { VirtualCardNav.L1_REQUEST_FOR_LIMITED_VALIDITY_VIRTUAL_CARD })
public class RequestForLimitedValidityVirtualCardPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(RequestForLimitedValidityVirtualCardPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;




}
