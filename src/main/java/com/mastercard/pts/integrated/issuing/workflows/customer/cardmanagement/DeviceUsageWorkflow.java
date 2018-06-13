package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.apache.commons.beanutils.BeanUtils;
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
public class DeviceUsageWorkflow extends MenuFlows {

	@Autowired
	private Navigator navigator;

	@Autowired
	private TestContext context;

	private static final Logger logger = LoggerFactory.getLogger(DeviceUsageWorkflow.class);

	private static final String TOTAL = "total";

	private static final String TRANSACTION = "transaction";

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

	public Optional<Map<String, String>> getWalletMCGUsage(DeviceUsage deviceUsage) {
		DeviceUsagePage page = navigator.navigateToPage(DeviceUsagePage.class);
		return page.getWalletMCGUsage(deviceUsage);
	}

	public void deviceUsageVerification(String cardNumber, String tab, DeviceUsage deviceUsage) {
		DeviceUsagePage page = navigator.navigateToPage(DeviceUsagePage.class);
		List<String> list = new ArrayList<>();

		if (tab.equalsIgnoreCase(TRANSACTION)) {
			list.clear();
			list = page.getDeviceTransactionUsage(cardNumber);
			String expectedResult = context.get(ConstantData.TRANSACTION_AMOUNT);
			for (String actualResult : list) {
				logger.info("Actual Result TRANSACTION :: {}", actualResult);
				logger.info("Expected Result TRANSACTION :: {}", expectedResult);
				assertThat(actualResult, is(expectedResult));
			}
		} else if (tab.equalsIgnoreCase(TOTAL)) {
			Map<String, String> actualResult = page.getDeviceTotalUsage(cardNumber);
			try {
				@SuppressWarnings("unchecked")
				Map<String, String> expectedResult = BeanUtils.describe(deviceUsage);
				logger.info("Actual Result TOTAL :: {}", actualResult);
				logger.info("Expected Result TOTAL :: {}", expectedResult);
				assertValues(actualResult, expectedResult);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private void assertValues(Map<String, String> actualResult, Map<String, String> expectedResult) {
		for (Map.Entry<String, String> expectedEntry : expectedResult.entrySet()) {
			String key = expectedEntry.getKey();
			if (!expectedEntry.getValue().isEmpty() && !"class".equalsIgnoreCase(key)) {
				String exp = expectedEntry.getValue();
				String act = actualResult.get(key);
				assertTrue(String.format("%s value for field %s is NOT present on tab as expected. Actual Value is %s", exp, key, act), exp.contains(act));
				logger.info("{} value for field {} is present on tab as expected", expectedEntry.getValue(), expectedEntry.getKey());
			} else {
				logger.info("Value is null or key is class for key {}", key);
			}

		}
	}
}
