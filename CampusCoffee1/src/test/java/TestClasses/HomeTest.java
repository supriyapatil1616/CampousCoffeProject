package TestClasses;

import Pages.*;
import TestBase.WebTestBaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTest extends WebTestBaseClass {
    public HomePage homePage;
    public LoginPage loginPage;
    public MyAccountPage myAccountPage;
    public StayUpdatedFormPage stayUpdatedFormPage;
    public RegistrationPage registrationPage;
    public OurCoffeePage ourCoffeePage;
    public CoffeePage coffeePage;
    public HomeTest(){
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
    }
    @Test(priority=3)
    public void verifyUserCanSelectOptionFromOurStory(){
        SoftAssert softAssert=new SoftAssert();
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        ourCoffeePage.histroyMove();
        String coffeePageText=ourCoffeePage.ourCoffeeText();
        softAssert.assertEquals(coffeePageText, "OUR COFFEE", "Text should be matched here");
        softAssert.assertAll();
    }
    @Test(priority=4)
    public void verifyUserGoToCoffePage()  {
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        homePage.movetoShop();
        homePage.closeSecondAdd();
        coffeePage.dropdown();
        coffeePage.scrollToElement();
    }
    @Test(priority=6, description = "Veriffy user is not able to subscribe because of invalid captcha")
    public void verifyTheEmailIconInHomePage(){
        SoftAssert softAssert=new SoftAssert();
        //homePage.closeFirstAdd();
        homePage.closeSecondAdd();
        stayUpdatedFormPage.form(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email") );
        String messageText=stayUpdatedFormPage.captchText();
        softAssert.assertEquals(messageText,"The reCAPTCHA was invalid. Go back and try it again.","Text should be match");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
