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
    By actualTextCheckoutOverviewBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By itemTotalPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]");
    By itemTotalPriceProbaBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]");
    By taxPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");
    By taxPriceProbaBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");
    By totalPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]");
    By finishButtonBy = By.id("finish");
    By successOrderMessagebBy = By.className("complete-header");

    public CheckoutPage verifyCheckoutInformationIsDisplayed(String expectedText){
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

    public CheckoutPage verifyCheckoutOverviewIsDisplayed(String expectedText){
        String actualText = readText(actualTextCheckoutOverviewBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public CheckoutPage verifyTotalPrice(double expectedDouble){
        double p1 = Double.parseDouble(readText(itemTotalPriceBy).substring(13));
        double p2 = Double.parseDouble(readText(taxPriceBy).substring(6));
        double actualDouble  = Double.parseDouble(readText(totalPriceBy).substring(8));
        actualDouble = p1 + p2; 
        assertDoubleEquals(expectedDouble, actualDouble);
            return this;
    }

    public CheckoutPage verifyTotalPriceProba(double expectedDouble){
        double p5 = Double.parseDouble(readText(itemTotalPriceProbaBy).substring(13));
        double p6 = Double.parseDouble(readText(taxPriceProbaBy).substring(6));
        double actualDouble = p5 + p6;
        assertDoubleEquals(expectedDouble, actualDouble);
        return this;
    }

    public CheckoutPage clickOnFinishButton(){
        click(finishButtonBy);
        return this;
    }

    public CheckoutPage verifySuccessOrderMessage(String expectedText){
        String actualText = readText(successOrderMessagebBy);
        assertTextEquals(expectedText, actualText);
        return this;
        
    }

    
}
