package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

import static Utility.DriverUtility.actions;

public class HomePage extends WebTestBaseClass {
    @FindBy(xpath="//a[@class='user-controls__ul__li__a']")
    WebElement loginElement;
    @FindBy(xpath="//button[@title='Close']")
    WebElement closeFirstAdd;
    @FindBy(xpath="//a[@class='newsletter__close newsletter__trigger']")
    WebElement closeSecondAdd;
    @FindBy(xpath="//div[@class='menu__ul__li__icon accordion__toggle']//following::div[1]")
    WebElement movetoShop;
    @FindBy(xpath="//li[@id='menu-item-58591']")
    WebElement coffeeoption;
    @FindBy(xpath="//li[@class='user-controls__ul__li user-controls__ul__li--cart']")
    WebElement addCart;
    @FindBy(xpath="//li[@id='menu-item-375658']")
    WebElement newsOption;
    @FindBy(xpath="//button[@class='filter-inner-button']")
    WebElement findBtn;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
    public void closeFirstAdd(){
        DriverUtility.waitUntilElementToBeClickable(closeFirstAdd);
    }
    public void closeSecondAdd(){
        DriverUtility.waitUntilElementToBeClickable(closeSecondAdd);
    }
    public void clickOnLoginBtn(){
        DriverUtility.waitUntilElementToBeClickable(loginElement);
    }

    public void movetoShop(){
        DriverUtility.actionMoveToElement(movetoShop);
        actions.perform();
        DriverUtility.waitUntilElementToBeClickable(coffeeoption);
    }

    public void addToCart(){
        DriverUtility.waitUntilElementToBeClickable(addCart);
    }
    public void newsOpt(){
        DriverUtility.waitUntilElementToBeClickable(newsOption);
    }
    public void scroll(){
        DriverUtility.ScrollDownByVisibleElement(findBtn);
    }
    public void isEnabledMd(){
        DriverUtility.isEnabledMethood(findBtn);
    }


}


