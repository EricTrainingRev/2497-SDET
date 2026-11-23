package com.curriculum.labs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Provided tests for {@link Sale}. Tasks 1 and 2 are done when every test in
 * this class passes.
 */
class SaleTest {

    private static final double DELTA = 0.001;

    // ---- Task 1: constructors ----

    @Test
    void fullConstructorSetsEveryField() {
        Sale sale = new Sale("1002", "Gadget", 2, 49.50, 10);

        assertAll(
                () -> assertEquals("1002", sale.getSaleId()),
                () -> assertEquals("Gadget", sale.getProduct()),
                () -> assertEquals(2, sale.getQuantity()),
                () -> assertEquals(49.50, sale.getUnitPrice(), DELTA),
                () -> assertEquals(10, sale.getDiscountPercent()));
    }

    @Test
    void shortConstructorDefaultsDiscountToZero() {
        Sale sale = new Sale("1001", "Widget", 5, 19.99);

        assertAll(
                () -> assertEquals("1001", sale.getSaleId()),
                () -> assertEquals("Widget", sale.getProduct()),
                () -> assertEquals(5, sale.getQuantity()),
                () -> assertEquals(19.99, sale.getUnitPrice(), DELTA),
                () -> assertEquals(0, sale.getDiscountPercent()));
    }

    // ---- Task 2: equals, hashCode, toString ----

    @Test
    void salesWithTheSameDataAreEqual() {
        Sale first = new Sale("1002", "Gadget", 2, 49.50, 10);
        Sale second = new Sale("1002", "Gadget", 2, 49.50, 10);

        assertEquals(first, second);
    }

    @Test
    void shortAndFullConstructorsMatchWhenDiscountIsZero() {
        assertEquals(new Sale("1001", "Widget", 5, 19.99, 0), new Sale("1001", "Widget", 5, 19.99));
    }

    @Test
    void salesThatDifferInAnyFieldAreNotEqual() {
        Sale sale = new Sale("1002", "Gadget", 2, 49.50, 10);

        assertAll(
                () -> assertNotEquals(sale, new Sale("9999", "Gadget", 2, 49.50, 10), "different saleId"),
                () -> assertNotEquals(sale, new Sale("1002", "Widget", 2, 49.50, 10), "different product"),
                () -> assertNotEquals(sale, new Sale("1002", "Gadget", 3, 49.50, 10), "different quantity"),
                () -> assertNotEquals(sale, new Sale("1002", "Gadget", 2, 39.50, 10), "different unitPrice"),
                () -> assertNotEquals(sale, new Sale("1002", "Gadget", 2, 49.50, 20), "different discountPercent"));
    }

    @Test
    void aSaleIsNotEqualToNullOrToAnotherType() {
        Sale sale = new Sale("1002", "Gadget", 2, 49.50, 10);

        assertAll(
                () -> assertFalse(sale.equals(null), "equals(null) should be false"),
                () -> assertFalse(sale.equals("1002"), "a Sale should not equal a String"));
    }

    @Test
    void equalSalesHaveEqualHashCodes() {
        Sale first = new Sale("1002", "Gadget", 2, 49.50, 10);
        Sale second = new Sale("1002", "Gadget", 2, 49.50, 10);

        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void toStringContainsEveryFieldValue() {
        String text = new Sale("S-77", "Sprocket", 42, 12.5, 15).toString();

        assertAll(
                () -> assertTrue(text.contains("S-77"), "saleId missing from: " + text),
                () -> assertTrue(text.contains("Sprocket"), "product missing from: " + text),
                () -> assertTrue(text.contains("42"), "quantity missing from: " + text),
                () -> assertTrue(text.contains("12.5"), "unitPrice missing from: " + text),
                () -> assertTrue(text.contains("15"), "discountPercent missing from: " + text));
    }
}
