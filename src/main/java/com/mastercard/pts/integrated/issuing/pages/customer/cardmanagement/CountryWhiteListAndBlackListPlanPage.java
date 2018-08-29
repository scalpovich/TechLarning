package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CountryWhiteListAndBlackListPlan;
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
public class CountryWhiteListAndBlackListPlanPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CountryWhiteListAndBlackListPlanPage.class);

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

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Add Details']")
	private MCWebElement addDetailsButton;;

	public void verifyUiOperationStatus() {
		logger.info("Country White List/ Black List Plan");
		verifyUiOperation("Add Country White List/ Black List Plan");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(countryWblistPlanCode),
				WebElementUtils.elementToBeClickable(description));
	}

	public boolean addCountryInBlackOrWhiteListInPlan(CountryWhiteListAndBlackListPlan countryWhiteListBlackListPlan) {
		clickAddNewButton();
		runWithinPopup("Add Country White List/ Black List Plan", () -> {
			addPlanDetailsInPopUp(countryWhiteListBlackListPlan);
			addCountry(countryWhiteListBlackListPlan);
		});
		runWithinPopup("Add Country White List/ Black List Plan", () -> {
			clickSaveButton();
		});
		return verifyPlanCodeIsAdded(countryWhiteListBlackListPlan);

	}

	private void addPlanDetailsInPopUp(CountryWhiteListAndBlackListPlan countryWhiteListBlackListPlan) {
		WebElementUtils.enterText(planCode, countryWhiteListBlackListPlan.getPlanCode());
		WebElementUtils.enterText(planDescription, countryWhiteListBlackListPlan.getDescription());
		if (countryWhiteListBlackListPlan.getPlanType().equals("White List"))
			WebElementUtils.selectRadioBtn(planTypeWhiteList);
		else if (countryWhiteListBlackListPlan.getPlanType().equals("Black List"))
			WebElementUtils.selectRadioBtn(planTypeBlackList);
		addDetailsButton.click();
		SimulatorUtilities.wait(500);
		clickAddNewButton();

	}

	private void addCountry(CountryWhiteListAndBlackListPlan countryWhiteListBlackListPlan) {
		SimulatorUtilities.wait(1000);
		driver().switchTo().defaultContent();
		driver().switchTo().frame(
				driver().findElements(By.xpath("//h3[contains(text(), 'Add Country')]/ancestor::div//iframe")).get(1));

		WebElementUtils.selectDropDownByVisibleText(countryCode, countryWhiteListBlackListPlan.getCountryCode());
		WebElementUtils.pickDate(effectiveDate, LocalDate.now().plusDays(1));
		WebElementUtils.pickDate(endDate, LocalDate.now().plusYears(7));
		clickSaveButton();

	}

	private boolean verifyPlanCodeIsAdded(CountryWhiteListAndBlackListPlan countryWhiteListBlackListPlan) {
		WebElementUtils.enterText(countryWblistPlanCode, countryWhiteListBlackListPlan.getPlanCode());
		clickSearchButton();

		SimulatorUtilities.wait(500);
		if (getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']/tbody/tr/td[2]/span"))
				.size() == 1)
			return true;
		return false;

	}
}
