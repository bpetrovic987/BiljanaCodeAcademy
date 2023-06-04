package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    String baseURL = "https://www.saucedemo.com/";
    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginbuttonBy = By.id("login-button");
    By ErrorContainerBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");
    ////*[@id="login_button_container"]/div/form/div[3]/h3 sa duplim navodnicima je izbacio grešku

    public LoginPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public LoginPage login (String username, String password) {
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginbuttonBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin(String expectedText){
        String actualText = readText(ErrorContainerBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public void verifySuccessfullLogout(){
        waitVisability(usernameBy);
        waitVisability(passwordBy);
        waitVisability(loginbuttonBy);
    }


}
