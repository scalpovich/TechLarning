package com.mastercard.pts.integrated.issuing.steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.workflows.customer.transaction.TransactionWorkflow;

@Component
public class SimulatorTestHooks {

	@Autowired
	private TransactionWorkflow transactionWorkflow;

	@BeforeStory
	public void startSimulatorSession(@Named("SimulatorSession") String simulator) {
		if (!Strings.isNullOrEmpty(simulator)) {
			transactionWorkflow.launchWiniumAndSimulator(simulator);
		}
	}

	@AfterStory
	public void stopSimulatorSession(@Named("SimulatorSession") String simulator) {
		if (!Strings.isNullOrEmpty(simulator)) {
			transactionWorkflow.closeSimulator(simulator);
		}
	}
}