package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class AbstractDisputePage extends AbstractModelPage{
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='networkCode']/span/select")
	protected MCWebElement interchangeDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='microfilmRefNumber']")
	protected MCWebElement arnTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#transactionDate")
	protected MCWebElement transactionDateDpkr;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='cardNumber']")
	protected MCWebElement deviceNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//td/span/a[1]")
	private MCWebElement firstRecordInDataTable;
	
	protected void searchByArn(String arn,String popupTitle)
	{
		WebElementUtils.enterText(arnTxt, arn);
		clickSearchButton();
		
		runWithinPopup(
				popupTitle,
				() -> {
					    firstRecordInDataTable.click();
						verifyNoErrors();
				});
	}
	

	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(interchangeDwn),
				WebElementUtils.elementToBeClickable(arnTxt)
				);
	}
}
