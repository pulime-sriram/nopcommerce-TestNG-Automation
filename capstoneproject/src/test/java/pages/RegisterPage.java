package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By registerLink = By.linkText("Register");
    By genderMale = By.id("gender-male");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    // Elements
    public WebElement registerLink() {
        return driver.findElement(registerLink);
    }

    public WebElement genderMale() {
        return driver.findElement(genderMale);
    }

    public WebElement firstName() {
        return driver.findElement(firstName);
    }

    public WebElement lastName() {
        return driver.findElement(lastName);
    }

    public WebElement email() {
        return driver.findElement(email);
    }

    public WebElement password() {
        return driver.findElement(password);
    }

    public WebElement confirmPassword() {
        return driver.findElement(confirmPassword);
    }

    public WebElement registerButton() {
        return driver.findElement(registerButton);
    }

    // Reusable Method
    public void registerUser(String fName,
                             String lName,
                             String mail,
                             String pwd) {

        genderMale().click();

        firstName().sendKeys(fName);

        lastName().sendKeys(lName);

        email().sendKeys(mail);

        password().sendKeys(pwd);

        confirmPassword().sendKeys(pwd);

        registerButton().click();
    }
}