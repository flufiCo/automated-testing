package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class HerokuInputTest extends BaseTest {

    @Test
    public void inputs() {
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement element = driver.findElement(By.tagName("input"));
        element.sendKeys("3");
        String inputButton;
        inputButton = element.getAttribute("value");
        assertEquals(inputButton, "3", "The given number is incorrect");

        element.clear();
        IntStream.iterate(1, n -> n + 1).limit(5).forEach(number -> driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP));

        inputButton = element.getAttribute("value");
        assertEquals(inputButton, "5", "The given number is incorrect");

        element.clear();
        element.sendKeys("3");
        element.sendKeys(Keys.ARROW_DOWN);
        inputButton = element.getAttribute("value");
        assertEquals(inputButton, "2", "The given number is incorrect");

    }
}