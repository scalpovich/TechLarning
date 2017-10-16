package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutOverProfile;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.CutoverProfileFlows;

@Component
public class CutOverProfileSteps {

	@Autowired
	CutoverProfileFlows cutoverflows;

	public CutOverProfile cutover;

	@When("user creates a Cutover profile with cutover hours as $hours and cutover minutes as $minutes")
	public void whenUserCreatesACutoverProfile(@Named("hours") String hours, @Named("minutes") String minutes) {
		cutover = CutOverProfile.cutoverDatProvider();
		cutover.setCutoverHours(hours);
		cutover.setCutoverMins(minutes);
		cutoverflows.CreateCutOverProfile(cutover);
	}

}