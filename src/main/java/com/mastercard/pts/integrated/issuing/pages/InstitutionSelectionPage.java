package com.mastercard.pts.integrated.issuing.pages;

import java.util.Arrays;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionSelection;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class InstitutionSelectionPage extends InstitutionSelection {

	// ------------- Processing Center > Setup > Master Parameters > Institution
	// [CESM01]

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
			selectByVisibleText(institution, IntitutionDataProvider()
					.getInstiution());
		} else {
			selectByVisibleText(institution, Arrays.toString(optionName));
		}
		confirmButton.click();
	}

	public void selectAdminInstitution(String... optionName) {
		if (optionName.length == 0) {
			selectByVisibleText(institution, IntitutionDataProvider()
					.getAdminInstiutionName());
		} else {
			selectByVisibleText(institution, Arrays.toString(optionName));
		}
		confirmButton.click();
	}
	
	public void selectBankAdminInstitution(String... optionName) {
		if (optionName.length == 0) {
			selectByVisibleText(institution, IntitutionDataProvider()
					.getBankInstitution());
		} else {
			selectByVisibleText(institution, Arrays.toString(optionName));
		}
		confirmButton.click();
	}

}
