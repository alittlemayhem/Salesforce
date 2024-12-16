package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Textarea {

    WebDriver driver;
    String label;
    private final String textAreaPattern = "//label[text()='%s']//ancestor::lightning-textarea//textarea";

    public Textarea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Filling textarea '{}' with text '{}'", label, text);
        driver.findElement(By.xpath(String.format(textAreaPattern, label))).sendKeys(text);
    }
}
