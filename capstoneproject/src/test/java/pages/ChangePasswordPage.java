package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {

    WebDriver driver;

    public ChangePasswordPage(WebDriver driver) {

        this.driver = driver;
    }

    By oldPwd = By.id("OldPassword");

    By newPwd = By.id("NewPassword");

    By confirmPwd = By.id("ConfirmNewPassword");

    By saveBtn =
            By.xpath("//button[text()='Change password']");

    public void changePassword(
            String oldpass,
            String newpass) {

        driver.findElement(oldPwd).sendKeys(oldpass);

        driver.findElement(newPwd).sendKeys(newpass);

        driver.findElement(confirmPwd).sendKeys(newpass);

        driver.findElement(saveBtn).click();
    }
}