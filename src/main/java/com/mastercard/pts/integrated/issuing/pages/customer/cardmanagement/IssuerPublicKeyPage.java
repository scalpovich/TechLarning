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
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2EMV,
		CardManagementNav.L3IPK_CERTIFICATE_INFORMATION })
public class IssuerPublicKeyPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(IssuerPublicKeyPage.class);
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@Autowired
	DatePicker date;

	public String expiryCal = "//span[@id='certExpDate']";

	public String issueYear = "//span[@id = 'certIssDate']";

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addIssuerPublicKey;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement ipkIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:1:cols:nextCol:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement issuerBINDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:nextCol:colspanMarkup:inputField:input:inputTextField")
	private MCWebElement serialNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/img")
	private MCWebElement issueDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement issueDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/span/table/tbody/tr[3]/td[1]/a")
	private MCWebElement selectIssueDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/img")
	private MCWebElement expiryDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement expiryDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/tbody/tr[4]/td[3]/a")
	private MCWebElement selectExpiryDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement statusDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'cancel']")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement panelErrorTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement panelInfo;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/thead/tr[1]/th/div/a[2]/img")
	private MCWebElement expiryDateCalendar;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "calnav")
	private MCWebElement calendarNav;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "yui-cal-nav-yc")
	private MCWebElement yearTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class ='yui-cal-nav-btn yui-default']/button")
	private MCWebElement okBtn;

	public void clickaddIPKCertification() {
		clickWhenClickable(addIssuerPublicKey);
		switchTOAddIPKFrame();
	}

	public void switchTOAddIPKFrame() {
		switchToIframe(Constants.ADD_IPK_FRAME);
	}

	public void enterIPKId() {
		enterValueinTextBox(ipkIDTxt, CustomUtils.randomNumbers(6));
	}

	public void selectInterchangeType(IssuerPublicKey ipk) {
		selectByVisibleText(interchangeDDwn, ipk.getInterchange());
	}

	public void selectIssuerBin(IssuerPublicKey ipk) {
		logger.info("Issuer bin Selected - " + ipk.getDeviceBin());
		selectByVisibleText(issuerBINDDwn, ipk.getDeviceBin());
	}

	public void enterSerialNumber() {
		enterValueinTextBox(serialNumberTxt, CustomUtils.randomNumbers(6));

	}

	public void selectExpiryDate(IssuerPublicKey ipk) {
		date.setDateCalendar2(ipk.getIPKExpiryDate(), expiryCal);
	}

	public void selectIssuerDate(IssuerPublicKey ipk) {
		date.setDateCalendar2(ipk.getIssuerDate(), issueYear);
	}

	public void selectStatus(IssuerPublicKey ipk) {
		selectDropDownByText(statusDDwn, ipk.getStatus());
	}
	
	@Override
	public void clickSaveButton() {
		clickWhenClickable(save);
	}

	public boolean verifyErrorsOnIpkPage() {
		return publishErrorOnPage();
	}

	public void verifyIpkSuccess() {
		if (!verifyErrorsOnIpkPage()) {
			logger.info("Ipk Added Successfully");
			switchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(cancelBtn);
			switchToDefaultFrame();
		}
	}

	public void addIPKDetails(IssuerPublicKey ipk) {
		enterIPKId();
		selectInterchangeType(ipk);
		selectIssuerBin(ipk);
		enterSerialNumber();
		selectIssuerDate(ipk);
		selectExpiryDate(ipk);
		selectStatus(ipk);
		clickSaveButton();
		switchToDefaultFrame();
	}
}
