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

public class logoutStep {
    WebDriver driver;
    String baseUrl="https://www.saucedemo.com/";
    @Given("User already loged in")
    public void userAlreadyLogedIn() {
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

    @When("User click home menu")
    public void userClickHomeMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }

    @And("Click on logout menu")
    public void clickOnLogoutMenu() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("User logged out and login page displayed")
    public void userLoggedOutAndLoginPageDisplayed() {
        String loginAssert= driver.findElement(By.xpath("//div[contains(text(),'Swag Labs')]")).getText();
        Assert.assertEquals(loginAssert,"Swag Labs");
    }
}
