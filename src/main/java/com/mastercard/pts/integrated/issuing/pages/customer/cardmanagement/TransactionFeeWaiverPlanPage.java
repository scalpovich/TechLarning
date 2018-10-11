package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeeWaiverPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "addR")
	private MCWebElement addTransactionFeeWaiverPlanBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='txnFeeWaiverEffectiveDate']/..")
	private MCWebElement effectiveDateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='txnFeeWaiverEndDate']/..")
	private MCWebElement endDateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "txnFeeWaiverType:input:dropdowncomponent")
	private MCWebElement feeTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionCode:input:dropdowncomponent")
	private MCWebElement transactionTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement transactionSourceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionOrigin:input:dropdowncomponent")
	private MCWebElement transactionOriginDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "waiverCycle:input:dropdowncomponent")
	private MCWebElement waiverFrequencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "numberOfCycle:input:inputTextField")
	private MCWebElement applicableForCyclesTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycleVelocity:input:inputTextField")
	private MCWebElement transactionsWaivedPerCycleTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cycleVelocity:input:inputTextField")
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

	public void addTransactionFeeWaiverPlanMasterDetail(TransactionFeeWaiverPlan plan) {
		logger.info("Create transaction Fee Waiver Plan Master: {}", plan.getTransactionFeeWaiverPlanCode());
		clickAddNewButton();
		runWithinPopup("Add Transaction Fee Waiver Plan Master", () -> {
			WebElementUtils.enterText(waiverPlanCodeTxt,plan.getTransactionFeeWaiverPlanCode());
			WebElementUtils.enterText(descriptionTxt,CustomUtils.randomString(8));
			clickAddDetailsButton();
			addTransactionFeeWaiverPlanDetails(plan);
			clickSaveButton();	
		});
	}

	public void addTransactionFeeWaiverPlanMasterDetails(TransactionFeeWaiverPlan plan) {

		String[] transactionSource = plan.getTransactionSource().trim().split(":");
		String[] transactionType = plan.getTransactionType().trim().split(":");
		logger.info("Create transaction Fee Waiver Plan Master: {}", plan.getTransactionFeeWaiverPlanCode());
		SimulatorUtilities.wait(2000);
		clickAddNewButton();
		runWithinPopup("Add Transaction Fee Waiver Plan Master", () -> {
			WebElementUtils.enterText(waiverPlanCodeTxt,plan.getTransactionFeeWaiverPlanCode());
			WebElementUtils.enterText(descriptionTxt,Constants.GENERIC_DESCRIPTION);
			clickAddDetailsButton();
			for(String type : transactionType){
				for (String source:transactionSource) {
					addTransactionFeeWaiverPlanDetails(plan,type,source);
				}
			}
			clickSaveButton();
		});
	}


	public void addTransactionFeeWaiverPlanDetails(TransactionFeeWaiverPlan plan){
		clickAddNewButton();
		runWithinPopup("Add Transaction Fee Waiver Plan Details", () -> {
			WebElementUtils.pickDate(effectiveDateTxt, plan.getEffectiveDate());
			WebElementUtils.pickDate(endDateTxt, plan.getEndDate());
			WebElementUtils.selectDropDownByVisibleText(feeTypeDDwn,selectFeeType(plan.getFeeType()));
			WebElementUtils.selectDropDownByVisibleText(transactionTypeDDwn,plan.getTransactionType());
			WebElementUtils.selectDropDownByVisibleText(transactionSourceDDwn,plan.getTransactionSource());
			WebElementUtils.selectDropDownByVisibleText(transactionOriginDDwn,selectTransactionOrigin(plan.getTransactionOrigin()));
			WebElementUtils.selectDropDownByVisibleText(waiverFrequencyDDwn,selectWaiverFrequency(plan.getWaiverFrequency()));
			if (!(plan.getWaiverFrequency().contains("Permanent"))) {
				WebElementUtils.enterText(applicableForCyclesTxt, plan.getApplicableForCycles());
				WebElementUtils.enterText(transactionsWaivedPerCycleTxt, plan.getTransactionsWaivedPerCycle());
			}
			ClickCheckBox(clubTransactionOfAddOnCardsChk, true);
			clickSaveButton();
			verifyNoErrors();
		});
		verifyOperationStatus();	
	}

	private String selectTransactionOrigin(String transactionOrigin) {
		if (transactionOrigin.contains("Both")) {
			return "Both [~]";
		} else if (transactionOrigin.contains("Domestic")) {
			return "Domestic [DOM]";
		} else {
			return "International [INT]";
		}
	}

	private String selectWaiverFrequency(String waiverFrequency) {
		if (waiverFrequency.contains("Daily")) {
			return "Daily [D]";
		} else if (waiverFrequency.contains("Monthly")) {
			return "Monthly [M]";
		} else if (waiverFrequency.contains("Quarterly")) {
			return "Quarterly [Q]";
		} else {
			return "Permanent [P]";
		}
	}

	private String selectFeeType(String feeType) {
		if (feeType.contains("General")) {
			return "General [G]";
		} else {
			return "Boarding Offer [B]";
		}
	}

	public void addTransactionFeeWaiverPlanDetails(TransactionFeeWaiverPlan plan, String trasactionType, String transactionSource){
		SimulatorUtilities.wait(2000);
		clickAddNewButton();
		runWithinPopup("Add Transaction Fee Waiver Plan Details", () -> {
			WebElementUtils.pickDate(effectiveDateTxt, plan.getEffectiveDate());
			WebElementUtils.pickDate(endDateTxt, plan.getEndDate());
			WebElementUtils.selectDropDownByVisibleText(feeTypeDDwn,plan.getFeeType());
			WebElementUtils.selectDropDownByVisibleText(transactionTypeDDwn,trasactionType);
			WebElementUtils.selectDropDownByVisibleText(transactionSourceDDwn,transactionSource);
			WebElementUtils.selectDropDownByVisibleText(transactionOriginDDwn,plan.getTransactionOrigin());
			WebElementUtils.selectDropDownByVisibleText(waiverFrequencyDDwn,plan.getWaiverFrequency());
			WebElementUtils.enterText(applicableForCyclesTxt,plan.getApplicableForCycles());
			WebElementUtils.enterText(transactionsWaivedPerCycleTxt,plan.getTransactionsWaivedPerCycle());
			ClickCheckBox(clubTransactionOfAddOnCardsChk, true);
			clickSaveButton();
			verifyNoErrors();
		});
		verifyOperationStatus();	
	}

	public void setupTransactionTypeForSources(TransactionFeeWaiverPlan plan) {
		addTransactionFeeWaiverPlanMasterDetails(plan);
	}

	public void addTransactionFeeWaiverplanInExistingPlan(TransactionFeeWaiverPlan plan, DevicePlan device) {
		WebElementUtils.enterText(waiverPlanCodeTxt, device.getTransactionFeeWaiverPlan().substring(12, 15));
		clickSearchButton();
		SimulatorUtilities.wait(500);
		editFirstRecord();
		runWithinPopup("Edit Transaction Fee Waiver Plan Master", () -> {
			addTransactionFeeWaiverPlanDetails(plan);
			clickSaveButton();
		});

	}

}





