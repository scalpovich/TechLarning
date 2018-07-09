package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListReasonPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import net.serenitybdd.core.annotations.findby.By;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_STOPLIST_REASON })
public class StoplistReasonPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(StoplistReasonPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=description]")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement reasonCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "reasonCode:input:dropdowncomponent")
	private MCWebElement reasonCodeInPopUp;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionInPopUp;

	@PageElement(findBy = FindBy.NAME, valueToFind = "stickyFlag:checkBoxComponent")
	private MCWebElement stickyRadioButton;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToMaster:radioComponent' and @value='O']")
	private MCWebElement sentToMasterOnline;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToMaster:radioComponent' and @value='N']")
	private MCWebElement sentToMasterNotRequired;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToVisa:radioComponent' and @value='O']")
	private MCWebElement sentToVisaOnline;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToVisa:radioComponent' and @value='N']")
	private MCWebElement sentToVisaNotRequired;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToRupay:radioComponent' and @value='O']")
	private MCWebElement sentToRupayOnline;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToRupay:radioComponent' and @value='B']")
	private MCWebElement sentToRupayBatch;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToRupay:radioComponent' and @value='N']")
	private MCWebElement sentToRupayNotRequired;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToAmex:radioComponent' and @value='B']")
	private MCWebElement sentToAmexBatch;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToAmex:radioComponent' and @value='O']")
	private MCWebElement sentToAmexOnline;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='sentToAmex:radioComponent' and @value='N']")
	private MCWebElement sentToAmexNotRequired;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcUS:checkBoxComponent")
	private MCWebElement regionMCUS;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcCanada:checkBoxComponent")
	private MCWebElement regionMCCanada;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcAmerica:checkBoxComponent")
	private MCWebElement regionMCCarribbean;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcAsia:checkBoxComponent")
	private MCWebElement regionMCAsia;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcEurope:checkBoxComponent")
	private MCWebElement regionMCEurope;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mcMiddleEast:checkBoxComponent")
	private MCWebElement regionMCAfrica;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaVIP:checkBoxComponent")
	private MCWebElement regionVisaVIP;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaAisapacific:checkBoxComponent")
	private MCWebElement regionVisaAsia;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaCentralUroppe:checkBoxComponent")
	private MCWebElement regionVisaAfrica;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaCanadaVisa:checkBoxComponent")
	private MCWebElement regionVisaCanada;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaNaReBulettin:checkBoxComponent")
	private MCWebElement regionVisaNationalCardRecovery;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaEurope:checkBoxComponent")
	private MCWebElement regionVisaEurope;

	@PageElement(findBy = FindBy.NAME, valueToFind = "visaLatinAm:checkBoxComponent")
	private MCWebElement regionVisaCarribbean;

	public void verifyUiOperationStatus() {
		logger.info("Stoplist Reason");
		verifyUiOperation("Add Stoplist Reason");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(reasonCode),
				WebElementUtils.elementToBeClickable(description));
	}

	public void addStopListReasonInStopListPage(StopListReasonPlan stopListReasonPlan) {

		for (int index = 0; index < stopListReasonPlan.getSize(); index++) {
			if (verifyReasonAlreadyExistsOrNotInStopList(stopListReasonPlan.getDescription(index)) == false) {
				clickAddNewButton();
				
					addLostPlanInStopList(stopListReasonPlan.getReasonCode()[index],
							stopListReasonPlan.getDescription(index), stopListReasonPlan.getSticky(index),
							stopListReasonPlan.getSentToMastercard(index),
							stopListReasonPlan.getRegionMastercard(index), stopListReasonPlan.getSentToVisa(index),
							stopListReasonPlan.getRegionVisa(index), stopListReasonPlan.getSentToRupay(index),
							stopListReasonPlan.getSentToAmex(index));
				}

		}

		
	}

	private void addLostPlanInStopList(String reasonCode, String description, String sticky, String sentToMasterCard,
			String regionMastercard, String sentToVisa, String regionVisa, String sentToRupay, String sentToAmex) {
		runWithinPopup("Add Stoplist Reason", () -> {
		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, reasonCode);
		WebElementUtils.enterText(descriptionInPopUp, description);
		if (sticky.equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (sentToMasterCard.equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (sentToVisa.equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (sentToRupay.equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (sentToRupay.equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (sentToAmex.equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (sentToAmex.equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (regionMastercard != null || regionVisa != null) {
			selectRegions(regionMastercard.split(" "));
			selectRegions(regionVisa.split(" "));
		}
		clickSaveButton();
		});
	}

	private boolean verifyReasonAlreadyExistsOrNotInStopList(String stopListReason) {
		WebElementUtils.enterText(description, stopListReason);
		clickSearchButton();
		SimulatorUtilities.wait(1000);
		if (getFinder().getWebDriver().findElements(By.xpath("//table[@class='dataview']/tbody/tr/td[2]/span"))
				.size() == 1)
			return true;
		return false;

	}

	public void selectRegions(String regions[]) {
		for (String string : regions) {
			switch (string) {
			case "1-US":
				WebElementUtils.checkCheckbox(regionMCUS, true);
				break;
			case "A-Cananda":
				WebElementUtils.checkCheckbox(regionMCCanada, true);
				break;
			case "B-Latin America/Carribbean":
				WebElementUtils.checkCheckbox(regionMCCarribbean, true);
				break;
			case "C-Asia/Pacific":
				WebElementUtils.checkCheckbox(regionMCAsia, true);
				break;
			case "D-Europe":
				WebElementUtils.checkCheckbox(regionMCEurope, true);
				break;
			case "E-Middle East/Africa":
				WebElementUtils.checkCheckbox(regionMCAfrica, true);
				break;
			case "0-No Bulletin/V.I.P. Only":
				WebElementUtils.checkCheckbox(regionVisaVIP, true);
				break;
			case "A-Asia-Pacific region":
				WebElementUtils.checkCheckbox(regionVisaAsia, true);
				break;
			case "B- Central Europe/Middle East and Africa(CEMEA)":
				WebElementUtils.checkCheckbox(regionVisaAfrica, true);
				break;
			case "C-Canada":
				WebElementUtils.checkCheckbox(regionVisaCanada, true);
				break;
			case "D-National Card recovery Bulletin":
				WebElementUtils.checkCheckbox(regionVisaNationalCardRecovery, true);
				break;
			case "E-Europe":
				WebElementUtils.checkCheckbox(regionVisaEurope, true);
				break;
			case "F-Latin America and Caribbean(LAC)":
				WebElementUtils.checkCheckbox(regionVisaCarribbean, true);
				break;

			}
		}

	}

}
