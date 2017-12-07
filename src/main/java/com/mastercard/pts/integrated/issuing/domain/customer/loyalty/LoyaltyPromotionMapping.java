package com.mastercard.pts.integrated.issuing.domain.customer.loyalty;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

/**
 * @author e076177
 *
 */
@Component
public class LoyaltyPromotionMapping {

	private String mappingLoyaltyPlanddwn;
	private String mappingPromotionPlanddwn;
	private String priority;

	public String getMappingLoyaltyPlanddwn() {
		return mappingLoyaltyPlanddwn;
	}

	public void setMappingLoyaltyPlanddwn(String mappingLoyaltyPlanddwn) {
		this.mappingLoyaltyPlanddwn = mappingLoyaltyPlanddwn;
	}

	public String getMappingPromotionPlanddwn() {
		return mappingPromotionPlanddwn;
	}

	public void setMappingPromotionPlanddwn(String mappingPromotionPlanddwn) {
		this.mappingPromotionPlanddwn = mappingPromotionPlanddwn;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void loyaltyPlanDataProvider() {

		setPriority(MapUtils.fnGetInputDataFromMap("priority"));
	}
}
