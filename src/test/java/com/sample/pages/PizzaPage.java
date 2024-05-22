package com.sample.pages;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;

public class PizzaPage {

	private static final Logger logger = LogManager.getLogger(PizzaPage.class);

	private WebDriver driver;

	public PizzaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
/* 
 * This will get the all locators and stored in the variable.
 */
	@FindBy(id = "pizza1Pizza")
	WebElement pizzaname;

	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings1']")
	WebElement topping1;

	@FindBy(xpath = "//div[@id='pizza1']//select[@class='toppings2']")
	WebElement topping2;

	@FindBy(id = "pizza1Qty")
	WebElement quantity;

	@FindBy(id = "pizza1Cost")
	WebElement totalcost;

	@FindBy(id = "name")
	WebElement customername;

	@FindBy(id = "email")
	WebElement customeremail;

	@FindBy(id = "phone")
	WebElement customerphone;

	@FindBy(id = "ccpayment")
	WebElement ccpayment;

	@FindBy(id = "cashpayment")
	WebElement cashpayment;

	@FindBy(id = "placeOrder")
	WebElement placeorderbtn;

	@FindBy(id = "reset")
	WebElement reset;

	/*
	 * This method will get the pizza type in the String format and if it's found
	 * then select the Pizza from the dropdown menu.
	 * 
	 */
	public void setPizzaType(String pizzaName) {

		Select pizzaSelect = new Select(pizzaname);
		List<WebElement> listOfPizzaType = pizzaSelect.getOptions();

		for (WebElement webelement : listOfPizzaType) {
			if (webelement.getText().contains(pizzaName)) {
				pizzaSelect.selectByVisibleText(webelement.getText());
				logger.info("Selected Pizza Name is : " + pizzaname);
			} else {
				logger.info("The Pizza name not found: ");
			}
		}
	}

	/*
	 * This method will get the pizza Type from the Enum and matches with the
	 * dropdown value, if it's found match then select the Pizza from the dropdown
	 * menu.
	 * 
	 */
	public void setPizzaTypeFromEnum(PizzaTypes pizzaType) {

		Select pizzaSelect = new Select(pizzaname);
		List<WebElement> listOfPizzaType = pizzaSelect.getOptions();

		for (WebElement option : listOfPizzaType) {
			for (PizzaTypes pizzaOption : PizzaTypes.values()) {
				if (option.getText().contains(pizzaOption.getDisplayName()) && pizzaOption.equals(pizzaType)) {
					pizzaSelect.selectByVisibleText(option.getText());
					logger.info("Selected Pizza Name is: " + pizzaOption.getDisplayName());
					return;
				}
			}
		}
		logger.info("Pizza name not found: " + pizzaType.getDisplayName());
	}

	/*
	 * This method will get the pizza "Toppings1" type in the String format and if it's found
	 * then select the Pizza "Toppings1" from the dropdown menu.
	 */
	public void setToppings1Type(String toppingtype1) {

		Select pizzatopping1 = new Select(topping1);
		List<WebElement> listofpizzatopping1 = pizzatopping1.getOptions();

		for (WebElement webElement : listofpizzatopping1) {

			if (webElement.getText().contains(toppingtype1)) {
				pizzatopping1.selectByVisibleText(webElement.getText());
				logger.info("Pizza Topping1 is:" + webElement.getText());
			} else {
				logger.info("Pizza Topping1 is not found");
			}
		}
		logger.info("Pizza Topping1 is : " + topping1);
	}
	 /* This method will get the Pizza "Toppings1" from the Enum and matches with the
	 * dropdown value, if it's found match then select the Pizza "Toppings1" from the dropdown menu.
	 */
	public void setPizzaToppingType1FromEnum(PizzaToppings PizzaTopping) {
		Select pizzatopping1Select = new Select(topping1);
		List<WebElement> listOfPizzatoppingType = pizzatopping1Select.getOptions();

		for (WebElement option : listOfPizzatoppingType) {
			for (PizzaToppings pizzatoppingOption : PizzaToppings.values()) {
				if (option.getText().contains(pizzatoppingOption.getDisplayName())
						&& pizzatoppingOption.equals(PizzaTopping)) {
					pizzatopping1Select.selectByVisibleText(option.getText());
					logger.info("Select Pizza topping Type 1: " + pizzatoppingOption.getDisplayName());
					return;
				}
			}
		}
		logger.info("The Pizza topping Type 1 not found.");
	}
	/*
	 * This method will get the pizza "Toppings2" type in the String format and if it's found
	 * then select the Pizza "Toppings2" from the dropdown menu.
	 */
	public void setToppings2Type(String toppingtype2) {

		Select pizzatopping2 = new Select(topping2);
		List<WebElement> listofpizzatopping2 = pizzatopping2.getOptions();

		for (WebElement webElement : listofpizzatopping2) {
			if (webElement.getText().contains(toppingtype2)) {
				pizzatopping2.selectByVisibleText(toppingtype2);
				logger.info("Pizza Topping2 is:" + webElement.getText());
			} else {
				logger.info("Pizza Topping2 is not found.");
			}
		}
	}
	 /* This method will get the Pizza "Toppings2" from the Enum and matches with the
	 * dropdown value, if it's found match then select the Pizza "Toppings2" from the dropdown menu.
	 */
	public void setPizzaToppingType2FromEnum(PizzaToppings PizzaTopping) {
		Select pizzatopping2Select = new Select(topping2);
		List<WebElement> listOfPizzatoppingType = pizzatopping2Select.getOptions();

		for (WebElement option : listOfPizzatoppingType) {
			for (PizzaToppings pizzatoppingOption : PizzaToppings.values()) {
				if (option.getText().contains(pizzatoppingOption.getDisplayName())
						&& pizzatoppingOption.equals(PizzaTopping)) {
					pizzatopping2Select.selectByVisibleText(option.getText());
					logger.info("Select Pizza topping Type 2: " + pizzatoppingOption.getDisplayName());
					return;
				}
			}
		}
		logger.info("The Pizza topping Type 2 not found.");
	}
	/*
	 * This method will enter the Pizza "Quantity" in a string format.
	 */
	public void setPizzaQuantitystr(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
		logger.info("Pizza Quantity is : " + qty);
	}
	/*
	 * This method will enter the Pizza "Quantity" and it's convert the value from Integer to String value.
	 */
	public void setPizzaQuantityint(int qty) {
		quantity.clear();
		String quantitystr = Integer.toString(qty);
		quantity.sendKeys(quantitystr);
		logger.info("Pizza Quantity is : " + qty);
	}
	/*
	 * This method will get the Total "Cost" value based on the selection of pizza type and quantity with the help of javascript Executor.
	 */
	public String getPizzaAmount() {
		totalcost.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String gettotalcost = (String) (js.executeScript("return document.getElementById('pizza1Cost').value;"));

		logger.info("Pizza cost get from Js is:" + gettotalcost);
		return gettotalcost;

	}
	/*
	 * This method will enter the Customer "Name" in the String format.
	 */	

