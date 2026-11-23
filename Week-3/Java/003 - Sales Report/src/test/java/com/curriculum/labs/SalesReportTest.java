package com.curriculum.labs;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Task 5: your tests for the provided {@link SalesReport}.
 *
 * <p>Build your own {@link Sale} objects for each test. Pick quantities,
 * prices, and discounts whose totals are easy to work out by hand:
 * total = quantity × unitPrice × (1 − discountPercent / 100).
 */
class SalesReportTest {

    // ---- Filter ----

    @Test
    void filterKeepsOnlySalesAtOrAboveTheMinimum() {
        // TODO: Task 5 — build sales on both sides of a minimum, filter them,
        // and compare the result to the list you expect.
        fail("TODO: Task 5");
    }

    @Test
    void filterKeepsASaleExactlyAtTheMinimum() {
        // TODO: Task 5 — build a sale whose total equals the minimum exactly
        // and check that it is kept.
        fail("TODO: Task 5");
    }

    @Test
    void filterReturnsAnEmptyListWhenNothingMatches() {
        // TODO: Task 5 — use a minimum higher than every sale's total.
        fail("TODO: Task 5");
    }

    @Test
    void filterReturnsAnEmptyListForEmptyInput() {
        // TODO: Task 5 — filter an empty list.
        fail("TODO: Task 5");
    }

    // ---- Sort ----

    @Test
    void sortOrdersSalesByTotalLargestFirst() {
        // TODO: Task 5 — pass sales in a mixed-up order and check the order
        // that comes back.
        fail("TODO: Task 5");
    }

    @Test
    void sortAccountsForTheDiscount() {
        // TODO: Task 5 — build a higher-priced sale with a large discount and
        // a cheaper sale with none, where the discount drops the first one's
        // total below the second's. Check that the cheaper sale comes first.
        fail("TODO: Task 5");
    }

    @Test
    void sortHandlesEmptyAndSingleSaleLists() {
        // TODO: Task 5 — sort an empty list and a list with one sale.
        fail("TODO: Task 5");
    }

    @Test
    void sortLeavesTheOriginalListUnchanged() {
        // TODO: Task 5 — sort a list you can modify (an ArrayList, not
        // List.of) and check that the original is still in its starting
        // order afterward.
        fail("TODO: Task 5");
    }
}
