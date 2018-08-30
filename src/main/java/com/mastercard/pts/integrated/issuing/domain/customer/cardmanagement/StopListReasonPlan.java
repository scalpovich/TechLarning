package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class StopListReasonPlan {
	 private static final String  REASON_CODE="REASON_CODE";
	 private static final String  DESCRIPTION="DESCRIPTION";
	 private static final String  STICKY="STICKY";
	 private static final String  SENT_TO_MASTER="SENT_TO_MASTER";
	 private static final String  REGION_MASTERCARD="REGION_MASTERCARD";
	 private static final String  SENT_TO_VISA="SENT_TO_VISA";
	 private static final String  REGION_VISA="REGION_VISA";
	 private static final String  SENT_TO_RUPAY="SENT_TO_RUPAY";
	 private static final String  SENT_TO_AMEX="SENT_TO_AMEX";
	 
	 private String[] reasonCode;
	 private String[] description;
	 private String[] sticky;
	 private String[] sentToMastercard;
	 private String[] regionMastercard;
	 private String[] sentToVisa;
	 private String[] regionVisa;
	 private String[] sentToRupay;
	 private String[] sentToAmex;
	 
	 private int size;
	 
	public String[] getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String[] strings) {
		this.reasonCode = strings;
	}

	public String getDescription(int index) {
		return description[index];
	}

	public void setDescription(String[] strings) {
		this.description = strings;
	}

	public String getSticky(int index) {
		return sticky [index];
	}

	public void setSticky(String[] sticky) {
		this.sticky = sticky;
	}

	public String getSentToMastercard(int index) {
		return sentToMastercard[index];
	}

	public void setSentToMastercard(String[] sentToMastercard) {
		this.sentToMastercard = sentToMastercard;
	}

	public String getRegionMastercard(int index) {
		return regionMastercard[index];
	}

	public void setRegionMastercard(String[] regionMastercard) {
		this.regionMastercard = regionMastercard;
	}

	public String getSentToVisa(int index) {
		return sentToVisa[index];
	}

	public void setSentToVisa(String[] sentToVisa) {
		this.sentToVisa = sentToVisa;
	}

	public String getRegionVisa(int index) {
		return regionVisa[index];
	}

	public void setRegionVisa(String[] regionVisa) {
		this.regionVisa = regionVisa;
	}

	public String getSentToRupay(int index) {
		return sentToRupay[index];
	}

	public void setSentToRupay(String[] sentToRupay) {
		this.sentToRupay = sentToRupay;
	}

	public String getSentToAmex(int index) {
		return sentToAmex[index];
	}

	public void setSentToAmex(String[] sentToAmex) {
		this.sentToAmex = sentToAmex;
	}

	public void setSize(int size)
	{
		 this.size=size;
	}
	
	public int getSize()
	{
		return this.size;
	}
	public static StopListReasonPlan createWithProvider(KeyValueProvider provider) {
		StopListReasonPlan plan = new StopListReasonPlan();
		plan.setReasonCode(provider.getString(REASON_CODE).split(":"));
		plan.setDescription(provider.getString(DESCRIPTION).split(":"));
		plan.setSticky(provider.getString(STICKY).split(":"));
		plan.setSentToMastercard(provider.getString(SENT_TO_MASTER).split(":"));
		plan.setRegionMastercard(provider.getString(REGION_MASTERCARD).split(":"));
		plan.setSentToVisa(provider.getString(SENT_TO_VISA).split(":"));
		plan.setRegionVisa(provider.getString(REGION_VISA).split(":"));
		plan.setSentToAmex(provider.getString(SENT_TO_AMEX).split(":"));
		plan.setSentToRupay(provider.getString(SENT_TO_RUPAY).split(":"));
		plan.setSize(provider.getString(REASON_CODE).split(":").length);
		return plan;
	}
	
	
	
	 


}
