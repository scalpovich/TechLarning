package com.mastercard.pts.integrated.issuing.utils.simulator;

public class SimulatorConstantsData {
	
	//To Kill Simuilator process ___________________________________________________
		public static final String KILL_WINIUM_PROCESS = "Winium.Desktop.Driver";
		public static final String KILL_FINSIM_PROCESS = "ATClient";
		public static final String KILL_MAS_PROCESS = "MSPMCW"; 
		public static final String KILL_MCPS_PROCESS = "MCPS";
		public static final String KILL_MDFS_PROCESS = "MSPMCW";
		public static final String KILL_VTS_PROCESS = "VTS3";
		// _________________________________________________________________________
		// Other Misc constants _______________________________________________________
		public static final String WINIUM_DRIVER_EXE_PATH = "\\simulator\\externalLibraries\\Winium.Desktop.Driver.exe";
		public static final String AUTOIT_EXE_PATH = "\\simulator\\AutoIT\\";
		public static final String PSEXEC_EXE_PATH = "\\simulator\\PsExec\\PsExec.exe";
		public static final String SIKULI_IMAGE_PATH = "\\\\simulator\\\\images\\\\";
		public static final String VISA_INPUT_FILE_PATH =  "\\simulator\\VisaInputFile\\DMS_TEST_FILE.stf";
		// _________________________________________________________________________
		// SIMULATOR EXE PATHS TO INVOKE _______________________________________
		public static final String MAS_EXE_PATH = "C://Program Files (x86)//MasterCard//OTP 7.32.1003//Bin//MSPMCW.exe"; // need to modify this
		public static final String FINSIM_EXE_PATH = "\\\\simulator\\\\FINSimExe\\\\ATClient.exe";
		public static final String VISA_EXE_PATH = "C://Program Files (x86)//Vts3//Appl//VTS3.exe";
		public static final String MCPS_EXE_PATH = "C://Program Files (x86)//MasterCard//MCPS 16_Q4//mcps.exe";
		// _________________________________________________________________________
		// MAS & MDFS LICENSE SELECTION _______________________________________
		public static final String SELECT_MAS_LICENSE = "Credit - Professional";
		public static final String SELECT_MDFS_LICENSE = "Debit - Professional";
		public static final String MAS_LICENSE_TYPE_16X = "MAS 16.4";  // need to modify this
		public static final String MDFS_LICENSE_TYPE_16X = "MAS 16.4"; // need to modify this
		// _________________________________________________________________________

		// MAS  & MDFS LICENSE SELECTION _______________________________________
		
	public static String MAS_16_X = "MasterCard Authorization Simulator <MAS16.Q4>"; // need to modify this

	public static final String MDFS_16_X = "MasterCard Debit Financial Simulator <MDFS16.Q4>";

	public static final String MCPS_16_X = "MCPS - MasterCard Clearing Presentment Simulator - 16.Q4";
	
	public static final String SAMPLE_PAN_NUMBER = "2222550010000018";
	
	private SimulatorConstantsData() {}
}
