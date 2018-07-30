package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.SearchApplicationDetails;
import com.mastercard.pts.integrated.issuing.pages.customer.administration.InstitutionCreationPageNew;
import com.mastercard.pts.integrated.issuing.pages.customer.navigation.CardManagementNav;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.DatePicker;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_SEARCH, CardManagementNav.L2SEARCHAPPLICATION,
		CardManagementNav.L3APPLICATIONDETAILS })
@Component
public class SearchApplicationDetailsPage extends SearchApplicationDetails{
	
	final Logger logger = LoggerFactory.getLogger(InstitutionCreationPageNew.class);
	
	@Autowired
	public DatePicker date;
	
	@Autowired
	TestContext context;
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
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement applicationNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[5]/span")
	private MCWebElement batchNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement fromDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement toDate;
	
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
	
	public String searchApplicationNumber(){
		Device device=context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(applicationNumberTxt, device.getApplicationNumber());
		WebElementUtils.pickDate(fromDate, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDate, LocalDate.now());
		clickSearchButton();		
		searchUntilBatchNumberIsDisplayed();	
		return batchNumberTxt.getText();
	}
	
	public void clickSearchButton(){
		clickWhenClickable(SearchBtn);
	}
	
	public void searchUntilBatchNumberIsDisplayed(){
		try{	
			String path = String.format("//table[@class='dataview']/..//td[count(//th[.//*[text()='%S']]/preceding-sibling::th)+1]", "Device Batch Number");
			
			if(driver().findElement(By.xpath(path)).getText().equals("-")){				
				SimulatorUtilities.wait(8000);
				clickSearchButton();
				waitForPageToLoad(driver());
				searchUntilBatchNumberIsDisplayed();
			}						
		}catch(Exception e){
			e.printStackTrace();
		}
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
	
	public void searchApplicationNumberForFileUpload()
	{
		List<String>applicationNumbers=context.get(CreditConstants.ALL_APPLICATION_NUMBERS);
		logger.info("size :{}",applicationNumbers.size());
		List<String>batchNumbersForPreProduction=new LinkedList<>();
		/*for(int i=0;i<applicationNumbers.size();i++)
		{*/
			waitForLoaderToDisappear();
			WebElementUtils.enterText(applicationNumberTxt,applicationNumbers.get(0));
			WebElementUtils.pickDate(fromDate, LocalDate.now().minusDays(1));
			WebElementUtils.pickDate(toDate, LocalDate.now());
			waitAndSearchForApplicationBatchNumberToAppear();
			batchNumbersForPreProduction.add(batchNumberTxt.getText());
		//}
		context.put(CreditConstants.ALL_BATCH_NUMBERS_PREPRODUCTION, batchNumbersForPreProduction);
	}
}
