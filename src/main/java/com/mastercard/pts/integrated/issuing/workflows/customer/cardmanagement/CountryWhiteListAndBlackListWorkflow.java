package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CountryWhiteListAndBlackListPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CountryWhiteListAndBlackListPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CountryWhiteListAndBlackListWorkflow {

	@Autowired
	Navigator navigator;
	CountryWhiteListAndBlackListPlanPage countryWhiteListBlackListPlanPage;

	public boolean addCountryInBlackOrWhiteListInPlan(CountryWhiteListAndBlackListPlan countryWhiteListBlackListPlan) {
		countryWhiteListBlackListPlanPage=navigator.navigateToPage(CountryWhiteListAndBlackListPlanPage.class);
		return countryWhiteListBlackListPlanPage.addCountryInBlackOrWhiteListInPlan(countryWhiteListBlackListPlan);
	}
}
