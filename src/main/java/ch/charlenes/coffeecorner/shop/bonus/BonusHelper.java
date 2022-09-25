package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Bill;
import ch.charlenes.coffeecorner.shop.ItemType;
import ch.charlenes.coffeecorner.shop.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

public class BonusHelper {

    public static IBonusCalculator getBonusCalculator(BonusType bonusType) {
        switch (bonusType) {
            case CUSTOMERSTAMP:
                return new CustomerStamp();
            case FREE_EXTRA:
                return new FreeExtra();
            default:
                throw new IllegalArgumentException("Unknown bonus type: " + bonusType);
        }
    }

    public static List<OrderItem> filterListByItemType(Bill bill, ItemType... itemType) {
        return bill.getOrder().getOrderItems()
                .stream()
                .filter(orderItem -> {
                    for (ItemType type : itemType) {
                        if (orderItem.getProduct().getItemType() == type) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
