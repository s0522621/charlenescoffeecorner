package ch.charlenes.coffeecorner.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    public double getTotalPrice() {
        double totalPrice = product.getPrice();
        for (Extra extra : extras) {
            totalPrice += extra.getPrice();
        }
        return totalPrice;
    }

    public String getDescription() {
        StringJoiner description = new StringJoiner(" with ");
        description.add(product.getDescription());
        extras.stream()
                .forEach(extra -> description.add(extra.getDescription()));
        return description.toString();
    }
}
