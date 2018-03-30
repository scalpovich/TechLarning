package com.mastercard.pts.integrated.issuing.utils.simulator;

public class SimulatorConstantsData {

	// To Kill Simuilator process
	// ___________________________________________________
	public static final String KILL_WINIUM_PROCESS = "Winium.Desktop.Driver";
	public static final String KILL_FINSIM_PROCESS = "ATClient";
	public static final String KILL_MAS_PROCESS = "MSPMCW"; // same process for
															// MAS & MDFS
	public static final String KILL_MAS17_PROCESS = "MSPMCW1740"; // same
	public static final String KILL_MAS18_PROCESS = "MSPMCW1840";																// process
																	// for MAS &
																	// MDFS
	public static final String KILL_MCPS_PROCESS = "MCPS";
	public static final String KILL_VTS_PROCESS = "VTS3";
	// _________________________________________________________________________
	// Other Misc constants
	// _______________________________________________________
	public static final String WINIUM_DRIVER_EXE_PATH = "\\simulator\\externalLibraries\\Winium.Desktop.Driver.exe";
	public static final String AUTOIT_EXE_PATH = "\\simulator\\AutoIT\\";
	public static final String PSEXEC_EXE_PATH = "\\simulator\\PsExec\\PsExec.exe";
	public static final String SIKULI_IMAGE_PATH = "\\\\simulator\\\\images\\\\";
	public static final String VISA_INPUT_FILE_PATH = "\\simulator\\VisaInputFile\\";
	public static final String VISA_EXCEL_TEMPLATE_FILE_PATH = VISA_INPUT_FILE_PATH + "VisaUploadTemplate.xls";
	// _________________________________________________________________________
	// SIMULATOR EXE PATHS TO INVOKE _______________________________________
	public static String MAS_EXE_PATH; // same exe is invoked for both MAS and
										// MCPS
	public static final String FINSIM_EXE_PATH = "\\\\simulator\\\\FINSimExe\\\\ATClient.exe";
	public static final String VISA_EXE_PATH = "C://Program Files (x86)//Vts3//Appl//VTS3.exe";
	public static final String MCPS_EXE_PATH = "C://Program Files (x86)//MasterCard//MCPS 16_Q4//mcps.exe";
	// _________________________________________________________________________
	// MAS & MDFS LICENSE SELECTION _______________________________________
	public static final String SELECT_MAS_LICENSE = "Credit - Professional";
	public static final String SELECT_MDFS_LICENSE = "Debit - Professional";
	public static String MAS_LICENSE_TYPE = "MAS 16.4"; // need to modify this
	public static String MDFS_LICENSE_TYPE = "MAS 16.4"; // need to modify this
	// _________________________________________________________________________

	// SIMULATOR PARENT HANDLER _______________________________________
	public static String MAS_PARENT_HANDLE;
	public static String MDFS_PARENT_HANDLE;
	public static final String MCPS_PARENT_HANDLE = "MCPS - MasterCard Clearing Presentment Simulator - 16.Q4";

	public static final String SAMPLE_PAN_NUMBER = "2222550010000018";

	private SimulatorConstantsData() {
	}
}
