package com.mastercard.pts.integrated.issuing.pages.collect.activity;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = ActivityNav.TAB_ACTIVITY, treeMenuItems = { ActivityNav.L1_CMS_TRAILS_DOWNLOAD })
public class CMSTrailsDownloadPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(CMSTrailsDownloadPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "agencycode:input:dropdowncomponent")
	private MCWebElement agencyCodeDDwn;

	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=pdate]")
	private MCWebElement pdateDPkr;

	@PageElement(findBy = FindBy.NAME, valueToFind = "countryCode:input:dropdowncomponent")
	private MCWebElement countryDDwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "citycode:input:dropdowncomponent")
	private MCWebElement cityDDwn;

	public void verifyUiOperationStatus() {
		logger.info("CMS Trails Download");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(agencyCodeDDwn), WebElementUtils.elementToBeClickable(pdateDPkr),
				WebElementUtils.elementToBeClickable(countryDDwn), WebElementUtils.elementToBeClickable(cityDDwn));
	}
}