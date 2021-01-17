package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloableLoginPage {

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    public WebElement searchBox;
}
