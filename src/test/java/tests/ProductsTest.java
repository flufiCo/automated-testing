
package tests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class ProductsTest extends BaseTest {

      @Test
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