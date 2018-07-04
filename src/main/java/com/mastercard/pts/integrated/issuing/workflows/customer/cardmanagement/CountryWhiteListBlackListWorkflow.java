package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CountryWhiteListBlackListPlan;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CountryWhiteListBlackListPlanPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class CountryWhiteListBlackListWorkflow {

	@Autowired
	Navigator navigator;
	CountryWhiteListBlackListPlanPage countryWhiteListBlackListPlanPage;

	public boolean addCountryInBlackOrWhiteListInPlan(CountryWhiteListBlackListPlan countryWhiteListBlackListPlan) {
		countryWhiteListBlackListPlanPage=navigator.navigateToPage(CountryWhiteListBlackListPlanPage.class);
		return countryWhiteListBlackListPlanPage.addCountryInBlackOrWhiteListInPlan(countryWhiteListBlackListPlan);
	}
}
