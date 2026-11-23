package com.curriculum.labs;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

/**
 * Task 4: your tests for the provided {@link SalesFileReader}.
 *
 * <p>Work from the behavior described in the Javadoc on
 * {@link SalesFileReader#readSales}, not from its implementation. The sample
 * file is {@code src/test/resources/sales.csv}; open it and count the valid
 * lines by hand so you know what to expect.
 */
class SalesFileReaderTest {

    private static final Path SAMPLE_FILE = Path.of("src", "test", "resources", "sales.csv");

    @Test
    void readsEveryValidSaleFromTheSampleFile() throws IOException {
        // TODO: Task 4 — read SAMPLE_FILE and check that the number of sales
        // returned matches the number of valid lines you counted.
        fail("TODO: Task 4");
    }

    @Test
    void skipsBadLinesAndKeepsReading() throws IOException {
        // TODO: Task 4 — check that the bad lines are not in the result, and
        // that a valid sale appearing after them in the file still is.
        fail("TODO: Task 4");
    }

    @Test
    void missingFileThrowsAnException() {
        // TODO: Task 4 — check that reading a file that doesn't exist throws
        // an IOException.
        fail("TODO: Task 4");
    }
}
