package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_DEVICE_BIN })
public class DeviceBinPage extends AbstractModelPage {

	private static final Logger logger = LoggerFactory.getLogger(DeviceBinPage.class);

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=issuerBin]")
	private MCWebElement issuerBin;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='networkCode']/span/select")
	private MCWebElement interchangeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='productType']/span/select")
	private MCWebElement productTypeDwn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='binType']/span/select")
	private MCWebElement binTypeDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='issuerBin']")
	private MCWebElement issuerBinTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='remarks']")
	private MCWebElement remarksTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='processorIca']")
	private MCWebElement processorIcaTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='issuerIca']")
	private MCWebElement issuerIcaTxt;

	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='proxyIca']")
	private MCWebElement proxyIcaTxt;

	public void verifyUiOperationStatus() {
		logger.info("Device BIN");
		verifyUiOperation("Add Device BIN");
	}

	public void addDeviceBin(List<DeviceBin> dbList) {
		dbList.forEach(db -> {
			performSearchOperationOnMainScreen(db);
			if(isNoRecordsFoundInTable())
			{
				logger.info("create Devcie bin : {}", db.toString());
				clickAddNewButton();
				runWithinPopup("Add Device BIN", () -> {
					addBin(db);
					verifyNoErrors();
				});
				verifyOperationStatus();
			}
		});
	}

	private void addBin(DeviceBin db) {
		WebElementUtils.selectDropDownByVisibleText(interchangeDwn, db.getInterchange());
		WebElementUtils.selectDropDownByVisibleText(productTypeDwn, db.getProductType());
		WebElementUtils.selectDropDownByVisibleText(binTypeDwn, db.getBinType());
		WebElementUtils.enterText(issuerBinTxt, db.getIssuerBin());
		WebElementUtils.enterText(remarksTxt, db.getRemarks());
		WebElementUtils.enterText(processorIcaTxt, db.getIssuerBin());
		WebElementUtils.enterText(issuerIcaTxt, db.getIssuerBin());
		WebElementUtils.enterText(proxyIcaTxt, db.getIssuerBin());
		clickSaveButton();
	}

	private void performSearchOperationOnMainScreen(DeviceBin db)
	{
		WebElementUtils.enterText(issuerBin, db.getIssuerBin());
		clickSearchButton();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(issuerBin), WebElementUtils.elementToBeClickable(interchange));
	}
}
