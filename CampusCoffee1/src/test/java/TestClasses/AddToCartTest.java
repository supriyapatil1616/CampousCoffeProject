package TestClasses;

import Pages.*;
import TestBase.WebTestBaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartTest extends WebTestBaseClass {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public StayUpdatedFormPage stayUpdatedFormPage;
    public RegistrationPage registrationPage;
    public OurCoffeePage ourCoffeePage;
    public CoffeePage coffeePage;
    public AddToCartPage addToCartPage;
    public AddToCartTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initilization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        myAccountPage=new MyAccountPage();
        stayUpdatedFormPage=new StayUpdatedFormPage();
        registrationPage=new RegistrationPage();
        ourCoffeePage=new OurCoffeePage();
        coffeePage=new CoffeePage();
        addToCartPage=new AddToCartPage();
    }
    @Test(priority=5)
    public void verifyAddToCartFunctionality(){
        SoftAssert softAssert=new SoftAssert();
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        homePage.addToCart();
        homePage.closeSecondAdd();
        addToCartPage.selectProduct();
        String cartText=addToCartPage.cartAddedMsg();
        softAssert.assertEquals(cartText, "SUCCESS! YOU’VE ADDED THIS ITEM TO YOUR CART", "Text should be matched here");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
