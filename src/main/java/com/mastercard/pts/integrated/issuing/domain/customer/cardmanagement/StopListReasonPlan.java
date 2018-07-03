package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.poi.util.SystemOutLogger;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class StopListReasonPlan {
	 private static final String  REASON_CODE_LOST="REASON_CODE_LOST";
	 private static final String  DESCRIPTION_LOST="DESCRIPTION_LOST";
	 private static final String  STICKY_LOST="STICKY_LOST";
	 private static final String  SENT_TO_MASTER_LOST="SENT_TO_MASTER_LOST";
	 private static final String  REGION_MASTERCARD_LOST="REGION_MASTERCARD_LOST";
	 private static final String  SENT_TO_VISA_LOST="SENT_TO_VISA_LOST";
	 private static final String  REGION_VISA_LOST="REGION_VISA_LOST";
	 private static final String  SENT_TO_RUPAY_LOST="SENT_TO_RUPAY_LOST";
	 private static final String  SENT_TO_AMEX_LOST="SENT_TO_AMEX_LOST";
	 private static final String  REASON_CODE_STOLEN="REASON_CODE_STOLEN";
	 private static final String  DESCRIPTION_STOLEN="DESCRIPTION_STOLEN";
	 private static final String  STICKY_STOLEN="STICKY_STOLEN";
	 private static final String  SENT_TO_MASTER_STOLEN="SENT_TO_MASTER_STOLEN";
	 private static final String  REGION_MASTERCARD_STOLEN="REGION_MASTERCARD_STOLEN";
	 private static final String  SENT_TO_VISA_STOLEN="SENT_TO_VISA_STOLEN";
	 private static final String  REGION_VISA_STOLEN="REGION_VISA_STOLEN";
	 private static final String  SENT_TO_RUPAY_STOLEN="SENT_TO_RUPAY_STOLEN";
	 private static final String  SENT_TO_AMEX_STOLEN="SENT_TO_AMEX_STOLEN";
	 private static final String  REASON_CODE_COUNTERFEIT="REASON_CODE_COUNTERFEIT";
	 private static final String  DESCRIPTION_COUNTERFEIT="DESCRIPTION_COUNTERFEIT";
	 private static final String  STICKY_COUNTERFEIT="STICKY_COUNTERFEIT";
	 private static final String  SENT_TO_MASTER_COUNTERFEIT="SENT_TO_MASTER_COUNTERFEIT";
	 private static final String  REGION_MASTERCARD_COUNTERFEIT="REGION_MASTERCARD_COUNTERFEIT";
	 private static final String  SENT_TO_VISA_COUNTERFEIT="SENT_TO_VISA_COUNTERFEIT";
	 private static final String  REGION_VISA_COUNTERFEIT="REGION_VISA_COUNTERFEIT";
	 private static final String  SENT_TO_RUPAY_COUNTERFEIT="SENT_TO_RUPAY_COUNTERFEIT";
	 private static final String  SENT_TO_AMEX_COUNTERFEIT="SENT_TO_AMEX_COUNTERFEIT";
	 private static final String  REASON_CODE_RETURNED="REASON_CODE_RETURNED";
	 private static final String  DESCRIPTION_RETURNED="DESCRIPTION_RETURNED";
	 private static final String  STICKY_RETURNED="STICKY_RETURNED";
	 private static final String  SENT_TO_MASTER_RETURNED="SENT_TO_MASTER_RETURNED";
	 private static final String  REGION_MASTERCARD_RETURNED="REGION_MASTERCARD_RETURNED";
	 private static final String  SENT_TO_VISA_RETURNED="SENT_TO_VISA_RETURNED";
	 private static final String  REGION_VISA_RETURNED="REGION_VISA_RETURNED";
	 private static final String  SENT_TO_RUPAY_RETURNED="SENT_TO_RUPAY_RETURNED";
	 private static final String  SENT_TO_AMEX_RETURNED="SENT_TO_AMEX_RETURNED";
	 private static final String  REASON_CODE_EXPIRED="REASON_CODE_EXPIRED";
	 private static final String  DESCRIPTION_EXPIRED="DESCRIPTION_EXPIRED";
	 private static final String  STICKY_EXPIRED="STICKY_EXPIRED";
	 private static final String  SENT_TO_MASTER_EXPIRED="SENT_TO_MASTER_EXPIRED";
	 private static final String  REGION_MASTERCARD_EXPIRED="REGION_MASTERCARD_EXPIRED";
	 private static final String  SENT_TO_VISA_EXPIRED="SENT_TO_VISA_EXPIRED";
	 private static final String  REGION_VISA_EXPIRED="REGION_VISA_EXPIRED";
	 private static final String  SENT_TO_RUPAY_EXPIRED="SENT_TO_RUPAY_EXPIRED";
	 private static final String  SENT_TO_AMEX_EXPIRED="SENT_TO_AMEX_EXPIRED";
	 private static final String  REASON_CODE_DAMAGED="REASON_CODE_DAMAGED";
	 private static final String  DESCRIPTION_DAMAGED="DESCRIPTION_DAMAGED";
	 private static final String  STICKY_DAMAGED="STICKY_DAMAGED";
	 private static final String  SENT_TO_MASTER_DAMAGED="SENT_TO_MASTER_DAMAGED";
	 private static final String  REGION_MASTERCARD_DAMAGED="REGION_MASTERCARD_DAMAGED";
	 private static final String  SENT_TO_VISA_DAMAGED="SENT_TO_VISA_DAMAGED";
	 private static final String  REGION_VISA_DAMAGED="REGION_VISA_DAMAGED";
	 private static final String  SENT_TO_RUPAY_DAMAGED="SENT_TO_RUPAY_DAMAGED";
	 private static final String  SENT_TO_AMEX_DAMAGED="SENT_TO_AMEX_DAMAGED";
	 private static final String  REASON_CODE_EMERGENCY="REASON_CODE_EMERGENCY";
	 private static final String  DESCRIPTION_EMERGENCY="DESCRIPTION_EMERGENCY";
	 private static final String  STICKY_EMERGENCY="STICKY_EMERGENCY";
	 private static final String  SENT_TO_MASTER_EMERGENCY="SENT_TO_MASTER_EMERGENCY";
	 private static final String  REGION_MASTERCARD_EMERGENCY="REGION_MASTERCARD_EMERGENCY";
	 private static final String  SENT_TO_VISA_EMERGENCY="SENT_TO_VISA_EMERGENCY";
	 private static final String  REGION_VISA_EMERGENCY="REGION_VISA_EMERGENCY";
	 private static final String  SENT_TO_RUPAY_EMERGENCY="SENT_TO_RUPAY_EMERGENCY";
	 private static final String  SENT_TO_AMEX_EMERGENCY="SENT_TO_AMEX_EMERGENCY";
	 private static final String  REASON_CODE_ERRONEOUS="REASON_CODE_ERRONEOUS";
	 private static final String  DESCRIPTION_ERRONEOUS="DESCRIPTION_ERRONEOUS";
	 private static final String  STICKY_ERRONEOUS="STICKY_ERRONEOUS";
	 private static final String  SENT_TO_MASTER_ERRONEOUS="SENT_TO_MASTER_ERRONEOUS";
	 private static final String  REGION_MASTERCARD_ERRONEOUS="REGION_MASTERCARD_ERRONEOUS";
	 private static final String  SENT_TO_VISA_ERRONEOUS="SENT_TO_VISA_ERRONEOUS";
	 private static final String  REGION_VISA_ERRONEOUS="REGION_VISA_ERRONEOUS";
	 private static final String  SENT_TO_RUPAY_ERRONEOUS="SENT_TO_RUPAY_ERRONEOUS";
	 private static final String  SENT_TO_AMEX_ERRONEOUS="SENT_TO_AMEX_ERRONEOUS";
	
	 private String reasonCodeLost;
	 private String descriptionLost;
	 private String stickyLost;
	 private String sentToMasterLost;
	 private String regionMastercardLost;
	 private String sentToVisaLost;
	 private String regionVisaLost;
	 private String sentToRupayLost;
	 private String sentToAmexLost;
	 private String reasonCodeStolen;
	 private String descriptionStolen;
	 private String stickyStolen;
	 private String sentToMasterStolen;
	 private String regionMastercardStolen;
	 private String sentToVisaStolen;
	 private String regionVisaStolen;
	 private String sentToRupayStolen;
	 private String sentToAmexStolen;
	 private String reasonCodeCounterfeit;
	 private String descriptionCounterfeit;
	 private String stickyCounterfeit;
	 private String sentToMasterCounterfeit;
	 private String regionMastercardCounterfeit;
	 private String sentToVisaCounterfeit;
	 private String regionVisaCounterfeit;
	 private String sentToRupayCounterfeit;
	 private String sentToAmexCounterfeit;
	 private String reasonCodeReturned;
	 private String descriptionReturned;
	 private String stickyReturned;
	 private String sentToMasterReturned;
	 private String regionMastercardReturned;
	 private String sentToVisaReturned;
	 private String regionVisaReturned;
	 private String sentToRupayReturned;
	 private String sentToAmexReturned;
	 private String reasonCodeExpired;
	 private String descriptionExpired;
	 private String stickyExpired;
	 private String sentToMasterExpired;
	 private String regionMastercardExpired;
	 private String sentToVisaExpired;
	 private String regionVisaExpired;
	 private String sentToRupayExpired;
	 private String sentToAmexExpired;
	 private String reasonCodeDamaged;
	 private String descriptionDamaged;
	 private String stickyDamaged;
	 private String sentToMasterDamaged;
	 private String regionMastercardDamaged;
	 private String sentToVisaDamaged;
	 private String regionVisaDamaged;
	 private String sentToRupayDamaged;
	 private String sentToAmexDamaged;
	 private String reasonCodeEmergency;
	 private String descriptionEmergency;
	 private String stickyEmergency;
	 private String sentToMasterEmergency;
	 private String regionMastercardEmergency;
	 private String sentToVisaEmergency;
	 private String regionVisaEmergency;
	 private String sentToRupayEmergency;
	 private String sentToAmexEmergency;
	 private String reasonCodeErroneous;
	 private String descriptionErroneous;
	 private String stickyErroneous;
	 private String sentToMasterErroneous;
	 private String regionMastercardErroneous;
	 private String sentToVisaErroneous;
	 private String regionVisaErroneous;
	 private String sentToRupayErroneous;
	 private String sentToAmexErroneous;
	public String getReasonCodeLost() {
		return reasonCodeLost;
	}
	public void setReasonCodeLost(String reasonCodeLost) {
		this.reasonCodeLost = reasonCodeLost;
	}
	public String getDescriptionLost() {
		return descriptionLost;
	}
	public void setDescriptionLost(String descriptionLost) {
		this.descriptionLost = descriptionLost;
	}
	public String getStickyLost() {
		return stickyLost;
	}
	public void setStickyLost(String stickyLost) {
		this.stickyLost = stickyLost;
	}
	public String getSentToMasterLost() {
		return sentToMasterLost;
	}
	public void setSentToMasterLost(String sentToMasterLost) {
		this.sentToMasterLost = sentToMasterLost;
	}
	public String getRegionMastercardLost() {
		return regionMastercardLost;
	}
	public void setRegionMastercardLost(String regionMastercardLost) {
		this.regionMastercardLost = regionMastercardLost;
	}
	public String getSentToVisaLost() {
		return sentToVisaLost;
	}
	public void setSentToVisaLost(String sentToVisaLost) {
		this.sentToVisaLost = sentToVisaLost;
	}
	public String getRegionVisaLost() {
		return regionVisaLost;
	}
	public void setRegionVisaLost(String regionVisaLost) {
		this.regionVisaLost = regionVisaLost;
	}
	public String getSentToRupayLost() {
		return sentToRupayLost;
	}
	public void setSentToRupayLost(String sentToRupayLost) {
		this.sentToRupayLost = sentToRupayLost;
	}
	public String getSentToAmexLost() {
		return sentToAmexLost;
	}
	public void setSentToAmexLost(String sentToAmexLost) {
		this.sentToAmexLost = sentToAmexLost;
	}
	public String getReasonCodeStolen() {
		return reasonCodeStolen;
	}
	public void setReasonCodeStolen(String reasonCodeStolen) {
		this.reasonCodeStolen = reasonCodeStolen;
	}
	public String getDescriptionStolen() {
		return descriptionStolen;
	}
	public void setDescriptionStolen(String descriptionStolen) {
		this.descriptionStolen = descriptionStolen;
	}
	public String getStickyStolen() {
		return stickyStolen;
	}
	public void setStickyStolen(String stickyStolen) {
		this.stickyStolen = stickyStolen;
	}
	public String getSentToMasterStolen() {
		return sentToMasterStolen;
	}
	public void setSentToMasterStolen(String sentToMasterStolen) {
		this.sentToMasterStolen = sentToMasterStolen;
	}
	public String getRegionMastercardStolen() {
		return regionMastercardStolen;
	}
	public void setRegionMastercardStolen(String regionMastercardStolen) {
		this.regionMastercardStolen = regionMastercardStolen;
	}
	public String getSentToVisaStolen() {
		return sentToVisaStolen;
	}
	public void setSentToVisaStolen(String sentToVisaStolen) {
		this.sentToVisaStolen = sentToVisaStolen;
	}
	public String getRegionVisaStolen() {
		return regionVisaStolen;
	}
	public void setRegionVisaStolen(String regionVisaStolen) {
		this.regionVisaStolen = regionVisaStolen;
	}
	public String getSentToRupayStolen() {
		return sentToRupayStolen;
	}
	public void setSentToRupayStolen(String sentToRupayStolen) {
		this.sentToRupayStolen = sentToRupayStolen;
	}
	public String getSentToAmexStolen() {
		return sentToAmexStolen;
	}
	public void setSentToAmexStolen(String sentToAmexStolen) {
		this.sentToAmexStolen = sentToAmexStolen;
	}
	public String getReasonCodeCounterfeit() {
		return reasonCodeCounterfeit;
	}
	public void setReasonCodeCounterfeit(String reasonCodeCounterfeit) {
		this.reasonCodeCounterfeit = reasonCodeCounterfeit;
	}
	public String getDescriptionCounterfeit() {
		return descriptionCounterfeit;
	}
	public void setDescriptionCounterfeit(String descriptionCounterfeit) {
		this.descriptionCounterfeit = descriptionCounterfeit;
	}
	public String getStickyCounterfeit() {
		return stickyCounterfeit;
	}
	public void setStickyCounterfeit(String stickyCounterfeit) {
		this.stickyCounterfeit = stickyCounterfeit;
	}
	public String getSentToMasterCounterfeit() {
		return sentToMasterCounterfeit;
	}
	public void setSentToMasterCounterfeit(String sentToMasterCounterfeit) {
		this.sentToMasterCounterfeit = sentToMasterCounterfeit;
	}
	public String getRegionMastercardCounterfeit() {
		return regionMastercardCounterfeit;
	}
	public void setRegionMastercardCounterfeit(String regionMastercardCounterfeit) {
		this.regionMastercardCounterfeit = regionMastercardCounterfeit;
	}
	public String getSentToVisaCounterfeit() {
		return sentToVisaCounterfeit;
	}
	public void setSentToVisaCounterfeit(String sentToVisaCounterfeit) {
		this.sentToVisaCounterfeit = sentToVisaCounterfeit;
	}
	public String getRegionVisaCounterfeit() {
		return regionVisaCounterfeit;
	}
	public void setRegionVisaCounterfeit(String regionVisaCounterfeit) {
		this.regionVisaCounterfeit = regionVisaCounterfeit;
	}
	public String getSentToRupayCounterfeit() {
		return sentToRupayCounterfeit;
	}
	public void setSentToRupayCounterfeit(String sentToRupayCounterfeit) {
		this.sentToRupayCounterfeit = sentToRupayCounterfeit;
	}
	public String getSentToAmexCounterfeit() {
		return sentToAmexCounterfeit;
	}
	public void setSentToAmexCounterfeit(String sentToAmexCounterfeit) {
		this.sentToAmexCounterfeit = sentToAmexCounterfeit;
	}
	public String getReasonCodeReturned() {
		return reasonCodeReturned;
	}
	public void setReasonCodeReturned(String reasonCodeReturned) {
		this.reasonCodeReturned = reasonCodeReturned;
	}
	public String getDescriptionReturned() {
		return descriptionReturned;
	}
	public void setDescriptionReturned(String descriptionReturned) {
		this.descriptionReturned = descriptionReturned;
	}
	public String getStickyReturned() {
		return stickyReturned;
	}
	public void setStickyReturned(String stickyReturned) {
		this.stickyReturned = stickyReturned;
	}
	public String getSentToMasterReturned() {
		return sentToMasterReturned;
	}
	public void setSentToMasterReturned(String sentToMasterReturned) {
		this.sentToMasterReturned = sentToMasterReturned;
	}
	public String getRegionMastercardReturned() {
		return regionMastercardReturned;
	}
	public void setRegionMastercardReturned(String regionMastercardReturned) {
		this.regionMastercardReturned = regionMastercardReturned;
	}
	public String getSentToVisaReturned() {
		return sentToVisaReturned;
	}
	public void setSentToVisaReturned(String sentToVisaReturned) {
		this.sentToVisaReturned = sentToVisaReturned;
	}
	public String getRegionVisaReturned() {
		return regionVisaReturned;
	}
	public void setRegionVisaReturned(String regionVisaReturned) {
		this.regionVisaReturned = regionVisaReturned;
	}
	public String getSentToRupayReturned() {
		return sentToRupayReturned;
	}
	public void setSentToRupayReturned(String sentToRupayReturned) {
		this.sentToRupayReturned = sentToRupayReturned;
	}
	public String getSentToAmexReturned() {
		return sentToAmexReturned;
	}
	public void setSentToAmexReturned(String sentToAmexReturned) {
		this.sentToAmexReturned = sentToAmexReturned;
	}
	public String getReasonCodeExpired() {
		return reasonCodeExpired;
	}
	public void setReasonCodeExpired(String reasonCodeExpired) {
		this.reasonCodeExpired = reasonCodeExpired;
	}
	public String getDescriptionExpired() {
		return descriptionExpired;
	}
	public void setDescriptionExpired(String descriptionExpired) {
		this.descriptionExpired = descriptionExpired;
	}
	public String getStickyExpired() {
		return stickyExpired;
	}
	public void setStickyExpired(String stickyExpired) {
		this.stickyExpired = stickyExpired;
	}
	public String getSentToMasterExpired() {
		return sentToMasterExpired;
	}
	public void setSentToMasterExpired(String sentToMasterExpired) {
		this.sentToMasterExpired = sentToMasterExpired;
	}
	public String getRegionMastercardExpired() {
		return regionMastercardExpired;
	}
	public void setRegionMastercardExpired(String regionMastercardExpired) {
		this.regionMastercardExpired = regionMastercardExpired;
	}
	public String getSentToVisaExpired() {
		return sentToVisaExpired;
	}
	public void setSentToVisaExpired(String sentToVisaExpired) {
		this.sentToVisaExpired = sentToVisaExpired;
	}
	public String getRegionVisaExpired() {
		return regionVisaExpired;
	}
	public void setRegionVisaExpired(String regionVisaExpired) {
		this.regionVisaExpired = regionVisaExpired;
	}
	public String getSentToRupayExpired() {
		return sentToRupayExpired;
	}
	public void setSentToRupayExpired(String sentToRupayExpired) {
		this.sentToRupayExpired = sentToRupayExpired;
	}
	public String getSentToAmexExpired() {
		return sentToAmexExpired;
	}
	public void setSentToAmexExpired(String sentToAmexExpired) {
		this.sentToAmexExpired = sentToAmexExpired;
	}
	public String getReasonCodeDamaged() {
		return reasonCodeDamaged;
	}
	public void setReasonCodeDamaged(String reasonCodeDamaged) {
		this.reasonCodeDamaged = reasonCodeDamaged;
	}
	public String getDescriptionDamaged() {
		return descriptionDamaged;
	}
	public void setDescriptionDamaged(String descriptionDamaged) {
		this.descriptionDamaged = descriptionDamaged;
	}
	public String getStickyDamaged() {
		return stickyDamaged;
	}
	public void setStickyDamaged(String stickyDamaged) {
		this.stickyDamaged = stickyDamaged;
	}
	public String getSentToMasterDamaged() {
		return sentToMasterDamaged;
	}
	public void setSentToMasterDamaged(String sentToMasterDamaged) {
		this.sentToMasterDamaged = sentToMasterDamaged;
	}
	public String getRegionMastercardDamaged() {
		return regionMastercardDamaged;
	}
	public void setRegionMastercardDamaged(String regionMastercardDamaged) {
		this.regionMastercardDamaged = regionMastercardDamaged;
	}
	public String getSentToVisaDamaged() {
		return sentToVisaDamaged;
	}
	public void setSentToVisaDamaged(String sentToVisaDamaged) {
		this.sentToVisaDamaged = sentToVisaDamaged;
	}
	public String getRegionVisaDamaged() {
		return regionVisaDamaged;
	}
	public void setRegionVisaDamaged(String regionVisaDamaged) {
		this.regionVisaDamaged = regionVisaDamaged;
	}
	public String getSentToRupayDamaged() {
		return sentToRupayDamaged;
	}
	public void setSentToRupayDamaged(String sentToRupayDamaged) {
		this.sentToRupayDamaged = sentToRupayDamaged;
	}
	public String getSentToAmexDamaged() {
		return sentToAmexDamaged;
	}
	public void setSentToAmexDamaged(String sentToAmexDamaged) {
		this.sentToAmexDamaged = sentToAmexDamaged;
	}
	public String getReasonCodeEmergency() {
		return reasonCodeEmergency;
	}
	public void setReasonCodeEmergency(String reasonCodeEmergency) {
		this.reasonCodeEmergency = reasonCodeEmergency;
	}
	public String getDescriptionEmergency() {
		return descriptionEmergency;
	}
	public void setDescriptionEmergency(String descriptionEmergency) {
		this.descriptionEmergency = descriptionEmergency;
	}
	public String getStickyEmergency() {
		return stickyEmergency;
	}
	public void setStickyEmergency(String stickyEmergency) {
		this.stickyEmergency = stickyEmergency;
	}
	public String getSentToMasterEmergency() {
		return sentToMasterEmergency;
	}
	public void setSentToMasterEmergency(String sentToMasterEmergency) {
		this.sentToMasterEmergency = sentToMasterEmergency;
	}
	public String getRegionMastercardEmergency() {
		return regionMastercardEmergency;
	}
	public void setRegionMastercardEmergency(String regionMastercardEmergency) {
		this.regionMastercardEmergency = regionMastercardEmergency;
	}
	public String getSentToVisaEmergency() {
		return sentToVisaEmergency;
	}
	public void setSentToVisaEmergency(String sentToVisaEmergency) {
		this.sentToVisaEmergency = sentToVisaEmergency;
	}
	public String getRegionVisaEmergency() {
		return regionVisaEmergency;
	}
	public void setRegionVisaEmergency(String regionVisaEmergency) {
		this.regionVisaEmergency = regionVisaEmergency;
	}
	public String getSentToRupayEmergency() {
		return sentToRupayEmergency;
	}
	public void setSentToRupayEmergency(String sentToRupayEmergency) {
		this.sentToRupayEmergency = sentToRupayEmergency;
	}
	public String getSentToAmexEmergency() {
		return sentToAmexEmergency;
	}
	public void setSentToAmexEmergency(String sentToAmexEmergency) {
		this.sentToAmexEmergency = sentToAmexEmergency;
	}
	public String getReasonCodeErroneous() {
		return reasonCodeErroneous;
	}
	public void setReasonCodeErroneous(String reasonCodeErroneous) {
		this.reasonCodeErroneous = reasonCodeErroneous;
	}
	public String getDescriptionErroneous() {
		return descriptionErroneous;
	}
	public void setDescriptionErroneous(String descriptionErroneous) {
		this.descriptionErroneous = descriptionErroneous;
	}
	public String getStickyErroneous() {
		return stickyErroneous;
	}
	public void setStickyErroneous(String stickyErroneous) {
		this.stickyErroneous = stickyErroneous;
	}
	public String getSentToMasterErroneous() {
		return sentToMasterErroneous;
	}
	public void setSentToMasterErroneous(String sentToMasterErroneous) {
		this.sentToMasterErroneous = sentToMasterErroneous;
	}
	public String getRegionMastercardErroneous() {
		return regionMastercardErroneous;
	}
	public void setRegionMastercardErroneous(String regionMastercardErroneous) {
		this.regionMastercardErroneous = regionMastercardErroneous;
	}
	public String getSentToVisaErroneous() {
		return sentToVisaErroneous;
	}
	public void setSentToVisaErroneous(String sentToVisaErroneous) {
		this.sentToVisaErroneous = sentToVisaErroneous;
	}
	public String getRegionVisaErroneous() {
		return regionVisaErroneous;
	}
	public void setRegionVisaErroneous(String regionVisaErroneous) {
		this.regionVisaErroneous = regionVisaErroneous;
	}
	public String getSentToRupayErroneous() {
		return sentToRupayErroneous;
	}
	public void setSentToRupayErroneous(String sentToRupayErroneous) {
		this.sentToRupayErroneous = sentToRupayErroneous;
	}
	public String getSentToAmexErroneous() {
		return sentToAmexErroneous;
	}
	public void setSentToAmexErroneous(String sentToAmexErroneous) {
		this.sentToAmexErroneous = sentToAmexErroneous;
	}
	
	public static StopListReasonPlan createWithProvider(KeyValueProvider provider) {
		StopListReasonPlan plan = new StopListReasonPlan();
		plan.setReasonCodeLost(provider.getString(REASON_CODE_LOST));
		plan.setDescriptionLost(provider.getString(DESCRIPTION_LOST));
		plan.setStickyLost(provider.getString(STICKY_LOST));
		plan.setSentToMasterLost(provider.getString(SENT_TO_AMEX_LOST));
		plan.setRegionMastercardLost(provider.getString(REGION_MASTERCARD_LOST));
		plan.setSentToVisaLost(provider.getString(SENT_TO_VISA_LOST));
		plan.setRegionVisaLost(provider.getString(REGION_VISA_LOST));
		plan.setSentToAmexLost(provider.getString(SENT_TO_AMEX_LOST));
		plan.setSentToRupayLost(provider.getString(SENT_TO_RUPAY_LOST));
		plan.setReasonCodeStolen(provider.getString(REASON_CODE_STOLEN));
		plan.setDescriptionStolen(provider.getString(DESCRIPTION_STOLEN));
		plan.setStickyStolen(provider.getString(STICKY_STOLEN));
		plan.setSentToMasterStolen(provider.getString(SENT_TO_AMEX_STOLEN));
		plan.setRegionMastercardStolen(provider.getString(REGION_MASTERCARD_STOLEN));
		plan.setSentToVisaStolen(provider.getString(SENT_TO_VISA_STOLEN));
		plan.setRegionVisaStolen(provider.getString(REGION_VISA_STOLEN));
		plan.setSentToAmexStolen(provider.getString(SENT_TO_AMEX_STOLEN));
		plan.setSentToRupayStolen(provider.getString(SENT_TO_RUPAY_STOLEN));
		plan.setReasonCodeCounterfeit(provider.getString(REASON_CODE_COUNTERFEIT));
		plan.setDescriptionCounterfeit(provider.getString(DESCRIPTION_COUNTERFEIT));
		plan.setStickyCounterfeit(provider.getString(STICKY_COUNTERFEIT));
		plan.setSentToMasterCounterfeit(provider.getString(SENT_TO_AMEX_COUNTERFEIT));
		plan.setRegionMastercardCounterfeit(provider.getString(REGION_MASTERCARD_COUNTERFEIT));
		plan.setSentToVisaCounterfeit(provider.getString(SENT_TO_VISA_COUNTERFEIT));
		plan.setRegionVisaCounterfeit(provider.getString(REGION_VISA_COUNTERFEIT));
		plan.setSentToAmexCounterfeit(provider.getString(SENT_TO_AMEX_COUNTERFEIT));
		plan.setSentToRupayCounterfeit(provider.getString(SENT_TO_RUPAY_COUNTERFEIT));
		plan.setReasonCodeReturned(provider.getString(REASON_CODE_RETURNED));
		plan.setDescriptionReturned(provider.getString(DESCRIPTION_RETURNED));
		plan.setStickyReturned(provider.getString(STICKY_RETURNED));
		plan.setSentToMasterReturned(provider.getString(SENT_TO_AMEX_RETURNED));
		plan.setRegionMastercardReturned(provider.getString(REGION_MASTERCARD_RETURNED));
		plan.setSentToVisaReturned(provider.getString(SENT_TO_VISA_RETURNED));
		plan.setRegionVisaReturned(provider.getString(REGION_VISA_RETURNED));
		plan.setSentToAmexReturned(provider.getString(SENT_TO_AMEX_RETURNED));
		plan.setSentToRupayReturned(provider.getString(SENT_TO_RUPAY_RETURNED));
		plan.setReasonCodeExpired(provider.getString(REASON_CODE_EXPIRED));
		plan.setDescriptionExpired(provider.getString(DESCRIPTION_EXPIRED));
		plan.setStickyExpired(provider.getString(STICKY_EXPIRED));
		plan.setSentToMasterExpired(provider.getString(SENT_TO_AMEX_EXPIRED));
		plan.setRegionMastercardExpired(provider.getString(REGION_MASTERCARD_EXPIRED));
		plan.setSentToVisaExpired(provider.getString(SENT_TO_VISA_EXPIRED));
		plan.setRegionVisaExpired(provider.getString(REGION_VISA_EXPIRED));
		plan.setSentToAmexExpired(provider.getString(SENT_TO_AMEX_EXPIRED));
		plan.setSentToRupayExpired(provider.getString(SENT_TO_RUPAY_EXPIRED));
		plan.setReasonCodeDamaged(provider.getString(REASON_CODE_DAMAGED));
		plan.setDescriptionDamaged(provider.getString(DESCRIPTION_DAMAGED));
		plan.setStickyDamaged(provider.getString(STICKY_DAMAGED));
		plan.setSentToMasterDamaged(provider.getString(SENT_TO_AMEX_DAMAGED));
		plan.setRegionMastercardDamaged(provider.getString(REGION_MASTERCARD_DAMAGED));
		plan.setSentToVisaDamaged(provider.getString(SENT_TO_VISA_DAMAGED));
		plan.setRegionVisaDamaged(provider.getString(REGION_VISA_DAMAGED));
		plan.setSentToAmexDamaged(provider.getString(SENT_TO_AMEX_DAMAGED));
		plan.setSentToRupayDamaged(provider.getString(SENT_TO_RUPAY_DAMAGED));
		plan.setReasonCodeEmergency(provider.getString(REASON_CODE_EMERGENCY));
		plan.setDescriptionEmergency(provider.getString(DESCRIPTION_EMERGENCY));
		plan.setStickyEmergency(provider.getString(STICKY_EMERGENCY));
		plan.setSentToMasterEmergency(provider.getString(SENT_TO_AMEX_EMERGENCY));
		plan.setRegionMastercardEmergency(provider.getString(REGION_MASTERCARD_EMERGENCY));
		plan.setSentToVisaEmergency(provider.getString(SENT_TO_VISA_EMERGENCY));
		plan.setRegionVisaEmergency(provider.getString(REGION_VISA_EMERGENCY));
		plan.setSentToAmexEmergency(provider.getString(SENT_TO_AMEX_EMERGENCY));
		plan.setSentToRupayEmergency(provider.getString(SENT_TO_RUPAY_EMERGENCY));
		plan.setReasonCodeErroneous(provider.getString(REASON_CODE_ERRONEOUS));
		plan.setDescriptionErroneous(provider.getString(DESCRIPTION_ERRONEOUS));
		plan.setStickyErroneous(provider.getString(STICKY_ERRONEOUS));
		plan.setSentToMasterErroneous(provider.getString(SENT_TO_AMEX_ERRONEOUS));
		plan.setRegionMastercardErroneous(provider.getString(REGION_MASTERCARD_ERRONEOUS));
		plan.setSentToVisaErroneous(provider.getString(SENT_TO_VISA_ERRONEOUS));
		plan.setRegionVisaErroneous(provider.getString(REGION_VISA_ERRONEOUS));
		plan.setSentToAmexErroneous(provider.getString(SENT_TO_AMEX_ERRONEOUS));
		plan.setSentToRupayErroneous(provider.getString(SENT_TO_RUPAY_ERRONEOUS));
		return plan;
	}
	
	
	
	 


}
