package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_INPUT = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        fullUserInput(user);
        fullPasswordInput(password);
        clickSubmBtn();
        if (isErrorMessagePresent()) {
            getErrorMessage();
        } else {
        }
    }

    public void fullUserInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
    }

    public void fullPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickSubmBtn() {
        driver.findElement(LOGIN_INPUT).submit();
    }

    public boolean isErrorMessagePresent() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getErrorMessage() {
        WebElement errorElement = driver.findElement(ERROR_MESSAGE);
        return errorElement.getText();
    }
}