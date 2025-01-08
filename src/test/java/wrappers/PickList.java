package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class PickList {

    WebDriver driver;
    String label;
    String pickListPattern = "//label[text()='%s']//ancestor::lightning-picklist";

    public PickList(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.info("Selecting picklist item '{}' from list '{}'", option, label);
        driver.findElement(By.xpath(String.format(pickListPattern + "//button", label)))
                .click();
        WebElement element = driver.findElement(By.xpath(String.format(pickListPattern + "//lightning-base-combobox-item//span[text()='%s']", label, option)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void searchResultOption(String option) {
        log.info("Selecting search result item '{}' from list '{}'", option, label);
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-lookup//input", label))).sendKeys(option);
        driver.findElement(By.xpath(String.format("//*[@title='%s']//ancestor::lightning-base-combobox-item", option))).click();
    }
}
