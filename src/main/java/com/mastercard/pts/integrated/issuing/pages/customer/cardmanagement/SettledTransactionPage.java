package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_SEARCH, CardManagementNav.L2_TRANSACTION,
		CardManagementNav.L3_SETTLED_TRANSACTION})
public class SettledTransactionPage extends AbstractCardManagementPage2 {
	
	@Override
	public void verifyUiOperationStatus() {
		verifyUiOperationStatus("Settled Transaction");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(microfilmRefNumberTxt),
				WebElementUtils.elementToBeClickable(cardNumberTxt),
				WebElementUtils.elementToBeClickable(branchDDwn),
				WebElementUtils.elementToBeClickable(sequenceNumberTxt)
				);
	}
}