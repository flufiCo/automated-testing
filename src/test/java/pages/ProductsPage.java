package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final String ADD_TO_CART_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By TITLE = By.cssSelector("[class='title']");
    private final By ADD_TO_CART_BUTTONS = By.xpath("//*[text()='Add to cart']");
    private final By CART_LINK = By.xpath("//*[@class='shopping_cart_link']");
    private final By PRODUCT_NAMES = By.cssSelector(".inventory_item_name");

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int index) {
        driver.findElements(ADD_TO_CART_BUTTONS).get(index).click();
    }

    public boolean isDisp() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public void openCart() {
        driver.findElement(CART_LINK).click();
    }

    public ArrayList<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(PRODUCT_NAMES);
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsNames) {
            names.add(product.getText());
        }
        return names;
    }

    public void isOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_BUTTONS));
    }
}