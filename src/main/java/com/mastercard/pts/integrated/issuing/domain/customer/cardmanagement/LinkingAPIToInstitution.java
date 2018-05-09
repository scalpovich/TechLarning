package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MapUtils;

@Component
public class LinkingAPIToInstitution {

	private String productType;
	private String userId;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static LinkingAPIToInstitution linkingAPIInstitutionDataProvider() {
		LinkingAPIToInstitution accountRange= new LinkingAPIToInstitution();
		accountRange.setProductType(MapUtils.fnGetInputDataFromMap("ProductType") );
		accountRange.setUserId(MapUtils.fnGetInputDataFromMap("APILInkingUserID") );
		return accountRange;
	}
}


