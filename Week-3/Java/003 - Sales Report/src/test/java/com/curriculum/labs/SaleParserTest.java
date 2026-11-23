package com.curriculum.labs;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Provided tests for {@link SaleParser}. Task 3 is done when every test in
 * this class passes.
 */
class SaleParserTest {

    // ---- Valid lines ----

    @Test
    void lineWithDiscountParses() throws Exception {
        Sale sale = SaleParser.parseLine("1002,Gadget,2,49.50,10");

        assertEquals(new Sale("1002", "Gadget", 2, 49.50, 10), sale);
    }

    @Test
    void lineWithoutDiscountDefaultsToZero() throws Exception {
        Sale sale = SaleParser.parseLine("1001,Widget,5,19.99");

        assertEquals(new Sale("1001", "Widget", 5, 19.99), sale);
        assertEquals(0, sale.getDiscountPercent());
    }

    @Test
    void whitespaceAroundFieldsIsIgnored() throws Exception {
        Sale sale = SaleParser.parseLine("1006, Widget , 3 , 19.99");

        assertEquals(new Sale("1006", "Widget", 3, 19.99), sale);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2001,Freebie,1,0.00",      // price of exactly 0
            "2002,Gadget,1,49.50,0",    // discount of exactly 0
            "2003,Gadget,1,49.50,100"   // discount of exactly 100
    })
    void boundaryValuesAreAccepted(String line) {
        assertDoesNotThrow(() -> SaleParser.parseLine(line));
    }

    // ---- Planted problems ----

    @ParameterizedTest
    @ValueSource(strings = {
            "1003,Gizmo,4",                   // too few fields
            "1003",                           // far too few
            "1003,Gizmo,4,19.99,10,extra"     // too many fields
    })
    void wrongFieldCountThrowsMalformedRecordException(String line) {
        assertThrows(MalformedRecordException.class, () -> SaleParser.parseLine(line));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1004,Widget,five,19.99",     // quantity
            "1004,Widget,5,cheap",        // unitPrice
            "1004,Widget,5,19.99,ten"     // discountPercent
    })
    void nonNumericValueThrowsInvalidNumberExceptionWithCause(String line) {
        InvalidNumberException e = assertThrows(InvalidNumberException.class, () -> SaleParser.parseLine(line));

        assertInstanceOf(NumberFormatException.class, e.getCause(),
                "the original NumberFormatException should be the cause");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1005,Gadget,-2,49.50",       // negative quantity
            "1005,Gadget,0,49.50",        // zero quantity
            "1005,Gadget,2,-49.50",       // negative price
            "1005,Gadget,2,49.50,-5",     // discount below 0
            "1005,Gadget,2,49.50,101"     // discount above 100
    })
    void outOfRangeValueThrowsInvalidValueException(String line) {
        assertThrows(InvalidValueException.class, () -> SaleParser.parseLine(line));
    }
}
