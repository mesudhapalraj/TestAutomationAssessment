package stepdefinition;

import java.io.IOException;

import com.pages.SauceDemoPage;
import com.qa.factory.DriverFactory;


import io.cucumber.java.en.*;


public class SauceDemoStepDefinition {
	SauceDemoPage demoPage = new SauceDemoPage(DriverFactory.getDriver());

	@Given("when user is on sauce demo screen")
	public void when_user_is_on_sauce_demo_screen() {
		DriverFactory.getDriver().get("https://www.saucedemo.com");
	}

	@When("Enter {string} in Username field")
	public void enter_in_username_field(String userName) throws IOException {
		demoPage.enterUserName(userName);
	}

	@When("Enter {string} in Password field")
	public void enter_in_password_field(String password) throws IOException {
		demoPage.enterPassword(password);
	}
	
	@Then("Click on LoginBtn field")
	public void click_on_LoginBtn_field() {
		demoPage.clickLoginButton();
	}

	@Then("Verify error {string} is present")
	public void verify_error_is_present(String expectederrorMesssage) throws IOException {
		demoPage.verifyErrorMessage(expectederrorMesssage);

	}
	
	@Then("check {string} text is present in products page")
	public void check_text_is_present_in_products_page(String productsPageText) throws IOException {
		demoPage.verifyProductpage(productsPageText);
	}

	@Then("click {string} the product in products page")
	public void click_the_product_in_products_page(String product) throws IOException {
		demoPage.clickProduct(product);

	}

	@Then("click AddToCartBtn")
	public void click_AddToCartBtn() throws IOException {
		demoPage.AddtoCart();
	}

	@Then("click on BasketBtn")
	public void click_on_BasketBtn() {
		demoPage.AddtoBasket();
	}

	@Then("check {string} text is present in Your Cart page")
	public void check_text_is_present_in_Your_Cart_page(String titleCart) throws IOException {
		demoPage.verifyCartTitle(titleCart);

	}

	@Then("verify the amount is {string} in Your Cart screen for Sauce Labs Bolt T-Shirt")
	public void verify_the_amount_is_in_Your_Cart_screen_for_Sauce_Labs_Bolt_T_Shirt(String price) throws IOException {
		demoPage.assertPriceAmount(price);
	}

	@Then("click on continueShoppingBtn")
	public void click_on_continueShoppingBtn() throws IOException {
		demoPage.continueShopping();

	}

	@Then("click on CheckOutBtn")
	public void click_on_CheckOutBtn() throws IOException {
		demoPage.clickCheckout();

	}

	@Then("click on ContinueBtn")
	public void click_on_ContinueBtn() {
		demoPage.clickContinueBtn();

	}

	@Then("verify the total price is {string}")
	public void verify_the_total_price_is(String totalPrice) throws IOException {
		demoPage.assertTotalPrice(totalPrice);

	}

	@Then("click on FinishBtn")
	public void click_on_FinishBtn() {
		demoPage.clickFinishBtn();
	}

	@Then("check {string} text is present")
	public void check_text_is_present(String thanksText) throws IOException {
		demoPage.verifyThanksText(thanksText);
	}

	@Then("Enter {string} Firstname")
	public void enter_Firstname(String string) throws IOException {
		demoPage.enterfName(string);

	}

	@Then("Enter {string} Lastname")
	public void enter_Lastname(String string) throws IOException {
		demoPage.enterlName(string);
	}

	@Then("Enter {string} Pin")
	public void enter_Pin(String string) throws IOException {
		demoPage.enterPin(string);
	}


}
