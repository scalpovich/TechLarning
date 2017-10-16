package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

@Component
public class PictureCode extends AbstractBasePage {

	public String PictureCode;

	public String getPictureCode() {
		return PictureCode;
	}

	public void setPictureCode(String pictureCode) {
		PictureCode = pictureCode;
	}
}
