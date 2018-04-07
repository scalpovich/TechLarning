package com.mastercard.pts.integrated.issuing.domain;

import java.util.LinkedList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

public class CreditMappingForJson {
	private String association;
	private String branch;
	private String card_packid_generation_template;
	private String device_id_generation_template;
	private String device_customer_type;
	private String embossing_vendor;
    private String interchange;
	private String issuer_bin;
	private String plastic_id;
	private String picture_code;
	//private List<CreditMappingForJson>institute;
	private String code;
	private String abbreviation;
	
	
	public String getAssociation() {
		return association;
	}

	public void setAssociation(String association) {
		this.association = association;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCard_packid_generation_template() {
		return card_packid_generation_template;
	}

	public void setCard_packid_generation_template(
			String card_packid_generation_template) {
		this.card_packid_generation_template = card_packid_generation_template;
	}

	public String getDevice_id_generation_template() {
		return device_id_generation_template;
	}

	public void setDevice_id_generation_template(
			String device_id_generation_template) {
		this.device_id_generation_template = device_id_generation_template;
	}

	public String getDevice_customer_type() {
		return device_customer_type;
	}

	public void setDevice_customer_type(String device_customer_type) {
		this.device_customer_type = device_customer_type;
	}

	public String getEmbossing_vendor() {
		return embossing_vendor;
	}

	public void setEmbossing_vendor(String embossing_vendor) {
		this.embossing_vendor = embossing_vendor;
	}

	public String getInterchange() {
		return interchange;
	}

	public void setInterchange(String interchange) {
		this.interchange = interchange;
	}

	public String getIssuer_bin() {
		return issuer_bin;
	}

	public void setIssuer_bin(String issuer_bin) {
		this.issuer_bin = issuer_bin;
	}

	public String getPlastic_id() {
		return plastic_id;
	}

	public void setPlastic_id(String plastic_id) {
		this.plastic_id = plastic_id;
	}

	public String getPicture_code() {
		return picture_code;
	}

	public void setPicture_code(String picture_code) {
		this.picture_code = picture_code;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public static CreditMappingForJson createWithProvider(DataProvider provider,String key,String value) {
         return  provider.getDataBySimpleClassNameForInstitute(CreditMappingForJson.class, key,value);
	}
	
	@Override
	public String toString() {
		return MiscUtils.toString(this);
	}
}
