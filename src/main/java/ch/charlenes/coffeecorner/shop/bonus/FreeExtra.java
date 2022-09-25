package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Bill;
import ch.charlenes.coffeecorner.shop.ItemType;
import ch.charlenes.coffeecorner.shop.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class FreeExtra implements IBonusCalculator {

    @Override
    public void applyBonus(Bill bill) {
        getDiscountedItems(BonusHelper.filterListByItemType(bill, ItemType.SNACK, ItemType.BEVERAGE, ItemType.COFFEE))
                .stream()
                .forEach(orderItem -> bill.addDiscount(new Discount(BonusType.FREE_EXTRA, orderItem.getExtras().get(0), null)));
    }

    private List<OrderItem> getDiscountedItems(List<OrderItem> snackAndBeverageList) {
        int nrOfBeverages = 0;
        int nrOfSnacks = 0;

        for (OrderItem orderItem : snackAndBeverageList) {
            if (orderItem.getProduct().getItemType() == ItemType.BEVERAGE || orderItem.getProduct().getItemType() == ItemType.COFFEE) {
                nrOfBeverages++;
            } else if (orderItem.getProduct().getItemType() == ItemType.SNACK) {
                nrOfSnacks++;
            }
        }

        return snackAndBeverageList.stream()
                .limit(Math.min(nrOfBeverages, nrOfSnacks))
                .filter(orderItem -> orderItem.getProduct().getItemType() == ItemType.COFFEE)
                .filter(orderItem -> orderItem.getExtras().size() > 0)
                .collect(Collectors.toList());
    }

}
