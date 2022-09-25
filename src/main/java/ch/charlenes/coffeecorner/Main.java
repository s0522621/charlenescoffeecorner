package ch.charlenes.coffeecorner;

import ch.charlenes.coffeecorner.parser.BillParser;
import ch.charlenes.coffeecorner.shop.Bill;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("One argument expected! e.g. cashregister 'small coffee with extra milk'");
        }
        Bill b = BillParser.parseBill(args[0]);

        // TODO: print bill
        System.out.println(b);
    }
}