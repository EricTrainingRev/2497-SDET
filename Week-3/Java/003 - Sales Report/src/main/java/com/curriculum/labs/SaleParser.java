package com.curriculum.labs;

/**
 * Turns one line of the sales file into a {@link Sale}.
 */
public final class SaleParser {

    private SaleParser() {
    }

    /**
     * Parses one line in the format
     * {@code saleId,product,quantity,unitPrice[,discountPercent]}.
     *
     * <p>Whitespace around any field is ignored. Rules, checked in this order:
     * <ol>
     *   <li>The line must have 4 or 5 comma-separated fields; otherwise throw
     *       {@link MalformedRecordException}.</li>
     *   <li>{@code quantity} and {@code discountPercent} must be whole
     *       numbers and {@code unitPrice} a decimal number; if any of them
     *       fails to convert, throw {@link InvalidNumberException} with the
     *       original {@link NumberFormatException} as its cause.</li>
     *   <li>{@code quantity} must be greater than 0, {@code unitPrice} must
     *       not be negative, and {@code discountPercent} must be from 0 to
     *       100; otherwise throw {@link InvalidValueException}.</li>
     * </ol>
     *
     * <p>A line with 4 fields has no discount; build it with the shorter
     * {@link Sale} constructor.
     *
     * <p>Every exception's message should say what's wrong with the line.
     *
     * @param line one line from the sales file
     * @return the parsed sale
     */
    public static Sale parseLine(String line)
            throws MalformedRecordException, InvalidNumberException, InvalidValueException {
        // TODO: Task 3 — implement the rules described above.
        throw new UnsupportedOperationException("TODO: Task 3");
    }
}
