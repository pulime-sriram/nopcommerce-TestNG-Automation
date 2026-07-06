package pages;

import org.openqa.selenium.*;

public class MyAccountPage {

    WebDriver driver;

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }

    By myAccount=By.linkText("My account");

    public void openMyAccount(){

        driver.findElement(myAccount).click();
    }
}