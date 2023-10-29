package TestClasses;

import Pages.*;
import TestBase.WebTestBaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTest extends WebTestBaseClass {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public StayUpdatedFormPage stayUpdatedFormPage;
    public RegistrationPage registrationPage;
    public OurCoffeePage ourCoffeePage;
    public CoffeePage coffeePage;
    public AddToCartPage addToCartPage;
    public LoginTest(){
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
    @Test(priority=1,description = "User can login with valid username and password")
    public void verifyLoginWithValidUsernameAndPass(){
        SoftAssert softAssert=new SoftAssert();
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        homePage.clickOnLoginBtn();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        String myAccountPageText=myAccountPage.textOfMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
    }
    @Test(priority = 7, description="Login without entering username and password and take screenshot")
    public void verifyLoginWithInvalidData() throws IOException {
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        homePage.clickOnLoginBtn();
        loginPage.login1();
        loginPage.Screenshot();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
