package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_OPERATION, CardManagementNav.L2_OPERATION_APPLICATION, CardManagementNav.L3_OPERATION_APPLICATION_CREDIT, CardManagementNav.L4_RISK_ANALYSIS })
public class RiskAnalysisPage extends AbstractBasePage {

	protected static final Logger logger = LoggerFactory.getLogger(RiskAnalysisPage.class);

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[contains(text(),'Batch No')]")
	private MCWebElement batchNoColumn;

	@Autowired
	TestContext context;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement saveBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Process All']")
	private MCWebElement processAllBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Risk Analysis']")
	private MCWebElement riskAnalysisBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd']/td[1]")
	private MCWebElements txtAllBatchNumber;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Risk Analysis']")
	private MCWebElement riskAnalysisLink;

	@PageElement(findBy = FindBy.CSS, valueToFind = "table.dataview")
	private MCWebElement searchTable;

	public void riskAnalysisBatchProcess() {

		if (!WebElementUtils.isTextAvailableinTable(searchTable, context.get(CreditConstants.PRIMARY_BATCH_NUMBER))) {
			clickWhenClickable(riskAnalysisBtn);
			riskAnalysisBatchProcess();
		}
		SimulatorUtilities.wait(4000);
	}

	public void clickProcessALL() {
		clickWhenClickable(processAllBtn);
	}

	public List<String> allBatchNumberRetrieval() {
		List<String> batchnumbers = new ArrayList<>();
		for (int i = 0; i < txtAllBatchNumber.getElements().size(); i++) {
			batchnumbers.add(txtAllBatchNumber.getElements().get(i).getText());
		}
		return batchnumbers;
	}

	public int identifyBatchNumberToProcess() {
		Device device = context.get(ContextConstants.DEVICE);
		int index = 0;
		for (int i = 0; i < allBatchNumberRetrieval().size(); i++) {
			if (allBatchNumberRetrieval().get(i).equals(device.getBatchNumber())) {
				logger.info("batchNumber: {}", allBatchNumberRetrieval().get(i));
				index = i;
			}
		}
		return index;
	}

	public void processAppropriateBatchForApplication() {
		checkWhetherRecordPersists();
		String checkBox = "//table[@class='dataview']//tbody/tr[@class='even' or @class='odd'][" + identifyBatchNumberToProcess() + 1 + "]/td[8]/span/input";
		clickWhenClickable(getFinder().getWebDriver().findElement(By.xpath(checkBox)));
		saveBtn.click();
		verifyOperationStatus();
	}

	public void checkWhetherRecordPersists() {
		if (isNoRecordsFoundInTable()) {
			clickWhenClickable(riskAnalysisLink);
			checkWhetherRecordPersists();
		}
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(batchNoColumn));
	}
}