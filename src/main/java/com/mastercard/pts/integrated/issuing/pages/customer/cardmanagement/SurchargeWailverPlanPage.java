package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SurchargeWailverPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_SURCHARGE_WAIVER_PLAN })
public class SurchargeWailverPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(SurchargeWailverPlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=waiverPlanCode]")
	private MCWebElement waiverPlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[@class='addR']")
	private MCWebElement addButton;

	@PageElement(findBy = FindBy.NAME, valueToFind = "waiverPlanCode:input:inputTextField")
	private MCWebElement surchargeWaiverPlanCodeTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement surchargeWaiverPlandescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Add Details']")
	private MCWebElement addDetailsBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='waiverPlanCode']//li")
	private MCWebElement waiverPlanErrorMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='description']//li")
	private MCWebElement descriptionErrorMsg;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='currencyCode']//li")
	private MCWebElement currencyErrorMsg;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mcgCode:input:dropdowncomponent")
	private MCWebElement mcgDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement effectiveDateImg;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='iddbDp']//img")
	private MCWebElement endDateImg;
	
	
	//input[@value='Add Details']
	public void verifyUiOperationStatus() {
		logger.info("Surcharge Waiver Plan");
		verifyUiOperation("Add Surcharge Waiver Plan");
	}

	public boolean enterWaiverPlanValid(SurchargeWailverPlan surchargeWailverPlan) {
		logger.info("Surcharge Waiver Plan");
		clickWhenClickable(addButton);
		switchToIframe(Constants.ADD_SURCHARGE_WAIVER_FEE_PLAN);
		enterValueinTextBox(surchargeWaiverPlanCodeTxt, surchargeWailverPlan.getSurchargeWaiverPlanCodeValid());
        clickWhenClickable(addDetailsBtn);
		return waiverPlanValidation();
		}
	public boolean enterWaiverPlanInvalid(SurchargeWailverPlan surchargeWailverPlan) {
		logger.info("Surcharge Waiver Plan");
		clickWhenClickable(addButton);
		switchToIframe(Constants.ADD_SURCHARGE_WAIVER_FEE_PLAN);
		enterValueinTextBox(surchargeWaiverPlanCodeTxt, surchargeWailverPlan.getSurchargeWaiverPlanCodeInvalid());
		 clickWhenClickable(addDetailsBtn);
		return waiverPlanValidation();
		}
	
	public boolean enterWaiverPlanDescriptionValid(SurchargeWailverPlan surchargeWailverPlan) {
		enterValueinTextBox(surchargeWaiverPlandescriptionTxt,surchargeWailverPlan.getSurchargeWaiverDescriptionValid() );
		 clickWhenClickable(addDetailsBtn);
		return descriptionValidation();
		}
	public boolean enterWaiverPlanDescriptionInvalid(SurchargeWailverPlan surchargeWailverPlan) {
		enterValueinTextBox(surchargeWaiverPlandescriptionTxt,surchargeWailverPlan.getSurchargeWaiverDescriptionInvalid() );
		 clickWhenClickable(addDetailsBtn);
		return descriptionValidation();
		}

	public boolean waiverPlanValidation() {
		String a = surchargeWaiverPlanCodeTxt.getAttribute("value");
		String[] b = a.split("");
		if (a.matches("[A-Z0-9\\_]*") && b[0].matches("[A-Z0-9]")&& b[b.length - 1].matches("[A-Z0-9]")) {
			System.out.println("Pass");
			return true;
		}
		System.out.println("Fail");
		return false;
		
	}

	public boolean descriptionValidation() {
		String a = surchargeWaiverPlandescriptionTxt.getAttribute("value");
        String[] b = a.split("");
       if (a.matches("[a-zA-Z0-9\\s\\.\\,\\&\\#\\:\\*\\(\\)\\-\\[\\]]*")&& b[0].matches("[a-zA-Z0-9]")) {
    	   System.out.println("Pass");
			return true;
		}
       System.out.println("Fail");
		return false;
	}
	
	public boolean currencyValidation()
	{
		 clickWhenClickable(addDetailsBtn);
		 if(currencyErrorMsg.isVisible())
		 {
			 System.out.println("Currency error msg is displayed");
			 return true;
		 }
		 return false;
	}
	
	public void currencySelect()
	{
		currencyDDwn.getSelect().selectByIndex(2);
	}
	public void addDetailsButtonClick()
	{
		clickWhenClickable(addDetailsBtn);
	}
	public void addNewButtonClick()
	{
		clickWhenClickable(addButton);
	}
    
	public String waiverPlanCodeErrorMessage()
	{
		return waiverPlanErrorMsg.getText();
		
	}
	public String waiverPlanDescriptionErrorMessage()
	{
		return descriptionErrorMsg.getText();
		
	}
	public void interchangeSelect()
	{
		interchangeDDwn.getSelect().selectByIndex(1);
	}
	public void mcgSelect()
	{
		mcgDDwn.getSelect().selectByIndex(1);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(waiverPlanCode),
				WebElementUtils.elementToBeClickable(description));
	}
}
