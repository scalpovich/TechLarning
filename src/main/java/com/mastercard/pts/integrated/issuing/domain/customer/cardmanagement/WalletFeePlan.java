package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.utils.DateUtils;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

public class WalletFeePlan {

	private static final String KEY_CURRENCY = "CURRENCY";
	
	private static final String	WFP_CURRENCY = "WFP_CURRENCY";
	private static final String	WFP_INACTIVITYFEES_CHARGE_FEES	 = 	"WFP_INACTIVITYFEES_CHARGE_FEES";
	private static final String WFP_INACTIVITYFEES_FEES	 = 	"WFP_INACTIVITYFEES_FEES";
	private static final String WFP_INACTIVITYFEES_MANUAL_REACTIVATION_FEES	 = 	"WFP_INACTIVITYFEES_MANUAL_REACTIVATION_FEES";
	private static final String	WFP_STATEMENTFEE_PAPER_GENERATION	 = 	"WFP_STATEMENTFEE_PAPER_GENERATION";
	private static final String WFP_STATEMENTFEE_PAPER_REGENERATION	 = 	"WFP_STATEMENTFEE_PAPER_REGENERATION";
	private static final String WFP_STATEMENTFEE_PAPER_REGENERATION_ABOVE6MONTHS	 = 	"WFP_STATEMENTFEE_PAPER_REGENERATION_ABOVE6MONTHS";
	private static final String WFP_STATEMENTFEE_EMAIL_GENERATION	 = 	"WFP_STATEMENTFEE_EMAIL_GENERATION";
	private static final String WFP_STATEMENTFEE_EMAIL_REGENERATION	 = 	"WFP_STATEMENTFEE_EMAIL_REGENERATION";
	private static final String WFP_STATEMENTFEE_EMAIL_REGENERATION_ABOVE6MONTHS	 = 	"WFP_STATEMENTFEE_EMAIL_REGENERATION_ABOVE6MONTHS";

	public String FeeAmount;
	private String productType;
	private String walletFeePlanCode;
	private String description;
	private String currency;
	private String inactivityFeesChargeFees;
	private String inactivityFeesFee;
	private String inactivityFeesManualReactivationFees;
	private String statementFeePaperGeneration;
	private String statementFeePaperReGeneration;
	private String statementFeePaperReGenerationAbove6Months;
	private String statementFeeEmailGeneration;
	private String statementFeeEmailReGeneration;
	private String statementFeeEmailReGenerationAbove6Months;
	public String EffectiveDate;
	public String EndDate;
	public String WaiverPeriod;
	private List<WalletFeePlanDetails> walletFeePlanDetails = new ArrayList<>();

	public static WalletFeePlan createWithProvider(KeyValueProvider provider) {
		WalletFeePlan plan = new WalletFeePlan();
		plan.setWalletFeePlanCode("A" + RandomStringUtils.randomNumeric(6));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setCurrency(provider.getString(KEY_CURRENCY));
		return plan;
	}
	
	public static WalletFeePlan createWithProviderForRegression(KeyValueProvider provider) {
		WalletFeePlan plan = new WalletFeePlan();
		plan.setWalletFeePlanCode("A" + RandomStringUtils.randomNumeric(6));
		plan.setDescription(ConstantData.GENERIC_DESCRIPTION);
		plan.setCurrency(provider.getString(WFP_CURRENCY));
		plan.setInactivityFeesChargeFees(provider.getString(WFP_INACTIVITYFEES_CHARGE_FEES));
		plan.setInactivityFeesFee(provider.getString(WFP_INACTIVITYFEES_FEES));
		plan.setInactivityFeesManualReactivationFees(provider.getString(WFP_INACTIVITYFEES_MANUAL_REACTIVATION_FEES));
		plan.setStatementFeeEmailGeneration(provider.getString(WFP_STATEMENTFEE_EMAIL_GENERATION));
		plan.setStatementFeeEmailReGeneration(provider.getString(WFP_STATEMENTFEE_EMAIL_REGENERATION));
		plan.setStatementFeeEmailReGenerationAbove6Months(provider.getString(WFP_STATEMENTFEE_EMAIL_REGENERATION_ABOVE6MONTHS));
		plan.setStatementFeePaperGeneration(provider.getString(WFP_STATEMENTFEE_PAPER_GENERATION));
		plan.setStatementFeePaperReGeneration(provider.getString(WFP_STATEMENTFEE_PAPER_REGENERATION));
		plan.setStatementFeePaperReGenerationAbove6Months(provider.getString(WFP_STATEMENTFEE_PAPER_REGENERATION_ABOVE6MONTHS));
		return plan;
	}
	
