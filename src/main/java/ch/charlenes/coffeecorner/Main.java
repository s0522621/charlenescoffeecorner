package ch.charlenes.coffeecorner;

import ch.charlenes.coffeecorner.parser.OrderParser;
import ch.charlenes.coffeecorner.shop.Bill;
import ch.charlenes.coffeecorner.shop.Order;
import ch.charlenes.coffeecorner.shop.bonus.BonusHelper;
import ch.charlenes.coffeecorner.shop.bonus.BonusType;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("One argument expected! e.g. cashregister 'small coffee with extra milk'");
        }
        Order order = OrderParser.parseFullOrder(args[0]);
        Bill b = new Bill(order);
        Arrays.stream(BonusType.values())
                .forEach(bonusType -> BonusHelper.getBonusCalculator(bonusType)
                        .applyBonus(b));
        // TODO: print bill
    }
}