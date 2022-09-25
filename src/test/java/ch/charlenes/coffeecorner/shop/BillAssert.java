package ch.charlenes.coffeecorner.shop;

import ch.charlenes.coffeecorner.shop.bonus.BonusType;

import static org.junit.jupiter.api.Assertions.*;

public class BillAssert {

        private final Bill bill;

        private BillAssert(Bill bill) {
            this.bill = bill;
        }

        public static BillAssert assertThat(Bill bill) {
            return new BillAssert(bill);
        }

        public BillAssert hasOrder() {
            assertNotNull(bill.getOrder());
            return this;
        }

        public BillAssert hasOrderItemWithDescription(String description) {

            bill.getOrder().getOrderItems().stream()
                    .filter(orderItem -> orderItem.getDescription().equals(description))
                    .findFirst()
                    .orElseThrow(() -> new AssertionError("No order item with description " + description));
            return this;
        }

        public BillAssert hasDiscounts(int expectedDiscounts) {
            assertNotNull(bill.getDiscounts());
            assertEquals(expectedDiscounts, bill.getDiscounts().size());
            return this;
        }

        public BillAssert hasDiscountWithBonusType(BonusType bonusType) {
            assertNotNull(bill.getDiscounts());
            assertTrue(bill.getDiscounts().stream()
                    .anyMatch(discount -> discount.getBonusType().equals(bonusType)));
            return this;
        }
}
