package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_E_COMM_ACTIVATION })
public class ECommActivationPage extends ServicesAbstractPage {
	
		@PageElement(findBy = FindBy.ID, valueToFind="EcomInput1")
	private MCWebElement activateEcomTransaction;
	
	@PageElement(findBy = FindBy.ID, valueToFind="EcomInput0")
	private MCWebElement deactivateEcommTransaction;
	
	@PageElement(findBy = FindBy.ID, valueToFind="ActivateTypeActivation in Period")
	private MCWebElement activationInPeriodRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind="ActivateTypeImmediate Activation for n Hrs")
	private MCWebElement activationForNHoursRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind="ActivateTypeLife Long Activate")
	private MCWebElement activationLifeLongRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind="NoOfHours")
	private MCWebElement numberOfHoursInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement ecomActivationSubmitBtn;
	
	@PageElement(findBy = FindBy.ID, valueToFind="Start_Eff_Date")
	private MCWebElement ecomActivationFrom;
	
	@PageElement(findBy = FindBy.ID, valueToFind="End_Eff_Date")
	private MCWebElement ecomActionTo;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//td[@class='ResponseTxt']")
	private MCWebElement activationStatus;
	
	
	public void setActivationEcomOption(){
		clickWhenClickableCHP(activateEcomTransaction);
	}
	
	public void setDeActivationEcomOption(){
		clickWhenClickableCHP(deactivateEcommTransaction);
	}
	
	public void setActivationInPeriod(){
		clickWhenClickable(activationInPeriodRdo);
	}
	
	public void setActivationForNHours(){
		clickWhenClickable(activationForNHoursRdo);
	}
	
	public void setActivationForLifeLong(){
		clickWhenClickable(activationLifeLongRdo);
	}
	
	public void setNumberOfHours(String numberOfHours){
		 enterText(numberOfHoursInpt, numberOfHours);
	}
	
	public void submitEcomActivationPlan(){
		clickWhenClickable(ecomActivationSubmitBtn);
	}
	
	public void setActivationFromDate(String fromDate){
		enterText(ecomActivationFrom, fromDate);
	}
	
	public void setActivationToDate(String toDate){
		enterText(ecomActionTo,toDate);
	}
	
	public String getEcomActivationResponseMsg(){
		return getTextFromPage(activationStatus);
	}
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("E-Comm Activation");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(ecomInput1Rbtn),
				WebElementUtils.visibilityOf(ecomInput0Rbtn), WebElementUtils.visibilityOf(activateTypeActivationInPeriodRbtn),
				WebElementUtils.visibilityOf(activateTypeImmediateActivationForNHrsRbtn), WebElementUtils.visibilityOf(activateTypeLifeLongActivateRbtn));
	}
}
