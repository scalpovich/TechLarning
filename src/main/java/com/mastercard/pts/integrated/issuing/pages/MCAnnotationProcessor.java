package com.mastercard.pts.integrated.issuing.pages;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementFinderProvider;
import com.mastercard.testing.mtaf.bindings.element.ElementProxyHandler;
import com.mastercard.testing.mtaf.bindings.element.MCEditableTwoColumnsTable;
import com.mastercard.testing.mtaf.bindings.element.MCTableElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

public class MCAnnotationProcessor {
	
	private MCAnnotationProcessor() {}
	
	public static void initializeSuper(Object instance, ElementFinderProvider finderProvider) {
		Class<?> clazz = instance.getClass().getSuperclass();
		while (!clazz.equals(Object.class)) {
			initializeClass(instance, clazz, finderProvider);
			clazz = clazz.getSuperclass();
		}
	}

	private static void initializeClass(Object instance, Class<?> clazz, ElementFinderProvider finderProvider) {
		Field[] fields =  clazz.getDeclaredFields();
		
		for (Field f : fields) {
			if (f.isAnnotationPresent(PageElement.class)) {
				PageElement pageElement = f.getAnnotation(PageElement.class);
				
				Object valueToInject = null;
				if (f.getType().equals(MCWebElement.class)) {
					valueToInject = Proxy.newProxyInstance(MCWebElement.class.getClassLoader(),
							new Class[] { MCWebElement.class }, 
							new ElementProxyHandler(f, pageElement, instance, finderProvider));
					
				} else if (f.getType().equals(MCWebElements.class)) {
					valueToInject = Proxy.newProxyInstance(MCWebElements.class.getClassLoader(),
							new Class[] { MCWebElements.class }, 
							new ElementProxyHandler(f, pageElement, instance, finderProvider));
					
				} else if (f.getType().equals(MCTableElement.class)) {
					valueToInject = Proxy.newProxyInstance(MCTableElement.class.getClassLoader(),
							new Class[] { MCTableElement.class }, 
							new ElementProxyHandler(f, pageElement, instance, finderProvider));
				} else if (f.getType().equals(MCEditableTwoColumnsTable.class)) {
					valueToInject = Proxy.newProxyInstance(MCEditableTwoColumnsTable.class.getClassLoader(),
							new Class[] { MCEditableTwoColumnsTable.class }, 
							new ElementProxyHandler(f, pageElement, instance, finderProvider));
				}
				
				try {
					f.setAccessible(true);
					f.set(instance, valueToInject);
				} catch (IllegalAccessException e) {
					throw MiscUtils.propagate(e);
				}
			}
		}
	}
}
