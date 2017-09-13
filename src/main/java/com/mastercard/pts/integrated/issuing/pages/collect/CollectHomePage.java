package com.mastercard.pts.integrated.issuing.pages.collect;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CollectHomeNav.TAB_HOME)
public class CollectHomePage extends AbstractCollectPage {
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "a[title=Home]")
	private MCWebElement homeTab;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "a[title='Business Setup']")
	private MCWebElement businessSetupTab;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "a[title=Activity]")
	private MCWebElement activityTab;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "a[title=Administration]")
	private MCWebElement administrationTab;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "a[title=Report]")
	private MCWebElement reportTab;
	
	@Override
	public void verifyUiOperationStatus() {
		verifyUiOperationStatus("Home");
	}

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(homeTab),
				WebElementUtils.visibilityOf(businessSetupTab),
				WebElementUtils.visibilityOf(activityTab),
				WebElementUtils.visibilityOf(administrationTab),
				WebElementUtils.visibilityOf(reportTab));
	}
}