	public void setCustomerName(String customer_name) {
		customername.clear();
		customername.click();
		customername.sendKeys(customer_name);
		logger.info("Customer Name: " + customer_name);
	}
	/*
	 * This method will enter the Customer "Email" in the String format.
	 */
	public void setCustomerEmail(String customer_email) {
		customeremail.clear();
		customeremail.click();
		customeremail.sendKeys(customer_email);
		logger.info("Customer Email is : " + customer_email);
	}
	/*
	 * This method will enter the Customer "Phone" in the String format.
	 */
	public void setCustomerPhone(String customer_phone) {
		customerphone.clear();
		customerphone.click();
		customerphone.sendKeys(customer_phone);
		logger.info("Customer Pnhone is : " + customer_phone);
	}
	/*
	 * This method will click on the "Credit Card" radio button.
	 */
	public void setCardPayment() {
		ccpayment.click();
		logger.info("select Credit Card Payment radio button.");
	}
	/*
	 * This method will click on the "Cash on Pickup" radio button.
	 */
	public void setCashPayment() {
		cashpayment.click();
		logger.info("select Cash Payment radio button.");
	}
	/*
	 * This method will click on the "Place Order" button.
	 */
	public void placeOrder() throws InterruptedException {
		placeorderbtn.click();
		Thread.sleep(3000);
		logger.info("Click on Place Order button button.");
	}
	/*
	 * This method will click on the "Reset" button.
	 */
	public void resetbtn() {
		reset.click();
		logger.info("Click on reset button.");
	}
	/*
	 * This method will get the Selected "Pizza Name" value.
	 */
	public String getPizzaTypeName() {
		String getPizza = new Select(pizzaname).getFirstSelectedOption().getText();
		return getPizza;
	}
	/*
	 * This method will get the Selected Pizza "Toppings1" value.
	 */
	public String getToppingstype1() {
		String getpizzatopping1 = new Select(topping1).getFirstSelectedOption().getText();
		return getpizzatopping1;
	}
	/*
	 * This method will get the Selected Pizza "Toppings2" value.
	 */
	public String getToppingstype2() {
		String getpizzatopping2 = new Select(topping2).getFirstSelectedOption().getText();
		return getpizzatopping2;
	}
	/*
	 * This method will get the entered "quantity" value.
	 */
	public String getQuantity() {
		String text = quantity.getText();
		return text;
	}
	/*
	 * This method will get the entered Customer "Name" value.
	 */
	public String getcustName() {
		String text = customername.getText();
		return text;
	}
	/*
	 * This method will get the entered Customer "Email" value.
	 */
	public String getEmail() {
		String text = customeremail.getText();
		return text;
	}
	/*
	 * This method will get the entered Customer "Phone" number value.
	 */
	public String getPhone() {
		String text = customerphone.getText();
		return text;
	}
	/*
	 * This method will get the "Credit Card" options is selected or not.
	 */
	public boolean getCCPayment() {
		boolean flag = ccpayment.isSelected();
		return flag;
	}
	/*
	 * This method will get the "Cash on Pickup" options is selected or not.
	 */
	public boolean getCashPayment() {
		boolean flag = cashpayment.isSelected();
		return flag;
	}

}
