package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class PreProductionBatchPag extends AbstractBasePage {
	@Autowired
	MenuSubMenuPage menuSubMenuPage;

		@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement ProductTypeDDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value = 'Search'][@type = 'submit']")
	private MCWebElement SearchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productionPanel:BasicDataTable:datatable:body:rows:1:cells:8:cell:columnCheckBox")
	private MCWebElement PreProductionBatchRecordChkBx;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value ='Process Selected'][@type= 'submit']")
	private MCWebElement ProcessSelectedBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement BatchNumTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:saveAll")
	private MCWebElement ProcessAllBtn;

	public void preproduction(String product, String batchNum) {
		menuSubMenuPage.getPreProductionBatch().click();
		selectDropDownByText(ProductTypeDDwn, product);
		if (batchNum != null) {
			enterText(BatchNumTxt, batchNum);
		}
		ClickButton(SearchBtn);
		ClickCheckBox(PreProductionBatchRecordChkBx, true);
		ClickButton(ProcessSelectedBtn);
		switchToDefaultFrame();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
