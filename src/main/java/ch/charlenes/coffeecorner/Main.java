package ch.charlenes.coffeecorner;

import ch.charlenes.coffeecorner.parser.BillParser;
import ch.charlenes.coffeecorner.printer.ConsolePrinter;
import ch.charlenes.coffeecorner.shop.Bill;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("One argument expected! e.g. cashregister 'small coffee with extra milk'");
        }
        ConsolePrinter printer = new ConsolePrinter();
        printer.print(BillParser.parseBill(args[0]));
    }
}