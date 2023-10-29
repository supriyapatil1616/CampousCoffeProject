package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CoffeePage extends WebTestBaseClass {
    @FindBy(id="sort")
    WebElement sortDropdown;
    @FindBy(id="input_13_1")
    WebElement scrollToEmail;
    public CoffeePage() {
        PageFactory.initElements(driver, this);
    }
    public void dropdown(){
        DriverUtility.dropdownSelection("Latest",sortDropdown);
    }
    public void scrollToElement()  {
        DriverUtility.ScrollDownByVisibleElement(scrollToEmail);
    }

}
