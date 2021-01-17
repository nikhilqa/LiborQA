package stepdefinition;

import base.BaseCall;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utilities.ConfigReader;

import java.util.List;

public class LoginStepDefinitionTest extends BaseCall{

    LoginPage loginPage;

    @Given("^user is on flowable login page$")
    public void user_is_on_flowable_login_page() throws InterruptedException {
        String title = ConfigReader.readProjectConfig("TestHomePageTitle").trim();
        System.out.println("Title got" + title);
        System.out.println("Title from config" + ConfigReader.readProjectConfig("TestHomePageTitle"));
        Assert.assertEquals(driver.getTitle(), title);
        Thread.sleep(5000);
    }

    @When("^user search text$")
    public void user_search_text(DataTable arg1) throws Throwable {
       String data = String.valueOf(arg1.raw());
        loginPage = new LoginPage(driver);
        loginPage.searchText(data);
    }

}
