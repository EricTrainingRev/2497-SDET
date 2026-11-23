package com.curriculum.labs;

/**
 * One sale from the sales file.
 *
 * <p>The fields, getters, and {@link #getTotal()} are provided. You write the
 * constructors (Task 1) and the {@code Object} overrides (Task 2).
 */
public class Sale {

    private final String saleId;
    private final String product;
    private final int quantity;
    private final double unitPrice;
    private final int discountPercent;

    /**
     * Creates a sale with every field supplied.
     */
    public Sale(String saleId, String product, int quantity, double unitPrice, int discountPercent) {
        // TODO: Task 1 — assign each parameter to its matching field.
        throw new UnsupportedOperationException("TODO: Task 1");
    }

    /**
     * Creates a sale with no discount (a discountPercent of 0).
     */
    public Sale(String saleId, String product, int quantity, double unitPrice) {
        // TODO: Task 1 — call the five-argument constructor, passing 0 for the
        // discount, instead of repeating the field assignments here.
        throw new UnsupportedOperationException("TODO: Task 1");
    }

    public String getSaleId() {
        return saleId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    /**
     * The amount charged for this sale:
     * quantity × unitPrice × (1 − discountPercent / 100).
     */
    public double getTotal() {
        return quantity * unitPrice * (1 - discountPercent / 100.0);
    }

    @Override
    public boolean equals(Object o) {
        // TODO: Task 2 — two sales are equal when all five fields match.
        throw new UnsupportedOperationException("TODO: Task 2");
    }

    @Override
    public int hashCode() {
        // TODO: Task 2 — build the hash code from the same five fields that
        // equals compares.
        throw new UnsupportedOperationException("TODO: Task 2");
    }

    @Override
    public String toString() {
        // TODO: Task 2 — return a readable string that contains every field's
        // value. Any format works, including one your IDE generates.
        throw new UnsupportedOperationException("TODO: Task 2");
    }
}
