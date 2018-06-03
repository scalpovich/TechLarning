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
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.LoginFlows;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP, AdministrationNav.L2_PRIVILEGES,
		AdministrationNav.L3_SCREEN_LEVEL })
public class ScreenLevelPrivilegesPage extends AbstractBaseFlows {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Navigator navigator;

	@Autowired
	LoginFlows loginFlows;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	public static final String PRIVILEGES_CHECKBOX = "//div[@style='display: block;']//tr[position()=3]/td[position()>1]/input";
	public static final String LIST_TAB_NAMES = "//ul[@class='tabs']/li/a";

	public void assignScreenLevelPrivileges(String entityType) {
		List<String> privilegesTabsNameList;
		navigator.navigateToPage(ScreenLevelPrivilegesPage.class);
		searchEntity(entityType);
		SimulatorUtilities.wait(1000);
		privilegesTabsNameList = getNamesPrivilegesTabs();
		selectPrevilegesCheckBoxes();
		for (int i = 1; i < privilegesTabsNameList.size(); i++) {
			selectTab(privilegesTabsNameList.get(i));
			SimulatorUtilities.wait(500);
			selectPrevilegesCheckBoxes();
			SimulatorUtilities.wait(200);
		}
		ClickButton(saveBtn);
	}

	public void selectPrevilegesCheckBoxes() {
		List<WebElement> listOfWebElements = getList(PRIVILEGES_CHECKBOX);
		CustomUtils.ThreadDotSleep(200);
		int count = 0;
		while (count <= 3) {
			for (int i = listOfWebElements.size() - 1; i >= 0; i--) {
				WebElement element = listOfWebElements.get(i);
				if (element.isEnabled()) {
					element.click();
					count++;
					CustomUtils.ThreadDotSleep(200);
				}
			}
		}
	}

	public List<String> getNamesPrivilegesTabs() {
		List<WebElement> privilegesTabsList = getList(LIST_TAB_NAMES);
		List<String> privilegesTabsNameList = new ArrayList<String>();
		for (WebElement element : privilegesTabsList) {
			SimulatorUtilities.wait(500);
			privilegesTabsNameList.add(element.getText());
		}
		return privilegesTabsNameList;
	}
}
