package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.domain.CreditCardPlans;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class AbstractCreditPage extends AbstractBasePage {
	@Autowired
	CreditCardPlans creditCardPlans;
	private static final Logger logger = LoggerFactory.getLogger(AbstractCreditPage.class);
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='dataview-div']/table//tbody/tr[1]/td/span/child::a/span")
	private MCWebElement uniqueAddedCode;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='dataview-div']/table//tbody/tr[1]/td/span[string-length( text()) > 2]")
	private MCWebElements otherValuesInFirstRow;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(@class,'mandatoryFlag')]")
	private MCWebElements mandatoryValues;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(@class,'mandatoryFlag')]/parent::span/parent::td/preceding-sibling::td[@class='displayName']/span")
	private MCWebElement mandatoryValuesHeaders;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='headers']/th[@class='wicket_orderNone']/a/span")
	private MCWebElements tableHeaders;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName wrap-search']")
	private MCWebElements filterHeaders;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[@class='top']//div[@id='searchForm']//table/tbody/tr//td[@class='field']/child::*")
	private MCWebElements commonXpathForFilter;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='searchButton']//input")
	private MCWebElement searchBtn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]//img[@alt='Edit Record']")
	private MCWebElements editRecord;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr")
	private MCWebElements firstRow;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody/tr/td")
	private MCWebElements firstRowColumnValues;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[text()='Description :']/parent::*/following-sibling::td//span/*")
	private MCWebElements descriptionTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@class='w_captionText']")
	private MCWebElements frameSwitch;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName']/span[contains(text(),'Description')]/parent::*/following-sibling::*/span/input")
	private MCWebElement innerDescriptionTxt;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[contains(text(),'Description')]/following-sibling::td/following-sibling::td/input")
	private MCWebElement descriptionFilterTxt;
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@class='displayName']/following-sibling::td//li[contains(text(),'required')]/../../../.././preceding::td[1]/span")
	private MCWebElements allLabelsMandatoryField;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tbody/tr[@class!='headers']/td/span/a/img[@alt='Delete Record']")
	private MCWebElement deleteRecord;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//tr[@class='headers']/following-sibling::tr//span")
	private MCWebElement noRecordsFound;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']/tbody")
	private MCWebElement tableRows;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@type='submit' or @name='save']")
	private MCWebElement saveOrDetailsOrSearchBtn;
	
	public void saveOrDetailsOrSearchClick()
	{
		clickWhenClickable(saveOrDetailsOrSearchBtn);
	}
	public List<String> mandatoryLabels() {
		
		LinkedList<String>mandatoryFieldsLabels=new LinkedList<>();
		 for(int i=0;i<allLabelsMandatoryField.getElements().size();i++)
		 {
             mandatoryFieldsLabels.add(allLabelsMandatoryField.getElements().get(i).getText());
			 
		 }
		return mandatoryFieldsLabels;
	}
	public List<MCWebElement> mandatoryFields() {
		
    	List<MCWebElement>mandatoryField=new LinkedList<>();
		 for(int i=0;i<mandatoryValues.getElements().size();i++)
		 {
			 mandatoryField.add(mandatoryValues.getElements().get(i));
			 
		 }
		return mandatoryField;
	}
	public Map<String, String> mandatoryValuesWithLabels(List<MCWebElement>fields,List<String>labels) {
		Map<String,String>mandatoryLabelsAndValues=new LinkedHashMap<>();
		List<MCWebElement>mandateFields=fields;
		List<String>mandatoryFieldsLabels=labels;
		if(mandateFields.size()==mandatoryFieldsLabels.size())
		{
		 for(int i=0;i<mandatoryFieldsLabels.size();i++)
		 {
			 if(mandateFields.get(i).getTagName().equals("input"))
			 {
				 String[] field=mandatoryFieldsLabels.get(i).split(":");
		     mandatoryLabelsAndValues.put(field[0].trim(), mandateFields.get(i).getAttribute("value"));
					
			 }
			 else if(mandateFields.get(i).getTagName().equals("select"))
			 {
				 String[] field=mandatoryFieldsLabels.get(i).split(":");
				 mandatoryLabelsAndValues.put(field[0].trim(), mandateFields.get(i).options().getElements().get(1).getText());
			 }
		 }
		
		}
		return mandatoryLabelsAndValues;
	}
	  public void searchFunctionalityCheck()
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
		   for (Map.Entry<String, String> entry : creditCardPlans.getMandatoryValuesWithLabels().entrySet()) {
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
		   logger.info("Row values after search: {}", tableRows.getText());
		   Assert.assertEquals("Added Record is displayed based on filter Values",firstRow.getElements().size(), 1);
		  
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
		   WebElementUtils.enterText(linkListDescription.get(0),"");	   
		   WebElementUtils.enterText(linkListDescription.get(0),CustomUtils.randomAlphaNumeric(5));
		   String updatedValue=linkListDescription.get(0).getAttribute("value");
		   clickSaveButton();
		   WebElementUtils.enterText(descriptionFilterTxt,"");
		   clickSearchButton();
		   for(int i=0;i<tableHeaders.getElements().size();i++)
		   {
			   if(tableHeaders.getElements().get(i).getText().equals("Description"))
			   {
				   logger.info("EditedDescription: {}", firstRowColumnValues.getElements().get(i).getText());
				   logger.info("Added Record is displayed based on filters"+firstRowColumnValues.getElements().get(i).getText(),updatedValue);
				   Assert.assertEquals("Added Record is displayed based on filters",firstRowColumnValues.getElements().get(i).getText(),updatedValue);
			   }
		   }
		 }
		   else
		   {
			   
			 clickWhenClickable(editRecord.getElements().get(editSize()-1));
			  SwitchToDefaultFrame();
			  switchToIframe("Plan Detail");
			  WebElementUtils.enterText(innerDescriptionTxt,"");
			 WebElementUtils.enterText(innerDescriptionTxt,CustomUtils.randomNumbers(5));
			 String updatedValue=innerDescriptionTxt.getAttribute("value");
			 clickSaveButton();
			 switchToIframe(frameSwitch.getElements().get(frames()-1).getText());
			 for(int i=0;i<tableHeaders.getElements().size();i++)
			   {
				   if(tableHeaders.getElements().get(i).getText().contains("Description"))
				   {
					   logger.info("EditedDescription: {}", firstRowColumnValues.getElements().get(i).getText());
					   logger.info("Added Record is displayed based on filters in innerframe"+firstRowColumnValues.getElements().get(i).getText(),updatedValue);
					   Assert.assertEquals("Added Record is displayed based on filters in innerframe",firstRowColumnValues.getElements().get(i).getText(),updatedValue);
				   }
			   }
			 clickSaveButton();
			waitForPageToLoad(getFinder().getWebDriver());
		   
		   }
		 
	   }
	public void deleteFunctionalityCheck() {
		if (isDeleteColumnPresent()) {
			waitForPageToLoad(getFinder().getWebDriver());
				deleteFirstRecord();
				Alert alert = driver().switchTo().alert();
				alert.accept();
				clickWhenClickable(searchBtn);
				CustomUtils.ThreadDotSleep(5000);
				logger.info("Row size after deletion: {}", tableRows.getText());
				Assert.assertEquals("Added Record is deleted",tableRows.getText(),"");
			}
	}

	  private int editSize() {
		  return editRecord.getElements().size();
		}
		   private int frames() {
			frameSwitch.getElements();
			return frameSwitch.getElements().size();
			 }
}
