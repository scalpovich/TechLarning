/**
 * @author: e076168
 */
package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardholderServicesFlows;

@Component
public class CardholderServicesSteps extends AbstractBaseFlows{
	
	final Logger logger = LoggerFactory.getLogger(CardholderServicesSteps.class);
	
	@Autowired
	CardholderServicesFlows cardholderServiceflw;
	
	@When ("request for device replace")
	public void replaceDeviceRequest(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		cardholderServiceflw.navigateToServicesReplaceDevicePage();
		cardholderServiceflw.selectReplacementReasoneFrCard(cardholderService.getReplacementResone());
		Assert.assertTrue(cardholderServiceflw.verifyCardReplacementServiceConfirmationMsg(cardholderService.getReplacementResone()));
	}
	
	@When ("service request for block card")
	public void serviceRequestBlockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		cardholderServiceflw.navigateToServiceBlockDevicePage();
		cardholderServiceflw.blockSelectedCard(cardholderService.getBlockCardRemark());	
	}
	
	@Then ("verify that card is getting blocked")
	public void verifyCardbolkConfirmation(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		Assert.assertTrue(cardholderServiceflw.verifyBlockCardRequestConfirmMsg(cardholderService.getBlockConfirmationMsg()));
	}
	
	@When ("service request for unblock card")
	public void serviceRequestUnblockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		cardholderServiceflw.navigateToServiceUnblockBlockDevicePage();
		cardholderServiceflw.unblockSelectedCard(cardholderService.getUnblockCardRemark());
		
	}
	@Then ("verify that card is unbloked successfully")
	public void verifyUnblockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		Assert.assertTrue(cardholderServiceflw.verifyUnblockCardRequestConfirmMsg(cardholderService.getUnblockConfirmationMsg()));
	}
	@When ("verify selected wallet status")
	public void checkWalletStatus(){
		cardholderServiceflw.navigateToServiceActivateDeactivateWalletPage();		
	}
	
	@When ("service request for activate wallet")
	public void activateSelectedWallet(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		cardholderServiceflw.navigateToServiceActivateDeactivateWalletPage();
		cardholderServiceflw.activateWallet(cardholderService.getWalletActivateRemark());
	}
	
	@Then ("verify that wallet is geting activated")
	public void verifyActivateSelectedWallet(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		Assert.assertTrue(cardholderServiceflw.verifyWalletActivateDeactivateConfirmationMsg(cardholderService.getWalletActivateConfirmtionMsg()));
	}
	
	@When ("service request for deactivate wallet")
	public void deactivateSelectedWallet(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		cardholderServiceflw.navigateToServiceActivateDeactivateWalletPage();
		cardholderServiceflw.deactivateWallet(cardholderService.getWalletDeactivateRemark());
		Assert.assertTrue(cardholderServiceflw.verifyWalletActivateDeactivateConfirmationMsg(cardholderService.getWalletDeactivateConfirmMsg()));
	}
	
	
	@When ("activate ecom transaction for $activatePeriod duration")
	public void activateEcommTransaction(@Named("activatePeriod")String activatePeriod){
		cardholderServiceflw.navigateToServiceEcommTransactionPage();
		cardholderServiceflw.activateEcomTransaction(activatePeriod);
	}
	
	@Then ("ecom transaction activation $hours")
	public void setEomTransactionActivationHours(@Named("hours")String hours){
		cardholderServiceflw.setEcomActivationHours(hours);
	}
	
	@Then ("activation of ecom transaction from $fromDate to $toDate")
	public void setStartAndEndDateForEcomTransaction(@Named("fromDate")String fromDate, @Named("toDate")String toDate){
		cardholderServiceflw.setEcomActivationDurationDate(fromDate,toDate);
	}
	
	@Then ("verify ecom transaction activation status")
	public void verifyEcomActivationStatus(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();
		Assert.assertTrue(cardholderServiceflw.verifyStatusAfterActivation(cardholderService.getActivationStatusForEcom()));
	}
	
	@When ("activate international service for $activationinPeriod duration")
	public void activateCardInternationalService(@Named("activationinPeriod")String activationinPeriod){
		
		CardholderServices cardholderService = CardholderServices.cardholderInternationalServicesDataProvider();
		cardholderServiceflw.navigateToServicesInternationalUseActivationPage();
		cardholderServiceflw.activateInternationalTransaction(activationinPeriod);
		
	}
	
	@Then ("activation of international use from $fromDate to $toDate")
	public void setInternationalActiDuration(@Named("fromDate")String fromDate, @Named("toDate")String toDate){
		cardholderServiceflw.selectDateFrnInternationalUse(fromDate,toDate);
	}
	
	@Then ("verify international use activation status")
	public void verifyInternatioanlActivationStatus(){
		Assert.assertTrue("International Use activation is failed for card", cardholderServiceflw.checkInternationalUseActivationStatus("Error Message"));
	}
	
	@Then ("international use activation hours is $hours")
	public void setInternationalUseHours(@Named("hours")String hours){
		cardholderServiceflw.setInternationalUseHours(hours);
	}

}
