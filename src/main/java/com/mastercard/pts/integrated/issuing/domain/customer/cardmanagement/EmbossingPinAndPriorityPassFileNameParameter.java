package com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement;

import java.util.ArrayList;
import java.util.List;

import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

public class EmbossingPinAndPriorityPassFileNameParameter {
	
	private String description;
	private String fileType;
	private String productType;
	private String priority;
	private String fileNameExpression;
	
	private static final String FILE_TYPE_EMBOSSING="FILE_TYPE_EMBOSSING";
	private static final String FILE_TYPE_PIN="FILE_TYPE_PIN";
	private static final String PRODUCT_TYPE_PREPAID="PRODUCT_TYPE_PREPAID";
	
	private static final String FILE_TYPE_PRIORITY_PASS="FILE_TYPE_PRIORITY_PASS";
	private static final String PRODUCT_TYPE_CREDIT="PRODUCT_TYPE_CREDIT";
	private static final String PRODUCT_TYPE_DEBIT="PRODUCT_TYPE_DEBIT";
	private static final String FILENAME="FILENAME";
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getFileNameExpression() {
		return fileNameExpression;
	}
	public void setFileNameExpression(String fileNameExpression) {
		this.fileNameExpression = fileNameExpression;
	}
	
	
	public static List<EmbossingPinAndPriorityPassFileNameParameter> createWithProvider(KeyValueProvider provider)
	{
		List<EmbossingPinAndPriorityPassFileNameParameter> dataProvider = new ArrayList <>();
		
		EmbossingPinAndPriorityPassFileNameParameter embossingCredit= new EmbossingPinAndPriorityPassFileNameParameter();
		embossingCredit.setDescription(provider.getString("EMBOSSING_CREDIT_DESCRIPTION"));
		embossingCredit.setFileType(provider.getString(FILE_TYPE_EMBOSSING));
		embossingCredit.setFileNameExpression(provider.getString(FILENAME));
		embossingCredit.setProductType(provider.getString(PRODUCT_TYPE_CREDIT));
		embossingCredit.setPriority(provider.getString("EMBOSSING_CREDIT_PRIORITY"));
		dataProvider.add(embossingCredit);
		
		
		EmbossingPinAndPriorityPassFileNameParameter embossingDebit= new EmbossingPinAndPriorityPassFileNameParameter();
		embossingDebit.setDescription(provider.getString("EMBOSSING_DEBIT_DESCRIPTION"));
		embossingDebit.setFileType(provider.getString(FILE_TYPE_EMBOSSING));
		embossingDebit.setFileNameExpression(provider.getString(FILENAME));
		embossingDebit.setProductType(provider.getString(PRODUCT_TYPE_DEBIT));
		embossingDebit.setPriority(provider.getString("EMBOSSING_DEBIT_PRIORITY"));
		dataProvider.add(embossingDebit);
		
		EmbossingPinAndPriorityPassFileNameParameter embossingprePaid= new EmbossingPinAndPriorityPassFileNameParameter();
		embossingprePaid.setDescription(provider.getString("EMBOSSING_PREPAID_DESCRIPTION"));
		embossingprePaid.setFileType(provider.getString(FILE_TYPE_EMBOSSING));
		embossingprePaid.setFileNameExpression(provider.getString(FILENAME));
		embossingprePaid.setProductType(provider.getString(PRODUCT_TYPE_PREPAID));
		embossingprePaid.setPriority(provider.getString("EMBOSSING_PREPAID_PRIORITY"));
		dataProvider.add(embossingprePaid);
		
		EmbossingPinAndPriorityPassFileNameParameter priorityPassCredit= new EmbossingPinAndPriorityPassFileNameParameter();
		priorityPassCredit.setDescription(provider.getString("PRIORITY_PASS_CREDIT_DESCRIPTION"));
		priorityPassCredit.setFileType(provider.getString(FILE_TYPE_PRIORITY_PASS));
		priorityPassCredit.setFileNameExpression(provider.getString(FILENAME));
		priorityPassCredit.setProductType(provider.getString(PRODUCT_TYPE_CREDIT));
		priorityPassCredit.setPriority(provider.getString("PRIORITY_PASS_CREDIT_PRIORITY"));
		dataProvider.add(priorityPassCredit);
		
		
		EmbossingPinAndPriorityPassFileNameParameter priorityPassDebit= new EmbossingPinAndPriorityPassFileNameParameter();
		priorityPassDebit.setDescription(provider.getString("PRIORITY_PASS_DEBIT_DESCRIPTION"));
		priorityPassDebit.setFileType(provider.getString(FILE_TYPE_PRIORITY_PASS));
		priorityPassDebit.setFileNameExpression(provider.getString(FILENAME));
		priorityPassDebit.setProductType(provider.getString(PRODUCT_TYPE_DEBIT));
		priorityPassDebit.setPriority(provider.getString("PRIORITY_PASS_DEBIT_PRIORITY"));
		dataProvider.add(priorityPassDebit);
		
		
		EmbossingPinAndPriorityPassFileNameParameter priorityPassPrepaid= new EmbossingPinAndPriorityPassFileNameParameter();
		
		priorityPassPrepaid.setDescription(provider.getString("PRIORITY_PASS_PREPAID_DESCRIPTION"));
		priorityPassPrepaid.setFileType(provider.getString(FILE_TYPE_PRIORITY_PASS));
		priorityPassPrepaid.setFileNameExpression(provider.getString(FILENAME));
		priorityPassPrepaid.setProductType(provider.getString(PRODUCT_TYPE_PREPAID));
		priorityPassPrepaid.setPriority(provider.getString("PRIORITY_PASS_PREPAID_PRIORITY"));
		dataProvider.add(priorityPassPrepaid);
		
		
		
       EmbossingPinAndPriorityPassFileNameParameter pinCredit= new EmbossingPinAndPriorityPassFileNameParameter();
		
       pinCredit.setDescription(provider.getString("PIN _CREDIT_DESCRIPTION"));
       pinCredit.setFileNameExpression(provider.getString(FILENAME));
       pinCredit.setFileType(provider.getString(FILE_TYPE_PIN));
       pinCredit.setProductType(provider.getString(PRODUCT_TYPE_CREDIT));
       pinCredit.setPriority(provider.getString("PIN _CREDIT_PRIORITY"));
		dataProvider.add(pinCredit);
		
		
		EmbossingPinAndPriorityPassFileNameParameter pinDebit= new EmbossingPinAndPriorityPassFileNameParameter();
		pinDebit.setDescription(provider.getString("PIN _DEBIT_DESCRIPTION"));
		pinDebit.setFileType(provider.getString(FILE_TYPE_PIN));
		pinDebit.setFileNameExpression(provider.getString(FILENAME));
		pinDebit.setProductType(provider.getString(PRODUCT_TYPE_DEBIT));
		pinDebit.setPriority(provider.getString("PIN _DEBIT_PRIORITY"));
		dataProvider.add(pinDebit);	
		
		
		
	EmbossingPinAndPriorityPassFileNameParameter pinPrepaid= new EmbossingPinAndPriorityPassFileNameParameter();
		
	pinPrepaid.setDescription(provider.getString("PIN _PREPAID_DESCRIPTION"));
	pinPrepaid.setFileNameExpression(provider.getString(FILENAME));
	pinPrepaid.setProductType(provider.getString(PRODUCT_TYPE_PREPAID));
	pinPrepaid.setFileType(provider.getString(FILE_TYPE_PIN));
	pinPrepaid.setPriority(provider.getString("PIN _PREPAID_PRIORITY"));
		dataProvider.add(pinPrepaid);	
		
	return dataProvider;
		
		
		
	}

}
