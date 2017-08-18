package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP, CardManagementNav.L2_DEVICE_RANGE })
public class DeviceRangePage extends AbstractModelPage {

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
					selectProductType(deviceRange.getProductType());
					selectProgram(deviceRange.getProgram());
					selectDevicePlanCode(deviceRange.getDevicePlanCode());
					selectIssuerBin(deviceRange.getIssuerBin());
					selectBranch(deviceRange.getBranch());
					addBtn.click();
					waitForWicket();

					addFromDeviceNumber(deviceRange.getFromDeviceNumber());
					addToDeviceNumber(deviceRange.getToDeviceNumber());

					if (ProductType.DEBIT.equalsIgnoreCase(deviceRange
							.getProductType())) {
						WebElementUtils.selectDropDownByVisibleText(
								endPointModeDDwn, deviceRange.getEndPointMode());
						WebElementUtils.selectDropDownByVisibleText(
								routingTypeDDwn, deviceRange.getRoutingType());
						WebElementUtils.selectDropDownByVisibleText(
								interfaceNameDDwn, deviceRange.getInterfaceName());
					}

					WebElementUtils.selectDropDownByVisibleText(statusDDwn,
							deviceRange.getStatus());

					pageScrollDown();
					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
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
