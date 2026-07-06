package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Shopping Cart

    By termsOfService = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");

    // Billing

    By state = By.id("BillingNewAddress_StateProvinceId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    By phone = By.id("BillingNewAddress_PhoneNumber");

    By billingContinue =
            By.xpath("//button[contains(@class,'new-address-next-step-button')]");

    // Shipping Method

    By shippingContinue =
            By.xpath("//button[contains(@class,'shipping-method-next-step-button')]");

    // Payment Method

    By paymentMethodContinue =
            By.xpath("//button[contains(@class,'payment-method-next-step-button')]");

    // Payment Information

    By paymentInfoContinue =
            By.xpath("//button[contains(@class,'payment-info-next-step-button')]");

    // Confirm Order

    By confirmOrder =
            By.xpath("//button[contains(@class,'confirm-order-next-step-button')]");

    public void checkout() throws Exception {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        // Cart

        driver.findElement(termsOfService).click();

        Thread.sleep(2000);

        driver.findElement(checkoutBtn).click();

        Thread.sleep(5000);

        // State

        Select stateDropDown =
                new Select(driver.findElement(state));

        if (stateDropDown.getOptions().size() > 1) {

            stateDropDown.selectByIndex(1);
        }

        Thread.sleep(2000);

        // Address

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys("Bangalore");

        driver.findElement(address1).clear();
        driver.findElement(address1)
                .sendKeys("Electronic City Phase 1");

        driver.findElement(zipCode).clear();
        driver.findElement(zipCode)
                .sendKeys("560100");

        driver.findElement(phone).clear();
        driver.findElement(phone)
                .sendKeys("9876543210");

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                driver.findElement(billingContinue));

        Thread.sleep(2000);

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(billingContinue));

        System.out.println("Billing Completed");

        Thread.sleep(5000);

        // Shipping Method

        driver.findElement(shippingContinue).click();

        System.out.println("Shipping Completed");

        Thread.sleep(5000);

        // Payment Method

        driver.findElement(paymentMethodContinue).click();

        System.out.println("Payment Method Completed");

        Thread.sleep(5000);

        // Payment Information

        driver.findElement(paymentInfoContinue).click();

        System.out.println("Payment Information Completed");

        Thread.sleep(5000);

        // Confirm Order

        driver.findElement(confirmOrder).click();

        System.out.println("Order Confirmed");

        Thread.sleep(8000);
    }
}