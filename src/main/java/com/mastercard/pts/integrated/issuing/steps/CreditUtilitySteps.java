package com.mastercard.pts.integrated.issuing.steps;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CreditMappingForExcel;
import com.mastercard.pts.integrated.issuing.domain.CreditMappingForJson;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;

@Component
public class CreditUtilitySteps {
	private static final Logger logger = LoggerFactory.getLogger(CreditUtilitySteps.class);
	
	@Autowired
	private KeyValueProvider keyValueProvider;

	@Autowired
	private TestContext context;

	@Autowired
	private DataProvider provider;
	
	@Autowired
	private CreditMappingForExcel creditMappingForExcel;
	
	private CreditMappingForJson creditMappingForJson;
	
	 
	@Given("setting json values in excel")
	public void mappingJsonValuesInExcel() throws Exception
	{
		String institution=System.getProperty("institution");
		Method[]methodsJson=CreditMappingForJson.class.getDeclaredMethods();
		Method[]methodsExcel=CreditMappingForExcel.class.getDeclaredMethods();
		creditMappingForExcel=creditMappingForExcel.createWithProviderForRegression(keyValueProvider);
		context.put(CreditConstants.EXCEL_VALUES,creditMappingForExcel);
		if(StringUtils.isEmpty(institution))
		{
		creditMappingForJson =CreditMappingForJson.createWithProvider(provider,Institution.createWithProvider(provider).getCode(),Institution.createWithProvider(provider).getName());
		}
		else
		{
			institution=institution.replaceAll("\\s+","");
			String[]institutionSplit=institution.split("\\[");
			String institutionName=institutionSplit[0];
			String institutionCode=institutionSplit[1].substring(0, institutionSplit[1].length()-1);
			creditMappingForJson =CreditMappingForJson.createWithProvider(provider,institutionCode,institutionName);
		}
	    context.put(CreditConstants.JSON_VALUES, creditMappingForJson);

		Map<String,String>jsonMap=new LinkedHashMap<String, String>();
        String updated_Value="";
         Map<String, Object> map = context.get(TestContext.KEY_STORY_DATA);
		for(int i=0;i<methodsExcel.length;i++)
		{
			String valueExcel="";
			String valueJson="";
				if(methodsJson[i].getName().equalsIgnoreCase(methodsExcel[i].getName())&&methodsJson[i].getName().startsWith("get"))
				{
					
						creditMappingForExcel=context.get(CreditConstants.EXCEL_VALUES);
						creditMappingForJson=context.get(CreditConstants.JSON_VALUES);
						
						 valueExcel=(String) creditMappingForExcel.getClass().getMethod(methodsExcel[i].getName()).invoke(creditMappingForExcel);
						 valueJson=(String) creditMappingForJson.getClass().getMethod(methodsJson[i].getName()).invoke(creditMappingForJson);
						 valueExcel = valueExcel.replaceAll(".+", valueJson);
						 jsonMap.put(methodsJson[i].getName(), valueJson);
		
				}
				
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			for(Map.Entry<String, String> entryJson:jsonMap.entrySet())
			{
	

			  if (entryJson.getKey().toUpperCase().contains(entry.getKey())) {
				   updated_Value=String.valueOf(entry.getValue()).replaceAll(".+", entryJson.getValue());
					map.put(entry.getKey(), updated_Value);
				}

		}
	}
		context.put(TestContext.KEY_STORY_DATA,map);
	}
}
