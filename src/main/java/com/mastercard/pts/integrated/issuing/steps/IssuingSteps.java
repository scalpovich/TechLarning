/*
 * package com.mastercard.bdd.mpts.steps;
 * 
 * import org.jbehave.core.annotations.Given; import
 * org.jbehave.core.annotations.Then; import org.jbehave.core.annotations.When;
 * import org.springframework.stereotype.Component;
 * 
 * import com.mastercard.bdd.mpts.utils.CustomUtils;
 * 
 * @Component public class IssuingSteps extends AbstractBaseSteps {
 * 
 * @Given("abcd") public void abcd() { // TODO }
 * 
 * 
 * @Given("I login as a Bank User for the BankCode") public void login() { //
 * TODO
 * 
 * login.loadPage(); login.login();
 * 
 * 
 * // oracleInstance.queryATable(sql);
 * 
 * String mystr = ""; mystr = generateinstitutioncode();
 * System.out.println("Ready to send Inst Code : " + mystr);
 * 
 * //loginPage.loadPage(); //loginPage.login(); }
 * 
 * @When("user creates MarketingMessagePlan") public void
 * whenUserCreatesMarketingMessagePlan() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getMarketingMessagePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * marketingMessagePlanPage.addmarketingplan();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates MarketingMessagePlanForPrepaid") public void
 * whenUserCreatesMarketingMessagePlanForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getMarketingMessagePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * marketingMessagePlanPage.addmarketingplanprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates TransactionPlan") public void
 * whenUserCreatesTransactionPlan() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getTransactionPlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * transactionPlanPage.addtransactionplan(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates TransactionPlanForPrepaid") public void
 * whenUserCreatesTransactionPlanForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getTransactionPlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * transactionPlanPage.addtransactionplanprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates TransactionLimitPlan") public void
 * whenUserCreatesTransactionLimitPlan() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getTransactionLimitPlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * transactionLimitPlanPage.addtransactionlimitplan();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates TransactionLimitPlanForPrepaid") public void
 * whenUserCreatesTransactionLimitPlanForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getTransactionLimitPlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * transactionLimitPlanPage.addtransactionlimitplanprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates CreditPlan") public void whenUserCreatesCreditPlan() { //
 * TODO menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCreditCardBilling().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getCreditPlan().click();
 * 
 * creditPlanPage.addcreditplan(); }
 * 
 * @When("user creates DocumentChecklist") public void
 * whenUserCreatesDocumentChecklist() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProgramSetupApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDocumentChecklist().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * documentChecklistPage.adddocumentchecklist();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DocumentChecklistForPrepaid") public void
 * whenUserCreatesDocumentChecklistForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProgramSetupApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDocumentChecklist().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * documentChecklistPage.adddocumentchecklistprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates Office") public void whenUserCreatesOffice() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getOffice().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * officePage.addofficezone(); CustomUtils.ThreadDotSleep(6000);
 * menuSubMenuPage.getOffice().click(); CustomUtils.ThreadDotSleep(2000);
 * officePage.addofficeregion(); CustomUtils.ThreadDotSleep(3000);
 * menuSubMenuPage.getOffice().click(); CustomUtils.ThreadDotSleep(2000);
 * officePage.addofficebranch(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DeviceCardPackTemplate") public void
 * whenUserCreatesDeviceCardPackTemplate() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceCardPackTemplate().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceCardPackTemplatePage.addcardpackidtemplate();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * menuSubMenuPage.getDeviceCardPackTemplate().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceCardPackTemplatePage.adddevicetemplate();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates InstitutionCurrency") public void
 * whenUserCreatesInstitutionCurrency() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getInstitutionCurrency().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * institutionCurrencyPage.addinstitutioncurrency();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates PaymentBounceReason") public void
 * whenUserCreatesPaymentBounceReason() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCreditCardBilling().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getPaymentBounceReason().click();
 * 
 * paymentBounceReasonPage.addpaymentbouncereason(); }
 * 
 * @When("user creates MCG") public void whenUserCreatesMCG() { // TODO
 * 
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getMCG().click();
 * 
 * CustomUtils.ThreadDotSleep(1000); mCGPage.addmcg(); }
 * 
 * @When("user creates CutoverProfile") public void
 * whenUserCreatesCutoverProfile() throws InterruptedException { // TODO
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCutoverProfile().click();
 * 
 * menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup
 * (), menuSubMenuPage.getCutoverProfile());
 * 
 * 
 * CustomUtils.ThreadDotSleep(1000); cutoverProfilePage.addcutoverprofile();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * }
 * 
 * @When("user creates DeviceRange") public void whenUserCreatesDeviceRange() {
 * // TODO menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getDeviceRange().click();
 * 
 * deviceRangePage.adddevicerange(); }
 * 
 * @When("user creates DeviceRangeForPrepaid") public void
 * whenUserCreatesDeviceRangeForPrepaid() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getDeviceRange().click();
 * 
 * deviceRangePage.adddevicerangeprepaid(); }
 * 
 * @When("user creates WalletPlan") public void whenUserCreatesWalletPlan() { //
 * TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getWalletConfiguration().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getWalletPlan().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * walletPlanPage.addwalletplan(); CustomUtils.ThreadDotSleep(2000);
 * //System.out.println("inside prepaid flow");
 * 
 * }
 * 
 * @When("user creates WalletPlanForPrepaid") public void
 * whenUserCreatesWalletPlanForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getWalletConfiguration().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getWalletPlan().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * walletPlanPage.addwalletplanprepaid(); CustomUtils.ThreadDotSleep(2000);
 * //System.out.println("inside prepaid flow");
 * 
 * }
 * 
 * @When("user creates PlasticCode") public void whenUserCreatesPlasticCode() {
 * // TODO CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getPlasticcode().click();
 * 
 * CustomUtils.ThreadDotSleep(1000); plasticCodePage.addplasticcode(); }
 * 
 * @When("user creates BusinessMandatoryFields") public void
 * whenUserCreatesBusinessMandatoryFields() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProgramSetupApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getBusinessMandatoryFields().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * businessMandatoryFieldsPage.addbusinessmandatoryfields();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates BusinessMandatoryFieldsForPrepaid") public void
 * whenUserCreatesBusinessMandatoryFieldsForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProgramSetupApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getBusinessMandatoryFields().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * businessMandatoryFieldsPage.addbusinessmandatoryfieldsprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates PictureCode") public void whenUserCreatesPictureCode() {
 * // TODO
 * 
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getPicturecode().click();
 * 
 * CustomUtils.ThreadDotSleep(1000); pictureCodePage.addpicturecode(); }
 * 
 * @When("user creates DevicePlan") public void whenUserCreatesDevicePlan() { //
 * TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDevicePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * devicePlanPage.adddeviceplan(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DevicePlanForPrepaid") public void
 * whenUserCreatesDevicePlanForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDevicePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * devicePlanPage.adddeviceplanprepaid(null); CustomUtils.ThreadDotSleep(1000);
 * }
 * 
 * @When("user creates DedupePlan") public void whenUserCreatesDedupePlan() { //
 * TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDedupePlan().click();
 * 
 * CustomUtils.ThreadDotSleep(1000); dedupePlanPage.adddedupeplan(); }
 * 
 * @When("user creates Program") public void whenUserCreatesProgram() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getProgram().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * programPage.addprogram();
 * 
 * }
 * 
 * @When("user creates ProgramForPrepaid") public void
 * whenUserCreatesProgramForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getProgram().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * programPage.addprogramprepaid(); CustomUtils.ThreadDotSleep(2000); }
 * 
 * @When("user creates BillingCycle") public void whenUserCreatesBillingCycle()
 * { // TODO menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCreditCardBilling().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getBillingCycle().click();
 * 
 * billingCyclePage.addbillingcycle(); }
 * 
 * @When("user creates MCCRules") public void whenUserCreatesMCCRules() { //
 * TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getMCCRules().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * mCCRulesPage.addmccrules(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates PrepaidStatementPlan") public void
 * whenUserCreatesPrepaidStatementPlan() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getPrepaidMessagePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * prepaidMessagePlanPage.addprepaidmessageplan();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates Vendor") public void whenUserCreatesVendor() { // TODO
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getVendor().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * vendorPage.addvendor();
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getVendor().click();CustomUtils.ThreadDotSleep(1000);
 * vendorPage.addvendor(null); }
 * 
 * @When("user creates DeviceEventBasedFeePlan") public void
 * whenUserCreatesDeviceEventBasedFeePlan(){ //TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceEventBasedFeePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceEventBasedFeePlanPage.adddeviceeventbasedfeeplan();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DeviceEventBasedFeePlanForPrepaid") public void
 * whenUserCreatesDeviceEventBasedFeePlanForPrepaid(){ //TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceEventBasedFeePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceEventBasedFeePlanPage.adddeviceeventbasedfeeplanprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DeviceJoiningFee") public void
 * whenUserCreatesDeviceJoiningFee(){ //TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDeviceJoining().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceJoiningPage.adddevicejoining(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DeviceJoiningFeeForPrepaid") public void
 * whenUserCreatesDeviceJoiningFeeForPrepaid(){ //TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getDeviceConfiguration().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDeviceJoining().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceJoiningPage.adddevicejoiningprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates TransactionRulePlan") public void
 * whenUserCreatesTransactionRulePlan() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCreditCardBilling().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getTransactionRulePlan().click();
 * 
 * transactionRulePlanPage.addtransactionruleplan(); }
 * 
 * @When("user creates DeviceStatus") public void whenUserCreatesDeviceStatus()
 * { // TODO
 * 
 * // 'ADD' funtionality is now removed from STAGE environment
 * 
 * 
 * }
 * 
 * @When("user creates DeviceBIN") public void whenUserCreatesDeviceBIN() { //
 * TODO
 * 
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDeviceBin().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceBinPage.adddevicebin(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates DeviceBINForPrepaid") public void
 * whenUserCreatesDeviceBINForPrepaid() { // TODO
 * 
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getDeviceBin().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceBinPage.adddevicebinprepaid(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @Given(
 * "I login as a Bank User for the BankCode!-- When I select location-group followed by top N locations"
 * ) public void
 * givenILoginAsABankUserForTheBankCodeWhenISelectlocationgroupFollowedByTopNLocations
 * () { // TODO }
 * 
 * @When("user creates EmbossingPriorityPass") public void
 * whenUserCreatesEmbossingPriorityPass() { // Added by Debpriya
 * 
 * menuSubMenuPage.clickMenuSubOption(menuSubMenuPage.getInstitutionParameterSetup
 * (), menuSubMenuPage.getEmbossingParameters());
 * menuSubMenuPage.getEmbossingPriorityPass().click();
 * embossingPriorityPassPage.addembossingprioritypass();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * }
 * 
 * @When("user creates StatementMessagePlan") public void
 * whenUserCreatesStatementMessagePlan() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getStatementMessagePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * statementMessagePlanPage.addstatementmessageplan();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates StatementMessagePlanForPrepaid") public void
 * whenUserCreatesStatementMessagePlanForPrepaid() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getStatementMessagePlan().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * statementMessagePlanPage.addstatementmessageplanprepaid();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates PaymentPriority") public void
 * whenUserCreatesPaymentPriority() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCreditCardBilling().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getPaymentPriority().click();
 * 
 * paymentPriorityPage.addpaymentpriority(); }
 * 
 * @When("user creates WalletFeePlan") public void
 * whenUserCreatesWalletFeePlan() { // TODO
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getProgramSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getWalletConfiguration().click();
 * CustomUtils.ThreadDotSleep(2000); menuSubMenuPage.getWalletFeePlan().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * walletFeePlanPage.addwalletfeeplan(); }
 * 
 * @When("user creates EditFeeReason") public void
 * whenUserCreatesEditFeeReason() { // TODO
 * 
 * 
 * }
 * 
 * @When("user creates EmbossingTemplate") public void
 * whenUserCreatesEmbossingTemplate() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getEmbossingParameters().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getEmbossingTemplate().click();
 * 
 * embossingTemplatePage.addembossingtemplate("Emboss");
 * CustomUtils.ThreadDotSleep(2000); }
 * 
 * @When("user creates NetworkMembership") public void
 * whenUserCreatesNetworkMembership() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getNetworkMembership().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * networkMembershipPage.addnetworkmembership();
 * CustomUtils.ThreadDotSleep(1000); }
 * 
 * @When("user creates TransactionRegistration") public void
 * whenUserCreatesTransactionRegistration() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getTransactionRegistration().click();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * transactionRegistrationPage.addtransactionregistration();
 * CustomUtils.ThreadDotSleep(2000); }
 * 
 * @When("user creates Institution") public void whenUserCreatesInstitution() {
 * institutionSelectionPage.selectInstitution();
 * menuSubMenuPage.getProcessingCenter().click();
 * menuSubMenuPage.getSetup().click(); CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getMasterParameters().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * menuSubMenuPage.getInstitution().click(); CustomUtils.ThreadDotSleep(1000);
 * 
 * institutionCreationPage.createInst(generateinstitutioncode(),
 * generateinstitutionname()); // menu calick // fun call
 * 
 * CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getInstitutionParameterSetup().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCutoverProfile().click();
 * 
 * CustomUtils.ThreadDotSleep(1000);
 * cutoverProfilePage.addcutoverprofileTryDatePicker();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getNewApplication().click();
 * 
 * newApplicationPage.addnewapplication(); CustomUtils.ThreadDotSleep(5000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getActivityApplication().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getCreditSubMenu().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getVerifyorReject().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * verifyorRejectPage.verifyorrejectapplication();
 * CustomUtils.ThreadDotSleep(8000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getApplication().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getCreditSubMenu().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getApproveorReject().click();
 * 
 * approveorRejectPage.approveorrejectapplication();
 * CustomUtils.ThreadDotSleep(8000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getOperationApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCreditSubMenuOperation().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getCloseBatch().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * closeBatchPage.closebatch(); CustomUtils.ThreadDotSleep(8000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getOperationApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCreditSubMenuOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceGeneration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceGenerationPage.devicegeneration(); CustomUtils.ThreadDotSleep(8000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProcessingBatches().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getPreProductionBatch().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * preProductionBatchPage.preproduction(); CustomUtils.ThreadDotSleep(8000);
 * 
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProcessingBatches().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceProduction().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceProductionPage.deviceproduction();
 * 
 * }
 * 
 * @When("login as a normal user") public void loginAndLogout() { // logout and
 * login CustomUtils.ThreadDotSleep(2000);
 * menuSubMenuPage.logoutFromApplication(); CustomUtils.ThreadDotSleep(2000);
 * loginPage
 * .login(env.getProperty("app.user.name"),env.getProperty("app.user.pwd"));
 * CustomUtils.ThreadDotSleep(2000);
 * institutionSelectionPage.selectInstitution2();
 * CustomUtils.ThreadDotSleep(2000);
 * 
 * 
 * institutionSelectionPage.selectInstitution3();
 * CustomUtils.ThreadDotSleep(9000); userPage.createuser();
 * 
 * 
 * }
 * 
 * @When("user creates CloseBatch") public void whenUserCreatesCloseBatch() { //
 * TODO menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getOperationApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCreditSubMenuOperation().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getCloseBatch().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * closeBatchPage.closebatch(); CustomUtils.ThreadDotSleep(8000); }
 * 
 * @Then("credit application will get created") public void
 * thenCreditApplicationWillGetCreatedThenItShowsTheReportPageForBaseVersionThenVerifyTheContentsOfTheReportPageForOneLocationThenVerifyTheContentsOfTheReportPageForAnotherLanguageThenRepeatTheVerificationForRemainingLocations
 * () { // TODO }
 * 
 * @When("user creates Verify") public void whenUserCreatesVerify() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getActivityApplication().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getCreditSubMenu().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getVerifyorReject().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * verifyorRejectPage.verifyorrejectapplication();
 * CustomUtils.ThreadDotSleep(8000); }
 * 
 * @When("user creates PreProductionBatch") public void
 * whenUserCreatesPreProductionBatch() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProcessingBatches().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getPreProductionBatch().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * preProductionBatchPage.preproduction(); CustomUtils.ThreadDotSleep(8000); }
 * 
 * @When("user creates ApproveReject") public void
 * whenUserCreatesApproveReject() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getApplication().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getCreditSubMenu().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getApproveorReject().click();
 * 
 * approveorRejectPage.approveorrejectapplication();
 * CustomUtils.ThreadDotSleep(8000); }
 * 
 * @When("user creates DeviceProductionBatch") public void
 * whenUserCreatesDeviceProductionBatch() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProcessingBatches().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceProduction().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceProductionPage.deviceproduction(); }
 * 
 * @When("user creates DeviceGeneration") public void
 * whenUserCreatesDeviceGeneration() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getOperationApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getCreditSubMenuOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getDeviceGeneration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * deviceGenerationPage.devicegeneration(); CustomUtils.ThreadDotSleep(8000); }
 * 
 * @When("user creates NewApplication") public void
 * whenUserCreatesNewApplication() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getApplication().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getNewApplication().click();
 * 
 * newApplicationPage.addnewapplication(); CustomUtils.ThreadDotSleep(5000); }
 * 
 * @When("user creates BulkDeviceRequest") public void
 * whenUserCreatesBulkDeviceRequest() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(3000); menuSubMenuPage.getActivity().click();
 * CustomUtils.ThreadDotSleep(3000); menuSubMenuPage.getDeviceMenu().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getBulkDeviceRequest().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * 
 * deviceProdBulkRequestPage.addDeviceProdBulkRequest();
 * CustomUtils.ThreadDotSleep(3000); }
 * 
 * @When("user creates BulkDeviceGeneration") public void
 * whenUserCreatesBulkDeviceGeneration() { // TODO
 * menuSubMenuPage.getCardManagement().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getOperation().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getProcessingBatches().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getBulkDeviceGeneration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * bulkDeviceGenerationBatchPage.addbulkdevicegenerationbatch();
 * CustomUtils.ThreadDotSleep(8000); }
 * 
 * @When("user creates another user") public void whenUserCreatesAnotherUser(){
 * //TODO menuSubMenuPage.getAdministration().click();
 * CustomUtils.ThreadDotSleep(1000);
 * menuSubMenuPage.getAdministrationSetup().click();
 * CustomUtils.ThreadDotSleep(1000); menuSubMenuPage.getUser().click();
 * CustomUtils.ThreadDotSleep(1000);
 * 
 * userPage.createuser(); CustomUtils.ThreadDotSleep(1000); }
 * 
 * @Then("i check this") public void thenICheckThis(){
 * 
 * }
 * 
 * 
 * 
 * @Then("prepaid application will get created") public void
 * prepaidcardcreated() { // TODO }
 * 
 * @When("user creates samplestep") public void sampleteps() {
 * System.out.println("sample step"); } }
 */