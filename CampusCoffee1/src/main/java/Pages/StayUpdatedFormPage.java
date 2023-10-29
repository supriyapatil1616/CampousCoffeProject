package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StayUpdatedFormPage extends WebTestBaseClass {
    @FindBy(xpath="//a[@class='user-controls__ul__li__a user-controls__ul__li__a--newsletter newsletter__trigger']")
    WebElement formElement;

    @FindBy(id="input_8_1")
    WebElement firstName;
    @FindBy(id="input_8_2")
    WebElement lastName;
    @FindBy(id="input_8_3")
    WebElement emailF;

    @FindBy(xpath="//input[@class='gform_button button']")
    WebElement subscribeBtn;

    //captcha failed text
    @FindBy(xpath="//div[@id='validation_message_8_5']")
    WebElement captchaFailedText;
    public StayUpdatedFormPage(){
        PageFactory.initElements(driver, this);
    }
    public void form(String firstname,String lastname,String email){
        DriverUtility.waitUntilElementToBeClickable(formElement);
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        emailF.sendKeys(email);
        DriverUtility.waitUntilElementToBeClickable(subscribeBtn);
    }
    public String captchText(){
       return DriverUtility.getTextOfElement(captchaFailedText);
    }
}

