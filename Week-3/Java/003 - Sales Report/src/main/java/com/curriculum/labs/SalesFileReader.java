package com.curriculum.labs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads the sales file into a list of {@link Sale} objects.
 */
public final class SalesFileReader {

    private SalesFileReader() {
    }

    /**
     * Reads every line of the file and returns the sales that parse
     * successfully.
     *
     * <ul>
     *   <li>Blank lines and the header row (a line starting with
     *       {@code saleId}) are skipped.</li>
     *   <li>Each remaining line is passed to {@link SaleParser#parseLine}.</li>
     *   <li>A line that fails to parse is reported to standard error and
     *       skipped; reading continues with the next line.</li>
     *   <li>Sales are returned in the order they appear in the file.</li>
     * </ul>
     *
     * @param path the file to read
     * @return the successfully parsed sales, in file order
     * @throws IOException if the file is missing or can't be read
     */
    public static List<Sale> readSales(Path path) throws IOException {
        List<Sale> sales = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.isBlank() || line.startsWith("saleId")) {
                    continue;
                }

                try {
                    sales.add(SaleParser.parseLine(line));
                } catch (MalformedRecordException | InvalidNumberException | InvalidValueException e) {
                    System.err.println("Skipping line " + lineNumber + ": " + e.getMessage());
                }
            }
        }

        return sales;
    }
}
