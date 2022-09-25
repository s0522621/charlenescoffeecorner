package ch.charlenes.coffeecorner.shop;

import static ch.charlenes.coffeecorner.shop.ItemType.*;

public enum Product {

    ORANGE_JUICE("orange juice", 3.95, BEVERAGE),
    SMALL_COFFEE("small coffee", 2.5, COFFEE),
    MEDIUM_COFFEE("medium coffee", 3, COFFEE),
    LARGE_COFFEE("large coffee", 3.5, COFFEE),
    BACON_ROLL("bacon roll", 3.95, SNACK);

    private final String description;
    private final double price;
    private final ItemType type;

    Product(String description, double price, ItemType type) {
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public ItemType getItemType() {
        return type;
    }
}
