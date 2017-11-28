package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1PROGRAM_SETUP, CardManagementNav.L2_DEVICE_RANGE })
public class DeviceRangePage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(DeviceRangePage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeSearchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:productCode:input:dropdowncomponent")
	private MCWebElement programDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:devicePlanCode:input:dropdowncomponent")
	private MCWebElement devicePlanCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:issuerBin:input:dropdowncomponent")
	private MCWebElement issuerBinDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:branchCode:input:dropdowncomponent")
	private MCWebElement branchDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Add]")
	private MCWebElement addBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:minCardRange:input:inputTextField")
	private MCWebElement fromDeviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:maxCardRange:input:inputTextField")
	private MCWebElement toDeviceNumberTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#endPointMode select")
	private MCWebElement endPointModeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#componentName select")
	private MCWebElement interfaceNameDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#routingType select")
	private MCWebElement routingTypeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#activeFlag select")
	private MCWebElement statusDDwn;
	@Autowired
	Program program;

	@Autowired
	DevicePlan deviceplan;

	@Autowired
	DeviceBin issuerbin;
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement AddDeviceRangeBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:productCode:input:dropdowncomponent")
	private MCWebElement ProgramDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:devicePlanCode:input:dropdowncomponent")
	private MCWebElement DevicePlanCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:issuerBin:input:dropdowncomponent")
	private MCWebElement IssuerBINDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:branchCode:input:dropdowncomponent")
	private MCWebElement BranchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:search")
	private MCWebElement AddTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:minCardRange:input:inputTextField")
	private MCWebElement FromDeviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:maxCardRange:input:inputTextField")
	private MCWebElement ToDeviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:activeFlag:input:dropdowncomponent")
	private MCWebElement StatusDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:endPointMode:input:dropdowncomponent")
	private MCWebElement EndpointDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeContainer:cardType:input:dropdowncomponent")
	private MCWebElement InterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:routingType:input:dropdowncomponent")
	private MCWebElement RoutingTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:componentName:input:dropdowncomponent")
	private MCWebElement InterfaceDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:cancel")
	private MCWebElement CancelBtn;

	int i = 0;

	public void clickAddDeviceRange() {
		clickWhenClickable(AddDeviceRangeBtn);
		switchToAddDeviceRangeFrame();
	}

	public void switchToAddDeviceRangeFrame() {
		switchToIframe(Constants.ADD_DEVICE_RANGE_FRAME);
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductTypeDDwn, deviceCreation.getProduct());
	}

	public void selectProgram() {
		waitForElementVisible(ProgramDDwn);
		if (MapUtils.fnGetInputDataFromMap("Program") != null) {
			selectByVisibleText(ProgramDDwn, MapUtils.fnGetInputDataFromMap("Program"));
		} else {
			selectByVisibleText(ProgramDDwn, program.getProgramCode());
		}

	}

	public void selectDevicePlan() {
		waitForElementVisible(DevicePlanCodeDDwn);
		if (MapUtils.fnGetInputDataFromMap("DevicePlan") != null) {
			selectByVisibleText(DevicePlanCodeDDwn, MapUtils.fnGetInputDataFromMap("DevicePlan"));
		} else {
			selectByVisibleText(DevicePlanCodeDDwn, deviceplan.getDevicePlan());
		}
	}

	public void selectIssuerBIN() {
		waitForElementVisible(IssuerBINDDwn);
		if (MapUtils.fnGetInputDataFromMap("DMSIssuerBIN") != null) {
			selectByVisibleText(IssuerBINDDwn, MapUtils.fnGetInputDataFromMap("DMSIssuerBIN"));
		} else if (MapUtils.fnGetInputDataFromMap("SMSIssuerBIN") != null) {
			selectByVisibleText(IssuerBINDDwn, MapUtils.fnGetInputDataFromMap("SMSIssuerBIN"));
		}
	}

	public void selectBranch() {
		SelectDropDownByIndex(BranchDDwn, 1);
	}

	public void clickAddButton() {
		clickWhenClickable(AddTxt);
	}

	public void enterFromDeviceNo() {
		if (MapUtils.fnGetInputDataFromMap("FromDeviceNo") != null) {
			enterValueinTextBox(FromDeviceNumberTxt, MapUtils.fnGetInputDataFromMap("FromDeviceNo"));
		} else {
			i = Integer.valueOf(CustomUtils.randomNumbers(6)) + 1;
			enterValueinTextBox(FromDeviceNumberTxt, String.valueOf(i) + Constants.FromDevice);
		}

	}

	public void enterToDeviceNo() {
		if (MapUtils.fnGetInputDataFromMap("ToDeviceNo") != null) {
			enterValueinTextBox(ToDeviceNumberTxt, MapUtils.fnGetInputDataFromMap("ToDeviceNo"));
		} else {
			enterValueinTextBox(ToDeviceNumberTxt, String.valueOf(i) + Constants.ToDevice);
		}

	}

	public void selectStatus() {
		waitForElementVisible(StatusDDwn);
		if (StatusDDwn.isEnabled()) {
			selectByVisibleText(StatusDDwn, "Active [1]");
		}
	}

	public void selectEndPoint() {
		if (EndpointDDwn.isEnabled()) {
			SelectDropDownByIndex(EndpointDDwn, 1);
		}
	}

	public void selectInterface() {
		if (InterfaceDDwn.isEnabled()) {
			SelectDropDownByIndex(InterfaceDDwn, 1);
		}
	}

	public void selectRoutingType() {
		if (RoutingTypeDDwn.isEnabled()) {
			SelectDropDownByIndex(RoutingTypeDDwn, 1);
		}
	}

	@Override
	public void clickSaveButton() {
		clickWhenClickable(SaveBtn);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnDeviceRangePage() {
		return publishErrorOnPage();
	}

	public void verifyDeviceRangeSuccess() {
		if (!verifyErrorsOnDeviceRangePage()) {
			logger.info("Device Range Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void addDeviceRange(DeviceCreation devicecreation) {
		selectProduct(devicecreation);
		selectProgram();
		selectDevicePlan();
		selectIssuerBIN();
		selectBranch();
		clickAddButton();
	}

	public void addDeviceRangeDetails() {
		enterFromDeviceNo();
		enterToDeviceNo();
	}

	public void selectDebitInerface() {
		selectEndPoint();
		selectInterface();
		selectRoutingType();
	}

	public void Information() {
		selectStatus();
	}

	public void configureDeviceranges(String prodType) {
		ClickButton(AddDeviceRangeBtn);
		switchToIframe(Constants.ADD_DEVICE_RANGE_FRAME);
		SelectDropDownByText(ProductTypeDDwn, prodType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(ProgramDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(BranchDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DevicePlanCodeDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(IssuerBINDDwn, 1);

	}

	public void verifyInterchangeTypes(ExamplesTable interchangeTable) {
		String DropDownValue = null;
		for (int i = 0; i < interchangeTable.getRows().size(); i++) {
			DropDownValue = interchangeTable.getRow(i).get(interchangeTable.getHeaders().get(0));
			List<WebElement> interchangePresent = InterchangeDDwn.getSelect().getOptions();
			if ((interchangePresent.get(1).getText()).contains(DropDownValue)) {
				logger.info("Interchange " + DropDownValue + "  is present");
			} else if ((interchangePresent.get(2).getText()).contains(DropDownValue)) {
				logger.info("Interchange " + DropDownValue + "  is present");

			} else if ((interchangePresent.get(3).getText()).contains(DropDownValue)) {
				logger.info("Interchange " + DropDownValue + "  is present");
			} else {
				Assert.fail("Interchange is not present");

			}

			// List<Map<String, String>> aSAS = interchangeTable.getRows().get;

			// String interchangedropDown =
			// InterchangeDDwn.getSelect().getOptions().get(i).getText();
			// aSAS.contains(DropDownValue);

			//
			//
			// for (WebElement we : interchangedropDown) {
			// match = false;
			// if (we.getText().equals(DropDownValue)) {
			// match = true;
			// }
			//
			// }
			// Assert.assertTrue(aSAS.contains(DropDownValue));

		}

	}
	public void selectProductType(String productType) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn,
				productType);
	}

	public void selectProgram(String program) {
		WebElementUtils.selectDropDownByVisibleText(programDDwn, program);
	}

	public void selectDevicePlanCode(String devicePlanCode) {
		WebElementUtils.selectDropDownByVisibleText(devicePlanCodeDDwn,
				devicePlanCode);
	}

	public void selectIssuerBin(String issuerBin) {
		WebElementUtils.selectDropDownByVisibleText(issuerBinDDwn, issuerBin);
	}

	public void selectBranch(String branch) {
		WebElementUtils.selectDropDownByVisibleText(branchDDwn, branch);
	}

	public void addFromDeviceNumber(String fromDeviceNumber) {
		WebElementUtils.enterText(fromDeviceNumberTxt, fromDeviceNumber);
	}

	public void addToDeviceNumber(String toDeviceNumber) {
		WebElementUtils.enterText(toDeviceNumberTxt, toDeviceNumber);
	}

	// Method to fill data in Add Device Range
	public void addDeviceRangeData(DeviceRange deviceRange) {
		logger.info("Device Range: {}", deviceRange.getDevicePlanCode());
		clickAddNewButton();
		runWithinPopup(
				"Add Device Range",
				() -> {
					fillAddDevicePage(deviceRange);

					addFromDeviceNumber(deviceRange.getFromDeviceNumber());
					log.info("From addFromDeviceNumber = " + deviceRange.getFromDeviceNumber());
					addToDeviceNumber(deviceRange.getToDeviceNumber());
					log.info("To addFromDeviceNumber = " + deviceRange.getToDeviceNumber());

					forDebitCard(deviceRange);

					WebElementUtils.selectDropDownByVisibleText(statusDDwn, deviceRange.getStatus());

					WebElementUtils.scrollDown(driver(), 100, 250);
					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

	private void fillAddDevicePage(DeviceRange deviceRange) {
		selectProductType(deviceRange.getProductType());
		selectProgram(deviceRange.getProgram());
		selectDevicePlanCode(deviceRange.getDevicePlanCode());
		selectIssuerBin(deviceRange.getIssuerBin());
		selectBranch(deviceRange.getBranch());
		addBtn.click();
		waitForWicket();
	}

	private void forDebitCard(DeviceRange deviceRange) {
		if (ProductType.DEBIT.equalsIgnoreCase(deviceRange.getProductType())) {
			WebElementUtils.selectDropDownByVisibleText(endPointModeDDwn, deviceRange.getEndPointMode());
			WebElementUtils.selectDropDownByVisibleText(routingTypeDDwn, deviceRange.getRoutingType());
			WebElementUtils.selectDropDownByVisibleText(interfaceNameDDwn, deviceRange.getInterfaceName());
		}
	}

	public void verifyUiOperationStatus() {
		logger.info("Device Range");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils
				.visibilityOf(productTypeSearchDDwn));
	}

}
