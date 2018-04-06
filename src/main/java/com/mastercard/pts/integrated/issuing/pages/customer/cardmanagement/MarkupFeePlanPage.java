package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;


import java.util.Arrays;


import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;


import java.util.Collection;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarkupFeePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;


@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT,
treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_MARKUP_FEE_PLAN })

public class MarkupFeePlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(MarkupFeePlanPage.class);


	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=markupFeeCode]")
	private MCWebElement markupFeeCodeTxtBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=markupDescription]")
	private MCWebElement markupDescriptionTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMarkupFeePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "markupFeeCode:input:inputTextField")
	private MCWebElement markupFeePlanCodeTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "markupDescription:input:inputTextField")
	private MCWebElement descriptionTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "status:input:dropdowncomponent")
	private MCWebElement statusDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "defaultRate:input:inputAmountField")
	private MCWebElement defaultRateTxtBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "chargeMarkupFee:checkBoxComponent")
	private MCWebElement chargeMarkUpFeeChkbx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "clubToTransaction:checkBoxComponent")
	private MCWebElement clubIntoTransactionChkbx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "chargeToInterchangeTran:checkBoxComponent")
	private MCWebElement interchangeTransactionsChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "chargeToUsOnUsTran:checkBoxComponent")
	private MCWebElement onUsTransactionChkbx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "chargeToOtherTran:checkBoxComponent")
	private MCWebElement portalApiTransactionChkBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "sourceCurrency:input:dropdowncomponent")
	private MCWebElement sourceCurrencyTxtBx;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "destinationCurrency:input:dropdowncomponent")
	private MCWebElement destinationCurrencyTxtBx;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='rate:input:inputAmountField']")
	private MCWebElement currencySpecificRateTxtBx;
	
	@PageElement(findBy = FindBy.CSS,valueToFind = "input[value='Close']")
	private MCWebElement closeBtn;
	
	@PageElement(findBy = FindBy.CSS,valueToFind = "//*[@title='Card Management']")
	private MCWebElement cardMgmt;
	
	
	public void verifyUiOperationStatus() {
		logger.info("Markup Fee Plan");
		verifyUiOperation("Add Markup Fee Plan");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(markupFeeCodeTxtBx),
				WebElementUtils.elementToBeClickable(markupDescriptionTxtBx),
				WebElementUtils.elementToBeClickable(status)
				);
	}
	
	public void createMarkupFeePlanPage(MarkupFeePlan plan){
		logger.info("Create MarkUpFee Plan {}", plan.getmarkupFeePlanCode());
		clickAddNewButton();
		runWithinPopup("Add Markup Fee Plan",()->{
			WebElementUtils.enterText(markupFeePlanCodeTxtBx,plan.getmarkupFeePlanCode());
			WebElementUtils.enterText(descriptionTxtBx,Constants.GENERIC_DESCRIPTION);
			WebElementUtils.selectDropDownByVisibleText(statusDdwn,plan.getStatus());
			WebElementUtils.enterText(defaultRateTxtBx,plan.getDefaultRate());
			
			if(plan.getChargeMarkupFees().equalsIgnoreCase("true")){
				ClickCheckBox(chargeMarkUpFeeChkbx, true);
				ClickCheckBox(clubIntoTransactionChkbx, true);
				ClickCheckBox(interchangeTransactionsChkBx, true);
				ClickCheckBox(onUsTransactionChkbx, true);
				ClickCheckBox(portalApiTransactionChkBx, true);
				clickSaveButton();
				clickAddNewButton();
				SimulatorUtilities.wait(6000);
				
				runWithinPopup("Add Currency Specific Markup Rate",()->{
					WebElementUtils.selectDropDownByVisibleText(sourceCurrencyTxtBx,plan.getSourceCurrency());
					WebElementUtils.selectDropDownByVisibleText(destinationCurrencyTxtBx,plan.getDestinationCurrency());
					WebElementUtils.enterText(currencySpecificRateTxtBx,plan.getCurrencySpecificRate());
					clickSaveButton();
					verifyNoErrors();
				});
				
				clickCloseButton();
			}
			else{
				clickSaveButton();
			}
			
			verifyOperationStatus();
			
		});
	}
}

		

