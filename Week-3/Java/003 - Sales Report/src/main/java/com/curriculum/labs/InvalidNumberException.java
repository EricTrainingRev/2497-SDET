package com.curriculum.labs;

/**
 * Thrown when a field that should hold a number can't be converted to one.
 * The original conversion failure is kept as the cause.
 */
public class InvalidNumberException extends Exception {

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
