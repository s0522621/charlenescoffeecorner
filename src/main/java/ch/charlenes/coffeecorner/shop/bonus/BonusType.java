package ch.charlenes.coffeecorner.shop.bonus;

public enum BonusType {
    CUSTOMERSTAMP("Customer stamp"),
    FREE_EXTRA("Free extra");

    private final String description;

    BonusType(String description) {
        this.description = description;
    }
}
