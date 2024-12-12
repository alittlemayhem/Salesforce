package pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        //Чтобы все элементы нашлись по указанным локаторам
        // Инициализирует веб элементы на странице - сначала проксирует, а ищет при запуске теста
        PageFactory.initElements(driver, this);
    }

    @Override
    public BasePage isPageOpened() {
        return null;
    }

    @Override
    public BasePage open() {
        return null;
    }

    @FindBy (id = "username")
    WebElement userNameField;

    @FindBy (id = "password")
    WebElement passwordField;

    @FindBy (id = "Login")
    WebElement loginButton;

    public void login(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
