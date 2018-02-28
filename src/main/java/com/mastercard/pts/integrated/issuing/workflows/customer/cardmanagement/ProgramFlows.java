
package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ProgramPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class ProgramFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	ProgramPage programpage;

	public void navigateProgramPage() {

		waitForElementVisible(menuSubMenuPage.getCardManagement());
		clickMenuSubOption(menuSubMenuPage.getProgramSetup(), menuSubMenuPage.getProgram());
	}

	public List<String> getListOfProgramCodes() {
		List<String> aProgramCodes = new ArrayList<String>();
		List<WebElement> actualProgramCodes = getList("//table[@class='dataview']//child::tr/td[2]/span");
		for (int i = 0; i < actualProgramCodes.size(); i++) {
			aProgramCodes.add(actualProgramCodes.get(i).getText());
		}

		return aProgramCodes;
	}

	public String createprogramPrepaid(DeviceCreation deviceCreation, Program program, String loyaltyPlan) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.clickAddProgram();
		String PROGRAM = programpage.addProgramGeneral(deviceCreation, program);
		programpage.addKYCLimits(program);
		programpage.selectLoadAndRefundParameters(program);
		programpage.clickNextButton();
		programpage.selectWalletPLan(program);
		programpage.selectDevicePlan(program);
		programpage.selectOtherPlans(loyaltyPlan);
		programpage.clickNextButton();
		programpage.clickNextButton();
		program.setProgram(PROGRAM);
		programpage.clickFinishButton();
		return PROGRAM;
	}

	public String createProgramPrepaidMultiCurrency(DeviceCreation deviceCreation, Program program) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.clickAddProgram();
		String PROGRAM = programpage.addProgramGeneralMultiCurrency(deviceCreation, program);
		programpage.addKYCLimits(program);
		programpage.selectLoadAndRefundParameters(program);
		programpage.clickNextButton();
		programpage.selectWalletPLan(program);
		programpage.selectDevicePlan(program);
		programpage.selectOtherPlans1();
		programpage.clickNextButton();
		programpage.clickNextButton();
		program.setProgram(PROGRAM);
		programpage.clickFinishButton();
		return PROGRAM;
	}

	public String createProgramDebit(DeviceCreation deviceCreation, Program program) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.clickAddProgram();
		String PROGRAM = programpage.addProgramGeneral(deviceCreation, program);
		programpage.addKYCLimits(program);
		programpage.selectLoadAndRefundParameters(program);
		programpage.clickNextButton();
		programpage.selectWalletPLan(program);
		programpage.selectDevicePlan(program);
		programpage.clickNextButton();
		programpage.clickNextButton();
		program.setProgram(PROGRAM);
		programpage.clickFinishButton();
		return PROGRAM;
	}

	public String createprogramCredit(DeviceCreation deviceCreation, Program program) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.clickAddProgram();
		String PROGRAM = programpage.addProgramGeneral(deviceCreation, program);
		programpage.clickNextButton();
		programpage.selectWalletPLan(program);
		programpage.selectDevicePlan(program);
		programpage.selectOtherPlans1();
		programpage.clickNextButton();
		programpage.fillDataForCreditCard(program);
		programpage.clickNextButton();
		program.setProgram(PROGRAM);
		programpage.clickFinishButton();
		return PROGRAM;
	}

	public void VerifyProgramSuccess() {
		programpage.verifyNewProgramSuccess();
	}

	public void editProgram(String prog) {
		ProgramPage programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.editProgram(prog);
	}

	public void programEdit(String a) {
		ProgramPage programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.enterProgramValue(a);
	}

	public void checkAdaptiveAuthenticationEnabled(String prog) {
		ProgramPage programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.editProgram(prog);
		Assert.assertTrue("Adaptive Authentication Check Box is enabled", programpage.adaptiveAuthenticationChkBox());
	}

	public void checkAdaptiveAuthenticationDisabled(String prog) {
		ProgramPage programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.editProgram(prog);
		Assert.assertFalse("Adaptive Authentication Check Box is disabled", programpage.adaptiveAuthenticationChkBox());
	}
}
