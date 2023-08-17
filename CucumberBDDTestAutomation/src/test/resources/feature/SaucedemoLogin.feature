Feature: Verify the Sauce demo login and Product adding to the cart

@SauceDemo
Scenario Outline: Validating the login screen with invalid credentials 

Given when user is on sauce demo screen 
When Enter <username> in Username field 
And Enter <password> in Password field 
Then Click on LoginBtn field 
Then Verify error "Epic sadface: Sorry, this user has been locked out." is present 
	
Examples: 
		|username         |password      |
		|'locked_out_user'|'secret_sauce'|
		
@SauceDemo
Scenario Outline:Verify Login, add Product to Cart and finish the order 
		
Given when user is on sauce demo screen 
When Enter <username> in Username field 
And Enter <password> in Password field 
Then Click on LoginBtn field 
Then check "Products" text is present in products page 
Then click <product1> the product in products page 
Then click AddToCartBtn 
Then click on BasketBtn 
Then check "Your Cart" text is present in Your Cart page 
Then verify the amount is "$15.99" in Your Cart screen for Sauce Labs Bolt T-Shirt 
Then click on continueShoppingBtn 
Then click <product2> the product in products page 
Then click AddToCartBtn 
Then click on BasketBtn 
Then click on CheckOutBtn 
Then Enter <FirstName> Firstname 
And Enter <LastName> Lastname 
And Enter <Pin> Pin 
Then click on ContinueBtn 
Then verify the total price is "$49.66" 
Then click on FinishBtn 
Then check "Thank you for your order!" text is present 
			
			
Examples: 
|username       |password      |product1                 |product2             |FirstName|LastName|Pin     |
|'standard_user'|'secret_sauce'|'Sauce Labs Bolt T-Shirt'|'Sauce Labs Backpack'|'Test'   |'User'  |'112233'|
		
