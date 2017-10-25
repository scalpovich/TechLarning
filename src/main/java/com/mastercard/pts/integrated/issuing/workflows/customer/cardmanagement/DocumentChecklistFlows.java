package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DocumentChecklistPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Component
public class DocumentChecklistFlows extends MenuFlows {

	@Autowired
	DeviceCreation deviceCreation;

	@Autowired
	Navigator navigator;

	public String CreateDocumentChecklist(DeviceCreation deviceCreation) {
		waitForElementVisible(menusubmenuPage.getCardManagement());
		DocumentChecklistPage docCheckListPage = navigator.navigateToPage(DocumentChecklistPage.class);
		docCheckListPage.ClickaddDocumentCheckList();
		String docList = docCheckListPage.adddocumentchecklist(deviceCreation);
		docCheckListPage.clickSaveButton();
		docCheckListPage.addDocChecklistDetails();
		docCheckListPage.switchToAddDocChecklistFrame();
		docCheckListPage.clickSaveButton();
		docCheckListPage.verifyDoclistSuccess();
		return docList;
	}
}
