package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.dispute.SecondChargeBack;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = {
		DisputeNav.L1_DISPUTE_ACTIVITY, DisputeNav.L2_SECOND_CHARGEBACK,
		DisputeNav.L3_SECOND_CHARGEBACK_NEW })
public class SecondChargeBackNewPage extends AbstractDisputePage {

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='amount']/span/input")
	private MCWebElement chargeBackAmountTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='reasonCode']/span/select")
	private MCWebElement reasonCodeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='documentationIndicator']/span/select")
	private MCWebElement documentationDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='messageText']/span/textarea")
	private MCWebElement textTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='chargeFees']/span/input")
	private MCWebElement feeCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='chargebackDateCheck']/span/input")
	private MCWebElement chargebackDateCheckCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='copyRequestCheck']/span/input")
	private MCWebElement copyRequestCheckCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='atmDocCheck']/span/input")
	private MCWebElement docReqCopyReqCbx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='sourceAmount']//span[@class='labeltextr']")
	private MCWebElement transactionAmountTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='settlementAmount']/span")
	private MCWebElement settlementAmountTxt;

	public void searchByArn(String arn) {
		searchByArn(arn, "View Search Result");
	}

	public BigDecimal getTransactionAmount() {
		return new BigDecimal(transactionAmountTxt.getText());
	}

	public BigDecimal getSettlementAmount() {
		return new BigDecimal(settlementAmountTxt.getText());
	}

	public BigDecimal getChargeBackAmount() {
		return getTransactionAmount().subtract(getSettlementAmount());
	}

	public void triggerSecondChargeBack(SecondChargeBack sb) {
		WebElementUtils.enterText(chargeBackAmountTxt, getChargeBackAmount());
		WebElementUtils.selectDropDownByVisibleText(reasonCodeDDwn,
				sb.getSecondChargeBackReasonCode());
		WebElementUtils.selectDropDownByVisibleText(documentationDDwn,
				sb.getDocumentation());
		WebElementUtils.checkCheckbox(feeCbx, sb.getFees());
		WebElementUtils.enterText(textTxt, sb.getText());
		pageScrollDown();
		WebElementUtils.checkCheckbox(chargebackDateCheckCbx,
				sb.isChargeBackDateGreater());
		WebElementUtils.checkCheckbox(copyRequestCheckCbx,
				sb.isCopyRequestRequired());
		WebElementUtils
				.checkCheckbox(docReqCopyReqCbx, sb.isDocumentRequired());
		clickSaveButton();
	}

	public void verifyUiOperationStatus() {
		verifyOperationStatus("Second Chargeback New");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(interDDwn),
				WebElementUtils.elementToBeClickable(transactionDateDpkr),
				WebElementUtils.elementToBeClickable(microfilmRefNumber),
				WebElementUtils.elementToBeClickable(cardNumber));
	}

}