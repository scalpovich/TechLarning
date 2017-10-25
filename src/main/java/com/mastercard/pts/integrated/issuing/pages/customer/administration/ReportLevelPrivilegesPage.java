package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.LoginFlows;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP, AdministrationNav.L2_PRIVILEGES,
		AdministrationNav.L3_REPORT_LEVEL })
public class ReportLevelPrivilegesPage extends AbstractBaseFlows {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Navigator navigator;

	@Autowired
	private LoginFlows loginFlows;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement entityTypeDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public static final String PRIVILEGES_CHECKBOX_REPORT = "// div[@style='display: block;']//tr/td/input";
	public static final String ENTITY_TYPE_USER = "User [U]";
	public static final String ENTITY_TYPE_ROLE = "Role [R]";
	public static final By ENTITY_ID = By
			.name("searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent");
	public static final String PRIVILEGES_TABS = "//a[contains(text(),'%s')]";
	public static final String LIST_TAB_NAMES = "//ul[@class='tabs']/li/a";

	public void assignReportLevelPrivileges(String entityType) {
		List<String> previligesTabsNameList;
		navigator.navigateToPage(ReportLevelPrivilegesPage.class);
		searchEntity(entityType);
		previligesTabsNameList = getNamesPriviligesTabs();
		selectReportLevelPriviligesCheckBoxes();
		for (int i = 1; i < previligesTabsNameList.size(); i++) {
			selectTab(previligesTabsNameList.get(i));
			CustomUtils.ThreadDotSleep(500);
			selectReportLevelPriviligesCheckBoxes();
			CustomUtils.ThreadDotSleep(200);
		}
		ClickButton(saveBtn);
	}

	public void selectReportLevelPriviligesCheckBoxes() {
		Element(PRIVILEGES_CHECKBOX_REPORT).click();
	}

	public void searchEntity(String entityType) {
		if ("user".equalsIgnoreCase(entityType))
			selectByVisibleText(entityTypeDdwn, ENTITY_TYPE_USER);
		else if ("role".equalsIgnoreCase(entityType))
			selectByVisibleText(entityTypeDdwn, ENTITY_TYPE_ROLE);
		CustomUtils.ThreadDotSleep(500);
		Select select = new Select(getFinder().getWebDriver().findElement(
				ENTITY_ID));
		select.selectByVisibleText(MapUtils
				.fnGetInputDataFromMap("UserIDCreated"));
		ClickButton(searchBtn);
	}

	public void selectTab(String tabName) {
		getFinder().getWebDriver()
				.findElement(By.xpath(String.format(PRIVILEGES_TABS, tabName)))
				.click();
	}

	public List<String> getNamesPriviligesTabs() {
		List<WebElement> previligesTabsList = getList(LIST_TAB_NAMES);
		List<String> previligesTabsNameList = new ArrayList<String>();
		for (WebElement element : previligesTabsList)
			previligesTabsNameList.add(element.getText());
		return previligesTabsNameList;
	}

}
