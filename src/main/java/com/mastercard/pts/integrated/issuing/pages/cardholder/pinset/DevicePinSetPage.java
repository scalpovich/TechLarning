package com.mastercard.pts.integrated.issuing.pages.cardholder.pinset;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardHolderPinSet;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component 
@Navigation(tabTitle = CardHolderPinSet.TAB_PINSET, treeMenuItems = {CardHolderPinSet.PIN_SET})
public class DevicePinSetPage extends AbstractBasePage{	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "expiryDate")
	MCWebElement cardExpDateTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "cvv")
	MCWebElement cvv2CVC2Txt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "legalid")
	MCWebElement documentTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "legalidtype")
	MCWebElement documentNumberTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "issuanceplace")
	MCWebElement documentPlaceTxt;	
	
	@PageElement(findBy = FindBy.ID, valueToFind = "legalexpdate")
	MCWebElement dtPkrDocumentExp;
	
	@PageElement(findBy = FindBy.ID, valueToFind="mpts_cardHolderPortal_button_submit")
	private MCWebElement submitBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind="//*[@class='sectionHead']/td/../following-sibling::tr[1]/td")
	private MCWebElement lablResponse;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@*='birthDate']/../img")
	private MCWebElement birthDateDPkr;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "pinNew")
	private MCWebElement newPinTxt;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "pinNew2")
	private MCWebElement confirmTxt;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "keypad-special keypad-close")
	private MCWebElement pinConfirmBtn;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "ui-datepicker-year")
	private MCWebElement yearDDdn;
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "ui-datepicker-month")
	private MCWebElement monthDDdn;	
	
	private static final Logger logger = LoggerFactory.getLogger(DevicePinSetPage.class);
	
	public String setPinForDevice(Device device){
		fillPinSetInfo(device);
		setNewPin("1234");	
		clickWhenClickable(submitBtn);
		return lablResponse.getText();
	}
	
	public void fillPinSetInfo(Device device){
		logger.info("Device Number: {}", device.getDeviceNumber());
		String locator = String.format("//*[@class='dataview-div']//*[@id='%s']//*[@type='submit']", device.getDeviceNumber());
		Element(locator).click();
		waitForLoaderToDisappear();
		enterText(cardExpDateTxt, "1022");
		logger.info("CVV2 or CVC2 pin: {}", device.getCvv2Data());
		enterText(cvv2CVC2Txt, device.getCvv2Data());		
		logger.info("Client DOB: {}", device.getClientDetails().getBirthDate());
		setDate(device.getClientDetails().getBirthDate());		
		WebElementUtils.selectDropDownByIndex(documentTypeDDwn, 1);
		logger.info("Document ID: {}", device.getLegalID());
		enterText(documentNumberTxt, device.getLegalID());
		clickWhenClickable(submitBtn);
		waitForLoaderToDisappear();	
	}

	public  void setNewPin(String newPin){
		if(!Strings.isNullOrEmpty(newPin)){
			char[] pinArry = newPin.toCharArray();
				
				clickWhenClickable(newPinTxt);
				for(char pin : pinArry){
					String locator = String.format("//*[@*='keypad-key' and text()='%c']", pin);
					Element(locator).click();
				}
				clickWhenClickable(pinConfirmBtn);
				SimulatorUtilities.wait(3000);
				
				clickWhenClickable(confirmTxt);
				for(char pin : pinArry){
					String locator = String.format("//*[@*='keypad-key' and text()='%c']", pin);
					Element(locator).click();
				}
				clickWhenClickable(pinConfirmBtn);
				SimulatorUtilities.wait(2000);
		}
	}

	
	public void setDate(LocalDate date){		
		asWebElement(birthDateDPkr).click();
		selectByVisibleText(yearDDdn, String.valueOf(date.getYear()));
		SelectDropDownByValue(monthDDdn, String.valueOf(date.getMonthValue()-1));
		String locator = String.format("//*[@data-handler='selectDay']/a[text()=%d]", date.getDayOfMonth());
		driver().findElement(By.xpath(locator)).click();		
	}
}