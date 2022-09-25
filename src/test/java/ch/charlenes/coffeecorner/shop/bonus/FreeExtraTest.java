package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreeExtraTest {

    @Test
    void applyBonus_withOutExtra_expectNoDiscount() {
        // arrange
        FreeExtra freeExtra = new FreeExtra();
        Bill bill = getBill();
        // act
        freeExtra.applyBonus(bill);
        // assert
        assertEquals(0, bill.getDiscounts().size());
    }

    @Test
    void applyBonus_withExtra_expectDiscount() {
        // arrange
        FreeExtra freeExtra = new FreeExtra();
        Bill bill = getBill();
        bill.getOrder().getOrderItems().get(0).addExtra(Extra.EXTRA_MILK);
        // act
        freeExtra.applyBonus(bill);
        // assert
        assertEquals(1, bill.getDiscounts().size());
        assertEquals("Free extra: extra milk", bill.getDiscounts().get(0).getDescription());
        assertEquals(0.3, bill.getDiscounts().get(0).getPrice());
    }

    private static Bill getBill() {
        Order order = new Order();
        order.addItem(new OrderItem(Product.SMALL_COFFEE));
        order.addItem(new OrderItem(Product.BACON_ROLL));
        return new Bill(order);
    }

}