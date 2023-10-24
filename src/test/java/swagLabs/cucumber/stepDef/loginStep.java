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

public class loginStep {
    WebDriver driver;
    String baseUrl="https://www.saucedemo.com/";
    @Given("Login page")
    public void login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        String loginAssert= driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginAssert,"Swag Labs");
    }
    @When("user enter valid credentials")
    public void user_enter_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("click on login")
    public void click_on_login() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Home page should be displayed")
    public void home_page_should_be_displayed() {
        String homeAssert= driver.findElement(By.className("app_logo")).getText();
        String appName="Swag Labs";
        Assert.assertEquals(appName,homeAssert);
    }

    @When("user enter invalid credentials")
    public void user_enter_invalid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauces");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String errorAssert= driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]")).getText();
        String errorText="Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorText,errorAssert);
    }
}
