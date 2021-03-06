package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_PROCESSING_BATCHES, CardManagementNav.L3_CLIENT_PHOTO_DOWNLOAD_BATCHES })
public class ClientPhotoDownloadBatchPage extends AbstractBasePage {
	
	@Autowired
	private TestContext context;
	
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Product Type']/following-sibling::td/select")
	private MCWebElement productTypeDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[text()='Application Number']/following-sibling::td[2]")
	private MCWebElement applicationNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/..//td[13]")
	private MCWebElement processBatchCheckBox;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processSelected")
	private MCWebElement processSelectedBtn;
	
	public boolean[] verifyBatchNameIsPresentInDownloadBatch()
	{
		boolean []downloadBatchDetails= new boolean[] {true,true,true};
		Device device = context.get(CreditConstants.APPLICATION);
		selectByVisibleText(productTypeDDwn,context.get(ConstantData.PRODUCT_IDENTITY));
		enterValueinTextBox(applicationNumberTxt,device.getApplicationNumber());
		clickSearchButton();
		SimulatorUtilities.wait(2000);
		waitAndSearchForRecordToAppear();
		if(isNoRecordsFoundInTable()) {
			downloadBatchDetails[0]=false; 
			downloadBatchDetails[1]=false;
		} else {
			ClickCheckBox(processBatchCheckBox, true);
			SimulatorUtilities.wait(500);
			ClickButton(processSelectedBtn);
			
		}
		if(verifyOperationStatusAndgetJobID().isEmpty()) {
			downloadBatchDetails[2]=false;
		}
		return downloadBatchDetails;
	}
	

}
