package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessMandatory;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_APPLICATION,
		CardManagementNav.L3_BUSINESS_MANDATORY_FIELDS })
public class BusinessMandatoryFieldsPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(BusinessMandatoryFieldsPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement customerType;

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	@Autowired
	Program program;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBusinessMandatoryFields;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerType:input:dropdowncomponent")
	private MCWebElement CustomerType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement ProgramCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement AddDetails;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fieldName:input:dropdowncomponent")
	private MCWebElement FieldName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bmfmSearchPanel:search")
	private MCWebElement search;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	public void clickAddBusinessMandatoryFields() {
		waitForElementVisible(addBusinessMandatoryFields);
		addBusinessMandatoryFields.click();
	}

	public void switchToAddBusinessMandatoryFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public void selectCustomerType() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(CustomerType);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(CustomerType, getCustomerType());
	}

	public void selectProgram() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(ProgramCodeDDwn);
		CustomUtils.ThreadDotSleep(1000);
		selectByVisibleText(ProgramCodeDDwn, program.getProgram());
		// selectByVisibleText(ProgramCodeDDwn, "program [405]");
	}

	public void clickSearch() {
		waitForElementVisible(search);
		search.click();
		CustomUtils.ThreadDotSleep(3000);
	}

	public void selectMandatoryFields(String filepath) {
		String FieldToBeAdded = "";
		// String filepath = System.getProperty("user.dir") +
		// "/src/main/resources/config/"
		// + System.getProperty("environment") + File.separator + "TestData" +
		// File.separator + excelFileName;

		HashMap<String, HashMap<String, String>> map = excelTestData.fnReadEntireTestData(filepath, "Sheet1",
				"SequenceNo.");
		for (int i = 1; i < map.size(); i++) {
			excelTestData.dataProviderIterator(map, String.valueOf(i));
			String Value = MapUtils.getIterativeDataFromDatamap("Value (Y/N)");
			if (Value.contains("Y")) {
				FieldToBeAdded = MapUtils.getIterativeDataFromDatamap("Field Name");
				CustomUtils.ThreadDotSleep(3000);
				WebElement Field = getFinder().getWebDriver().findElement(
						By.xpath("//table[@class='dataview']//td[contains(.,'" + FieldToBeAdded + "')]/..//input"));
				CustomUtils.ThreadDotSleep(1000);
				if (!Field.isSelected()) {
					CustomUtils.ThreadDotSleep(1000);
					Field.click();

				}
			}

		}
	}

	public void clickSaveButton() {
		CustomUtils.ThreadDotSleep(2000);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		ClickButton(save);
		try {
			if (PanelInfo.isVisible()) {
				Assert.assertEquals(PanelInfo.getText(), Constants.Record_Added_Successfully);
			}
		} catch (Exception e) {
			logger.error(e.toString());
			try {
				if (PanelErrorTxt.isVisible()) {
					logger.info("inside error pannel");
					cancel.click();
				}
			} catch (Exception e1) {
				logger.error(e1.toString());
				logger.info("error pannel not present");
			}
		}
		SwitchToDefaultFrame();
	}

	public void addbusinessmandatoryfields(String product) {
		addBusinessMandatoryFields.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_FRAME);
		SelectDropDownByText(ProductType, product);
		waitForElementVisible(CustomerType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(CustomerType);
		SelectDropDownByIndex(CustomerType, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		waitForElementVisible(save);
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());

		try {
			if (PanelError.isVisible()) {
				logger.info("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			addBusinessMandFieldDetails();
			// addWicketAjaxListeners(getFinder().getWebDriver());

			SwitchToDefaultFrame();
			addWicketAjaxListeners(getFinder().getWebDriver());
			switchToIframe(Constants.ADD_BUSINESS_MANDATORY_FRAME);
			addWicketAjaxListeners(getFinder().getWebDriver());
			ClickButton(save);
		}
		SwitchToDefaultFrame();

	}

	public void addBusinessMandFieldDetails() {
		addSubDetails.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_DETAILS_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(FieldName, 1);
		ClickButton(save);

	}

	public void addbusinessmandatoryfieldsprepaid() {
		addBusinessMandatoryFields.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		ProductType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.businessmandatoryfieldspr.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		CustomerType.getSelect()
				.selectByVisibleText(env.getProperty("is.dinners.businessmandatoryfieldspr.CustomerType"));
		CustomUtils.ThreadDotSleep(1000);

		save.click();
		CustomUtils.ThreadDotSleep(2000);

		// Adding child records

		try {
			if (PanelError.isVisible()) {
				logger.info("inside error pannel");
				cancel.click();
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
			addSubDetails.click();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().defaultContent();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().frame("_wicket_window_16");
			CustomUtils.ThreadDotSleep(2000);

			FieldName.getSelect()
					.selectByVisibleText(env.getProperty("is.dinners.businessmandatoryfieldspr.FieldName"));

			save.click();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().defaultContent();

			getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
			CustomUtils.ThreadDotSleep(2000);
			save.click();
			CustomUtils.ThreadDotSleep(2000);

		}
		getFinder().getWebDriver().switchTo().defaultContent();

	}
	public void verifyUiOperationStatus() {
		logger.info("Business Mandatory Fields");
		verifyUiOperation("Add Business Mandatory Fields");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(productType),
				WebElementUtils.elementToBeClickable(customerType));
	}
}
