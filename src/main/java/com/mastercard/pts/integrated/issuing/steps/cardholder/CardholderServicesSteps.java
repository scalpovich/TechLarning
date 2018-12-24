package com.mastercard.pts.integrated.issuing.steps.cardholder;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static org.junit.Assert.assertTrue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.cardholder.CardholderServices;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.AbstractBaseFlows;
import com.mastercard.pts.integrated.issuing.workflows.cardholder.CardholderServicesFlows;

@Component
public class CardholderServicesSteps extends AbstractBaseFlows{
		
	@Autowired
	CardholderServicesFlows cardholderServiceflw;
	
	@Autowired
	KeyValueProvider provider;	

	final Logger logger = LoggerFactory.getLogger(CardholderServicesSteps.class);	
	public static final String walletStatus = "Request has been processed successfully";
	
	@Given ("request for device replacement")
	@When ("request for device replacement")
	@Then ("request for device replacement")	
	public void replaceDeviceRequest(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();		
		assertTrue("Replace device request has failed", cardholderServiceflw.selectReplacementForCard(cardholderService).contains("Activated Successfully"));
	}
	@Given ("replace device with $reasonType")
	@When ("replace device with $reasonType")
	@Then ("replace device with $reasonType")	
	public void replaceDeviceRequestWithReason(String reasonType){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();	
		cardholderService.setReplacementReason(reasonType);
		assertTrue("Replace device request has failed", cardholderServiceflw.selectReplacementForCard(cardholderService).contains("Activated Successfully"));
	}
	
