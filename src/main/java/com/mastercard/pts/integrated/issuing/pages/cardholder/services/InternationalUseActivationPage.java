package com.mastercard.pts.integrated.issuing.pages.cardholder.services;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ServicesNav;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//tr[@class='sectionHead'][2]")
	public MCWebElement iternationlUseConfirmationMsg;
	
	public void selectActivationRdo(){
		clickWhenClickableCHP(internationalActivation);
	}
	
	public void selectDeActivationRdo(){
		clickWhenClickableCHP(internationalDeActivation);
	}
	
	public void selectActivationInPeriodRdo(){
		clickWhenClickableCHP(activationInPeriodRdo);
	}
	
	public void activationFromDate(String fromDate){
		enterText(activationFromDateInpt, fromDate);
	}
	
	public void activationToDate(String toDate){		
		enterText(activationToDateInpt, toDate);
	}
	
	public void activationNHours(){
		clickWhenClickableCHP(activationForNHoursRdo);
	}
	
	public void enterNHours(String nHours){
		enterText(activateNHoursInpt, nHours);
	}
	
	public void selectActivationLifeLongRdo(){
		clickWhenClickableCHP(activationForLifeLongRdo);
	}
	
	public void internationalActivSubmitBtn(){
		clickWhenClickableCHP(activateInternationalUseSubmitBtn);
	}
	
	public void verifyUiOperationStatus() {
		verifyUiOperationStatusReusable("International Use Activation");
	}
	
	public String getInternationlUseActivaStatusConfrmMsg(){
		return getTextFromPage(iternationlUseConfirmationMsg);			
	}
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(intUseInput0Rbtn),
				WebElementUtils.visibilityOf(intUseInput1Rbtn), WebElementUtils.visibilityOf(activateTypeActivationInPeriodRbtn),
				WebElementUtils.visibilityOf(activateTypeImmediateActivationForNHrsRbtn), WebElementUtils.visibilityOf(activateTypeLifeLongActivateRbtn));
	}
}
