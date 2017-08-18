package com.mastercard.pts.integrated.issuing.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimulatorUtilities{
	private static final Logger logger = LoggerFactory.getLogger(SimulatorUtilities.class);
	private static Screen screen = new Screen();

	private static int numberOfTabs = 1;

	public  void pressTab()
	{
		pressTab(numberOfTabs);
	}	

	public void pressTab(int numberOfTabs)
	{
		robotOperation("tab", numberOfTabs);
	}

	public void pressDownArrow()
	{
		pressDownArrow(numberOfTabs);
	}

	public void pressEscape()
	{
		robotOperation("escape", numberOfTabs);
	}

	public void pressDownArrow(int numberOfTabs)
	{
		robotOperation("downArrow", numberOfTabs);
	}

	public void pressLeftArrow()
	{
		robotOperation("tabLeft", numberOfTabs);
	}

	public void pressEnter()
	{
		robotOperation("pressEnter", numberOfTabs);
		wait(2000);
	}

	public void pressSpaceBar()
	{
		robotOperation("pressSpace", numberOfTabs);
	}

	public void pressRightArrow()
	{
		robotOperation("tabRight", numberOfTabs);
	}

	public void pressPageDown()
	{
		robotOperation("pageDown", numberOfTabs);
	}

	public void pressPageUp()
	{
		pressPageUp(numberOfTabs);
	}

	public void pressPageUp(int numberOfTabs)
	{
		robotOperation("pageUp", numberOfTabs);
	}

	private void robotOperation(String operationType,  int numberOfTabs)
	{
		try {
			Robot robot = new Robot();
			for(int i = 0; i < numberOfTabs; i++)
			{
				getOperation(operationType, robot);
			}
			wait(2000);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void getOperation(String operationType, Robot robot) {
		switch (operationType) {
		case "tab":
			robot.keyPress(KeyEvent.VK_TAB);
			break;
		case "tabLeft":
			robot.keyPress(KeyEvent.VK_LEFT);
			break;
		case "tabRight":
			robot.keyPress(KeyEvent.VK_RIGHT);
			break;
		case "pressEnter":
			robot.keyPress(KeyEvent.VK_ENTER);
			break;					
		case "pageDown":
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			break;	
		case "pageUp":
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			break;	
		case "pressSpace":
			robot.keyPress(KeyEvent.VK_SPACE);
			break;		
		case "downArrow":
			robot.keyPress(KeyEvent.VK_DOWN);
			break;				
		case "escape":
			robot.keyPress(KeyEvent.VK_ESCAPE);
			break;	
		default:
			break;
		}
	}

	public String stringleftPadWith0(String originalValue, int sizeofOutput)
	{
		return StringUtils.leftPad(originalValue, sizeofOutput, "0");
	}

	public static void wait(int millis)
	{
		try{
			Thread.sleep(millis);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void executeAutoITExe(String fileName)
	{
		try
		{
			String path = getResourceFolderPath() + SimulatorConstantsData.AUTOIT_EXE_PATH.replace("\\", "\\\\");
			MiscUtils.reportToConsole( "********** " + fileName + " ********** AutoIt Exe being executed.");
			wait(1000);
			String commandToExecute = " cmd /c " + path + fileName;
			Runtime.getRuntime().exec(commandToExecute);
			wait(3000);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public Boolean isNotNullAndEmpty(String varible)
	{
		return varible != null && !varible.isEmpty();
	}

	public void setText(String characters) throws AWTException {

		if(isNotNullAndEmpty(characters))
		{
			Robot robot = new Robot();
			java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection( characters );
			clipboard.setContents(stringSelection, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			wait(1000);
		}
	}

	public void setValueInCombo(String characters) throws AWTException {
		if(isNotNullAndEmpty(characters))
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F4);
			wait(2000);
			pressRobotKey(characters, robot);
			wait(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
		}
	}

	public void performRightClickOperation(String nameOfSnapshot)
	{
		performRightClick(getImageForSelectedItem(nameOfSnapshot));
	}

	public void performClickOperation(String nameOfSnapshot)
	{	
		performActionClick(getImageOfItem(nameOfSnapshot), getImageForSelectedItem(nameOfSnapshot) );
		wait(1000);
	}

	public void performDoubleClickOperation(String nameOfSnapshot)
	{	
		performActionDoubleClick(getImageOfItem(nameOfSnapshot), getImageForSelectedItem(nameOfSnapshot) );
		wait(1000);
	}

	public void  clickDataElements(String dataElement)
	{
		searchForImageAndPerformDoubleClick(dataElement);	
	}

	private void performRightClick(Pattern nameOfSnapshot) 
	{
		try {
			screen.rightClick(nameOfSnapshot);
		}
		catch(Exception e)	{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void performActionClick(Pattern selectParent, Pattern selectParentIfSelected) {
		try {
			if(screen.exists(selectParent) != null) 
			{
				screen.click(selectParent);
			}
			else
			{
				if(selectParentIfSelected!=null)
				{
					screen.click(selectParentIfSelected);
				}
			}
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void performActionDoubleClick(Pattern selectParent, Pattern selectParentIfSelected) {
		try {
			if(screen.exists(selectParent) != null) 
			{
				screen.doubleClick(selectParent);
			}
			else
			{
				if(selectParentIfSelected!=null)
				{
					screen.doubleClick(selectParentIfSelected);
				}
			}
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void waitForImageToAppear(String screenName) throws FindFailed
	{
		screen.wait(getImageOfItem(screenName));
		wait(5000);
		for(int i = 0;  i<10; i++)
		{
			if(isImagePresent(screenName))
			{
				MiscUtils.reportToConsole("Wait for Image : " + screenName + " iteration number : " + i);
				wait(5000);
				break;
			}
		}
	}

	public Boolean isImagePresent(String screenName)
	{
		try
		{
			return screen.exists(getImageOfItem(screenName))!=null;
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			return false;
		}
	}

	public String getResourceFolderPath()
	{
		File resourcesDirectory = new File("src/main/resources");
		return resourcesDirectory.getAbsolutePath().replace("\\", "\\\\");
	}

	public String getTempDirectoryLocationForSimulatorResults()
	{
		String tempFolder = new DateUtils().getDateyyyyMMdd() + "_IssuingTests_Simulator";
		//Folder is located in Temp Directory .. Ex: C:\Users\e071200\AppData\Local\Temp\20170718_IssuingTests_Simulator
		File resourcesDirectory = new File(System.getProperty("java.io.tmpdir") + tempFolder); 
		return resourcesDirectory.getAbsolutePath().replace("\\", "\\\\");
	}

	private Pattern getImageOfItem(String nameOfSnapshot) {

		String objectName = getResourceFolderPath() + SimulatorConstantsData.SIKULI_IMAGE_PATH  + nameOfSnapshot +".PNG";
		MiscUtils.reportToConsole("Performing operation with Sikuli on image :", nameOfSnapshot);
		if(!fileExists(objectName))
		{
			return null;
		}

		try {
			return new Pattern(objectName).similar(0.9F);
		}
		catch(Exception e)
		{
			logger.debug(ConstantData.EXCEPTION, e);
			return null;
		}
	}

	private Boolean fileExists(String filePathString)
	{
		return new File(filePathString).exists();
	}

	private Pattern getImageForSelectedItem(String nameOfSnapshot) {
		return getImageOfItem(nameOfSnapshot +"_Selected");
	}

	public void searchForImageAndPerformClick(String nameOfSnapshot)
	{
		searchAndScrollDownForImage(nameOfSnapshot, 5);
		performClickOperation(nameOfSnapshot);
	}

	public void searchForImageAndPerformDoubleClickforDataElements(String nameOfSnapshot)
	{
		if(nameOfSnapshot.contains("61_13"))
		{
			performOperationOnDataElementDe6113();
		}
		else
		{
			searchAndScrollDownForImage(nameOfSnapshot, 10);
			performDoubleClickOperation(nameOfSnapshot);
		}
	}

	public void searchForImageAndPerformDoubleClick(String nameOfSnapshot)
	{
		searchAndScrollDownForImage(nameOfSnapshot, 10);
		performDoubleClickOperation(nameOfSnapshot);
	}

	private void performOperationOnDataElementDe6113() {
		searchAndScrollDownForImage("DE61_DataElement", 10);
		performClickOperation("DE61_DataElement");
		pressRightArrow();
		searchAndScrollDownForImage("DE61_13_DataElement", 2);
		performDoubleClickOperation("DE61_13_DataElement");
	}

	private void searchAndScrollDownForImage(String nameOfSnapshot,  int loopThrough) {
		for(int i = 0; i < loopThrough; i++)
		{
			if(isImagePresent(nameOfSnapshot))
			{
				break;
			}
			else
			{
				pressPageDown();
			}
		}
	}

	public void searchAndScrollUpForImage(String nameOfSnapshot,  int loopThrough) {
		for(int i = 0; i < loopThrough; i++)
		{
			if(isImagePresent(nameOfSnapshot))
			{
				break;
			}
			else
			{
				pressPageUp();
			}
		}
	}

	public String getPinText() {
		executeAutoITExe("GetPINData");
		String filePath = getResourceFolderPath() + "\\PINDATA.txt";
		String content;
		try {
			content = FileCreation.getFileContents(filePath);
			content = content.substring(content.length()-6);
			return content.replaceAll("\\D+",""); // gets only numbers
		}		
		catch(Exception e)	{
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
			return null;
		}
	}

	public void pressRobotKey(String valueToSelect, Robot a) {

		Boolean isDigit = valueToSelect.matches("\\d{1}");
		if(isDigit)
		{
			int digit = Integer.parseInt(valueToSelect);
			performNumberKeyPress(digit, a);
		}
		else
		{
			performAlphabetKeyPress(valueToSelect, a);
		}
	}

	private void performAlphabetKeyPress(String valueToSelect, Robot a) {
		switch (valueToSelect.toUpperCase()) {
		case "A" :  a.keyPress(KeyEvent.VK_A); 
		break;		
		case "B" :  a.keyPress(KeyEvent.VK_B);
		break;
		case "C" :  a.keyPress(KeyEvent.VK_C);
		break;
		case "D" :  a.keyPress(KeyEvent.VK_D);
		break;
		case "E" :  a.keyPress(KeyEvent.VK_E);
		break;
		case "F" :  a.keyPress(KeyEvent.VK_F);
		break;
		}
	}

	private void performNumberKeyPress(int valueToSelect, Robot a) {
		switch (valueToSelect) {
		case 0 :  a.keyPress(KeyEvent.VK_0);
		break;
		case 1 : a.keyPress(KeyEvent.VK_1); 
		break;
		case 2 : a.keyPress(KeyEvent.VK_2);
		break;
		case 3 : a.keyPress(KeyEvent.VK_3);
		break;
		case 4 : a.keyPress(KeyEvent.VK_4);
		break;
		case 5 : a.keyPress(KeyEvent.VK_5);
		break;
		case 6 : a.keyPress(KeyEvent.VK_6);
		break;
		case 7 : a.keyPress(KeyEvent.VK_7);
		break;
		case 8 : a.keyPress(KeyEvent.VK_8);
		break;
		case 9 : a.keyPress(KeyEvent.VK_9);
		break;
		case 10 : a.keyPress(KeyEvent.VK_9);
		a.keyPress(KeyEvent.VK_F4);
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyPress(KeyEvent.VK_ENTER);
		/*pressDownArrow();
		pressEnter();*/
		break;
		case 11 : a.keyPress(KeyEvent.VK_9);
		a.keyPress(KeyEvent.VK_F4);
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyPress(KeyEvent.VK_ENTER);
		/*		pressDownArrow(2);
		pressEnter();*/
		break;
		case 12 : a.keyPress(KeyEvent.VK_9);
		a.keyPress(KeyEvent.VK_F4);
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyPress(KeyEvent.VK_DOWN);
		a.keyPress(KeyEvent.VK_ENTER);
		/*pressDownArrow(3);
		pressEnter();*/
		break;
		}
	}
}