package tests;
import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUserName = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String suspendedUser = "locked_out_user";
    String suspendedUserError = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUserName = "";
    String emptyUserNameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUserName = "test";
    String invalidPassword = "sauce";
    String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    

    
@Test 
public void verifySuccessfulLogin() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
   e.printStackTrace();
}
}

@Test 
public void verifySuspendedUser () {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(suspendedUser, password);
    loginPage.verifyUnsuccessfulLogin(suspendedUserError);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyUserNameLogin () {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUserName, password);
    loginPage.verifyUnsuccessfulLogin(emptyUserNameError);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulEmptyPasswordLogin () {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, emptyPassword);
    loginPage.verifyUnsuccessfulLogin(emptyPasswordError);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

@Test
public void verifyUnseccessfulInvalidUsernameLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUserName, password);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

@Test
public void verifyUnsuccessfulInvalidPasswordLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, invalidPassword);
    loginPage.verifyUnsuccessfulLogin(invalidCredentialsError);

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }
}

@Test
public void verifySuccessfulLogout(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUserName, password);
    homePage.verifySuccessfulLogin(homePageTitle);
    homePage.clickOnMenuButton();
    homePage.clickOnLogoutButton();
    loginPage.verifySuccessfullLogout();
   
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }

}
}