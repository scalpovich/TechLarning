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
@Navigation(tabTitle = EnquiryNav.TAB_ENQUIRY, treeMenuItems = { EnquiryNav.L1_TRANSACTIONS })
public class TransactionsPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(TransactionsPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "fromDate")
	private MCWebElement fromDateDPkr;

	@PageElement(findBy = FindBy.ID, valueToFind = "toDate")
	private MCWebElement toDateDPkr;

	@PageElement(findBy = FindBy.ID, valueToFind = "optionFlag1")
	private MCWebElement optionFlag1Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "optionFlag0")
	private MCWebElement optionFlag0Rbtn;

	public void verifyUiOperationStatus() {
		logger.info("Transactions");
		verifyTitleCardHolderPortal("Transactions");
		verifyWalletDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(fromDateDPkr),
				WebElementUtils.visibilityOf(toDateDPkr), WebElementUtils.visibilityOf(optionFlag0Rbtn), WebElementUtils.visibilityOf(optionFlag1Rbtn));
	}
}
