package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = {
		LoyaltyNav.L1_REPORTS,
		LoyaltyNav.L2_LOYALTY_POINTS		
		})
public class LoyaltyPointsPage extends AbstractBasePage{

	private static final Logger logger = LoggerFactory
			.getLogger(LoyaltyPointsPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	public MCWebElement productTypeDDwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:3:cols:colspanMarkup:inputField:input:dropdowncomponent")
	public MCWebElement loyaltyPlanDDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='p_device_number']/input")
	public MCWebElement deviceNumberTxtBox;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:2:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	public MCWebElement fileTypeDDwn;

	public void verifyUiOperationStatus() {
		logger.info("Loyalty Points");
		verifySearchButton("Go");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(selectReportDDwn));
	}
	
	public void selectReport(String value) {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, value);
		saveOrDetailsOrSearchClick();
	}
	
	public void selectProductType(String value) {
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, value);
	}
	
	public void selectLoyaltyPlan(String value) {
		WebElementUtils.selectDropDownByVisibleText(loyaltyPlanDDwn, value);
	}
	
	public void enterDeviceNumber(String value) {
		enterValueinTextBox(deviceNumberTxtBox, value);
	}
	
	public void selectFileType(String value) {
		WebElementUtils.selectDropDownByVisibleText(fileTypeDDwn, value);
	}
	
	public String verifyReportDownloaded(String name, String extn) {
		return verifyReportDownloaded(name);
	}
}
