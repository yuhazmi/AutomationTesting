package swagLabs.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class buyProductStep {
    WebDriver driver;
    String baseUrl="https://www.saucedemo.com/";
    @Given("User already login")
    public void user_already_login() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //login successfull
        String homeAssert= driver.findElement(By.className("app_logo")).getText();
        String appName="Swag Labs";
        Assert.assertEquals(appName,homeAssert);
    }

    @When("User click add to cart button")
    public void user_click_add_to_cart_button() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    @And("User click cart icon")
    public void user_click_cart_icon() {
        driver.findElement(By.className("shopping_cart_link")).click();

    }

    @And("User check the shopping list and click Checkout button")
    public void user_check_the_shopping_list_and_click_checkout_button() {
        String pageAssert= driver.findElement(By.className("title")).getText();
        String pageTitle="Your Cart";
        Assert.assertEquals(pageTitle,pageAssert);
        driver.findElement(By.id("checkout")).click();
    }

    @And("User fill the biodata and click Continue button")
    public void user_fill_the_biodata_and_click_continue_button() {
        driver.findElement(By.id("first-name")).sendKeys("Yuhazmi");
        driver.findElement(By.id("last-name")).sendKeys("Dartius");
        driver.findElement(By.id("postal-code")).sendKeys("22222");
        driver.findElement(By.id("continue")).click();
    }

    @And("User click the Finish button")
    public void user_click_the_finish_button() {
        String pageAssert= driver.findElement(By.className("title")).getText();
        String pageTitle="Checkout: Overview";
        Assert.assertEquals(pageTitle,pageAssert);
        driver.findElement(By.id("finish")).click();
    }

    @Then("User directed to Checkout complete page")
    public void user_directed_to_checkout_complete_page() {
        String pageAssert= driver.findElement(By.className("title")).getText();
        String pageTitle="Checkout: Complete!";
        Assert.assertEquals(pageTitle,pageAssert);
    }
}
