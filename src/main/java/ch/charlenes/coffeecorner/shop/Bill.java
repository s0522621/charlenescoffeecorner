package ch.charlenes.coffeecorner.shop;

import ch.charlenes.coffeecorner.shop.bonus.Discount;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private final Order order;

    private final List<Discount> discounts = new ArrayList<>();

    public Bill(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

}
