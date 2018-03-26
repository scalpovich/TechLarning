package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingFile;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.EmbossingTemplatePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class EmbossingFileFlows extends MenuFlows {

	@Autowired
	Navigator navigator;

	public String createEmbossingTemplate(EmbossingFile embossingfile) {
		waitForElementVisible(menuSubMenuPage.getCardManagement());
		EmbossingTemplatePage embossingtemplatepage = navigator.navigateToPage(EmbossingTemplatePage.class);
		embossingtemplatepage.clickAddEmbossingTemplate();
		String embossingTemplate = embossingtemplatepage.addEmbossingGeneral(embossingfile);
        waitForLoaderToDisappear();
		embossingtemplatepage.verifyEmbossingTemplateSuccess();
		return embossingTemplate;
	}

}
