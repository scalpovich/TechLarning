package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class SearchPanelHelpdesk.
 */
@Component
public class SearchPanelHelpdesk extends AbstractBasePage {
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement productType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement regMobileNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement clientCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement embName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement packID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:6:componentList:0:componentPanel:input:inputTextField")
	private MCWebElement callReferenceNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement firstName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement deviceNumber;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:1:componentPanel:input:dateTextField")
	private MCWebElement birthDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:4:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement lastName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:5:componentList:1:componentPanel:input:inputTextField")
	private MCWebElement CBSClientID;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:6:buttonPanel:buttonCol:searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = ".//*[@alt='Edit Record']")
	private MCWebElement editBtn;

	public MCWebElement getEditBtn() {
		return editBtn;
	}

	public void searchDevice(String productType, String deviceNumber) {
		waitForElementVisible(this.productType);
		SelectDropDownByText(this.productType, productType);
		waitForElementVisible(this.deviceNumber);
		enterText(this.deviceNumber, deviceNumber);
		waitForElementVisible(searchBtn);
		searchBtn.click();
	}

	public void searchDevice() {
		waitForElementVisible(editBtn);
		editBtn.click();
	}
}
