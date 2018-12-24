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
	
	public void navigateToServiceActivateDeactivateWalletPage(){
		navigator.navigateToPage(ActivateDeactivateWalletPage.class);
	}
	
	public String selectReplacementForCard(CardholderServices replacementOption){
		ReplaceDevicePage page = navigator.navigateToPage(ReplaceDevicePage.class);
		return page.deviceReplacementRequest(replacementOption);
	}
	
	public void blockSelectedCard(CardholderServices cardHolderService){
		BlockDevicePage page = navigator.navigateToPage(BlockDevicePage.class);
		page.enterCardBlockRemark(cardHolderService.getBlockCardRemark());	
	}
	
	public String requestBlockCard(CardholderServices cardHolderService){
		BlockDevicePage page = navigator.navigateToPage(BlockDevicePage.class);
		return page.blockDeviceRequest(cardHolderService);	
	}
	
	public String verifyBlockCardRequestConfirmMsg(){
		return blockDevicePage.getCardBlockConfirmMsg();
	}

	public void unblockSelectedCard(String unblockCardRemark){
		UnblockDevicePage page = navigator.navigateToPage(UnblockDevicePage.class);
		page.enterCardUnblockRemerk(unblockCardRemark);
		page.confirmUnblockCardRequestBtn();
	}
	
	public String unblockSelectedDevice(CardholderServices cardholderService){
		UnblockDevicePage page = navigator.navigateToPage(UnblockDevicePage.class);
		return page.unblockCard(cardholderService);
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

	public String activateDeactivateWallet(CardholderServices cardHolderService){
		ActivateDeactivateWalletPage page = navigator.navigateToPage(ActivateDeactivateWalletPage.class);
		return page.activateWallet(cardHolderService);		
	}
	
	public String verifyWalletActivateDeactivateConfirmationMsg(){		
		return activateDeactivateWalletPage.getWalletActivateDeactivateConfirmMsg();
	}
	
	public String activateEcomTransaction(CardholderServices cardholderService){
		ECommActivationPage page = navigator.navigateToPage(ECommActivationPage.class);
		return page.configureEcomActivation(cardholderService);
	}
	
	public void setEcomActivationHours(CardholderServices cardholderService){
		eCommActivationPage.setNumberOfHours(cardholderService.getEcomActivationHour());
		eCommActivationPage.submitEcomActivationPlan();
	}
	
	public void setActivationDate(String fromDate,String toDate){
		eCommActivationPage.setEcomActivationDurationDate();
	}
	
	public boolean verifyStatusAfterActivation(String activationStatus){
		return eCommActivationPage.getEcomActivationResponseMsg().contains(activationStatus);
	}
	
	public String activateInternationalTransaction(CardholderServices cardholderService){
		InternationalUseActivationPage page = navigator.navigateToPage(InternationalUseActivationPage.class);
		return page.updateInternationalDeviceUsage(cardholderService);
	}
	
	public void selectDateFrnInternationalUse(String fromDate, String toDate){
		InternationalUseActiPage.setInternationalUse(fromDate,toDate);
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
	
	public String deactivateComTransaction(){
		ECommActivationPage page = navigator.navigateToPage(ECommActivationPage.class);		
		return page.deactivateEcomTransaction();
	}
	
	public String deactivateInternationlTransaction(){
		InternationalUseActivationPage page = navigator.navigateToPage(InternationalUseActivationPage.class);
		return page.deactivateInternationalTransaction();
	}
	
}
