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
public class CloseBatchPage extends AbstractBasePage {

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div[4]/div[2]/div[2]/form[1]/div[2]/div[4]/table/tbody/tr/td[10]/span/input")
	private MCWebElement CloseBatchRecord;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement ProcessSelected;

	public void closebatch() {
		CloseBatchRecord.click();
		CustomUtils.ThreadDotSleep(1000);
		ProcessSelected.click();
		CustomUtils.ThreadDotSleep(1000);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
