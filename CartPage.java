package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    public CartPage (WebDriver driver) {
    super(driver);
    }

    By actualTextYourCartBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By checkoutButtonBy = By.id("checkout");
    

    public CartPage verifyCartIsOpened(String expectedText){
        String actualText = readText(actualTextYourCartBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CartPage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this;
}
}
