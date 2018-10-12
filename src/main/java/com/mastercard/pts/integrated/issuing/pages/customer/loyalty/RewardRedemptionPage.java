package com.mastercard.pts.integrated.issuing.pages.customer.loyalty;

import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.RewardsRedemption;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

import junit.framework.Assert;

@Component
@Navigation(tabTitle = LoyaltyNav.TAB_LOYALTY, treeMenuItems = { LoyaltyNav.L1_ACTIVITY,
		LoyaltyNav.L2_REWARD_REDEMPTION })
public class RewardRedemptionPage extends AbstractBasePage {

	private static final Logger logger = LoggerFactory.getLogger(RewardRedemptionPage.class);

	@PageElement(findBy = FindBy.NAME, valueToFind = "cardNumber:input:inputTextField")
	private MCWebElement deviceNumberTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchButton")
	private MCWebElement searchBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "rowData:lytPlanCode:input:dropdowncomponent")
	private MCWebElement loyaltyPlanDdwn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "redeemButton")
	private MCWebElement redeemBtn;

	@PageElement(findBy = FindBy.NAME, valueToFind = "lrhPtsRedeemed:input:inputTextField")
	private MCWebElement pointsredeemedtxt;

	public void searchForRewardsRedemption(Device device) {
		WebElementUtils.enterText(deviceNumberTxt, device.getDeviceNumber());
		clickSearchButton();
	}

	public void selectLoyaltyPlan(RewardsRedemption rewards) {
		SimulatorUtilities.wait(1000);
		WebElementUtils.selectDropDownByVisibleText(loyaltyPlanDdwn, rewards.getLoyaltyPlan());
	}

	public void redeemScreen(RewardsRedemption rewards) {
		redeemBtn.click();
		runWithinPopup("Redemption", () -> {
			WebElementUtils.enterText(pointsredeemedtxt, rewards.getpointsToRedeem());
			clickSaveButton();
		});
	}

	public void verifyLoyaltyPointsNotRedeemed() {
		// assertFalse("Loyalty points shouldnot be available for redemption",
		// isElementPresent(redeemBtn));

		try {
			if (isElementPresent(redeemBtn)) {
				Assert.fail("Loyalty points shouldnot be available for redemption");
			}

		} catch (ElementNotVisibleException e) {
			logger.info("Redeem button is not displayed as loyalty points not available for redemption");
		}
	}

	public void verifyLoyaltyPointsRedeemed(KeyValueProvider provider) {
		Assert.assertEquals(getCellTextByColumnName(1, "Total Loyalty Points Earned"),
				provider.getString("TRANSACTION_AMOUNT"));
		Assert.assertEquals(getCellTextByColumnName(1, "Redeemed"), provider.getString("POINTS_TO_REDEEM"));
		Assert.assertEquals(getCellTextByColumnName(1, "Available for Redemption"), "0");
	}

	public void verifyLoyaltyPointsRedeemedforCumulative(KeyValueProvider provider, RewardsRedemption rewards) {
		Assert.assertEquals(getCellTextByColumnName(1, "Total Loyalty Points Earned"),
				provider.getString("MAX_AMT_EACH_PERIOD"));
		Assert.assertEquals(getCellTextByColumnName(1, "Redeemed"), rewards.getpointsToRedeem());
		Assert.assertEquals(getCellTextByColumnName(1, "Available for Redemption"), "0");
	}

	public void verifyUiOperationStatus() {
		logger.info("Reward Redemption");
		verifySearchButton("Search");
	}

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(WebElementUtils.elementToBeClickable(deviceNumberTxt));
	}
}
