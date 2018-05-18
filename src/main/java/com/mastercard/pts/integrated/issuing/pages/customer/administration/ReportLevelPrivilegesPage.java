package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.navigation.AdministrationNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public static final String PRIVILEGES_CHECKBOX_REPORT = "// div[@style='display: block;']//tr/td/input";
	public static final String LIST_TAB_NAMES = "//ul[@class='tabs']/li/a";

	public void assignReportLevelPrivileges(String entityType) {
		List<String> privilegesTabsNameList;
		navigator.navigateToPage(ReportLevelPrivilegesPage.class);
		searchEntity(entityType);
		privilegesTabsNameList = getNamesPrivilegesTabs();
		selectReportLevelPrivilegesCheckBoxes();
		for (int i = 1; i < privilegesTabsNameList.size(); i++) {
			selectTab(privilegesTabsNameList.get(i));
			CustomUtils.ThreadDotSleep(500);
			selectReportLevelPrivilegesCheckBoxes();
			CustomUtils.ThreadDotSleep(200);
		}
		ClickButton(saveBtn);
	}

	public void selectReportLevelPrivilegesCheckBoxes() {
		Element(PRIVILEGES_CHECKBOX_REPORT).click();
	}

	public List<String> getNamesPrivilegesTabs() {
		List<WebElement> privilegesTabsList = getList(LIST_TAB_NAMES);
		List<String> privilegesTabsNameList = new ArrayList<String>();
		for (WebElement element : privilegesTabsList)
			privilegesTabsNameList.add(element.getText());
		return privilegesTabsNameList;
	}

}
