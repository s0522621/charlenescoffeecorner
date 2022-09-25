package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Bill;
import ch.charlenes.coffeecorner.shop.Order;
import ch.charlenes.coffeecorner.shop.OrderItem;
import ch.charlenes.coffeecorner.shop.Product;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomerStampTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void applyBonus_withAtLeastFiveCoffee_expectDiscount() {
        // arrange
        CustomerStamp customerStamp = new CustomerStamp();
        Bill bill = getBill(5);
        assertTrue(bill.getDiscounts().isEmpty());
        // act
        customerStamp.applyBonus(bill);
        // assert
        assertEquals(1, bill.getDiscounts().size());
        assertEquals("Customer stamp: small coffee", bill.getDiscounts().get(0).getDescription());
        assertEquals(2.5, bill.getDiscounts().get(0).getPrice());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void applyBonus_withTooLessCoffee_expectNoDiscount(int ints) {
        // arrange
        CustomerStamp customerStamp = new CustomerStamp();
        Bill bill = getBill(ints);
        assertTrue(bill.getDiscounts().isEmpty());
        // act
        customerStamp.applyBonus(bill);
        // assert
        assertEquals(0, bill.getDiscounts().size());
    }

    private static Bill getBill(int nrOfCoffee) {
        Order order = new Order();
        for(int i = 0; i < nrOfCoffee; i++) {
            order.addItem(new OrderItem(Product.SMALL_COFFEE));
        }
        return new Bill(order);
    }
}