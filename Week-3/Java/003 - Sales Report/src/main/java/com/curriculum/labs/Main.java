package com.curriculum.labs;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Runs the whole program: read the sales file, keep the larger sales, sort
 * them, and print them.
 */
public class Main {

    private static final Path SALES_FILE = Path.of("src", "test", "resources", "sales.csv");
    private static final double MINIMUM_TOTAL = 50.0;

    public static void main(String[] args) throws IOException {
        List<Sale> sales = SalesFileReader.readSales(SALES_FILE);
        List<Sale> filtered = SalesReport.filterByMinimumTotal(sales, MINIMUM_TOTAL);
        List<Sale> sorted = SalesReport.sortByTotalDescending(filtered);

        System.out.println("Sales with a total of at least " + MINIMUM_TOTAL + ", largest first:");
        for (Sale sale : sorted) {
            System.out.println(sale);
        }
    }
}
