package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends WebTestBaseClass {
   @FindBy(id="reg_email")
    WebElement registrationEmail;
   @FindBy(name="password")
    WebElement registartionPassword;
   @FindBy(name="register")
    WebElement registrationBtn;
    public RegistrationPage(){
        PageFactory.initElements(driver, this);
    }
    public void registration(String email1,String password1){
       registrationEmail.sendKeys(email1);
        registartionPassword.sendKeys(password1);
        DriverUtility.waitUntilElementToBeClickable(registrationBtn);
    }


}
