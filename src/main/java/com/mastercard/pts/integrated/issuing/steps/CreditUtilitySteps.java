package com.mastercard.pts.integrated.issuing.steps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

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
	
	 
	@Given("setting json values in excel for $product")
	public void mappingJsonValuesInExcel(String product) throws Exception
	{
		context.put(ConstantData.PRODUCT_IDENTITY, product);
		String institution=System.getProperty(ConstantData.INSTITUTION_KEY);
		Method[]methodsJson=CreditInstitutionData.class.getDeclaredMethods();
		/** Step-1
		 * creating context of excel and json for all the fields mention in CreditInstitutionData.json
		 */
		contextForExcelAndJson(institution);
	    context.put(CreditConstants.JSON_VALUES, creditMappingForJson);

		/**Step-2
		 * Getting the initial excel context which retrieves all the data of @Storyname
		 */
        Map<String, Object> map = context.get(TestContext.KEY_STORY_DATA);
        ConcurrentHashMap<String, Object>concurrentMap=new ConcurrentHashMap<String, Object>(map);
//         /**Step-3
// 		 * Replacing excel context of Step-1 values with json context values
// 		 */
          //replacingValuesFromJsonToExcel(methodsJson, methodsExcel, jsonMap);
        
//		 /**Step-4
// 		 * Update the excel context of Step-2 with the replaced values and using it to run the entire scenario/Story
// 		 */
//		updatedExcelContext(jsonMap, concurrentMap);
   
        //get json values in map
        Map<String,String>jsonMap=getJsonMap(methodsJson);

        //append extra json values to ExcelMap
        map=putExtraJsonValuesTOExcel(concurrentMap, jsonMap);
        
        //replace excel values with Excel values
        Map<String, Object> allInOneMap=replacingValuesFromJsonToExcel(map, jsonMap);
     
		context.put(TestContext.KEY_STORY_DATA,allInOneMap);
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
			
			 System.out.println(methodsExcel.length);
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
					break;
				}
			}	
		}
		}
	}
	
	public Map<String, Object> replacingValuesFromJsonToExcel(Map<String, Object> excelMap, Map<String, String> jsonMap)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String updatedValue=null;
		for (Map.Entry<String, Object> entry : excelMap.entrySet()) {
			for(Map.Entry<String, String> entryJson:jsonMap.entrySet())
			{	            
			  if (entryJson.getKey().contains(entry.getKey().replaceAll("_", ""))) {	 
				   updatedValue=String.valueOf(entry.getValue()).replaceAll(".+", entryJson.getValue());				  
				   excelMap.put(entry.getKey(), updatedValue);				

		}}}
		
		return excelMap;
	}
	public Map<String, Object> putExtraJsonValuesTOExcel(Map<String, Object> excelMap, Map<String, String> jsonMap)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Map<String, Object> excelMapWithoutUnderScore=new HashMap<String, Object>();
		ArrayList<String> keyList=new ArrayList<String>();
		for (Map.Entry<String, Object> entry : excelMap.entrySet()) {
			excelMapWithoutUnderScore.put(entry.getKey().replaceAll("_", ""), entry.getValue());
			keyList.add(entry.getKey().replaceAll("_", ""));
		}	
		for(Map.Entry<String, String> entryJson:jsonMap.entrySet()) {	            
			  if (!keyList.contains(entryJson.getKey().replaceFirst("GET", ""))) {				  
				   excelMap.put(entryJson.getKey(), entryJson.getValue());
		}}

		
		return excelMap;
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
	
	public Map<String,String> getJsonMap(Method[] getMap) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Map<String,String> tempMap=new HashMap<String,String>();
		
		for(int i=0;i<getMap.length;i++)
        {
        	String valueOfJson="";
        	creditMappingForJson=context.get(CreditConstants.JSON_VALUES);
			if(getMap[i].getName().startsWith("get"))
			{
			valueOfJson=(String) creditMappingForJson.getClass().getMethod(getMap[i].getName()).invoke(creditMappingForJson);
			tempMap.put(getMap[i].getName().toUpperCase(), valueOfJson);
        }
        }
		return tempMap;
		
	}
}
