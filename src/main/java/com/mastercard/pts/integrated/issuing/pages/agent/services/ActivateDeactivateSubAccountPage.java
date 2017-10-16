package com.mastercard.pts.integrated.issuing.pages.agent.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_TRAVEL_CARD_CURRENCY_MANAGEMENT,
		ServicesNav.L2_ACTIVATE_DEACTIVATE_SUBACCOUNT })
public class ActivateDeactivateSubAccountPage extends ServicesAbstractPage {
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(cardNumberTxt),
				WebElementUtils.visibilityOf(walletNumberDDwn));
	}
}