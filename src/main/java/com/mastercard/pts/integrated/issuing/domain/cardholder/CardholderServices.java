package com.mastercard.pts.integrated.issuing.domain.cardholder;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class CardholderServices {

	
	private static final String REPLACEMENT_REASON = "REPLACEMENT_REASON";
	private static final String REPLACE_CONFIRM_MSG = "REPLACE_CONFIRM_MSG";
	private static final String BLOCK_CARD_REMARK = "BLOCK_CARD_REMARK";
	private static final String BLOCK_CONFIRM_MSG = "BLOCK_CONFIRM_MSG";
	private static final String UNBLOCK_CARD_REMARK = "UNBLOCK_CARD_REMARK";
	private static final String UNBLOCK_CONFIRM_CARD_REMARK = "UNBLOCK_CONFIRM_CARD_REMARK";
	private static final String ECOM_ACTIVATION_CONFIRM_MSG = "ECOM_ACTIVATION_CONFIRM_MSG";
	private static final String WALLET_DEACTIVATE_CONFIRM_MSG = "WALLET_DEACTIVATE_CONFIRM_MSG";
	private static final String WALLET_ACTIVATE_CONFIRM_MSG = "WALLET_ACTIVATE_CONFIRM_MSG";
	private static final String WALLET_ACTIVATION_REMARK = "WALLET_ACTIVATION_REMARK";
	private static final String WALLET_DEACTIVATION_REMARK = "WALLET_DEACTIVATION_REMARK";	
	private static final String ECOM_ACTIVATION_HOUR = "ECOM_ACTIVATION_HOUR";
	private static final String ECOM_ACTI_FROM_DATE = "ECOM_ACTI_FROM_DATE";
	private static final String ECOM_ACTI_TO_DATE = "ECOM_ACTI_TO_DATE";
	private static final String INTERNATIONAL_ACTI_FROM_DATE = "INTERNATIONAL_ACTI_FROM_DATE";
	private static final String INTERNATIONAL_ACTI_TO_DATE = "INTERNATIONAL_ACTI_TO_DATE";
	private static final String INTERNATIONAL_ACTIVATION_HOUR = "INTERNATIONAL_ACTIVATION_HOUR";
	private static final String VIRTUAL_CARD_TYPE = "VIRTUAL_CARD_TYPE";
	
	private String replacementReason;	
	private String cardReplacementConfirmationMsg;	
	private String blockCardRemark;	
	private String BlockConfirmationMsg;	
	private String unblockCardRemark;	
	private String unblockConfirmationMsg;
	private String walletActivateRemark;	
	private String walletDeactivateRemark;	
	private String walletActivateConfirmtionMsg;	
	private String activationStatusForEcom;	
	private String ecomFromDate;
	private String ecomToDate;
	private String ecomActivationHour;
	private String internationActivationType;
	private String internationalFromDate;
	private String internationalToDate;
	private String internationalActivationHours;	
	private String virtualCardtype;
	
	public static final String LIFELONG_ACTIVATION = "Life Long Activate";	
	public static final String HOURS_ACTIVATION = "Activation for 'n' hours";	
	public static final String PERIOD_ACTIVATION = "Activation in Period";
	
	public String getVirtualCardtype() {
		return virtualCardtype;
	}
	public void setVirtualCardtype(String virtualCardtype) {
		this.virtualCardtype = virtualCardtype;
	}
	public String getInternationalActivationHours() {
		return internationalActivationHours;
	}

	public void setInternationalActivationHours(String internationalActivationHours) {
		this.internationalActivationHours = internationalActivationHours;
	}
	public String getInternationalFromDate() {
		return internationalFromDate;
	}
	public void setInternationalFromDate(String internationalFromDate) {
		this.internationalFromDate = internationalFromDate;
	}
	public String getInternationalToDate() {
		return internationalToDate;
	}
	public void setInternationalToDate(String internationalToDate) {
		this.internationalToDate = internationalToDate;
	}
	public String getInternationActivationType() {
		return internationActivationType;
	}
	public void setInternationActivationType(String internationActivationType) {
		this.internationActivationType = internationActivationType;
	}
	public String getEcomActivationHour() {
		return ecomActivationHour;
	}

	public void setEcomActivationHour(String ecomActivationHour) {
		this.ecomActivationHour = ecomActivationHour;
	}

	public String getEcomFromDate() {
		return ecomFromDate;
	}

	public void setEcomFromDate(String ecomFromDate) {
		this.ecomFromDate = ecomFromDate;
	}
	public String getEcomToDate() {
		return ecomToDate;
	}
	public void setEcomToDate(String ecomToDate) {
		this.ecomToDate = ecomToDate;
	}
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

	public String getReplacementReason() {
		return replacementReason;
	}

	public void setReplacementReason(String replacementResone) {
		this.replacementReason = replacementResone;
	}
	
	
	
	public static CardholderServices cardholderServicesDataProvider(){
		CardholderServices cardholderService = new CardholderServices();
		cardholderService.setReplacementReason(MapUtils.fnGetInputDataFromMap("ReplacementResone"));
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
		cardholderService.setVirtualCardtype(MapUtils.fnGetInputDataFromMap("virtualCardType"));
		return cardholderService;
	}
	
	public static CardholderServices cardholderServicesDataProvider(KeyValueProvider provider){
		CardholderServices cardholderService = new CardholderServices();
		cardholderService.setReplacementReason(provider.getString(REPLACEMENT_REASON));
		cardholderService.setCardReplacementConfirmationMsg(provider.getString(REPLACE_CONFIRM_MSG));
		cardholderService.setBlockCardRemark(provider.getString(BLOCK_CARD_REMARK));
		cardholderService.setBlockConfirmationMsg(provider.getString(BLOCK_CONFIRM_MSG));
		cardholderService.setUnblockCardRemark(provider.getString(UNBLOCK_CARD_REMARK));
		cardholderService.setUnblockConfirmationMsg(provider.getString(UNBLOCK_CONFIRM_CARD_REMARK));
		cardholderService.setWalletActivateRemark(provider.getString(WALLET_ACTIVATION_REMARK));
		cardholderService.setWalletDeactivateRemark(provider.getString(WALLET_DEACTIVATION_REMARK));
		cardholderService.setWalletActivateConfirmtionMsg(provider.getString(WALLET_ACTIVATE_CONFIRM_MSG));
		cardholderService.setWalletDeactivateConfirmMsg(provider.getString(WALLET_DEACTIVATE_CONFIRM_MSG));
		cardholderService.setActivationStatusForEcom(provider.getString(ECOM_ACTIVATION_CONFIRM_MSG));
		cardholderService.setEcomActivationHour(provider.getString(ECOM_ACTIVATION_HOUR));
		cardholderService.setEcomFromDate(provider.getString(ECOM_ACTI_FROM_DATE));
		cardholderService.setEcomToDate(provider.getString(ECOM_ACTI_TO_DATE));
		cardholderService.setInternationalFromDate(provider.getString(INTERNATIONAL_ACTI_FROM_DATE));
		cardholderService.setInternationalToDate(provider.getString(INTERNATIONAL_ACTI_TO_DATE));
		cardholderService.setInternationalActivationHours(provider.getString(INTERNATIONAL_ACTIVATION_HOUR));
		cardholderService.setVirtualCardtype(provider.getString(VIRTUAL_CARD_TYPE));		
		return cardholderService;
	}
	
	public static CardholderServices cardholderInternationalServicesDataProvider(KeyValueProvider provider){
		CardholderServices cardholderService = new CardholderServices();
		cardholderService.setReplacementReason(provider.getString(REPLACEMENT_REASON));
		cardholderService.setCardReplacementConfirmationMsg(provider.getString(REPLACE_CONFIRM_MSG));
		cardholderService.setBlockCardRemark(provider.getString(BLOCK_CARD_REMARK));
		cardholderService.setBlockConfirmationMsg(provider.getString(BLOCK_CONFIRM_MSG));
		cardholderService.setUnblockCardRemark(provider.getString(UNBLOCK_CARD_REMARK));
		cardholderService.setUnblockConfirmationMsg(provider.getString(UNBLOCK_CONFIRM_CARD_REMARK));
		cardholderService.setWalletActivateRemark(provider.getString(WALLET_ACTIVATION_REMARK));
		cardholderService.setWalletDeactivateRemark(provider.getString(WALLET_DEACTIVATION_REMARK));
		cardholderService.setWalletActivateConfirmtionMsg(provider.getString(WALLET_ACTIVATE_CONFIRM_MSG));
		cardholderService.setWalletDeactivateConfirmMsg(provider.getString(WALLET_DEACTIVATE_CONFIRM_MSG));
		cardholderService.setActivationStatusForEcom(provider.getString(ECOM_ACTIVATION_CONFIRM_MSG));
		cardholderService.setEcomActivationHour(provider.getString(ECOM_ACTIVATION_HOUR));
		cardholderService.setEcomFromDate(provider.getString(ECOM_ACTI_FROM_DATE));
		cardholderService.setEcomToDate(provider.getString(ECOM_ACTI_TO_DATE));
		cardholderService.setInternationalFromDate(provider.getString(INTERNATIONAL_ACTI_FROM_DATE));
		cardholderService.setInternationalToDate(provider.getString(INTERNATIONAL_ACTI_TO_DATE));
		cardholderService.setInternationalToDate(provider.getString(INTERNATIONAL_ACTIVATION_HOUR));
		cardholderService.setVirtualCardtype(provider.getString(VIRTUAL_CARD_TYPE));
		return cardholderService;
	}
}
