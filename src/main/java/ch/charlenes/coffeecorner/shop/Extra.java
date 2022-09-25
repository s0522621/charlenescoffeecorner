package ch.charlenes.coffeecorner.shop;


public enum Extra {

    EXTRA_MILK("extra milk", 0.3),
    FOAMED_MILK("foamed milk", 0.5),
    SPECIAL_ROAST("special roast", 0.9);

    private final String description;
    private final double price;

    Extra(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
