package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class ProductsTest extends BaseTest {

      @Epic("Модуль работы с корзиной интернет-магазина")
      @Feature("TMS-757")
      @Story("TNS-757.768")
      @Severity(SeverityLevel.CRITICAL)
      @Owner("DI ILIN  DI_MA@gmail.com")
      @TmsLink("UrnSu8")
      @Issue("3")
      @Flaky
      @Test (description = "Проверка добавления товаров в корзину и их отображения")
      public void addGoods() {
          loginPage
                  .open()
                  .login(user, password);
          assertTrue(productsPage.getTitle().contains("Products"));
          productsPage
                  .isOpened()
                  .addToCart("Sauce Labs Backpack")
                  .addToCart(1)
                  .addToCart(2)
                  .openCart();
          assertTrue(productsPage.getTitle().contains("Your Cart"));
          assertTrue(productsPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
      }
}