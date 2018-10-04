package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.DBUtility;
import com.mastercard.pts.integrated.issuing.utils.DateUtils;



@Component
public class DatabaseFlows {
	
	@Autowired
	private DBUtility dbUtil;	
	
//	@Value("${institution}")
	private String institution;

	public void updateInstituteDateToFirstOfNextMonth(String date)
	{		
		
		String queryString = "update system_codes set short_name='-" + DateUtils.getNextMonthFirstDayDifference(date) + "'  WHERE TYPE_ID = 'SYS_PARAM' AND code = 'BACK_DAY' AND bank_code = '"+ getInstitutionCode() +"'";
		dbUtil.executeUpdate(queryString);
	}
	
	public String getInstitutionCode()
	{
		return institution.substring(institution.indexOf('[')+1, institution.indexOf(']'));
	}
}
