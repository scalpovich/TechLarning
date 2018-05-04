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

	public List<String> getNamesPriviligesTabs() {
		List<WebElement> previligesTabsList = getList(LIST_TAB_NAMES);
		List<String> previligesTabsNameList = new ArrayList<String>();
		for (WebElement element : previligesTabsList)
			previligesTabsNameList.add(element.getText());
		return previligesTabsNameList;
	}

}
