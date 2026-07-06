package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class WishlistPage {

    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    By wishlistBtn =
            By.xpath("//button[contains(@id,'add-to-wishlist-button')]");

    public void addWishlist() {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(wishlistBtn));
    }
}