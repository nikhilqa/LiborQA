package runner;

import base.BaseCall;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",
        monochrome = true, dryRun = false,
        glue = "stepdefinition",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:path/report.html"})

public class TestRunner extends BaseCall {

}
