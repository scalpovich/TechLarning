package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.LinkingAPIToInstitution;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_LINKING_API_TO_INSTITUTION
})

public class LinkingAPIToInstitutionPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(LinkingAPIToInstitutionPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement userId;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDdwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "userId:input:dropdowncomponent")
	private MCWebElement userIdDdwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchBtn")
	private MCWebElement searchbtn;
	@PageElement(findBy = FindBy.CLASS, valueToFind = "button add")
	private MCWebElement addbtn;


	public void verifyUiOperationStatus() {
		logger.info("Link API to institution");
		verifyUiOperation("Add Link API to institution");
	}		 

	public void clickAddLinkingAPI(){
		clickWhenClickable(addplanBtn);
		switchToIframe(Constants.ADD_LINK_API);
	}

	public void addLinkingDetails(LinkingAPIToInstitution linkingAPIToInstitution){
		clickAddLinkingAPI();
		selectByVisibleText(userIdDdwn,linkingAPIToInstitution.getUserId());
		selectByVisibleText(productTypeDdwn,linkingAPIToInstitution.getProductType());
		clickWhenClickable(searchbtn);
		if(!publishErrorOnPage()){
		selectAllServiceCode();
		clickWhenClickable(addbtn);
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		SwitchToDefaultFrame();
		verifyNewChannelRoutingSuccess();
		}else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();
		}
		

	}
	public void verifyNewChannelRoutingSuccess() {
		if (!publishErrorOnPage()) {
			logger.info("Record Added Successfully.");
			SwitchToDefaultFrame();
		} else {
			logger.info("Error in record Addition");
			clickWhenClickable(cancelBtn);
			SwitchToDefaultFrame();

		}
	}
	public void selectAllServiceCode() {
		Select s = new Select(getFinder().getWebDriver().findElement(
				By.name("serviceCodePalette:choices")));
		List<WebElement> lenght =s.getOptions();
		for (int i = 0; i < lenght.size(); i++) {
			s.selectByIndex(i);
		}

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(productType),
				WebElementUtils.elementToBeClickable(userId)
				);
	}
}