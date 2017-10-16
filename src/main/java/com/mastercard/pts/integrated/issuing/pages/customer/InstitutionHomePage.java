package com.mastercard.pts.integrated.issuing.pages.customer;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class InstitutionHomePage extends AbstractPage {
	
	@PageElement(findBy = FindBy.ID, valueToFind = "institution")
	private MCWebElement selectedInstitutionElement;

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.visibilityOf(selectedInstitutionElement));
	}

	public String getSelectedInstitution() {
		return selectedInstitutionElement.getText();
	}
}
