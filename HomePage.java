package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver) {
    super (driver);
    }

    By homePageTitleBy = By.className("title");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bike-light");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By numberOfItemsBy = By.className("inventory_item");
    By menuButtonBy = By.id("react-burger-menu-btn");
    By aboutButtonBy = By.id("about_sidebar_link");
    By p1By = By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div");
    By p2By = By.xpath("//*[@id='inventory_container']/div/div[2]/div[2]/div[2]/div");
    By p3By = By.xpath("//*[@id='inventory_container']/div/div[2]/div[2]/div[2]/div");
    By p4By = By.xpath("//*[@id='inventory_container']/div/div[4]/div[2]/div[2]/div");
    By p5By = By.xpath("//*[@id='inventory_container']/div/div[5]/div[2]/div[2]/div");
    By p6By = By.xpath("//*[@id='inventory_container']/div/div[6]/div[2]/div[2]/div");
    By sortButtonBy = By.xpath("//*[@id='header_container']/div[2]/div/span/select");
    By lowToHighButtonBy = By.xpath("//*[@id='header_container']/div[2]/div/span/select/option[3]");
    By highToLowBy = By.xpath("//*[@id='header_container']/div[2]/div/span/select/option[4]");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By shoppingCartButtonBy = By.id("shopping_cart_container");

    public HomePage verifySuccessfulLogin (String expectedText) {
        String actualTitle = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualTitle);
        return this; 
    }

    public HomePage verifyProductsAddedToCart(){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisability(shoppingCartBadgeBy);
        return this;
    }


    public HomePage numberOfItems(int expectedNumberOfItems){
         int actualNumberOfItems = countItems(numberOfItemsBy);
         assertIntegerEquals(expectedNumberOfItems, actualNumberOfItems);
         return this;
    }

    public HomePage clickOnMenuButton(){
        click(menuButtonBy);
        return this;
    }

    public HomePage clickOnLogoutButton(){
        click(logoutButtonBy);
        return this;
    }

    public HomePage verifyAboutLink(String expectedLink){
        String actualLink = readLink(aboutButtonBy);
        assertTextEquals(expectedLink, actualLink);
        return this;
    }

    public HomePage verifySortLowToHigh(){
        double c1 = Double.parseDouble(readText(p1By).substring(1));
        double c2 = Double.parseDouble(readText(p2By).substring(1));
        double c3 = Double.parseDouble(readText(p3By).substring(1));
        double c4 = Double.parseDouble(readText(p4By).substring(1));
        double c5 = Double.parseDouble(readText(p5By).substring(1));
        double c6 = Double.parseDouble(readText(p6By).substring(1));
            double [] cene = {c1, c2, c3, c4, c5, c6};
            double max = 0;
            for (double x : cene){
                if (x>max){
                    max = x;
                }
            }
            double min = 100000;
            for (double x : cene){
                if (x<min){
                    min = x;
                }
            }
        click(sortButtonBy);
        click(lowToHighButtonBy);
        Assert.assertEquals(min, Double.parseDouble(readText(p1By).substring(1)), 0.0001);
        Assert.assertEquals(max, Double.parseDouble(readText(p6By).substring(1)), 0.0001);
        return this;
    }
    
    public HomePage addToCartItem(){
        click(addToCartButton1By);
      //  click(addToCartButton2By);
        return this;
    }

    public HomePage clickOnShoppingCartButton(){
        click(shoppingCartButtonBy);
        return this;
    }
        
        }

 