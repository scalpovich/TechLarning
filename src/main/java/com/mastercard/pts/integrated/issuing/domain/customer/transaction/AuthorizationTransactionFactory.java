package com.mastercard.pts.integrated.issuing.domain.customer.transaction;

import static java.util.stream.Collectors.joining;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.LinkedListMultimap;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class AuthorizationTransactionFactory {

	private static final String CARD_PROFILE_NAME = "CardProfiles_User.AUTOMATION CARD";

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationTransactionFactory.class);

	@Autowired
	private Path tempDir;

	@Autowired
	private TestContext context;

	public String createCsvCardProfile(Transaction transaction) {
		MiscUtils.reportToConsole(" *******  start createCsvCardProfile *******");
		LinkedListMultimap<String, String> elements = LinkedListMultimap.create();
		add(elements, "(path)", CARD_PROFILE_NAME);
		add(elements, "(description)", transaction.getTestCaseToSelect());

		add(elements, "002", transaction.getCardNumber());
		add(elements, "014", transaction.getExpirationYear());
		//		add(elements, "023", transaction.getCardSequenceNumber()); // not needed for now

		transaction.getCardDataElements().entrySet().stream()
		.forEach(e -> add(elements, e.getKey(), e.getValue()));

		String header = elements.keySet().stream().collect(joining(","));
		String values = elements.keySet().stream().map(name -> elements.get(name).get(0))
				.collect(joining(","));

		List<String> lines = Arrays.asList(header, values);

		String filename = String.format("Card_Profile_%s_%s.csv", transaction.getTestCaseToSelect(),
				DateUtils.getDateTimeDDMMYYYYHHMMSS());
		try {
			String fullPath = Files.write(tempDir.resolve(filename), lines).toString();
			logger.info("Generate card profile {}", fullPath);
			return fullPath;
		} catch (IOException e) {
			//NO SONAR. We are propagating exception to another class where it is thrown
			throw MiscUtils.propagate(e);
		}
	}

	public String createCsvTesCase(Transaction transaction) {
		MiscUtils.reportToConsole(" *******  start createCsvTesCase *******");
		LinkedListMultimap<String, String> elements = createTestCaseDataElements(transaction);
		String header = elements.keySet().stream().collect(joining(","));
		String values = elements.keySet().stream().map(name -> elements.get(name).get(0)).collect(joining(","));
		String expectations = elements.keySet().stream().map(name -> elements.get(name).get(1)).collect(joining(","));

		List<String> lines = Arrays.asList(header, values, expectations);

		String filename = String.format("%s_%s.csv", transaction.getTestCaseToSelect(), DateUtils.getDateTimeDDMMYYYYHHMMSS());

		try {
			String fullPath = Files.write(tempDir.resolve(filename), lines).toString();
			logger.info("Generate MAS test case {}", fullPath);
			return fullPath;
		} catch (IOException e) {
			//NO SONAR. We are propagating exception to another class where it is thrown
			throw MiscUtils.propagate(e);
		}
	}

	public LinkedListMultimap<String, String> createTestCaseDataElements(Transaction transaction) {
		LinkedListMultimap<String, String> elements = createTestCaseHeaderElements(
				transaction.getTestCaseToSelect(), transaction.getTransactionProfile(), CARD_PROFILE_NAME, transaction.getMerchantProfile());

		transaction.getDeKeyValuePair().entrySet().stream()
		.map(this::generateDynamicElement)
		.forEach(e -> add(elements, e.getKey(), e.getValue()));

		transaction.getExpectedDataElements().entrySet().stream()
		.forEach(e -> add(elements, e.getKey(), "", e.getValue()));

		return elements;
	}

	private Entry<String, String> generateDynamicElement(Entry<String, String> entry) {
		String randNum = RandomStringUtils.randomNumeric(12);
		if ("037".equals(entry.getKey())) {
			//Lokesh - uncommenting this code as TRANSACTION NAME is set in context at all level of execution
			if(context.get(ConstantData.TRANSACTION_NAME).toString().contains("PREAUTH"))
			{
				context.put("DATAELEMENT_037", randNum);
			}
			if(context.get(ConstantData.TRANSACTION_NAME).toString().contains("COMPLETION"))
			{
				randNum=context.get("DATAELEMENT_037");
			}
			entry.setValue(randNum);
			context.put(ConstantData.RRN_NUMBER, randNum);
			MiscUtils.reportToConsole("Set value of RRN : " + context.get(ConstantData.RRN_NUMBER));
			MiscUtils.reportToConsole("RRN Number for transaction : " + randNum);
		}
		return entry;
	}

	private LinkedListMultimap<String, String> createTestCaseHeaderElements(String testCaseName,
			String transactionProfile, String cardProfile, String merchantProfile) {
		LinkedListMultimap<String, String> elements = LinkedListMultimap.create();
		add(elements, "(group)", "AUTO");
		add(elements, "(name)", testCaseName);
		add(elements, "(description)", "AUTO");
		add(elements, "(transaction profile)", transactionProfile);
		add(elements, "(type)", "Tran", "ACQ ER");
		add(elements, "(card profile)", cardProfile);
		add(elements, "(merchant profile)", merchantProfile);

		return elements;
	}

	private static void add(LinkedListMultimap<String, String> elements,
			String name, String value, String expected) {
		elements.put(name, value);
		elements.put(name, expected);
	}

	private static void add(LinkedListMultimap<String, String> elements,
			String name, String value) {
		add(elements, name, value, "");
	}
}
