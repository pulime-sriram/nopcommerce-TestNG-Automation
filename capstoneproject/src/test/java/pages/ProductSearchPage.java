package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSearchPage {

    WebDriver driver;

    public ProductSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox =
            By.id("small-searchterms");

    By searchBtn =
            By.xpath("//button[contains(@class,'search-box-button')]");

    By firstProduct =
            By.xpath("(//h2[@class='product-title']/a)[1]");

    public void searchProduct(String product) {

        driver.findElement(searchBox).clear();

        driver.findElement(searchBox).sendKeys(product);

        driver.findElement(searchBtn).click();
    }

    public void openFirstProduct() {

        driver.findElement(firstProduct).click();
    }
}