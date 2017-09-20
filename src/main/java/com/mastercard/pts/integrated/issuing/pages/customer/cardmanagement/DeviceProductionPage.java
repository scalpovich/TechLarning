package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DeviceProductionPage extends AbstractBasePage {
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement BatchNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement DeviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:searchButtonPanel:buttonCol:searchButton")
	private MCWebElement SearchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "dataPanel:BasicDataTable:datatable:body:rows:1:cells:7:cell:columnCheckBox")
	private MCWebElement DeviceProductionBatchRecordChkBx;

	@PageElement(findBy = FindBy.NAME, valueToFind = "processSelected")
	private MCWebElement ProcessSelectedBtn;

	public void deviceproduction(String prodType, String batchNum, String DeviceNumber) {
		menuSubMenuPage.getDeviceProduction().click();
		SelectDropDownByText(ProductTypeDDwn, prodType);
		if (batchNum != null) {
			enterText(BatchNumberTxt, batchNum);
		}

		if (DeviceNumber != null) {
			enterText(DeviceNumberTxt, DeviceNumber);
		}
		ClickButton(SearchBtn);

		if (DeviceProductionBatchRecordChkBx.isVisible()) {
			ClickCheckBox(DeviceProductionBatchRecordChkBx, true);
		} else {
			ClickButton(SearchBtn);
			CustomUtils.ThreadDotSleep(10000);
		}
		ClickButton(ProcessSelectedBtn);

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}