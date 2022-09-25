package ch.charlenes.coffeecorner.shop;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private List<Extra> extras = new ArrayList<>();
    private Product product;

    public OrderItem(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void addExtra(Extra extra) {
        this.extras.add(extra);
    }

    public List<Extra> getExtras() {
        return extras;
    }
}
