package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Extra;
import ch.charlenes.coffeecorner.shop.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void getDescription_withSmallCoffeeAndCustomerStamp() {
        Discount discount = new Discount(BonusType.CUSTOMERSTAMP, null, Product.SMALL_COFFEE);
        assertEquals("Customer stamp: small coffee", discount.getDescription());
        assertEquals(2.5, discount.getPrice());
    }

    @Test
    void getDescription_withExtra() {
        Discount discount = new Discount(BonusType.FREE_EXTRA, Extra.EXTRA_MILK, null);
        assertEquals("Free extra: extra milk", discount.getDescription());
        assertEquals(0.3, discount.getPrice());
    }
}