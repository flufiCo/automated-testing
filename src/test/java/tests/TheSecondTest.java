package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TheSecondTest extends BaseTest {

    @Test
    public void zipCode4DigitsCheck() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".error-message-container.error"))).getText();
        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void zipCode5DigitsCheck() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        boolean isPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Sauce Labs Backpack']"))).isDisplayed();
        assertTrue(isPresent, "Sauce Labs Backpack button not found!");
    }
}