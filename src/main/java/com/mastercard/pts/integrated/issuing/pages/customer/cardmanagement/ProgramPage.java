package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ApplicationType;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2_PROGRAM })

public class ProgramPage extends AbstractBasePage {
	@Autowired
	private TestContext context;
	final Logger logger = LoggerFactory.getLogger(ProgramPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=programCode]")
	private MCWebElement programSearchTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:inputTextField")
	private MCWebElement programTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:networkCode:input:dropdowncomponent")
	private MCWebElement interchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement productDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programType:input:dropdowncomponent")
	private MCWebElement programTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement baseCurrencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//img[@class='iconButton']")
	private MCWebElement imageIcon;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=noOfCurrencyAllowed]")
	private MCWebElement noOfCurrencyAllowedTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:optionalCurrencyConvFlag:input:dropdowncomponent")
	private MCWebElement currencyConversionByDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:calendarMonth:input:dropdowncomponent")
	private MCWebElement calendarStartMonthDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:transferType:input:dropdowncomponent")
	private MCWebElement walletToWalletTransferTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:referenceCurrency:input:dropdowncomponent")
	private MCWebElement referenceCurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxBalanceBefKyc:input:inputAmountField")
	private MCWebElement maximumBalanceWithoutKycTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfLoadBefKyc:input:inputTextField")
	private MCWebElement numberOfLoadsAllowedWithoutKycTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode1:input:dropdowncomponent")
	private MCWebElement walletPlanPlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode2:input:dropdowncomponent")
	private MCWebElement walletPlanPlan2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement devicePlanPlan1DDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode2:input:dropdowncomponent")
	private MCWebElement devicePlanPlan2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:statMsgCode:input:dropdowncomponent")
	private MCWebElement otherPlanStatementMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:mktMsgPlanCode:input:dropdowncomponent")
	private MCWebElement otherPlanMarketingMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditLimit:input:inputTextField")
	private MCWebElement creditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxCreditLimit:input:inputTextField")
	private MCWebElement maximumCreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitMethod:input:dropdowncomponent")
	private MCWebElement cashLimitTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitFixed:input:inputTextField")
	private MCWebElement cashLimitAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitVariable:input:inputTextField")
	private MCWebElement percentageOfCreditLimitTxt;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addProgramBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:inputTextField")
	private MCWebElement ProgramTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:description:input:inputTextField")
	private MCWebElement DescriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:networkCode:input:dropdowncomponent")
	private MCWebElement InterchangeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement ProductDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programType:input:dropdowncomponent")
	private MCWebElement ProgramTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyCode:input:dropdowncomponent")
	private MCWebElement BaseCurrencyDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:optionalCurrencyConvFlag:input:dropdowncomponent")
	private MCWebElement CurrencyConversionByDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:calendarMonth:input:dropdowncomponent")
	private MCWebElement CalendarStartMonthDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	private MCWebElement NEXTBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxBalanceBefKyc:input:inputAmountField")
	private MCWebElement MaxBalWithoutKYCTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfLoadBefKyc:input:inputTextField")
	private MCWebElement LoadsWithoutKYCTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode1:input:dropdowncomponent")
	private MCWebElement WalletPlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode2:input:dropdowncomponent")
	private MCWebElement WalletPlan2DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:walletPlanCode3:input:dropdowncomponent")
	private MCWebElement WalletPlan3DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement DevicePlan1DDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:statMsgCode:input:dropdowncomponent")
	private MCWebElement StatementMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:mktMsgPlanCode:input:dropdowncomponent")
	private MCWebElement MarketingMessagePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:creditLimit:input:inputTextField")
	private MCWebElement CreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:maxCreditLimit:input:inputTextField")
	private MCWebElement MaxCreditLimitTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitMethod:input:dropdowncomponent")
	private MCWebElement CashLimitTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitFixed:input:inputTextField")
	private MCWebElement CashLimitAmountTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:refundInCurrency:input:dropdowncomponent")
	private MCWebElement RefundinCurrencyDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelINFO']")
	private MCWebElement PanelInfo;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:noOfCurrencyAllowed:input:inputTextField")
	private MCWebElement NoOfCurrencyAllowed;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:transferType:input:dropdowncomponent")
	private MCWebElement WalletToWalletTransferType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:referenceCurrency:input:dropdowncomponent")
	private MCWebElement ReferenceCurrency;

	/*
	 * @PageElement(findBy = FindBy.NAME, valueToFind =
	 * "view:cashLimitVariable:input:inputTextField") private MCWebElement
	 * PercentageofCreditLimit;
	 */

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement cashLimitResetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:addOnLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement addOnLimitResetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:refundInCurrency:input:dropdowncomponent")
	private MCWebElement refundInCurrencyDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#dedupePlanCode select")
	private MCWebElement dedupePlanCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#documentPlanCode select")
	private MCWebElement documentPlanCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#mccRulePlanCode select")
	private MCWebElement mccRulePlanCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "#stmtPlanCode select")
	private MCWebElement stmtPlanCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:markupFeePlanCode:input:dropdowncomponent")
	private MCWebElement markupFeePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currencyPayoutListPlanCode:input:dropdowncomponent")
	private MCWebElement payoutCurrencyPlanDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:cashLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement CashLimitResetDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:addOnLimitCycleIndicatior:input:dropdowncomponent")
	private MCWebElement AddOnLimitResetDDwn;

	/*
	 * @PageElement(findBy = FindBy.NAME, valueToFind = "Textbox_NAME") private
	 * MCWebElement NEXT2;
	 */

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:finish")
	private MCWebElement FinishBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class = 'feedbackPanelERROR']")
	private MCWebElement PanelErrorTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:cancel")
	private MCWebElement CancelBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "ofacScreeningOfNewApp:checkBoxComponent")
	private MCWebElement sdnCheckBox;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement enterProgram;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:buttonPanel:buttonCol:searchButton")
	private MCWebElement search;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//following-sibling::td[4]/span/a")
	private MCWebElement editProgram;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Save']")
	public MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:loyaltyPlanCode:input:dropdowncomponent")
	private MCWebElement loyaltyPlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:allowFtIncOnClosedUsage:checkBoxComponent")
	private MCWebElement receiveCheckBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:allowFtOutOnClosedUsage:checkBoxComponent")
	private MCWebElement sendCheckBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "adaptiveEcommFlag:checkBoxComponent")
	private MCWebElement adaptiveAuthenticationCheckBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//ul[@class='tabs']/li[2]")
	private MCWebElement planTab;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'countryWbPlanCode:input:dropdowncomponent')]")
	private MCWebElement countryWhiteBlackListPlan;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "authoLevelCard:checkBoxComponent")
	private MCWebElement chkBxCardCreditLimitValidation;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[starts-with(text(),'Limits')]")
	private MCWebElement txtLimitLevelValidation;

	private final String COUNTRY_WHITELIST_AND_BLACKLIST_PLAN="country white and black list";
	public void addProgram(String programCode) {
		WebElementUtils.enterText(programTxt, programCode);
	}

	public void addDescription(String description) {
		WebElementUtils.enterText(descriptionTxt, description);
	}

	public void selectInterchange(String interchange) {
		selectByVisibleText(interchangeDDwn, interchange);
	}

	public void selectProduct(String product) {
		WebElementUtils.selectDropDownByVisibleText(productDDwn, product);
	}

	public void selectProgramType(String programType) {
		selectByVisibleText(programTypeDDwn, programType);
	}

	public void selectBaseCurrency(String baseCurrency) {
		WebElementUtils.selectDropDownByVisibleText(baseCurrencyDDwn, baseCurrency);
	}

	public void enterNoOfCurrencyAllowed(String noOfCurrencyAllowed) {
		WebElementUtils.enterText(noOfCurrencyAllowedTxt, noOfCurrencyAllowed);
	}

	public void selectCurrencyConversionBy(String currencyConversionBy) {
		if (currencyConversionByDDwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(currencyConversionByDDwn, currencyConversionBy);
	}

	public void selectCalendarStartMonth(String calendarStartMonth) {
		WebElementUtils.selectDropDownByVisibleText(calendarStartMonthDDwn, calendarStartMonth);
	}

	public void selectWalletToWalletTransferType(String walletToWalletTransferType) {
		WebElementUtils.selectDropDownByVisibleText(walletToWalletTransferTypeDDwn, walletToWalletTransferType);
	}

	public void selectReferenceCurrency(String referenceCurrency) {
		WebElementUtils.selectDropDownByVisibleText(referenceCurrencyDDwn, referenceCurrency);
	}

	public void addMaximumBalanceWithoutKyc(String maximumBalanceWithoutKyc) {
		WebElementUtils.enterText(maximumBalanceWithoutKycTxt, maximumBalanceWithoutKyc);
	}

	public void addnumberOfLoadsAllowedWithoutKyc(String numberOfLoadsAllowedWithoutKyc) {
		WebElementUtils.enterText(numberOfLoadsAllowedWithoutKycTxt, numberOfLoadsAllowedWithoutKyc);
	}

	public void receiveFundTransferForUsage() {
		WebElementUtils.checkCheckbox(receiveCheckBx, true);
	}

	public void sendFundTransferForUsage() {
		WebElementUtils.checkCheckbox(sendCheckBx, true);
	}

	public void selectWalletPlanPlan1(String walletPlanPlan1) {
		WebElementUtils.selectDropDownByVisibleText(walletPlanPlan1DDwn, walletPlanPlan1);
	}

	public void selectWalletPlanPlan2(String walletPlanPlan1) {
		WebElementUtils.selectDropDownByVisibleText(walletPlanPlan2DDwn, walletPlanPlan1);
	}

	public void selectRefundInCurrency(String refundInCurrency) {
		if (refundInCurrencyDDwn.isEnabled())
			WebElementUtils.selectDropDownByVisibleText(refundInCurrencyDDwn, refundInCurrency);
	}

	public void selectDevicePlanPlan1DDwn(String devicePlanPlan1) {
		WebElementUtils.selectDropDownByVisibleText(devicePlanPlan1DDwn, devicePlanPlan1);
	}
	
	public void selectDevicePlanPlan2DDwn(String devicePlanPlan2) {
		WebElementUtils.selectDropDownByVisibleText(devicePlanPlan2DDwn, devicePlanPlan2);
	}

	public void selectOtherPlanStatementMessagePlan(String otherPlanStatementMessagePlan) {
		WebElementUtils.selectDropDownByVisibleText(otherPlanStatementMessagePlanDDwn, otherPlanStatementMessagePlan);
	}

	public void selectOtherPlanMarketingMessagePlan(String otherPlanMarketingMessagePlan) {
		WebElementUtils.selectDropDownByVisibleText(otherPlanMarketingMessagePlanDDwn, otherPlanMarketingMessagePlan);
	}
	
	public void selectPayoutCurrencyPlan(String payoutCurrencyPlan) {
		if (payoutCurrencyPlanDDwn.isEnabled())
		{
			WebElementUtils.selectDropDownByVisibleText(payoutCurrencyPlanDDwn, payoutCurrencyPlan);
		}
	}

	public void addProgramData(Program program, String productType) {
		logger.info("Add Program: {}", program.getProgramCode());
		clickAddNewButton();

		runWithinPopup("Add Program", () -> {
			addProgram(program.getProgramCode());          	
			addDescription(program.getDescription());
			SimulatorUtilities.wait(2000);
			selectInterchange(program.getInterchange());
			SimulatorUtilities.wait(2000);
			selectProduct(program.getProduct());
			SimulatorUtilities.wait(2000);
			selectProgramType(program.getProgramType());					
			SimulatorUtilities.wait(2000);
			selectBaseCurrency(program.getBaseCurrency());
			program.setProgramCodeDevice(program.getDescription() + " " + "[" + program.getProgramCode() + "]");
			logger.info("Program added :" + program.getDescription() + " " + "[" + program.getProgramCode() + "]");
			if (program.getProgramType().contains("Multi")) {
				addNumberOfCurrency(program.getNoOfCurrencyAllowed());
				selectPayoutCurrencyPlan(program.getPayoutCurrencyPlan());
				selectRefundInCurrency(program.getRefundInCurrency());
				selectWalletToWalletTransferType(program.getWalletToWalletTransferType());
				if ("Reference Currency [R]".equalsIgnoreCase(program.getWalletToWalletTransferType()))
					selectReferenceCurrency(program.getReferenceCurrency());
			}
			if (productType.equalsIgnoreCase(ProductType.PREPAID)){
				selectCurrencyConversionBy(program.getCurrencyConversionBy());
			}				
			selectCalendarStartMonth(program.getCalendarStartMonth());
			fillExtraSections(program, productType);
			clickNextButton();
			clickFinishButton();
		});
		verifyOperationStatus();
	}

	public void addProgramForMultiWallet(Program program, String productType) {
		logger.info("Add Program: {}", program.getProgramCode());
		clickAddNewButton();

		runWithinPopup("Add Program", () -> {
			addProgram(program.getProgramCode());
			addDescription(program.getDescription());
          	SimulatorUtilities.wait(2000);
			selectInterchange(program.getInterchange());
          	SimulatorUtilities.wait(2000);
			selectProduct(program.getProduct());
          	SimulatorUtilities.wait(2000);
			selectProgramType(program.getProgramType());
          	SimulatorUtilities.wait(2000);
			selectBaseCurrency(program.getBaseCurrency());
          	SimulatorUtilities.wait(2000);
			program.setProgramCodeDevice(program.getDescription() + " " + "[" + program.getProgramCode() + "]");
			logger.info("Program added :" + program.getDescription() + " " + "[" + program.getProgramCode() + "]");
			if (program.getProgramType().contains("Multi")) {
				addNumberOfCurrency(program.getNoOfCurrencyAllowed());
				if (!MiscUtils.getEnvironment().contains(Constants.ENVIRONMENT)) {
					selectPayoutCurrencyPlan(program.getPayoutCurrencyPlan());
				}
				selectRefundInCurrency(program.getRefundInCurrency());
				selectWalletToWalletTransferType(program.getWalletToWalletTransferType());
				if ("Reference Currency [R]".equalsIgnoreCase(program.getWalletToWalletTransferType()))
					selectReferenceCurrency(program.getReferenceCurrency());
			}
			if (!productType.equalsIgnoreCase(ProductType.DEBIT))
				selectCurrencyConversionBy(program.getCurrencyConversionBy());
			selectCalendarStartMonth(program.getCalendarStartMonth());
			fillExtraSections(program, productType);
			clickNextButton();
			clickFinishButton();
		});
		verifyOperationStatus();
	}

	public void addsProgramData(Program program, String productType) {
		logger.info("Add Program: {}", program.getProgramCode());
		clickAddNewButton();

		runWithinPopup("Add Program", () -> {
			addProgram(program.getProgramCode());
			addDescription(program.getDescription());
			selectInterchange(program.getInterchange());
			selectProduct(program.getProduct());
			selectProgramType(program.getProgramType());
			selectBaseCurrency(program.getBaseCurrency());
			program.setProgramCodeDevice(program.getDescription() + " " + "[" + program.getProgramCode() + "]");
			logger.info("Program added :" + program.getDescription() + " " + "[" + program.getProgramCode() + "]");
			if (program.getProgramType().contains("Multi")) {
				addNumberOfCurrency(program.getNoOfCurrencyAllowed());
				if (!MiscUtils.getEnvironment().contains(Constants.ENVIRONMENT)) {
					selectPayoutCurrencyPlan(program.getPayoutCurrencyPlan());
				}
				selectRefundInCurrency(program.getRefundInCurrency());
				selectWalletToWalletTransferType(program.getWalletToWalletTransferType());
				if ("Reference Currency [R]".equalsIgnoreCase(program.getWalletToWalletTransferType()))
					selectReferenceCurrency(program.getReferenceCurrency());
			}
			if (!productType.equalsIgnoreCase(ProductType.DEBIT))
				selectCurrencyConversionBy(program.getCurrencyConversionBy());
			selectCalendarStartMonth(program.getCalendarStartMonth());
			fillExtraSection(program, productType);
			clickNextButton();
			clickFinishButton();
		});
		verifyOperationStatus();
	}

	private void addNumberOfCurrency(String numberOfCurrencyAllowed) {
		noOfCurrencyAllowedTxt.clearField();
		WebElementUtils.acceptAlert(driver());
		enterNoOfCurrencyAllowed(numberOfCurrencyAllowed);
	}

	public void selectIframeLoyaltyPlan(String loyaltyPlan) {
		if (loyaltyPlan != null)
			selectByVisibleText(loyaltyPlanDDwn, loyaltyPlan);

	}

	private void fillExtraSections(Program program, String productType) {
		
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			addMaximumBalanceWithoutKyc(program.getMaximumBalanceWithoutKyc());
			addnumberOfLoadsAllowedWithoutKyc(program.getNumberOfLoadsAllowedWithoutKyc());
			receiveFundTransferForUsage();
			sendFundTransferForUsage();
			selectRefundInCurrency(program.getRefundInCurrency());
		}

		clickNextButton();
		selectWalletPlanPlan1(program.getFirstWalletPlan());
		selectDevicePlanPlan1DDwn(program.getDevicePlanPlan1());
		
		if(Objects.nonNull(program.getApplicationType()) || Objects.nonNull(program.getSubApplicationType())){
			if(program.getApplicationType().contains(ApplicationType.SUPPLEMENTARY_DEVICE)||program.getApplicationType().contains(ApplicationType.ADD_ON_DEVICE)){
			      selectDevicePlanPlan2DDwn(program.getDevicePlanPlan2());
			}
		}		
		
		if (!productType.equalsIgnoreCase(ProductType.DEBIT)) {
			selectOtherPlanStatementMessagePlan(program.getOtherPlanStatementMessagePlan());
			selectOtherPlanMarketingMessagePlan(program.getOtherPlanMarketingMessagePlan());
		}

		WebElementUtils.selectDropDownByOptionalVisibleText(dedupePlanCodeDDwn, program.getDedupPlan());
		WebElementUtils.selectDropDownByOptionalVisibleText(documentPlanCodeDDwn, program.getDocumentChecklistPlan());
		WebElementUtils.selectDropDownByOptionalVisibleText(mccRulePlanCodeDDwn, program.getMmcRulePlan());

		if (productType.equalsIgnoreCase(ProductType.PREPAID)|| productType.equalsIgnoreCase(ProductType.CREDIT)) {
			WebElementUtils.selectDropDownByOptionalVisibleText(markupFeePlanDDwn, program.getMarkUpFeePlan());
			WebElementUtils.selectDropDownByOptionalVisibleText(stmtPlanCodeDDwn, program.getPrepaidStatementPlan());
		}
		if (loyaltyPlanDDwn != null && Objects.nonNull(program.getLoyaltyPlan()) && !program.getLoyaltyPlan().isEmpty()) {
			WebElementUtils.selectDropDownByOptionalVisibleText(loyaltyPlanDDwn, program.getLoyaltyPlan());
		}

		waitForLoaderToDisappear();
		clickNextButton();
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			fillDataForCreditCard(program);
		}
	}

	private void fillExtraSection(Program program, String productType) {
		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			addMaximumBalanceWithoutKyc(program.getMaximumBalanceWithoutKyc());
			addnumberOfLoadsAllowedWithoutKyc(program.getNumberOfLoadsAllowedWithoutKyc());
			receiveFundTransferForUsage();
			sendFundTransferForUsage();
			selectRefundInCurrency(program.getRefundInCurrency());
		}

		clickNextButton();

		logger.info("Assign first Wallet :" + program.getFirstWalletPlan());
		selectWalletPlanPlan1(program.getFirstWalletPlan());
		logger.info("Assign second Wallet :" + program.getSecondWalletPlan());
		selectWalletPlanPlan2(program.getSecondWalletPlan());

		selectDevicePlanPlan1DDwn(program.getDevicePlanPlan1());
		if (!productType.equalsIgnoreCase(ProductType.DEBIT)) {
			selectOtherPlanStatementMessagePlan(program.getOtherPlanStatementMessagePlan());
			selectOtherPlanMarketingMessagePlan(program.getOtherPlanMarketingMessagePlan());
		}

		WebElementUtils.selectDropDownByOptionalVisibleText(dedupePlanCodeDDwn, program.getDedupPlan());
		WebElementUtils.selectDropDownByOptionalVisibleText(documentPlanCodeDDwn, program.getDocumentChecklistPlan());
		WebElementUtils.selectDropDownByOptionalVisibleText(mccRulePlanCodeDDwn, program.getMmcRulePlan());

		if (productType.equalsIgnoreCase(ProductType.PREPAID)) {
			WebElementUtils.selectDropDownByOptionalVisibleText(stmtPlanCodeDDwn, program.getPrepaidStatementPlan());
		}
		waitForLoaderToDisappear();
		clickNextButton();
		if (productType.equalsIgnoreCase(ProductType.CREDIT)) {
			fillDataForCreditCard(program);
		}
	}

	public void fillDataForCreditCard(Program program) {
		WebElementUtils.enterText(creditLimitTxt, program.getCreditLimit());
		WebElementUtils.enterText(maximumCreditLimitTxt, program.getMaximumCreditLimit());
		WebElementUtils.selectDropDownByVisibleText(cashLimitTypeDDwn, program.getCashLimitType());
		WebElementUtils.enterText(cashLimitAmountTxt, program.getCashLimitAmount());
		WebElementUtils.selectDropDownByVisibleText(cashLimitResetDDwn, program.getCashLimitReset());
		WebElementUtils.selectDropDownByVisibleText(addOnLimitResetDDwn, program.getAddOnLimitReset());		
	}

	public void verifyUiOperationStatus() {
		logger.info("Program");
		verifySearchButton("Search");
	}

	public void clickAddProgram() {
		clickWhenClickable(addProgramBtn);
		switchToAddProgramframe();
	}

	public void switchToAddProgramframe() {
		switchToIframe(Constants.ADD_PROGRAM_FRAME);
	}

	public String enterProgramCode(Program program) {
		waitForElementVisible(programTxt);
		if (program.getCode().length() != 0) {
			enterValueinTextBox(programTxt, program.getCode());
		} else {
			enterValueinTextBox(programTxt, CustomUtils.randomAlphaNumeric(5).toUpperCase());
		}
		program.setProgramCode(programTxt.getAttribute("value"));
		return programTxt.getAttribute("value");
	}

	public String enterProgramDescription(Program program) {
		if (program.getDescription().length() != 0) {
			enterValueinTextBox(descriptionTxt, program.getDescription());
		} else {
			enterValueinTextBox(descriptionTxt, "programDescription" + CustomUtils.randomNumbers(5));
		}
		program.setDescription(descriptionTxt.getAttribute("value"));
		return descriptionTxt.getAttribute("value");
	}

	public void selectInterchange(Program program) {
		selectByVisibleText(InterchangeDDwn, program.getInterchange());
	}

	public void selectProduct(Program program) {
		selectByVisibleText(ProductDDwn, program.getProduct());
	}

	public void selectRefundinCurrency(Program program) {
		if (RefundinCurrencyDDwn.isEnabled()) {
			selectByVisibleText(RefundinCurrencyDDwn, program.getRefundInCurrency());
		}
	}

	public void selectProgramType(Program program) {
		selectByVisibleText(ProgramTypeDDwn, program.getProgramType());

	}

	public void selectBaseCurrency(Program program) {
		selectByVisibleText(BaseCurrencyDDwn, program.getBaseCurrency());
	}

	public void selectCurrencyConversionBy(Program program) {
		if (CurrencyConversionByDDwn.isEnabled()) {
			selectByVisibleText(CurrencyConversionByDDwn, program.getCurrencyConversionBy());
		}

	}

	public void enterNoOfCurrencyAllowed() {
		waitForElementVisible(ProductDDwn);
		NoOfCurrencyAllowed.clearField();
		Alert alert = getFinder().getWebDriver().switchTo().alert();
		logger.info(alert.getText());
		alert.accept();
		enterValueinTextBox(NoOfCurrencyAllowed, "3");
	}

	public void selectWalletToWalletTransfer() {
		selectDropDownByIndex(WalletToWalletTransferType, 1);
	}

	public void selectReferenceCurrency(Program program) {
		if (ReferenceCurrency.isEnabled()) {
			selectByVisibleText(ReferenceCurrency, program.getBaseCurrency());
		}
	}

	public void selectCalendarStartMonth() {
		selectDropDownByIndex(CalendarStartMonthDDwn, 1);
	}

	public void enterMaximumBalanceWithoutKYC(Program program) {
		if (MaxBalWithoutKYCTxt.isEnabled())
			enterValueinTextBox(MaxBalWithoutKYCTxt, program.getMaxBalanceWithoutKYC());
	}

	public void enterLoadsWithoutKYC(Program program) {
		if (LoadsWithoutKYCTxt.isEnabled())
			enterValueinTextBox(LoadsWithoutKYCTxt, program.getLoadsWithoutKyc());
	}

	@Override
	public void clickNextButton() {
		ClickButton(NEXTBtn);
		waitForWicket();
		SimulatorUtilities.wait(2000);
	}

	public void selectWalletPlan1(Program program) {
		if (MapUtils.fnGetInputDataFromMap("WalletPlan") != null) {
			selectByVisibleText(WalletPlan1DDwn, MapUtils.fnGetInputDataFromMap("WalletPlan"));
		} else {
			Program programContext = context.get(ContextConstants.PROGRAM);
			selectByVisibleText(WalletPlan1DDwn, /* program.getWalletPlan1() */programContext.getWalletPlan1());
		}
	}

	public void selectWalletPlan2(Program program) {
		waitForElementVisible(WalletPlan2DDwn);
		if (WalletPlan2DDwn.isEnabled()) {
			if (MapUtils.fnGetInputDataFromMap("WalletPlan2") != null) {
				selectByVisibleText(WalletPlan2DDwn, MapUtils.fnGetInputDataFromMap("WalletPlan2"));
			} else {
				selectByVisibleText(WalletPlan2DDwn, program.getWalletPlan2());
			}
		}
	}

	public void selectWalletPlan3(Program program) {
		waitForElementVisible(WalletPlan3DDwn);
		if (WalletPlan3DDwn.isEnabled()) {
			if (MapUtils.fnGetInputDataFromMap("WalletPlan3") != null) {
				selectByVisibleText(WalletPlan3DDwn, MapUtils.fnGetInputDataFromMap("WalletPlan3"));
			} else {
				selectDropDownByIndex(WalletPlan3DDwn, 3);
			}
		}
	}

	public void selectDevicePlan1(Program program) {
		waitForElementVisible(DevicePlan1DDwn);
		if (program.getDevicePlanProgram().length() != 0) {
			selectByVisibleText(DevicePlan1DDwn, program.getDevicePlanProgram());
		} else {
			logger.info("DevicePlanProgram:" + program.getDevicePlanProgram());
			selectByVisibleText(DevicePlan1DDwn, program.getDevicePlanProgram());
		}

	}

	public void selectStatementMessagePlan() {
		waitForElementVisible(StatementMessagePlanDDwn);
		selectDropDownByIndex(StatementMessagePlanDDwn, 1);
	}

	public void selectMarketingMessagePlan() {
		waitForElementVisible(MarketingMessagePlanDDwn);
		selectDropDownByIndex(MarketingMessagePlanDDwn, 1);
	}

	@Override
	public void clickFinishButton() {
		waitForElementVisible(FinishBtn);
		clickWhenClickable(FinishBtn);
		switchToDefaultFrame();
	}

	public boolean verifyErrorsOnProgramPage() {
		return publishErrorOnPage();
	}

	public void verifyNewProgramSuccess() {
		if (!verifyErrorsOnProgramPage()) {
			logger.info("Program Added Successfully");
			waitForPageToLoad(driver());
			switchToDefaultFrame();
		} else {
			logger.info("Error in Record Addition");
			clickWhenClickable(CancelBtn);
			switchToDefaultFrame();
		}
	}

	public void editProgram(String prog) {
		enterValueinTextBox(enterProgram, prog);
		clickWhenClickable(search);
		waitForElementVisible(editProgram);
		Scrolldown(editProgram);
		clickWhenClickableDoNotWaitForWicket(editProgram);
		switchToEditProgramframe();
	}

	public boolean adaptiveAuthenticationChkBox() {
		boolean flag = false;
		flag = adaptiveAuthenticationCheckBx.isEnabled();
		if (flag == true)
			clickWhenClickable(adaptiveAuthenticationCheckBx);
		clickWhenClickable(save);
		return flag;
	}

	public String addProgramGeneral(Program program) {
		String programCode;
		String ProgramDescription;
		programCode = enterProgramCode(program);
		program.setProgramCode(programCode);
		ProgramDescription = enterProgramDescription(program);
		selectInterchange(program);
		selectProduct(program);
		selectProgramType(program);
		selectBaseCurrency(program);
		selectCurrencyConversionBy(program);
		selectCalendarStartMonth();
		return buildDescriptionAndCode(ProgramDescription, programCode);
	}

	public String addProgramGeneralMultiCurrency(Program program) {
		String programCode;
		String ProgramDescription;
		programCode = enterProgramCode(program);
		program.setProgramCode(programCode);
		ProgramDescription = enterProgramDescription(program);
		selectInterchange(program);
		selectProduct(program);
		selectProgramType(program);
		selectBaseCurrency(program);
		enterNoOfCurrencyAllowed();
		selectCurrencyConversionBy(program);
		selectCalendarStartMonth();
		selectWalletToWalletTransfer();
		selectReferenceCurrency(program);
		return buildDescriptionAndCode(ProgramDescription, programCode);
	}

	public void addKYCLimits(Program program) {
		enterMaximumBalanceWithoutKYC(program);
		enterLoadsWithoutKYC(program);
	}

	public void selectLoadAndRefundParameters(Program program) {
		selectRefundinCurrency(program);
	}

	public void selectWalletPLan(Program program) {
		selectWalletPlan1(program);
		if ((program.getProgramType().contains("Travel card")) || (program.getWalletType().contains("Multi"))) {
			selectWalletPlan2(program);
		}
	}

	public void selectDevicePlan(Program program) {
		selectDevicePlan1(program);
	}

	public void selectOtherPlans(String loyaltyPlan) {
		selectStatementMessagePlan();
		selectMarketingMessagePlan();
		if (loyaltyPlan != null)
			selectByVisibleText(loyaltyPlanDDwn, loyaltyPlan);
	}

	public void selectOtherPlans1() {
		selectStatementMessagePlan();
		selectMarketingMessagePlan();
	}

	public void enterProgramValue(String a) {
		enterValueinTextBox(enterProgram, a);
		clickWhenClickable(search);
		waitForWicket(driver());
		clickWhenClickable(editProgram);
		CustomUtils.ThreadDotSleep(2000);
		switchToEditProgramframe();
		ClickCheckBox(sdnCheckBox, false);
		clickSaveButton();
	}

	public void switchToEditProgramframe() {
		switchToIframe(Constants.EDIT_PROGRAM_FRAME);
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(programSearchTxt));

	}
	
	private void setCountryWhiteListAndBlackListPlan(Program program) {
		WebElementUtils.selectDropDownByVisibleText(countryWhiteBlackListPlan, program.getCountryWhiteListAndBlackListPlan());

	}

	private void editsProgram(Program program, String editItem) {
		clickWhenClickable(planTab);
		setCountryWhiteListAndBlackListPlan(program);
		clickSaveButton();
	}

	public void editsProgramForPlans(Program program, String editItem) {
		enterValueinTextBox(enterProgram, program.getProgramCode());
		logger.info("Program code :{}", program.getProgramCode());
		clickWhenClickable(search);
		waitForElementVisible(editProgram);
		clickWhenClickable(editProgram);
		runWithinPopup("Edit Program", () -> {
			editsProgram(program, editItem);
		});
	}
	
	public void editProgramToEnableCardLimit(String program) {
		enterValueinTextBox(enterProgram, program);
		clickWhenClickable(search);
		waitForElementVisible(editProgram);
		editFirstRecord();
		Scrolldown(editProgram);
		runWithinPopup(Constants.EDIT_PROGRAM_FRAME,()-> {
			cardCreditLimitValidation();	
		});
		verifyOperationStatus();
	}
	
	public void cardCreditLimitValidation(){
		SimulatorUtilities.wait(2000);
		clickWhenClickable(txtLimitLevelValidation);
		ClickCheckBox(chkBxCardCreditLimitValidation,true);
		clickSaveButton();
	}
}
