package com.mastercard.pts.integrated.issuing.workflows.credit;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.ApprovalScorePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Workflow
public class ApprovalScoreWorkFlow {
	@Autowired
	private Navigator navigator;
	@Autowired
    ApprovalScorePage approvalScorePage;
	public void userAddsNewApprovalScore()
	{
		approvalScorePage = navigator.navigateToPage(ApprovalScorePage.class);
		approvalScorePage.addApprovalScore();
	}
	public void userVerifiesAndEditsNewApprovalScore()
	{
	approvalScorePage.verifyUiOperationStatus();
	}
	
	public void verifyIsRecordAddedinTable()
	{
		approvalScorePage.valuesAddedInTable();
		approvalScorePage.addApprovalScore();
		if(approvalScorePage.addApprovalScore().size()==approvalScorePage.valuesAddedInTable().size())
		{
		if(approvalScorePage.addApprovalScore().retainAll(approvalScorePage.valuesAddedInTable())&&approvalScorePage.valuesAddedInTable().retainAll(approvalScorePage.addApprovalScore()))
		{
		Assert.assertTrue("the values are added in table properly", true);	
		}
		else
		{
			Assert.assertTrue("the values are not added in table properly", false);	
		}
		}
	}
	/*public void verifyIsRecordAdded() throws Exception
	   {
		Method[] m = ApprovalScorePage.class.getDeclaredMethods();
		for (int i = 0; i < m.length; i++)
		{
			if(m[i].toString().contains("valuesAddedInTable()"))
			{
				System.out.println("Value:"+(String)m[i].invoke(new ApprovalScorePage()));
			}
		}
		   LinkedList<String>allValuesUpdated = new LinkedList<>();
		   for(int i=0;i<allValues.size();i++)
		   {
			   if(allValues.get(i).getText().equals(" ")||allValues.get(i).getText().equals(""))
			   {
				   allValues.remove(i);
			   }
			   allValuesUpdated.add(allValues.get(i).getText());
		   }
		   if(addedValues.retainAll(allValuesUpdated)&& allValuesUpdated.retainAll(addedValues))
		   {
			   Assert.assertTrue(message, condition);
		   }
	   }
	   
   
}*/
}