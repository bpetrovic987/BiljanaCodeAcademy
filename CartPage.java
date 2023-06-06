package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    public CartPage (WebDriver driver) {
    super(driver);
    }

    By actualTextYourCartBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By checkoutButtonBy = By.id("checkout");
    By SauceLabsPackBy = By.id("item_4_title_link");
    By sauceLabsBikeLightBy = By.id("item_0_title_link");
    By sauceLabsOnesieBy = By.xpath("//*[@id='item_2_title_link']");
    By testAllTheThingsBy = By.xpath("//*[@id='item_3_title_link']");


    public CartPage verifyCartIsOpened(String expectedText){
        String actualText = readText(actualTextYourCartBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage verifyProduct1AddedToCart(String expectedText){
        String actualText = readText(SauceLabsPackBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage verifyProduct2AddedToCart(String expectedText){
        String actualText = readText(sauceLabsBikeLightBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage verifyProduct5AddedToCart(String expectedText){
        String actualText = readText(sauceLabsOnesieBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage verifyProduct6AddedtoCart(String expectedText){
        String actualText = readText(testAllTheThingsBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this;
    }

}
