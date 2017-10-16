package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchLevelPriviledge;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_ADMINISTRATION_SETUP,
		AdministrationNav.L2_ADMINISTRATION_PREVILEDGE,
		AdministrationNav.L3_ADMINISTRATION_BACTH_LEVEL })
public class BatchLevelPreviledgePage extends BatchLevelPriviledge {

	public String optionLocator = "//span[.='%s']/../../..//input";
	public String accessCheckBox = "//div[@id='tab%i']//label[.='Access']/preceding-sibling::input";

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'componentList:0')]")
	private MCWebElement entityType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//select[contains(@name,'componentList:1')]")
	private MCWebElement entityID;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Search']")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//ul[@class='tabs']//li")
	private MCWebElements batchScreenTabs;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Upload']")
	private MCWebElement batchUploadTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='Download']")
	private MCWebElement batchDownloadTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[.='System Internal']")
	private MCWebElement batchSystemInternalTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//label[.='Access']/preceding-sibling::input")
	private MCWebElement accessOnTab;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@name='Save']")
	private MCWebElement saveBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@class='feedbackPanelINFO']")
	private MCWebElement feedBackPanel;
	
	

	public WebElement BatchTypeAccessWithName(String OptionName) {
		return getFinder().getWebDriver().findElement(
				By.xpath(optionLocator.replace("%s", OptionName)));
	}

	public WebElement accessOnTab(String tabNumber) {
		return getFinder().getWebDriver().findElement(
				By.xpath(accessCheckBox.replace("%i", tabNumber)));
	}

	public void selectEntityType(String... optionName) {
		if (optionName.length != 0) {
			selectByVisibleText(entityType, optionName[0]);
		} else {
			selectByVisibleText(entityType, getEntityType());
		}
	}

	public void selectEntityID(String... optionName) {
		if (optionName.length != 0) {
			selectByVisibleText(entityID, optionName[0]);
		} else {
			selectByVisibleText(entityID, getEntityId());
		}
	}

	public void clickSearchBtn() {
		clickWhenClickable(searchBtn);
	}

	public void clickBatchScreenTabs(MCWebElement ele) {
		clickWhenClickable(ele);
	}

	public void clickBatchUploadTabs() {
		clickBatchScreenTabs(batchUploadTab);
	}

	public void clickBatchDownloadTab() {
		clickBatchScreenTabs(batchDownloadTab);
	}

	public void clickBatchSystemInternalTabs() {
		clickBatchScreenTabs(batchSystemInternalTab);
	}

	public void supplyAccessToAllBatches() {
		int tabSize = batchScreenTabs.getElements().size();
		for (int i = 0; i < tabSize; i++) {
			clickBatchScreenTabs(batchScreenTabs.getElements().get(i));
			accessOnTab(String.valueOf(i + 1)).click();
		}
		clickWhenClickable(saveBtn);		
		Assert.assertTrue(feedBackPanel.getFluent().getWebElement().getCssValue("color").equals(Constants.SUCCESS_MESSAGE));
	}

	public void supplyAccessToUploadBatches() {
		clickBatchUploadTabs();
		accessOnTab(String.valueOf(1)).click();
		clickWhenClickable(saveBtn);
	}

	public void supplyAccessToDownloadBatches() {
		clickBatchDownloadTab();
		accessOnTab(String.valueOf(2)).click();
		clickWhenClickable(saveBtn);
	}

	public void supplyAccessToSystemInternalBatches() {
		clickBatchSystemInternalTabs();
		accessOnTab(String.valueOf(3)).click();
		clickWhenClickable(saveBtn);
	}

}
