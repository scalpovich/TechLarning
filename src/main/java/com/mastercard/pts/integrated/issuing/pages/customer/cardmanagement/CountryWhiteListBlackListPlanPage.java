package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CountryWhiteListBlackListPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_COUNTRY_WHITE_LIST_BLACK_LIST_PLAN })
public class CountryWhiteListBlackListPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CountryWhiteListBlackListPlanPage.class);
	private final String WHITE_LIST="White List";
	private final String BLACK_LIST="Black List";
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=countryWblistPlanCode]")
	private MCWebElement countryWblistPlanCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryWblistPlanCode:input:inputTextField")
	private MCWebElement planCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement planDescription;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='planType:radioComponent' and @value='W']")
	private MCWebElement planTypeWhiteList;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='planType:radioComponent' and @value='B']")
	private MCWebElement planTypeBlackList;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryCode;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='countryWblistEffectiveDate:input:dateTextField']/..")
	private MCWebElement effectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='countryWblistEndDate:input:dateTextField']/..")
	private MCWebElement endDate;
	
	private String addCountryFrame="//h3[contains(text(), 'Add Country')]/ancestor::div//iframe";

	private final String ADD_COUNTRY_WHITELIST_BLACK_LIST_PLAN_FRAME="Add Country White List/ Black List Plan";
	public void verifyUiOperationStatus() {
		logger.info("Country White List/ Black List Plan");
		verifyUiOperation("Add Country White List/ Black List Plan");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(countryWblistPlanCode),
				WebElementUtils.elementToBeClickable(description));
	}

	public boolean addCountryInBlackOrWhiteListInPlan(CountryWhiteListBlackListPlan countryWhiteListBlackListPlan) {
		clickAddNewButton();
		runWithinPopup(ADD_COUNTRY_WHITELIST_BLACK_LIST_PLAN_FRAME, () -> {
			addPlanDetailsInPopUp(countryWhiteListBlackListPlan);
			addCountry(countryWhiteListBlackListPlan);
		});
		runWithinPopup(ADD_COUNTRY_WHITELIST_BLACK_LIST_PLAN_FRAME, () -> {
			clickSaveButton();
		});
		verifyUiOperationStatus();
		return verifyPlanCodeIsAdded(countryWhiteListBlackListPlan);

	}

	private void addPlanDetailsInPopUp(CountryWhiteListBlackListPlan countryWhiteListBlackListPlan) {
		WebElementUtils.enterText(planCode, countryWhiteListBlackListPlan.getPlanCode());
		WebElementUtils.enterText(planDescription, countryWhiteListBlackListPlan.getDescription());
		if (countryWhiteListBlackListPlan.getPlanType().equals(WHITE_LIST)) {
			WebElementUtils.selectRadioBtn(planTypeWhiteList);
		} else if (countryWhiteListBlackListPlan.getPlanType().equals(BLACK_LIST)) {
			WebElementUtils.selectRadioBtn(planTypeBlackList);
		}
		clickAddDetailsButton();
		clickAddNewButton();
	}

	private void addCountry(CountryWhiteListBlackListPlan countryWhiteListBlackListPlan) {
		SimulatorUtilities.wait(1000);
		switchToDefaultFrame();
		switchToDefaultFrame(addCountryFrame,1);
		WebElementUtils.selectDropDownByVisibleText(countryCode, countryWhiteListBlackListPlan.getCountryCode());
		WebElementUtils.pickDate(effectiveDate, LocalDate.now().plusDays(1));
		WebElementUtils.pickDate(endDate, LocalDate.now().plusYears(7));
		clickSaveButton();
	}

	private boolean verifyPlanCodeIsAdded(CountryWhiteListBlackListPlan countryWhiteListBlackListPlan) {
		SimulatorUtilities.wait(500);
		WebElementUtils.enterText(countryWblistPlanCode, countryWhiteListBlackListPlan.getPlanCode());
		clickSearchButton();
		SimulatorUtilities.wait(500);
		return getFirstColumnValueFromTable().equalsIgnoreCase(countryWhiteListBlackListPlan.getPlanCode());

	}
}
