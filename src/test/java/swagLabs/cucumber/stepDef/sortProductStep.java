package swagLabs.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class sortProductStep {
    WebDriver driver;
    String baseUrl="https://www.saucedemo.com/";
    @Given("User already loginn")
    public void user_already_loginn() {
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
    @When("User sort product by name z to a")
    public void user_sort_product_by_name_z_to_a() {
        Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
        dropdown.selectByValue("za");
    }

    @Then("product sorted from z to a")
    public void product_sorted_from_z_to_a() {
        String productAssert= driver.findElement(By.className("inventory_item_name")).getText();
        String productName="Test.allTheThings() T-Shirt (Red)";
        Assert.assertEquals(productName,productAssert);
    }
}
