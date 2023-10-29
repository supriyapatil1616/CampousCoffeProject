package TestClasses;

import Pages.*;
import TestBase.WebTestBaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class NewsTest extends WebTestBaseClass {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public StayUpdatedFormPage stayUpdatedFormPage;
    public RegistrationPage registrationPage;
    public OurCoffeePage ourCoffeePage;
    public CoffeePage coffeePage;
    public AddToCartPage addToCartPage;

    public NewsTest(){
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
    @Test(priority =8, description ="Verify Find button is enabled or disabled on news page")
    public void VerifyTheFindButtonVisibility() throws IOException {
        homePage.closeFirstAdd();
        //homePage.closeSecondAdd();
        homePage.newsOpt();
        homePage.scroll();
        homePage.isEnabledMd();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
