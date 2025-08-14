import config.Consts;
import config.WebDriver;
import pages.BasePage;
import pages.AboutUsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutUsPageTests {
    final public static String logoXpath = "//div[@class='logo']";

    @BeforeAll
    public static void createWebDriver() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeWebDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void openingAboutUsPageTest() {
        AboutUsPage.openAboutUsPage();

        assertEquals(Consts.aboutUsPageUrl, WebDriver.driver.getCurrentUrl());
    }

    @Test
    public void logoTest() {
        AboutUsPage.openAboutUsPage();

        WebDriver.getWait(2);

        WebElement logo = WebDriver.driver.findElement(By.xpath(logoXpath));

        assertTrue(BasePage.checkExistAndSizePicture(logo));
    }
}
