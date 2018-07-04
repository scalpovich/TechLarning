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

	public boolean addStopListReasonInStopListPage(StopListReasonPlan stopListReasonPlan, String stopListReason) {

		if (verifyReasonAlreadyExistsOrNotInStopList(stopListReason) == false) {
			clickAddNewButton();
			runWithinPopup("Add Stoplist Reason", () -> {
				switch (stopListReason) {
				case "Lost":
					addLostPlanInStopList(stopListReasonPlan);
					break;
				case "Stolen":
					addStolenPlanInStopList(stopListReasonPlan);
					break;
				case "Counterfeit":
					addCounterfeitPlanInStopList(stopListReasonPlan);
					break;
				case "Returned":
					addReturnedPlanInStopList(stopListReasonPlan);
					break;
				case "Expired":
					addExpiredPlanInStopList(stopListReasonPlan);
					break;
				case "Damaged Card":
					addDamagedCardPlanInStopList(stopListReasonPlan);
					break;
				case "Emergency Replacement":
					addEmergencyReplacementPlanInStopList(stopListReasonPlan);
					break;
				case "Erroneous Card":
					addErroneousCardPlanInStopList(stopListReasonPlan);
					break;
				}
				SimulatorUtilities.wait(1000);
			});
		}
		return verifyReasonAlreadyExistsOrNotInStopList(stopListReason);
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

	private void addLostPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeLost());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionLost());
		if (stopListReasonPlan.getStickyLost().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterLost().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaLost().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayLost().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayLost().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexLost().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexLost().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardLost() != null || stopListReasonPlan.getRegionVisaLost() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardLost().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaLost().split(","));
		}
		clickSaveButton();

	}

	private void addStolenPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeStolen());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionStolen());
		if (stopListReasonPlan.getStickyStolen().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterStolen().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaStolen().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayStolen().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayStolen().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexStolen().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexStolen().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardStolen() != null
				|| stopListReasonPlan.getRegionVisaStolen() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardStolen().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaStolen().split(","));
		}
		clickSaveButton();

	}

	private void addCounterfeitPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeCounterfeit());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionCounterfeit());
		if (stopListReasonPlan.getStickyCounterfeit().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterCounterfeit().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaCounterfeit().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayCounterfeit().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayCounterfeit().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexCounterfeit().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexCounterfeit().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardCounterfeit() != null
				|| stopListReasonPlan.getRegionVisaCounterfeit() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardCounterfeit().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaCounterfeit().split(","));
		}
		clickSaveButton();

	}

	private void addReturnedPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeReturned());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionReturned());
		if (stopListReasonPlan.getStickyReturned().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterReturned().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaReturned().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayReturned().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayReturned().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexReturned().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexReturned().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardReturned() != null
				|| stopListReasonPlan.getRegionVisaReturned() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardReturned().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaReturned().split(","));
		}
		clickSaveButton();

	}

	private void addExpiredPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeExpired());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionExpired());
		if (stopListReasonPlan.getStickyExpired().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterExpired().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaExpired().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayExpired().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayExpired().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexExpired().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexExpired().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardExpired() != null
				|| stopListReasonPlan.getRegionVisaExpired() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardExpired().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaExpired().split(","));
		}
		clickSaveButton();

	}

	private void addDamagedCardPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeDamaged());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionDamaged());
		if (stopListReasonPlan.getStickyDamaged().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterDamaged().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaDamaged().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayDamaged().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayDamaged().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexDamaged().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexDamaged().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardDamaged() != null
				|| stopListReasonPlan.getRegionVisaDamaged() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardDamaged().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaDamaged().split(","));
		}
		clickSaveButton();

	}

	private void addEmergencyReplacementPlanInStopList(StopListReasonPlan stopListReasonPlan) {

		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeEmergency());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionEmergency());
		if (stopListReasonPlan.getStickyEmergency().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterEmergency().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaEmergency().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayEmergency().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayEmergency().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexEmergency().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexEmergency().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardEmergency() != null
				|| stopListReasonPlan.getRegionVisaEmergency() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardEmergency().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaEmergency().split(","));
		}
		clickSaveButton();
	}

	private void addErroneousCardPlanInStopList(StopListReasonPlan stopListReasonPlan) {
		WebElementUtils.selectDropDownByVisibleText(reasonCodeInPopUp, stopListReasonPlan.getReasonCodeErroneous());
		WebElementUtils.enterText(descriptionInPopUp, stopListReasonPlan.getDescriptionErroneous());
		if (stopListReasonPlan.getStickyErroneous().equals("Yes"))
			WebElementUtils.selectRadioBtn(stickyRadioButton);
		if (stopListReasonPlan.getSentToMasterErroneous().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToMasterOnline);
		if (stopListReasonPlan.getSentToVisaErroneous().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToVisaOnline);
		if (stopListReasonPlan.getSentToRupayErroneous().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToRupayOnline);
		if (stopListReasonPlan.getSentToRupayErroneous().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToRupayBatch);
		if (stopListReasonPlan.getSentToAmexErroneous().equals("Online"))
			WebElementUtils.selectRadioBtn(sentToAmexOnline);
		if (stopListReasonPlan.getSentToAmexErroneous().equals("Batch Mode"))
			WebElementUtils.selectRadioBtn(sentToAmexBatch);
		if (stopListReasonPlan.getRegionMastercardErroneous() != null
				|| stopListReasonPlan.getRegionVisaErroneous() != null) {
			selectRegions(stopListReasonPlan.getRegionMastercardErroneous().split(","));
			selectRegions(stopListReasonPlan.getRegionVisaErroneous().split(","));
		}
		clickSaveButton();

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
