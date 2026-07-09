package tests;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductSearchPage;
import pages.RegisterPage;
import pages.ShoppingCartPage;
import pages.WishlistPage;
import utilities.ExtentListener;

public class NopCommerceTest {

    WebDriver driver;

    HomePage hp;
    RegisterPage rp;
    LoginPage lp;
    ProductSearchPage sp;
    ProductDetailsPage pd;
    ShoppingCartPage sc;
    WishlistPage wp;
    CheckoutPage cp;

    String email;
    String password = "Dheeraj123";

    @BeforeClass
    public void setup() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.nopcommerce.com");
        Thread.sleep(8000);

        hp = new HomePage(driver);
        rp = new RegisterPage(driver);
        lp = new LoginPage(driver);
        sp = new ProductSearchPage(driver);
        pd = new ProductDetailsPage(driver);
        sc = new ShoppingCartPage(driver);
        wp = new WishlistPage(driver);
        cp = new CheckoutPage(driver);
    }

    @Test(priority = 1)
    public void verifyHomePageLoadedTest() {
        ExtentListener.test.info("Verifying Home Page");

        if(driver.getTitle().contains("nopCommerce")) {
            ExtentListener.test.pass("Home Page Loaded");
        } else {
            throw new RuntimeException("Home Page Not Loaded");
        }
    }

    @Test(priority = 2)
    public void openRegisterPageTest() {
        ExtentListener.test.info("Opening Register Page");
        hp.clickRegister();
        ExtentListener.test.pass("Register Page Opened");
    }

    @Test(priority = 3)
    public void invalidRegistrationTest() throws Exception {
        ExtentListener.test.info("Validating Registration Mandatory Fields");
        driver.get("https://demo.nopcommerce.com/register");
        
        rp.registerUser("", "", "", "");
        Thread.sleep(2000);

        String pageText = driver.getPageSource();

        if (pageText.contains("First name is required")
                && pageText.contains("Last name is required")
                && pageText.contains("Email is required")
                && pageText.contains("Password is required")) {

            ExtentListener.test.pass("Mandatory Field Validation Verified");
        } else {
            throw new RuntimeException("Mandatory Field Validation Failed");
        }
    }

    @Test(priority = 4)
    public void registerTest() throws Exception {
        ExtentListener.test.info("Executing Valid Registration");
        email = "dheeraj" + UUID.randomUUID().toString().substring(0,5) + "@gmail.com";

        rp.registerUser("Dheeraj", "Sriram", email, password);
        Thread.sleep(3000);

        ExtentListener.test.pass("Registration Completed");
    }

    @Test(priority = 5)
    public void invalidLoginTest() {
        ExtentListener.test.info("Executing Invalid Login Test");
        driver.get("https://demo.nopcommerce.com/login");

        lp.login("wronguser@gmail.com", "wrongpass");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By errorBannerLocator = By.cssSelector(".message-error.validation-summary-errors");

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorBannerLocator));
        String actualErrorText = driver.findElement(errorBannerLocator).getText();

        Assert.assertTrue(actualErrorText.contains("Login was unsuccessful"));
        Assert.assertTrue(actualErrorText.contains("No customer account found"));

        ExtentListener.test.pass("Invalid Login Validation Verified");
    }

    @Test(priority = 6)
    public void loginTest() throws Exception {
        ExtentListener.test.info("Executing Valid Login");
        driver.get("https://demo.nopcommerce.com/login"); // Navigates cleanly to login screen

        lp.login(email, password);
        Thread.sleep(3000);

        ExtentListener.test.pass("Login Completed");
    }

    @Test(priority = 7)
    public void verifyLoginSuccessTest() {
        String pageText = driver.getPageSource();

        if(pageText.contains("Log out")) {
            ExtentListener.test.pass("Login Verified");
        } else {
            throw new RuntimeException("Login Verification Failed");
        }
    }
    @Test(priority = 8)
    public void invalidSearchProductTest() throws Exception {
        ExtentListener.test.info("Executing Invalid Product Search");
        sp.searchProduct("XYZ123NonExistent");
        Thread.sleep(2000);

        String pageText = driver.getPageSource();
        if(pageText.contains("No products were found that matched your criteria.")) {
            ExtentListener.test.pass("Invalid Search Message Verified Successfully");
        } else {
            throw new RuntimeException("Invalid Search Validation Failed");
        }
    }

    @Test(priority = 9)
    public void searchProductTest() throws Exception {
        sp.searchProduct("Apple MacBook Pro");
        Thread.sleep(3000);

        ExtentListener.test.pass("Product Search Completed");
    }

    
    @Test(priority = 10)
    public void openProductDetailsTest() {
        sp.openFirstProduct();
        ExtentListener.test.pass("Product Details Opened");
    }

    @Test(priority = 11)
    public void addToCartTest() throws Exception {
        pd.addProductToCart();
        Thread.sleep(3000);

        ExtentListener.test.pass("Product Added To Cart");
    }

    @Test(priority = 12)
    public void wishlistTest() {
        wp.addWishlist();
        ExtentListener.test.pass("Product Added To Wishlist");
    }

    @Test(priority = 13)
    public void openShoppingCartTest() throws Exception {
        sc.openCart();
        Thread.sleep(3000);

        ExtentListener.test.pass("Shopping Cart Opened");
    }

    @Test(priority = 14)
    public void checkoutTest() throws Exception {
        cp.checkout();
        ExtentListener.test.pass("Checkout Completed");
    }

    @Test(priority = 15, dependsOnMethods = "checkoutTest")
    public void verifyOrderPlacedTest() {
        String text = driver.getPageSource();

        if(text.contains("Your order has been successfully processed!")) {
            ExtentListener.test.pass("Order Placed Successfully");
            System.out.println("ORDER PLACED SUCCESSFULLY");
        } else {
            ExtentListener.test.fail("Order Placement Failed");
            throw new RuntimeException("ORDER NOT PLACED");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}