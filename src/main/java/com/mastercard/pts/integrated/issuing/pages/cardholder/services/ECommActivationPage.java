package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@name='Start_Eff_Date']//..//button")
	private MCWebElement ecomActivationFrom;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@name='End_Eff_Date']//..//button")
	private MCWebElement ecomActionTo;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	private MCWebElement responseLbl;	
	
	public void setActivationEcomOption(){
		clickWhenClickableCHP(activateEcomTransaction);
	}
	
	public void deactivationEcomTran(){
		WebElementUtils.selectRadioBtn(deactivateEcommTransaction);
	}
	
	public void setActivationInPeriod(){
		WebElementUtils.selectRadioBtn(activationInPeriodRdo);
	}
	
	public void setActivationForNHours(){
		WebElementUtils.selectRadioBtn(activationForNHoursRdo);
	}
	
	public void setActivationForLifeLong(){
		WebElementUtils.selectRadioBtn(activationLifeLongRdo);
	}
	
	public void setNumberOfHours(String numberOfHours){
		 enterText(numberOfHoursInpt, numberOfHours);
	}
	
	public void submitEcomActivationPlan(){
		clickWhenClickable(ecomActivationSubmitBtn);
	}
	
	public void setActivationFromDate(LocalDate fromDate){
		//WebElementUtils.pickDate(ecomActivationFrom, fromDate);	
		WebElementUtils.pickDateJQuery(driver(),ecomActivationFrom, fromDate);
	}
	
	public void setActivationToDate(LocalDate toDate){
		//WebElementUtils.pickDate(ecomActionTo,toDate);
		WebElementUtils.pickDateJQuery(driver(),ecomActionTo, toDate);
	}
	
	public String getEcomActivationResponseMsg(){
		return getTextFromPage(responseLbl);
	}
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("E-Comm Activation");
	}
	
	public void setEcomActivationDurationDate(){
		setActivationFromDate(LocalDate.now());
		setActivationToDate(LocalDate.now().plusDays(2));
		submitEcomActivationPlan();
	}
	
	public String configureEcomActivation(CardholderServices activationPlan){
		if(activationPlan.getActivationStatusForEcom().contains(CardholderServices.HOURS_ACTIVATION)){			
			setActivationForNHours();			
			setNumberOfHours(activationPlan.getEcomActivationHour());
			submitEcomActivationPlan();
			
		}else if(activationPlan.getActivationStatusForEcom().contains(CardholderServices.LIFELONG_ACTIVATION)){
			setActivationForLifeLong();
			submitEcomActivationPlan();			
			
		}else if(activationPlan.getActivationStatusForEcom().contains(CardholderServices.PERIOD_ACTIVATION)){
			setActivationInPeriod();
			setEcomActivationDurationDate();			
		}
		return getTextFromPage(responseLbl);
	}
	
	public String deactivateEcomTransaction(){
		deactivationEcomTran();
		clickWhenClickable(ecomActivationSubmitBtn);
		waitForLoaderToDisappear();
		return getTextFromPage(responseLbl);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(ecomInput1Rbtn),
				WebElementUtils.visibilityOf(ecomInput0Rbtn), WebElementUtils.visibilityOf(activateTypeActivationInPeriodRbtn),
				WebElementUtils.visibilityOf(activateTypeImmediateActivationForNHrsRbtn), WebElementUtils.visibilityOf(activateTypeLifeLongActivateRbtn));
	}
}
