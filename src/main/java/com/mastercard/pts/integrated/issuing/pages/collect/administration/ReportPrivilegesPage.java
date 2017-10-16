package com.mastercard.pts.integrated.issuing.pages.collect.administration;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;

@Component
@Navigation(tabTitle = AdministrationNav.TAB_ADMINISTARTION, treeMenuItems = { AdministrationNav.L1_PRIVILEGES, AdministrationNav.L2_REPORT_PRIVILEGES })
public class ReportPrivilegesPage extends AdministrationAbstractPage {

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(groupUserDDwn), WebElementUtils.elementToBeClickable(groupUserNameDDwn));
	}
}