package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.StoplistReasonPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class StopListReasonWorkflow {

	@Autowired
	Navigator navigator;
	StoplistReasonPage stopListPage;
}
