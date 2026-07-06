package tests;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        // Helps reduce automation detection
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

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
    public void registerTest() throws InterruptedException {

        hp.clickRegister();

        email = "dheeraj"
                + UUID.randomUUID().toString().substring(0, 5)
                + "@gmail.com";

        rp.registerUser(
                "Dheeraj",
                "sriram",
                email,
                password);

        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {

        driver.get("https://demo.nopcommerce.com/login");

        lp.login(email, password);

        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void searchProductTest()
            throws InterruptedException {

        sp.searchProduct("Apple MacBook Pro");

        Thread.sleep(3000);

        sp.openFirstProduct();
    }
   

    @Test(priority = 4)
    public void addToCartTest() throws InterruptedException {

        pd.addProductToCart();

        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void wishlistTest() {

        wp.addWishlist();
    }

    @Test(priority = 6)
    public void shoppingCartTest()
            throws Exception {

        sc.openCart();

        Thread.sleep(3000);

        cp.checkout();
    }
    @Test(priority = 7,
    		dependsOnMethods = "shoppingCartTest")
    		public void verifyOrderPlacedTest() {

    		    String text = driver.getPageSource();

    		    if(text.contains(
    		            "Your order has been successfully processed!")) {

    		        System.out.println(
    		                "ORDER PLACED SUCCESSFULLY");
    		    }
    		    else {

    		        throw new RuntimeException(
    		                "ORDER NOT PLACED");
    		    }
    		}
    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}