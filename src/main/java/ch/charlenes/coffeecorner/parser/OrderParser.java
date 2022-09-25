package ch.charlenes.coffeecorner.parser;

import ch.charlenes.coffeecorner.shop.*;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.text.MessageFormat.format;

public class OrderParser {

    public static final String STOPWORD_WITH = " with ";
    public static final String DELIMETER = ", ";

    public static Order parseFullOrder(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Order cannot be null or empty!");
        }
        Order order = new Order();
        Arrays.stream((input).split(DELIMETER))
                .forEach(singleOrder -> order.addItem(parseOrderItem(singleOrder)));
        return order;
    }


    protected static OrderItem parseOrderItem(String singleOrder) {
        String[] split = singleOrder.split(STOPWORD_WITH);
        OrderItem orderItem = new OrderItem(parseProduct(split[0]));
        if (split.length > 1) {
            if (orderItem.getProduct().getItemType() !=  ItemType.COFFEE) {
                throw new IllegalArgumentException(format("Extras are only allowed for coffee! Remove extra from {0}", singleOrder));
            }
            Stream.of(split).skip(1).forEach(extra -> orderItem.addExtra(parseExtra(extra)));
        }
        return orderItem;
    }

    private static Extra parseExtra(String givenName) {
        return Stream.of(Extra.values())
                .filter(extra -> extra.getDescription().equals(givenName.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("No Extra with name {0} found", givenName)));
    }

    private static Product parseProduct(String givenName) {
        return Stream.of(Product.values())
                .filter(beverage -> beverage.getDescription().equals(givenName.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format("No Product with name {0} found", givenName)));
    }
}
