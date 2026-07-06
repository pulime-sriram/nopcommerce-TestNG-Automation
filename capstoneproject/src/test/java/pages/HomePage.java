package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    By registerLink=By.linkText("Register");
    By loginLink=By.linkText("Log in");
    By searchBox=By.id("small-searchterms");
    By searchButton=By.xpath("//button[@type='submit']");

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}