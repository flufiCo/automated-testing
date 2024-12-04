package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password"); // Исправлено название переменной
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие браузера")
    public LoginPage open() { // Возвращаем текущий объект для цепочки вызовов
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вводим данные {user} и {password}")
    public LoginPage login(String user, String password) { // Возвращаем текущий объект
        fillUserInput(user);
        fillPasswordInput(password);
        clickSubmitBtn();
        return this;
    }

    @Step("Вводим данные {user} в поле логина")
    public LoginPage fillUserInput(String user) { // Возвращаем текущий объект
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        return this;
    }

    @Step("Вводим {password} в поле пароля")
    public LoginPage fillPasswordInput(String password) { // Возвращаем текущий объект
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку авторизации")
    public LoginPage clickSubmitBtn() { // Возвращаем текущий объект
        driver.findElement(LOGIN_BUTTON).click(); // Исправлено на click()
        return this;
    }

    @Step("Получаем текст из сообщения об ошибке")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
