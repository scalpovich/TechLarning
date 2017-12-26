package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditCardCreditPlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_PROGRAM_SETUP,
		CardManagementNav.L2_CREDIT_CARD_BILLING,
		CardManagementNav.L3_CREDIT_PLAN})
public class CreditPlanPage extends AbstractBasePage {
    @Autowired
    KeyValueProvider provider;
    @Autowired
    CreditCardCreditPlan creditCardCreditPlan;
    
	private static final Logger logger = LoggerFactory.getLogger(CreditPlanPage.class);
    private static final String CREDITPLAN_FRAME="Add Credit Plan";
    
   @PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileCode]")
	private MCWebElement profileCode;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWording]")
	private MCWebElement profileWording;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=profileWordAbrv]")
	private MCWebElement profileWordAbrv;
    @PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addCreditPlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileCode:input:inputTextField")
	private MCWebElement creditPlanCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWording:input:inputTextField")
	private MCWebElement description;

	@PageElement(findBy = FindBy.NAME, valueToFind = "profileWordAbrv:input:inputTextField")
	private MCWebElement abbreviation;

	@PageElement(findBy = FindBy.NAME, valueToFind = "basePaymentDate:input:dropdowncomponent")
	private MCWebElement paymentDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayPaymentDate:input:inputTextField")
	private MCWebElement paymentDateDays;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidDate:input:dropdowncomponent")
	private MCWebElement unpaidDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "nbdayUnpaidDate:input:inputTextField")
	private MCWebElement unpaidDateDays;

	@PageElement(findBy = FindBy.NAME, valueToFind = "transactionFeePlan:input:dropdowncomponent")
	private MCWebElement transactionRulePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "unpaidPerm:input:inputAmountField")
	private MCWebElement minimumDue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "totalUnpaidPerm:input:inputAmountField")
	private MCWebElement totalDue;

	@PageElement(findBy = FindBy.NAME, valueToFind = "paymentPriorityPlan:input:dropdowncomponent")
	private MCWebElement paymentPriorityPlan;
    @PageElement(findBy = FindBy.NAME, valueToFind = "overdrawnPerm:input:inputTextField")
	private MCWebElement allowedPercentage;
	@PageElement(findBy = FindBy.NAME, valueToFind = "currencyCode:input:dropdowncomponent")
	private MCWebElement currencyddwn;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='dataview-div']/table//tbody/tr[1]/td/span/child::a/span")
	private MCWebElement uniqueAddedCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='dataview-div']/table//tbody/tr[1]/td/span[string-length( text()) > 2]")
	private MCWebElements otherValuesInFirstRow;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(@class,'mandatoryFlag')]")
	private MCWebElement mandatoryValues;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(@class,'mandatoryFlag')]/parent::span/parent::td/preceding-sibling::td[@class='displayName']/span")
	private MCWebElement mandatoryValuesHeaders;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='headers']/th[@class='wicket_orderNone']/a/span")
	private MCWebElements tableHeaders;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName wrap-search']")
	private MCWebElements filterHeaders;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='top']//div[@id='searchForm']//table/tbody/tr//td[@class='field']/child::input|select")
	private MCWebElements commonXpathForFilter;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='searchButton']//input")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]//img[@alt='Edit Record']")
	private MCWebElements editRecord;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr")
	private MCWebElements firstRow;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Description :']/parent::*/following-sibling::td//span/*")
	private MCWebElements descriptionTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='w_captionText']")
	private MCWebElements frameSwitch;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName']/span[contains(text(),'Description')]/parent::*/following-sibling::*/span/input")
	private MCWebElement innerDescriptionTxt;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Description')]/following-sibling::td/following-sibling::td/input")
	private MCWebElement descriptionFilterTxt;
	
        public void addcreditplan() {
		CreditCardCreditPlan.createWithProvider(provider);
		clickWhenClickable(addCreditPlan);
		switchToIframe(CREDITPLAN_FRAME);
		WebElementUtils.enterText(creditPlanCode, CreditCardCreditPlan.createWithProvider(provider).getCreditPlanCode());
		WebElementUtils.enterText(description, CreditCardCreditPlan.createWithProvider(provider).getDescription());
		WebElementUtils.enterText(abbreviation, CreditCardCreditPlan.createWithProvider(provider).getAbbreviation());
		WebElementUtils.selectDropDownByIndex(paymentDate,1);
		waitForElementEnabled(paymentDateDays);
		WebElementUtils.enterText(paymentDateDays,CreditCardCreditPlan.createWithProvider(provider).getPaymentDueDateDays());
		WebElementUtils.selectDropDownByIndex(unpaidDate,1);
		waitForElementEnabled(unpaidDateDays);
		WebElementUtils.enterText(unpaidDateDays,CreditCardCreditPlan.createWithProvider(provider).getUnpaidDateDays());
		WebElementUtils.selectDropDownByIndex(transactionRulePlan, 1);
		WebElementUtils.selectDropDownByIndex(currencyddwn, 1);
		WebElementUtils.enterText(minimumDue, CreditCardCreditPlan.createWithProvider(provider).getMinimumDue());
		WebElementUtils.enterText(totalDue, CreditCardCreditPlan.createWithProvider(provider).getTotalDue());
		WebElementUtils.selectDropDownByIndex(paymentPriorityPlan, 1);
		WebElementUtils.enterText(allowedPercentage, CreditCardCreditPlan.createWithProvider(provider).getAllowedPercentage());
		clickSaveButton();
		
	}
	
	public void verifyUiOperationStatus() {
		logger.info("Credit Plan");
		
		verifyUiOperation("Add Credit Plan");
	}
	
	public Map<String,String>mandatoryValuesInPage()
	{
		Map<String,String>mandatoryValues=new LinkedHashMap<>();
		
		return mandatoryValues;
		
	}
	
	public Map<String,String> valuesInFirstRow() {
		logger.info("Credit Plan");
		Map<String,String>valuesInFirstRowAndTheirHeaders=new LinkedHashMap<>();
		
		for(int i=0;i<tableHeaders.getElements().size();i++)
		{
			if(i==0)
		      valuesInFirstRowAndTheirHeaders.put(tableHeaders.getElements().get(i).getText(), uniqueAddedCode.getText());
			else
			{
			 valuesInFirstRowAndTheirHeaders.put(tableHeaders.getElements().get(i).getText(), otherValuesInFirstRow.getElements().get(i-1).getText());
			
			}
		}
		return valuesInFirstRowAndTheirHeaders;
	}
   public void enterFilterValuesBasedOnRecordCreated()
   {
	   LinkedList<MCWebElement>linkList=new LinkedList<>();
	   LinkedList<MCWebElement>linkListHeaders=new LinkedList<>();
	   for(int i=0;i<commonXpathForFilter.getElements().size();i++)
	   {
	   linkList.add(commonXpathForFilter.getElements().get(i));
	   }
	   for(int i=0;i<filterHeaders.getElements().size();i++)
	   {
		   linkListHeaders.add(filterHeaders.getElements().get(i));
	   }
	   for (Map.Entry<String, String> entry : valuesInFirstRow().entrySet()) {
		   for(int i=0;i<linkListHeaders.size();i++)
		   {
			   if(linkListHeaders.get(i).getText().equals(entry.getKey()))
			   {
				   if(linkList.get(i).getTagName().equals("input"))
					   {
						   WebElementUtils.enterText(linkList.get(i), entry.getValue());
						   break;
					   }
					   else if(linkList.get(i).getTagName().equals("select"))
					   {
						   WebElementUtils.selectDropDownByVisibleText(linkList.get(i), entry.getValue());
						   break;
					   }
				  }
		   }
		   
	   }
	   clickWhenClickable(searchBtn);
	   Assert.assertEquals("Added Record is displayed based on filters",firstRow.getElements().size(), 1);
   }
   public void editFunctionalityCheck()
   {
	   LinkedList<MCWebElement>linkListDescription=new LinkedList<>();
	   clickWhenClickable(editRecord.getElements().get(editSize()-1));
	   switchToIframe(frameSwitch.getElements().get(frames()-1).getText());
	   for(int i=0;i<descriptionTxt.getElements().size();i++)
	   {
		linkListDescription.add(descriptionTxt.getElements().get(i));
	   }
	   if(!linkListDescription.get(0).getTagName().equals("span"))
	   {
	   WebElementUtils.enterText(linkListDescription.get(0),ConstantData.GENERIC_DESCRIPTION+CustomUtils.randomNumbers(3));
	   String updatedValue=linkListDescription.get(0).getAttribute("value");
	   clickSaveButton();
	   WebElementUtils.enterText(descriptionFilterTxt,"");
	   clickWhenClickable(searchBtn);
	   Assert.assertEquals("Added Record is displayed based on filters",firstRow.getElements().size(), 1);
	   
	   for (Map.Entry<String, String> entry : valuesInFirstRow().entrySet()) {
		   if(entry.getKey().equals("Description"))
		   {
		 Assert.assertEquals("Edit operation is Successfull", updatedValue, entry.getValue());
		   }
	   }
	   }
	   else
	   {
		 clickWhenClickable(editRecord.getElements().get(editSize()-1));
		  SwitchToDefaultFrame();
		  switchToIframe("Plan Detail");
		 WebElementUtils.enterText(innerDescriptionTxt,ConstantData.GENERIC_DESCRIPTION+CustomUtils.randomNumbers(3));
		 String updatedValue=innerDescriptionTxt.getAttribute("value");
		 clickSaveButton();
		 switchToIframe(frameSwitch.getElements().get(frames()-1).getText());
		 for (Map.Entry<String, String> entry : valuesInFirstRow().entrySet()) {
			   if(entry.getKey().contains("Description") )
			   {
		        Assert.assertEquals("Edit operation is Successfull", updatedValue, entry.getValue());
				 
			   }
		   }
		 clickSaveButton();
	   }
   }
private int editSize() {
  return editRecord.getElements().size();
}
   private int frames() {
	frameSwitch.getElements();
	return frameSwitch.getElements().size();
	 }
	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(profileCode),
				WebElementUtils.elementToBeClickable(profileWording),
				WebElementUtils.elementToBeClickable(profileWordAbrv)
				
				);
	}
}
