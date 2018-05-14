package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.AbstractCardManagementPage;
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
		// String expectedResult = "9.00";

		for (String actualResult : list) {
			logger.info("Actual Result :: {}", actualResult);
			logger.info("Expected Result :: {}", expectedResult);
			assertThat(actualResult, is(expectedResult));
		}
	}
}