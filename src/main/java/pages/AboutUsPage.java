package pages;

import config.Consts;
import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AboutUsPage {

    public static void openAboutUsPage() {
        BasePage.openLink(Consts.MAINPAGEURL, WebDriver.driver);
        WebElement aboutUs = WebDriver.driver.findElement(By.id("2"));
        aboutUs.click();

        WebDriver.getWait(5).until((ExpectedCondition<Boolean>) wd -> BasePage.js.executeScript("return document.readyState").equals("complete"));
    }
}
