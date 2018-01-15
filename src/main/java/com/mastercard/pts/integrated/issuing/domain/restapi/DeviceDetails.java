package com.mastercard.pts.integrated.issuing.domain.restapi;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import com.mastercard.pts.integrated.issuing.steps.restapi.RestStepDefinitions;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;

@Component
public class DeviceDetails {

	@Autowired
	ConnectionUtils connectionUtils;
	// Queries for CardActivation API
	public static final String GETCPICRDQUERY = "SELECT DEVICE_NUMBER ,KYC_STATUS ,CARD_PACK_ID FROM device INNER JOIN client ON device.CLIENT_CODE = client.CLIENT_CODE INNER JOIN device_plan on device.DEVICE_PLAN_CODE = device_plan.DEVICE_PLAN_CODE where KYC_STATUS='Y' AND device.bank_code='111777' AND device.Status_code=0 AND ACTIVATION_DATE is null AND device.DELIVERY_MODE is null AND DELIVERY_DEFAULT LIKE '____1%' AND ROWNUM=1";
	public static final String GETEXPIREDCARDQUERY = "SELECT DEVICE_NUMBER,CARD_PACK_ID from device INNER JOIN device_plan on device.DEVICE_PLAN_CODE = device_plan.DEVICE_PLAN_CODE where device.STATUS_CODE=12 and device.bank_code='111777' and device.EXPIRY_DATE is NOT NULL and device_plan.DEVICE_TYPE not IN (7,8) and device.ACTIVATION_DATE is null AND ROWNUM=1";
	public static final String GETCANCELLEDCARDQUERY = "SELECT Status_code,DEVICE_NUMBER,CARD_PACK_ID,DEVICE_TYPE from device INNER JOIN device_plan on device.DEVICE_PLAN_CODE = device_plan.DEVICE_PLAN_CODE where STATUS_CODE=3 and device.bank_code='111777' and ACTIVATION_DATE is null and device_plan.DEVICE_TYPE not IN (7,8) AND ROWNUM=1";
	public static final String GETSTOPLISTEDCARDQUERY = "SELECT device.DELIVERY_MODE,device.ACTIVATION_DATE,DEVICE_PLAN.DELIVERY_DEFAULT,device.Status_code,device.DEVICE_NUMBER,device.CARD_PACK_ID,device_plan.DEVICE_TYPE,device.bank_code from device INNER JOIN client ON device.CLIENT_CODE = client.CLIENT_CODE INNER JOIN device_plan on device.DEVICE_PLAN_CODE = device_plan.DEVICE_PLAN_CODE where device.BANK_CODE='111777' and device_plan.DEVICE_TYPE not IN (7,8) and  device.ACTIVATION_DATE is null and device_plan.DELIVERY_DEFAULT LIKE '____1%' and device.Status_code in (8,19) and device.DELIVERY_MODE is not null and ROWNUM=1";
	public static final String GETACTIVATEDCARDQUERY = "SELECT DEVICE_NUMBER,CARD_PACK_ID FROM device INNER JOIN client ON device.CLIENT_CODE = client.CLIENT_CODE INNER JOIN device_plan on device.DEVICE_PLAN_CODE = device_plan.DEVICE_PLAN_CODE where KYC_STATUS='Y' AND device.bank_code='111777' AND device.Status_code=0 AND ACTIVATION_DATE is not null AND device.DELIVERY_MODE is null AND DELIVERY_DEFAULT ='000010000' AND DELIVERY_DATE IS NOT NULL AND DELIVERY_FLAG NOT IN (0) and ROWNUM=1";
	// Queries for Card link delink API
	public static final String GETDEVICE = "select PRODUCT_TYPE,DEVICE_NUMBER,DEFAULT_WALLET_NUMBER,WALLET_CUSTOM_NUMBER1,WALLET_CUSTOM_NUMBER2 from device INNER JOIN client ON device.CLIENT_CODE = client.CLIENT_CODE where device.bank_code='111777' and device.ACTIVATION_DATE is not null and device.PRODUCT_TYPE='D' and RowNum=1";
	public static final String GETCLIENTLENGTH = "select CLIENT_LEN from Institution where bank_code='111777'";
	public static final String GETCARDLINKSTATUS = "select DEVICE_NUMBER,WALLET_NUMBER,DEFAULT_WALLET_FLAG,ACCOUNT_TYPE,PRODUCT_TYPE,BANK_CODE from DEVICE_WALLET_LINK WHERE DEVICE_NUMBER='?'";

