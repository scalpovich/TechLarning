package com.mastercard.pts.integrated.issuing.pages.customer;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class QuickJumpPage extends AbstractBasePage {

	final Logger logger = LoggerFactory.getLogger(QuickJumpPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "font[class='breadactive']")
	private MCWebElement pageNameLbl;

	@PageElement(findBy = FindBy.ID, valueToFind = "txtgoto")
	private MCWebElement quickJumpTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "img[src*='btn-qj.png']")
	private MCWebElement searchBtn;
	
	public void quickJump(String pageCode) {
		WebElementUtils.enterText(quickJumpTxt, pageCode);
		searchBtn.click();
		Assert.assertFalse("Page does not exist!", isAlertPresent());		
	}

	public String getPageName() {
		return pageNameLbl.getText();
	}

	public boolean isAlertPresent() {
		try {
			Alert alert = driver().switchTo().alert();
			if (alert != null) {
				alert.accept();
				return true;
			}
		} catch (NoAlertPresentException e) {
			return false;
		}
		return false;
	}

}
