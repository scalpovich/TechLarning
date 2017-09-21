package com.mastercard.pts.integrated.issuing.pages.collect.administration;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTARTION, treeMenuItems = { AdministrationNav.L1_RESET_PASS })
public class AdministrationResetPasswordPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(AdministrationResetPasswordPage.class);

	public void verifyUiOperationStatus() {
		logger.info("Group Creation");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList();
	}
}