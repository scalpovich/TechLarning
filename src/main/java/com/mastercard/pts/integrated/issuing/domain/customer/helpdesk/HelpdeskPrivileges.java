package com.mastercard.pts.integrated.issuing.domain.customer.helpdesk;

import com.mastercard.pts.integrated.issuing.domain.HasCodeAndDescription;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class HelpdeskPrivileges implements HasCodeAndDescription {

	private static final String USER_GROUP_ID = "USER_GROUP_ID";
	private static final String GROUP_NAME = "GROUP_NAME";
	private static final String EMAIL_ID = "EMAIL_ID";

	private String userGroup;
	private String userGroupID;
	private String groupName;
	private String emailID;

	public String getUserGroupID() {
		return userGroupID;
	}

	public void setUserGroupID(String userGroupID) {
		this.userGroupID = userGroupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public static HelpdeskPrivileges createWithProvider(
			KeyValueProvider provider) {
		HelpdeskPrivileges helpdeskPrivileges = new HelpdeskPrivileges();
		helpdeskPrivileges
.setUserGroupID(provider.getString(USER_GROUP_ID));
		helpdeskPrivileges.setGroupName(provider.getString(GROUP_NAME));
		helpdeskPrivileges.setEmailID(provider.getString(EMAIL_ID));
		return helpdeskPrivileges;
	}

	@Override
	public String getCode() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

}
