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
import com.mastercard.pts.integrated.issuing.domain.InstitutionData;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.processingcenter.Institution;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.utils.ConstantData;

@Component
public class JsonUtilitySteps {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtilitySteps.class);
	
	@Autowired
	private KeyValueProvider keyValueProvider;

	@Autowired
	private TestContext context;

	@Autowired
	private DataProvider provider;
	
	@Autowired
	private CreditMappingForExcel creditMappingForExcel;
	
	private InstitutionData jsonMappingData;
	
	 
	@Given("setting json values in excel for $product")
	public void mappingJsonValuesInExcel(String product) throws Exception{
		context.put(ConstantData.PRODUCT_IDENTITY, product);
		Method[]methodsJson = InstitutionData.class.getDeclaredMethods();
		
		/** Step-1
		 * creating context of excel and JSON for all the fields mention in InstitutionData.json
		 */
		contextForExcelAndJson(System.getProperty(ConstantData.INSTITUTION_KEY));
	    context.put(CreditConstants.JSON_VALUES, jsonMappingData);

		/**Step-2
		 * Getting the initial excel context which retrieves all the data of @Storyname
		 */
        Map<String, Object> map = context.get(TestContext.KEY_STORY_DATA);
        ConcurrentHashMap<String, Object>concurrentMap=new ConcurrentHashMap<String, Object>(map);
        
        //get JSON values in map
        Map<String,String>jsonMap=getJsonMap(methodsJson);

        //append extra JSON values to ExcelMap
        map=putExtraJsonValuesToExcel(concurrentMap, jsonMap);
        
        //replace excel values with Excel values
        Map<String, Object> allInOneMap=replacingValuesFromJsonToExcel(map, jsonMap);
        logger.info("Institution JSON data is updated");
        context.put(TestContext.KEY_STORY_DATA,allInOneMap);		
	}
	
	public void updatedExcelContext(Map<String, String> jsonMap,
			Map<String, Object> map) {
		String updatedValue="";
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			for(Map.Entry<String, String> entryJson:jsonMap.entrySet()){	            
			  if (entryJson.getKey().toUpperCase().contains(entry.getKey().replaceAll("_", ""))) {	 
				   updatedValue=String.valueOf(entry.getValue()).replaceAll(".+", entryJson.getValue());				  
					map.put(entry.getKey(), updatedValue);	
			  }	   
			   List<String>excelKeysWithoutUnderScore = new LinkedList<String>();
			   Set<String>keysExcel = map.keySet();
			   keysExcel.stream().forEach((excelKey)-> {
				  excelKeysWithoutUnderScore.add(excelKey.replaceAll("_", ""));
			   });
				  
				Set<String> keysJson = jsonMap.keySet();
				
				keysJson.stream().forEach((jsonKey) ->{
					String[] jsonKeyWithoutGet = jsonKey.split("get");
					if (!excelKeysWithoutUnderScore.contains(jsonKeyWithoutGet[1].toUpperCase())) {
						map.put(jsonKey, jsonMap.get(jsonKey));
					}
				});
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
			
			jsonMappingData=context.get(CreditConstants.JSON_VALUES);
			if(methodsJson[i].getName().startsWith("get")){
				valueJson=(String) jsonMappingData.getClass().getMethod(methodsJson[i].getName()).invoke(jsonMappingData);
					
				for(int j=0;j<methodsExcel.length;j++){
					if(methodsJson[i].getName().equalsIgnoreCase(methodsExcel[j].getName())&& methodsJson[i].getName().startsWith("get")){
						
						creditMappingForExcel=context.get(CreditConstants.EXCEL_VALUES);
						
						
						 valueExcel=(String) creditMappingForExcel.getClass().getMethod(methodsExcel[j].getName()).invoke(creditMappingForExcel);
						
						 valueExcel = valueExcel.replaceAll(".+", valueJson);
						 jsonMap.put(methodsJson[i].getName(), valueJson);
		
					}else {
						jsonMap.put(methodsJson[i].getName(),valueJson);
						break;
					}
		         }
			}
		}		
	}
	
	public Map<String, Object> replacingValuesFromJsonToExcel(Map<String, Object> excelMap, Map<String, String> jsonMap) throws Exception {
		String updatedValue = null;
		for (Map.Entry<String, Object> entry : excelMap.entrySet()) {
			for (Map.Entry<String, String> entryJson : jsonMap.entrySet()) {
				if (entryJson.getKey().equalsIgnoreCase(entry.getKey().replaceAll("_", ""))) {
					updatedValue = String.valueOf(entry.getValue()).replaceAll(".+", entryJson.getValue());
					excelMap.put(entry.getKey(), updatedValue);
				}
			}
		}
		return excelMap;
	}

	public Map<String, Object> putExtraJsonValuesToExcel(Map<String, Object> excelMap, Map<String, String> jsonMap) throws Exception {
		Map<String, Object> excelMapWithoutUnderScore = new HashMap<String, Object>();
		ArrayList<String> keyList = new ArrayList<String>();
		
		for (Map.Entry<String, Object> entry : excelMap.entrySet()) {
			excelMapWithoutUnderScore.put(entry.getKey().replaceAll("_", ""), entry.getValue());
			keyList.add(entry.getKey().replaceAll("_", ""));
		}
		jsonMap.entrySet().stream().forEach((entry)->{
			if (!keyList.contains(entry.getKey().replaceFirst("GET", ""))) {
				excelMap.put(entry.getKey(), entry.getValue());
			}
		});
		
		return excelMap;
	}

	public void contextForExcelAndJson(String institution) {
		if(StringUtils.isEmpty(institution)){
			jsonMappingData =InstitutionData.createWithProvider(provider,Institution.createWithProvider(provider).getCode());
			creditMappingForExcel=creditMappingForExcel.createWithProviderCSV(keyValueProvider);
			context.put(CreditConstants.EXCEL_VALUES,creditMappingForExcel);
		}else{
			institution = institution.replaceAll("\\s+","");
			String[]institutionSplit = institution.split("\\[");
			String institutionCode = institutionSplit[1].substring(0, institutionSplit[1].length()-1);
			jsonMappingData = InstitutionData.createWithProvider(provider,institutionCode);
			creditMappingForExcel = creditMappingForExcel.createWithProviderCSV(keyValueProvider);
			context.put(CreditConstants.EXCEL_VALUES,creditMappingForExcel);
		}
	}
	
	public Map<String, String> getJsonMap(Method[] getMap) throws Exception {
		Map<String, String> tempMap = new HashMap<String, String>();
		jsonMappingData = context.get(CreditConstants.JSON_VALUES);
		
		for (int i = 0; i < getMap.length; i++) {			
			if (getMap[i].getName().startsWith("get")) { 
				//getting InstitutionData Getters values and storing in map
				tempMap.put(getMap[i].getName().toUpperCase(), (String) jsonMappingData.getClass().getMethod(getMap[i].getName()).invoke(jsonMappingData));
			}
		}		
		return tempMap;
	}
}