package com.mastercard.pts.integrated.issuing.steps;

import java.util.Collection;
import java.util.Collections;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.DataLoader;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.RupayBinSettlementFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class RupayBinConfigMakerCheckerSteps extends AbstractBaseFlows {

	@Autowired
	@Qualifier("defaultDataLoader")
	public DataLoader dataLoader;

	@Autowired
	private RupayBinSettlementFlows rupaybinsettlementflow;

	@Given(" customer portal user has access and privilege to configure")
	public void givenCustomerPortalUserHasAccessAndPrivilegeToConfigure(
			@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {
		dataLoader.updateTestContextWithTestData(sheetName, tcName);
		rupaybinsettlementflow.makerRupayBinSettlement();
	}

	@When("the customer portal user edited the record")
	public void whenTheCustomerPortalUserEditedTheRecord() {
		rupaybinsettlementflow.editAtEndRupayBinSettlement();
		rupaybinsettlementflow.userWithBothPrivilege();
	}

	@Given(" a customer portal user has access and privilege to configure")
	public void givenCstomerPortalUserHasAccessAndPrivilegeToConfigure(
			@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {
		dataLoader.updateTestContextWithTestData(sheetName, tcName);
	}

	@Given("Customer portal user has access and privilege to do configurations")
	public void givenCustomerPortalUserHasAccessAndPrivilegeToDoConfigurations(
			@Named("TCName") String tcName,
			@Named("sheetName") String sheetName) {
		dataLoader.updateTestContextWithTestData(sheetName, tcName);
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Collections.emptyList();
	}
}