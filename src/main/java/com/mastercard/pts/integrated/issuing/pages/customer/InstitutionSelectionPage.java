package com.mastercard.pts.integrated.issuing.pages.customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionSelection;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
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
public class InstitutionSelectionPage extends AbstractBasePage {
	
	private static final String OPTION_SELECT_ONE = "Select One";
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=institutionCode]")
	private MCWebElement institutionSelect;
	
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "institutionCode:input:dropdowncomponent")
	private MCWebElement institution;

	@PageElement(findBy = FindBy.NAME, valueToFind = "confirm")
	private MCWebElement confirmButton;

	public MCWebElement getInstitution() {
		return institution;
	}

	public MCWebElement getConfirmButton() {
		return confirmButton;
	}

	public void selectInstitution(String instName) {

		waitForElementVisible(institution);
		institution.getSelect().selectByVisibleText(instName);
		confirmButton.click();
	}

	public void selectInstitution(String... optionName) {
		if (optionName.length == 0) {
			selectByVisibleText(institution, InstitutionSelection.IntitutionDataProvider()
					.getInstiution());
		} else {
			selectByVisibleText(institution, Arrays.toString(optionName));
		}
		confirmButton.click();
	}

	public void selectAdminInstitution(String... optionName) {
		if (optionName.length == 0) {
			selectByVisibleText(institution, InstitutionSelection.IntitutionDataProvider()
					.getAdminInstiutionName());
		} else {
			selectByVisibleText(institution, Arrays.toString(optionName));
		}
		confirmButton.click();
	}
	
	public void selectBankAdminInstitution(String... optionName) {
		if (optionName.length == 0) {
			selectByVisibleText(institution, InstitutionSelection.IntitutionDataProvider()
					.getBankInstitution());
		} else {
			selectByVisibleText(institution, Arrays.toString(optionName));
		}
		confirmButton.click();
	}


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
	
	
	public void clickConfirm() {
		confirmButton.click();
	}
}
