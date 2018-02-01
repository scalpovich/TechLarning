package com.mastercard.pts.integrated.issuing.workflows;

import java.util.Set;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BulkDeviceRequestbatch;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceCreation;
import com.mastercard.pts.integrated.issuing.utils.ConnectionUtils;
import com.mastercard.pts.integrated.issuing.utils.DBQueryConstant;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class CardPackIdFlows extends MenuFlows {

	@Autowired
	ConnectionUtils connutils;

	@Autowired
	BulkDeviceRequestbatch bulkdevicereqbatch;

	public Set<String> getDeviceNumber() {
		String Query1 = DBQueryConstant.DEVICENUMBER_QUERY + " " + "'" + "%"
				+ bulkdevicereqbatch.getDeviceNumberFromBulkDevice() + "'";

		System.out.println(Query1);
		return connutils.getAllValuesOfAColumn(Query1, DBQueryConstant.DEVICENUMBER_COLUMN);

	}

	public String DeviceNumber(DeviceCreation devicecreation) {
		Set<String> list = getDeviceNumber();
		String Device = "";
		for (String device : list) {
			if ((MapUtils.fnGetInputDataFromMap("SMSIssuerBIN") != null)) {
				if (device.contains(MapUtils.fnGetInputDataFromMap("SMSIssuerBIN")) == true)
					Device = device;
			}
			if ((MapUtils.fnGetInputDataFromMap("DMSIssuerBIN") != null)) {
				if (device.contains(MapUtils.fnGetInputDataFromMap("DMSIssuerBIN")) == true)
					Device = device;

			}

		}
		System.out.println(Device);
		devicecreation.setDeviceNumberFromQuery(Device);
		return Device.trim();

	}

	public String getCardPackId(DeviceCreation devicecreation) {
		String Query1 = DBQueryConstant.CARDPACKID_QUERY + "' " + DeviceNumber(devicecreation).trim() + "'";
		Set<String> cardpack = connutils.getAllValuesOfAColumn(Query1, DBQueryConstant.CARDPACKID_COLUMN);
		System.out.println(cardpack);
		String CARDPackID = "";
		for (String cardpackid : cardpack) {
			{
				CARDPackID = cardpackid;
			}
			System.out.println(CARDPackID);

		}
		return CARDPackID;
	}

	public void verifyPreGeneratedFlag(DeviceCreation devicecreation) {
		String Query1 = DBQueryConstant.PREGENERATEDFLAG_QUERY + "'" + DeviceNumber(devicecreation).trim() + "'";
		System.out.println(Query1);
		Set<String> pregeneratedflag = connutils.getAllValuesOfAColumn(Query1, DBQueryConstant.PREGENERATEDFLAG_COLUMN);
		System.out.println("before pregenerated flag:- " + pregeneratedflag);
		String PreGeneratedFLAG = "";
		for (String flag : pregeneratedflag) {
			{
				if (flag.equalsIgnoreCase("Y")) {
					PreGeneratedFLAG = flag;
					Assert.assertEquals(devicecreation.getPreGeneratedCardFlag(), PreGeneratedFLAG);
				}

			}
			System.out.println("after pregenerated flag:- " + PreGeneratedFLAG);

		}
	}

	public Set<String> getPreGeneratedCard(DeviceCreation devicecreation) {
		String Query1 = DBQueryConstant.DEVICE_QUERY + "' " + DeviceNumber(devicecreation).trim() + "'";

		System.out.println(Query1);
		return connutils.getAllValuesOfAColumn(Query1, DBQueryConstant.PREGENERATEDFLAG_COLUMN);

	}

	public String PreGeneratedCard(DeviceCreation devicecreation) {
		Set<String> list = getPreGeneratedCard(devicecreation);
		String CARD = "";
		for (String card : list) {

			CARD = card;
		}
		System.out.println(CARD);

		return CARD;

	}

}
