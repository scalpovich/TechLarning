package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.PictureCodePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class PictureCodeFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	@Autowired
	DeviceCreation deviceCreation;

	public String addPictureCode() {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		PictureCodePage picturecodePage = navigator.navigateToPage(PictureCodePage.class);
		picturecodePage.clickaddPictureCode();
		return picturecodePage.addPictureCodeDetails();

	}

}
