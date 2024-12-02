package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DropdownTest extends BaseTest {

    @Test
    public void checkSelectOption() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        //select.selectByVisibleText("Option 1");
        //select.selectByValue("1");
        select.selectByIndex(1);
        //select.deselectByVisibleText("Option 2");
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");
        //assertTrue(select.ge);
    }
}