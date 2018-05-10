package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:4:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement interfaceNameDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planId:input:inputTextField")
	private MCWebElement planIDTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "description:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addplanBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cancel")
	private MCWebElement cancelBtn;


	private static final Logger logger = LoggerFactory
			.getLogger(SystemCodesPage.class);


	public void clickAddChannelRouting(){
		clickWhenClickable(addplanBtn);
		switchToIframe(Constants.ADD_CHANNEL_ROUTING);
	}
	public void addRoutingDetails(ChannelRoutingPlan channelroutingplan){
		clickAddChannelRouting();
		enterText(planIDTxt, channelroutingplan.getPlanID());
		enterText(descriptionTxt ,channelroutingplan.getDescription());
		clickWhenClickable(saveBtn);
		waitForLoaderToDisappear();	
		clickWhenClickable(addplanBtn);
		SwitchToDefaultFrame();
		switchToIframe(Constants.ADD_CHANNEL_ROUTING_DETAILS);
		selectByVisibleText(channelDdwn,channelroutingplan.getChannel());
		selectByVisibleText(interfaceNameDdwn,channelroutingplan.getInterfaceName());	 
		clickWhenClickable(saveBtn);
		switchToIframe(Constants.ADD_CHANNEL_ROUTING);
		waitForLoaderToDisappear();	
		clickWhenClickable(saveBtn);
		verifyNewChannelRoutingSuccess();

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

}