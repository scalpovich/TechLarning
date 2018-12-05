package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CorporateClient;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_CLIENT,
		CardManagementNav.L3_CREATE_CORPORATE })
public class CreateCorporatePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(CreateCorporatePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=clientCode]")
	private MCWebElement clientCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=applicationRefNumber]")
	private MCWebElement applicationRefNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=companyName]")
	private MCWebElement companyNameTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement productTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:branchCode:input:dropdowncomponent")
	private MCWebElement branchCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:embossLine4:input:inputTextField")
	private MCWebElement embossedLineTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:liabilityType:input:dropdowncomponent")
	private MCWebElement liabilityTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement nextBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officeAddress1:input:inputTextField")
	private MCWebElement officeAddress1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officeCountryCode:input:dropdowncomponent")
	private MCWebElement officeCountryCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officeContactNumber1:input:inputTextField")
	private MCWebElement officeContactNumber1Txt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officeEmail:input:inputTextField")
	private MCWebElement officeEmailTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:incorporationDate:input:dateTextField")
	private MCWebElement dateOfIncorporation;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:tanNumber:input:inputTextField")
	private MCWebElement tanNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement currencyCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditLimit:input:inputAmountField")
	private MCWebElement creditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimit:input:inputAmountField")
	private MCWebElement cashLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement finishBtn;

	public void verifyUiOperationStatus() {
		logger.info("Corporate");
		verifyUiOperation("Add Corporate");
	}

	public void createCorporateClient(CorporateClient corporateclient) {
		logger.info("Create Corporate client Plan: {}",
				corporateclient.getProductType());
		clickAddNewButton();
		runWithinPopup("Add Corporate", () -> {
			WebElementUtils.selectDropDownByVisibleText(productTypeDdwn,
					corporateclient.getProductType());
			WebElementUtils.enterText(applicationRefNumberTxt,
					corporateclient.getApplicationRefNumber());
			WebElementUtils.selectDropDownByVisibleText(branchCodeDdwn,
					corporateclient.getBranch());
			WebElementUtils.enterText(companyNameTxt,
					corporateclient.getCompanyName());
			WebElementUtils.enterText(embossedLineTxt,
					corporateclient.getEmbossedLine());
			WebElementUtils.selectDropDownByVisibleText(liabilityTypeDdwn,
					corporateclient.getLiabilityType());
			clickWhenClickable(nextBtn);
			WebElementUtils.enterText(officeAddress1Txt,
					corporateclient.getCompanyName());
			WebElementUtils.selectDropDownByVisibleText(officeCountryCodeDdwn,
					corporateclient.getProductType());
			WebElementUtils.enterText(officeContactNumber1Txt,
					corporateclient.getCompanyName());
			WebElementUtils.enterText(officeEmailTxt,
					corporateclient.getCompanyName());
			clickWhenClickable(nextBtn);
			WebElementUtils.pickDate(dateOfIncorporation, LocalDate.now()
					.minusDays(1));
			WebElementUtils.enterText(tanNumberTxt,
					corporateclient.getTanNumber());
			clickNextButton();
			clickNextButton();
			WebElementUtils.enterText(creditLimitTxt,
					corporateclient.getCreditLimit());
			WebElementUtils.selectDropDownByVisibleText(cashLimitTxt,
					corporateclient.getCashLimit());
			WebElementUtils.enterText(currencyCodeDdwn,
					corporateclient.getBillingCurrency());
			clickWhenClickable(finishBtn);

		});
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(clientCode),
				WebElementUtils.elementToBeClickable(applicationRefNumberTxt),
				WebElementUtils.elementToBeClickable(companyNameTxt),
				WebElementUtils.elementToBeClickable(productTypeDdwn));
	}
}
