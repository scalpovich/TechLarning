package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class EventBasedLoyaltyPlan implements HasCodeAndDescription {
	
	private String eventCode;
	private String productType;
	private String eventDescription;
	private String eventPoints;
	private String type;
	private String eventPointsTobeDebited;

	public String getEventPointsTobeDebited() {
		return eventPointsTobeDebited;
	}

	public void setEventPointsTobeDebited(String eventPointsTobeDebited) {
		this.eventPointsTobeDebited = eventPointsTobeDebited;
	}

	@Override
	public String getCode() {
		return eventCode;
	}

	@Override
	public String getDescription() {
		return eventDescription;
	}

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventPoints() {
		return eventPoints;
	}

	public void setEventPoints(String eventPoints) {
		this.eventPoints = eventPoints;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static EventBasedLoyaltyPlan createWithProvider(KeyValueProvider provider) {
		EventBasedLoyaltyPlan plan = new EventBasedLoyaltyPlan();
		plan.setEventCode(MiscUtils.generate6CharAlphaNumeric());
		plan.setEventDescription(ConstantData.GENERIC_DESCRIPTION);
		//plan.setProductType(provider.getString("PROMOTION_CURRENCY"));
		plan.setEventPoints(provider.getString("EVENT_POINTS"));
		plan.setEventPointsTobeDebited(provider.getString("EVENT_POINTS_TO_BE_DEBITED"));
		return plan;
	}
		

}
