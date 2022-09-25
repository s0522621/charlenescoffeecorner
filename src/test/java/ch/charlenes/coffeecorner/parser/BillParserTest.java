package ch.charlenes.coffeecorner.parser;

import ch.charlenes.coffeecorner.shop.Bill;
import ch.charlenes.coffeecorner.shop.BillAssert;
import org.junit.jupiter.api.Test;

import static ch.charlenes.coffeecorner.shop.bonus.BonusType.FREE_EXTRA;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BillParserTest {

    @Test
    public void parseBill_noDiscount() {
        Bill bill = BillParser.parseBill("large coffee with extra milk");
        BillAssert.assertThat(bill)
                .hasOrder()
                .hasOrderItemWithDescription("large coffee with extra milk")
                .hasDiscounts(0);
    }

    @Test
    public void parseBill_expectDiscount() {
        Bill bill = BillParser.parseBill("large coffee with extra milk, bacon roll");
        BillAssert.assertThat(bill)
                .hasOrder()
                .hasOrderItemWithDescription("large coffee with extra milk")
                .hasOrderItemWithDescription("bacon roll")
                .hasDiscounts(1)
                .hasDiscountWithBonusType(FREE_EXTRA);
    }

    @Test
    public void parseBill_emptyBill_expectException() {
        assertThrows(IllegalArgumentException.class, () -> BillParser.parseBill(""));
    }

    @Test
    public void parseBill_extraNotAllowed_expectException() {
        assertThrows(IllegalArgumentException.class, () -> BillParser.parseBill("bacon roll with extra milk"));
    }

    @Test
    public void parseBill_unknownProduct_expectException() {
        assertThrows(IllegalArgumentException.class, () -> BillParser.parseBill("bacon"));
    }

    @Test
    public void parseBill_unknownExtra_expectException() {
        assertThrows(IllegalArgumentException.class, () -> BillParser.parseBill("large coffee with oat milk"));
    }
}
