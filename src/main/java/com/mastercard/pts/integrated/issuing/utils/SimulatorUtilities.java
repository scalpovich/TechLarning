package com.mastercard.pts.integrated.issuing.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimulatorUtilities {
	private static final Logger logger = LoggerFactory.getLogger(SimulatorUtilities.class);
	private static Screen screen = new Screen();
	private static int numberOfTabs = 1;
	private static final String SELECTED_IMAGE = "_Selected";
	private static final String SIKULI_MESSAGE = "***** Sikuli click operation is performed on : ";
	private static final String SIKULI_DOUBLECLICK_MESSAGE = "***** Sikuli double click operation is performed on : ";
	private static final String SETTEXT_OPERATION = "***** SetText operation is performed. Text set to : ";

	public void pressTab() {
		pressTab(numberOfTabs);
	}

	public void pressTab(int numberOfTabs) {
		robotOperation("tab", numberOfTabs);
	}

	public void pressDownArrow() {
		pressDownArrow(numberOfTabs);
	}

	public void pressEscape() {
		robotOperation("escape", numberOfTabs);
	}

	public void pressDownArrow(int numberOfTabs) {
		robotOperation("downArrow", numberOfTabs);
	}

	public void pressUpArrow(int numberOfTabs) {
		robotOperation("upArrow", numberOfTabs);
	}

	public void pressDelete(int numberOfTabs) {
		robotOperation("pressDelete", numberOfTabs);
	}

	public void pressDelete() {
		pressDelete(numberOfTabs);
	}

	public void pressUpArrow() {
		pressUpArrow(numberOfTabs);
	}

	public void pressLeftArrow() {
		pressLeftArrow(numberOfTabs);
	}

	public void pressLeftArrow(int numberOfTabs) {
		robotOperation("tabLeft", numberOfTabs);
	}

	public void pressEnter() {
		robotOperation("pressEnter", numberOfTabs);
		wait(2000);
	}

	public void pressSpaceBar() {
		pressSpaceBar(numberOfTabs);
	}

	public void pressSpaceBar(int numberOfTabs) {
		robotOperation("pressSpace", numberOfTabs);
	}

	public void pressRightArrow() {
		pressRightArrow(numberOfTabs);
	}

	public void pressRightArrow(int numberOfTabs) {
		robotOperation("tabRight", numberOfTabs);
	}

	public void pressPageDown() {
		pressPageDown(numberOfTabs);
	}

	public void pressPageDown(int numberOfTabs) {
		robotOperation("pageDown", numberOfTabs);
	}

	public void pressPageUp() {
		pressPageUp(numberOfTabs);
	}

	public void pressPageUp(int numberOfTabs) {
		robotOperation("pageUp", numberOfTabs);
	}

	private void robotOperation(String operationType, int numberOfTabs) {
		try {
			Robot robot = new Robot();
			for (int i = 0; i < numberOfTabs; i++) {
				if (operationType.toUpperCase().contains("TAB")) {
					getTabOperation(operationType, robot);
				} else {
					getOtherOperation(operationType, robot);
				}
				wait(1000);
				logger.info("**** Robot/Keyboard Operation performed :  ", operationType);
			}
			wait(2000);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void getOtherOperation(String operationType, Robot robot) {
		switch (operationType) {
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
		case "upArrow":
			robot.keyPress(KeyEvent.VK_UP);
			break;
		case "escape":
			robot.keyPress(KeyEvent.VK_ESCAPE);
			break;
		case "pressDelete":
			robot.keyPress(KeyEvent.VK_DELETE);
			break;
		default:
			break;
		}
	}

	private void getTabOperation(String operationType, Robot robot) {
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
		default:
			break;
		}
	}

	public String stringleftPadWith0(String originalValue, int sizeofOutput) {
		return StringUtils.leftPad(originalValue, sizeofOutput, "0");
	}

	public static void wait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void executeAutoITExe(String fileName) {
		try {
			String path = getResourceFolderPath() + SimulatorConstantsData.AUTOIT_EXE_PATH.replace("\\", "\\\\");
			String psExecPath = getResourceFolderPath() + SimulatorConstantsData.PSEXEC_EXE_PATH.replace("\\", "\\\\");
			String commandToExecute;
			logger.info("********* AutoIt Exe being executed :  {} ", fileName);

			// for remote/Jenkins/command Line - AutoIT execution.. enable the below 2 lines and comment the other 2 lines
			commandToExecute = " cmd /c " + psExecPath + " " + path + fileName;
			logger.info("********* commandToExecute  :  {}", commandToExecute);
			executeCommand(fileName, commandToExecute);
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void executeCommand(String fileName, String commandToExecute) throws InterruptedException, IOException {
		if (fileName.contains("SelectIPSHost")) {
			Runtime.getRuntime().exec(commandToExecute).waitFor(25, TimeUnit.SECONDS);
			wait(15000);
		} else {
			Runtime.getRuntime().exec(commandToExecute).waitFor(15, TimeUnit.SECONDS);
			wait(2000);
		}
		wait(2000);
	}

	public Boolean isNotNullAndEmpty(String varible) {
		return varible != null && !varible.isEmpty();
	}

	public void setText(String characters) throws AWTException {

		if (isNotNullAndEmpty(characters)) {
			Robot robot = new Robot();
			java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(characters);
			clipboard.setContents(stringSelection, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			wait(1000);
			logger.info(SETTEXT_OPERATION, characters);
		}
	}

	public void selectAll() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
	}

	public void performRightClickOperation(String nameOfSnapshot) {
		performRightClick(getImageForSelectedItem(nameOfSnapshot));
	}

	public void performClickOperation(String nameOfSnapshot) {
		logger.info(SIKULI_MESSAGE, nameOfSnapshot);
		performActionClick(getImageOfItem(nameOfSnapshot));
		wait(1000);
	}

	public void clickOnLastMatchingImage(String nameOfSnapshot) {
		logger.info(SIKULI_MESSAGE, nameOfSnapshot);
		clickOnLastImage(getImageOfItem(nameOfSnapshot));
		wait(1000);
	}

	public void performDoubleClickOperation(String nameOfSnapshot) {
		logger.info(SIKULI_DOUBLECLICK_MESSAGE, nameOfSnapshot);
		performActionDoubleClick(getImageOfItem(nameOfSnapshot));
		wait(1000);
	}

	public void performClickOperationOnImages(String nameOfSnapshot) {
		String imagesName = nameOfSnapshot + SELECTED_IMAGE;
		logger.info(SIKULI_MESSAGE, nameOfSnapshot);
		performActionClickOnImages(getImageOfItem(nameOfSnapshot), getImageOfItem(imagesName));
		wait(1000);
	}

	public void performDoubleClickOperationOnImages(String nameOfSnapshot) {
		String imagesNameTemp = nameOfSnapshot + SELECTED_IMAGE;
		logger.info(SIKULI_DOUBLECLICK_MESSAGE, nameOfSnapshot);
		performActionDoubleClickOnImages(getImageOfItem(nameOfSnapshot), getImageOfItem(imagesNameTemp));
		wait(1000);
	}

	private void performRightClick(Pattern nameOfSnapshot) {
		try {
			screen.rightClick(nameOfSnapshot);
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, nameOfSnapshot);
			MiscUtils.propagate(e);
		}
	}

	private void performActionClick(Pattern selectParent) {
		try {
			screen.click(selectParent);
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void clickOnLastImage(Pattern selectParent) {
		try {
			Iterator<Match> it = screen.findAll(selectParent);
			while (it.hasNext()) {
				logger.info("The match is ", it.next().click());
			}
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void performActionDoubleClick(Pattern selectParent) {
		try {
			screen.doubleClick(selectParent);
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void performActionClickOnImages(Pattern selectParent, Pattern selectParent1) {
		try {
			if (screen.exists(selectParent) != null) {
				screen.click(selectParent);
			} else {
				screen.click(selectParent1);
			}
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	private void performActionDoubleClickOnImages(Pattern selectParent, Pattern selectParent1) {
		try {
			if (screen.exists(selectParent) != null) {
				screen.doubleClick(selectParent);
			} else {
				screen.doubleClick(selectParent1);
			}
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, e);
			MiscUtils.propagate(e);
		}
	}

	public void waitForImageToAppear(String screenName) throws FindFailed {
		screen.wait(getImageOfItem(screenName));
		wait(5000);
		for (int i = 0; i < 10; i++) {
			if (isImagePresent(screenName)) {
				MiscUtils.reportToConsole("Wait for Image : " + screenName + " iteration number : " + i);
				wait(5000);
				break;
			}
		}
	}

	public Boolean isImagePresent(String screenName) {
		try {
			return screen.exists(getImageOfItem(screenName)) != null;
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, screenName);
			logger.error(e.getMessage());
			return false;
		}
	}

	public Boolean areImagesPresent(String screenName) {
		try {
			if (screen.exists(getImageOfItem(screenName)) != null)
				return true;
			else if (screen.exists(getImageOfItem(screenName + SELECTED_IMAGE)) != null)
				return true;
			else {
				logger.info("Check areImagesPresent in Simululator Utilities");
				return false;
			}

		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, screenName);
			return false;
		}
	}

	public String getResourceFolderPath() {
		File resourcesDirectory = new File("src/main/resources");
		return resourcesDirectory.getAbsolutePath().replace("\\", "\\\\");
	}

	public String getTempDirectoryLocationForSimulatorResults() {
		String tempFolder = new DateUtils().getDateyyyyMMdd() + "_IssuingTests_Simulator";
		// Folder is located in Temp Directory .. Ex: C:\Users\e071200\AppData\Local\Temp\20170718_IssuingTests_Simulator
		File resourcesDirectory = new File(System.getProperty("java.io.tmpdir") + tempFolder);
		return resourcesDirectory.getAbsolutePath();
	}

	private Pattern getImageOfItem(String nameOfSnapshot) {

		String objectName = getResourceFolderPath() + SimulatorConstantsData.SIKULI_IMAGE_PATH + nameOfSnapshot + ".PNG";
		if (!fileExists(objectName)) {
			return null;
		}

		try {
			return new Pattern(objectName).similar(0.75F);
		} catch (Exception e) {
			logger.debug(ConstantData.SIKUKI_EXCEPTION, nameOfSnapshot);
			return null;
		}
	}

	private Boolean fileExists(String filePathString) {
		return new File(filePathString).exists();
	}

	private Pattern getImageForSelectedItem(String nameOfSnapshot) {
		return getImageOfItem(nameOfSnapshot + "_Selected");
	}

	public void searchForImageAndPerformClick(String nameOfSnapshot) {
		searchAndScrollDownForImage(nameOfSnapshot, 5);
		performClickOperation(nameOfSnapshot);
	}

	public void searchForImageAndPerformDoubleClick(String nameOfSnapshot) {
		searchAndScrollDownForImage(nameOfSnapshot, 10);
		performDoubleClickOperation(nameOfSnapshot);
	}

	private void searchAndScrollDownForImage(String nameOfSnapshot, int loopThrough) {
		for (int i = 0; i < loopThrough; i++) {
			if (isImagePresent(nameOfSnapshot)) {
				break;
			} else {
				pressPageDown();
			}
		}
	}

	public void searchAndScrollUpForImage(String nameOfSnapshot, int loopThrough) {
		for (int i = 0; i < loopThrough; i++) {
			if (isImagePresent(nameOfSnapshot)) {
				break;
			} else {
				pressPageUp();
			}
		}
	}

	public String getPinText() {
		executeAutoITExe("GetPINData.exe");

		String filePath = getTempDirectoryLocationForSimulatorResults() + "\\PINDATA.txt";
		String content;
		try {
			content = FileCreation.getFileContents(filePath);
			return content.replaceAll("\\D+", ""); // gets only numbers
		} catch (Exception e) {
			logger.debug(ConstantData.EXCEPTION, e);
			MiscUtils.propagate(e);
			return null;
		}
	}
}