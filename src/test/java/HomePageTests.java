import config.Consts;
import config.WebDriver;
import pages.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class HomePageTests {
    final public static String logoXpath = "//div[@class='logo']";
    final public static String comingSoonImageXpath = "//img[@alt='coming soon']";

    @BeforeAll
    public static void createWebDriver() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeWebDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void openingMainPageTest() {
        BasePage.openLink(Consts.mainPageUrl, WebDriver.driver);
        assertEquals(0, BasePage.createLog());
    }

    @Test
    public void logoTest() {
        BasePage.openLink(Consts.mainPageUrl, WebDriver.driver);

        WebElement logo = WebDriver.driver.findElement(By.xpath(logoXpath));

        assertTrue(BasePage.checkExistAndSizePicture(logo));
    }

    @Test
    public void comingSoonImageTest() {
        BasePage.openLink(Consts.mainPageUrl, WebDriver.driver);

        WebElement comingSoonImage = WebDriver.driver.findElement(By.xpath(comingSoonImageXpath));

        assertTrue(BasePage.checkExistAndSizePicture(comingSoonImage));
    }
}
