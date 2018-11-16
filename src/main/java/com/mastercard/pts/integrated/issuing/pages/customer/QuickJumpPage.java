package com.mastercard.pts.integrated.issuing.pages.customer;

import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class QuickJumpPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(QuickJumpPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "font[class='breadactive']")
	private MCWebElement pageNameLbl;

	@PageElement(findBy = FindBy.ID, valueToFind = "txtgoto")
	private MCWebElement quickJumpTxt;

	public void quickJump(String pageCode) {
		WebElementUtils.enterText(quickJumpTxt, pageCode);
		WebElementUtils.asWebElement(quickJumpTxt).sendKeys(Keys.ENTER);
	}

	public String getPageName() {
		return pageNameLbl.getText();
	}

}
