package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.ChannelRoutingPlan;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP, CardManagementNav.L2_ROUTING,
		CardManagementNav.L3_CHANNEL_ROUTING})
public class ChannelRoutingPage extends AbstractBasePage {

	 
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement channelDdwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = " tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement interfaceNameDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planId:input:inputTextField")
	private MCWebElement planIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	
	public void clickAddChannelRouting(){
		clickWhenClickable(addplanBtn);
		switchToWindow(Constants.ADD_CHANNEL_ROUTING);
	}
	
	public void switchToWindow(String screenName) {
		addWicketAjaxListeners(driver());
		switchToIframe(screenName);
	} 
	public void addRoutingDetails(ChannelRoutingPlan channelroutingplan){
		enterText(planIDTxt, channelroutingplan.getPlanID());
		enterText(descriptionTxt ,channelroutingplan.getDescription());
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		clickWhenClickable(addplanBtn);
		
		selectByVisibleText(channelDdwn,channelroutingplan.getChannel());
		selectByVisibleText(interfaceNameDdwn,channelroutingplan.getInterfaceName());	 
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		clickWhenClickable(saveBtn);
		
	}
		
	 
	/*Add Channel Routing Plan Detail

	Channel - 
	interface -
	Add Channel Routing Plan
	
	*/
	
}