package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MarketingMessagePlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1PROGRAM_SETUP,
		CardManagementNav.L2MARKETING_MESSAGE_PLAN })
public class MarketingMessagePlanPage extends AbstractBasePage {
	final Logger logger = LoggerFactory.getLogger(MarketingMessagePlanPage.class);

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@Autowired
	DatePicker date;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addMarketingMessagePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mktMsgPlanCode:input:inputTextField")
	private MCWebElement MarketingMessagePlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "mktMsgDescription:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement ProductType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save2;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addSubDetails;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/img")
	private MCWebElement EffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[contains(text(), 'Next Month (')]")
	private MCWebElement EffectiveDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[4]//a[contains(text(), 'Next Month')]")
	private MCWebElement EndDateNxtMonth;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[2]/span/span/span/span/table/tbody/tr[5]/td[4]/a")
	private MCWebElement selectEffectiveDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/img")
	private MCWebElement EndDate;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div/div/form/table[1]/tbody/tr[3]/td[4]/span/span/span/span/table/tbody/tr[5]/td[4]/a")
	private MCWebElement selectEndDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgLabel:input:inputTextField")
	private MCWebElement MessageLabel;

	@PageElement(findBy = FindBy.NAME, valueToFind = "msgText:input:textAreaComponent")
	private MCWebElement Message;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement savefinal;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement CancelBtn;

	public String Calelement = "//td[@id = 'endDate']";

	public void clickAddMarketingMessagePlan() {
		clickWhenClickable(addMarketingMessagePlan);
		switchToAddMarketingMessagePlanFrame();
	}

	public void switchToAddMarketingMessagePlanFrame() {
		waitForLoaderToDisappear();
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_PLAN_FRAME);
	}

	public String enterMarketingMessagePlanCode() {
		enterValueinTextBox(MarketingMessagePlanCode, CustomUtils.randomNumbers(5));
		return MarketingMessagePlanCode.getAttribute("value");
	}

	public String enterMarketingMessagePlanDescription() {
		enterValueinTextBox(Description, Constants.MARKETING_PLAN);
		return Description.getAttribute("value");
	}

	public void selectProduct(DeviceCreation deviceCreation) {
		selectByVisibleText(ProductType, deviceCreation.getProduct());
	}

	public String addmarketingMessagePlanDetails(DeviceCreation deviceCreation) {
		String marketingmsgcode;
		String marketingmsgdesc;
		marketingmsgcode = enterMarketingMessagePlanCode();
		marketingmsgdesc = enterMarketingMessagePlanDescription();
		selectProduct(deviceCreation);
		return marketingmsgdesc + " " + "[" + marketingmsgcode + "]";
	}

	public void clickSaveButton() {
		clickWhenClickable(save);
		SwitchToDefaultFrame();
	}

	public boolean verifyErrorsOnMarketingMessagePage() {
		return publishErrorOnPage();
	}

	public void verifyNewVendorSuccess() {
		if (!verifyErrorsOnMarketingMessagePage()) {
			logger.info("Vendor Added Successfully");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in Vendor Addition");
			clickWhenClickable(CancelBtn);
			SwitchToDefaultFrame();
		}
	}

	public void clickAddMarketingMessageDetails() {
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_PLAN_FRAME);
		clickWhenClickable(addSubDetails);
	}

	public void switchToAddMarketingMessageDetailsFrame() {
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_MARKETING_MESSAGE_DETAILS_FRAME);
	}

	public void selectEffectiveDate(MarketingMessagePlan marketingmsg) {
		date.setDate(marketingmsg.getMarketingMsgEffectiveDate());
	}

	public void selectEndDate(MarketingMessagePlan marketingmsg) {
		date.setDateCalendar2(marketingmsg.getMarketingMsgEndDate(), Calelement);
	}

	public void enterMarketingMessagePlanDetailsLabel() {
		enterValueinTextBox(MessageLabel, Constants.MARKETING_PLAN);
	}

	public void enterMarketingMessagePlanDetailsDescription() {
		enterValueinTextBox(Message, Constants.MARKETING_PLAN);
	}

	public void addmarketingMessagedetails(MarketingMessagePlan marketingmsg) {
		switchToAddMarketingMessageDetailsFrame();
		selectEffectiveDate(marketingmsg);
		selectEndDate(marketingmsg);
		enterMarketingMessagePlanDetailsLabel();
		enterMarketingMessagePlanDetailsDescription();
		clickSaveButton();
		SwitchToDefaultFrame();
		switchToAddMarketingMessagePlanFrame();
		Scrolldown(save);
		waitForElementVisible(save);
		ClickButton(save);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return null;
	}

}
