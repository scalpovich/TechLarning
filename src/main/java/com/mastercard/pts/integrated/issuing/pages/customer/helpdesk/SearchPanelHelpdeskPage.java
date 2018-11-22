package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class SearchPanelHelpdesk.
 */
@Component
public class SearchPanelHelpdeskPage extends AbstractBasePage {
	
	@Autowired
	TestContext context;
	
	@Autowired
	private KeyValueProvider provider;
	
	public static final String UPLOAD_EXPECTED_STATUS="NORMAL [0]";
	public static final String STATUS_DEVICE_NOT_NORMAL="device status is not normal";
	private static final Logger logger = LoggerFactory.getLogger(SearchPanelHelpdeskPage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement regMobileNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement clientCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement embName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement packID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:6:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement callReferenceNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement firstName;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputCodeField")
	private MCWebElement firstNameInput;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement deviceNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dateTextField")
	private MCWebElement birthDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement lastName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement CBSClientID;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@alt='Edit Record']")
	private MCWebElement editBtn;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr//following-sibling::td[7]/span")
	private MCWebElement normalStatusTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='client.firstName']")
	private MCWebElement firstNameUploadTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='client.lastName']")
	private MCWebElement lastNameUploadTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='client.registeredMobileNumber']")
	private MCWebElement mobileNumberUploadTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr//following-sibling::td[1]/span/a/span")
	private MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr//following-sibling::td[8]/span")
	private MCWebElement normalStatusCreditTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='headers']//span")
	private MCWebElements headersTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[text()='Client Customer Id :']/../following-sibling::td[1]//*[@class='labeltextf']")
	private MCWebElement clientCustomerID;
	
	public MCWebElement getEditBtn() {
		return editBtn;
	}

	public void searchDevice(String productType, String deviceNumber) {
		waitForElementVisible(this.productType);
		selectDropDownByText(this.productType, productType);
		waitForElementVisible(this.deviceNumber);
		enterText(this.deviceNumber, deviceNumber);
		waitForElementVisible(searchBtn);
		searchBtn.click();
	}

	public void clickEditBtn() {
		waitForElementVisible(editBtn);
		editBtn.click();
	}

	public void clickSearchBtn() {
		waitForElementVisible(searchBtn);
		searchBtn.click();
	}

	public String searchDeviceUsingNumber(String productType, String deviceNumber) {
		waitForElementVisible(this.productType);
		selectDropDownByText(this.productType, productType);
		enterText(this.deviceNumber, deviceNumber);
		logger.info("Device Number :{}",deviceNumber );
		waitForElementVisible(searchBtn);
		clickWhenClickable(searchBtn);
		return normalStatusTxt.getText();
	}

	public String searchNewDevice(String productType, String deviceNumber) {
		waitForElementVisible(this.productType);
		selectDropDownByText(this.productType, productType);
		waitForElementVisible(this.deviceNumber);
		enterText(this.deviceNumber, deviceNumber);
		waitForElementVisible(searchBtn);
		searchBtn.click();
		SimulatorUtilities.wait(4000);
		return getCellTextByColumnName(Constants.TABLE_ROW_NUM, Constants.COLUMN_NAME);
	}
	
	public String getClientCustomerID(String productType, String deviceNumber) {
		Device device = Device.createWithProvider(provider);
		searchNewDevice(productType, deviceNumber);
		viewFirstRecord();
		SimulatorUtilities.wait(500);
		runWithinPopup("View General", () -> {
			context.put(CreditConstants.CLIENT_CUSTOMER_ID, clientCustomerID.getText());
			device.setMandatoryFieldValue(clientCustomerID.getText());
			context.put(ContextConstants.DEVICE, device);
			logger.info(" Client Customer ID : {}", clientCustomerID.getText());
			clickCloseButton();
		});
		return context.get(CreditConstants.CLIENT_CUSTOMER_ID);
	}
	
	public void normalStatusCheckFileUploadInBulk(String productType,Map<String, Object>mapFileUpload) {
		int counter=0;
		waitForElementVisible(this.productType);
		selectDropDownByText(this.productType, productType);
		for (Map.Entry<String, Object> entry : mapFileUpload.entrySet()) {
			counter++;
			HelpDeskGeneral helpDeskGeneral=(HelpDeskGeneral) entry.getValue();
			WebElementUtils.enterText(firstNameUploadTxt,helpDeskGeneral.getFirstName());
			WebElementUtils.enterText(lastNameUploadTxt,helpDeskGeneral.getLastName());
			WebElementUtils.enterText(mobileNumberUploadTxt,helpDeskGeneral.getMobileNumber());
			clickSearchButton();
			waitForPageToLoad(driver());
			SimulatorUtilities.wait(3000);
			String normalStatus=driver().findElement(By.xpath("//table[@class='dataview']//tr//following-sibling::td["+statusHeader()+"]/span")).getText();
			assertThat(STATUS_DEVICE_NOT_NORMAL, normalStatus, equalTo(UPLOAD_EXPECTED_STATUS));
			logger.info("Device Number :" +"  "+counter+"   "+ "-" +" "+ deviceNumberTxt.getText());
		}
	}
	
	public int statusHeader() {
		int index = 0;
		for (int i = 0; i < headersTxt.getElements().size(); i++) {
			if (headersTxt.getElements().get(i).getText().equalsIgnoreCase("Status")) {
				index = i;
			}
		}
		return index + 1;

	}
}
