package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import com.mastercard.pts.integrated.issuing.pages.AbstractBasePage;

public class BatchLevelPriviledge extends AbstractBasePage{
  
	public String entityType;
	public String entityId;
	
	
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getEntityId() {
		return entityId;
	}
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	
	
}
