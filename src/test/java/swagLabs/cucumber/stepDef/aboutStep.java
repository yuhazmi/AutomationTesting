package swagLabs.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class aboutStep {
    WebDriver driver;
    String baseUrl="https://www.saucedemo.com/";
    @Given("User loged in")
    public void userLogedIn() {
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

    @When("User click about menu")
    public void userClickAboutMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("about_sidebar_link")).click();
    }

    @Then("Incorrect about page displayed")
    public void incorrectAboutPageDisplayed() {
        String pageTitleAssert= driver.getTitle();
        String textpageTitle="Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
        Assert.assertEquals(textpageTitle,pageTitleAssert);
    }
}
