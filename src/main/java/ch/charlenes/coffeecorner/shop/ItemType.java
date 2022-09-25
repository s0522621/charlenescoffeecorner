package ch.charlenes.coffeecorner.shop;

public enum ItemType {

    COFFEE("coffee"),
    BEVERAGE("beverage"),
    SNACK("snack"),
    EXTRA("extra");

    private final String description;

    ItemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
