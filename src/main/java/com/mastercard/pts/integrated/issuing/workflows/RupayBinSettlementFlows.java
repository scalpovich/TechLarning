package com.mastercard.pts.integrated.issuing.workflows;

import org.openqa.selenium.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AdminstrationPage;
import com.mastercard.pts.integrated.issuing.pages.InstitutionSelectionPage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.LoginPage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.RupaySettlementPage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class RupayBinSettlementFlows extends AbstractBaseFlows {
	@Autowired
	RupaySettlementPage rupaysettlementpage;
	@Autowired
	MenuSubMenuPage menusubmenu;
	@Autowired
	LoginPage loginpage;
	@Autowired
	AdminstrationPage adminpage;
	@Autowired
	InstitutionSelectionPage institute;
	String SettlementBin;

	public void deleteRecordOnProduction() {
		getIntoRupaySettlementBin("Maker");
		SettlementBin = SettlementBin = MapUtils.fnGetInputDataFromMap("SettlementBin2");
		rupaysettlementpage.deleteRecord(SettlementBin);
		getIntoRupaySettlementBin("Checker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.APPROVE_OPERATION);
	}

	public void userWithBothPrivilege() {
		getIntoRupaySettlementBin("SuperUser");
		SettlementBin = MapUtils.fnGetInputDataFromMap("SettlementBin2");
		rupaysettlementpage.editAtEndSettlementBinMaker(SettlementBin);
		getIntoRupaySettlementBin("SuperUser");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.BOTH_PRIVILEGE_OPERATION);
		getIntoRupaySettlementBin("Checker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.APPROVE_OPERATION);

	}

	public void editAtEndRupayBinSettlement() {
		getIntoRupaySettlementBin("Maker");
		SettlementBin = MapUtils.fnGetInputDataFromMap("SettlementBin2");
		rupaysettlementpage.editAtEndSettlementBinMaker(SettlementBin);
		getIntoRupaySettlementBin("Checker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.COMPARE_RETURN_OPERATION);
	}

	public void makerRupayBinSettlement() {
		getIntoRupaySettlementBin("Maker");
		final String SettlementBin = addRecordRupaySettlementMakerChecker();
		getIntoRupaySettlementBin("Checker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.RETURN_OPERATION);
		CustomUtils.ThreadDotSleep(2000);
		getIntoRupaySettlementBin("Maker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.RETURN_MAKER_OPERATION);
		getIntoRupaySettlementBin("Checker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.APPROVE_OPERATION);
		getIntoRupaySettlementBin("Maker");
		rupaysettlementpage.editRecordCheckerSide(SettlementBin, Constants.APPROVE_MAKER_OPERATION);

	}

	public void getIntoRupaySettlementBin(String role) {
		loginpage.login(MapUtils.fnGetInputDataFromMap(role), CustomUtils.RandomNumbers(4) + "");
		// institute.getInstitution().click();
		rupaysettlementpage.SelectDropDownByText(institute.getInstitution(),
				MapUtils.fnGetInputDataFromMap("InstitutionName"));
		institute.getConfirmButton().click();
		;
		menusubmenu.getCardManagementMenu().click();
		menusubmenu.getInstitutionParameterSetup().click();
		waitForElementVisible(menusubmenu.getRupaySettlementBin());
		menusubmenu.getRupaySettlementBin().click();

	}

	public void giveAdminRightsToCheckerMaker() {
		menusubmenu.getAdministration().click();
		menusubmenu.getAdministrationSetup().click();
		waitForElementVisible(menusubmenu.getEnableMakerChecker());
		menusubmenu.getEnableMakerChecker().click();
		// rupaysettlementpage.ClickCheckBox(adminpage.getRupaySettlement(),
		// true);
		rupaysettlementpage.ClickButton(adminpage.getSaveButton());

	}

	public String addRecordRupaySettlementMakerChecker() {
		String SettlementBin;
		rupaysettlementpage.getAddRupaySettlementBinConfiguration().click();
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getdeviceBinPopup(),
				MapUtils.fnGetInputDataFromMap("DeviceBin"));
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getrupayProductCodePopup(),
				MapUtils.fnGetInputDataFromMap("RupayProductCode"));
		SettlementBin = MapUtils.fnGetInputDataFromMap("SettlementBin2");
		rupaysettlementpage.getSettlementBinPopup().sendKeys(SettlementBin);
		rupaysettlementpage.getParticipantIdPopup().sendKeys(CustomUtils.RandomNumbers(11));
		rupaysettlementpage.getmakersNotePopup().sendKeys("Added by " + MapUtils.fnGetInputDataFromMap("Maker"));
		rupaysettlementpage.getSubmitButtonPopup().click();
		getFinder().getWebDriver().switchTo().defaultContent();
		CustomUtils.ThreadDotSleep(1500);
		return SettlementBin;

	}

	public void configureSettlementBin() {
		enterIntoRupaySettlementBin();
		try {
			insertBinConfigurationDetails(MapUtils.fnGetInputDataFromMap("DeviceBin"),
					MapUtils.fnGetInputDataFromMap("RupayProductCode"),
					MapUtils.fnGetInputDataFromMap("ParticipantId2"), 0);
		} catch (Exception e) {
			waitForElementVisible(rupaysettlementpage.getAddRupaySettlementBinConfiguration());

		}
		try {
			rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		} catch (Exception e) {
			enterIntoRupaySettlementBin();
			return;
		}
		insertBinConfigurationDetails(MapUtils.fnGetInputDataFromMap("DeviceBin"),
				MapUtils.fnGetInputDataFromMap("RupayProductCode2"), MapUtils.fnGetInputDataFromMap("ParticipantId2"),
				0);
		waitForElementVisible(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		try {
			rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		} catch (Exception e) {
			enterIntoRupaySettlementBin();
			return;
		}
		try {
			insertBinConfigurationDetails(MapUtils.fnGetInputDataFromMap("DeviceBin"),
					MapUtils.fnGetInputDataFromMap("RupayProductCode3"),
					MapUtils.fnGetInputDataFromMap("ParticipantId2"), 0);
		} catch (Exception e) {
			getFinder().getWebDriver().switchTo().defaultContent();
			return;
		}
		onlyOnePair();
	}

	public void onlyOnePair() {
		try {
			waitForElementVisible(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
			rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());

			insertBinConfigurationDetails(MapUtils.fnGetInputDataFromMap("DeviceBin"),
					MapUtils.fnGetInputDataFromMap("RupayProductCode3"),
					MapUtils.fnGetInputDataFromMap("ParticipantId2"), 1);
			CustomUtils.ThreadDotSleep(3000);
			rupaysettlementpage.getCancelButtonAddRupaySettlement().click();
		} catch (Exception e) {
			return;
		}
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	public void deleteSettlementBin() {
		try {
			if (rupaysettlementpage.isLoaded())
				rupaysettlementpage.getDeleteRecord().click();
			Alert alert = getFinder().getWebDriver().switchTo().alert();
			CustomUtils.ThreadDotSleep(1000);
			alert.accept();
		} catch (Exception e) {
			return;
		}
	}

	public void getIntoPrivileges() {
		login.login();
		login.login();
		selectInstitute();
	}

	public void participantIdMandatory() {
		int devIndex = 0;
		int rpIndex = 0;
		switch (MapUtils.fnGetInputDataFromMap("DeviceBin")) {
		case "Rupay Debit [070683]":
			devIndex = 1;
			break;
		case "test [175415]":
			devIndex = 2;
			break;
		case "saafsd [213456]":
			devIndex = 3;
			break;
		case "test [610000]":
			devIndex = 2;
			break;
		case "test [650000]":
			devIndex = 1;
			break;
		default:
			devIndex = 2;
			break;
		}
		switch (MapUtils.fnGetInputDataFromMap("RupayProductCode")) {
		case "[AEP01] Transaction originated from microATM":
			rpIndex = 1;
			break;
		case "[ATM01] Transaction originated from ATM":
			rpIndex = 2;
			break;
		case "[IMP01] Transaction originated from Mobile/Internet Banking":
			rpIndex = 3;
			break;
		case "[POS01] Transaction originated from POS/E-Commerce":
			rpIndex = 2;
			break;

		default:
			rpIndex = 2;
			break;
		}
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		waitForElementVisible(rupaysettlementpage.getdeviceBinPopup());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getdeviceBinPopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getdeviceBinPopup(), devIndex);
		CustomUtils.ThreadDotSleep(200);
		waitForElementVisible(rupaysettlementpage.getrupayProductCodePopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getrupayProductCodePopup(), rpIndex);
		CustomUtils.ThreadDotSleep(200);

		rupaysettlementpage.getSettlementBinPopup().sendKeys(CustomUtils.RandomNumbers(6));
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonPopup());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getCancelButtonPopup());
		getFinder().getWebDriver().switchTo().defaultContent();
		enterIntoRupaySettlementBin();

	}

	public void settlementIdMandatory() {
		int devIndex = 0;
		int rpIndex = 0;
		switch (MapUtils.fnGetInputDataFromMap("DeviceBin")) {
		case "Rupay Debit [070683]":
			devIndex = 1;
			break;
		case "test [175415]":
			devIndex = 2;
			break;
		case "saafsd [213456]":
			devIndex = 3;
			break;
		case "test [610000]":
			devIndex = 2;
			break;
		case "test [650000]":
			devIndex = 1;
			break;
		default:
			devIndex = 2;
			break;
		}
		switch (MapUtils.fnGetInputDataFromMap("RupayProductCode")) {
		case "[AEP01] Transaction originated from microATM":
			rpIndex = 1;
			break;
		case "[ATM01] Transaction originated from ATM":
			rpIndex = 2;
			break;
		case "[IMP01] Transaction originated from Mobile/Internet Banking":
			rpIndex = 3;
			break;
		case "[POS01] Transaction originated from POS/E-Commerce":
			rpIndex = 2;
			break;

		default:
			rpIndex = 2;
			break;
		}
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		waitForElementVisible(rupaysettlementpage.getdeviceBinPopup());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getdeviceBinPopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getdeviceBinPopup(), devIndex);
		CustomUtils.ThreadDotSleep(200);
		waitForElementVisible(rupaysettlementpage.getrupayProductCodePopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getrupayProductCodePopup(), rpIndex);
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.getParticipantIdPopup().sendKeys(CustomUtils.RandomNumbers(11));

		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonPopup());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getCancelButtonPopup());
		getFinder().getWebDriver().switchTo().defaultContent();
		enterIntoRupaySettlementBin();
	}

	public void rupayProductCodeMandatory() {
		// rupaysettlementpage.getAddRupaySettlementBinConfiguration().click();
		int devIndex = 0;
		int rpIndex = 0;
		switch (MapUtils.fnGetInputDataFromMap("DeviceBin")) {
		case "Rupay Debit [070683]":
			devIndex = 1;
			break;
		case "test [175415]":
			devIndex = 2;
			break;
		case "saafsd [213456]":
			devIndex = 3;
			break;
		case "test [610000]":
			devIndex = 2;
			break;
		case "test [650000]":
			devIndex = 1;
			break;
		default:
			devIndex = 2;
			break;
		}
		switch (MapUtils.fnGetInputDataFromMap("RupayProductCode")) {
		case "[AEP01] Transaction originated from microATM":
			rpIndex = 1;
			break;
		case "[ATM01] Transaction originated from ATM":
			rpIndex = 2;
			break;
		case "[IMP01] Transaction originated from Mobile/Internet Banking":
			rpIndex = 3;
			break;
		case "[POS01] Transaction originated from POS/E-Commerce":
			rpIndex = 2;
			break;

		default:
			rpIndex = 2;
			break;
		}
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		waitForElementVisible(rupaysettlementpage.getdeviceBinPopup());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getdeviceBinPopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getdeviceBinPopup(), devIndex);
		CustomUtils.ThreadDotSleep(200);
		waitForElementVisible(rupaysettlementpage.getrupayProductCodePopup());
		// rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getrupayProductCodePopup(),
		// rpIndex);
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.getSettlementBinPopup().sendKeys(CustomUtils.RandomNumbers(6));
		rupaysettlementpage.getParticipantIdPopup().sendKeys(CustomUtils.RandomNumbers(11));
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonPopup());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getCancelButtonPopup());
		getFinder().getWebDriver().switchTo().defaultContent();
		enterIntoRupaySettlementBin();
	}

	public void deviceBinMandatory() {
		int devIndex = 0;
		int rpIndex = 0;
		switch (MapUtils.fnGetInputDataFromMap("DeviceBin")) {
		case "Rupay Debit [070683]":
			devIndex = 1;
			break;
		case "test [175415]":
			devIndex = 2;
			break;
		case "saafsd [213456]":
			devIndex = 3;
			break;
		case "test [610000]":
			devIndex = 2;
			break;
		case "test [650000]":
			devIndex = 1;
			break;
		default:
			devIndex = 2;
			break;
		}
		switch (MapUtils.fnGetInputDataFromMap("RupayProductCode")) {
		case "[AEP01] Transaction originated from microATM":
			rpIndex = 1;
			break;
		case "[ATM01] Transaction originated from ATM":
			rpIndex = 2;
			break;
		case "[IMP01] Transaction originated from Mobile/Internet Banking":
			rpIndex = 3;
			break;
		case "[POS01] Transaction originated from POS/E-Commerce":
			rpIndex = 2;
			break;

		default:
			rpIndex = 2;
			break;
		}
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		waitForElementVisible(rupaysettlementpage.getdeviceBinPopup());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getdeviceBinPopup());
		// rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getdeviceBinPopup(),
		// devIndex);
		CustomUtils.ThreadDotSleep(200);
		waitForElementVisible(rupaysettlementpage.getrupayProductCodePopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getrupayProductCodePopup(), rpIndex);
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.getSettlementBinPopup().sendKeys(CustomUtils.RandomNumbers(6));
		rupaysettlementpage.getParticipantIdPopup().sendKeys(CustomUtils.RandomNumbers(11));
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonPopup());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getCancelButtonPopup());
		getFinder().getWebDriver().switchTo().defaultContent();
		enterIntoRupaySettlementBin();
	}

	public void setPrivileges() {
		login.login("Admin", "admin");
		selectInstitute();
		rupaysettlementpage.submenuClick(rupaysettlementpage.getAdministration(), rupaysettlementpage.getSetup(),
				rupaysettlementpage.getPrivileges());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.clickElement(rupaysettlementpage.getScreenLevel());
		rupaysettlementpage.clickElement(rupaysettlementpage.getEntityType());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getEntityType(),
				MapUtils.fnGetInputDataFromMap("EntityType"));
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.clickElement(rupaysettlementpage.getEntityID());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getEntityID(),
				MapUtils.fnGetInputDataFromMap("EntityID"));
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.clickElement(rupaysettlementpage.getSearchButton());
		waitForElementVisible(rupaysettlementpage.getRupaySettlementCheck(4));
		Scrolldown(rupaysettlementpage.getRupaySettlementCheck(4));
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(4), true);
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(3), true);
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(2), true);
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(1), true);

		Scrolldown(rupaysettlementpage.getSaveButton());
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButton());
		CustomUtils.ThreadDotSleep(1000);
		// Priviliges are given now login with user
		rupaysettlementpage.signOut();
	}

	public void binConfigureWithSameParticipantId() {
		enterIntoRupaySettlementBin();
		try {
			insertBinConfigurationDetails(MapUtils.fnGetInputDataFromMap("DeviceBin"),
					MapUtils.fnGetInputDataFromMap("RupayProductCode"), MapUtils.fnGetInputDataFromMap("ParticipantId"),
					0);
		} catch (Exception e) {

		}
		enterIntoRupaySettlementBin();

		// rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		try {
			insertBinConfigurationDetails(MapUtils.fnGetInputDataFromMap("DeviceBin2"),
					MapUtils.fnGetInputDataFromMap("RupayProductCode2"),
					MapUtils.fnGetInputDataFromMap("ParticipantId2"), 0);
		} catch (Exception e) {

		}

	}

	public void insertBinConfigurationDetails(String DeviceBin, String RupayProductCode, String ParticipantId,
			int Error) {
		int devIndex = 0;
		int rpIndex = 0;
		switch (DeviceBin) {
		case "Rupay Debit [070683]":
			devIndex = 1;
			break;
		case "test [175415]":
			devIndex = 2;
			break;
		case "saafsd [213456]":
			devIndex = 3;
			break;
		case "test [610000]":
			devIndex = 1;
			break;
		case "test [650000]":
			devIndex = 2;
			break;
		default:
			devIndex = 2;
			break;
		}
		switch (RupayProductCode) {
		case "[AEP01] Transaction originated from microATM":
			rpIndex = 1;
			break;
		case "[ATM01] Transaction originated from ATM":
			rpIndex = 2;
			break;
		case "[IMP01] Transaction originated from Mobile/Internet Banking":
			rpIndex = 3;
			break;
		case "[POS01] Transaction originated from POS/E-Commerce":
			rpIndex = 2;
			break;

		default:
			rpIndex = 2;
			break;
		}
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		waitForElementVisible(rupaysettlementpage.getdeviceBinPopup());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getdeviceBinPopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getdeviceBinPopup(), devIndex);
		CustomUtils.ThreadDotSleep(200);
		waitForElementVisible(rupaysettlementpage.getrupayProductCodePopup());
		rupaysettlementpage.SelectDropDownByIndex(rupaysettlementpage.getrupayProductCodePopup(), rpIndex);
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.getSettlementBinPopup().sendKeys(CustomUtils.RandomNumbers(6));
		rupaysettlementpage.getParticipantIdPopup().sendKeys(ParticipantId);
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonPopup());
		try {

			if (rupaysettlementpage.getFeedbackError().isVisible()) {
				rupaysettlementpage.getCancelButtonPopup().click();
			}
		} catch (Exception e) {

		}
		if (Error == 0) {
			getFinder().getWebDriver().switchTo().defaultContent();
		}
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	public void binConfigurationWithUser() {
		waitForElementVisible(rupaysettlementpage.getCardManagement());
		rupaysettlementpage.clickElement(rupaysettlementpage.getCardManagement());
		waitForElementVisible(rupaysettlementpage.getInstitutionParameterSetup());
		rupaysettlementpage.clickElement(rupaysettlementpage.getInstitutionParameterSetup());
		try {
			waitForElementVisible(rupaysettlementpage.getCardManagement());
			if (waitForElementInVisible(rupaysettlementpage.RupaySettlementBin1)) {

				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("***** User dont have permission *****");
		}
		rupaysettlementpage.clickElement(rupaysettlementpage.getRupaySettlementBin());
		waitForElementVisible(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		// waitForElementVisible(rupaysettlementpage.getDeviceBin());
		rupaysettlementpage.clickElement(rupaysettlementpage.getDeviceBin());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getDeviceBin(),
				MapUtils.fnGetInputDataFromMap("DeviceBin"));
		rupaysettlementpage.clickElement(rupaysettlementpage.getRupayProductCode());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getRupayProductCode());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getRupayProductCode(),
				MapUtils.fnGetInputDataFromMap("RupayProductCode"));
		rupaysettlementpage.getSettlementBin().sendKeys(CustomUtils.RandomNumbers(6));
		rupaysettlementpage.getParticipantId().sendKeys(CustomUtils.RandomNumbers(11));
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonDeviceBin());
		CustomUtils.ThreadDotSleep(4000);

	}

	public void enterIntoRupaySettlementBin() {
		waitForElementVisible(rupaysettlementpage.getCardManagement());
		rupaysettlementpage.clickElement(rupaysettlementpage.getCardManagement());
		waitForElementVisible(rupaysettlementpage.getInstitutionParameterSetup());
		rupaysettlementpage.clickElement(rupaysettlementpage.getInstitutionParameterSetup());
		rupaysettlementpage.clickElement(rupaysettlementpage.getRupaySettlementBin());
		waitForElementVisible(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		CustomUtils.ThreadDotSleep(1000);
	}

	public void removePrivileges() {
		login.login("Admin", "admin");
		selectInstitute();
		rupaysettlementpage.submenuClick(rupaysettlementpage.getAdministration(), rupaysettlementpage.getSetup(),
				rupaysettlementpage.getPrivileges());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.clickElement(rupaysettlementpage.getScreenLevel());
		rupaysettlementpage.clickElement(rupaysettlementpage.getEntityType());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getEntityType(),
				MapUtils.fnGetInputDataFromMap("EntityType"));
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.clickElement(rupaysettlementpage.getEntityID());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getEntityID(),
				MapUtils.fnGetInputDataFromMap("EntityID"));
		CustomUtils.ThreadDotSleep(200);
		rupaysettlementpage.clickElement(rupaysettlementpage.getSearchButton());
		waitForElementVisible(rupaysettlementpage.getRupaySettlementCheck(4));
		Scrolldown(rupaysettlementpage.getRupaySettlementCheck(4));
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(4), false);
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(3), false);
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(2), false);
		rupaysettlementpage.ClickCheckBox(rupaysettlementpage.getRupaySettlementCheck(1), false);

		Scrolldown(rupaysettlementpage.getSaveButton());
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButton());
		CustomUtils.ThreadDotSleep(1000);
		// Priviliges are given now login with user
		rupaysettlementpage.signOut();
		login.login();
		login.login();
		selectInstitute();
	}

	public void binConfigureWithNoPrivilege() {
		waitForElementVisible(rupaysettlementpage.getCardManagement());
		rupaysettlementpage.clickElement(rupaysettlementpage.getCardManagement());
		waitForElementVisible(rupaysettlementpage.getInstitutionParameterSetup());
		rupaysettlementpage.clickElement(rupaysettlementpage.getInstitutionParameterSetup());
		waitForElementVisible(rupaysettlementpage.getRupaySettlementBin());
		rupaysettlementpage.clickElement(rupaysettlementpage.getRupaySettlementBin());

		waitForElementVisible(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		rupaysettlementpage.clickElement(rupaysettlementpage.getAddRupaySettlementBinConfiguration());
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.AddServiceCode_FrameSwitcher();
		// waitForElementVisible(rupaysettlementpage.getDeviceBin());
		rupaysettlementpage.clickElement(rupaysettlementpage.getDeviceBin());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getDeviceBin(),
				MapUtils.fnGetInputDataFromMap("DeviceBin"));
		rupaysettlementpage.clickElement(rupaysettlementpage.getRupayProductCode());
		// rupaysettlementpage.clickElement(rupaysettlementpage.getRupayProductCode());
		rupaysettlementpage.SelectDropDownByText(rupaysettlementpage.getRupayProductCode(),
				MapUtils.fnGetInputDataFromMap("RupayProductCode"));
		rupaysettlementpage.getSettlementBin().sendKeys(CustomUtils.RandomNumbers(6));
		rupaysettlementpage.getParticipantId().sendKeys(CustomUtils.RandomNumbers(11));
		CustomUtils.ThreadDotSleep(1000);
		rupaysettlementpage.ClickButton(rupaysettlementpage.getSaveButtonDeviceBin());
	}

}
