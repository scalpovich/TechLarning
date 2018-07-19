package com.mastercard.pts.integrated.issuing.steps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CreditMappingForExcel;
import com.mastercard.pts.integrated.issuing.domain.CreditInstitutionData;
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
	
	private CreditInstitutionData creditMappingForJson;
	
	 
	@Given("setting json values in excel")
	public void mappingJsonValuesInExcel() throws Exception
	{
		String institution=System.getProperty("institution");
		Method[]methodsJson=CreditInstitutionData.class.getDeclaredMethods();
		Method[]methodsExcel=CreditMappingForExcel.class.getDeclaredMethods();
		/** Step-1
		 * creating context of excel and json for all the fields mention in CreditInstitutionData.json
		 */
		contextForExcelAndJson(institution);
	    context.put(CreditConstants.JSON_VALUES, creditMappingForJson);

		Map<String,String>jsonMap=new LinkedHashMap<String, String>();
		/**Step-2
		 * Getting the initial excel context which retrieves all the data of @Storyname
		 */
        Map<String, Object> map = context.get(TestContext.KEY_STORY_DATA);
       ConcurrentHashMap<String, Object>concurrentMap=new ConcurrentHashMap<String, Object>(map);
         /**Step-3
 		 * Replacing excel context of Step-1 values with json context values
 		 */
		replacingValuesFromJsonToExcel(methodsJson, methodsExcel, jsonMap);
		 /**Step-4
 		 * Update the excel context of Step-2 with the replaced values and using it to run the entire scenario/Story
 		 */
		updatedExcelContext(jsonMap, concurrentMap);
		context.put(TestContext.KEY_STORY_DATA,concurrentMap);
		context.get(TestContext.KEY_STORY_DATA);
	}


	public void updatedExcelContext(Map<String, String> jsonMap,
			Map<String, Object> map) {
		String updatedValue=null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			for(Map.Entry<String, String> entryJson:jsonMap.entrySet())
			{	            
			  if (entryJson.getKey().toUpperCase().contains(entry.getKey().replaceAll("_", ""))) {	 
				   updatedValue=String.valueOf(entry.getValue()).replaceAll(".+", entryJson.getValue());				  
					map.put(entry.getKey(), updatedValue);				

		}
			  List<String>excelKeysWithoutUnderScore=new LinkedList<String>();
			  Set<String>keysExcel=map.keySet();
			  for(String excelKey:keysExcel)
			  {
				  excelKeysWithoutUnderScore.add(excelKey.replaceAll("_", ""));
			  }
			  
		
				Set<String> keysJson = jsonMap.keySet();
				for (String jsonKey : keysJson) {
					String[] jsonKeyWithoutGet = jsonKey.split("get");

					if (!excelKeysWithoutUnderScore
							.contains(jsonKeyWithoutGet[1].toUpperCase())) {
						map.put(jsonKey, jsonMap.get(jsonKey));
					}

				}
			 
			}
		}
	
	}


	public void replacingValuesFromJsonToExcel(Method[] methodsJson,
			Method[] methodsExcel, Map<String, String> jsonMap)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
         
		for(int i=0;i<methodsJson.length;i++)
		{
			String valueExcel="";
			String valueJson="";
			
			creditMappingForJson=context.get(CreditConstants.JSON_VALUES);
			if(methodsJson[i].getName().startsWith("get"))
			{
			 valueJson=(String) creditMappingForJson.getClass().getMethod(methodsJson[i].getName()).invoke(creditMappingForJson);
			
			for(int j=0;j<methodsExcel.length;j++)
			{
				if(methodsJson[i].getName().equalsIgnoreCase(methodsExcel[j].getName())&& methodsJson[i].getName().startsWith("get"))
				{
					
						creditMappingForExcel=context.get(CreditConstants.EXCEL_VALUES);
						
						
						 valueExcel=(String) creditMappingForExcel.getClass().getMethod(methodsExcel[j].getName()).invoke(creditMappingForExcel);
						
						 valueExcel = valueExcel.replaceAll(".+", valueJson);
						 jsonMap.put(methodsJson[i].getName(), valueJson);
		
				}
				else {
					jsonMap.put(methodsJson[i].getName(),valueJson);
				}
			}	
		}
		}
	}


	public void contextForExcelAndJson(String institution) {
		/*creditMappingForExcel=creditMappingForExcel.createWithProviderForRegression(keyValueProvider);
		context.put(CreditConstants.EXCEL_VALUES,creditMappingForExcel);*/
		if(StringUtils.isEmpty(institution))
		{
		creditMappingForJson =CreditInstitutionData.createWithProvider(provider,Institution.createWithProvider(provider).getCode());
		creditMappingForExcel=creditMappingForExcel.createWithProviderCSV(keyValueProvider);
		context.put(CreditConstants.EXCEL_VALUES,creditMappingForExcel);
		}
		else
		{
			institution=institution.replaceAll("\\s+","");
			String[]institutionSplit=institution.split("\\[");
			String institutionCode=institutionSplit[1].substring(0, institutionSplit[1].length()-1);
			creditMappingForJson =CreditInstitutionData.createWithProvider(provider,institutionCode);
			creditMappingForExcel=creditMappingForExcel.createWithProviderCSV(keyValueProvider);
			context.put(CreditConstants.EXCEL_VALUES,creditMappingForExcel);
		}
	}
}