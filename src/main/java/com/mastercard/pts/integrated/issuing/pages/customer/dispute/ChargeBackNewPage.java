package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.ChargeBack;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_CHARGEBACK,
		DisputeNav.L3_CHARGEBACK_NEW })
public class ChargeBackNewPage extends AbstractDisputePage {

	private static final Logger logger = LoggerFactory
			.getLogger(ChargeBackNewPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchContainer:networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=microfilmRefNumber]")
	private MCWebElement microfilmRefNumber;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='amount']/span/input")
	private MCWebElement chargeBackAmountTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='reasonCode']/span/select")
	private MCWebElement reasonCodeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='documentationIndicator']/span/select")
	private MCWebElement documentationDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='messageText']/span/textarea")
	private MCWebElement textTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='chargeFees']/span/input")
	private MCWebElement feeCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='chargebackDateCheck']/span/input")
	private MCWebElement chargebackDateCheckCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='copyRequestCheck']/span/input")
	private MCWebElement copyRequestCheckCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='atmDocCheck']/span/input")
	private  MCWebElement docReqCopyReqCbx;
	
	public void searchByArn(String arn)
	{
		searchByArn(arn, "View Search Result");
	}

	public void triggerChargeBack(ChargeBack cb) {
		WebElementUtils
				.enterText(chargeBackAmountTxt, cb.getChargeBackAmount());
		WebElementUtils.selectDropDownByVisibleText(reasonCodeDwn,
				cb.getReasonCode());
		WebElementUtils.selectDropDownByVisibleText(documentationDwn,
				cb.getDocumentation());
		WebElementUtils.checkCheckbox(feeCbx, cb.isFees());
		WebElementUtils.enterText(textTxt, cb.getText());
		WebElementUtils.checkCheckbox(chargebackDateCheckCbx,
				cb.isChargeBackDateGrater());
		WebElementUtils.checkCheckbox(copyRequestCheckCbx,
				cb.isCopyRequestRequired());
		WebElementUtils
				.checkCheckbox(docReqCopyReqCbx, cb.isDocumentRequired());
		clickSaveButton();
	}

	public void verifyUiOperationStatus() {
		logger.info("Chargeback New");
		verifySearchButton("Search");
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
