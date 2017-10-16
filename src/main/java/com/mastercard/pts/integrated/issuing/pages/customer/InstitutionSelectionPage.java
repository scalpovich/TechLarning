package com.mastercard.pts.integrated.issuing.pages.customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

/**
 * @author Vitaliy Liubezny
 *
 */
@Component
public class InstitutionSelectionPage extends AbstractPage {
	
	private static final String OPTION_SELECT_ONE = "Select One";
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=institutionCode]")
	private MCWebElement institutionSelect;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[value=Confirm]")
	private MCWebElement confirmButton;

	@Override
	protected List<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.visibilityOf(institutionSelect),
				WebElementUtils.elementToBeClickable(confirmButton));
	}

	public List<String> getAvailableInstitutions() {
		return institutionSelect.getSelect().getOptions().stream()
				.map(WebElement::getText).filter(text -> !text.equals(OPTION_SELECT_ONE))
				.collect(Collectors.toList());
	}
	
	public String getSelectedInstitution() {
		return institutionSelect.getSelect().getFirstSelectedOption().getText();
	}
	
	
	/**
	 * @param institutionSelector, e.g. "CANARA [110000]"
	 */
	public void selectInstitution(String institutionSelector) {
		institutionSelect.getSelect().selectByVisibleText(institutionSelector);
	}

	public void clickConfirm() {
		confirmButton.click();
	}
}
