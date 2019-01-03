package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.thoughtworks.selenium.webdriven.commands.GetExpression;

@Component
@Navigation(tabTitle = HelpdeskNav.TAB_HELPDESK, treeMenuItems = {
		HelpdeskNav.L1_ACTIVITY,
		HelpdeskNav.L2_SEARCH,
		HelpdeskNav.L3_SERVICE_REQUEST
		})
public class ServiceRequestPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceRequestPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement serviceDescriptionLbl;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement statusCodeDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement priorityDDwn;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement callReferanceNumberTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement deviceNumberTxt;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:dateTextField")
	private MCWebElement fromDateDPkr;
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:1:componentPanel:input:dateTextField")
	private MCWebElement toDateDPkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement stageDDwn;
	public void verifyUiOperationStatus() {
		logger.info("Service Request");
		verifySearchButton("Search");
	}

	public String verifyServiceRequest(Device device){
		logger.info("Service Request validation");
		selectByVisibleText(productTypeDDwn, device.getProductType());
		enterText(deviceNumberTxt, device.getDeviceNumber());
		selectFromToDate();
		clickSearchButton();
		waitForWicket();
		waitForPageToLoad(driver());
		SimulatorUtilities.wait(100000);
		String serviceRequest = String.format("//*[@class='dataview']/..//td[count(//span[text()='Service Description']//..//..//preceding-sibling::th)+1]");
		return driver().findElement(By.xpath(serviceRequest)).getText();
	}
	
	public void  selectFromToDate(){
		WebElementUtils.enterText(fromDateDPkr, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		WebElementUtils.enterText(toDateDPkr, LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(productTypeDDwn));
	}
}
