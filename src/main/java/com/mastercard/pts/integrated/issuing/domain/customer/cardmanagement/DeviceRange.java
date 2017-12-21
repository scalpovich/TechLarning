package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.apache.commons.lang3.RandomStringUtils;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class DeviceRange {

	private static final int BIN_RANGE_SIZE = 10;
	private static final String	DR_ISSUER_BIN	 = 	"DR_ISSUER_BIN";
	private static final String	DR_BRANCH	 = 	"DR_BRANCH";
	private static final String	DR_CARD_TYPE	 = 	"DR_CARD_TYPE";
	private static final String	DR_ENDPOINT_MODE	 = 	"DR_ENDPOINT_MODE";
	private static final String	DR_INTERFACE_NAME	 = 	"DR_INTERFACE_NAME";
	private static final String	DR_ROUTING_TYPE	 = 	"DR_ROUTING_TYPE";
	private static final String	DR_STATUS	 = 	"DR_STATUS";
		
	private String productType;
	private String program;
	private String devicePlanCode;
	private String issuerBin;
	private String branch;
	private String fromDeviceNumber;
	private String toDeviceNumber;
	private String endPointMode;
	private String interfaceName;
	private String routingType;
	private String status;
	private String cardType;
	
		private String channelRoutingPlan;
		public String getChannelRoutingPlan() {
			return channelRoutingPlan;
		}
	
		public void setChannelRoutingPlan(String channelRoutinPlan) {
			this.channelRoutingPlan = channelRoutinPlan;
		}

	public static String[] generateDeviceRange(int length) {
		String randomSpan = RandomStringUtils.randomNumeric(length - 2);
		String from = randomSpan + "00";
		String to = randomSpan + "99";
		return new String[] { from, to };
	}
	
	public static DeviceRange createWithProvider(DataProvider provider, String... tags){
		String[] deviceRange = generateDeviceRange(BIN_RANGE_SIZE);
		
		DeviceRange range = provider.getDataBySimpleClassName(DeviceRange.class, tags);
		range.setFromDeviceNumber(deviceRange[0]);
		range.setToDeviceNumber(deviceRange[1]);
		return range;
	}

	public static DeviceRange createWithProvider(KeyValueProvider provider, String... tags){
		String[] deviceRange = generateDeviceRange(BIN_RANGE_SIZE);
		DeviceRange range = new DeviceRange();
		range.setFromDeviceNumber(deviceRange[0]);
		range.setToDeviceNumber(deviceRange[1]);

		range.setCardType(provider.getString(DR_CARD_TYPE));
		range.setIssuerBin(provider.getString(DR_ISSUER_BIN));
		range.setBranch(provider.getString(DR_BRANCH));
		range.setEndPointMode(provider.getString(DR_ENDPOINT_MODE));
		range.setInterfaceName(provider.getString(DR_INTERFACE_NAME));
		range.setRoutingType(provider.getString(DR_ROUTING_TYPE));
		range.setStatus(provider.getString(DR_STATUS));

		return range;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getDevicePlanCode() {
		return devicePlanCode;
	}

	public void setDevicePlanCode(String devicePlanCode) {
		this.devicePlanCode = devicePlanCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIssuerBin() {
		return issuerBin;
	}

	public void setIssuerBin(String issuerBin) {
		this.issuerBin = issuerBin;
	}

	public String getFromDeviceNumber() {
		return fromDeviceNumber;
	}

	public void setFromDeviceNumber(String fromDeviceNumber) {
		this.fromDeviceNumber = fromDeviceNumber;
	}

	public String getToDeviceNumber() {
		return toDeviceNumber;
	}

	public void setToDeviceNumber(String toDeviceNumber) {
		this.toDeviceNumber = toDeviceNumber;
	}
	
	public String getEndPointMode() {
		return endPointMode;
	}
	
	public void setEndPointMode(String endPointMode) {
		this.endPointMode = endPointMode;
	}
	
	public String getInterfaceName() {
		return interfaceName;
	}
	
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	
	public String getRoutingType() {
		return routingType;
	}
	
	public void setRoutingType(String routingType) {
		this.routingType = routingType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public DeviceRange devicerangeDataProvider() {
		DeviceRange devicerange = new DeviceRange();
		devicerange.setFromDeviceNumber(MapUtils.fnGetInputDataFromMap("FromDeviceNo"));
		devicerange.setToDeviceNumber(MapUtils.fnGetInputDataFromMap("ToDeviceNo"));
		return devicerange;

	}

}