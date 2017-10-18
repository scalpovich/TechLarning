package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_DEVICEBIN })
public class DeviceBinPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(DeviceBinPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=issuerBin]")
	private MCWebElement issuerBin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='networkCode']/span/select")
	private MCWebElement interchangeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='productType']/span/select")
	private MCWebElement productTypeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='binType']/span/select")
	private MCWebElement binTypeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='issuerBin']")
	private MCWebElement issuerBinTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='remarks']")
	private MCWebElement remarksTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='processorIca']")
	private MCWebElement processorIcaTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='issuerIca']")
	private MCWebElement issuerIcaTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='proxyIca']")
	private MCWebElement proxyIcaTxt;
@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceBinBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "networkCode:input:dropdowncomponent")
	private MCWebElement InterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "issuerBin:input:inputTextField")
	private MCWebElement IssuerBINTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "binType:input:dropdowncomponent")
	private MCWebElement BinTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement SearchIssuerBinTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processingBin:input:inputTextField")
	private MCWebElement ProcessingBINTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processorIca:input:inputTextField")
	private MCWebElement ProcessingICATxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "issuerIca:input:inputTextField")
	private MCWebElement IssuerICATxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "proxyIca:input:inputTextField")
	private MCWebElement ProxyICATxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "remarks:input:inputTextField")
	private MCWebElement RemarkTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelERROR")
	private MCWebElement ErrorDevicedelete;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='issuerBin']/..//div[@class='ketchup-error-container-alt']//ol//li[contains(text(),'Must be of length 6.')]")
	private MCWebElement IssuerBINLengthError;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='issuerBin']/..//div[@class='ketchup-error-container-alt']//ol//li[contains(text(),'Must be numeric.')]")
	private MCWebElement IssuerBINNumericError;

	public void clickaddDeviceBin() {
		clickWhenClickable(addDeviceBinBtn);
		switchToAddDeviceBinFrame();
	}

	public void switchToAddDeviceBinFrame() {
		switchToIframe(Constants.ADD_DEVICE_BIN_FRAME);
	}

	public void selectNetwork(DeviceBin DeviceBin) {
		selectByVisibleText(InterchangeDDwn, DeviceBin.getInterchange());
	}

	public String enterIssuerBIN(DeviceBin DeviceBin) {
		if (DeviceBin.getInterchange().contains("Mastercard")) {
			enterValueinTextBox(IssuerBINTxt, "5" + CustomUtils.RandomNumbers(5));
		} else if (DeviceBin.getInterchange().contains("Visa")) {
			enterValueinTextBox(IssuerBINTxt, "4" + CustomUtils.RandomNumbers(5));
		} else if (DeviceBin.getInterchange().contains("Rupay")) {
			enterValueinTextBox(IssuerBINTxt, "6" + CustomUtils.RandomNumbers(5));
		} else {
			enterValueinTextBox(IssuerBINTxt, "2" + CustomUtils.RandomNumbers(5));
		}
		return IssuerBINTxt.getAttribute("value");
	}

	public void selectproductType(DeviceCreation devicecreation) {
		selectByVisibleText(ProductTypeDDwn, devicecreation.getProduct());
	}

	public void selectBinType(DeviceBin DeviceBin) {
		selectByVisibleText(BinTypeDDwn, DeviceBin.getBinType());
	}

	public void enterProcessingBIN() {
		if (ProcessingBINTxt.isEnabled())
			enterValueinTextBox(ProcessingBINTxt, CustomUtils.RandomNumbers(6));
	}

	public void enterProcessingICA() {
		if (ProcessingICATxt.isEnabled())
			enterValueinTextBox(ProcessingICATxt, CustomUtils.RandomNumbers(6));
	}

	public void enterIssuerICA() {
		if (IssuerICATxt.isEnabled())
			enterValueinTextBox(IssuerICATxt, CustomUtils.RandomNumbers(6));
	}

	public void enterProxyICA() {
		if (ProxyICATxt.isEnabled())
			enterValueinTextBox(ProxyICATxt, CustomUtils.RandomNumbers(6));
	}

	public String enterRemarks(DeviceBin DeviceBin) {
		enterValueinTextBox(RemarkTxt, DeviceBin.getRemarks());
		return RemarkTxt.getAttribute("value");
	}

	public void clickSaveButton() {
		clickWhenClickable(saveBtn);
	}

	public boolean verifyErrorsOnDeviceBinPage() {
		return publishErrorOnPage();
	}

	public void verifyNewDeviceBinSuccess() {
		if (!verifyErrorsOnDeviceBinPage()) {
			logger.info("Device BIN Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public String addDeviceBinDetails(DeviceBin DeviceBin, DeviceCreation devicecreation) {
		String BIN;
		String Remarks;
		selectNetwork(DeviceBin);
		BIN = enterIssuerBIN(DeviceBin);
		selectproductType(devicecreation);
		selectBinType(DeviceBin);
		enterProcessingICA();
		enterProcessingBIN();
		enterIssuerICA();
		enterProxyICA();
		waitForPageToLoad(getFinder().getWebDriver());
		Remarks = enterRemarks(DeviceBin);
		clickSaveButton();
		return BIN;
	}

	public void editDeviceBin(String issuerBIN, String fieldUpdated, String updatedValue) {
		waitForElementVisible(addDeviceBinBtn);
		WebElement EditRupayNtkBtn = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + issuerBIN + "')]/following::td[2]/span/a/img[@alt='Edit Record']"));
		EditRupayNtkBtn.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.EDIT_DEVICE_PLAN_FRAME);

		if (fieldUpdated.equals("BINType")) {
			SelectDropDownByText(BinTypeDDwn, updatedValue);
		}
		if (fieldUpdated.equals("Remark")) {
			enterText(RemarkTxt, updatedValue);
		}
		ClickButton(saveBtn);
		SwitchToDefaultFrame();
	}

	public void deleteDeviceBin() {
		// System.out.println("//table[@class='dataview']/tbody/tr[" + i +
		// "]/td[3]");

		List<WebElement> Bins = getFinder().getWebDriver()
				.findElements(By.xpath("//table[@class='dataview']/tbody/tr"));
		int i = Bins.size();
		String issuerBIN = getFinder().getWebDriver()
				.findElement(By.xpath("//table[@class='dataview']/tbody/tr[" + i + "]/td[3]")).getText();
		System.out.println("//table[@class='dataview']/tbody/tr[" + i + "]/td[3]");
		getFinder().getWebDriver()
				.findElement(By.xpath(
						"//td[contains(.,'" + issuerBIN + "')]/following::td[3]/span/a/img[@alt='Delete Record']"))
				.click();
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		alert.accept();
		Assert.assertEquals(ErrorDevicedelete.getText(), Constants.Record_Cannot_Be_deleted);
	}

	public void deviceBinValidation(String interchangeType, String productType, String binType, String remark) {
		ClickButton(addDeviceBinBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe(Constants.ADD_DEVICE_BIN_FRAME);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(InterchangeDDwn, interchangeType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(ProductTypeDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(BinTypeDDwn, binType);
		enterText(IssuerBINTxt, CustomUtils.RandomNumbers(4));
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(RemarkTxt, remark);
		ClickButton(saveBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		Assert.assertTrue(IssuerBINLengthError.isVisible());
		IssuerBINTxt.clearField();
		enterText(IssuerBINTxt, "abcdef");
		ClickButton(saveBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		Assert.assertTrue(IssuerBINNumericError.isVisible());
		ClickButton(CancelBtn);

	}
	public void verifyUiOperationStatus() {
		logger.info("Device BIN");
		verifyUiOperation("Add Device BIN");
	}

	public void addDeviceBin(List<DeviceBin> dbList) {
		dbList.forEach(db -> {
			performSearchOperationOnMainScreen(db);
			if(isNoRecordsFoundInTable())
			{
				logger.info("create Devcie bin : {}", db.toString());
				clickAddNewButton();
				runWithinPopup("Add Device BIN", () -> {
					addBin(db);
					verifyNoErrors();
				});
				verifyOperationStatus();
			}
		});
	}

	private void addBin(DeviceBin db) {
		WebElementUtils.selectDropDownByVisibleText(interchangeDwn, db.getInterchange());
		WebElementUtils.selectDropDownByVisibleText(productTypeDwn, db.getProductType());
		WebElementUtils.selectDropDownByVisibleText(binTypeDwn, db.getBinType());
		WebElementUtils.enterText(issuerBinTxt, db.getIssuerBin());
		WebElementUtils.enterText(remarksTxt, db.getRemarks());
		WebElementUtils.enterText(processorIcaTxt, db.getIssuerBin());
		WebElementUtils.enterText(issuerIcaTxt, db.getIssuerBin());
		WebElementUtils.enterText(proxyIcaTxt, db.getIssuerBin());
		clickSaveButton();
	}

	private void performSearchOperationOnMainScreen(DeviceBin db)
	{
		WebElementUtils.enterText(issuerBin, db.getIssuerBin());
		clickSearchButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(issuerBin), WebElementUtils.elementToBeClickable(interchange));
	}
}
