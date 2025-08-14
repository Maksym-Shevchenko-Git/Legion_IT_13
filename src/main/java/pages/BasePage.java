package pages;

import config.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class BasePage {

    public static final JavascriptExecutor js = (JavascriptExecutor) WebDriver.driver;

    public static void openLink(String link, org.openqa.selenium.WebDriver driver) {
        WebDriver.getWait(10).until((ExpectedCondition<Boolean>) wd -> js.executeScript("return document.readyState").equals("complete"));

        driver.manage().window().maximize();
        driver.get(link);
    }

    public static int createLog() {
        LogEntries entries = WebDriver.driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();

        for (LogEntry i : logs) {
            System.out.println("Error: " + i);
        }

        return logs.size();
    }

    public static boolean checkExistAndSizePicture(WebElement webElement) {
        boolean webElementisplayed = false;

        if (webElement.isDisplayed()) {
            System.out.println("The picture is displayed.");
            int h = webElement.getRect().getHeight();
            int w = webElement.getRect().getWidth();
            if (h != 0 && w != 0) {
                System.out.println("The picture size is " + h + "x" + w + ".");
                webElementisplayed = true;
            } else {
                System.out.println("The picture size is " + h + "x" + w + ".");
            }
        } else {
            System.out.println("The Picture is not displayed.");
        }

        return webElementisplayed;
    }
}
