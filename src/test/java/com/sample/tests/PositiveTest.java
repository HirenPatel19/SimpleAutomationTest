package com.sample.tests;

import com.sample.pages.ConfirmationDialog;
import com.sample.pages.PizzaPage;
import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaTypes;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class PositiveTest extends TestBase {

	@DataProvider(name = "pizza types")
	public Object[][] pizzaTypes() {
		ArrayList<Object[]> objects = new ArrayList<>();
		for (PizzaTypes types : PizzaTypes.values()) {
			objects.add(new Object[] { types.getDisplayName(), types.getCost() });
		}
		return objects.toArray(new Object[0][]);
	}
/*
 * This is the end-to-end positive flow test which will take each pizza type and completes the order.
 */
	@Test(dataProvider = "pizza types", priority = 1)
	public void testPizzaType(String pizzaName, Double pizzaCost) throws InterruptedException {

		PizzaPage pizzaPage = new PizzaPage(this.driver);
		pizzaPage.setPizzaType(pizzaName);
		Thread.sleep(2000);
		pizzaPage.setToppings1Type("Diced Mango");
		Thread.sleep(2000);
		pizzaPage.setToppings2Type("Mushrooms");
		Thread.sleep(2000);
		pizzaPage.setPizzaQuantityint(1);
		Thread.sleep(2000);
		String count = pizzaPage.getPizzaAmount();

        pizzaPage.setCustomerName("Ivanoff");
        pizzaPage.setCustomerEmail("Abra@cadabra");
        pizzaPage.setCustomerPhone("123321");

        pizzaPage.setCardPayment();
        pizzaPage.placeOrder();

        ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.driver);
        String text = confirmationDialog.getConfirmationText();
        confirmationDialog.closeDialogBox();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text,  "Thank you for your order! TOTAL: "+count+" "+pizzaName);
        softAssert.assertAll();
	}
}
