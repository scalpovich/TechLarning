package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

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
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_SETUP, DisputeNav.L2_DISPUTE_REASON_CODE,
		DisputeNav.L3_ARBITRATION_TYPE})
public class ArbitrationTypePage extends AbstractDisputePage {
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	protected MCWebElement arbitrationTypeDDwn;

	public void verifyUiOperationStatus() {
		verifyOperationStatus("Arbitration Type");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDDwn),
				WebElementUtils.elementToBeClickable(arbitrationTypeDDwn));
	}
}
