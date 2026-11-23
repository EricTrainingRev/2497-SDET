package com.curriculum.labs;

/**
 * Thrown when a number converts successfully but falls outside its allowed
 * range.
 */
public class InvalidValueException extends Exception {

    public InvalidValueException(String message) {
        super(message);
    }
}
