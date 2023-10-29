package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends WebTestBaseClass {
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountText;

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }

   public String textOfMyAccount() {
        return DriverUtility.getTextOfElement(myAccountText);
    }
}


