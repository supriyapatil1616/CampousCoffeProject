package Pages;

import TestBase.WebTestBaseClass;
import Utility.DriverUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage extends WebTestBaseClass {
    @FindBy(xpath="//img[@class='product-card__image__img']")
    WebElement productCampos;
    @FindBy(xpath="//select[@class='pa_weight']")
    WebElement dropdownselection;
    @FindBy(xpath="//div[text()='Whole Beans']")
    WebElement wholeBeans;
    @FindBy(xpath="//div[text()='Once off']")
    WebElement onceOffOption;
    @FindBy(xpath="//a[@class='button add-to-cart__button button--primary']")
    WebElement addToCartBtn;
    @FindBy(xpath="//div[@class='added-to-cart-modal__title h2']")
    WebElement cartAddedMsg;
    public AddToCartPage() {
        PageFactory.initElements(driver, this);
    }
    public void selectProduct() {
        DriverUtility.waitUntilElementToBeClickable(productCampos);
        DriverUtility.dropdownSelection("500g",dropdownselection);
        DriverUtility.waitUntilElementToBeClickable(wholeBeans);
        DriverUtility.ScrollDownByVisibleElement(onceOffOption);
        DriverUtility.waitUntilElementToBeClickable(addToCartBtn);

    }
    public String cartAddedMsg() {
        return DriverUtility.getTextOfElement(cartAddedMsg);
    }

}
