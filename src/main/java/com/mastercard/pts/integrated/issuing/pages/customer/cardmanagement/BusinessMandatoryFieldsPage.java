package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessMandatory;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.ReadTestDataFromExcel;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2APPLICATION, CardManagementNav.L3BUSINESS_MANDATORY_FIELDS })
public class BusinessMandatoryFieldsPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(EmbossingPriorityPassPage.class);

	@Autowired
	private ReadTestDataFromExcel excelTestData;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBusinessMandatoryFieldsBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelError;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "customerType:input:dropdowncomponent")
	private MCWebElement CustomerTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement ProgramCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement AddDetailsBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetailsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "fieldName:input:dropdowncomponent")
	private MCWebElement FieldNameDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "bmfmSearchPanel:search")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

	public void clickAddBusinessMandatoryFields() {
		clickWhenClickable(addBusinessMandatoryFieldsBtn);
		switchToAddBusinessMandatoryFrame();
	}

	public void switchToAddBusinessMandatoryFrame() {
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectCustomerType(BusinessMandatory businessmandate) {
		waitForElementVisible(CustomerTypeDDwn);
		selectByVisibleText(CustomerTypeDDwn, businessmandate.getCustomerType());
	}

	public void selectProgram(Program program) {
		waitForElementVisible(ProgramCodeDDwn);
		if (MapUtils.fnGetInputDataFromMap("Program") != null) {
			selectByVisibleText(ProgramCodeDDwn, MapUtils.fnGetInputDataFromMap("Program"));
		} else {
			selectByVisibleText(ProgramCodeDDwn, program.getProgram());
		}
		// selectByVisibleText(ProgramCodeDDwn, "program [405]");
	}

	public void clickSearch() {
		clickWhenClickable(searchBtn);
	}

	public void selectMandatoryFields(String filepath) {
		String FieldToBeAdded = "";
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
		clickWhenClickable(saveBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnBusinessMandatesPage() {
		return publishErrorOnPage();
	}

	public void verifyBusinessMandatesSuccess() {
		if (!verifyErrorsOnBusinessMandatesPage()) {
			logger.info("Business Mandate Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void selectBusinessmandatory(DeviceCreation deviceCreation, BusinessMandatory businessmandate,
			Program program) {
		selectProduct(deviceCreation);
		selectCustomerType(businessmandate);
		selectProgram(program);
		clickSaveButton();
	}

	public void addBusinessMandFieldDetails() {
		clickWhenClickable(addSubDetailsBtn);
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_BUSINESS_MANDATORY_DETAILS_FRAME);
		SelectDropDownByIndex(FieldNameDDwn, 1);
		clickSaveButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
