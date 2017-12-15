package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.ErrorMessages;

public class DevicePlanPageErrVal extends ErrorMessages {

	public static final String DEVICE_CODE_PLAN = "Device Plan Code:";
	public static final String SERVICE_CODE = "Service Code:";
	public static final String CARD_PACK_ID_GEN_TEMP = "Card Pack ID Generation Template:";

	public static final String PICTURE_CODE = "Picture Code:";
	public static final String DEVICE_TYPE = "Device Type:";
	public static final String ASSOCIATION = "Association:";
	public static final String PRODUCT_TYPE = "Product Type:";
	public static final String EXPIRY_FLAG = "Expiry Flag:";
	public static final String DEVICE_ID_GEN_TEMP = "Device ID Generation Template:";
	public static final String ACTIVATION_MODE = "Activation Mode:";

	public static final String DELIVERY_MODE = "Delivery Mode:";
	public static final String CARD_PROD = "Card Production:";
	public static final String PLASTIC_ID = "Plastic Id:";
	public static final String DESCRIPTION = "Description:";

	public enum MandatoryFeildValdiation implements ErrorValMsgProvider {

		ServiceCode(SERVICE_CODE, thisFieldIsReq, wholeNo), DevicePlan(DEVICE_CODE_PLAN, thisFieldIsReq,
				alphaNumStartEnd), CardPackIdGenTemp(CARD_PACK_ID_GEN_TEMP, thisFieldIsReq, NA);

		private String field;
		private String manErrMsg;
		private String valErrors;

		public String getvalErrors() {
			return valErrors;
		}

		public String getField() {
			return field;
		}

		public String getErrMsg() {
			return manErrMsg;
		}

		private MandatoryFeildValdiation(String field, String manErrMsg, String valErrors) {
			this.field = field;
			this.manErrMsg = manErrMsg;
			this.valErrors = valErrors;
		}

		public String[] getFieldsVal() {
			String[] val = new String[3];
			val[0] = field;
			val[1] = manErrMsg;
			val[2] = valErrors;
			return val;

		}
	}

}
