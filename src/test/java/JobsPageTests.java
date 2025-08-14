import config.Consts;
import config.WebDriver;
import pages.JobsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class JobsPageTests {

    final public static String errorMessageXpath = "//div[@class='error-indicator']";
    final public static String locationElementXpath = "//input[@name='location' and @class='serch-input']";
    final public static String positionElementXpath = "//input[@name='position' and @class='serch-input']";
    final public static String companyElementXpath = "//input[@name='company' and @class='serch-input']";
    final public static String descriptionElementXpath = "//input[@name='description' and @class='serch-input']";
    final public static String searchButtonElementXpath = "//button[@type='submit' and @class='search-butom' and contains(text(), 'search')]";
    final public static String resetButtonElementXpath = "//button[@type='submit' and @class='search-butom' and contains(text(), 'reset')]";
    final public static String jobsListElementXpath = "//ul[@class='entry-meta']";
    final public static String companyName = "Google";
    final public static String positionName = "Manager";
    final public static String locationName = "USA";
    final public static String descriptionName = "Java";
    final public static String abracadabraName = "abracadabra";

    @BeforeAll
    public static void createWebDriver() {
        WebDriver.createWebDriver();
    }

    @AfterAll
    public static void closeWebDriver() {
        WebDriver.closeWebDriver();
    }

    @Test
    public void openingJobsPageTest() {
        JobsPage.openJobsPage();

        assertEquals(Consts.JOBSPAGEURL, WebDriver.driver.getCurrentUrl());
    }

    @ParameterizedTest
    @CsvSource({"Toronto", "Tel-Aviv", "Chicago", "New-York"})
    public void searchLocationTest(String location) {
        JobsPage.openJobsPage();

        WebElement errorMessage = null;

        WebElement locationElement = WebDriver.driver.findElement(By.xpath(locationElementXpath));
        locationElement.sendKeys(location);

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        WebElement searchButtonElement = WebDriver.driver.findElement(By.xpath(searchButtonElementXpath));
        searchButtonElement.click();

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        try {
            errorMessage = WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        } catch (Exception e) {
        }

        assertFalse(JobsPage.checkErrors(errorMessage));
    }

    @ParameterizedTest
    @CsvSource({"QA", "Developer", "Project Manager"})
    public void searchPositionTest(String position) {
        JobsPage.openJobsPage();

        WebElement errorMessage = null;

        WebElement positionElement = WebDriver.driver.findElement(By.xpath(positionElementXpath));
        positionElement.sendKeys(position);

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        WebElement searchButtonElement = WebDriver.driver.findElement(By.xpath(searchButtonElementXpath));
        searchButtonElement.click();

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        try {
            errorMessage = WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        } catch (Exception e) {
        }

        assertFalse(JobsPage.checkErrors(errorMessage));
    }

    @ParameterizedTest
    @CsvSource({"Apple", "Facebook", "Google"})
    public void searchCompanyTest(String position) {
        JobsPage.openJobsPage();

        WebElement errorMessage = null;

        WebElement companyElement = WebDriver.driver.findElement(By.xpath(companyElementXpath));
        companyElement.sendKeys(position);

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        WebElement searchButtonElement = WebDriver.driver.findElement(By.xpath(searchButtonElementXpath));
        searchButtonElement.click();

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        try {
            errorMessage = WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        } catch (Exception e) {
        }

        assertFalse(JobsPage.checkErrors(errorMessage));
    }

    @Test
    public void combinedSearchTest() {
        JobsPage.openJobsPage();

        WebElement errorMessage = null;

        WebElement companyElement = WebDriver.driver.findElement(By.xpath(companyElementXpath));
        companyElement.sendKeys(companyName);

        WebElement positionElement = WebDriver.driver.findElement(By.xpath(positionElementXpath));
        positionElement.sendKeys(positionName);

        WebElement locationElement = WebDriver.driver.findElement(By.xpath(locationElementXpath));
        locationElement.sendKeys(locationName);

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        WebElement searchButtonElement = WebDriver.driver.findElement(By.xpath(searchButtonElementXpath));
        searchButtonElement.click();

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        try {
            errorMessage = WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        } catch (Exception e) {
        }

        assertFalse(JobsPage.checkErrors(errorMessage));
    }

    @Test
    public void abracadabraTest() {
        JobsPage.openJobsPage();

        WebElement errorMessage = null;

        WebElement positionElement = WebDriver.driver.findElement(By.xpath(positionElementXpath));
        positionElement.sendKeys(abracadabraName);

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        WebElement searchButtonElement = WebDriver.driver.findElement(By.xpath(searchButtonElementXpath));
        searchButtonElement.click();

        WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobsListElementXpath)));

        try {
            errorMessage = WebDriver.getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageXpath)));
        } catch (Exception e) {
        }

        assertEquals(JobsPage.errorMessageText, errorMessage.getText());
    }

    @Test
    public void resetTest() {
        JobsPage.openJobsPage();

        WebElement companyElement = WebDriver.driver.findElement(By.xpath(companyElementXpath));
        companyElement.sendKeys(companyName);

        WebElement positionElement = WebDriver.driver.findElement(By.xpath(positionElementXpath));
        positionElement.sendKeys(positionName);

        WebElement locationElement = WebDriver.driver.findElement(By.xpath(locationElementXpath));
        locationElement.sendKeys(locationName);

        WebElement descriptionElement = WebDriver.driver.findElement(By.xpath(descriptionElementXpath));
        descriptionElement.sendKeys(descriptionName);

        assertTrue(JobsPage.checkValue(companyElement, companyName));
        assertTrue(JobsPage.checkValue(positionElement, positionName));
        assertTrue(JobsPage.checkValue(locationElement, locationName));
        assertTrue(JobsPage.checkValue(descriptionElement, descriptionName));

        WebElement resetButtonElement = WebDriver.driver.findElement(By.xpath(resetButtonElementXpath));
        resetButtonElement.click();

        assertTrue(JobsPage.checkValue(companyElement, ""));
        assertTrue(JobsPage.checkValue(positionElement, ""));
        assertTrue(JobsPage.checkValue(locationElement, ""));
        assertTrue(JobsPage.checkValue(descriptionElement, ""));
    }
}