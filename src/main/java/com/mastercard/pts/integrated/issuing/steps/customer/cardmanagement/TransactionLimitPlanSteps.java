package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionLimitPlanDetails;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.ProgramSetupWorkflow;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionLimitPlanFlows;

@Component
public class TransactionLimitPlanSteps {

	private static final String DESCRIPTION = "Automation Limit Plan ";

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	private KeyValueProvider provider;

	private TransactionLimitPlan transactionLimitPlan;

	@Autowired
	private TransactionLimitPlanFlows transactionLimitPlanFlows;

	@Autowired
	private ProgramSetupWorkflow programSetupWorkflow;
	
	@Autowired
	private TestContext context;

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
		String description=DESCRIPTION + ProductType.fromShortName(type).subSequence(0, 3);
		transactionLimitPlan.setDescription(description);
		transactionLimitPlan.setIframeproductType(ProductType.fromShortName(type));
		String randomValue = MiscUtils.generate6CharAlphaNumeric();
		transactionLimitPlan.setTransactionLimitPlanCode(randomValue);
		String code = String.format("%s [%s]", description, randomValue);
		context.put(ContextConstants.TX_LIMIT_PLAN_CODE, code);
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