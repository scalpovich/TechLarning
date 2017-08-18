package com.mastercard.pts.integrated.issuing.pages.navigation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Page Object Annotation - allows to navigate to a page by pageObject.class
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface Navigation {
	/**
	 * tab title
	 */
	public String tabTitle();

	/**
	 * array of menuIDs, empty by default
	 */
	public String[] treeMenuItems() default {};
}