	// Device Table cloumnNames
	public static final String DEVICENUMBERCOLUMN = "DEVICE_NUMBER";
	public static final String CARDPACKIDCOLUMN = "CARD_PACK_ID";

	// Institution Table cloumnNames
	public static final String CLIENTLENGTHCOLUMN = "CLIENT_LEN";
	// DEVICE_WALLET_LINK Table cloumnNames
	public static final String DEFAULTWALLETFLAGCOLUMN = "DEFAULT_WALLET_FLAG";
	public static final String WALLETNUMBERCOLUMN = "WALLET_NUMBER";
	ResultSet result;
	final Logger logger = LoggerFactory.getLogger(DeviceDetails.class);

	private String transactionId;
	private String timeStamp;
	private String deviceNumber;
	private String defaultWallet;
	private String customWallet;

	public String getDefaultWallet() {
		return defaultWallet;
	}

	public void setDefaultWallet(String defaultWallet) {
		this.defaultWallet = defaultWallet;
	}

	public String getCustomWallet() {
		return customWallet;
	}

	public void setCustomWallet(String customWallet) {
		this.customWallet = customWallet;
	}

	private String cardPackID;
	private String statusCode;

	public void getCPICRDDataFromDB() {
		result = connectionUtils.executeQueryForBIN(GETCPICRDQUERY);
		try {
			while (result.next()) {
				setCardPackID(result.getString(CARDPACKIDCOLUMN));
				setDeviceNumber(result.getString(DEVICENUMBERCOLUMN));
			}
		} catch (Exception e) {
			logger.error("Error Message : ", e);
		}
	}

	public void getCardStatusFromDB(String query) {
		result = connectionUtils.executeQueryForBIN(query);
		try {
			while (result.next()) {
				setDeviceNumber(result.getString("DEVICE_NUMBER"));
			}
		} catch (Exception e) {
			logger.error("Error Message", e);
		}
	}

	public String getDataFromDB(String query, String coulmn) {
		String data = null;
		result = connectionUtils.executeQueryForBIN(query);
		try {
			while (result.next()) {
				data = result.getString(coulmn);
			}
		} catch (Exception e) {
			logger.error("Error Message", e);
		}
		return data;
	}

	public void checkWalletLinkStatus() {
		try {
			result = connectionUtils
					.executeQueryForBIN(GETCARDLINKSTATUS.replace("?",
							getDeviceNumber()));

			while (result.next()) {
				if (result.getString(WALLETNUMBERCOLUMN).equals(
						getDefaultWallet())) {
					logger.info("****************Match Found************************\n WALLET NUMBER COLUMN="
							+ result.getString(WALLETNUMBERCOLUMN));
					Assert.assertTrue(result.getString(DEFAULTWALLETFLAGCOLUMN)
							.equals("Y"));
				} else if (result.getString(WALLETNUMBERCOLUMN).equals(
						getCustomWallet())) {
					logger.info("****************Match Found************************\n WALLET NUMBER COLUMN="
							+ result.getString(WALLETNUMBERCOLUMN));
					Assert.assertTrue(result.getString(DEFAULTWALLETFLAGCOLUMN)
							.equals("N"));
				} else {
					logger.info("****************NO Match ************************");

				}
			}
		} catch (Exception e) {
			logger.error("Error Message ", e);
		}

	}

	public void checkWalletDelinkStatus() {
		try {
			result = connectionUtils
					.executeQueryForBIN(GETCARDLINKSTATUS.replace("?",
							getDeviceNumber()));

			while (result.next()) {
				if (result.getString(WALLETNUMBERCOLUMN).equals(
						getDefaultWallet())) {
					logger.info("****************Match Found************************\n DEFAULTWALLETFLAGCOLUMN="
							+ result.getString(WALLETNUMBERCOLUMN));
					Assert.assertTrue(result.getString(DEFAULTWALLETFLAGCOLUMN)
							.equals("N"));
				} else if (result.getString(WALLETNUMBERCOLUMN).equals(
						getCustomWallet())) {
					logger.info("****************Match Found************************\n DEFAULTWALLETFLAGCOLUMN="
							+ result.getString(WALLETNUMBERCOLUMN));
					Assert.assertTrue(result.getString(DEFAULTWALLETFLAGCOLUMN)
							.equals("Y"));
				} else {
					logger.info("****************NO Match ************************");
				}
			}
		} catch (Exception e) {
			logger.error("ERROR Message", e);
		}

	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public String getCardPackID() {
		return cardPackID;
	}

	public void setCardPackID(String cardPackID) {
		this.cardPackID = cardPackID;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
