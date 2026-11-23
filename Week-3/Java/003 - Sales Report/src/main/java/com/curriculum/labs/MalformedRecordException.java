package com.curriculum.labs;

/**
 * Thrown when a line does not have the expected number of comma-separated
 * fields.
 */
public class MalformedRecordException extends Exception {

    public MalformedRecordException(String message) {
        super(message);
    }
}
