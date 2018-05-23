package com.mastercard.pts.integrated.issuing.workflows.customer.administration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BatchDefinition;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.BatchDefinitionPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class BatchDefinitionWorkflow {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	Navigator navigator;

	private BatchDefinitionPage batchDefinitionPage;

	public void setBatchDefinitionFlows(String batchType, String batchID) {
		BatchDefinition batchDefinition = BatchDefinition.createWithProvider();
		batchDefinitionPage = navigator
				.navigateToPage(BatchDefinitionPage.class);
		batchDefinitionPage.searchForBatchDefinition(batchType, batchID);
		batchDefinitionPage.editBatchDefinition(batchDefinition);
	}
}
