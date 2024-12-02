package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", " ", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"problem_user", "", "Epic sadface: Password is required"}
        };
    }
    private final By MISTAKE_MESSAGE_NUMBER_3 = By.cssSelector("h3");

    @Test(dataProvider = "loginData")
    public void incorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMessage(), errorMsg);
    }

    @Test(enabled = false)
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
        assertTrue("", productsPage.isDisp());
    }

    @Test(enabled = false)
    public void emptyPasswordInputCheck() {
        loginPage.open();
        loginPage.login("standard_user", " ");
        assertEquals(driver.findElement(MISTAKE_MESSAGE_NUMBER_3).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(enabled = false)
    public void lockedOutUserInputCheck() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(driver.findElement(MISTAKE_MESSAGE_NUMBER_3).getText(),
                "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(enabled = false)
    public void problemUserInputCheck() {
        loginPage.open();
        loginPage.login("problem_user", "secret_sauce");
        assertEquals(driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")).getText(),
                "Test.allTheThings() T-Shirt (Red)");
    }
}