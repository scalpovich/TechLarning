package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBackReversal;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_CHARGEBACK,
		DisputeNav.L3_CHARGEBACK_REVERSAL })

public class ChargeBackReversalPage extends AbstractDisputePage {

	private static final Logger logger = LoggerFactory
			.getLogger(ChargeBackReversalPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchContainer:networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='reverseFee']/span/input")
	private MCWebElement reverFeeCbx;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='messageText']/span/textarea")
	private MCWebElement textTxtArea;

	public void verifyUiOperationStatus() {
		logger.info("Chargeback Reversal");
		verifySearchButton("Search");
	}

	public void triggerChargeBackReversal(ChargeBackReversal cb)
	{
		WebElementUtils.enterText(textTxtArea, cb.getText());
		WebElementUtils.checkCheckbox(reverFeeCbx, cb.isFees());
		clickSaveButton();
	}
	
	public void searchByArn(String arn)
	{
		searchByArn(arn, "View Search Result");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber));
	}
}
