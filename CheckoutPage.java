package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    By actualTextCheckoutInformationBy = By.className("title");
    By continueButtonBy = By.id("continue");
    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By postalCodeBy = By.id("postal-code");

    public CheckoutPage verifyCheckoutInformationPageIsOpened(String expectedText){
        String actualText = readText(actualTextCheckoutInformationBy);
        assertTextEquals(expectedText, actualText);
        return this; 
    }

    public CheckoutPage enterInformations(String firstName, String lastName, String postalCode){
        writeText(firstNameBy, firstName);
        writeText(lastNameBy, lastName);
        writeText(postalCodeBy, postalCode);
        return this;
    }

    public CheckoutPage clickOnContinueButton(){
        click(continueButtonBy);
        return this;
    }
    
}
