package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    White Box testing is testing that considers the underlying code of the application as a primary source of consideration.
    Unlike Black Box testing, in this scenario the source code itself is what is being tested. When doing White Box testing
    there are typically two primary concerns:
    - Line Coverage
    - Decision Coverage

    Line coverage is a reference to how many statements in your code are "covered" by your tests. If a statement is executed
    it is included in the coverage calculation. If it is not executed it is left out

    Decision (or branch) coverage referees to the flow of execution in your application. If you have conditionals that are
    never exercised (think an if block that never executes) branch coverage can help you discover this

    These approaches to building tests can be very helpful for tracking how much, or possibly little, of your application
    is actually exercised during your applications workflows. High line coverage with low branch coverage indicates that
    your branching logic is either not being utilized or is not yet covered by the current test suite. High branch coverage
    but low line coverage is an indicator of significant dead code in your application (unreachable code). Low line and
    branch coverage is most likely an indication that your tests are broken (or not yet complete). Ideally, your line
    coverage and branch coverage should be 100% each: all your statements are covered by tests, and all avenues of execution
    are explored

    Keep in mind, 100 line and branch coverage does not itself indicate your tests are doing their job. It just means that
    your application as a whole is being exercised as part of your tests
 */

public class CalculatorTest {

    @Test
    public void testDividePositive(){
        String result = Calculator.divide(10.0f,5.0f);
        Assertions.assertEquals("2.0", result);
    }

    @Test
    public void testDivideNegative(){
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> Calculator.divide(10.0f,0.0f));
        Assertions.assertEquals("Can't divide by zero", exception.getMessage());
    }

}
