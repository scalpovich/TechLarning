package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TaxOnIncomeRate;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_TAX_ON_INCOME
		})

public class TaxOnIncomePage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(TaxOnIncomePage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement feeType;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=taxDescription]")
	private MCWebElement taxDescription;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/..")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/..")
	private MCWebElement endDateDPkr;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement taxOnIncomeDescriptionTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement taxOnIncomeFeeTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:5:cols:colspanMarkup:inputField:input:inputAmountField")
	private MCWebElement taxOnIncomeTaxPercentTxt;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:6:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement taxOnIncomeStatusDDwn;
	
	public void verifyUiOperationStatus() {
		logger.info("Tax On Income Rate");
		verifyUiOperation("Add Tax On Income Rate");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(feeType),
				WebElementUtils.elementToBeClickable(taxDescription),
				WebElementUtils.elementToBeClickable(status)
				);
	}
	public void addTaxOnIncomeRate(TaxOnIncomeRate taxOnIncomeRate){
		logger.info("Add Tax On Income Rate");
		deleteExistingRecord(taxOnIncomeRate.getFeeType());
		clickAddNewButton();
		runWithinPopup("Add Tax On Income Rate", () -> {
			addTaxOnIncomeRateAndSave(taxOnIncomeRate);
		});
	}

	private void addTaxOnIncomeRateAndSave(TaxOnIncomeRate taxOnIncomeRate) {
		enterTaxDescription(taxOnIncomeRate);
		selectFeeType(taxOnIncomeRate);
		WebElementUtils.pickDate(effectiveDateDPkr, futureDate);
		WebElementUtils.pickDate(endDateDPkr, futureEndDate);
		enterTaxPercentage(taxOnIncomeRate);
		selectStatus(taxOnIncomeRate);
		clickSaveButton();
	}
	
	public void enterTaxDescription(TaxOnIncomeRate taxOnIncomeRate){
		WebElementUtils.enterText(taxOnIncomeDescriptionTxt, taxOnIncomeRate.getTaxDescription());
	}
	
	public void selectFeeType(TaxOnIncomeRate taxOnIncomeRate){
		selectByVisibleText(taxOnIncomeFeeTypeDDwn, taxOnIncomeRate.getFeeType());
	}
	
    public void enterTaxPercentage(TaxOnIncomeRate taxOnIncomeRate){
    	WebElementUtils.enterText(taxOnIncomeTaxPercentTxt, taxOnIncomeRate.getTaxRate());
	}
    public void selectStatus(TaxOnIncomeRate taxOnIncomeRate){
    	selectByVisibleText(taxOnIncomeStatusDDwn, taxOnIncomeRate.getStatus());
   	}
	
	
}
