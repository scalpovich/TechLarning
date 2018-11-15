package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LoanPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionSearchDetails;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_LOAN,
		CardManagementNav.L3_LOAN_APPROVAL_RETAIL_TRANSACTION_TO_LOAN })
public class LoanApprovalRetailTransactionToLoanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(LoanApprovalRetailTransactionToLoanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=cardNumber]")
	private MCWebElement cardNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement loanPlanDdwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Calculate EMI']")
	private MCWebElement calculateEMIBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value= 'Sanction']")
	private MCWebElement sanctionBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='EMI :']/../following-sibling::td[1]/span/input")
	private MCWebElement emiLbl;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='Processing Fee :']/../following-sibling::td[1]/span/input")
	private MCWebElement processingFeeLbl;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td/span[text()='Moratorium Loan :']/../following-sibling::td[1]/span/input")
	private MCWebElement moratoriumLoanLbl;
	
	public void verifyUiOperationStatus() {
		logger.info("Loan Approval Retail Transaction to Loan");
		verifySearchButton("Search");
	}

	public LoanDetails retailTransactionToLoanFromLoanScreen(LoanPlan loanPlan, Device device, String arn) {
		WebElementUtils.enterText(cardNumber, device.getDeviceNumber());
		logger.info(loanPlan.getLoanPlanCode());
		WebElementUtils.selectDropDownByVisibleText(loanPlanDdwn, loanPlan.getLoanPlanDescription() + " " + "[" + loanPlan.getLoanPlanCode() + "]");
		clickSearchButton();
		return sanctionLoanFromLoanScreen(arn);

	}

	public LoanDetails sanctionLoanFromLoanScreen(String arn) {
		LoanDetails loanDetails = new LoanDetails();
		clickAddNewButton();
		runWithinPopup("Retail Transaction To Loan ", () -> {
			String checkBox = String.format("//td//span[text()='%s']/../../following-sibling::td[7]", arn);
			String tranAmountLbl = String.format("//td//span[text()='%s']/../../following-sibling::td[6]/span/span", arn);
			Element(checkBox).click();
			loanDetails.setTransactionAmount(Element(tranAmountLbl).getText());
			ClickButton(calculateEMIBtn);
			SimulatorUtilities.wait(1000);
			loanDetails.setLoanEMI(emiLbl.getAttribute("value"));
			loanDetails.setProcessingFee(processingFeeLbl.getAttribute("value"));
			loanDetails.setMoratoriumLoan(moratoriumLoanLbl.getAttribute("value"));
			clickWhenClickable(sanctionBtn);

		});
		return loanDetails;
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(cardNumber));
	}
}