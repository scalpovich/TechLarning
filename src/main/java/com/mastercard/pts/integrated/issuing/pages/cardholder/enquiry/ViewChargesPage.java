package com.mastercard.pts.integrated.issuing.pages.cardholder.enquiry;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.EnquiryNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = EnquiryNav.TAB_ENQUIRY, treeMenuItems = { EnquiryNav.L1_VIEW_CHARGES })
public class ViewChargesPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(ViewChargesPage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[contains(text(), 'Available Balance')]/following-sibling::td[1]")
	private MCWebElement availableBalanceLbl;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionType")
	private MCWebElement transactionTypeDDwn;

	@PageElement(findBy = FindBy.ID, valueToFind = "transactionAmount")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "selectedTxnCurrency")
	private MCWebElement selectedTxnCurrencyDDwn;

	public void verifyUiOperationStatus() {
		logger.info("View Charges");
		verifyTitleCardHolderPortal("View Charges");
		verifyWalletDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(availableBalanceLbl),
				WebElementUtils.visibilityOf(transactionTypeDDwn), WebElementUtils.visibilityOf(transactionAmountTxt),
				WebElementUtils.visibilityOf(selectedTxnCurrencyDDwn));
	}
}
