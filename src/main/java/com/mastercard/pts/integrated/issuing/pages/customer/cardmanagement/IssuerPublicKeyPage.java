package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.IssuerPublicKey;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2EMV,
		CardManagementNav.L3IPK_CERTIFICATE_INFORMATION })

public class IssuerPublicKeyPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(IssuerPublicKeyPage.class);
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@Autowired
	DatePicker date;

	public String ExpiryCal = "//span[@id='certExpDate']";

	public String ExpiryYear = "//span[@id = 'certIssDate']";

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addIssuerPublicKey;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement IPKID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Interchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement IssuerBIN;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement SerialNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/img")
	private MCWebElement IssueDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement IssueDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/span/table/tbody/tr[3]/td[1]/a")
	private MCWebElement selectIssueDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/img")
	private MCWebElement ExpiryDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement ExpiryDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/tbody/tr[4]/td[3]/a")
	private MCWebElement selectExpiryDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement Status;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'cancel']")
	private MCWebElement CancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/thead/tr[1]/th/div/a[2]/img")
	private MCWebElement ExpiryDateCalendar;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "calnav")
	private MCWebElement CalendarNav;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "yui-cal-nav-yc")
	private MCWebElement YearTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class ='yui-cal-nav-btn yui-default']/button")
	private MCWebElement OkBtn;

	public void clickaddIPKCertification() {
		clickWhenClickable(addIssuerPublicKey);
		switchTOAddIPKFrame();
	}

	public void switchTOAddIPKFrame() {
		switchToIframe(Constants.ADD_IPK_FRAME);
	}

	public void enterIPKId() {
		enterValueinTextBox(IPKID, CustomUtils.randomNumbers(6));
	}

	public void selectInterchangeType(IssuerPublicKey ipk) {
		selectByVisibleText(Interchange, ipk.getInterchange());
	}

	public void selectIssuerBin(IssuerPublicKey ipk) {
		System.out.println(ipk.getDeviceBin());
		selectByVisibleText(IssuerBIN, ipk.getDeviceBin());

	}

	public void enterSerialNumber() {
		enterValueinTextBox(SerialNumber, CustomUtils.randomNumbers(6));

	}

	public void selectExpiryDate(IssuerPublicKey ipk) {
		date.setDateCalendar2(ipk.getIPKExpiryDate(), ExpiryCal);
	}

	public void selectIssuerDate(IssuerPublicKey ipk) {
		date.setDate(ipk.getIssuerDate());
	}

	public void selectStatus(IssuerPublicKey ipk) {
		SelectDropDownByText(Status, ipk.getStatus());
	}

	public void clickSaveButton() {
		clickWhenClickable(save);
	}

	public boolean verifyErrorsOnIpkPage() {
		return publishErrorOnPage();
	}

	public void verifyIpkSuccess() {
		if (!verifyErrorsOnIpkPage()) {
			logger.info("Ipk Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void addIPKDetails(IssuerPublicKey ipk) {
		enterIPKId();
		selectInterchangeType(ipk);
		selectIssuerBin(ipk);
		enterSerialNumber();
		selectExpiryDate(ipk);
		selectIssuerDate(ipk);
		selectStatus(ipk);
		clickSaveButton();
		SwitchToDefaultFrame();
	}
}
