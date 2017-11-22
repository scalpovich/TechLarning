package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.MenuSubMenuPage;
import com.mastercard.pts.integrated.issuing.utils.Constants;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class BulkDeviceRequestPage extends AbstractBasePage {

	@Autowired
	MenuSubMenuPage menuSubMenuPage;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addBulkDeviceRequestBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "productType:input:dropdowncomponent")
	private MCWebElement productTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "programCode:input:dropdowncomponent")
	private MCWebElement programTypeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "branchCode:input:dropdowncomponent")
	private MCWebElement branchDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "corporateClientCode:input:dropdowncomponent")
	private MCWebElement corporateClientCodeDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "quantity:input:inputTextField")
	private MCWebElement quantityRequestedTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "devicePlanCode:input:dropdowncomponent")
	private MCWebElement devicePlanDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement SaveBtn;

	@PageElement(findBy = FindBy.CLASS, valueToFind = "feedbackPanelINFO")
	private MCWebElement confirmationMsgTxt;

	public String createBulkDeviceRequest(String productType, String program, String quantityReq) {

		menuSubMenuPage.getBulkDeviceRequest().click();
		addWicketAjaxListeners(getFinder().getWebDriver());
		ClickButton(addBulkDeviceRequestBtn);
		switchToIframe(Constants.ADD_BULK_DEVICE_REQUEST_FRAME);
		SelectDropDownByText(productTypeDDwn, productType);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(branchDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByText(programTypeDDwn, program);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(corporateClientCodeDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		SelectDropDownByIndex(devicePlanDDwn, 1);
		addWicketAjaxListeners(getFinder().getWebDriver());
		enterText(quantityRequestedTxt, quantityReq);
		ClickButton(SaveBtn);
		SwitchToDefaultFrame();
		return getBatchNumber();

	}

	public String getBatchNumber() {
		String strOutputMessage = confirmationMsgTxt.getText().split("\\n")[0];
		System.out.println("Request Number " + strOutputMessage);
		// Record Added Successfully, Batch Number is 17149055
		String strOuputMessagePattern = "Record\\s*Added\\d*\\s*Successfully\\s*,\\s*Batch\\s*Number\\s*is\\s*";
		System.out.println("strOuputMessagePattern" + strOuputMessagePattern);
		// Assert.assertTrue("Record Added Successfully",
		// strOutputMessage.matches(strOuputMessagePattern));

		String strRequestNumber = strOutputMessage.replaceAll("[^\\d]", "").trim();
		// int intIndex = strOutputMessage.indexOf("is");
		// String strRequestNumber = strOutputMessage.substring(43, intIndex +
		// 1);
		System.out.println("Request Number is " + strRequestNumber);
		MapUtils.fnSetInputDataToInputMap("BatchNumber", strRequestNumber);
		return strRequestNumber;

	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}

}
