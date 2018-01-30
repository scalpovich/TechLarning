package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.ProductType;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_ACTIVITY,
		CardManagementNav.L2_ACTIVITY_APPLICATION,
		CardManagementNav.L3_ACTIVITY_APPLICATION_CREDIT,
		CardManagementNav.L4_VERIFY })
public class VerifyCreditPage extends AbstractCardManagementPage {
@Autowired
TestContext context;
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSS05]

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addEmbossingPriorityPass;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planDesc:input:inputTextField")
	private MCWebElement Description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement applicationNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement fromDatePicker;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement toDatePicker;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[8]/span//img")
	private MCWebElement editImg;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "verify")
	private MCWebElement verifyBtn;
	
	//table[@class='dataview']//tbody/tr[1]/td[8]/span//img

	public void verifyapplication() {
		Device device=context.get(ContextConstants.APPLICATION);
		WebElementUtils.enterText(applicationNumberTxt, device.getApplicationNumber());
		WebElementUtils.pickDate(fromDatePicker, LocalDate.now());
		WebElementUtils.pickDate(toDatePicker, LocalDate.now());
		clickSearchButton();
	}

	public String editAndVerifyApplication()
	{
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
		clickWhenClickable(verifyBtn);
		verifyOperationStatus();
		getCodeFromInfoMessage("Application Number");
		return getCodeFromInfoMessage("Application Number");
	}
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}


}