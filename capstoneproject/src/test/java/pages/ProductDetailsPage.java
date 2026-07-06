package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCart =
            By.xpath("//button[contains(@id,'add-to-cart-button')]");

    public void addProductToCart() {

        driver.findElement(addToCart).click();
    }
}