package com.sample.tests;

import com.sample.pages.ConfirmationDialog;
import com.sample.pages.PizzaPage;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTest extends TestBase {

	/*
	 * This method will check the Missing Phone number validation.
	 */
	@Test(priority = 1 )
	public void checkMissingPhoneNum() throws Exception {

		PizzaPage pizzaPage = new PizzaPage(this.driver);
		pizzaPage.setPizzaTypeFromEnum(PizzaTypes.MEDIUM_TWOTOPPINGS);
		pizzaPage.setPizzaToppingType1FromEnum(PizzaToppings.MANGOS);
		pizzaPage.setPizzaToppingType2FromEnum(PizzaToppings.MUSHROOMS);
		pizzaPage.setPizzaQuantityint(1);
		pizzaPage.setCustomerName("TestName");
		pizzaPage.setCustomerEmail("Test@test.com");
		pizzaPage.setCardPayment();
		pizzaPage.placeOrder();

		ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.driver);
		String text = confirmationDialog.getConfirmationText();
		confirmationDialog.closeDialogBox();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(text, "Missing phone number");
		softAssert.assertAll();
	}
	/*
	 * This method will check the Missing Name validation.
	 */
	@Test(priority = 2)
	public void checkMissingName() throws InterruptedException {

		PizzaPage pizzaPage = new PizzaPage(this.driver);
		pizzaPage.resetbtn();
		pizzaPage.setPizzaTypeFromEnum(PizzaTypes.MEDIUM_TWOTOPPINGS);
		pizzaPage.setPizzaToppingType1FromEnum(PizzaToppings.MANGOS);
		pizzaPage.setPizzaToppingType2FromEnum(PizzaToppings.MUSHROOMS);
		pizzaPage.setPizzaQuantityint(2);
		pizzaPage.setCustomerPhone("8954752015");
		pizzaPage.setCustomerEmail("Test@test.com");
		pizzaPage.setCardPayment();
		pizzaPage.placeOrder();

		ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.driver);
		String text = confirmationDialog.getConfirmationText();
		confirmationDialog.closeDialogBox();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(text, "Missing name");
		softAssert.assertAll();
	}
	/*
	 * This method will check the Invalid Quantity validation.
	 */
	@Test(priority = 3)
	public void checkInvalidqty() throws InterruptedException {

		PizzaPage pizzaPage = new PizzaPage(this.driver);
		pizzaPage.setPizzaTypeFromEnum(PizzaTypes.MEDIUM_TWOTOPPINGS);
		pizzaPage.setPizzaToppingType1FromEnum(PizzaToppings.MANGOS);
		pizzaPage.setPizzaToppingType2FromEnum(PizzaToppings.MUSHROOMS);
		pizzaPage.setPizzaQuantitystr("abc");
		pizzaPage.setCustomerName("TestName");
		pizzaPage.setCustomerPhone("8954752015");
		pizzaPage.setCustomerEmail("Test@test.com");
		pizzaPage.setCashPayment();
		pizzaPage.placeOrder();

		ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.driver);
		String text = confirmationDialog.getConfirmationText();
		confirmationDialog.closeDialogBox();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(text, "Thank you for your order! TOTAL: NaN");
		softAssert.assertAll();
	}
	/*
	 * This method will check the Reset button (Clear all fields) functionality.
	 */
	@Test(priority = 4)
	public void checkresetbtn() throws InterruptedException {

		PizzaPage pizzaPage = new PizzaPage(this.driver);
		
		pizzaPage.setPizzaTypeFromEnum(PizzaTypes.MEDIUM_TWOTOPPINGS);
		pizzaPage.setPizzaToppingType1FromEnum(PizzaToppings.MANGOS);
		pizzaPage.setPizzaToppingType2FromEnum(PizzaToppings.MUSHROOMS);
		pizzaPage.setPizzaQuantitystr("abc");
		pizzaPage.setCustomerName("TestName");
		pizzaPage.setCustomerPhone("8954752015");
		pizzaPage.setCustomerEmail("Test@test.com");
		pizzaPage.setCardPayment();
		pizzaPage.setCashPayment();

		pizzaPage.resetbtn();
		Thread.sleep(5000);

		String pizza = pizzaPage.getPizzaTypeName();
		String pizzaQty = pizzaPage.getQuantity();
		String customer_name = pizzaPage.getcustName();
		String customer_email = pizzaPage.getEmail();
		String customer_phone = pizzaPage.getPhone();
		boolean credit_option = pizzaPage.getCCPayment();
		boolean cash_option = pizzaPage.getCashPayment();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(pizza, "Choose Pizza");
		softAssert.assertEquals(pizzaQty, "");
		softAssert.assertEquals(customer_name, "");
		softAssert.assertEquals(customer_email, "");
		softAssert.assertEquals(customer_phone, "");
		softAssert.assertEquals(credit_option, false);
		softAssert.assertEquals(cash_option, false);
		softAssert.assertAll();
	}
}
