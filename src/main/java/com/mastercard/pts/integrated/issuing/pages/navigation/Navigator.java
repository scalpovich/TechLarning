package com.mastercard.pts.integrated.issuing.pages.navigation;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.common.base.Preconditions;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.PageObjectFactory;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementFinderProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;

@Component
public final class Navigator extends AbstractBasePage {
	
	private final Logger logger = LoggerFactory.getLogger(Navigator.class);
	
	@Autowired
	private PageObjectFactory pageObjFactory;

	@Autowired
	private WebDriverProvider driverProvider;

	@Autowired
	private ElementFinderProvider finderProvider;
	
	@Value("${default.wait.timeout_in_sec}")
	private long waitTimeout;

	/**
	 * Method navigate to page by page object's class, using  @Navigation annotation
	 * 
	 * E.g. Page Object should have following annotation
	 * @Navigation (tabTitle = AdministrationNav.TAB_TITLE , menuItemsTree
	 *             ={AdministrationNav.Setup, AdministrationNav._Role})
	 * 
	 * @param pageObjectClass
	 * @return
	 */
	public <T extends AbstractPage> T navigateToPage(Class<T> pageObjectClass) {
		
		Navigation nav = pageObjectClass.getAnnotation(Navigation.class);
		Preconditions.checkArgument(nav != null,
				"Please specify @Navigation for class: %s",
				pageObjectClass.getName());

		if (nav.treeMenuItems().length == 0) {
			navigateToTab(nav.tabTitle());
		} else {
			navigateToPath(nav.tabTitle(), nav.treeMenuItems());
		}

		T page = pageObjFactory.getPage(pageObjectClass);
		page.waitUntilIsLoaded();

		return page;
	}

	/**
	 * Method navigate to page by page name
	 * 
	 * E.g. Page Object should have following annotation
	 * @Navigation (tabTitle = AdministrationNav.TAB_TITLE , menuItemsTree
	 *             ={AdministrationNav.Setup, AdministrationNav._Role})
	 * 
	 * @param pageObjectClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends AbstractPage> T navigateToPage(String pageName) {
		return navigateToPage((Class<T>) pageObjFactory.getPage(pageName).getClass());
	}
	
	/**
	 * Method navigates to page by page object's annotation and checks if page is
	 * available 
	 * E.g. Page Object should have following annotation
	 * 
	 * @Navigation (tabTitle = AdministrationNav.TAB_TITLE , menuItemsTree
	 *             ={AdministrationNav.Setup, AdministrationNav._Role})
	 * @param pageObjectClass
	 * @return
	 */
	public <T extends AbstractPage> boolean isPageAvailable(Class<T> pageObjectClass) {
		boolean isPathAvailable = true;
		
		T page = null;
		try {
			page = navigateToPage(pageObjectClass);
		} catch (TimeoutException e) {
			isPathAvailable = false;
			logger.debug("Page {} is not available: {}", pageObjectClass.getName(), e);
		}

		return isPathAvailable && page.isLoaded();
	}
	
	/**
	 * Method navigates to page by page name and checks if page is
	 * available 
	 * E.g. Page Object should have following annotation
	 * 
	 * @Navigation (tabTitle = AdministrationNav.TAB_TITLE , menuItemsTree
	 *             ={AdministrationNav.Setup, AdministrationNav._Role})
	 * @param pageObjectClass
	 * @return
	 */
	public boolean isPageAvailable(String pageName) {	
		return isPageAvailable(pageObjFactory.getPage(pageName).getClass());
	}

	/**
	 * Method click on tab, then click on a menu item, next menu item is taking
	 * as nested menu item.
	 * 
	 * @param tabTitle  - tab title
	 * @param menuItemsTree - it is array of menuIDs
	 */
	public void navigateToPath(String tabTitle, String... menuItemsTree) {
		navigateToTab(tabTitle);
		navigateToTreeLeaf(menuItemsTree);
	}

	/**
	 * Navigate to a tab
	 * 
	 * @param tabName
	 */
	public void navigateToTab(String tabTitle) {
		logger.info("Navigate to {} tab", tabTitle);
		clickElement(By.xpath(String.format("//a[contains(.,'%s')]", tabTitle)));
	}

	/**
	 * Method clicks on each menu items, w/o clicking on tab
	 * 
	 * @param treeMenuItems
	 *            - menu item's tree
	 */
	public void navigateToTreeLeaf(String... treeMenuItems) {
		String navPath = String.join(" > ", treeMenuItems);
		logger.info("Navigate to menu items {}", navPath);

		for (int i = 0; i < treeMenuItems.length; i++) {
			if (i < treeMenuItems.length - 1) {
				clickNode(treeMenuItems[i]);
			} else {
				clickLeaf(treeMenuItems[i]);
			}
		}
	}

	private void clickNode(String treeMenuItem) {
		MCWebElement node = WebElementUtils.fluentWait(() -> finderProvider.get()
				.findOne(FindBy.ID, treeMenuItem));
		if (!WebElementUtils.hasClass(node, "p1-active") &&
				!WebElementUtils.hasClass(node, "p2-active")) {
			clickElement(By.id(treeMenuItem));
		}
	}

	private void clickLeaf(String treeMenuItem) {
		By locator = By.cssSelector(String.format("#%s a", treeMenuItem));
		fluentWait(() -> driverProvider.get().findElement(locator));
		clickElement(locator);
	}

	/**
	 * Methods walks through navigation (starts from tab) and check if menu
	 * items is available
	 * 
	 * @param tabTitle
	 * @param treeMenuItems
	 * @return boolean
	 */
	public boolean isNavigationPathAvailable(String tabTitle, String... treeMenuItems) {
		return isNavigationPathAvailable(tabTitle) && isNavigationPathAvailable(treeMenuItems);
	}

	/**
	 * Methods walks through navigation (w/o clicking on tab) and check if menu
	 * items is available
	 * 
	 * @param treeMenuItems
	 * @return boolean
	 */
	public boolean isNavigationPathAvailable(String... treeMenuItems) {
		try {
			navigateToTreeLeaf(treeMenuItems);
		} catch (TimeoutException e) {
			logger.debug("Tree navigation path {} is not available: {}",
					String.join(" > ", treeMenuItems), e);
			return false;
		}
        return true;  
	}

	/**
	 * Method checks if the tab is available
	 * 
	 * @param tabTitle  
	 * @return boolean
	 */
	public boolean isNavigationPathAvailable(String tabTitle) {
		try {
			navigateToTab(tabTitle);
		} catch (TimeoutException e) {
			logger.debug("Tab navigation {} is not available: {}", tabTitle, e);
			return false;
		}
        return true;       
	}
	
	private void clickElement(By locator) {
        WebElementUtils.scrollToElement(driver(), finderProvider.get().getWebDriver().findElement(locator));
        WebElementUtils.retryUntilNoErrors(() -> finderProvider.get().getWebDriver().findElement(locator).click());
 }


}