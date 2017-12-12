package com.mastercard.pts.integrated.issuing.pages.customer.helpdesk;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

//TODO: Auto-generated Javadoc
/**
 * @author E070234, E074127 The Class SearchPanelHelpdesk.
 */
@Component
public class SearchPanelHelpdeskPage extends AbstractBasePage {
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
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:inputCodeField")
	private MCWebElement firstNameInput;
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
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tr//following-sibling::td[7]/span")
	private MCWebElement normalStatus;
	
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
	   //getFinder().getWebDriver().findElement(By.xpath(".//*[@alt='Edit Record']")).click();
	}

	public void clickEditBtn() {
		waitForElementVisible(editBtn);
		editBtn.click();
	}
	public void clickSearchBtn() {
		waitForElementVisible(searchBtn);
		searchBtn.click();
	}
	public String searchDeviceUsingName(String productType, String name) {
		waitForElementVisible(this.productType);
		SelectDropDownByText(this.productType, productType);
		enterText(this.firstNameInput, String.valueOf(name));
		waitForElementVisible(searchBtn);
		searchBtn.click();
		String[]a=normalStatus.getText().split("\\[");
		System.out.println("status:"+a[0].trim());
		return a[0].trim();
	}
}
