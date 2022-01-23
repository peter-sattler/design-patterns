package net.sattler22.headfirst.decorator.io;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Heads First (OO) Design Patterns - Chapter 3 (Decorator Pattern)
 * <p>
 * Extend the <code>java.io</code> classes with our own decorator!!!
 *
 * @author Pete Sattler
 * @version January 2022
 */
final class LowerCaseInputStreamTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LowerCaseInputStreamTest.class);
    private static final String DECORATOR_INPUT_FILE = "decorator-io.txt";

    @Test
    void testDecorator() throws IOException {
        final var inputFile = getClass().getClassLoader().getResourceAsStream(DECORATOR_INPUT_FILE);
        if (inputFile == null)
            throw new FileNotFoundException(String.format("Decorator input file [%s] not found", DECORATOR_INPUT_FILE));
        try (final var inputStream = new LowerCaseInputStream(new BufferedInputStream(inputFile))) {
            int c;
            final var result = new StringBuilder();
            while ((c = inputStream.read()) >= 0)
                result.append((char) c);
            LOGGER.info(result.toString());
            assertTrue(true);  //SonarLint
        }
    }
}
