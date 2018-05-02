package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ManualAlerts;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ManualAlertsFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstituionSetupCredit, InstituionSetupDebit ,InstituionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class ManualAlertsSteps extends ManualAlertsFlows {

@Autowired
	ManualAlertsFlows manualAlertFlows;
@Autowired
ManualAlerts alertpage;

	@When("user creates Manual Alerts of $EMVCard for product type $credit")
	public void whenUserCreatesAloudLoadCurrency(@Named("devicetype") String devicetype , @Named("Product") String product ) {
		alertpage	= ManualAlerts.manualAlertsDataProvider();
		alertpage.setProduct(product);
		alertpage.setDeviceTypeDdwn(devicetype);
		manualAlertFlows.addManualAlerts(alertpage);
		
		
	}
	
}
