package com.mastercard.pts.integrated.issuing.pages;


import java.util.function.Supplier;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;
import com.mastercard.testing.mtaf.bindings.page.AbstractPage;

/**
 * Class allows to navigate through site
 */
@Component
public class PageObjectFactory {
	
	private static final Logger logger = Logger.getLogger(PageObjectFactory.class);
	
	@Autowired
	private BeanFactory beanFactory;
	
	/**
	 * Method creates page object of specified class
	 * 
	 * @param pageClass
	 * @return page object 
	 */
	public <T extends AbstractPage> T getPage(Class<T> pageClass) {
		return initPageObject(() -> (T) beanFactory.getBean(pageClass));
	}
	
	/**
	 * Method creates page object by page's name. 
	 * Page's name is equals to page object name, but of "Page" at the end
	 * E.g page name  = "Institution System Code" - page object name is InstitutionSystemCodePage
	 * @param pageName
	 * @return page object 
	 */
	@SuppressWarnings("unchecked")
	public <T extends AbstractPage> T getPage(String pageName) {
		String beanName = StringUtils.capitalize(pageName.replaceAll("\\s+","")) + "Page";
		return initPageObject(() -> (T) beanFactory.getBean(beanName));
	}
	
	private <T extends AbstractPage> T initPageObject(Supplier<T> pageSupplier) {
		T page = null;
		try {
			page = pageSupplier.get();
		} catch (Exception e) {
			logger.error("Fail to create page object: " + e.getMessage());
			throw MiscUtils.propagate(e);
		}
		return page;
	}
}
