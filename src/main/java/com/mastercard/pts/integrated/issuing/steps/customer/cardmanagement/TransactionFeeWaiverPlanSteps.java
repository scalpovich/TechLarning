package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.TransactionFeeWaiverPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.TransactionFeeWaiverPlanFlows;

@Component
public class TransactionFeeWaiverPlanSteps {
	
	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private TransactionFeeWaiverPlanFlows transactionFeeWaiverPlanFlows;

	@Autowired
	private TestContext context;
	
	@When("user creates a transaction fee waiver")
	public void createTransactionFeeWaiverPlan(){
		TransactionFeeWaiverPlan plan=TransactionFeeWaiverPlan.createWithProvider(provider);
		transactionFeeWaiverPlanFlows.addTransactionFeeWaiverPlanForMultipleType(plan);
	}
	
	@When("User add $type type in Transaction Fee Waiver plan as $origin origin and $frequency frequency")
	public void userAddTransactionFeeWaiverplanInExistingPlan(String type, String origin,String frequency){
		TransactionFeeWaiverPlan plan=TransactionFeeWaiverPlan.createWithProvider(provider);
		plan.setFeeType(type);
		plan.setTransactionOrigin(origin);
		plan.setWaiverFrequency(frequency);
		LocalDate convertedDate1 = LocalDate.parse(context.get(ContextConstants.INSTITUTION_DATE), DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss"));
		String date=convertedDate1.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate convertedDate2 = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		plan.setEffectiveDate(convertedDate2.plusDays(1));
		plan.setEndDate(convertedDate2.plusDays(1));
		DevicePlan device=context.get(ContextConstants.DEVICE_PLAN);
		transactionFeeWaiverPlanFlows.addTransactionFeeWaiverplanInExistingPlan(plan,device);
	}
}

	
	
	
	
	
	
	
	
	


