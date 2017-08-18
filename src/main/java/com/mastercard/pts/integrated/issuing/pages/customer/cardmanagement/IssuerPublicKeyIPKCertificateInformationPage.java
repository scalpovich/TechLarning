package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.IssuerPublicKey;
import com.mastercard.pts.integrated.issuing.pages.AbstractModelPage;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = {
		CardManagementNav.L1_INSTITUTION_PARAMETER_SETUP,
		CardManagementNav.L2_EMV,
		CardManagementNav.L3_ISSUER_PUBLIC_KEY_IPK_CERTIFICATE_INFORMATION})
public class IssuerPublicKeyIPKCertificateInformationPage extends AbstractModelPage {
	
	private static final Logger logger = LoggerFactory
			.getLogger(IssuerPublicKeyIPKCertificateInformationPage.class);
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=ipkId]")
	private MCWebElement ipkId;
	
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:1:componentList:1:componentPanel:input:dropdowncomponent")
	private MCWebElement interchange;

	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:2:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement issuerBin;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "[fld_fqn=serialNumber]")
	private MCWebElement serialNumber;
		
	@PageElement(findBy = FindBy.NAME, valueToFind = "searchDiv:rows:3:componentList:0:componentPanel:input:dropdowncomponent")
	private MCWebElement status;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='ipkId']")
	private MCWebElement 	ipkIdTxt;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "input[fld_fqn='serialNumber']")
	private MCWebElement 	serialNumberTxt;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='networkCode']/select")
	private MCWebElement 	interchangeDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='issuerBin']/select")
	private MCWebElement 	issuerBinDwn;
	
	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//span[@id='status']/select")
	private MCWebElement 	statusDwn;
	
	@PageElement(findBy = FindBy.CSS, valueToFind= "#certIssDate")
	private MCWebElement 	issueDateDpkr;
	
	@PageElement(findBy = FindBy.CSS, valueToFind = "#certExpDate")
	private MCWebElement 	expiryDateDpkr;
	
	public void verifyUiOperationStatus() {
		logger.info("Ipk Certificate Information");
		verifyUiOperation("Add Ipk Certificate Information");
	}
	
	public void addIPKCertificate(List<IssuerPublicKey> ipkList)
	{
		ipkList.forEach(ipk->{
		logger.info("create IPK : {}",ipk.toString());
		clickAddNewButton();
		runWithinPopup(
				"Add Ipk Certificate Information",
				() -> {
						addCertificate(ipk);
						verifyNoErrors();
				});

		verifyOperationStatus();       
		});
	}
	
	private void addCertificate(IssuerPublicKey ipk)
	{			
			WebElementUtils.enterText(ipkIdTxt, ipk.getIpkId());
			WebElementUtils.selectDropDownByVisibleText(interchangeDwn, ipk.getInterchange());
			WebElementUtils.selectDropDownByVisibleText(issuerBinDwn, ipk.getIssuerBin());
			WebElementUtils.enterText(serialNumberTxt, ipk.getSerialNumber());
			WebElementUtils.pickDate(issueDateDpkr, LocalDate.now().plusDays(Integer.parseInt(ipk.getIssueDataCurrentDatePlus())));
			WebElementUtils.pickDate(expiryDateDpkr, ipk.getExpiryDate());
			WebElementUtils.selectDropDownByVisibleText(statusDwn, ipk.getStatus());
			clickSaveButton();
	}
	

	@Override
	protected Collection<ExpectedCondition<WebElement>> isLoadedConditions() {
		return Arrays.asList(
				WebElementUtils.elementToBeClickable(ipkId),
				WebElementUtils.elementToBeClickable(interchange),
				WebElementUtils.elementToBeClickable(issuerBin),
				WebElementUtils.elementToBeClickable(serialNumber),
				WebElementUtils.elementToBeClickable(status)
				);
	}
}
