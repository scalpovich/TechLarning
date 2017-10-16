package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.InstitutionCreationPageNew;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1SEARCH, CardManagementNav.L2SEARCHAPPLICATION,
		CardManagementNav.L3APPLICATIONDETAILS })
@Component
public class SearchApplicationDetailsPage extends SearchApplicationDetails{
	
	final Logger logger = LoggerFactory.getLogger(InstitutionCreationPageNew.class);
	
	@Autowired
	public DatePicker date;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='firstName']")
	private MCWebElement firstName;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='lastName']")
	private MCWebElement lastName;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/following::img[1]")
	private MCWebElement Cal_From_Field;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/following::img[2]")
	private MCWebElement Cal_To_Field;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@value='Search']")
	private MCWebElement SearchBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/..//td[contains(@class,'today')]/a")
	private MCWebElement selectFromDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/..//td[contains(@class,'today')]/a")
	private MCWebElement selectToDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody//tr")
	private MCWebElements DataTable;
	
	
	
		
	public void enterFirstName(SearchApplicationDetails search){
		enterText(firstName, search.getFirstName());
	}
	
	public void enterLastName(SearchApplicationDetails search){
		enterText(lastName, search.getLastName());
	}
	
	public void selectFromDate(SearchApplicationDetails search){
		date.setDate(search.getFromDate());
	}
	
	public void selectToDate(SearchApplicationDetails search){
		date.setDate(search.getToDate());
	}
	
	public void clickSearchButton(){
		clickWhenClickable(SearchBtn);
	}
	
	
	public void searchNewApplication(SearchApplicationDetails search){
		enterFirstName(search);
		enterLastName(search);
		selectFromDate(search);
		selectToDate(search);
		clickSearchButton();
		
	}
	
	public void verifyNewApplication(){
		for(MCWebElement element : DataTable.getElements()){
			if(element.getText().contains("abc"));
			logger.info("New application processed successfully");
		}
	}
}
