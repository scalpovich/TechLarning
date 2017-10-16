package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MPTSBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DeviceBinPage extends MPTSBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceBin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement Interchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "issuerBin:input:inputTextField")
	private MCWebElement IssuerBIN;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "binType:input:dropdowncomponent")
	private MCWebElement BinType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processingBin:input:inputTextField")
	private MCWebElement ProcessingBIN;

	@PageElement(findBy = FindBy.NAME, valueToFind = "remarks:input:inputTextField")
	private MCWebElement Remark;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	public String adddevicebin(String interchangeType, String productType, String binType, String remark) {
		ClickButton(addDeviceBin);
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_BIN_FRAME);
		SelectDropDownByText(Interchange, interchangeType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(IssuerBIN, CustomUtils.randomNumbers(6));
		SelectDropDownByText(ProductType, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(BinType, binType);
		if (productType.equalsIgnoreCase("Prepaid [P]")) {
			enterText(ProcessingBIN, CustomUtils.randomNumbers(6));
		}
		enterText(Remark, remark);
		ClickButton(save);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SwitchToDefaultFrame();
		return IssuerBIN.getText();

	}

	public String adddevicebinprepaid() {
		addDeviceBin.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		Interchange.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicebinpr.interchange"));
		CustomUtils.ThreadDotSleep(1000);
		// IssuerBIN.sendKeys(env.getProperty("is.dinners.devicebin.issuerbin"));
		IssuerBIN.sendKeys("610000");
		CustomUtils.ThreadDotSleep(1000);
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicebinpr.producttype"));
		CustomUtils.ThreadDotSleep(1000);
		BinType.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicebinpr.bintype"));
		CustomUtils.ThreadDotSleep(1000);
		// ProcessingBIN.sendKeys(env.getProperty("is.dinners.devicebin.processingbin"));
		ProcessingBIN.sendKeys(CustomUtils.randomNumbers(6));
		CustomUtils.ThreadDotSleep(1000);
		Remark.sendKeys(env.getProperty("is.dinners.devicebinpr.remark"));

		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		return IssuerBIN.getText();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}
}
