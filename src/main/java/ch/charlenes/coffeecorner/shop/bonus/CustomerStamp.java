package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Bill;
import ch.charlenes.coffeecorner.shop.ItemType;
import ch.charlenes.coffeecorner.shop.OrderItem;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerStamp implements IBonusCalculator {

    public final static int STAMPCARD_SIZE = 5;

    @Override
    public void applyBonus(Bill bill) {
        getDiscountedItems(BonusHelper.filterListByItemType(bill, ItemType.COFFEE, ItemType.BEVERAGE))
                .stream()
                .forEach(orderItem -> bill.addDiscount(new Discount(BonusType.CUSTOMERSTAMP, null, orderItem.getProduct())));
    }

    private static List<OrderItem> getDiscountedItems(List<OrderItem> filteredList) {
        if(filteredList.size() < STAMPCARD_SIZE) {
            return Collections.emptyList();
        }
        int limit = filteredList.size() / STAMPCARD_SIZE + Math.min(filteredList.size() % STAMPCARD_SIZE, 1);

        return Stream.iterate(0, i -> i + STAMPCARD_SIZE)
                .limit(limit)
                .map(filteredList::get)
                .collect(Collectors.toList());
    }
}
