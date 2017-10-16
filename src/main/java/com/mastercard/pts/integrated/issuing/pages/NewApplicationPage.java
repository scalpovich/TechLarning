package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class NewApplicationPage extends AbstractBasePage{
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addNewApplication;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:productType:input:dropdowncomponent")
	private MCWebElement ProductType;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationType:input:dropdowncomponent")
	private MCWebElement ApplicationType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationSubType:input:dropdowncomponent")
	private MCWebElement SubApplicationType;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[2]/input")
	private MCWebElement Next;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationBatch.displayStatusFlag:input:dropdowncomponent")
	private MCWebElement CreateOpenBatch;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:applicationBatch.openedBatches:input:dropdowncomponent")
	private MCWebElement OpenedBatches;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:generateBatch")
	private MCWebElement Generate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:customerType:input:dropdowncomponent")
	private MCWebElement CustomerType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:programCode:input:dropdowncomponent")
	private MCWebElement ProgramCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next2;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:deviceType1:input:dropdowncomponent")
	private MCWebElement DeviceType;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePlanCode1:input:dropdowncomponent")
	private MCWebElement DevicePlan;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:devicePhotoIndicator1:input:dropdowncomponent")
	private MCWebElement PhotoIndicator;

	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next3;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:branchCode:input:dropdowncomponent")
	private MCWebElement BranchCode;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:title:input:dropdowncomponent")
	private MCWebElement Title;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:firstName:input:inputCodeField")
	private MCWebElement FirstName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:lastName:input:inputCodeField")
	private MCWebElement LastName;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:vipFlag:input:dropdowncomponent")
	private MCWebElement VIP;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:gender:input:dropdowncomponent")
	private MCWebElement Gender;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:nationality:input:dropdowncomponent")
	private MCWebElement Nationality;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[14]/td[4]/span/span/span/img")
	private MCWebElement BirthDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[14]/td[4]/span/span/span/span/table/thead/tr[1]/th/div/a[1]")
	private MCWebElement previousBirthDate;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[3]/td/div/table[1]/tbody/tr[14]/td[4]/span/span/span/span/table/tbody/tr[2]/td[3]/a")
	private MCWebElement selectBirthDate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "view:married:input:dropdowncomponent")
	private MCWebElement MaritialStatus;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next4;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:preferredMailingAddress:input:dropdowncomponent")
	private MCWebElement PreferredMailingAddress;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine1:input:inputTextField")
	private MCWebElement AddressLine1;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentAddressLine2:input:inputTextField")
	private MCWebElement AddressLine2;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentZipCode:input:inputTextField")
	private MCWebElement PostalCode;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officeIsdCode:input:dropdowncomponent")
	private MCWebElement MobileNumberCountryCode;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officeMobileNumber:input:inputTextField")
	private MCWebElement MobileNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:currentPhoneNumber1:input:inputTextField")
	private MCWebElement CurrentPhoneNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "view:officePhoneNumber2:input:inputTextField")
	private MCWebElement OfficePhoneNumber;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next5;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next6;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next7;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next8;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next9;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttons:next")
	private MCWebElement Next10;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//div[2]/div/form/table/tbody/tr/td[2]/table/tbody/tr[4]/td/span/table/tbody/tr/td/span[4]/input")
	private MCWebElement Finish;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;
	
	public void addnewapplication()
	{
		addNewApplication.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		
		
		ProductType.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.ProductType"));
		CustomUtils.ThreadDotSleep(1000);
		ApplicationType.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.ApplicationType"));
		CustomUtils.ThreadDotSleep(1000);
		SubApplicationType.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.SubApplicationType"));
		CustomUtils.ThreadDotSleep(1000);
		
		Next.click();
		CustomUtils.ThreadDotSleep(1000);
		CreateOpenBatch.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.CreateOpenBatch"));
		CustomUtils.ThreadDotSleep(1000);
		Generate.click();
		CustomUtils.ThreadDotSleep(1000);
		Next.click();
		CustomUtils.ThreadDotSleep(1000);
		CustomerType.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.CustomerType"));
		CustomUtils.ThreadDotSleep(1000);
		//ProgramCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.ProgramCode"));
		ProgramCode.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		Next.click();
		CustomUtils.ThreadDotSleep(1000);
		//DeviceType.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.DeviceType"));
		DeviceType.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		//DevicePlan.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.DevicePlan"));
		DevicePlan.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		PhotoIndicator.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.PhotoIndicator"));
		CustomUtils.ThreadDotSleep(1000);
		Next.click();
		CustomUtils.ThreadDotSleep(1000);
		//BranchCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.BranchCode"));
		BranchCode.getSelect().selectByIndex(1);
		CustomUtils.ThreadDotSleep(1000);
		Title.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.Title"));
		CustomUtils.ThreadDotSleep(1000);
		//FirstName.sendKeys(env.getProperty("is.dinners.newapplication.FirstName"));
		FirstName.sendKeys(applicationfirstname);
		//LastName.sendKeys(env.getProperty("is.dinners.newapplication.LastName"));
		LastName.sendKeys(applicationlastname);
		VIP.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.VIP"));
		CustomUtils.ThreadDotSleep(1000);
		Gender.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.Gender"));
		CustomUtils.ThreadDotSleep(1000);
		Nationality.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.Nationality"));
		CustomUtils.ThreadDotSleep(1000);
		BirthDate.click();
		CustomUtils.ThreadDotSleep(1000);
		for(int i=0 ; i < 244 ; i++)
		{
			previousBirthDate.click();
			//CustomUtils.ThreadDotSleep(100);
		}
		
		selectBirthDate.click();
		CustomUtils.ThreadDotSleep(2000);
		MaritialStatus.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.MaritialStatus"));
		CustomUtils.ThreadDotSleep(2000);
		Next.click();
		CustomUtils.ThreadDotSleep(2000);
		//PreferredMailingAddress.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.PreferredMailingAddress"));
		CustomUtils.ThreadDotSleep(1000);
		AddressLine1.sendKeys(env.getProperty("is.dinners.newapplication.AddressLine1"));
		CustomUtils.ThreadDotSleep(1000);
		PostalCode.sendKeys(env.getProperty("is.dinners.newapplication.PostalCode"));
		CustomUtils.ThreadDotSleep(3000);
		AddressLine2.sendKeys(env.getProperty("is.dinners.newapplication.AddressLine1"));
		CustomUtils.ThreadDotSleep(1000);
		
		/*WebElement webElement2 = getFinder().getWebDriver().findElement(By.name("view:officeIsdCode:input:dropdowncomponent")); 
		webElement2.sendKeys(Keys.TAB);*/
				
		MobileNumberCountryCode.getSelect().selectByVisibleText(env.getProperty("is.dinners.newapplication.MobileNumberCountryCode"));
		CustomUtils.ThreadDotSleep(1000);
		//getFinder().getWebDriver().findElement(By.name("view:officeMobileNumber:input:inputTextField")).sendKeys(Keys.TAB);
		
		/*MobileNumber.sendKeys(env.getProperty("is.dinners.newapplication.MobileNumber"));
		CustomUtils.ThreadDotSleep(1000);*/
		
		
		//MobileNumber.clearField();
		//CustomUtils.ThreadDotSleep(1000);
		
		//MobileNumber.sendKeys(Keys.TAB);
		/*WebElement webElement = getFinder().getWebDriver().findElement(By.name("view:officeMobileNumber:input:inputTextField"));
		webElement.sendKeys(Keys.TAB);
		webElement.sendKeys(Keys.ENTER);*/
		
		//MobileNumber.sendKeys(env.getProperty("is.dinners.newapplication.MobileNumber"));
		
		//------
		//getFinder().getWebDriver().findElement(By.name("view:officeMobileNumber:input:inputTextField")).clear();
		//CustomUtils.ThreadDotSleep(1000);
		getFinder().getWebDriver().findElement(By.name("view:officeMobileNumber:input:inputTextField")).sendKeys(Keys.BACK_SPACE);
		CustomUtils.ThreadDotSleep(1000);
		getFinder().getWebDriver().findElement(By.name("view:officeMobileNumber:input:inputTextField")).sendKeys("12345678");
		CustomUtils.ThreadDotSleep(1000);
		
		//------
		/*MobileNumber.sendKeys(env.getProperty("is.dinners.newapplication.MobileNumber"));
		CustomUtils.ThreadDotSleep(1000);
		OfficePhoneNumber.sendKeys(env.getProperty("is.dinners.newapplication.PhoneNumber"));
		CustomUtils.ThreadDotSleep(1000);
		MobileNumber.sendKeys(env.getProperty("is.dinners.newapplication.MobileNumber"));
		CustomUtils.ThreadDotSleep(1000);*/
		
		//------
		/*WebElement element = getFinder().getWebDriver().findElement(By.name("view:officeMobileNumber:input:inputTextField"));
		new Actions(getFinder().getWebDriver()).moveToElement(element).perform();
		new Actions(getFinder().getWebDriver()).moveToElement(element).sendKeys("123123123");*/
		
		CustomUtils.ThreadDotSleep(2000);
		
		Next.click();
		CustomUtils.ThreadDotSleep(1000);
		Next.click();						//	On 'Occupation details' Page
		CustomUtils.ThreadDotSleep(1000);
		Next.click();						//	On 'Bank details
		CustomUtils.ThreadDotSleep(1000);
		Next.click();						//	On 'Other Information details
		CustomUtils.ThreadDotSleep(1000);
		Next.click();						//	On 'Client Extra details
		CustomUtils.ThreadDotSleep(1000);
		Next.click();						//	On 'Device Extra details
		CustomUtils.ThreadDotSleep(1000);
		/*Next.click();						
		CustomUtils.ThreadDotSleep(1000);*/
		
		
		Finish.click();						//	On 'Wallet Extra details
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}


}
