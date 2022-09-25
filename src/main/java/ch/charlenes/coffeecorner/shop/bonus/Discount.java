package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Extra;
import ch.charlenes.coffeecorner.shop.Product;

import java.util.Optional;

public class Discount {

    private final BonusType bonusType;
    private final Optional<Extra> extra;
    private final Optional<Product> product;

    public Discount(BonusType bonusType, Extra extra, Product product) {
        this.bonusType = bonusType;
        this.extra = Optional.ofNullable(extra);
        this.product = Optional.ofNullable(product);
    }

    public BonusType getBonusType() {
        return bonusType;
    }

    public Optional<Extra> getExtra() {
        return extra;
    }

    public Optional<Product> getProduct() {
        return product;
    }

    public String getDescription() {
        String description = bonusType.getDescription() + ": ";
        if (extra.isPresent()) {
            description += extra.get().getDescription();
        }
        if (product.isPresent()) {
            description += product.get().getDescription();
        }
        return description;
    }

    public double getPrice() {
        double price = 0;
        if (extra.isPresent()) {
            price += extra.get().getPrice();
        }
        if (product.isPresent()) {
            price += product.get().getPrice();
        }
        return price;
    }
}
