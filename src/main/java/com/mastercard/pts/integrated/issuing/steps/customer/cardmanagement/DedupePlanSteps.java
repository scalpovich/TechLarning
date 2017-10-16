package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DedupePlan;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.DedupePlanFlows;

@Component
public class DedupePlanSteps {
	@Autowired
	DedupePlanFlows dedupeplanflows;

	@Autowired
	DedupePlan dedupeplan;

	@When("user creates Dedupe Plan")
	public void whenUserCreatesDedupePlan() {
		String dedupePlan = dedupeplanflows.addDedupePlan();
		dedupeplan.setDedupePlanCode(dedupePlan);
	}
}