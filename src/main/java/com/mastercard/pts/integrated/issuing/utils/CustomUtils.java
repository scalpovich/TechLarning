package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.MCWebElements;

@Component
public abstract class CustomUtils extends AbstractBasePage {

	final static Logger LOG = LoggerFactory.getLogger("UtilsLogger");
	final static Logger logger = LoggerFactory.getLogger(CustomUtils.class);
	private static final int BUFFER_SIZE = 0;
	private static int invalidImageCount = 0;

	public static String tagName;

	public static void ThreadDotSleep(long millis) {
		try {

			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String RandomNumbers(int length) {
		int i = 0;
		String ndigitRandomNumber = "";
		double d = 0.0;

		for (int j = 1; j <= length; j++) {
			Random r = new Random();

			do {
				i = r.nextInt();
			} while (i < 0);

			i = i % 9;
			ndigitRandomNumber = ndigitRandomNumber + i;
			i = 0;
		}

		return ndigitRandomNumber;
	}

	public static String randomNumbers(int length) {
		Random rnd = new Random();
		if (length < 1 && length > 12) {
			throw new IllegalArgumentException(
					"Random number generator length should be between 1 to 12");
		}
		long nextLong = Math.abs(rnd.nextLong());
		return String.valueOf(nextLong).substring(0, length);
	}

	public static String randomString(final int length) {

		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String RandomAlphabet() {
		final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final int N = alphabet.length();
		String AlphaLetter = "";

		Random r = new Random();

		for (int i = 0; i < 1; i++) {
			AlphaLetter = AlphaLetter + alphabet.charAt(r.nextInt(N));
		}

		return AlphaLetter;
	}

	public static void validateInvalidImages(List<WebElement> imagesList) {
		try {
			invalidImageCount = 0;

			LOG.info("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					LOG.info("Verifying if the Images are loaded properly");
					verifyImageActive(imgElement);
				}
			}
			LOG.info("Total no. of invalid images are " + invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info(e.getMessage());
		}
	}

	public static void verifyImageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			LOG.info("Checking images...");
		}

	}

	public static String getEffectiveDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		return new SimpleDateFormat("MM/dd/yyyy").format(c.getTime())
				.toString();
	}

