package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class ApproveorRejectPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:inputCodeField")
	private MCWebElement searchFirstName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement Search;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "/html/body/div[2]/div[4]/div[2]/div[2]/span/div[3]/table/tbody/tr/td[8]/span/a/img")
	private MCWebElement Edit;

	@PageElement(findBy = FindBy.NAME, valueToFind = "approve")
	private MCWebElement Approve;

	public void approveorrejectapplication() {

		searchFirstName.sendKeys("applicationfirstname");
		Search.click();
		CustomUtils.ThreadDotSleep(1000);

		Edit.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");

		Approve.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
