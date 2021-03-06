package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;
@Component
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
