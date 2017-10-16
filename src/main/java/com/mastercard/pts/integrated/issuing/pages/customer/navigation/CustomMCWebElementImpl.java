package com.mastercard.pts.integrated.issuing.pages.customer.navigation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.CustomMCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;

public class CustomMCWebElementImpl extends AbstractBasePage {
	
	
	
	public MCWebElement getCustomMCWebElement(Object obj, String text) {
		FindBy findBy = null;
		String valueoFind = null;
		String Value=null;
		Class page = obj.getClass();
		for (Field field : page.getDeclaredFields()) {
			for (Annotation a : field.getAnnotations()) {
				if (a.annotationType() == CustomMCWebElement.class) {
					CustomMCWebElement custom = (CustomMCWebElement) a;
					findBy=custom.findBy();
					valueoFind= custom.valueToFind();
					Value=valueoFind.replace("%s", text);
					getFinder().getWebDriver().findElement(By.xpath("//a"));
					
					getFinder().findOne(findBy,Value);
				}
			}
		}
		return getFinder().findOne(findBy,Value);
	}

}
