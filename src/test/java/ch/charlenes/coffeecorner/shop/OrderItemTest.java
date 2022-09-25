package ch.charlenes.coffeecorner.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    @Test
    void smallCoffee() {
        OrderItem orderItem = new OrderItem(Product.SMALL_COFFEE);
        OrderItemAssert.assertThat(orderItem)
                .hasType(ItemType.COFFEE)
                .hasDescription("small coffee")
                .hasTotalPrice(2.5);
    }

    @Test
    void smallCoffee_withExtraMilk() {
        OrderItem orderItem = new OrderItem(Product.SMALL_COFFEE);
        orderItem.addExtra(Extra.EXTRA_MILK);
        OrderItemAssert.assertThat(orderItem)
                .hasType(ItemType.COFFEE)
                .hasDescription("small coffee with extra milk")
                .hasExtra(Extra.EXTRA_MILK)
                .hasTotalPrice(2.8);
    }
}