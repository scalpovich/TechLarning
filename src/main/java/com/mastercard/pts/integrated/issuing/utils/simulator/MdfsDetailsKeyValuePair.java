package com.mastercard.pts.integrated.issuing.utils.simulator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class MdfsDetailsKeyValuePair {
	private static final Logger logger = LoggerFactory.getLogger(MdfsDetailsKeyValuePair.class);

	//MDFS 18.Q2, MDFS 17.Q4 etc are the values to be used in the environment.properties file we want to use specific version
	private static final String MDFS_18_Q2 = "MDFS 18.Q2";
	private static final String MDFS_17_Q4 = "MDFS 17.Q4";
	private static final String MDFS_16_Q4 = "MDFS 16.Q4";
	private static final Map<String, String> mdfsInstallationVersionKeyValuePair = new LinkedHashMap<>();
	private static final Map<String, String> mdfsParentWindowHandlerPropertyKeyValuePair = new LinkedHashMap<>();
	private static final Map<String, String> mdfsLicenseTypeToSelect = new LinkedHashMap<>();
	private static final String simulatorHeaderHandle = "MasterCard Debit Financial Simulator";

	// add more installations here along with EXE path details
	private static void setMdfsInstallationVersionData() {
		// same exe needs to be invoked for MAS and MDFS
		mdfsInstallationVersionKeyValuePair.put(MDFS_18_Q2, "C://Program Files (x86)//MasterCard//OTP 7.32.1014//Bin//MSPMCW1820.exe");
		mdfsInstallationVersionKeyValuePair.put(MDFS_17_Q4, "C://Program Files (x86)//MasterCard//OTP 7.32.1014//Bin//MSPMCW1740.exe");
		mdfsInstallationVersionKeyValuePair.put(MDFS_16_Q4, "C://Program Files (x86)//MasterCard//OTP 7.32.1003//Bin//MSPMCW.exe");
	}

	// add more parent Window handle property based on the title seen on the
	// version of MAS
	private static void setMdfsParentWindowHandlerPropertyVersionData() {
		mdfsParentWindowHandlerPropertyKeyValuePair.put(MDFS_18_Q2, simulatorHeaderHandle);
		mdfsParentWindowHandlerPropertyKeyValuePair.put(MDFS_17_Q4, simulatorHeaderHandle);
		mdfsParentWindowHandlerPropertyKeyValuePair.put(MDFS_16_Q4, simulatorHeaderHandle);
	}

	// add What License type to select on Select Services screen on MAS
	private static void setMdfsLicenseToSelectData() {
		mdfsLicenseTypeToSelect.put(MDFS_18_Q2, "MDFS 18.2");
		mdfsLicenseTypeToSelect.put(MDFS_17_Q4, "MDFS 17.4");
		mdfsLicenseTypeToSelect.put(MDFS_16_Q4, "MDFS 16.4");
	}

	private static String getMdfsParentWindowHandlerProperty(String key) {
		return mdfsParentWindowHandlerPropertyKeyValuePair.get(key.toUpperCase());
	}

	private static String getMdfsLicenseToSelect(String key) {
		return mdfsLicenseTypeToSelect.get(key.toUpperCase());
	}

	private static void setMdfsParentWindowHandlerInLegacyConstant(String value) {
		SimulatorConstantsData.MDFS_PARENT_HANDLE = value;
		MiscUtils.reportToConsole("MDFS_PARENT_HANDLE    : " + SimulatorConstantsData.MDFS_PARENT_HANDLE);
	}

	private static void setMdfsLicenseToSelectValueInLegacyConstant(String value) {
		SimulatorConstantsData.MDFS_LICENSE_TYPE = value;
		MiscUtils.reportToConsole("MDFS_LICENSE_TYPE    : " + SimulatorConstantsData.MDFS_LICENSE_TYPE);
	}

	private static void setMdfsExePathValueInLegacyConstant(String value) {
		SimulatorConstantsData.MAS_EXE_PATH = value;
		MiscUtils.reportToConsole("MDFS_EXE_PATH    : " + SimulatorConstantsData.MAS_EXE_PATH);
	}

	public static void getLatestVersionMdfsDetailsInstalledOnMachine() {
		String parentWindowHandle;
		String licenseToSelect;
		String logComments;

		SimulatorUtilities simulatorUtilities = new SimulatorUtilities();
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, String> entry : mdfsInstallationVersionKeyValuePair.entrySet()) {
			MiscUtils.reportToConsole("MDFS Exe being searched for <--> versionNumber = " + entry.getKey()
					+ " ---  exePath = " + entry.getValue());

			Boolean exeExists = simulatorUtilities.fileExists(entry.getValue());
			if (exeExists) {
				parentWindowHandle = getMdfsParentWindowHandlerProperty(entry.getKey());
				licenseToSelect = getMdfsLicenseToSelect(entry.getKey());

				// setting the latest MAS properties to legacy constants so that
				// no other code needs to be updated
				setMdfsParentWindowHandlerInLegacyConstant(parentWindowHandle);
				setMdfsLicenseToSelectValueInLegacyConstant(licenseToSelect);
				setMdfsExePathValueInLegacyConstant(entry.getValue());

				logComments = "versionNumber = " + entry.getKey() + " ---  exePath = " + entry.getValue()
						+ " ---  parentWindowHandler = " + parentWindowHandle + " ---  licenseToSelect = "
						+ licenseToSelect;
				MiscUtils.reportToConsole("getLatestVersionMdfsDetailsInstalledOnMachine <--> " + logComments);
				logger.info("MDFS Details  <--> {} ", logComments);
				return;
			}
		}
	}

	public static void initializeMdfsData() {
		// initailizing and setting the value in Map's for
		// masInstallationVersionKeyValuePair &
		// masParentWindowHandlerPropertyKeyValuePair
		setMdfsInstallationVersionData();
		setMdfsParentWindowHandlerPropertyVersionData();
		setMdfsLicenseToSelectData();
	}

	public static void getSpecificMdfsVersionDetails(String version) {
		String parentWindowHandle;
		String licenseToSelect;
		String logComments;

		SimulatorUtilities simulatorUtilities = new SimulatorUtilities();
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, String> entry : mdfsInstallationVersionKeyValuePair.entrySet()) {

			MiscUtils.reportToConsole("MDFS Exe being searched for <--> version.toLowerCase().trim() = "
					+ version.toLowerCase().trim() + " : : " + entry.getKey().toLowerCase().trim());
			MiscUtils.reportToConsole("MDFS Exe being searched for <--> versionNumber = " + entry.getKey()
					+ " ---  exePath = " + entry.getValue());
			if (version.trim().equalsIgnoreCase(entry.getKey().trim())) {
				Boolean exeExists = simulatorUtilities.fileExists(entry.getValue());
				// get & set details only when both the set version in the
				// WhichSimulatorVersionToChoose.Java in "Configuration" and the
				// versionNumber are same
				if (exeExists) {
					parentWindowHandle = getMdfsParentWindowHandlerProperty(entry.getKey());
					licenseToSelect = getMdfsLicenseToSelect(entry.getKey());

					// setting the latest MAS properties to legacy constants so
					// that no other code needs to be updated
					setMdfsParentWindowHandlerInLegacyConstant(parentWindowHandle);
					setMdfsLicenseToSelectValueInLegacyConstant(licenseToSelect);
					setMdfsExePathValueInLegacyConstant(entry.getValue());

					logComments = "versionNumber = " + entry.getKey() + " ---  exePath = " + entry.getValue()
							+ " ---  parentWindowHandler = " + parentWindowHandle + " ---  licenseToSelect = "
							+ licenseToSelect;
					MiscUtils.reportToConsole("getSpecificMdfsVersionDetails <--> " + logComments);
					logger.info("MDFS Details  <--> {} ", logComments);
					return;
				}
			}
		}
	}

	@Override
	public String toString() {
		MiscUtils.reportToConsole("Fetching details of latest version of MDFS installed on the machine");
		return "Fetching details of latest version of MDFS installed on the machine";
	}
}