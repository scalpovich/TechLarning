package com.mastercard.pts.integrated.issuing.steps;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.configuration.LinuxBox;
import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.BatchFileValidator;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class BatchSteps {

	private static final String DEFAULT_EMBOSSING_LINE = "^(?<deviceNumber> {3}\\d{16}|\\d{19})"
			+ "\\|(?<expiryDate>\\d{4})\\|(?<pvki>\\d)\\|(?<pvv>\\d{4}| {4})\\|(?<icv>\\d{3}| {3})"
			+ "\\|(?<cvv>\\d{3}| {3})\\|(?<cvv2>\\d{3}| {3})\\|(?<serviceCode>\\d{3})"
			+ "(?<checksum>\\d{8})?$";

	private static final String DEFAULT_TRAILER = "TR\\d{8}";

	private static final String DEFAULT_HEADER = "[\\w ]{32}\\d{6}";

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	private Path tempDirectory;

	@Autowired
	private LinuxBox linuxBox;

	@Autowired
	private TestContext context;

	@When("embossing file batch was generated in correct format")
	@Then("embossing file batch was generated in correct format")
	public void  embossingFileWasGeneratedSuccessfully() {
		DevicePlan tempdevicePlan = context.get(ContextConstants.DEVICE_PLAN);
		File batchFile = linuxBox.downloadByLookUpForPartialFileName(tempdevicePlan.getDevicePlanCode(), tempDirectory.toString(), "DEVICE");
		
		List<Map<String, String>> batchData = BatchFileValidator.forBatch(batchFile)
				.expectHeader(getHeaderPattern())
				.expectLine(DEFAULT_EMBOSSING_LINE)
				.expectTrailer(getTrailerPattern())
				.validate()
				.extractData();

		Map<String, String> deviceData = batchData.get(0);

		Device device = context.get(ContextConstants.DEVICE);
		device.setCvvData(deviceData.get("cvv"));
		device.setDeviceNumber(deviceData.get("deviceNumber"));
		device.setExpirationDate(deviceData.get("expiryDate"));
		device.setPvvData(deviceData.get("pvv"));
		device.setIcvvData(deviceData.get("icv"));
		device.setCvv2Data(deviceData.get("cvv2"));
		device.setPvkiData(deviceData.get("pvki"));
		
		MiscUtils.reportToConsole("Device Details :  " + device );
	}

	@When("Pin Offset file batch was generated successfully")
	@Then("Pin Offset file batch was generated successfully")
	public void  getPinFileData()
	{
		try
		{
			String[] values = null;
			DevicePlan tempdevice = context.get(ContextConstants.DEVICE_PLAN);
			File batchFile = linuxBox.downloadByLookUpForPartialFileName(tempdevice.getDevicePlanCode(), tempDirectory.toString(), "PIN");

			Scanner scanner = new Scanner(batchFile);
			while(scanner.hasNext()){
				values = scanner.nextLine().split(">");
			}

			Device device = context.get(ContextConstants.DEVICE);
			if(values[0] == null && values[0].isEmpty())
			{
				values[0] = "pin not retrieved";
			}
			device.setPinOffset(values[0]);
			MiscUtils.reportToConsole("Pin Offset :  " + values[0] );
			scanner.close();
		}
		catch(Exception e)
		{
			MiscUtils.propagate(e);
		}
	}

	private String getHeaderPattern() {
		return provider.getString("BATCH_HEADER_PATTERN", DEFAULT_HEADER);
	}

	private String getTrailerPattern() {
		return provider.getString(" BATCH_TRAILER_PATTERN", DEFAULT_TRAILER);
	}

}
