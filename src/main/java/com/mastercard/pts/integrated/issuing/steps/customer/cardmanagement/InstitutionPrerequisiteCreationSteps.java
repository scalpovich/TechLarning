package com.mastercard.pts.integrated.issuing.steps.customer.cardmanagement;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.BusinessCalendar;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CutoverProfile;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DeviceBin;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinAndPriorityPassFileNameParameter;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.EmbossingPinPriorityPassFileTemplate;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.HolidayConfiguration;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.InstitutionCurrency;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.IssuerPublicKey;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.NetworkMembership;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Office;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PictureCode;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.PlasticCode;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Vendor;
import com.mastercard.pts.integrated.issuing.domain.provider.DataProvider;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.customer.cardmanagement.InstitutionCreationWorkflow;

@Component
public class InstitutionPrerequisiteCreationSteps{
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private KeyValueProvider provider;
	
	@Autowired
	private DataProvider dbProvider;

	@Autowired
	private InstitutionCreationWorkflow institutionCreationWorkflow;
	
	@Given("check for new Institution status")
	@When("check for new Institution status")
	public void givenCheckforNewInstitutionStatus(){
		assertTrue("Institution already exist, so no need of pre requisite data creation",context.get("NEW_INSTITUION_CREATED").equals(true));
	}
	
	@Given("user creates new holiday configuration")
	@When("user creates new holiday configuration")
	public void givenUserCreatesNewHolidayConfiguration(){
		HolidayConfiguration hc=HolidayConfiguration.createWithProvider(dbProvider);
		institutionCreationWorkflow.createHolidayConfiguration(hc);
	}
	
	@Given("user creates new business calendar")
	@When("user creates new business calendar")
	public void givenUserCreatesNewBusinessCalendar(){
		BusinessCalendar bc=BusinessCalendar.createWithProvider(dbProvider);
		institutionCreationWorkflow.createBusinessCalendar(bc);
	}
	
	@Given("user creates new cutover profile")
	@When("user creates new cutover profile")
	public void givenUserCreatesNewCutoverProfile(){
		CutoverProfile cp=CutoverProfile.createWithProvider(dbProvider);
		institutionCreationWorkflow.createCutOverProfile(cp);
	}
	
	@Given("user creates new network membership")
	@When("user creates new network membership")
	public void givenUserCreatesNewNetworkMembership(){
		List<NetworkMembership> nwmList=NetworkMembership.createWithProvider(dbProvider);
		institutionCreationWorkflow.createNetworkMembership(nwmList);
	}
	
	@Given("user creates new institute currency")
	@When("user creates new institute currency")
	public void givenUserCreatesNewInstituteCurrency(){
		InstitutionCurrency instCurrency=InstitutionCurrency.createWithProvider(dbProvider);
		institutionCreationWorkflow.createInstitutionCurrency(instCurrency);
	}
	
	@Given("user creates new office")
	@When("user creates new office")
	public void givenUserCreatesOffice(){
		List<Office> ofcList=Office.createWithProvider(dbProvider);
		institutionCreationWorkflow.createOffice(ofcList);
	}
	
	@Given("user creates new plastic code")
	@When("user creates new plastic code")
	public void givenUserCreatesPlasticCode(){
		PlasticCode cp=PlasticCode.createWithProvider(dbProvider);
		institutionCreationWorkflow.createPlasticCode(cp);
	}
	
	@Given("user creates new picture code")
	@When("user creates new picture code")
	public void givenUserCreatesPictureCode(){
		PictureCode cp=PictureCode.createWithProvider(dbProvider);
		institutionCreationWorkflow.createPictureCode(cp);
	}
	@Given("user creates new device bin")
	@When("user creates new device bin")
	public void givenUserCreatesDeviceBin(){
		List<DeviceBin> deviceBinList=DeviceBin.createWithProvider(dbProvider);
		institutionCreationWorkflow.createDeviceBin(deviceBinList);
	}
	
	@Given("user creates new issuer public key")
	@When("user creates new issuer public key")
	public void givenUserCreatesIssuerPublicKey(){
		List<IssuerPublicKey> ipkList=IssuerPublicKey.createWithProvider(dbProvider);
		institutionCreationWorkflow.createIpk(ipkList);
	}
	
	@Given("user adds embossing pin priority pass file template")
	@When("user adds embossing pin priority pass file template")
	public void givenUserAddsEmbossingPinPriorityPassFileTemplate(){
		List<EmbossingPinPriorityPassFileTemplate> dataProvider = EmbossingPinPriorityPassFileTemplate.createDataWithProvider();
		institutionCreationWorkflow.embossingPinPriorityPassFileTemplate(dataProvider); 
	}
	@Given("user adds the vendor masters")
	@When("user adds the vendor masters")
	public void givenUserAddsTheVendorMasters(){
		List<Vendor> vendorMasterData = Vendor.createWithProvider(provider);
		institutionCreationWorkflow.addVendorMasters(vendorMasterData);
	}
	@Given("user adds embossing pin Priority pass file names")
	@When("user adds embossing pin Priority pass file names")
	public void givenUserAddsEmbossingPinPriorityPassFileNames(){
		List<EmbossingPinAndPriorityPassFileNameParameter> dataProvider = EmbossingPinAndPriorityPassFileNameParameter
				.createWithProvider(provider);
		institutionCreationWorkflow
				.addEmbossingPinPriorityPassFileNames(dataProvider);
	}
	@Given("user enables transaction registration")
	@When("user enables transaction registration")
	public void givenUserEnablesTransactionRegisters(){
		institutionCreationWorkflow.registerTransactions();
	}
	
}