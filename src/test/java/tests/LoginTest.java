package tests;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    private final By MISTAKE_MESSAGE_NUMBER_3 = By.cssSelector("h3");
    private final By NAME_TSHIRT = By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']");

    @Epic("Модуль логтна интернет-магазина")
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

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {user, " ", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", password, "Epic sadface: Sorry, this user has been locked out."},
                {"problem_user", "", "Epic sadface: Password is required"},
        };
    }

    @Test(enabled = true)
    public void emptyPasswordInputCheck() {
        loginPage
                .open()
                .login(user, " ");
        assertEquals(driver.findElement(MISTAKE_MESSAGE_NUMBER_3).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(enabled = true)
    public void lockedOutUserInputCheck() {
        loginPage
                .open()
                .login("locked_out_user", password);
        assertEquals(driver.findElement(MISTAKE_MESSAGE_NUMBER_3).getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(enabled = false)
    public void problemUserInputCheck() {
        loginPage
                .open()
                .login("problem_user", password);
        assertEquals(driver.findElement(NAME_TSHIRT).getText(),
                "Test.allTheThings() T-Shirt (Red)");
    }
}