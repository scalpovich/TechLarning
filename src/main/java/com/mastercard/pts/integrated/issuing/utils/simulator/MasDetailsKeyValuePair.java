package com.mastercard.pts.integrated.issuing.utils.simulator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class MasDetailsKeyValuePair {
	private static final Logger logger = LoggerFactory.getLogger(MasDetailsKeyValuePair.class);

	private static final String MAS_18_Q2 = "MAS 18.Q2";
	private static final String MAS_17_Q4 = "MAS 17.Q4";
	private static final String MAS_16_Q4 = "MAS 16.Q4";
	private static final Map<String, String> masInstallationVersionKeyValuePair = new LinkedHashMap<>();
	private static final Map<String, String> masParentWindowHandlerPropertyKeyValuePair = new LinkedHashMap<>();
	private static final Map<String, String> masLicenseTypeToSelect = new LinkedHashMap<>();

	// add more installations here along with EXE path details
	private static void setMasInstallationVersionData() {
		masInstallationVersionKeyValuePair.put(MAS_18_Q2, 	"C://Program Files (x86)//MasterCard//OTP 7.32.1014//Bin//MSPMCW1820.exe");
		masInstallationVersionKeyValuePair.put(MAS_17_Q4, "C://Program Files (x86)//MasterCard//OTP 7.32.1014//Bin//MSPMCW1740.exe");
		masInstallationVersionKeyValuePair.put(MAS_16_Q4, "C://Program Files (x86)//MasterCard//OTP 7.32.1003//Bin//MSPMCW.exe");
	}

	// add more parent Window handle property based on the title seen on the
	// version of MAS
	private static void setMasParentWindowHandlerPropertyVersionData() {
		masParentWindowHandlerPropertyKeyValuePair.put(MAS_18_Q2, "MasterCard Authorization Simulator <MAS18.Q2 SP1 - IPS Host Testing>");
		masParentWindowHandlerPropertyKeyValuePair.put(MAS_17_Q4, "MasterCard Authorization Simulator <MAS17.Q4 SP1 - IPS Host Testing>");
		masParentWindowHandlerPropertyKeyValuePair.put(MAS_16_Q4, "MasterCard Authorization Simulator <MAS16.Q4>");
	}

	// add What License type to select on Select Services screen on MAS
	private static void setMasLicenseToSelectData() {
		masLicenseTypeToSelect.put(MAS_18_Q2, "MAS 18.2");
		masLicenseTypeToSelect.put(MAS_17_Q4, "MAS 17.4");
		masLicenseTypeToSelect.put(MAS_16_Q4, "MAS 16.4");
	}

	private static String getMasParentWindowHandlerProperty(String key) {
		return masParentWindowHandlerPropertyKeyValuePair.get(key.toUpperCase());
	}

	private static String getMasLicenseToSelect(String key) {
		return masLicenseTypeToSelect.get(key.toUpperCase());
	}

	private static void setMasParentWindowHandlerInLegacyConstant(String value) {
		SimulatorConstantsData.MAS_PARENT_HANDLE = value;
		MiscUtils.reportToConsole("MAS_PARENT_HANDLE    : " + SimulatorConstantsData.MAS_PARENT_HANDLE);
	}

	private static void setMasLicenseToSelectValueInLegacyConstant(String value) {
		SimulatorConstantsData.MAS_LICENSE_TYPE = value;
		MiscUtils.reportToConsole("MAS_LICENSE_TYPE    : " + SimulatorConstantsData.MAS_LICENSE_TYPE);
	}

	private static void setMasExePathValueInLegacyConstant(String value) {
		SimulatorConstantsData.MAS_EXE_PATH = value;
		MiscUtils.reportToConsole("MAS_EXE_PATH    : " + SimulatorConstantsData.MAS_EXE_PATH);
	}

	public static void getLatestVersionMasDetailsInstalledOnMachine() {
		String parentWindowHandle;
		String licenseToSelect;
		String logComments;

		SimulatorUtilities simulatorUtilities = new SimulatorUtilities();
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, String> entry : masInstallationVersionKeyValuePair.entrySet()) {
			MiscUtils.reportToConsole("MAS Exe being searched for <--> versionNumber = " + entry.getKey()
					+ " ---  exePath = " + entry.getValue());

			Boolean exeExists = simulatorUtilities.fileExists(entry.getValue());
			if (exeExists) {
				parentWindowHandle = getMasParentWindowHandlerProperty(entry.getKey());
				licenseToSelect = getMasLicenseToSelect(entry.getKey());

				// setting the latest MAS properties to legacy constants so that
				// no other code needs to be updated
				setMasParentWindowHandlerInLegacyConstant(parentWindowHandle);
				setMasLicenseToSelectValueInLegacyConstant(licenseToSelect);
				setMasExePathValueInLegacyConstant(entry.getValue());

				logComments = "versionNumber = " + entry.getKey() + " ---  exePath = " + entry.getValue()
						+ " ---  parentWindowHandler = " + parentWindowHandle + " ---  licenseToSelect = "
						+ licenseToSelect;
				MiscUtils.reportToConsole("getLatestVersionMasDetailsInstalledOnMachine <--> " + logComments);
				logger.info("MAS Details  <--> " + logComments);
				return;
			}
		}
	}

	public static void initializeMasData() {
		// initailizing and setting the value in Map's for
		// masInstallationVersionKeyValuePair &
		// masParentWindowHandlerPropertyKeyValuePair
		setMasInstallationVersionData();
		setMasParentWindowHandlerPropertyVersionData();
		setMasLicenseToSelectData();
	}

	public static void getSpecificMasVersionDetails(String version) {
		String parentWindowHandle;
		String licenseToSelect;
		String logComments;

		SimulatorUtilities simulatorUtilities = new SimulatorUtilities();
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, String> entry : masInstallationVersionKeyValuePair.entrySet()) {

			MiscUtils.reportToConsole("MAS Exe being searched for <--> version.toLowerCase().trim() = "
					+ version.toLowerCase().trim() + " : : " + entry.getKey().toLowerCase().trim());
			MiscUtils.reportToConsole("MAS Exe being searched for <--> versionNumber = " + entry.getKey()
					+ " ---  exePath = " + entry.getValue());
			if (version.trim().equalsIgnoreCase(entry.getKey().trim())) {
				Boolean exeExists = simulatorUtilities.fileExists(entry.getValue());
				// get & set details only when both the set version in the
				// WhichSimulatorVersionToChoose.Java in "Configuration" and the
				// versionNumber are same
				if (exeExists) {
					parentWindowHandle = getMasParentWindowHandlerProperty(entry.getKey());
					licenseToSelect = getMasLicenseToSelect(entry.getKey());

					// setting the latest MAS properties to legacy constants so
					// that no other code needs to be updated
					setMasParentWindowHandlerInLegacyConstant(parentWindowHandle);
					setMasLicenseToSelectValueInLegacyConstant(licenseToSelect);
					setMasExePathValueInLegacyConstant(entry.getValue());

					logComments = "versionNumber = " + entry.getKey() + " ---  exePath = " + entry.getValue()
							+ " ---  parentWindowHandler = " + parentWindowHandle + " ---  licenseToSelect = "
							+ licenseToSelect;
					MiscUtils.reportToConsole("getSpecificMasVersionDetails <--> " + logComments);
					logger.info("MAS Details  <--> " + logComments);
					return;
				}
			}
		}
	}

	@Override
	public String toString() {
		MiscUtils.reportToConsole("Fetching details of latest version of MAS installed on the machine");
		return "Fetching details of latest version of MAS installed on the machine";
	}
}