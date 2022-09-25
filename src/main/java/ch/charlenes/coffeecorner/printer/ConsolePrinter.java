package ch.charlenes.coffeecorner.printer;

import ch.charlenes.coffeecorner.shop.Bill;

import java.util.concurrent.atomic.AtomicReference;

public class ConsolePrinter {

    public static final double TAX_RATE = 0.081;

    public void print(Bill bill) {
        printHeader();
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        printOrder(bill, sum);
        printDiscounts(bill, sum);
        printFooter(sum.get());
    }

    private static void printHeader() {
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("|             Charlene's Coffee Corner                     |%n");
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("| %-37s | %16s |%n", "Article", "Price");
        System.out.printf("------------------------------------------------------------%n");
    }

    private static void printOrder(Bill bill, AtomicReference<Double> sum) {
        bill.getOrder().getOrderItems().forEach(orderItem -> {
            double price = orderItem.getTotalPrice();
            sum.updateAndGet(v -> new Double((double) (v + price)));
            System.out.printf("| %-37s | CHF %12.2f |%n", orderItem.getDescription(), price);
        });
    }

    private static void printDiscounts(Bill bill, AtomicReference<Double> sum) {
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("|                     Discounts                            |%n");
        System.out.printf("------------------------------------------------------------%n");

        bill.getDiscounts().forEach(discount -> {
            double price = discount.getPrice();
            sum.updateAndGet(v -> new Double((double) (v - price)));
            System.out.printf("| %-37s | CHF %12.2f |%n", discount.getDescription(), -price);
        });
    }

    private static void printFooter(Double sum) {
        double mwst = sum * TAX_RATE;
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("| %-37s | CHF %12.2f |%n", "Mwst 8.1%", mwst);
        System.out.printf("| %-37s | CHF %12.2f |%n", "Total:", sum + mwst);
        System.out.printf("------------------------------------------------------------%n");
    }
}
