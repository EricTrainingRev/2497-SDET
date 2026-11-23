package com.curriculum.labs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Filters and sorts lists of sales by their total.
 */
public final class SalesReport {

    private SalesReport() {
    }

    /**
     * Returns a new list containing the sales whose total is at least
     * {@code minimum}, in their original order. A sale whose total equals
     * {@code minimum} exactly is kept. The input list is not changed.
     *
     * @param sales   the sales to filter
     * @param minimum the smallest total to keep
     * @return a new list of the matching sales
     */
    public static List<Sale> filterByMinimumTotal(List<Sale> sales, double minimum) {
        List<Sale> result = new ArrayList<>();
        for (Sale sale : sales) {
            if (sale.getTotal() >= minimum) {
                result.add(sale);
            }
        }
        return result;
    }

    /**
     * Returns a new list with the sales ordered from largest total to
     * smallest. Sales with equal totals keep their original relative order.
     * The input list is not changed.
     *
     * @param sales the sales to sort
     * @return a new, sorted list
     */
    public static List<Sale> sortByTotalDescending(List<Sale> sales) {
        List<Sale> result = new ArrayList<>(sales);
        result.sort(Comparator.comparingDouble(Sale::getTotal).reversed());
        return result;
    }
}
