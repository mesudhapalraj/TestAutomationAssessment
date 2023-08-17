package com.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.factory.DriverFactory;

public class SauceDemoPage {
	
	private WebDriver driver;

	public SauceDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input#user-name")
	private WebElement usernameTxtBox;

	@FindBy(css = "input#password")
	private WebElement passwordTxtBox;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[@class='header_secondary_container']/span[text()='Products']")
	private WebElement productPageText;

	@FindBy(tagName = "h3")
	private WebElement errorMessageText;

	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	private WebElement AddToCartBtn;

	@FindBy(xpath = "//a[@id='item_4_title_link']/div[text()='Sauce Labs Backpack']")
	private WebElement product2;

	@FindBy(css = "a[id='item_1_title_link'] div")
	private WebElement product1;

	@FindBy(css = "a[class*='shopping_cart_link']")
	private WebElement BasketBtn;

	@FindBy(css = "button#continue-shopping")
	private WebElement continueShoppingBtn;

	@FindBy(css = "button#checkout")
	private WebElement CheckOutBtn;

	@FindBy(xpath = "//*/span[text()='Your Cart']")
	private WebElement yourCartText;

	@FindBy(className = "inventory_item_price")
	private WebElement priceAmount;

	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(css = "input#postal-code")
	private WebElement pinNumber;

	@FindBy(css = "input#continue")
	private WebElement continueBtn;

	@FindBy(css = "div.summary_info_label.summary_total_label")
	private WebElement totalPrice;

	@FindBy(css = "button#finish")
	private WebElement finishBtn;

	@FindBy(tagName = "h2")
	private WebElement thanksText;

	@FindBy(className = "shopping_cart_badge")
	private WebElement cartBadge;

	@FindBy(className = "summary_tax_label")
	private WebElement taxPrice;

	@FindBy(className = "summary_subtotal_label")
	private WebElement subTotal;

	@FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
	private WebElement totalsummary;

	public void enterUserName(String userName) throws IOException {
		usernameTxtBox.sendKeys(userName);
		
	}

	public void enterPassword(String password) throws IOException {
		passwordTxtBox.sendKeys(password);
		
	}

	public void clickLoginButton() {
		loginBtn.click();

	}
	
	public void verifyErrorMessage(String expectederrorMessage) throws IOException {
			String actualerrorText = errorMessageText.getText();
			Assert.assertTrue(actualerrorText.equals(expectederrorMessage));
		
	}

	public void verifyProductpage(String productsPageText) throws IOException {
			String actualProductpageText = productPageText.getText();
			Assert.assertTrue(productsPageText.equals(actualProductpageText));

	}

	public void clickProduct(String product) throws IOException {
			driver.findElement(By.xpath("//*/div[text()='" + product + "']")).click();
	}

	public void AddtoCart() throws IOException {
			AddToCartBtn.click();
	}

	public void AddtoBasket() {
		BasketBtn.click();
	}

	public void verifyCartTitle(String titleCart) throws IOException {
			String actualCarttitle = yourCartText.getText();
			Assert.assertTrue(actualCarttitle.equals(titleCart));
	}

	public void assertPriceAmount(String price) throws IOException {
			String actualPriceAmount = priceAmount.getText();
			Assert.assertTrue(price.trim().equals(actualPriceAmount));
	}

	public void continueShopping() throws IOException {
		continueShoppingBtn.click();
	}

	public void clickCheckout() throws IOException {
		CheckOutBtn.click();

	}

	public void enterfName(String uname) throws IOException {
		firstName.sendKeys(uname);
	}

	public void enterlName(String lname) throws IOException {
		lastName.sendKeys(lname);
	}

	public void enterPin(String pin) throws IOException {
		pinNumber.sendKeys(pin);
	}

	public void clickContinueBtn() {
		continueBtn.click();
	}

	public void assertTotalPrice(String Price) throws IOException {
			verifyAndAssertTotalPrice();
	}

	public void verifyAndAssertTotalPrice() throws IOException {
		int totalProduct = Integer.parseInt(cartBadge.getText());
		List<WebElement> products = new ArrayList();
		products = DriverFactory.getDriver().findElements(By.xpath("//*[@class=\"inventory_item_price\"]"));
		float sumOfPdt = (float) 0.00;
		float tax = (float) 0.00;
		float totalSum = (float) 0.00;
		for (int count = 0; count < totalProduct; count++) {
			float priceOfProduct = Float.valueOf(products.get(count).getText().substring(1).trim());
			sumOfPdt = sumOfPdt + priceOfProduct;
		}
		tax = Float.valueOf(taxPrice.getText().trim().split(":")[1].substring(2));
		totalSum = sumOfPdt + tax;
		System.out.println(totalsummary.getText().trim().split(":")[1].substring(2));
		float summary = Float.valueOf(totalsummary.getText().trim().split(":")[1].substring(2));
		Assert.assertEquals(summary,totalSum,0.000002);

		if (summary==totalSum) {
			System.out.println("Assertion is success");
		}
	}

	public void clickFinishBtn() {
		finishBtn.click();

	}

	public void verifyThanksText(String Text) throws IOException {
		String actualText = thanksText.getText();
		Assert.assertTrue(actualText.trim().equals(Text));
	}


}
