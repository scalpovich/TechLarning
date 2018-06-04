package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HolidayConfiguration;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.HolidayConfigurationPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Component
public class HolidayConfigurationFlows {
	
	@Autowired
	private Navigator navigator;
	
	public void addHolidayConfiguration(HolidayConfiguration holidayConfiguration){
		HolidayConfigurationPage page = navigator.navigateToPage(HolidayConfigurationPage.class);
		page.addNewHolidayConfiguration(holidayConfiguration);	
	}

}
