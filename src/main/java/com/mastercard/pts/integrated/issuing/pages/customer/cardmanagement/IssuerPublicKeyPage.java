package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2EMV,
		CardManagementNav.L3IPK_CERTIFICATE_INFORMATION })

public class IssuerPublicKeyPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(IssuerPublicKeyPage.class);
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

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
		waitForElementVisible(addIssuerPublicKey);
		addIssuerPublicKey.click();
	}

	public void switchTOAddIPKFrame() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe("Add Ipk Certificate Information");
	}

	public void enterIPKId() {
		enterText(IPKID, CustomUtils.randomNumbers(6));
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void selectInterchangeType(DeviceCreation deviceCreation) {
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectByVisibleText(Interchange, deviceCreation.getInterchange());
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void selectIssuerBin() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(IssuerBIN, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void enterSerialNumber() {
		enterText(SerialNumber, CustomUtils.randomNumbers(6));
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void selectDate() {
		IssueDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		// IssueDateNxtMonth.click();
		selectIssueDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		ExpiryDate.click();
		CustomUtils.ThreadDotSleep(1000);
		// ExpiryDateCalendar.click();
		List<WebElement> calendar = getFinder().getWebDriver().findElements(By.xpath("//a[@class='calnav']"));
		calendar.get(1).click();
		waitForElementVisible(YearTxt);
		YearTxt.clearField();
		enterText(YearTxt, "2050");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(OkBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectExpiryDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
	}

	public void selectStatus() {
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(Status, "Active [1]");
	}

	public void clickSaveButton() {
		addWicketAjaxListeners(getFinder().getWebDriver());
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
					CancelBtn.click();
				}
			} catch (Exception e1) {
				logger.error(e1.toString());
				logger.info("error pannel not present");
			}
		}
		SwitchToDefaultFrame();
	}

	public void addIPKCertificateInformation() {
		addIssuerPublicKey.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		switchToIframe("Add Ipk Certificate Information");
		enterText(IPKID, CustomUtils.randomNumbers(6));
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByText(Interchange, MapUtils.fnGetInputDataFromMap("InterchangeType"));
		// SelectDropDownByIndex(Interchange, 2);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		SelectDropDownByIndex(IssuerBIN, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		enterText(SerialNumber, CustomUtils.randomNumbers(6));
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		IssueDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		// IssueDateNxtMonth.click();
		selectIssueDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);
		ExpiryDate.click();
		CustomUtils.ThreadDotSleep(1000);
		// ExpiryDateCalendar.click();
		List<WebElement> calendar = getFinder().getWebDriver().findElements(By.xpath("//a[@class='calnav']"));
		calendar.get(1).click();
		waitForElementVisible(YearTxt);
		YearTxt.clearField();
		enterText(YearTxt, "2050");
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(OkBtn);
		addWicketAjaxListeners(getFinder().getWebDriver());
		addWicketAjaxListeners(getFinder().getWebDriver());
		selectExpiryDate.click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		CustomUtils.ThreadDotSleep(1000);

		SelectDropDownByText(Status, "Active [1]");
		ClickButton(save);
		try {
			addWicketAjaxListeners(getFinder().getWebDriver());
			if (PanelErrorTxt.isVisible()) {
				waitForElementVisible(CancelBtn);
				ClickButton(CancelBtn);
			}
		} catch (Exception e) {
			SwitchToDefaultFrame();
			CustomUtils.ThreadDotSleep(1000);
		}
		SwitchToDefaultFrame();
	}
}
