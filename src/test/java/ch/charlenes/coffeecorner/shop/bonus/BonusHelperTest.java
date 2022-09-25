package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ch.charlenes.coffeecorner.shop.bonus.BonusHelper.filterListByItemType;
import static ch.charlenes.coffeecorner.shop.bonus.BonusHelper.getBonusCalculator;
import static org.junit.jupiter.api.Assertions.*;

class BonusHelperTest {

    @Test
    void getBonusCalculator_withCustomerStamp_expectOk() {
        // arrange / act
        IBonusCalculator bonusCalculator = getBonusCalculator(BonusType.CUSTOMERSTAMP);
        // assert
        assertNotNull(bonusCalculator);
        assertTrue(bonusCalculator instanceof CustomerStamp);
    }

    @Test
    void getBonusCalculator_withFreeExtra_expectOk() {
        // arrange / act
        IBonusCalculator bonusCalculator = getBonusCalculator(BonusType.FREE_EXTRA);
        // assert
        assertNotNull(bonusCalculator);
        assertTrue(bonusCalculator instanceof FreeExtra);
    }

    @Test
    public void getBonusCalculator_withUnknownBonus_expectException() {
        assertThrows(IllegalArgumentException.class, () -> getBonusCalculator(null));
    }

    @Test
    void filterListByItemType_justSmallCoffeeFilterCoffee_expectCoffee() {
        // arrange
        Bill bill = getBill();
        // act
        List<OrderItem> result = filterListByItemType(bill, ItemType.COFFEE);
        // assert
        assertEquals(1, result.size());
        assertEquals(ItemType.COFFEE, result.get(0).getProduct().getItemType());
        assertEquals(Product.SMALL_COFFEE, result.get(0).getProduct());
    }

    @Test
    void filterListByItemType_severalItems_expectCoffee() {
        // arrange
        Bill bill = getBill();
        bill.getOrder().addItem(new OrderItem(Product.ORANGE_JUICE));
        // act
        List<OrderItem> result = filterListByItemType(bill, ItemType.COFFEE);
        // assert
        assertEquals(1, result.size());
        assertEquals(ItemType.COFFEE, result.get(0).getProduct().getItemType());
        assertEquals(Product.SMALL_COFFEE, result.get(0).getProduct());
    }

    private static Bill getBill() {
        Order order = new Order();
        order.addItem(new OrderItem(Product.SMALL_COFFEE));
        return new Bill(order);
    }
}