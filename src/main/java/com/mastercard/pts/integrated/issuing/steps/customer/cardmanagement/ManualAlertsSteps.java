package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ManualAlerts;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ManualAlertsFlows;

/**
 * This class provides the step definitions for steps mentioned in the InstitutionSetupCredit, InstitutionSetupDebit ,InstitutionSetupPrepaid story file
 */

/**
 * @author E070234
 *
 */
@Component
public class ManualAlertsSteps  {

	@Autowired
	ManualAlertsFlows manualAlertFlows;
	@Autowired
	ManualAlerts manualAlert;

	@When("user creates Manual Alerts of $deviceType for product type $productType")
	public void whenUserCreatesManualAlerts(@Named("devicetype") String devicetype , @Named("Product") String product ) {
		manualAlert	= ManualAlerts.manualAlertsDataProvider();
		manualAlert.setProduct(product);
		manualAlert.setDeviceType(devicetype);
		manualAlertFlows.addManualAlerts(manualAlert);


	}

}
