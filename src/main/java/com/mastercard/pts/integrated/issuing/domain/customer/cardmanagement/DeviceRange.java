package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
import com.mastercard.pts.integrated.issuing.utils.MapUtils;

public class DeviceRange extends AbstractBasePage {

	public String FromDeviceNumber;
	public String ToDeviceNumber;

	public String getFromDeviceNumber() {
		return FromDeviceNumber;
	}

	public void setFromDeviceNumber(String fromDeviceNumber) {
		FromDeviceNumber = fromDeviceNumber;
	}

	public String getToDeviceNumber() {
		return ToDeviceNumber;
	}

	public void setToDeviceNumber(String toDeviceNumber) {
		ToDeviceNumber = toDeviceNumber;
	}

	public DeviceRange devicerangeDataProvider() {
		DeviceRange devicerange = new DeviceRange();
		devicerange.setFromDeviceNumber(MapUtils.fnGetInputDataFromMap("FromDeviceNo"));
		devicerange.setToDeviceNumber(MapUtils.fnGetInputDataFromMap("ToDeviceNo"));
		return devicerange;

	}

}
