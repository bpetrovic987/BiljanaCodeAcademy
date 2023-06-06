package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.CartPage;
import pages.CheckoutPage;

public class ShoppingTests extends BaseTest {
    public LoginPage loginPage;
    public HomePage homePage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    String standardUserName = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int numberOfAllItems = 6;
    String expectedAboutLInk = "https://saucelabs.com/";
    String expectedTextYourCart = "Your Cart";
    String expectedTextCheckoutInformation = "Checkout: Your Information";
    String firstName = "Biljana";
    String lastName = "Krstic";
    String postalCode = "11300";
    String expectedTextCheckoutOverview = "Checkout: Overview";
    String expectedTextSauceLabsPack = "Sauce Labs Backpack";
    String expectedTextSauceLabsBikeLight = "Sauce Labs Bike Light";
    Double expectedPrice = 43.18;
    Double expectedPriceProba = 25.90;
    String expectedMessageSuccessOrder = "Thank you for your order!";
    String expectedTextSauceLabsOnesie = "Sauce Labs Onesie";
    String expectedTextTestAllTheThings = "Test.allTheThings() T-Shirt (Red)";

@Test
public void verifySuccessfulAddedToCart(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.verifyProductAddedToCart();

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
   e.printStackTrace();
}
}

@Test
public void numbersOfItemsHomePage(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.numberOfItems(numberOfAllItems);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

@Test
public void verifyAboutLink(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.clickOnMenuButton();
    homePage.verifyAboutLink(expectedAboutLInk);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
} 

    @Test
public void verifySort(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.verifySortLowToHigh();

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

    @Test
public void wholeTask(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage (driver);
    CheckoutPage checkoutPage = new CheckoutPage (driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.addProductsToCartProba();
    homePage.clickOnShoppingCartButton();
    cartPage.verifyCartIsOpened(expectedTextYourCart);
    cartPage.verifyProduct5AddedToCart(expectedTextSauceLabsOnesie);
    cartPage.verifyProduct6AddedToCart(expectedTextTestAllTheThings);
    cartPage.clickOnCheckoutButton();
    checkoutPage.verifyCheckoutInformationIsDisplayed(expectedTextCheckoutInformation);
    checkoutPage.enterInformations(firstName, lastName, postalCode);
    checkoutPage.clickOnContinueButton();
    checkoutPage.verifyCheckoutOverviewIsDisplayed(expectedTextCheckoutOverview);
    checkoutPage.verifyTotalPriceProba(expectedPriceProba);
    checkoutPage.clickOnFinishButton();
    checkoutPage.verifySuccessOrderMessage(expectedMessageSuccessOrder);

    
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

}