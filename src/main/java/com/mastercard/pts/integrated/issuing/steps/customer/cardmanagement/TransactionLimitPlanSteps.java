package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramSetupWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionLimitPlanFlows;

@Component
public class TransactionLimitPlanSteps {

	private static final String description = "Automation Limit Plan ";

	private static final String transactionLimitPlanCode = "_TLP";

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	private KeyValueProvider provider;

	private TransactionLimitPlan transactionLimitPlan;

	@Autowired
	private TransactionLimitPlanFlows transactionLimitPlanFlows;

	@Autowired
	private ProgramSetupWorkflow programSetupWorkflow;

	@When("user creates Transaction Limit Plan for $product and plan type as $plan")
	public void whenUserCreatesTransactionLimitPlanForPrepaidAndPlanTypeAsDeviceWalletPromotionEntityPlan(@Named("product") String product, @Named("plan") String plan) {
		transactionLimitPlan = TransactionLimitPlan.transactionlimitDataProvider();
		deviceCreation.setProduct(product);
		deviceCreation.setPlanType(plan);
		transactionLimitPlanFlows.createTransactionLimitPlan(deviceCreation, transactionLimitPlan);
	}

	@When("User fills Transaction Limit Plan for $type product without details")
	public void whenUserFillsTransactionLimitPlan(String type) {
		transactionLimitPlan = TransactionLimitPlan.createWithProvider(provider);
		transactionLimitPlan.setDescription(description + ProductType.fromShortName(type).toString().subSequence(0, 3));
		transactionLimitPlan.setIframeproductType(ProductType.fromShortName(type));
		transactionLimitPlan.setTransactionLimitPlanCode(ProductType.fromShortName(type).subSequence(0, 3).toString().toUpperCase() + transactionLimitPlanCode);
		transactionLimitPlanFlows.createTransactionLimitPlanWithoutDetails(transactionLimitPlan);
	}

	@When("User fills details for $type for $source source")
	public void whenUserFillsDetails(String type, String source) {
		TransactionLimitPlanDetails details = TransactionLimitPlanDetails.createWithProvider(provider);
		details.setIframeTransactionType(type);
		details.setIframeTransactionSource(source);
		transactionLimitPlan.getTransactionLimitPlanDetails().clear();
		transactionLimitPlan.getTransactionLimitPlanDetails().add(details);
		transactionLimitPlanFlows.addDetails(transactionLimitPlan);
	}
	
	@When("User saves plan")
	public void whenUserSavesPlan(){
		transactionLimitPlanFlows.clickSave();
	}
	
	@When("User deleted $name plan")
	public void whenUserDeletesNamePlan(String name){
		transactionLimitPlanFlows.deletePlan(name);
	}
}