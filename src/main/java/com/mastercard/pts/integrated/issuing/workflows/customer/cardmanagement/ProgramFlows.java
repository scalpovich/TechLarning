
package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

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

	public String createprogramPrepaid(DeviceCreation deviceCreation, Program program) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		programpage = navigator.navigateToPage(ProgramPage.class);
		programpage.clickAddProgram();
		String PROGRAM = programpage.addProgramGeneral(deviceCreation, program);
		programpage.addKYCLimits(program);
		programpage.selectLoadAndRefundParameters(program);
		programpage.clickNextButton();
		programpage.selectWalletPLan(program);
		programpage.selectDevicePlan(program);
		programpage.selectOtherPlans();
		programpage.clickNextButton();
		programpage.clickNextButton();
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
		programpage.selectOtherPlans();
		programpage.clickNextButton();
		programpage.clickNextButton();
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
		programpage.clickFinishButton();
		return PROGRAM;
	}

	public void VerifyProgramSuccess() {
		programpage.verifyNewProgramSuccess();
	}
}