	@Then ("service request for block card")
	@When ("service request for block card")
	public void serviceRequestBlockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();		
		cardholderServiceflw.blockSelectedCard(cardholderService);
		assertTrue("Block device service request has failed",cardholderServiceflw.verifyBlockCardRequestConfirmMsg().contains("Activated Successfully"));		
	}
	
	@Then ("service request to block a card")
	@When ("service request to block a card")
	public void serviceRequestToBlockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);
		assertTrue("Block device service request has failed",cardholderServiceflw.requestBlockCard(cardholderService).contains("Device Blocked"));		
	}
	
	@When ("service request for unblock card")
	public void serviceRequestUnblockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();		
		cardholderServiceflw.unblockSelectedCard(cardholderService.getUnblockCardRemark());		
	}
	
	@Given ("service request to unblock card")
	@When ("service request to unblock card")
	@Then ("service request to unblock card")
	public void serviceRequestforUnblockCard(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);					
		assertTrue("Card unblock service request has failed",cardholderServiceflw.unblockSelectedDevice(cardholderService).contains("Unblock Device"));
	}
	
	@Then ("verify that card is unbloked successfully")
	public void verifyUnblockCard(){
		assertTrue("Card unblock service request has failed",cardholderServiceflw.verifyUnblockCardRequestConfirmMsg("Activated Successfully"));
	}
	
	@When ("verify selected wallet status")
	public void checkWalletStatus(){
		cardholderServiceflw.navigateToServiceActivateDeactivateWalletPage();		
	}
	
	@When ("service request for activate wallet")
	public void activateSelectedWallet(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();		
		assertTrue("Request to activate wallet has failed",cardholderServiceflw.activateDeactivateWallet(cardholderService).contains("Request has been processed successfully"));
	}
	
	@When ("activate associated wallet for selected device")
	@Then ("activate associated wallet for selected device")
	public void activateWalletServiceRequest(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);		
		assertTrue("Request to activate wallet has failed",cardholderServiceflw.activateDeactivateWallet(cardholderService).contains("Request has been processed successfully"));
	}
	
	@Then ("verify that wallet is geting activated")
	public void verifyActivateSelectedWallet(){
		assertTrue("Device wallet is activated",cardholderServiceflw.verifyWalletActivateDeactivateConfirmationMsg().contains(walletStatus));
	}
	
	@When ("service request for deactivate wallet")
	@Then ("service request for deactivate wallet")	
	public void deactivateSelectedWallet(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider();		
		cardholderServiceflw.activateDeactivateWallet(cardholderService);
		assertTrue("Service request for deactivate wallet is failed",cardholderServiceflw.verifyWalletActivateDeactivateConfirmationMsg().contains("Request has been processed successfully"));
	}
	
	@When ("deactivate associated wallet for selected device")
	@Then ("deactivate associated wallet for selected device")
	public void deactivateSelectedDeviceWallet(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);		
		cardholderServiceflw.activateDeactivateWallet(cardholderService);
		assertTrue("Service request for deactivate wallet has failed", cardholderServiceflw.activateDeactivateWallet(cardholderService).contains("Request has been processed successfully"));
	}
	
	@When ("activate associated wallet for device")
	public void activateSelectedWalletForDevice(){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);		
		cardholderServiceflw.activateDeactivateWallet(cardholderService);
	}
	
	
	
	@When ("activate ecom transaction for $activatePeriod duration")
	public void activateEcommTransaction(String activatePeriod){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);
		cardholderService.setActivationStatusForEcom(activatePeriod);
		cardholderServiceflw.activateEcomTransaction(cardholderService);
	}
	
	@Then ("ecom transaction activation for $duration hours")
	public void setEomTransactionActivationHours(@Named("duration")String duration){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);
		cardholderService.setEcomActivationHour(duration);
		cardholderServiceflw.setEcomActivationHours(cardholderService);
	}
	
	@When ("activation of ecom transaction from $fromDate to $toDate")
	@Given ("activation of ecom transaction from $fromDate to $toDate")
	@Then ("activation of ecom transaction from $fromDate to $toDate")
	public void setStartAndEndDateForEcomTransaction(@Named("fromDate")String fromDate, @Named("toDate")String toDate){
		cardholderServiceflw.setActivationDate(fromDate,toDate);
	}
	
	@When ("activation of ecom transaction for $acivationType")
	@Given ("activation of ecom transaction for $acivationType")
	@Then ("activation of ecom transaction for $acivationType")
	public void enableEcomTransaction(String acivationType){
		CardholderServices cardholderService = CardholderServices.cardholderServicesDataProvider(provider);
		cardholderService.setActivationStatusForEcom(acivationType);		
		assertTrue("Device is already activated for "+ acivationType, cardholderServiceflw.activateEcomTransaction(cardholderService).contains("Activated Successfully"));
	}
	
	@Then ("verify ecom transaction activation status")
	public void verifyEcomActivationStatus(){
		assertTrue("Activate ECOM transaction is failed",cardholderServiceflw.verifyStatusAfterActivation("Activated Successfully"));
	}
	
	@When ("activate international service for $activationinPeriod duration")
	public void activateCardInternationalService(String activationinPeriod){		
		CardholderServices cardholderService = CardholderServices.cardholderInternationalServicesDataProvider(provider);
		cardholderService.setInternationActivationType(activationinPeriod);
		cardholderServiceflw.activateInternationalTransaction(cardholderService);
		assertTrue("International Use activation has failed",cardholderServiceflw.activateInternationalTransaction(cardholderService).contains("Activated Successfully"));
	}
	
	@Given ("activate international service for $activationinPeriod")
	@When ("activate international service for $activationinPeriod")
	@Then ("activate international service for $activationinPeriod")
	public void activateInternationalTransctionService(String activationType){		
		CardholderServices cardholderService = CardholderServices.cardholderInternationalServicesDataProvider(provider);
		cardholderService.setInternationActivationType(activationType);
		assertTrue("International Use activation has failed", cardholderServiceflw.activateInternationalTransaction(cardholderService).contains("Activated Successfully"));
	}
	
	@Then ("activation of international use from $fromDate to $toDate")
	public void setInternationalActiDuration(@Named("fromDate")String fromDate, @Named("toDate")String toDate){
		cardholderServiceflw.selectDateFrnInternationalUse(fromDate,toDate);
	}
	
	@Given ("international use activation hours is $hours")
	@When ("international use activation hours is $hours")
	@Then ("international use activation hours is $hours")
	public void setInternationalUseHours(@Named("hours")String hours){
		cardholderServiceflw.setInternationalUseHours(hours);
	}
	
	@Given ("deactivate $serviceType transaction")
	@When ("deactivate $serviceType transaction")
	@Then ("deactivate $serviceType transaction")
	public void deactivateEcomTransaction(String serviceType){
		if(serviceType.equalsIgnoreCase("ecom")){
			assertTrue("Ecom deactivation is not successfully", cardholderServiceflw.deactivateComTransaction().contains("De-activated Successfully"));	
		}else if(serviceType.equalsIgnoreCase("internationl")){
			assertTrue("International deactivation is not successfully", cardholderServiceflw.deactivateInternationlTransaction().contains("De-activated Successfully"));	
		}
	}
}
