package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends WebTestBaseClass {
    @FindBy(id="username")
    WebElement userNameTextBox;
    @FindBy(id="password")
    WebElement passwordTextBox;
    @FindBy(name="login")
    WebElement loginBtn;
    @FindBy(linkText="Click here")
    WebElement registrationLink;
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    public void login(String username,String password){
        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        DriverUtility.waitUntilElementToBeClickable(loginBtn);
    }
    public void login1(){
        DriverUtility.waitUntilElementToBeClickable(loginBtn);
    }
    public void link(){
        DriverUtility.waitUntilElementToBeClickable(registrationLink);
    }
    public void Screenshot() throws IOException {
        DriverUtility.TakesScreenshot();
    }
}
