package com.mastercard.pts.integrated.issuing.pages.customer.cardmanagement;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.CreditConstants;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Device;
import com.mastercard.pts.integrated.issuing.domain.helpdesk.HelpDeskGeneral;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.pages.navigation.annotation.Navigation;
import com.mastercard.pts.integrated.issuing.utils.CustomUtils;
import com.mastercard.pts.integrated.issuing.utils.WebElementUtils;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorUtilities;
import com.mastercard.testing.mtaf.bindings.element.MCWebElement;
import com.mastercard.testing.mtaf.bindings.element.ElementsBase.FindBy;
import com.mastercard.testing.mtaf.bindings.page.PageElement;

@Component
@Navigation(tabTitle = CardManagementNav.TAB_CARD_MANAGEMENT, treeMenuItems = { CardManagementNav.L1_ACTIVITY, CardManagementNav.L2_ACTIVITY_APPLICATION, CardManagementNav.L3_INCOMPLETE_APPLICATION })
public class IncompleteApplicationPage extends AbstractCardManagementPage {

	private static final Logger logger = LoggerFactory.getLogger(IncompleteApplicationPage.class);

	@Autowired
	TestContext context;

	@Autowired
	private KeyValueProvider provider;
	
	// ------------- Card Management > Institution Parameter Setup > Institution
	// Currency [ISSAP0R]
	private static final String INCOMPLETE_FRAME = "Edit Application";
	@PageElement(findBy = FindBy.CLASS, valueToFind = "addR")
	private MCWebElement addEmbossingPriorityPass;

	@PageElement(findBy = FindBy.NAME, valueToFind = "cobrandNumber:input:inputTextField")
	private MCWebElement partnerMSNumberAdded;

	@PageElement(findBy = FindBy.NAME, valueToFind = "planDesc:input:inputTextField")
	private MCWebElement descriptionTxt;

	@PageElement(findBy = FindBy.NAME, valueToFind = "save")
	private MCWebElement save;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='applicationNumber']")
	private MCWebElement applicationNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='fromDate']/../..")
	private MCWebElement fromDatePicker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='toDate']/../..")
	private MCWebElement toDatePicker;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[8]/span//img")
	private MCWebElement editImg;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//*[@name='verify']")
	private MCWebElement verifyBtn;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='formNumber']")
	private MCWebElement formNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//td[@id='batchNum']//span[@class='labeltextf']")
	private MCWebElement batchNumberTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//table[@class='dataview']//tbody/tr[1]/td[1]/span//span")
	private MCWebElement applicationNumberFileUploadTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//a[text()='Verify']")
	private MCWebElement verifyLink;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='firstName']")
	private MCWebElement firstNameTxt;

	@PageElement(findBy = FindBy.X_PATH, valueToFind = "//input[@fld_fqn='lastName']")
	private MCWebElement lastNameTxt;

	public void incompleteApplication() {
		Device device = context.get(CreditConstants.APPLICATION);
		WebElementUtils.enterText(applicationNumberTxt, device.getApplicationNumber());
		WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
		WebElementUtils.pickDate(toDatePicker, LocalDate.now());
		clickSearchButton();
	}

	public String editAndSaveIncompleteApplication() {
		Device device = Device.createWithProviderForOtherDetails(provider);
		incompleteApplication();
		waitForPageToLoad(driver());
		clickWhenClickable(editImg);
		SimulatorUtilities.wait(5000);

		runWithinPopup("Edit Application", () -> {
			if (isElementPresent(partnerMSNumberAdded)) {
				String randomPartnerMSNumber=CustomUtils.randomNumbers(5);
				enterValueinTextBox(partnerMSNumberAdded, randomPartnerMSNumber);
				device.setPartnerMembershipNumber(randomPartnerMSNumber);
				logger.info(device.getPartnerMembershipNumber());
				context.put(ContextConstants.DEVICE, device);
			}
			clickWhenClickable(save);
		});

		verifyOperationStatus();
		return getCodeFromInfoMessage("Application Number");
	}

	public void incompleteApplicationFileUpload() {
		Map<String, Object> mapFileUpload = context.get(CreditConstants.FILEUPLOAD_IN_BULK);
		List<String> allBatchNumbers = new LinkedList<>();
		List<String> allApplicationNumbers = new LinkedList<>();
		for (Map.Entry<String, Object> entry : mapFileUpload.entrySet()) {
			HelpDeskGeneral helpDeskGeneral = (HelpDeskGeneral) entry.getValue();
			WebElementUtils.enterText(formNumberTxt, helpDeskGeneral.getFormNumber());
			WebElementUtils.enterText(firstNameTxt, helpDeskGeneral.getFirstName());
			WebElementUtils.enterText(lastNameTxt, helpDeskGeneral.getLastName());
			WebElementUtils.pickDate(fromDatePicker, LocalDate.now().minusDays(1));
			WebElementUtils.pickDate(toDatePicker, LocalDate.now());
			clickSearchButton();
			waitForPageToLoad(driver());
			allApplicationNumbers.add(applicationNumberFileUploadTxt.getText());
			clickWhenClickable(editImg);
			switchToIframe(INCOMPLETE_FRAME);
			SimulatorUtilities.wait(8000);
			allBatchNumbers.add(batchNumberTxt.getText());
			clickWhenClickablewithWicket(verifyBtn);
			SimulatorUtilities.wait(10000);
			clickWhenClickable(verifyLink);
		}
		context.put(CreditConstants.ALL_APPLICATION_NUMBERS, allApplicationNumbers);
		context.put(CreditConstants.ALL_BATCH_NUMBERS, allBatchNumbers);
	}

	@Override
	public void verifyUiOperationStatus() {
		logger.info("Incomplete Application");
		verifySearchButton("Search");
	}
}
