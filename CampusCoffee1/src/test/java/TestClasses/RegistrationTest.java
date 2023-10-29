package TestClasses;

import Pages.*;
import TestBase.WebTestBaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegistrationTest extends WebTestBaseClass {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public StayUpdatedFormPage stayUpdatedFormPage;
    public RegistrationPage registrationPage;
    public OurCoffeePage ourCoffeePage;
    public CoffeePage coffeePage;
    public AddToCartPage addToCartPage;

    public RegistrationTest() {
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
    @Test(priority=2)
    public void verifyRegistrationFunctionality(){
        SoftAssert softAssert=new SoftAssert();
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        homePage.clickOnLoginBtn();
        loginPage.link();
        registrationPage.registration(prop.getProperty("email1"), prop.getProperty("password1") );
        String myAccountPageText=myAccountPage.textOfMyAccount();
        softAssert.assertEquals(myAccountPageText, "MY ACCOUNT", "Text should be matched here");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
