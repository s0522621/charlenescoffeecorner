package ch.charlenes.coffeecorner.shop;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> orderItems = new ArrayList<>();

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
