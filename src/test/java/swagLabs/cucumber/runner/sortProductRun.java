package swagLabs.cucumber.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/swagLabs/cucumber/features",
        glue = "swagLabs.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"}
)
public class sortProductRun {
}
