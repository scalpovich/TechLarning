package com.mastercard.pts.integrated.issuing.domain.helpdesk;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

public class EventAndAlerts extends AbstractBasePage {
	// Add On Card Request
	private String title;
	private String firstName;
	private String familyName;
	private String embossedName;
	private String relation;
	private String errorMessage;

	public EventAndAlerts(String title, String firstName, String familyName,
			String embossedName, String relation) {
		this.title = title;
		this.firstName = firstName;
		this.familyName = familyName;
		this.embossedName = embossedName;
		this.relation = relation;
	}

	public EventAndAlerts() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getEmbossedName() {
		return embossedName;
	}

	public void setEmbossedName(String embossedName) {
		this.embossedName = embossedName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	// 304 - E-commerce Activation/Deactivation
	private String eCommStatus;
	private String eCommType;

	public String geteCommStatus() {
		return eCommStatus;
	}

	public void seteCommStatus(String eCommStatus) {
		this.eCommStatus = eCommStatus;
	}

	public String geteCommType() {
		return eCommType;
	}

	public void seteCommType(String eCommType) {
		this.eCommType = eCommType;
	}

	@Override
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
