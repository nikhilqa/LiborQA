package base;

import Logger.LogSetting;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.apache.log4j.Logger;
import org.apache.maven.surefire.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import useractivities.CommonActions;
import utilities.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

@Listeners(SimpleTestListener.class)
public class BaseCall extends AbstractTestNGCucumberTests {

    private Logger log = LogSetting.getLogger(BaseCall.class);
    public WebDriver driver = null;
    private TestNGCucumberRunner testNGCucumberRunner;

    public BaseCall() {
        driver = DriverInstance.getMyDriver();
    }

    @BeforeTest
    public void alwaysRun() {
        new CommonActions(driver).setImplicitWait(Long.parseLong(ConfigReader.readProjectConfig("Implicit_wait_Duration")), TimeUnit.SECONDS);
        new CommonActions(driver).get(ConfigReader.readProjectConfig("FlowableQaURL"));
        log.info("Browser started");
    }

    @BeforeClass
    public void setReportConfiguration() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        ExtentProperties property = ExtentProperties.INSTANCE;
        property.setReportPath("path/Report.html");
    }

    @Test(dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass
    public void setConfiguration() {
        testNGCucumberRunner.finish();
        Reporter.loadXMLConfig("ConfigFiles/extent-config.xml");
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
        log.info("Browser closed");
    }
}