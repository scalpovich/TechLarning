package com.mastercard.pts.integrated.issuing.pages;

import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
public class DeviceCardPackTemplatePage extends AbstractBasePage{
	
//	------------- Card Management > Institution Parameter Setup > Institution Currency [ISSS05]
	
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addDeviceCardPackTemplate;

	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateType:input:dropdowncomponent")
	private MCWebElement TemplateType;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:templateDesc:input:inputTextField")
	private MCWebElement Description;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "firstContainer:cardNumberLength:input:inputTextField")
	private MCWebElement TemplateLength;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescBin:input:dropdowncomponent")
	private MCWebElement Field1;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLenBin:input:inputTextField")
	private MCWebElement Length1;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc2:input:dropdowncomponent")
	private MCWebElement Field2;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen2:input:inputTextField")
	private MCWebElement Length2;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc3:input:dropdowncomponent")
	private MCWebElement Field3;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDescLen3:input:inputTextField")
	private MCWebElement Length3;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "mainContainer:trnsTypeDesc4:input:dropdowncomponent")
	private MCWebElement Field4;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:submitTemplate")
	private MCWebElement submit;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "buttonContainer:save")
	private MCWebElement save;
	
	public void addcardpackidtemplate()
	{
		addDeviceCardPackTemplate.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		
		TemplateType.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.TemplateType"));
		CustomUtils.ThreadDotSleep(2000);
		Description.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Description"));
		CustomUtils.ThreadDotSleep(2000);
		TemplateLength.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.TemplateLength"));
		CustomUtils.ThreadDotSleep(2000);
		Field1.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.Field1"));
		CustomUtils.ThreadDotSleep(2000);
		Length1.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Length1"));
		CustomUtils.ThreadDotSleep(2000);
		Field2.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.Field2"));
		CustomUtils.ThreadDotSleep(2000);
		Length2.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Length2"));
		CustomUtils.ThreadDotSleep(2000);
		Field3.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.Field3"));
		CustomUtils.ThreadDotSleep(2000);
		Length3.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Length3"));
		CustomUtils.ThreadDotSleep(2000);
		Field4.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.Field4"));
		CustomUtils.ThreadDotSleep(2000);
		
		submit.click();
		CustomUtils.ThreadDotSleep(3000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		
	}
	
	public void adddevicetemplate()
	{
		addDeviceCardPackTemplate.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().frame("_wicket_window_3");
		
		TemplateType.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.TemplateType2"));
		CustomUtils.ThreadDotSleep(1000);
		Description.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Description2"));
		CustomUtils.ThreadDotSleep(1000);
		TemplateLength.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.TemplateLength2"));
		CustomUtils.ThreadDotSleep(2000);
		Field1.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.Field1_2"));
		CustomUtils.ThreadDotSleep(2000);
		Length1.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Length1_2"));
		CustomUtils.ThreadDotSleep(2000);
		Field2.getSelect().selectByVisibleText(env.getProperty("is.dinners.devicecardpacktemplate.Field2_2"));
		CustomUtils.ThreadDotSleep(2000);
		Length2.sendKeys(env.getProperty("is.dinners.devicecardpacktemplate.Length2_2"));
		CustomUtils.ThreadDotSleep(2000);
		
		
		submit.click();
		CustomUtils.ThreadDotSleep(2000);
		save.click();
		CustomUtils.ThreadDotSleep(2000);
		getFinder().getWebDriver().switchTo().defaultContent();
		
	}
	

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
