package com.mastercard.pts.integrated.issuing.steps.agent.inventory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.ContextConstants;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.CardType;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Acceptance;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Order;
import com.mastercard.pts.integrated.issuing.domain.agent.inventory.Status;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.DevicePlan;
import com.mastercard.pts.integrated.issuing.domain.customer.cardmanagement.Program;
import com.mastercard.pts.integrated.issuing.domain.provider.KeyValueProvider;
import com.mastercard.pts.integrated.issuing.workflows.agent.inventory.InventoryWorkflow;

@Component
public class InventorySteps {
	private static final String ORDER_CREATION_MESSAGE = "Order generated successfully and Order No is";
	private static final String ACCEPTANCE_MESSAGE = "Order acceptance successful";
	private static final String STATUS_MESSAGE = "RFO-Full Order Received";
	private static final String FAILED_MESSAGE_INFO = "Page Load Failed";
	private Order order;

	@Autowired
	private TestContext context;

	@Autowired
	private InventoryWorkflow inventoryWorkflow;

	@Autowired
	private KeyValueProvider provider;

	@Autowired
	DevicePlan devicePlan;

	@When("user navigates to order page")
	public void whenUserNavigatesToOrderPage() {
		inventoryWorkflow.navigateToOrderPage();
	}

	@Then("order page is loaded and master detail content title is $expectedTitleText")
	public void thenCreateRolePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getOrderMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to order acceptance page")
	public void whenUserNavigatesToAcceptancePage() {
		inventoryWorkflow.navigateToAcceptancePage();
	}

	@Then("order acceptance page is loaded and master detail content title is $expectedTitleText")
	public void thenAcceptancePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getAcceptanceMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to order status page")
	public void whenUserNavigatesToStatusPage() {
		inventoryWorkflow.navigateToStatusPage();
	}

	@Then("order status page is loaded and master detail content title is $expectedTitleText")
	public void thenStatusPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getStatusMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to order cancellation page")
	public void whenUserNavigatesToOrderCancellationPage() {
		inventoryWorkflow.navigateToOrderCancellationPage();
	}

	@Then("order cancellation page is loaded and master detail content title is $expectedTitleText")
	public void thenOrderCancellationPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getOrderCancellationMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to stock transfer intra branch page")
	public void whenUserNavigatesToStockTransferIntraBranchPage() {
		inventoryWorkflow.navigateToStockTransferIntraBranchPage();
	}

	@Then("stock transfer intra branch page is loaded and master detail content title is $expectedTitleText")
	public void thenStockTransferIntraBranchPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getStockTransferIntraBranchMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to stock transfer acceptance page")
	public void whenUserNavigatesToStockTransferAcceptancePage() {
		inventoryWorkflow.navigateToStockTransferAcceptancePage();
	}

	@Then("stock transfer acceptance page is loaded and master detail content title is $expectedTitleText")
	public void thenStockTransferAcceptancePageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getStockTransferAcceptanceMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to stock return page")
	public void whenUserNavigatesToStockReturnPage() {
		inventoryWorkflow.navigateToStockReturnPage();
	}

	@Then("stock return page is loaded and master detail content title is $expectedTitleText")
	public void thenStockReturnPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getStockReturnMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@When("user navigates to inventory status page")
	public void whenUserNavigatesToInventoryStatusPage() {
		inventoryWorkflow.navigateToInventoryStatusPage();
	}

	@Then("inventory status page is loaded and master detail content title is $expectedTitleText")
	public void thenInventoryStatusPageLoaded(String expectedTitleText) {
		assertThat(FAILED_MESSAGE_INFO, inventoryWorkflow.getInventoryStatusMasterDetailContentTitleText(),
				containsString(expectedTitleText));
	}

	@Given("user enters order details and submits the form")
	@When("user enters order details and submits the form")
	public void whenUserEntersOrderDetailsAndSubmitsTheForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		order = Order.createWithProvider(provider);
		order.setProgram(program.buildDescriptionAndCode());
		order.setDeviceType(CardType.fromShortName(devicePlan.getDeviceType()));
		String orderNumber = inventoryWorkflow.createOrder(order);
		order.setOrderNumber(orderNumber);
		context.put(ContextConstants.ORDER, order);
	}

	@Given("user fills order details and submits the form")
	@When("user fills order details and submits the form")
	public void whenUserFillsOrderDetailsAndSubmitsTheForm() {
		Program program = context.get(ContextConstants.PROGRAM);
		order = Order.createWithProvider(provider);
		order.setProgram(program.buildDescriptionAndCode());
		String orderNumber = inventoryWorkflow.createOrder(order);
		order.setOrderNumber(orderNumber);
		context.put(ContextConstants.ORDER, order);
	}

	@When("order is successful")
	@Then("order is successful")
	public void thenOrderIsSuccessful() {
		assertThat("Order Creation Failed", inventoryWorkflow.getOrderCreationMessage(),
				containsString(ORDER_CREATION_MESSAGE));
	}

	@Given("user fills the order acceptance details and submits the form")
	@When("user fills the order acceptance details and submits the form")
	public void whenUserFillsTheOrderAcceptanceDetailsAndSubmitsTheForm() {
		Acceptance acceptance = Acceptance.createWithProvider(provider);
		acceptance.setOrderNumber(order.getOrderNumber() + " [New Order]");
		inventoryWorkflow.acceptDispatch(acceptance);
	}

	@When("order acceptance is successful")
	@Then("order acceptance is successful")
	public void thenOrderAcceptanceIsSuccessful() {
		assertThat("Dispatch Acceptance Failed", inventoryWorkflow.getDispatchAcceptanceMessage(),
				containsString(ACCEPTANCE_MESSAGE));
	}

	@Given("user fills status details and submits the form")
	@When("user fills status details and submits the form")
	public void whenUserFillsStatusDetailsAndSubmitsTheForm() {
		Status status = Status.createWithProvider(provider);
		status.setOrderNumber(order.getOrderNumber());
		inventoryWorkflow.statusInfo(status);
	}

	@When("status column updates with type of order accepted")
	@Then("status column updates with type of order accepted")
	public void thenStatusColumnUpdatesWithTypeOfOrderAccepted() {
		assertThat("Status update Failed", inventoryWorkflow.getStatusMessage(), containsString(STATUS_MESSAGE));
	}
}