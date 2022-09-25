package ch.charlenes.coffeecorner.shop.bonus;

import ch.charlenes.coffeecorner.shop.Bill;

public interface IBonusCalculator {
    void applyBonus(Bill bill);
}
