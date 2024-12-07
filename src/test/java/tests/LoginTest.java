package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    private final By mistakeMsg = By.cssSelector("h3");
    private final By nameTShirt = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");

    @Epic("Модуль авторизации интернет-магазина")
    @Feature("TMS-756")
    @Story("TNS-756.767")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("DI ILIN  DI_MA@gmail.com")
    @TmsLink("UrnSu7")
    @Issue("2")
    @Description("Проверка входа в систему интернет-магазина")
    @Flaky
    @Test(dataProvider = "loginData")
    public void incorrectLogin(String user, String password, String errorMsg) {
        loginPage
                .open()
                .login(user, password);
        assertEquals(loginPage.getErrorMessage(), errorMsg);
    }

    @DataProvider
    public Object[][] loginData() {
        // эти 2 строчки были добавлены потому что данные из user и password брались null, но в тесте ниже они
        // отбаратывают коректно!
        String user = PropertyReader.getProperty("SmartQA.user");
        String password = PropertyReader.getProperty("SmartQA.password");
        return new Object[][]{
                {user, "invalid_password", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"problem_user", "", "Epic sadface: Password is required"},
        };
    }

    @Test(enabled = false)
    public void lockedOutUserInputCheck() {
        loginPage
                .open()
                .login("locked_out_user", password);
        assertEquals(driver.findElement(mistakeMsg).getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(enabled = false)
    public void emptyPasswordInputCheck() {
        loginPage
                .open()
                .login(user, " ");
        assertEquals(driver.findElement(mistakeMsg).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }


    @Test(enabled = false)
    public void problemUserInputCheck() {
        loginPage
                .open()
                .login("problem_user", password);
        assertEquals(driver.findElement(nameTShirt).getText(),
                "Test.allTheThings() T-Shirt (Red)");
    }
}