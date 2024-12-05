package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы авторизации в браузере")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вводим данные {user} и {password}")
    public LoginPage login(String user, String password) {
        fillUserInput(user);
        fillPasswordInput(password);
        clickSubmitBtn();
        return this;
    }

    @Step("Вводим данные {user} в поле логина")
    public LoginPage fillUserInput(String user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        return this;
    }

    @Step("Вводим {password} в поле пароля")
    public LoginPage fillPasswordInput(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку авторизации")
    public LoginPage clickSubmitBtn() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}

