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
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ServicesNav.TAB_SERVICES, treeMenuItems = { ServicesNav.L1_INTERNATIONAL_USE_ACTIVATION })
public class InternationalUseActivationPage extends ServicesAbstractPage {

	@PageElement(findBy = FindBy.ID, valueToFind = "IntUseInput1")
	private MCWebElement intUseInput1Rbtn;

	@PageElement(findBy = FindBy.ID, valueToFind = "IntUseInput0")
	private MCWebElement intUseInput0Rbtn;
	
		@PageElement(findBy = FindBy.ID, valueToFind ="IntUseInput1")
	private MCWebElement internationalActivation;

	@PageElement(findBy = FindBy.ID, valueToFind ="IntUseInput0")
	private MCWebElement internationalDeActivation;	
	
	@PageElement(findBy = FindBy.ID, valueToFind ="ActivateTypeActivation in Period")
	private MCWebElement activationInPeriodRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind ="ActivateTypeImmediate Activation for n Hrs")
	private MCWebElement activationForNHoursRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind ="NoOfHours")
	private MCWebElement activateNHoursInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind ="ActivateTypeLife Long Activate")
	private MCWebElement activationForLifeLongRdo;
	
	@PageElement(findBy = FindBy.ID, valueToFind ="Start_Eff_Date")
	private MCWebElement activationFromDateInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind ="End_Eff_Date")
	private MCWebElement activationToDateInpt;
	
	@PageElement(findBy = FindBy.ID, valueToFind ="mpts_cardHolderPortal_button_submit")
	private MCWebElement activateInternationalUseSubmitBtn;
	
	public void selectActivationInPeriod(){
		clickWhenClickableCHP(activationInPeriodRdo);
	}
	
	public void activationFromDate(LocalDate fromDate){		
		WebElementUtils.pickDateChp(driver(),activationFromDateInpt, fromDate);
	}
	
	public void activationToDate(LocalDate toDate){		
		WebElementUtils.pickDateChp(driver(),activationToDateInpt, toDate);
	}
	
	public void activationNHours(){
		clickWhenClickableCHP(activationForNHoursRdo);
	}
	
	public void enterNHours(String nHours){
		enterText(activateNHoursInpt, nHours);
	}
	
	public void selectActivationLifeLong(){
		clickWhenClickableCHP(activationForLifeLongRdo);
	}
	
	public void internationalActivSubmitBtn(){
		clickWhenClickableCHP(activateInternationalUseSubmitBtn);
	}
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("International Use Activation");
	}
	
	public String getInternationlUseActivaStatusConfrmMsg(){
		return getTextFromPage(responseLbl);			
	}
	
	public void setInternationalUse(String fromDate, String toDate){
		activationFromDate(LocalDate.now().minusDays(1));
		activationToDate(LocalDate.now());
		internationalActivSubmitBtn();
	}
	
	public String updateInternationalDeviceUsage(CardholderServices cardholderService){
		if(cardholderService.getInternationActivationType().contains(CardholderServices.HOURS_ACTIVATION)){				
			activationNHours();
			enterNHours(cardholderService.getInternationalActivationHours());
			internationalActivSubmitBtn();
			
		}else if(cardholderService.getInternationActivationType().contains(CardholderServices.LIFELONG_ACTIVATION)){
			selectActivationLifeLong();
			internationalActivSubmitBtn();	
			
		}else if(cardholderService.getInternationActivationType().contains(CardholderServices.PERIOD_ACTIVATION)){
			selectActivationInPeriod();
			setInternationalUse(LocalDate.now().minusDays(1).toString(),LocalDate.now().toString());
		}
		return getTextFromPage(responseLbl);
	}
	
	public String deactivateInternationalTransaction(){
		WebElementUtils.selectRadioBtn(internationalDeActivation);
		clickWhenClickable(activateInternationalUseSubmitBtn);
		waitForLoaderToDisappear();
		return getTextFromPage(responseLbl);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(intUseInput0Rbtn),
				WebElementUtils.visibilityOf(intUseInput1Rbtn), WebElementUtils.visibilityOf(activateTypeActivationInPeriodRbtn),
				WebElementUtils.visibilityOf(activateTypeImmediateActivationForNHrsRbtn), WebElementUtils.visibilityOf(activateTypeLifeLongActivateRbtn));
	}
}
