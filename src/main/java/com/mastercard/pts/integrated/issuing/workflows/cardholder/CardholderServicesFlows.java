package com.mastercard.pts.integrated.issuing.workflows.cardholder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ActivateDeactivateWalletPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.BlockDevicePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ECommActivationPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.InternationalUseActivationPage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.ReplaceDevicePage;
import com.mastercard.pts.integrated.issuing.pages.cardholder.services.UnblockDevicePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;

@Component
public class CardholderServicesFlows  extends AbstractBaseFlows{
	
	@Autowired
	Navigator navigator;
	
	@Autowired
	ReplaceDevicePage replaceDevicePage;
	
	@Autowired
	BlockDevicePage blockDevicePage;
	
	@Autowired
	UnblockDevicePage unblockDevicePage;
	
	@Autowired
	ECommActivationPage eCommActivationPage;
	
	@Autowired
	InternationalUseActivationPage InternationalUseActiPage;
	
	@Autowired
	ActivateDeactivateWalletPage activateDeactivateWalletPage;

	private String walletStatusActive ="Active";
	
	private String walletStatusDeactive ="Deactive";
	
	public void navigateToServicesReplaceDevicePage(){		
		navigator.navigateToPage(ReplaceDevicePage.class);
	}
	
	public void navigateToServicesInternationalUseActivationPage(){
		navigator.navigateToPage(InternationalUseActivationPage.class);
	}
	public void navigateToServiceBlockDevicePage(){
		navigator.navigateToPage(BlockDevicePage.class);
	}
	
	public void navigateToServiceUnblockBlockDevicePage(){
		navigator.navigateToPage(UnblockDevicePage.class);
	}
	
	public void navigateToServiceActivateDeactivateWalletPage(){
		navigator.navigateToPage(ActivateDeactivateWalletPage.class);
	}
	
	public void navigateToServiceEcommTransactionPage(){
		navigator.navigateToPage(ECommActivationPage.class);
	}
	
	public void selectReplacementReasoneFrCard(String replaceMenetOption){
		replaceDevicePage.selectReplaceMentOption(replaceMenetOption);
	}
	
	
	public boolean verifyCardReplacementServiceConfirmationMsg(String confirmationMsg){
	
		if(replaceDevicePage.getReplacementRequestConfirmationMsg().contains(confirmationMsg)){
			return true;
			
		}else{
			
			return false;
		}	
	}
	
	public void blockSelectedCard(String blockCardRemark){
		blockDevicePage.enterCardBlockRemark(blockCardRemark);
		blockDevicePage.confirmCardBlockRequest();
	}
	
	public boolean verifyBlockCardRequestConfirmMsg(String cardBlockconfirMessage){
		if(blockDevicePage.getCardBlockConfirmMsg().contains(cardBlockconfirMessage)){
			blockDevicePage.clickOnOkayButton();
			return true;
		}else{
			return false;
		}
	}

	public void unblockSelectedCard(String unblockCardRemark){
		unblockDevicePage.enterCardUnblockRemerk(unblockCardRemark);
		unblockDevicePage.confirmUnblockCardRequestBtn();
	}
	
	
	public boolean verifyUnblockCardRequestConfirmMsg(String cardUnblockConfirmMessag){
		if(unblockDevicePage.getUnblockCardRequestResponse().contains(cardUnblockConfirmMessag)){
			unblockDevicePage.clickOnOkayBtn();
			return true;
		}else{
			return false;
		}
	}
	
	public String checkWalletStatus(){
		if(activateDeactivateWalletPage.getWalletStatus().contains(walletStatusActive)){
			return walletStatusActive;
		}else{
			return walletStatusDeactive;
		}
	}
	
	public void activateWallet(String activateRemark){
		activateDeactivateWalletPage.setActivateDeactivaeteWalletRemrk(activateRemark);
		activateDeactivateWalletPage.clickOnWalletActivateDeactivateSubtButton();
	}
	
	public void deactivateWallet(String deactivationRemark){
		activateDeactivateWalletPage.setActivateDeactivaeteWalletRemrk(deactivationRemark);
		activateDeactivateWalletPage.clickOnWalletActivateDeactivateSubtButton();
	}
	
	public boolean verifyWalletActivateDeactivateConfirmationMsg(String walletActivateDeactivateConfirmMessag){
		
		if(activateDeactivateWalletPage.getWalletActivateDeactivateConfirmMsg().contains(walletActivateDeactivateConfirmMessag)){
			return true;
		}else{
			return false;
		}
	}
	
	public void activateEcomTransaction(String activationPlan){
		
		if(activationPlan.contains(CardholderServices.ECOM_HOURS_ACTIVATION)){
			eCommActivationPage.setActivationForNHours();			
			
			
		}else if(activationPlan.contains(CardholderServices.ECOM_LIELONG_ACTIVATION)){
			eCommActivationPage.setActivationForLifeLong();
			eCommActivationPage.submitEcomActivationPlan();
			
		}else if(activationPlan.contains(CardholderServices.ECOM_PERIOD_ACTIVATION)){
			eCommActivationPage.setActivationInPeriod();
		}
	}
	
	public void setEcomActivationHours(String activationHours){
		eCommActivationPage.setNumberOfHours(activationHours);
		eCommActivationPage.submitEcomActivationPlan();
	}
	
	public void setEcomActivationDurationDate(String fromDate,String toDate){
		eCommActivationPage.setActivationFromDate(fromDate);
		eCommActivationPage.setActivationToDate(toDate);
		eCommActivationPage.submitEcomActivationPlan();
	}
	
	public boolean verifyStatusAfterActivation(String activationStatus){
		return eCommActivationPage.getEcomActivationResponseMsg().contains(activationStatus);
	}
	
	public void setFromAndToDateForEcomActivation(String fromDate,String toDate){
		
	}
	
	public void activateInternationalTransaction(String activationPlan){
		
		if(activationPlan.contains(CardholderServices.ECOM_HOURS_ACTIVATION)){				
			InternationalUseActiPage.activationNHours();
			
		}else if(activationPlan.contains(CardholderServices.ECOM_LIELONG_ACTIVATION)){
			InternationalUseActiPage.selectActivationLifeLongRdo();
			InternationalUseActiPage.internationalActivSubmitBtn();	
			
		}else if(activationPlan.contains(CardholderServices.ECOM_PERIOD_ACTIVATION)){
			InternationalUseActiPage.selectActivationLifeLongRdo();
		}
	}
	
	public void selectDateFrnInternationalUse(String fromDate, String toDate){
		InternationalUseActiPage.activationFromDate(fromDate);
		InternationalUseActiPage.activationToDate(toDate);
		InternationalUseActiPage.internationalActivSubmitBtn();
	}
	
	public void setInternationalUseHours(String activationHours){
		InternationalUseActiPage.enterNHours(activationHours);
		InternationalUseActiPage.internationalActivSubmitBtn();
	}
	
	public boolean checkInternationalUseActivationStatus(String confirmationStatusMsg){
		if(InternationalUseActiPage.getInternationlUseActivaStatusConfrmMsg().contains(confirmationStatusMsg)){
			return true;
			
		}else{
			
			return false;			
		}
	}
	
}
