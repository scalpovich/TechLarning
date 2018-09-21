package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceRange;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.StopListBin;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_STOP_LIST,
		CardManagementNav.L3_STOP_LIST_BIN
		})

public class StopListBinPage extends AbstractBasePage {
	
	private static final Logger logger = LoggerFactory.getLogger(StopListBinPage.class);
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement bin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopBinsContainer:bin:input:dropdowncomponent")
	private MCWebElement binDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopBinsContainer:search")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopBinsDetailContainer:reasonCode:input:dropdowncomponent")
	private MCWebElement reasonCodeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "stopBinsDetailContainer:abrevName:input:textAreaComponent")
	private MCWebElement descriptionTxt;
	
	public void verifyUiOperationStatus() {
		logger.info("Stop List Bins");
		verifyButton("Search");
	}
	
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(bin),
				WebElementUtils.elementToBeClickable(interchange)
				);
	}
	
	public void stoplistBin(StopListBin stopListBin, DeviceRange deviceRange){
		clickAddNewButton();
		runWithinPopup("Add Stop List Bins", ()->{
			String issuerBin="";
			if(!deviceRange.getIssuerBin().contains("[")){
				issuerBin=deviceRange.getIssuerBin();
			}
			else{
				issuerBin=deviceRange.getIssuerBinCode(deviceRange.getIssuerBin());
			}
			selectBin(String.format("%s [%s]", issuerBin, issuerBin));
			clickSearch();
			waitForElementVisible(reasonCodeDDwn);
			selectReasonCode(stopListBin.getStopListReason());
			enterDescription(stopListBin.getStopListReasonDescription());
			clickSaveButton();
		});
		verifyOperationStatus();
	}
	public void selectBin(String bin){
		selectDropDownByText(binDDwn, bin);
	}
    public void selectReasonCode(String reasonCode){
    	selectDropDownByText(reasonCodeDDwn, reasonCode);
	}
    public void enterDescription(String description){
    	enterText(descriptionTxt, description);
    }
    
    public void clickSearch(){
    	ClickButton(searchBtn);
    }
}