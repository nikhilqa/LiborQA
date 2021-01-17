package pages;

import Locators.FloableLoginPage;
import cucumber.api.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import useractivities.CommonActions;
import Logger.LogSetting;

public class LoginPage extends FloableLoginPage {

    private WebDriver driver = null;
    private Logger log = LogSetting.getLogger(CommonActions.class);
    CommonActions commonActions ;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        commonActions = new CommonActions(driver);
    }

    public void enterUsername(String username) {
        commonActions.enterString(usernameTextBox, username);
        log.info("Username Entered");
    }

    public void searchText(String searchText) {
        commonActions.enterString(searchBox, searchText);


    }

}
