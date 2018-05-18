package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceUsage;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.DeviceUsagePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.workflows.MenuFlows;

@Workflow
public class DeviceUsageWorklow extends MenuFlows {

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	private static final Logger logger = LoggerFactory.getLogger(DeviceUsageWorklow.class);


	public void deviceUsageVerification(String cardNumber) {
		DeviceUsagePage page = navigator.navigateToPage(DeviceUsagePage.class);
		List<String> list = page.getDeviceTotalTransactionUsage(cardNumber);
		String expectedResult = context.get(ConstantData.TRANSACTION_AMOUNT);
		for (String actualResult : list) {
			logger.info("Actual Result :: {}", actualResult);
			logger.info("Expected Result :: {}", expectedResult);
			assertThat(actualResult, is(expectedResult));
		}
	}
	
	public void getWalletMCGUsage(){
		DeviceUsage detail = null;
		DeviceUsagePage page = navigator.navigateToPage(DeviceUsagePage.class);
		page.getWalletMCGUsage(detail);
	}
}