package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_DEVICE_SALE_ISSUANCE, ServicesNav.L2_DEDUPE_REVERIFICATION_APPROVAL })
public class DedupeReverificationApprovalPage extends ServicesAbstractPage {

	@PageElement(findBy = FindBy.CSS, valueToFind = "#applicationNumber")
	private MCWebElement applicationNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#formNumber")
	private MCWebElement formNumberTxt;

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(applicationNumberTxt),
				WebElementUtils.visibilityOf(formNumberTxt));
	}
}