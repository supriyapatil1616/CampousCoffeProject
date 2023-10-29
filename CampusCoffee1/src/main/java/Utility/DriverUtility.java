package Utility;

import TestBase.WebTestBaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class DriverUtility extends WebTestBaseClass {
    public static final long PAGE_LODE_TIME=60;
    public static final long IMPLICIT_WAIT=60;
    public static final long EXPLICIT_WAIT=60;
    public static WebDriverWait wait;
    public static Actions actions;
    public static JavascriptExecutor javascriptExecutor;
    public static Select select;
    public static TakesScreenshot takesScreenshot;
    public static void waitUntilElementToBeClickable(WebElement element){

        wait =new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public static String getTextOfElement(WebElement element){
        return element.getText();
    }
    public static void actionMoveToElement(WebElement element){
        actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public static void ScrollDownByVisibleElement(WebElement element){
        javascriptExecutor  = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",element);
    }
    public static String dropdownSelection(String visibleText ,WebElement element){
        select = new Select(element);
        select.selectByVisibleText(visibleText);
        return visibleText;
    }
    public static void TakesScreenshot() throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file,new File(System.getProperty("user.dir") + "/src/main/resources/Screenshot/screenshot.PNG"));
    }
    public static boolean isEnabledMethood(WebElement element){
        return element.isEnabled();
    }
}
