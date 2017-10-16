package com.mastercard.pts.integrated.issuing.pages.collect.businesssetup;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.collect.AbstractCollectPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = BusinessSetupNav.TAB_BUSINESS_SETUP)
public class BusinessSetupHomePage extends AbstractCollectPage {

	@Override
	public void verifyUiOperationStatus() {
		verifyUiOperationStatus("Business Setup");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(heading), WebElementUtils.visibilityOf(body));
	}
}