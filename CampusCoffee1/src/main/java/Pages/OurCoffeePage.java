package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OurCoffeePage extends WebTestBaseClass {
    @FindBy(xpath="//div[@class='menu__ul__li__icon accordion__toggle']")
    WebElement movetoHistory;
    @FindBy(id="menu-item-4755")
    WebElement ourCoffeeOption;
    @FindBy(xpath="//h1[@class='hero-inner-title']")
    WebElement ourCoffeeText;
    public OurCoffeePage() {
        PageFactory.initElements(driver, this);
    }
    public void histroyMove(){
        DriverUtility.actionMoveToElement(movetoHistory);
        DriverUtility.waitUntilElementToBeClickable(ourCoffeeOption);
    }
    public String ourCoffeeText() {
        return DriverUtility.getTextOfElement(ourCoffeeText);
    }
}
