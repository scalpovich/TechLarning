package com.mastercard.pts.integrated.issuing.pages.cardholder.virtualcard;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = VirtualCardNav.TAB_VIRTUAL_CARD, treeMenuItems = { VirtualCardNav.L1_VIRTUAL_PREPAID_CARD_REQUEST })
public class VirtualPrepaidCardRequestPage extends AbstractBasePage {
	private static final Logger logger = LoggerFactory.getLogger(VirtualPrepaidCardRequestPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "div .Title")
	private MCWebElement masterDetailContentTitle;

	@PageElement(findBy = FindBy.ID, valueToFind = "title")
	private MCWebElement titleTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "firstName")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "middleName1")
	private MCWebElement middleName1Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "middleName2")
	private MCWebElement middleName2Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "lastName")
	private MCWebElement lastNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "maidenName")
	private MCWebElement maidenNameTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "married")
	private MCWebElement marriedTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "gender")
	private MCWebElement genderTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "birthDateStr")
	private MCWebElement birthDateStrTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address1")
	private MCWebElement address1Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address2")
	private MCWebElement address2Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "address3")
	private MCWebElement address3Txt;

	@PageElement(findBy = FindBy.ID, valueToFind = "zipCode")
	private MCWebElement zipCodeTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "cityCode")
	private MCWebElement cityCodeTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "stateCode")
	private MCWebElement stateCodeTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "countryCode")
	private MCWebElement countryCodeTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "regesteredMobileNumber")
	private MCWebElement regesteredMobileNumberTxt;

	@PageElement(findBy = FindBy.ID, valueToFind = "registeredMailId")
	private MCWebElement registeredMailIdTxt;

	public void verifyUiOperationStatus() {
		logger.info("Virtual Prepaid Card Request");
		verifyTitleCardHolderPortal("Static Virtual Device Request");
		verifyWalletDetails();
		verifyDeviceDetails();
		verifyButton("Submit");
		verifyButton("Cancel");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(masterDetailContentTitle), WebElementUtils.visibilityOf(titleTxt),
				WebElementUtils.visibilityOf(firstNameTxt), WebElementUtils.visibilityOf(middleName1Txt), WebElementUtils.visibilityOf(middleName2Txt),
				WebElementUtils.visibilityOf(lastNameTxt), WebElementUtils.visibilityOf(maidenNameTxt), WebElementUtils.visibilityOf(genderTxt),
				WebElementUtils.visibilityOf(marriedTxt), WebElementUtils.visibilityOf(birthDateStrTxt), WebElementUtils.visibilityOf(address1Txt),
				WebElementUtils.visibilityOf(address2Txt), WebElementUtils.visibilityOf(address3Txt), WebElementUtils.visibilityOf(zipCodeTxt),
				WebElementUtils.visibilityOf(cityCodeTxt), WebElementUtils.visibilityOf(stateCodeTxt), WebElementUtils.visibilityOf(countryCodeTxt),
				WebElementUtils.visibilityOf(regesteredMobileNumberTxt), WebElementUtils.visibilityOf(registeredMailIdTxt));
	}
}
