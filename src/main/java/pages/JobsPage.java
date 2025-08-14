package pages;

import config.Consts;
import config.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class JobsPage {
    public static final String errorMessageText = "No results found!" + "\n" + "Please try different search criteria";

    public static void openJobsPage() {
        BasePage.openLink(Consts.mainPageUrl, WebDriver.driver);
        WebElement jobsPage = WebDriver.driver.findElement(By.id("3"));
        jobsPage.click();

        WebDriver.getWait(5).until((ExpectedCondition<Boolean>) wd -> BasePage.js.executeScript("return document.readyState").equals("complete"));
    }

    public static boolean checkErrors(WebElement errorMessage) {
        boolean errorsPresents = false;

        if (errorMessage != null) {
            if (errorMessage.isDisplayed() && errorMessage.getText().equals(errorMessageText)) {
                errorsPresents = true;
            }
        }

        return errorsPresents;
    }

    public static boolean checkValue(WebElement currentValue, String requiredValue) {
        return currentValue.getAttribute("value").equals(requiredValue);
    }
}
