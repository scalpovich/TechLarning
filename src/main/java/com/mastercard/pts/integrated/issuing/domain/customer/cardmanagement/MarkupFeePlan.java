package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

	import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
	import com.mastercard.pts.integrated.issuing.utils.CustomUtils;

	
	public class MarkupFeePlan{
		
		private String markupFeePlanCode;
		private String description;
		private String status;
		private String defaultRate;
		private String clubIntoTheTransaction;
		private String interchangeTransaction;
		private String onUsTransaction;
		private String portalApiTransaction;
		private String sourceCurrency;
		private String destinationCurrency;
		private String currencySpecificRate;
		private String chargMarkupFeeCheckbox;
		private String chargeMarkupFee;
		
		public String getChargeMarkupFee() {
			return chargeMarkupFee;
		}

		public void setChargeMarkupFee(String chargeMarkupFee) {
			this.chargeMarkupFee = chargeMarkupFee;
		}

		private static final String MP_STATUS="MP_STATUS";
		private static final String MP_DESCRIPTION="MP_DESCRIPTION";
		private static final String MP_DEFAULT_RATE="MP_DEFAULT_RATE";
		private static final String MP_CHARGE_MARKUP_FEE="MP_CHARGE_MARKUP_FEE";
		private static final String MP_CLUB_INTO_THE_TRANSACTION="MP_CLUB_INTO_THE_TRANSACTION";
		private static final String MP_INTERCHANGE_TRANSACTION ="MP_INTERCHANGE_TRANSACTION";
		private static final String MP_ON_US_TRANSACTION="MP_ON_US_TRANSACTION";
		private static final String MP_PORTAL_API_TRANSACTION ="MP_PORTAL_API_TRANSACTION";
		private static final String MP_SOURCE_CURRENCY="MP_SOURCE_CURRENCY";
		private static final String MP_DESTINATION_CURRENCY="MP_DESTINATION_CURRENCY";
		private static final String MP_CURRENCY_SPECIFIC_RATE="MP_CURRENCY_SPECIFIC_RATE";
		
		public void setStatus(String status) {
			this.status = status;
		}

		public String getDefaultRate() {
			return defaultRate;
		}

		public void setDefaultRate(String defaultRate) {
			this.defaultRate = defaultRate;
		}

		public String getClubIntoTheTransaction() {
			return clubIntoTheTransaction;
		}

		public void setClubIntoTheTransaction(String clubIntoTheTransaction) {
			this.clubIntoTheTransaction = clubIntoTheTransaction;
		}

		public String getinterchangeTransaction() {
			return interchangeTransaction;
		}

		public void setinterchangeTransaction(String interchangeTransaction) {
			this.interchangeTransaction = interchangeTransaction;
		}

		public String getOnUsTransaction() {
			return onUsTransaction;
		}

		public void setOnUsTransaction(String onUsTransaction) {
			this.onUsTransaction = onUsTransaction;
		}

		public String getPostalApiTransaction() {
			return portalApiTransaction;
		}

		public void setPostalApiTransaction(String postalApiTransaction) {
			this.portalApiTransaction = postalApiTransaction;
		}

		public String getSourceCurrency() {
			return sourceCurrency;
		}

		public void setSourceCurrency(String sourceCurrency) {
			this.sourceCurrency = sourceCurrency;
		}

		public String getDestinationCurrency() {
			return destinationCurrency;
		}

		public void setDestinationCurrency(String destinationCurrency) {
			this.destinationCurrency = destinationCurrency;
		}

		public String getCurrencySpecificRate() {
			return currencySpecificRate;
		}

		public void setCurrencySpecificRate(String currencySpecificRate) {
			this.currencySpecificRate = currencySpecificRate;
		}

		public String getChargMarkupFeeCheckbox() {
			return chargMarkupFeeCheckbox;
		}

		public void setChargMarkupFeeCheckbox(String chargMarkupFeeCheckbox) {
			this.chargMarkupFeeCheckbox = chargMarkupFeeCheckbox;
		}
		
		public String getmarkupFeePlanCode() {
			return markupFeePlanCode;
		}

		public void setMarkupFeePlanCode(String markupFeePlanCode) {
			this.markupFeePlanCode = markupFeePlanCode;
		}
		
		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStatus() {
			return status;
		}

		public static MarkupFeePlan createWithProvider(KeyValueProvider provider) {
			MarkupFeePlan plan = new MarkupFeePlan();
			plan.setStatus(provider.getString(MP_STATUS));
			plan.setDescription(provider.getString(MP_DESCRIPTION));
			plan.setDefaultRate(provider.getString(MP_DEFAULT_RATE));
			plan.setChargeMarkupFee(provider.getString(MP_CHARGE_MARKUP_FEE));
			plan.setClubIntoTheTransaction(provider.getString(MP_CLUB_INTO_THE_TRANSACTION));
			plan.setPostalApiTransaction(provider.getString(MP_PORTAL_API_TRANSACTION));
			plan.setinterchangeTransaction(provider.getString(MP_INTERCHANGE_TRANSACTION));
			plan.setOnUsTransaction(provider.getString(MP_ON_US_TRANSACTION));
			plan.setSourceCurrency(provider.getString(MP_SOURCE_CURRENCY));
			plan.setDestinationCurrency(provider.getString(MP_DESTINATION_CURRENCY));
			plan.setCurrencySpecificRate(provider.getString(MP_CURRENCY_SPECIFIC_RATE));
			plan.setMarkupFeePlanCode(CustomUtils.randomNumbers(4));
			return plan;
		}
		
	}
		
