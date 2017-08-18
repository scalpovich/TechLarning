package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessageDetails;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_MARKETING_MESSAGE_PLAN })
public class MarketingMessagePlanPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory
			.getLogger(MarketingMessagePlanPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mktMsgPlanCode]")
	private MCWebElement planCodeSearchTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mktMsgPlanCode]")
	private MCWebElement planCodeTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn=mktMsgDescription]")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=productType]")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='effectiveDate']/..")
	private MCWebElement effectiveDateDPkr;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='endDate']/..")
	private MCWebElement endDateDPkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgLabel:input:inputTextField")
	private MCWebElement messageLabelTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgText:input:textAreaComponent")
	private MCWebElement messageTxt;

	public void verifyUiOperationStatus() {
		logger.info("Marketing Message Plan");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(planCodeSearchTxt));
	}

	public void createMarketingMessagePlan(
			MarketingMessagePlan marketingMessagePlan) {
		logger.info("Create Marketing Message Plan: {}",
				marketingMessagePlan.getMarketingMessagePlanCode());
		clickAddNewButton();

		runWithinPopup(
				"Add Marketing Message Plan",
				() -> {
					WebElementUtils.enterText(planCodeTxt,
							marketingMessagePlan.getMarketingMessagePlanCode());
					WebElementUtils.enterText(descriptionTxt,
							marketingMessagePlan.getDescription());
					WebElementUtils.selectDropDownByVisibleText(
							productTypeDDwn,
							marketingMessagePlan.getProductType());
					clickAddDetailsButton();

					marketingMessagePlan.getMarketingMessageDetails().forEach(
							this::addDetails);

					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

	private void addDetails(MarketingMessageDetails details) {
		clickAddNewButton();

		runWithinPopup(
				"Add Marketing Message Details",
				() -> {
					WebElementUtils.pickDate(effectiveDateDPkr,
							details.getEffectiveDate());
					WebElementUtils.pickDate(endDateDPkr, details.getEndDate());
					WebElementUtils.enterText(messageLabelTxt,
							details.getMesssageLabel());
					WebElementUtils.enterText(messageTxt, details.getMessage());
					clickSaveButton();

					verifyNoErrors();
				});

		verifyOperationStatus();
	}

}