	public static void verifyHeaderTrailerPattern(String filepath) {
		final String DEFAULT_TRAILER = "TR\\d{8}";
		final String DEFAULT_HEADER = "[\\w ]{32}\\d{6}";
		File filesrc = new File(filepath);
		Scanner sc = null;
		try {
			sc = new Scanner(filesrc);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				System.out.println(line.toCharArray());
				if (line.contains("HR") || line.contains("HD")) {
					boolean Header_Pattern = Pattern.matches(DEFAULT_HEADER,
							line);
					Assert.assertEquals("Header record matched", true,
							Header_Pattern);
				} else if (line.startsWith("TR")) {
					boolean Trailer_Pattern = Pattern.matches(DEFAULT_TRAILER,
							line);
					Assert.assertEquals("Trailer record matched", true,
							Trailer_Pattern);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void verifyEmbossedFileRecord(String filepath)
			throws FileNotFoundException {
		String[] lineArray;
		File filesrc = new File(filepath);
		Scanner sc = new Scanner(filesrc);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line.toCharArray();
			if (!line.startsWith("HR") && !line.startsWith("TR")
					&& !line.startsWith("HD")) {
				lineArray = line.split("\\|");
				String DEVICE_NUMBER = "(?<deviceNumber> {5}\\d{19}|\\d{16}| {19})";
				String expirydate = "(?<expiryDate>\\d{4})";
				String serviceCode = "(?<serviceCode>\\d{3}|\\s{3})";
				String pvki = "(?<pvki>\\d)";
				String pvv = "(?<pvv>\\d{4}| {4})";
				String cvv = "(?<cvv>\\d{3}|\\s{3})";
				String icvv = "(?<icvv>\\d{3}|\\s{3})";
				String cvv2 = "(?<cvv2>\\d{3}|\\s{3})";
				String city = "(?<city> {46}\\w{4}|\\s{4})";
				String state = "(?<state> {39}\\w{11})";
				String country = "(?<country> {45}\\w{5}|\\s{5})";
				String AddressLine1 = "(?<addressline1> {46}\\w{4}|\\s{4})";
				String CardPackId = "(?<cardPackId>\\d{24}|\\s{24})";
				String AddressLine2 = "(?<addressline2> {43}\\S{7}|\\w{7}})";
				String EmbossedName = "(?<embossedname> {20}\\w{4}\\s{1}\\w{5})";
				String ICA = "(?<ICA> \\d{6}| {6})";
				String CARDHOLDERNAME = "(?<cardholdername> {46}\\w{4}|\\s{4})";
				String LastName = "(?<LastName> {44}\\w{6}|\\s{6})";
				String legalID = "(?<legalID> {5}\\S{10}|\\w{10})";
				String checkSum = "(?<checkSum>\\d{8}| {8})";
				String[] DEFAULT_LINE = { DEVICE_NUMBER, expirydate,
						serviceCode, pvki, pvv, cvv, icvv, cvv2, city, state,
						country, AddressLine1, CardPackId, AddressLine2,
						EmbossedName, ICA, CARDHOLDERNAME, LastName, legalID,
						checkSum };
				for (int i = 0; i < lineArray.length; i++) {
					boolean ppattern = Pattern.matches(DEFAULT_LINE[i],
							lineArray[i]);
					Assert.assertTrue(ppattern);
				}
				Assert.assertEquals(lineArray[0],
						MapUtils.fnGetInputDataFromMap("DeviceNumber"));
				Assert.assertEquals(lineArray[1], MapUtils
						.fnGetInputDataFromMap("ExpiryDate")
						.replaceAll("-", ""));
				Assert.assertEquals(lineArray[2],
						MapUtils.fnGetInputDataFromMap("ServiceCode"));
				Assert.assertEquals(lineArray[11],
						MapUtils.fnGetInputDataFromMap("AddressLine1"));
				Assert.assertEquals(lineArray[14],
						MapUtils.fnGetInputDataFromMap("FirstName") + " "
								+ MapUtils.fnGetInputDataFromMap("LastName"));
				Assert.assertEquals(lineArray[18],
						MapUtils.fnGetInputDataFromMap("LegalID"));
			}
		}
		sc.close();

	}

	public static boolean checkErrorMessage(String message,
			MCWebElements element) {
		if (message.equalsIgnoreCase(element.getElements().get(0).getText()))
			return true;
		return false;
	}

	public static List<String> getAllOptionsOfDropDown(MCWebElement element) {
		List<String> dropDownOptions = new ArrayList<String>();
		for (WebElement dropDownElement : element.getSelect().getOptions()) {
			dropDownOptions.add(dropDownElement.getText());
		}
		return dropDownOptions;
	}

	public static boolean isFieldMandatory(MCWebElement element) {
		return element.getAttribute("class").startsWith("mandatory");
	}

	public static String readTextFromFile(String filepath)
			throws FileNotFoundException {
		String fileName = null;
		File filesrc = new File(filepath);
		Scanner sc = new Scanner(filesrc);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line.toCharArray();
			String institutionCode = (MapUtils
					.fnGetInputDataFromMap("InstitutionName")).replaceAll(
					"[^\\d]", "").trim();
			String networkCode = (MapUtils
					.fnGetInputDataFromMap("InterchangeType")).replaceAll(
					"[^\\d]", "").trim();
			System.out.println(institutionCode);
			System.out.println(networkCode);
			System.out.println(MapUtils.fnGetInputDataFromMap("VendorCode"));
			if (line.contains(institutionCode)
					&& line.contains(networkCode)
					&& (line.contains(MapUtils
							.fnGetInputDataFromMap("VendorCode")))) {
				fileName = line;
				break;
			}
		}
		return fileName;
	}

	public static boolean checkDropDownEnabled(MCWebElement dropdownElement) {
		return dropdownElement.isEnabled();
	}

	public static String randomAlphaNumeric(int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}

}