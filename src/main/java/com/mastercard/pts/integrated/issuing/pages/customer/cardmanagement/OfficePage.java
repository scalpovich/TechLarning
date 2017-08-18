package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_OFFICE })
public class OfficePage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(OfficePage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=branchCode]")
	private MCWebElement branchCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=branchName]")
	private MCWebElement branchName;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='branchName']")
	private MCWebElement branchNamePopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='branchCode']")
	private MCWebElement branchCodePopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address1']")
	private MCWebElement address1PopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address2']")
	private MCWebElement address2PopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='address3']")
	private MCWebElement address3PopupTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='zipCode']")
	private MCWebElement zipPopupTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='officeType']/span/select")
	private MCWebElement ofcTypeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='controlCode']/span/select")
	private MCWebElement controlCodeDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='countryCode']/select")
	private MCWebElement countryCodeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cityCodeTxt']")
	private MCWebElement cityCodePopupTxt;


	public void verifyUiOperationStatus() {
		logger.info("Office");
		verifyUiOperation("Add Office");
	}
	
	
	public void addOffice(List<Office> officeList)
	{
		officeList.forEach(ofc->{
		logger.info("create office : {}",ofc.toString());
		clickAddNewButton();
		runWithinPopup(
				"Add Office",
				() -> {
						addOffice(ofc);
						verifyNoErrors();
				});

		verifyOperationStatus();       
		});
	}
	
	private void addOffice(Office ofc)
	{					
			WebElementUtils.selectDropDownByVisibleText(ofcTypeDwn, ofc.getOfficeType());
			if(!ofc.getOfficeType().toUpperCase().contains("ZONAL"))
			{
				WebElementUtils.selectDropDownByVisibleText(controlCodeDwn, ofc.getControlOffice());
			}
			WebElementUtils.selectDropDownByVisibleText(countryCodeDwn, ofc.getCountry());
			WebElementUtils.enterText(branchCodePopupTxt, ofc.getOfficeCode());
			WebElementUtils.enterText(branchNamePopupTxt, ofc.getOfficeName());
			WebElementUtils.enterText(address1PopupTxt, ofc.getAddressLine1());
			WebElementUtils.enterText(address2PopupTxt, ofc.getAddressLine2());
			WebElementUtils.enterText(zipPopupTxt, ofc.getZip());
			SimulatorUtilities.wait(5000);
			WebElementUtils.enterText(address3PopupTxt, ofc.getAddressLine2());
			SimulatorUtilities.wait(5000);
			clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(branchCode),
				WebElementUtils.elementToBeClickable(branchName));
	}
}
