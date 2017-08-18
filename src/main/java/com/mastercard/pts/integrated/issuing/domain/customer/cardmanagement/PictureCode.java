package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

public class PictureCode {

	private String pictureCodeNumber;
	private String description;

	public String getPictureCodeNumber() {
		return pictureCodeNumber;
	}
	public void setPictureCodeNumber(String pictureCodeNumber) {
		this.pictureCodeNumber = pictureCodeNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static PictureCode createWithProvider(DataProvider provider)
	{
		return provider.getDataBySimpleClassName(PictureCode.class);
	}
	
}
