package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DeviceRangePage extends MPTSBasePage {
	final Logger logger = LoggerFactory.getLogger(DeviceRangePage.class);

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

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "CardRangeDetailContainer:cancel")
	private MCWebElement CancelBtn;

	public void adddevicerange(String prodType, String program, String fromDeviceNo, String toDeviceNo,
			String statusValue, String deviceType, String endpoint) {
		ClickButton(AddDeviceRangeBtn);
		switchToIframe(Constants.ADD_DEVICE_RANGE_FRAME);
		SelectDropDownByText(ProductTypeDDwn, prodType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProgramDDwn, program);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DevicePlanCodeDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(IssuerBINDDwn, 1);
		String IssuerBIN1 = IssuerBINDDwn.getText();

		String IssuerBIN = IssuerBIN1.replaceAll("[^\\d]", "").trim();
		MapUtils.fnSetInputDataToInputMap("IssuerBIN", IssuerBIN);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(BranchDDwn, 1);
		ClickButton(AddTxt);
		enterText(FromDeviceNumberTxt, fromDeviceNo);
		enterText(ToDeviceNumberTxt, toDeviceNo);
		SelectDropDownByText(StatusDDwn, statusValue);
		if (deviceType.equalsIgnoreCase("Limited Validity Virtual Card [8]")) {
			addWicketAjaxListeners(getFinder().getWebDriver());
			SelectDropDownByText(EndpointDDwn, endpoint);
		}
		ClickButton(SaveBtn);
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
		}
		SwitchToDefaultFrame();
	}

	public void adddevicerangeprepaid(String prodType, String program, String fromDeviceNo, String toDeviceNo,
			String statusValue) {
		ClickButton(AddDeviceRangeBtn);
		switchToIframe(Constants.ADD_DEVICE_RANGE_FRAME);
		SelectDropDownByText(ProductTypeDDwn, prodType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProgramDDwn, program);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(DevicePlanCodeDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(IssuerBINDDwn, 1);
		String IssuerBIN1 = IssuerBINDDwn.getText();

		String IssuerBIN = IssuerBIN1.replaceAll("[^\\d]", "").trim();
		MapUtils.fnSetInputDataToInputMap("IssuerBIN", IssuerBIN);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(BranchDDwn, 1);
		ClickButton(AddTxt);
		enterText(FromDeviceNumberTxt, fromDeviceNo);
		enterText(ToDeviceNumberTxt, toDeviceNo);
		SelectDropDownByText(StatusDDwn, statusValue);
		ClickButton(SaveBtn);
		try {
			if (PanelErrorTxt.isVisible()) {
				logger.info("inside error pannel");
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			logger.info("error pannel not present");
		}
		SwitchToDefaultFrame();
		// return IssuerBINDDwn.getText();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
