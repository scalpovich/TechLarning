package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.steps.AbstractBaseSteps;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DeviceCreationFlows;

/**
 * @author E060549
 * 
 *
 */

@Component
public class FileEmbossingSteps extends AbstractBaseSteps {
	/*
	 * @Autowired CustomUtils customutils;
	 */

	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaidDeviceFileEmbossingFlows;

	@Autowired
	DeviceCreationFlows deviceCreationFlows;

	@When("user creates embossing file template with additional parameters:$parameterTable")
	public void createEmbossingFileTemplate(ExamplesTable parameterTable) throws InterruptedException {
		/*
		 * String flag = prepaidDeviceFileEmbossingFlows.createEmbossTemplate();
		 * if (flag.equalsIgnoreCase("Added")) {
		 * prepaidDeviceFileEmbossingFlows.editEmbossingTemplate(System
		 * .getProperty("user.dir") +
		 * "\\TempFiles\\EmbossingInputTemplate.xlsx"); }
		 */
	}

	@When("create a PIN offset template with parameters:$pinTable")
	public void createPINOffsetTemplate(ExamplesTable PINTable) {
		// prepaidDeviceFileEmbossingFlows.createPINOffsetTemplate(PINTable);
	}

	@When("attach the template to the device plan")
	public void attachEmbossTemplateToDevicePlan() {
		/*
		 * prepaidDeviceFileEmbossingFlows.addVendor();
		 * prepaidDeviceFileEmbossingFlows.addDevicePlanPrepaid();
		 * prepaidDeviceFileEmbossingFlows.createProgram();
		 * prepaidDeviceFileEmbossingFlows.addDeviceRange();
		 * prepaidDeviceFileEmbossingFlows.createBulkDeviceReq();
		 * prepaidDeviceFileEmbossingFlows.RunBulkDeviceGenBatch();
		 * prepaidDeviceFileEmbossingFlows.RunPreProductionBatch();
		 */
	}

	@When("executes the device production batch")
	public void executeDeviceProdBatch() {
		prepaidDeviceFileEmbossingFlows.RunDeviceProductionBatch();
	}

	@When("attach the template to the new device plan of $type")
	public void attachEmbossTemplateToNewDevicePlan() {
		/*
		 * deviceCreationFlows.addVendor(); deviceCreationFlows.addDevicePlan();
		 * deviceCreationFlows.addProgram();
		 * deviceCreationFlows.addDeviceRange();
		 * deviceCreationFlows.addNewDevice();
		 * prepaidDeviceFileEmbossingFlows.RunPreProductionBatch();
		 */

	}
}
