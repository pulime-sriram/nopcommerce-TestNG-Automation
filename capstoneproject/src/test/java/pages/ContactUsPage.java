package pages;

import org.openqa.selenium.*;

public class ContactUsPage {

    WebDriver driver;

    public ContactUsPage(WebDriver driver){
        this.driver=driver;
    }

    By enquiry=By.id("Enquiry");
    By submitBtn=By.name("send-email");

    public void submitEnquiry(String msg){

        driver.findElement(enquiry).sendKeys(msg);
        driver.findElement(submitBtn).click();
    }
}