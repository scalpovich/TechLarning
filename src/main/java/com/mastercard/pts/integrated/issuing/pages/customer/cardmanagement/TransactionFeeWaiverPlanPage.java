package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_DEVICE_CONFIGURATION,
		CardManagementNav.L3_TRANSACTION_FEE_WAIVER_PLAN
		})

public class TransactionFeeWaiverPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(TransactionFeeWaiverPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=waiverPlanCode]")
	private MCWebElement waiverPlanCodeTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement descriptionTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "addR")
	private MCWebElement addTransactionFeeWaiverPlanBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "txnFeeWaiverEffectiveDate:input:dateTextField")
	private MCWebElement effectiveDateTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "txnFeeWaiverEndDate:input:dateTextField")
	private MCWebElement endDateTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "txnFeeWaiverType:input:dropdowncomponent")
	private MCWebElement feeTypeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionTypeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement transactionSourceDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement transactionOriginDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "waiverCycle:input:dropdowncomponent")
	private MCWebElement waiverFrequencyDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "numberOfCycle:input:inputTextField")
	private MCWebElement applicableForCyclesTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "cycleVelocity:input:inputTextField")
	private MCWebElement transactionsWaivedPerCycleTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "cycleVelocity:input:inputTextField")
	private MCWebElement clubTransactionOfAddOnCardsChk;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	
	
	public void verifyUiOperationStatus() {
		logger.info("Transaction Fee Waiver Plan Master");
		verifyUiOperation("Add Transaction Fee Waiver Plan Master");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(waiverPlanCodeTxt),
				WebElementUtils.elementToBeClickable(descriptionTxt)
				);
	}
}
