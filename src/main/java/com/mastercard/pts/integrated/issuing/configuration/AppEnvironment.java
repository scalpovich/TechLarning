package com.mastercard.pts.integrated.issuing.configuration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.BeanFactoryAnnotationUtils;
import org.springframework.stereotype.Component;

@Component
public class AppEnvironment {
	
	@Autowired
	private BeanFactory beanFactory;

	public Portal getPortalByType(String portalType) {
		return BeanFactoryAnnotationUtils.qualifiedBeanOfType(beanFactory, Portal.class, portalType);
	}
}
