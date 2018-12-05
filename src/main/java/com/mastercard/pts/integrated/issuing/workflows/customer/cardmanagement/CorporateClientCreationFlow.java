package com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement;
import org.springframework.beans.factory.annotation.Autowired;
import com.mastercard.pts.integrated.issuing.annotation.Workflow;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CorporateClient;
import com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement.CreateCorporatePage;
import com.mastercard.pts.integrated.issuing.pages.navigation.Navigator;

@Workflow
public class CorporateClientCreationFlow {
	
	@Autowired
	private Navigator navigator;
    @Autowired
    private TestContext context;
   
    public void createCorporateClient(CorporateClient corporatepage) {
    	CreateCorporatePage page = navigator.navigateToPage(CreateCorporatePage.class);
		page.createCorporateClient(corporatepage);
	}

}
