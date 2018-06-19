package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.CardStatus;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.ChangeAddressRequest;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.EventAndAlerts;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.HelpdeskNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class GeneralPage.
 */
@Component
@Navigation(tabTitle = HelpdeskNav.TAB_HELPDESK, treeMenuItems = { HelpdeskNav.L1_ACTIVITY, HelpdeskNav.L2_GENERAL })
public class GeneralPage extends AbstractBasePage {

	// public GeneralPage(String title, String firstName, String familyName,
	// String embossedName, String relation) {
	// super(title, firstName, familyName, embossedName, relation);
	// }

	// EventAndAlerts eventAndAlerts;

	@Autowired
	ChangeAddressRequest changeAddressRequest;

	@Autowired
	DateUtils dateUtils;

	@Autowired
	HelpDeskGeneral helpdeskgettersetter;

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	// View General > Device and Client Details
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement closeBtn;

	// General
	@PageElement(findBy = FindBy.NAME, valueToFind = "helpdeskDetailContainer:serviceCode:input:dropdowncomponent")
	private MCWebElement serviceCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "helpdeskDetailContainer:go")
	private MCWebElement serviceCodeGoBtn;

	// Genaral tab buttons
	@PageElement(findBy = FindBy.NAME, valueToFind = "authorizations")
	private MCWebElement authorizationBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "Transactions")
	private MCWebElement transactionsBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "changeHistory")
	private MCWebElement chargeBackHistoryBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "loyalty")
	private MCWebElement loyaltyBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceWalletAct")
	private MCWebElement deviceAndWalletActBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "serviceHistory")
	private MCWebElement serviceHistoryBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "notesHistory")
	private MCWebElement notesHistoryBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "addNotes")
	private MCWebElement addNotesBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "endCall")
	private MCWebElement endCallBtn;

	// Error message
	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelERROR")
	private MCWebElement errorMessage;

	// Successful Message
	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElements successInfo;

	// Notes, Save, Cancel, OK buttons
	@PageElement(findBy = FindBy.NAME, valueToFind = "memo1:input:textAreaComponent")
	private MCWebElement notes;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement savebtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='cancel'][@value='OK']")
	private MCWebElement OKBtn;

	// Service Code - Add-on Card Request
	@PageElement(findBy = FindBy.NAME, valueToFind = "udf2:input:dropdowncomponent")
	private MCWebElement title;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf3:input:inputTextField")
	private MCWebElement firstName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf5:input:inputTextField")
	private MCWebElement embName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf8:input:dropdowncomponent")
	private MCWebElement relation;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf7:input:dropdowncomponent")
	private MCWebElement pictureCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf1:input:dropdowncomponent")
	private MCWebElement devicePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf4:input:inputTextField")
	private MCWebElement familyName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "date1:input:dateTextField")
	private MCWebElement birthDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf6:input:dropdowncomponent")
	private MCWebElement gender;

	// Service Code - Annual Fee Waiver Request
	@PageElement(findBy = FindBy.NAME, valueToFind = "udf1:input:dropdowncomponent")
	private MCWebElement month;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf2:input:dropdowncomponent")
	private MCWebElement year;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf2:input:dropdowncomponent")
	private MCWebElement generalFrame;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name = 'udf12:radioComponent']/following-sibling::label[contains(text(),'Office')]")
	private MCWebElement emailradioBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf20:input:dropdowncomponent")
	private MCWebElement reasonDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf11:input:dropdowncomponent")
	private MCWebElement withdrawalReasonDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "	udf1:input:dropdowncomponent")
	private MCWebElement internationalOperationDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf2:input:dropdowncomponent")
	private MCWebElement internationalActivatioTypeDDwn;

	// Email/SMS Alert Change Request
	@PageElement(findBy = FindBy.NAME, valueToFind = "udf1:input:dropdowncomponent")
	private MCWebElement Operation_EmailAlertDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf2:checkBoxComponent")
	private MCWebElement SMSAlertCheckBox;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf3:checkBoxComponent")
	private MCWebElement emailAlertsCheckBox;

	// 104 - Change Address Request
	@PageElement(findBy = FindBy.NAME, valueToFind = "udf2:input:inputTextField")
	private MCWebElement changeRequestAddressLine1;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf3:input:inputTextField")
	private MCWebElement changeRequestAddressLine2;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf8:input:dropdowncomponent")
	private MCWebElement changeRequestCountryDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stateCodeTxt:input:inputTextField")
	private MCWebElement changeRequestStateTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cityCodeTxt:input:inputTextField")
	private MCWebElement changeRequestCityTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf7:input:inputTextField")
	private MCWebElement changeRequestZipCode;

	// 304 - E-commerce Activation/Deactivation
	@PageElement(findBy = FindBy.NAME, valueToFind = "udf23:radioComponent")
	private MCWebElement activateEComm;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf23:radioComponent")
	private MCWebElement deactivateEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='udf25:radioComponent'][@value='1']")
	private MCWebElement lifeLongValidationEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='udf25:radioComponent'][@value='2']")
	private MCWebElement immediateInHoursEComm;

	@PageElement(findBy = FindBy.NAME, valueToFind = "udf24:input:inputTextField")
	private MCWebElement timeInHoursEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='udf25:radioComponent'][@value='3']")
	private MCWebElement activationPeriodEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='date1:input:dateTextField']//following-sibling::span//img")
	private MCWebElement fromDateEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='date2:input:dateTextField']//following-sibling::span//img")
	private MCWebElement toDateEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@class='yui-cal-nav-yc'][@type='text']")
	private MCWebElement YearTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class ='yui-cal-nav-btn yui-default']/button")
	private MCWebElement dateOKBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'16')][@class='selector']")
	private MCWebElement birthDateEComm;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[2]/span[@class='feedbackPanelINFO']")
	private MCWebElement NoOfWalletsAddedTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id ='nextRenewalDate']//span[@class = 'labeldatef']")
	private MCWebElement nextRenewaldateTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h3[.='General']/following::table[2]//tbody/tr")
	private MCWebElements cardsTable;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h3[.='General']/following::table[2]//tbody/tr[1]/td[8]")
	private MCWebElement card2Status;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//h3[.='General']/following::table[2]//tbody/tr[2]/td[8]")
	private MCWebElement card1Status;

	public static String fromShortName(String name, Class<?> cls) {
		return MiscUtils.getConstantStringFromClassByPefixMatch(cls, name);
	}

	private final String activate = "Activate [1]";
	private final String deactivate = "Deactivate [0]";

	public void emailSMSAlertChange(String type, String status, String notes) {
		String smsType = "sms";
		String emailType = "email";
		String activeStatus = "active";
		String deactiveStatus = "deactive";

		switchToIframe(Constants.EMAIL_SMS_ACTIVE_DEACTIVE);
		if (status.equalsIgnoreCase(activeStatus)) {
			waitForElementVisible(this.Operation_EmailAlertDdwn);
			selectDropDownByText(this.Operation_EmailAlertDdwn, activate);
			if (type.equalsIgnoreCase(emailType)) {
				emailAlertsCheckBox.click();
			} else if (type.equalsIgnoreCase(smsType)) {
				SMSAlertCheckBox.click();
			}
		} else if (status.equalsIgnoreCase(deactiveStatus)) {
			waitForElementVisible(this.Operation_EmailAlertDdwn);
			selectDropDownByText(this.Operation_EmailAlertDdwn, deactivate);
			if (type.equalsIgnoreCase(emailType)) {
				emailAlertsCheckBox.click();
			} else if (type.equalsIgnoreCase(smsType)) {
				SMSAlertCheckBox.click();
			}
		}
		addNotes(notes);
	}

	public void selectServiceCode(String servicecode) {
		waitForElementVisible(this.serviceCodeDDwn);
		List<String> aa = CustomUtils.getAllOptionsOfDropDown(this.serviceCodeDDwn);
		selectDropDownByText(this.serviceCodeDDwn, servicecode);
		CustomUtils.ThreadDotSleep(5000);
		// waitForElementVisible(serviceCodeGoBtn);
		Scrolldown(serviceCodeGoBtn);
		serviceCodeGoBtn.click();

	}

	public void addOnCardRequest(EventAndAlerts eventAndAlerts) {
		switchToIframe(Constants.ADD_ON_CARD);
		selectDropDownByText(this.title, eventAndAlerts.getTitle());
		enterText(firstName, eventAndAlerts.getFirstName());
		enterText(embName, eventAndAlerts.getEmbossedName());
		enterText(familyName, eventAndAlerts.getFamilyName());
		selectDropDownByText(this.relation, eventAndAlerts.getRelation());
		addNotes(helpdeskgettersetter.getNoteText());
	}

	public void changeAddressRequest(ChangeAddressRequest changeAddressRequest) {
		switchToIframe(Constants.CHANGE_ADDRESS_REQUEST);
		enterText(changeRequestAddressLine1, changeAddressRequest.getAddressLine1());
		enterText(changeRequestAddressLine2, changeAddressRequest.getAddressLine2());
		CustomUtils.ThreadDotSleep(500);
		selectDropDownByText(this.changeRequestCountryDdwn, changeAddressRequest.getCountry());
		CustomUtils.ThreadDotSleep(500);
		enterText(changeRequestZipCode, changeAddressRequest.getZipCode());
		CustomUtils.ThreadDotSleep(500);
		enterText(changeRequestStateTxt, changeAddressRequest.getState());
		enterText(changeRequestCityTxt, changeAddressRequest.getCity());
		addNotes(helpdeskgettersetter.getNoteText());
	}

	public void activateDeviceHelpDesk() {
		enterText(notes, MapUtils.fnGetInputDataFromMap("Notes"));
		savebtn.click();
		waitForElementVisible(successInfo);
		OKBtn.click();
		waitForElementVisible(endCallBtn);
		endCallBtn.click();
	}

	public void addNotes(String noteText) {
		waitForElementVisible(this.notes);
		enterText(this.notes, noteText);
		ClickButton(savebtn);
		isElementPresent(successInfo);
		OKBtn.click();

		switchToDefaultFrame();
	}

	public void endCall() {
		switchToDefaultFrame();
		CustomUtils.ThreadDotSleep(5000);
		Scrolldown(endCallBtn);
		waitForElementVisible(endCallBtn);
		endCallBtn.click();
		CustomUtils.ThreadDotSleep(5000);
	}

	public void selectEmailAddressIndicator(String emailIndicator) {
		CustomUtils.ThreadDotSleep(5000);
		String emailIndicatorXpath = "//input[@name = 'udf12:radioComponent']/following-sibling::label[contains(text(),'%s')]";
		emailIndicatorXpath = emailIndicatorXpath.replaceAll("%s", emailIndicator);

		System.out.println(emailIndicatorXpath);
		System.out.println();
		WebElement emailIndicatorRadiobtn = getFinder().getWebDriver().findElement(By.xpath(emailIndicatorXpath));

		if (emailIndicatorRadiobtn.isSelected() != true) {
			emailIndicatorRadiobtn.click();
			addWicketAjaxListeners(getFinder().getWebDriver());
		}

	}

	public void selectReasonForStopListing(String iFrameName, String reason) {

		waitForElementVisible(SelectReason(iFrameName));
		selectDropDownByText(reasonDDwn, reason);

	}

	public MCWebElement SelectReason(String iFrameName) {
		if (iFrameName.contains("Withdraw")) {

			return this.withdrawalReasonDDwn;
		} else if (iFrameName.contains("stop")) {
			return this.reasonDDwn;
		} else
			return null;

	}

	public void activateDeactivateEComm(String status, String notes, String type) {
		selectDropDownByText(internationalOperationDDwn, status);
		selectDropDownByText(internationalActivatioTypeDDwn, type);

		if (status.equalsIgnoreCase("activate")) {

			if (type.equalsIgnoreCase("nhours")) {
				// immediateInHoursEComm.click();
				enterText(this.timeInHoursEComm, "2");
			}

			// * if (type.equalsIgnoreCase("ActivationPeriod")) {
			// * //activationPeriodEComm.click(); fromDateEComm.click();
			// * List<WebElement> calendar = getFinder().getWebDriver()
			// * .findElements(By.xpath("//a[@class='calnav']")); for (int i =
			// 0;
			// * i <= calendar.size(); i++) { calendar.get(i).click(); break; }
			// * YearTxt.clearField(); enterText(YearTxt, "1990");
			// * CustomUtils.ThreadDotSleep(500); ClickButton(dateOKBtn);
			// * CustomUtils.ThreadDotSleep(500); birthDateEComm.click(); }

		}
		addNotes(notes);
	}

	// input[@class='yui-cal-nav-yc'][@type='text']

	public void activateEComm(EventAndAlerts eventAndAlerts) {
		String type = eventAndAlerts.geteCommType();
		String status = eventAndAlerts.geteCommStatus();
		switchToIframe(Constants.E_COMMERCE_ACTIVATE_DEACTIVATE);
		CustomUtils.ThreadDotSleep(500);
		if (status.equalsIgnoreCase("activate")) {
			if (!activateEComm.isSelected())
				activateEComm.click();

			if (type.equalsIgnoreCase("nhours")) {
				if (!immediateInHoursEComm.isSelected())
					immediateInHoursEComm.click();
				CustomUtils.ThreadDotSleep(500);
				enterText(this.timeInHoursEComm, "2");
			}

			if (type.equalsIgnoreCase("lifeLong")) {
				if (!lifeLongValidationEComm.isSelected())
					lifeLongValidationEComm.click();
			}

			if (type.equalsIgnoreCase("ActivationPeriod")) {
				if (!activationPeriodEComm.isSelected())
					activationPeriodEComm.click();
				fromDateEComm.click();
				YearTxt.clearField();
				enterText(YearTxt, "1990");
				CustomUtils.ThreadDotSleep(500);
				ClickButton(dateOKBtn);
				CustomUtils.ThreadDotSleep(500);
				// birthDateEComm.click();
				List<WebElement> calendar = getFinder().getWebDriver()
						.findElements(By.xpath("//*[contains(text(),'16')][@class='selector']"));
				// for (int i = 0; i <= calendar.size(); i++) {
				calendar.get(2).click();
				// break;
				// }
			}

		} else if (status.equalsIgnoreCase("deactivate")) {
			deactivateEComm.click();
		}
		addNotes(helpdeskgettersetter.getNoteText());

	}

	public void deactivatingEComm(EventAndAlerts eventAndAlerts) {
		if (eventAndAlerts.geteCommStatus().equalsIgnoreCase("deactivate")) {
			switchToIframe(Constants.E_COMMERCE_ACTIVATE_DEACTIVATE);
			CustomUtils.ThreadDotSleep(500);
			deactivateEComm.click();
		}
		addNotes(helpdeskgettersetter.getNoteText());
	}

	public void activateDeviceHelpDesk(String notes) {
		switchToIframe(Constants.ACTIVATE_DEVICE);
		addNotes(notes);
	}

	public void linkCardQuery(String notes) {
		switchToIframe(Constants.LINK_CARD_QUERY);
		addNotes(notes);
	}

	public void addCardToDoNotCallRegister(String notes) {
		switchToIframe(Constants.DO_NOT_CALL_REGISTER);
		addNotes(notes);
	}

	public void addCallNotes(String notes) {
		switchToIframe(Constants.ADD_CALL_NOTES);
		addNotes(notes);
	}

	public void selectMultiWalletSingleCurrency(String Currency) {
		WebElement wallet_currency = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + Currency + "')]/following::td[1]/span/select[@class = 'selectf']"));
		String optionVisbleText = "";
		Select sel = new Select(wallet_currency);
		List<WebElement> selectedOptions = sel.getOptions();
		for (WebElement element : selectedOptions) {
			if (element.getText().toUpperCase().contains(helpdeskgettersetter.getNoOfWallets().toUpperCase())) {
				optionVisbleText = element.getText();
				break;
			}
		}
		sel.selectByVisibleText(optionVisbleText);
	}

	public void CalculateExpiryDate() {
		String date = MapUtils.fnGetInputDataFromMap("ExpiryDate");
		String DevicePlanExpiryDate = "31/" + date.replaceAll("-", "/");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// Convert from String to Date
		Date startDate = null;
		try {
			startDate = df.parse(DevicePlanExpiryDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		String nextDate = df.format(calendar.getTime());
		Assert.assertEquals(nextRenewaldateTxt.getAttribute("innerHTML"), nextDate);

	}

	public void checkNoAndStatusOfCards() {
		Assert.assertEquals(cardsTable.getElements().size(), 2);
		Assert.assertEquals(CardStatus.NORMAL_CARD, card1Status.getText());
		Assert.assertEquals(CardStatus.NOTACTIVATED_CARD, card2Status.getText());
	}

	public void switchToCurrencySetupFrame() {
		switchToIframe(Constants.CURRENCY_SETUP_FRAME);
	}

	public String CheckNoOfWalletsAdded() {
		String strOutputMessage = NoOfWalletsAddedTxt.getText().split("\\n")[0];
		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		return strRequestNumber;

	}

}