	public String getInactivityFeesChargeFees() {
		return inactivityFeesChargeFees;
	}

	public void setInactivityFeesChargeFees(String inactivityFeesChargeFees) {
		this.inactivityFeesChargeFees = inactivityFeesChargeFees;
	}
	public String getEffectiveDate() {
		return EffectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		EffectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}


	public String getInactivityFeesFee() {
		return inactivityFeesFee;
	}

	public void setInactivityFeesFee(String inactivityFeesFee) {
		this.inactivityFeesFee = inactivityFeesFee;
	}

	public String getInactivityFeesManualReactivationFees() {
		return inactivityFeesManualReactivationFees;
	}

	public void setInactivityFeesManualReactivationFees(
			String inactivityFeesManualReactivationFees) {
		this.inactivityFeesManualReactivationFees = inactivityFeesManualReactivationFees;
	}

	public String getStatementFeePaperGeneration() {
		return statementFeePaperGeneration;
	}

	public void setStatementFeePaperGeneration(String statementFeePaperGeneration) {
		this.statementFeePaperGeneration = statementFeePaperGeneration;
	}

	public String getStatementFeePaperReGeneration() {
		return statementFeePaperReGeneration;
	}

	public void setStatementFeePaperReGeneration(
			String statementFeePaperReGeneration) {
		this.statementFeePaperReGeneration = statementFeePaperReGeneration;
	}

	public String getStatementFeePaperReGenerationAbove6Months() {
		return statementFeePaperReGenerationAbove6Months;
	}

	public void setStatementFeePaperReGenerationAbove6Months(
			String statementFeePaperReGenerationAbove6Months) {
		this.statementFeePaperReGenerationAbove6Months = statementFeePaperReGenerationAbove6Months;
	}

	public String getStatementFeeEmailGeneration() {
		return statementFeeEmailGeneration;
	}

	public void setStatementFeeEmailGeneration(String statementFeeEmailGeneration) {
		this.statementFeeEmailGeneration = statementFeeEmailGeneration;
	}

	public String getStatementFeeEmailReGeneration() {
		return statementFeeEmailReGeneration;
	}

	public void setStatementFeeEmailReGeneration(
			String statementFeeEmailReGeneration) {
		this.statementFeeEmailReGeneration = statementFeeEmailReGeneration;
	}

	public String getStatementFeeEmailReGenerationAbove6Months() {
		return statementFeeEmailReGenerationAbove6Months;
	}

	public void setStatementFeeEmailReGenerationAbove6Months(
			String statementFeeEmailReGenerationAbove6Months) {
		this.statementFeeEmailReGenerationAbove6Months = statementFeeEmailReGenerationAbove6Months;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getWalletFeePlanCode() {
		return walletFeePlanCode;
	}

	public void setWalletFeePlanCode(String walletFeePlanCode) {
		this.walletFeePlanCode = walletFeePlanCode;
	}

	public List<WalletFeePlanDetails> getWalletFeePlanDetails() {
		return walletFeePlanDetails;
	}

	public void setWalletFeePlanDetails(List<WalletFeePlanDetails> walletFeePlanDetails) {
		this.walletFeePlanDetails = walletFeePlanDetails;
	}

	public String getFeeAmount() {
		return FeeAmount;
	}

	public void setFeeAmount(String feeAmount) {
		FeeAmount = feeAmount;
	}

	public String getWaiverPeriod() {
		return WaiverPeriod;
	}

	public void setWaiverPeriod(String waiverPeriod) {
		WaiverPeriod = waiverPeriod;
	}

	public String WalletFeePlanType;

	public String getWalletFeePlanType() {
		return WalletFeePlanType;
	}

	public void setWalletFeePlanType(String walletFeePlanType) {
		WalletFeePlanType = walletFeePlanType;
	}

	public static WalletFeePlan walletfeeplanDataProvider() {
		WalletFeePlan walletfeeplan = new WalletFeePlan();
		walletfeeplan.setCurrency(MapUtils.fnGetInputDataFromMap("BaseCurrency"));
		walletfeeplan.setFeeAmount(MapUtils.fnGetInputDataFromMap("Fee"));
		walletfeeplan.setWaiverPeriod(MapUtils.fnGetInputDataFromMap("WaiveCycle"));
		walletfeeplan.setEffectiveDate(DateUtils.getDateinDDMMYYYY() + 1);
		walletfeeplan.setEndDate(MapUtils.fnGetInputDataFromMap("EndDate"));
		return walletfeeplan;
	}

}

