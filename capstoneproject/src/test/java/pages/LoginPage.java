package pages;


import org.openqa.selenium.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    By email=By.name("Email");
    By password=By.name("Password");
    By loginBtn=By.xpath("//button[text()='Log in']");

    public void login(String user,String pass){

        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}