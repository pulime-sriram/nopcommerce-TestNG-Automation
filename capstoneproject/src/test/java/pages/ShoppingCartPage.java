package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By shoppingCart =
            By.linkText("Shopping cart");

    public void openCart() {

        driver.findElement(shoppingCart).click();
    }
}