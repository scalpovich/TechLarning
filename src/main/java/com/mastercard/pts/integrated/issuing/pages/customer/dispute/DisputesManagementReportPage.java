package com.mastercard.pts.integrated.issuing.pages.customer.dispute;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = DisputeNav.TAB_DISPUTE, treeMenuItems = { DisputeNav.L1_REPORTS, DisputeNav.L2_DISPUTES_MANAGEMENT_REPORT })
public class DisputesManagementReportPage extends AbstractDisputePage {

	@Autowired
	private KeyValueProvider provider;

	private static final Logger logger = LoggerFactory.getLogger(DisputesManagementReportPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "componentPanel")
	private MCWebElement selectReportDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:1:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "tables:3:rows:2:cols:colspanMarkup:inputField:input:dropdowncomponent")
	private MCWebElement fileTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "generateReport")
	private MCWebElement generateReportBtn;

	public void verifyUiOperationStatus() {
		logger.info("Disputes Management Report");
		verifySearchButton("Go");
	}

	public void downloadPotentialChargeBackReport() {
		WebElementUtils.selectDropDownByVisibleText(selectReportDDwn, provider.getString("SELECT_REPORT"));
		searchButtonElement.click();
		WebElementUtils.selectDropDownByVisibleText(productTypeDDwn, provider.getString("REPORT_PRODUCT_TYPE"));
		WebElementUtils.selectDropDownByVisibleText(fileTypeDDwn, provider.getString("FILE_TYPE"));
		generateReportBtn.click();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(selectReportDDwn));
	}
}