package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ApplicationBusinessMandatoryFields;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_BUSINESS_MANDATORY_FIELDS })
public class ApplicationBusinessMandatoryFieldsPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(ApplicationBusinessMandatoryFieldsPage.class);

	@Value("${default.wait.timeout_in_sec}")
	private long timeoutInSec;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=customerType]")
	private MCWebElement customerTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=fieldName]")
	private MCWebElement fieldNameDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Product Type']/following-sibling::td//select")
	private MCWebElement productTypeDDwnOnMainScreen;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Customer Type']/following-sibling::td//select")
	private MCWebElement customerTypeDDwnOnMainScreen;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=programCode]")
	private MCWebElement programCodeDDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name^=bmfmSearchPanel]")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[name^='childPanels:1:childdataPanel:inlineTable:container:dataList:0:colList:colHeaders:2:inputField:checkBoxComponent']")
	private MCWebElement checkBoxOneChk;

	public void verifyUiOperationStatus() {
		logger.info("Audit Configuration");
		verifySearchButton("Search");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(customerTypeDDwnOnMainScreen),
				WebElementUtils.visibilityOf(productTypeDDwnOnMainScreen));
	}

	public void addBusinessMandatoryFields(ApplicationBusinessMandatoryFields applicationBusinessMandatoryFields) {
		logger.info("Add Business Mandatory Fields: {}",	applicationBusinessMandatoryFields);		
	
		performSearchOperationOnMainScreen(applicationBusinessMandatoryFields);
		
		//When record already exists
		if(!isNoRecordsFoundInTable())
		{
			editAndAddBusinessMandatoryFields(applicationBusinessMandatoryFields);
		}		
		else
		{
			clickAddNewButton();
			runWithinPopup("Add Business Mandatory Fields", () -> {
				WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, applicationBusinessMandatoryFields.getProductType());
				WebElementUtils.selectDropDownByVisibleText(customerTypeDDwn, applicationBusinessMandatoryFields.getCustomerType());
				if(!applicationBusinessMandatoryFields.getCustomerType().contains("Corporate"))
				{
					//only when the customer type is "CORPORATE", we have the option of seelcting Program code.. else only "ALL" is avaible for selection
					applicationBusinessMandatoryFields.setProgramCode("All [~]");
				}
				WebElementUtils.selectDropDownByVisibleText(programCodeDDwn, applicationBusinessMandatoryFields.getProgramCode());
				clickWhenClickable(searchBtn);
				
				WebElementUtils.checkCheckbox(checkBoxOneChk, true);
				clickSaveButton();
				
				verifyNoErrors();
			});
			verifyOperationStatus();
		}
	}
	
	private void performSearchOperationOnMainScreen(ApplicationBusinessMandatoryFields applicationBusinessMandatoryFields)
	{
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwnOnMainScreen, applicationBusinessMandatoryFields.getProductType());
		WebElementUtils.selectDropDownByVisibleText(customerTypeDDwnOnMainScreen, applicationBusinessMandatoryFields.getCustomerType());
		clickSearchButton();
	}

	public Optional<String> getLabelMessage(WebElement ele) {
		return getFinder().getWebDriver().findElements((By) ele).stream()
				.map(WebElement::getText).findFirst();
	}

	private void editAndAddBusinessMandatoryFields(ApplicationBusinessMandatoryFields applicationBusinessMandatoryFields) {
		
		editFirstRecord();		
		
		runWithinPopup("Edit Business Mandatory Fields", () -> {
			if(checkBoxOneChk.isEnabled() && !checkBoxOneChk.isSelected())
			{
			WebElementUtils.checkCheckbox(checkBoxOneChk, true);
			}
			clickSaveButton();
		});
	}
	
	private void clickWhenClickable(MCWebElement element) {
		new WebDriverWait(driver(), timeoutInSec).until(WebElementUtils.elementToBeClickable(element)).click();
		waitForWicket();
	}
}
