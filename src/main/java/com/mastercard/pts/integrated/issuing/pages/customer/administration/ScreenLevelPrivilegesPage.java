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
		List<String> previligesTabsNameList;
		navigator.navigateToPage(ScreenLevelPrivilegesPage.class);
		searchEntity(entityType);
		CustomUtils.ThreadDotSleep(1000);
		previligesTabsNameList = getNamesPreviligesTabs();
		selectPreviligesCheckBoxes();
		for (int i = 1; i < previligesTabsNameList.size(); i++) {
			selectTab(previligesTabsNameList.get(i));
			CustomUtils.ThreadDotSleep(500);
			selectPreviligesCheckBoxes();
			CustomUtils.ThreadDotSleep(200);
		}
		ClickButton(saveBtn);
	}


	public void selectPreviligesCheckBoxes() {
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

	public List<String> getNamesPreviligesTabs() {
		List<WebElement> previligesTabsList = getList(LIST_TAB_NAMES);
		List<String> previligesTabsNameList = new ArrayList<String>();
		for (WebElement element : previligesTabsList) {
			CustomUtils.ThreadDotSleep(500);
			previligesTabsNameList.add(element.getText());
		}
		return previligesTabsNameList;
	}
}
