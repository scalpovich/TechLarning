package com.mastercard.pts.integrated.issuing.pages.navigation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomMCWebElement {
	
	FindBy findBy() default FindBy.NAME;
	
	String valueToFind() default "";
	
}
