package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessMandatory;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.BusinessMandatoryFieldsPage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class BusinessMandatoryFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public void addBusinessMandatoryFields(DeviceCreation deviceCreation, BusinessMandatory businessmandate,
			Program program) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		BusinessMandatoryFieldsPage businessmandatoryFieldspage = navigator
				.navigateToPage(BusinessMandatoryFieldsPage.class);
		businessmandatoryFieldspage.clickAddBusinessMandatoryFields();
		businessmandatoryFieldspage.switchToAddBusinessMandatoryFrame();
		businessmandatoryFieldspage.selectProduct(deviceCreation);
		businessmandatoryFieldspage.selectCustomerType(businessmandate);
		businessmandatoryFieldspage.selectProgram(program);
		businessmandatoryFieldspage.clickSearch();
		businessmandatoryFieldspage.selectMandatoryFields(
				System.getProperty("user.dir") + "/src/main/resources/config/" + System.getProperty("environment")
						+ File.separator + "TestData" + File.separator + "BusinessMandatoryFields.xlsx");
		businessmandatoryFieldspage.clickSaveButton();
	}

}
