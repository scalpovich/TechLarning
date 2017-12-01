package com.mastercard.pts.integrated.issuing.domain.cardholder;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class CardholderServices {

	
	public String replacementResone;
	
	public String cardReplacementConfirmationMsg;
	
	public String blockCardRemark;
	
	public String BlockConfirmationMsg;
	
	public String unblockCardRemark;
	
	public String unblockConfirmationMsg;

	public String walletActivateRemark;
	
	public String walletDeactivateRemark;
	
	public String walletActivateConfirmtionMsg;
	
	public String activationStatusForEcom;
	
	public static final String ECOM_LIELONG_ACTIVATION ="Life Long Activate";
	
	public static final String ECOM_HOURS_ACTIVATION ="Activation for 'n' hours";
	
	public static final String ECOM_PERIOD_ACTIVATION = "Activation in Period";
	
	public String getActivationStatusForEcom() {
		return activationStatusForEcom;
	}

	public void setActivationStatusForEcom(String activationStatusForEcom) {
		this.activationStatusForEcom = activationStatusForEcom;
	}

	
	public String getWalletActivateConfirmtionMsg() {
		return walletActivateConfirmtionMsg;
	}

	public void setWalletActivateConfirmtionMsg(String walletActivateConfirmtionMsg) {
		this.walletActivateConfirmtionMsg = walletActivateConfirmtionMsg;
	}

	public String getWalletDeactivateConfirmMsg() {
		return walletDeactivateConfirmMsg;
	}

	public void setWalletDeactivateConfirmMsg(String walletDeactivateConfirmMsg) {
		this.walletDeactivateConfirmMsg = walletDeactivateConfirmMsg;
	}


	public String walletDeactivateConfirmMsg;
	
	public String getWalletActivateRemark() {
		return walletActivateRemark;
	}

	public void setWalletActivateRemark(String walletActivateRemark) {
		this.walletActivateRemark = walletActivateRemark;
	}

	public String getWalletDeactivateRemark() {
		return walletDeactivateRemark;
	}

	public void setWalletDeactivateRemark(String walletDeactivateRemark) {
		this.walletDeactivateRemark = walletDeactivateRemark;
	}
	
	public String getUnblockConfirmationMsg() {
		return unblockConfirmationMsg;
	}

	public void setUnblockConfirmationMsg(String unblockConfirmationMsg) {
		this.unblockConfirmationMsg = unblockConfirmationMsg;
	}

	public String getUnblockCardRemark() {
		return unblockCardRemark;
	}

	public void setUnblockCardRemark(String unblockCardRemark) {
		this.unblockCardRemark = unblockCardRemark;
	}

	public String getBlockConfirmationMsg() {
		return BlockConfirmationMsg;
	}

	public void setBlockConfirmationMsg(String blockConfirmationMsg) {
		BlockConfirmationMsg = blockConfirmationMsg;
	}

	public String getBlockCardRemark() {
		return blockCardRemark;
	}

	public void setBlockCardRemark(String blockCardRemark) {
		this.blockCardRemark = blockCardRemark;
	}

	public String getCardReplacementConfirmationMsg() {
		return cardReplacementConfirmationMsg;
	}

	public void setCardReplacementConfirmationMsg(String cardReplacementConfirmationMsg) {
		this.cardReplacementConfirmationMsg = cardReplacementConfirmationMsg;
	}

	public String getReplacementResone() {
		return replacementResone;
	}

	public void setReplacementResone(String replacementResone) {
		this.replacementResone = replacementResone;
	}
	
	
	
	public static CardholderServices cardholderServicesDataProvider(){
		CardholderServices cardholderService = new CardholderServices();
		cardholderService.setReplacementResone(MapUtils.fnGetInputDataFromMap("ReplacementResone"));
		cardholderService.setCardReplacementConfirmationMsg(MapUtils.fnGetInputDataFromMap("ReplaceConfirmMessage"));
		cardholderService.setBlockCardRemark(MapUtils.fnGetInputDataFromMap("BlockCardRemark"));
		cardholderService.setBlockConfirmationMsg(MapUtils.fnGetInputDataFromMap("BlockConfirmationMsg"));
		cardholderService.setUnblockCardRemark(MapUtils.fnGetInputDataFromMap("UnblockCardRemark"));
		cardholderService.setUnblockConfirmationMsg(MapUtils.fnGetInputDataFromMap("UnblockConfirmationMsg"));
		cardholderService.setWalletActivateRemark(MapUtils.fnGetInputDataFromMap("UnblockConfirmationMsg"));
		cardholderService.setWalletDeactivateRemark(MapUtils.fnGetInputDataFromMap("UnblockConfirmationMsg"));
		cardholderService.setWalletActivateConfirmtionMsg(MapUtils.fnGetInputDataFromMap("WalletActivateConfirmMsg"));
		cardholderService.setWalletDeactivateConfirmMsg(MapUtils.fnGetInputDataFromMap("WalletDeactivateConfirmMsg"));
		cardholderService.setActivationStatusForEcom(MapUtils.fnGetInputDataFromMap("eComActivationConfirmMsg"));		
		return cardholderService;
	}
	
	public static CardholderServices cardholderInternationalServicesDataProvider(){
		CardholderServices cardholderService = new CardholderServices();
		
		return cardholderService;
	}
}
