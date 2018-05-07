package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class RupaySettlementPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(RupaySettlementPage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[.='Administration']")
	private MCWebElement Administration;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//li[contains(.,'Setup')]")
	private MCWebElement Setup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='SYS000']")
	private MCWebElement AdministrationSetup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='SYRP00']")
	private MCWebElement Privileges;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='SYRP01']/a")
	private MCWebElement ScreenLevel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='field']/select[@name='searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent']")
	private MCWebElement EntityType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='field']/select[@name='searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent']")
	private MCWebElement EntityID;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[3]/div[4]/div[2]/div[2]/form/div[2]/div[2]/div[1]/table[1]/tbody/tr[58]/td[5]/span/input")
	private MCWebElement RupaySettlementBinPrivilegeCheck4;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[3]/div[4]/div[2]/div[2]/form/div[2]/div[2]/div[1]/table[1]/tbody/tr[58]/td[4]/span/input")
	private MCWebElement RupaySettlementBinPrivilegeCheck3;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[3]/div[4]/div[2]/div[2]/form/div[2]/div[2]/div[1]/table[1]/tbody/tr[58]/td[3]/span/input")
	private MCWebElement RupaySettlementBinPrivilegeCheck2;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[3]/div[4]/div[2]/div[2]/form/div[2]/div[2]/div[1]/table[1]/tbody/tr[58]/td[2]/span/input")
	private MCWebElement RupaySettlementBinPrivilegeCheck1;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='header']/div[3]/span[2]/a[3]")
	private MCWebElement Signout;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='issuingLinkContainer']/li/a/span")
	private MCWebElement CardManagement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='ISR000']")
	private MCWebElement InstitutionParameterSetup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='ISR000']/ul/li[34]/a")
	private MCWebElement RupaySettlementBin;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[3]/div[4]/div[2]/div[2]/form/div[3]/span[1]/input")
	private MCWebElement SaveButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'deviceBin')]")
	private MCWebElement DeviceBinPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@id='id86']/table[1]/tbody/tr[1]/td[1]/span")
	public MCWebElement DeviceBinLabel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='selectf']/following::td[@id='deviceBin']")
	private MCWebElement DeviceBin;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='rupayProductCode']/select")
	private MCWebElement RupayProductCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='rupayProductCode']/span/select")
	private MCWebElement RupayProductCodePopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='settlementBin']/input")
	private MCWebElement SettlementBin;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='settlementBin']/span/input")
	private MCWebElement SettlementBinPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='participantId']/input")
	private MCWebElement ParticipantId;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='participantId']/span/input")
	private MCWebElement ParticipantIdPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='displayName']/following::span/textarea")
	private MCWebElement MakersNotePopup;

	@PageElement(findBy = FindBy.NAME, valueToFind = "checkerNote:input:textAreaComponent")
	private MCWebElement CheckersNotePopup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='save']/input")
	private MCWebElement SaveButtonDeviceBin;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='addrecord']/a[@class='addR']")
	private MCWebElement AddRupaySettlementBinConfiguration;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='btn_or_span']/input[@name='cancel']")
	private MCWebElement CancelButtonAddRupaySettlement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//tr[@class='even']/td[6]/span/a")
	private MCWebElement DeleteRecord;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='SYS000']/ul/li[5]/a")
	private MCWebElement EnableMakerChecker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='tabs']/li[2]")
	private MCWebElement CheckerMakerCardManagement;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='table_privileges']/tbody//tr[3]/td[2]/span/input")
	private MCWebElement CheckBoxEnableCheckerMaker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='form_privileges']/div[3]/span/input[@value='save']")
	private MCWebElement SaveButtonEnableCheckerMaker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='recordStatus']/select")
	private MCWebElement RecordStatus;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='recordBy']/select")
	private MCWebElement RecordBy;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='searchButton']/span/input[@value='Search']")
	private MCWebElement SearchButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='even']/td[5]/span/a")
	private MCWebElement EditButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='operationTypeSearch']/select")
	private MCWebElement OperationType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='save']/input[@type='submit']")
	private MCWebElement SaveButtonPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@id='save']/following::span/input[@value='Submit']")
	private MCWebElement SubmitButtonPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Cancel']")
	private MCWebElement CancelButtonPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//input[@value='Return']")
	private MCWebElement ReturnButtonPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//input[@value='Approve']")
	private MCWebElement ApproveButtonPopUp;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@type='submit' and @name='compare']")
	private MCWebElement CompareButtonPopup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Close']")
	private MCWebElement CloseButtonPopup;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='feedbackPanel']/li")
	private MCWebElement FeedbackPanel;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@class='feedbackPanelERROR']")
	private MCWebElement FeedbackError;

	public String RupaySettlementBin1 = "//*[@id='ISR000']/ul/li[34]/a";

	public MCWebElement getFeedbackError() {
		return FeedbackError;
	}

	public MCWebElement getRecordBy() {
		return RecordBy;
	}

	public MCWebElement getCloseButtonPopup() {
		return CloseButtonPopup;
	}

	public MCWebElement getCompareButtonPopup() {
		return CompareButtonPopup;
	}

	public MCWebElement getFeedbackPanel() {
		return FeedbackPanel;
	}

	public MCWebElement getApproveButtonPopup() {
		return ApproveButtonPopUp;
	}

	public MCWebElement getReturnButtonPopup() {
		return ReturnButtonPopUp;
	}

	public MCWebElement getCheckersNote() {
		return CheckersNotePopup;
	}

	public MCWebElement getEditButton() {
		return EditButton;
	}

	public MCWebElement getCancelButtonPopup() {
		return CancelButtonPopUp;
	}

	public MCWebElement getSubmitButtonPopup() {
		return SubmitButtonPopUp;
	}

	public MCWebElement getSaveButtonPopup() {
		return SaveButtonPopUp;
	}

	public MCWebElement getSettlementBinPopup() {
		return SettlementBinPopUp;
	}

	public MCWebElement getParticipantIdPopup() {
		return ParticipantIdPopUp;
	}

	public MCWebElement getdeviceBinPopup() {
		return DeviceBinPopUp;
	}

	public MCWebElement getrupayProductCodePopup() {
		return RupayProductCodePopUp;
	}

	public MCWebElement getmakersNotePopup() {
		return MakersNotePopup;
	}

	public MCWebElement getAdministration() {
		return Administration;
	}

	public MCWebElement getSetup() {
		return AdministrationSetup;
	}

	public MCWebElement getPrivileges() {
		return Privileges;
	}

	public MCWebElement getScreenLevel() {
		return ScreenLevel;
	}

	public MCWebElement getEntityType() {
		return EntityType;
	}

	public MCWebElement getEntityID() {
		return EntityID;
	}

	public MCWebElement getSearchButton() {
		return SearchButton;
	}

	public MCWebElement getSignout() {
		return Signout;
	}

	public MCWebElement getCardManagement() {
		return CardManagement;
	}

	public MCWebElement getInstitutionParameterSetup() {
		return InstitutionParameterSetup;
	}

	public MCWebElement getRupaySettlementBin() {
		return RupaySettlementBin;
	}

	public MCWebElement getSaveButton() {
		return SaveButton;
	}

	public MCWebElement getDeviceBin() {
		return DeviceBin;
	}

	public MCWebElement getRupayProductCode() {
		return RupayProductCode;
	}

	public MCWebElement getSettlementBin() {
		return SettlementBin;
	}

	public MCWebElement getParticipantId() {
		return ParticipantId;
	}

	public MCWebElement getSaveButtonDeviceBin() {
		return SaveButtonDeviceBin;
	}

	public MCWebElement getAddRupaySettlementBinConfiguration() {
		return AddRupaySettlementBinConfiguration;
	}

	public MCWebElement getCancelButtonAddRupaySettlement() {
		return CancelButtonAddRupaySettlement;
	}

	public MCWebElement getDeleteRecord() {
		return DeleteRecord;
	}

	public MCWebElement getEnableMakerChecker() {
		return EnableMakerChecker;
	}

	public MCWebElement getCheckerMakerCardManagement() {
		return CheckerMakerCardManagement;
	}

	public MCWebElement getCheckBoxEnableCheckerMaker() {
		return CheckBoxEnableCheckerMaker;
	}

	public MCWebElement getSaveButonEnableCheckerMaker() {
		return SaveButtonEnableCheckerMaker;
	}

	public MCWebElement getRupaySettlementCheck(int index) {
		switch (index) {
		case 1:
			return RupaySettlementBinPrivilegeCheck1;
		case 2:
			return RupaySettlementBinPrivilegeCheck2;
		case 3:
			return RupaySettlementBinPrivilegeCheck3;
		case 4:
			return RupaySettlementBinPrivilegeCheck4;
		}
		return RupaySettlementBinPrivilegeCheck4;
	}

	public void administrationClick() {
		waitForElementVisible(getAdministration());
		getAdministration().click();
	}

	public void submenuClick(MCWebElement menu, MCWebElement submenu, MCWebElement submenu2) {
		waitForElementVisible(menu);
		menu.click();
		waitForElementVisible(submenu);
		submenu.click();
		waitForElementVisible(submenu2);
		submenu2.click();

	}

	public void clickElement(MCWebElement element) {
		waitForElementVisible(element);
		element.click();
	}

	public void signOut() {
		clickElement(Signout);
	}

	public void swithToPopUp() {
		String parentWindowHandler = getFinder().getWebDriver().getWindowHandle(); // Store
		String subWindowHandler = null;
		Set<String> handles = getFinder().getWebDriver().getWindowHandles(); // get
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		getFinder().getWebDriver().switchTo().window(subWindowHandler); // switch
	}

	public void AddServiceCode_FrameSwitcher() {
		WebDriver driver = getFinder().getWebDriver();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.switchTo().frame(
				driver.findElement(By.xpath("/html/body/div[5]/form/div/div[2]/div/div/div/div[2]/div/div/iframe")));
	}

	public void AddServiceCode_FrameSwitcher2() {
		WebDriver driver = getFinder().getWebDriver();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().frame(
				driver.findElement(By.xpath("html/body/div[7]/form/div/div[2]/div/div/div/div[2]/div/div/iframe")));
	}

	public void editRecordCheckerSide(String SettlementBin, String Operation) {
		waitForElementVisible(RecordStatus);

		switch (Operation) {
		case Constants.RETURN_MAKER_OPERATION:
			selectDropDownByText(RecordStatus, "Returned [RET]");
			CustomUtils.ThreadDotSleep(2000);
			break;
		case Constants.APPROVE_MAKER_OPERATION:
			selectDropDownByText(RecordStatus, "Approved [APP]");
			break;
		case Constants.BOTH_PRIVILEGE_OPERATION:
			selectDropDownByText(RecordStatus, "Pending [SUB]");
			WebDriverWait wait = new WebDriverWait(getFinder().getWebDriver(), 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='recordBy']/select")));
			selectDropDownByText(RecordBy, "Self [SELF]");
			CustomUtils.ThreadDotSleep(2000);
			break;
		default:
			selectDropDownByText(RecordStatus, "Pending [SUB]");
			CustomUtils.ThreadDotSleep(2000);
			break;
		}

		getSearchButton().click();
		List<WebElement> mcws = getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']//tr"));
		waitForElementsVisible(mcws);
		getFinder().getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement edit = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + SettlementBin + "')]/following::a[1]/img[@alt='Edit Record'] "));
		waitForElementVisible(edit);
		edit.click();
		AddServiceCode_FrameSwitcher();
		switch (Operation) {
		case Constants.RETURN_OPERATION:
			getCheckersNote().sendKeys("return");
			getReturnButtonPopup().click();
			if (getFeedbackError().isVisible()) {
				waitForElementVisible(getFeedbackError());
				logger.warn(getFeedbackError().getText());
				getCancelButtonPopup().click();
			}

			break;
		case Constants.APPROVE_OPERATION:
			getCheckersNote().clearField();
			getCheckersNote().sendKeys("approveed");
			getApproveButtonPopup().click();
			CustomUtils.ThreadDotSleep(1000);
			if (getFeedbackError().isVisible()) {
				waitForElementVisible(getFeedbackError());
				logger.warn(getFeedbackError().getText());
			}
			getCancelButtonPopup().click();
			break;
		case Constants.RETURN_MAKER_OPERATION:
			getmakersNotePopup().clearField();
			getmakersNotePopup().sendKeys("Added by rahul");
			getSubmitButtonPopup().click();
			if (getFeedbackError().isVisible()) {
				waitForElementVisible(getFeedbackError());
				logger.warn(getFeedbackError().getText());
				getCancelButtonPopup().click();
			}
			break;
		case Constants.APPROVE_MAKER_OPERATION:
			getCancelButtonPopup().click();
			CustomUtils.ThreadDotSleep(1000);

			break;
		case Constants.COMPARE_RETURN_OPERATION:
			getCheckersNote().clearField();
			getCheckersNote().sendKeys(Constants.APPROVE_FROM_CHECKER);
			getCompareButtonPopup().click();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().defaultContent();
			switchToIframe(Constants.VIEW_FIELD_DIFFERENCE);
			CustomUtils.ThreadDotSleep(2000);
			getCloseButtonPopup().click();
			CustomUtils.ThreadDotSleep(2000);
			getFinder().getWebDriver().switchTo().defaultContent();
			switchToIframe(Constants.EDIT_RUPAY_SETTLEMENT_BIN);
			getApproveButtonPopup().click();
			if (getFeedbackError().isVisible()) {
				waitForElementVisible(getFeedbackError());
				logger.warn(getFeedbackError().getText());
				getCancelButtonPopup().click();
			}
			break;
		case Constants.BOTH_PRIVILEGE_OPERATION:
			getCancelButtonPopup().click();

			break;
		default:
			break;
		}

		getFinder().getWebDriver().switchTo().defaultContent();
		// waitForElementVisible(getFeedbackPanel());
	}

	public void editRecordMakerSide(String SettlementBin) {
		final String s_id = SettlementBin;
		waitForElementVisible(RecordStatus);
		selectDropDownByText(RecordStatus, "Returned [RET]");
		CustomUtils.ThreadDotSleep(2000);
		getSearchButton().click();
		List<WebElement> mcws = getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']//tr"));
		waitForElementsVisible(mcws);
		getFinder().getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement edit = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + SettlementBin + "')]/following::a[1]/img[@alt='Edit Record'] "));
		waitForElementVisible(edit);
		getEditButton().click();
		AddServiceCode_FrameSwitcher();
		getSubmitButtonPopup().click();
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	public void deleteRecord(String SettlementBin) {
		final String s_id = SettlementBin;
		waitForElementVisible(RecordStatus);
		selectDropDownByText(RecordStatus, "Production [PRO]");
		CustomUtils.ThreadDotSleep(2000);
		System.out.println("***** " + SettlementBin);
		getSearchButton().click();
		List<WebElement> mcws = getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']//tr"));
		waitForElementsVisible(mcws);
		getFinder().getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement delete = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + SettlementBin + "')]/following::a[2]/img[@alt='Delete Record']  "));
		waitForElementVisible(delete);
		delete.click();
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		CustomUtils.ThreadDotSleep(1000);
		alert.accept();
		CustomUtils.ThreadDotSleep(2000);
	}

	public void editAtEndSettlementBinMaker(String SettlementBin) {
		final String s_id = SettlementBin;
		List<WebElement> mcws = getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']//tr"));
		waitForElementsVisible(mcws);
		getFinder().getWebDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement edit = getFinder().getWebDriver().findElement(
				By.xpath("//td[contains(.,'" + SettlementBin + "')]/following::a[1]/img[@alt='Edit Record'] "));
		waitForElementVisible(edit);
		edit.click();
		AddServiceCode_FrameSwitcher();
		selectDropDownByText(getrupayProductCodePopup(), MapUtils.fnGetInputDataFromMap("RupayProductCode2"));
		getmakersNotePopup().sendKeys("updated and sent for approval");
		getSubmitButtonPopup().click();
		getFinder().getWebDriver().switchTo().defaultContent();

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

	public MCWebElement getRecordStatus() {
		// TODO Auto-generated method stub
		return RecordStatus;
	}

}
