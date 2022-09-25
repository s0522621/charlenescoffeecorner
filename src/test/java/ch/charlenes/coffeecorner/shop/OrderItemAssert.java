package ch.charlenes.coffeecorner.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderItemAssert {

    private OrderItem orderItem;

    private OrderItemAssert(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public static OrderItemAssert assertThat(OrderItem orderItem) {
        return new OrderItemAssert(orderItem);
    }

    public OrderItemAssert hasExtra(Extra extra) {
        assertTrue(orderItem.getExtras().contains(extra));
        return this;
    }

    public OrderItemAssert hasType(ItemType type) {
        assertEquals(type, orderItem.getProduct().getItemType());
        return this;
    }

    public OrderItemAssert hasDescription(String description) {
        assertEquals(description, orderItem.getDescription());
        return this;
    }

    public OrderItemAssert hasTotalPrice(double price) {
        assertEquals(price, orderItem.getTotalPrice());
        return this;
    }
}