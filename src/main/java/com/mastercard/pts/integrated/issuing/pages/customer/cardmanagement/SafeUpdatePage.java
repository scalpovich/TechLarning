package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_MASTERCARD,
		CardManagementNav.L3_SAFE_UPDATE })
public class SafeUpdatePage extends AbstractCardManagementPage2 {

	private static final Logger logger = LoggerFactory.getLogger(SafeUpdatePage.class);

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Safe Update");
		verifyUiOperation("Add Update");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(recordType),
				WebElementUtils.elementToBeClickable(microfilmRefNumberTxt),
				WebElementUtils.elementToBeClickable(sequenceNumberTxt),
				WebElementUtils.elementToBeClickable(fraudType),
				WebElementUtils.elementToBeClickable(subFraudType));
	}
}