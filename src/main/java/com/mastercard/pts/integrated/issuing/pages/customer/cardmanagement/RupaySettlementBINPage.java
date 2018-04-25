package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.RuPaySettlementBIN;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_RUPAY_SETTLEMENT_BIN })
public class RupaySettlementBINPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(RupaySettlementBINPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement deviceBinSearch;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement rupayProductCodeSearch;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=settlementBin]")
	private MCWebElement settlementBinSearch;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=participantId]")
	private MCWebElement participantIdSearch;

	@PageElement(findBy = FindBy.NAME, valueToFind = "deviceBin:input:dropdowncomponent")
	private MCWebElement deviceBINDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rupayProductCode:input:dropdowncomponent")
	private MCWebElement ruPayProductCodeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "settlementBin:input:inputTextField")
	private MCWebElement txtSettlementBIN;

	@PageElement(findBy = FindBy.NAME, valueToFind = "participantId:input:inputTextField")
	private MCWebElement txtParticipantID;

	public void verifyUiOperationStatus() {
		logger.info("RuPay Settlement BIN");
		verifyUiOperation("Add RuPay Settlement BIN");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(deviceBinSearch),
				WebElementUtils.elementToBeClickable(rupayProductCodeSearch),
				WebElementUtils.elementToBeClickable(settlementBinSearch),
				WebElementUtils.elementToBeClickable(participantIdSearch));
	}

	public void selectDeviceBIN(String deviceBIN, Boolean isSearching) {
		if (isSearching)
			WebElementUtils.selectDropDownByVisibleText(deviceBinSearch,
					deviceBIN);
		else
			WebElementUtils.selectDropDownByVisibleText(deviceBINDdwn,
					deviceBIN);
	}

	public void selectRuPayProductCode(String ruPayProductCode,
			Boolean isSearching) {
		if (isSearching)
			WebElementUtils.selectDropDownByVisibleText(rupayProductCodeSearch,
					ruPayProductCode);
		else
			WebElementUtils.selectDropDownByVisibleText(ruPayProductCodeDdwn,
					ruPayProductCode);
	}

	public void enterSettlementBIN(String settlementBIN, Boolean isSearching) {
		if (isSearching)
			WebElementUtils.enterText(settlementBinSearch, settlementBIN);
		else
			WebElementUtils.enterText(txtSettlementBIN, settlementBIN);
	}

	public void enterParticipantID(String participantID, Boolean isSearching) {
		if (isSearching)
			WebElementUtils.enterText(participantIdSearch, participantID);
		else
			WebElementUtils.enterText(txtParticipantID, participantID);
	}

	public void addRuPaySettlementBIN(RuPaySettlementBIN ruPaySettlementBIN,
			DeviceBin devicebin) {
		clickAddNewButton();
		runWithinPopup(
				"Add RuPay Settlement BIN",
				() -> {
					selectDeviceBIN(devicebin.buildDescriptionAndCode(), false);
					selectRuPayProductCode(
							ruPaySettlementBIN.getRuPayProductCode(), false);
					enterSettlementBIN(ruPaySettlementBIN.getSettlementBIN(),
							false);
					enterParticipantID(ruPaySettlementBIN.getParticipantID(),
							false);
					clickSaveButton();
				});
	}

	public void searchRuPaySettlementBIN(RuPaySettlementBIN ruPaySettlementBIN) {
		selectDeviceBIN(ruPaySettlementBIN.getDeviceBIN(), true);
		selectRuPayProductCode(ruPaySettlementBIN.getRuPayProductCode(), true);
		enterSettlementBIN(ruPaySettlementBIN.getSettlementBIN(), true);
		enterParticipantID(ruPaySettlementBIN.getParticipantID(), true);
		clickSearchButton();
	}

	public void verifyRuPaySettlementBINAdded(
			RuPaySettlementBIN ruPaySettlementBIN) {
		Assert.assertEquals(Constants.Record_Added_Successfully,
				getSuccessMessage());
	}
}