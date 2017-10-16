/**
 * 
 */
package com.mastercard.bdd.mpts;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author e070376
 *
 */
@Ignore
public class DownloadTest {

	public void Ctest() {

		FirefoxProfile profile = new FirefoxProfile();

		// Set Location to store files after downloading.
		profile.setPreference("browser.download.dir",
				System.getProperty("user.dir"));
		profile.setPreference("browser.download.folderList", 2);

		// Set Preference to not show file download confirmation dialogue using
		// MIME types Of different file extension types.
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/plain");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/plain,application/zip");

		profile.setPreference("browser.download.manager.showWhenStarting",
				false);
		profile.setPreference("pdfjs.disabled", true);

		// Pass FProfile parameter In webdriver to use preferences to download
		// file.
		FirefoxDriver driver = new FirefoxDriver(profile);

		// Open APP to download application
		driver.get("http://10.168.128.112:25003/integratedIssuing-customerPortal/mpts/app/Login");

		driver.findElement(By.id("userid")).sendKeys("Tejas");
		driver.findElement(
				By.xpath("//input[@id='passcode'][@name = 'passwd']"))
				.sendKeys("8520");
		driver.findElement(
				By.xpath("//input[@type='submit'][@name = 'SignIn']")).click();

		// Select select = new
		// Select(driver.findElement(By.name("institutionCode:input:dropdowncomponent")));
		// select.selectByVisibleText("BNK (000000)");
		driver.findElement(By.name("confirm")).click();
		driver.navigate()
				.to("http://10.168.128.112:25003/integratedIssuing-customerPortal/eis/app/ListPage?3&pageID=CESM02");

		driver.findElement(By.className("exportCSV")).click();

	}

	public void dTest() throws InterruptedException {

		FirefoxProfile profile = new FirefoxProfile();

		// Set Location to store files after downloading.
		profile.setPreference("browser.download.dir",
				System.getProperty("user.dir"));
		profile.setPreference("browser.download.folderList", 2);

		// Set Preference to not show file download confirmation dialogue using
		// MIME types Of different file extension types.
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/octet-stream");

		profile.setPreference("browser.download.manager.showWhenStarting",
				false);
		profile.setPreference("pdfjs.disabled", true);

		// Pass FProfile parameter In webdriver to use preferences to download
		// file.
		FirefoxDriver driver = new FirefoxDriver(profile);

		// Open APP to download application
		driver.get("http://toolsqa.com/automation-practice-form/");

		// Click to download
		driver.findElement(By.linkText("Test File to Download")).click();

		// Halting the execution for 5 secs to donwload the file completely
		Thread.sleep(5000);

		driver.close();

	}

}
