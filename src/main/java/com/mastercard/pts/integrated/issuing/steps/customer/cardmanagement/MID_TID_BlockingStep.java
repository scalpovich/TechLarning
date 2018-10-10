package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.MID_TID_Blocking;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.AccountHeadMappingFlows;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.MID_TID_BlockingFlows;

@Component
public class MID_TID_BlockingStep {
	
	@Autowired
	private MID_TID_Blocking midtidBlocking;
	
	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private MID_TID_BlockingFlows mid_tid_blockingflow;
	
	@Autowired
	private TestContext context;

	final Logger logger = LoggerFactory.getLogger(MID_TID_BlockingStep.class);


	@When("user creates MID TID Blocking for combination $type")
	public void userCreatesMIDTIDBlockingForCombination(String type){
		midtidBlocking = MID_TID_Blocking.createWithProvider(provider);
		mid_tid_blockingflow.addMID_TID_Blocking(type, midtidBlocking);
		context.put(ContextConstants.MID_TID_BLOCKING, mid_tid_blockingflow);
		
	}

	@When("user deletes MID TID Blocking for Combination $type")
	public void userDeleteMIDTIDBlockingForCombination(String type){
		mid_tid_blockingflow.deleteMID_TID_Blocking(type, midtidBlocking);
	}
	
}
