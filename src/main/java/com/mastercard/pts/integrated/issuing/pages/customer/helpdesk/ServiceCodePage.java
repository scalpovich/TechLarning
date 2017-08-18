package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = HelpdeskNav.TAB_HELPDESK, treeMenuItems = {
		HelpdeskNav.L1_SETUP,
		HelpdeskNav.L2_SERVICE_CODE
		})
public class ServiceCodePage extends AbstractModelPage{

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceCodePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement serviceCodeTxt;

	public void verifyUiOperationStatus() {
		logger.info("Service Code");
		verifyUiOperation("Add Service Code");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(serviceCodeTxt));
	}
}
