package com.mastercard.pts.integrated.issuing.steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.DBUtility;

@Component
public class DeviceKeyCreationSteps{
	
	@Autowired
	private DBUtility dbUtility;
	
	@Value(value = "classpath:config/${env}/SQLSCRIPTS/DeviceKeys.sql")
	private Resource devicekeysql;
	
	@Given("create prerequisites device and network keys")
	@When("create prerequisites device and network keys")
	@Then("create prerequisites device and network keys")
	public void givenCreatePrerequisitesDeviceKeysCreation(){
		dbUtility.runSQLScript(devicekeysql);
	}
}