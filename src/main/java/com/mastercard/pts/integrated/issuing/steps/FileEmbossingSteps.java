package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.workflows.DeviceCreationFlows;
import com.mastercard.pts.integrated.issuing.workflows.PrepaidDeviceFileEmbossingFlows;

@Component
public class FileEmbossingSteps extends AbstractBaseSteps {
	/*
	 * @Autowired CustomUtils customutils;
	 * 
	 */

	@Autowired
	PrepaidDeviceFileEmbossingFlows prepaidDeviceFileEmbossingFlows;

	@Autowired
	DeviceCreationFlows deviceCreationFlows;

	@When("user creates embossing file template with additional parameters:$parameterTable")
	public void createEmbossingFileTemplate(ExamplesTable parameterTable) throws InterruptedException {
		prepaidDeviceFileEmbossingFlows.createEmbossTemplate();
		prepaidDeviceFileEmbossingFlows.editEmbossingTemplate(parameterTable);//
		// to
		// be removed
	}

	@When("attach the template to the device plan")
	public void attachEmbossTemplateToDevicePlan() {
		prepaidDeviceFileEmbossingFlows.addVendor();
		prepaidDeviceFileEmbossingFlows.addDevicePlanPrepaid();
		prepaidDeviceFileEmbossingFlows.createProgram();
		prepaidDeviceFileEmbossingFlows.addDeviceRange();
		prepaidDeviceFileEmbossingFlows.createBulkDeviceReq();
		prepaidDeviceFileEmbossingFlows.RunBulkDeviceGenBatch();
		prepaidDeviceFileEmbossingFlows.RunPreProductionBatch();

	}

	@When("executes the device production batch")
	public void executeDeviceProdBatch() {
		prepaidDeviceFileEmbossingFlows.RunDeviceProductionBatch();
	}

	@When("attach the template to the new device plan of $type")
	public void attachEmbossTemplateToNewDevicePlan() {
		deviceCreationFlows.addVendor();
		deviceCreationFlows.addDevicePlan();
		deviceCreationFlows.addProgram();
		deviceCreationFlows.addDeviceRange();
		deviceCreationFlows.addNewDevice();
		prepaidDeviceFileEmbossingFlows.RunPreProductionBatch();

	}
}
