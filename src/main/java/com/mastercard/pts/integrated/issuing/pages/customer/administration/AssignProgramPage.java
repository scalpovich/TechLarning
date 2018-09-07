package com.mastercard.pts.integrated.issuing.pages.customer.administration;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTRATION, treeMenuItems = {
		AdministrationNav.L1_SETUP,
		AdministrationNav.L2_HELPDESK_PRIVILEGES,
		AdministrationNav.L3_ASSIGN_PROGRAM
})
public class AssignProgramPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory
			.getLogger(AssignProgramPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement programDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "select[name^=planPalette]")
	private MCWebElement availableServiceCodeLstBx;

	@PageElement(findBy = FindBy.CSS, valueToFind = "button.add")
	private MCWebElement addServiceCodeBtn;

	public void addServiceCodeToProgram(Program program) {
		AtomicBoolean canceled = new AtomicBoolean(false);
		logger.info("Program Code {}", program.getProgramCodeDevice());
		clickAddNewButton();
		runWithinPopup(
				"Add SR Visibility at Program Level",
				() -> {
					WebElementUtils.selectDDByVisibleText(programDDwn, program.getProgramCodeDevice());
					WebElementUtils .selectAllOptionsInListBox(availableServiceCodeLstBx);
					addServiceCodeBtn.click();
					clickSaveButton();
					//canceled.set(verifyAlreadyExistsAndClickCancel());
				});
		if (!canceled.get()) {
			//verifyOperationStatus();
		}
	}
}
