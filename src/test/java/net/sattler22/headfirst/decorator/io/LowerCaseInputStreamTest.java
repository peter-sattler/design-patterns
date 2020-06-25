package net.sattler22.headfirst.decorator.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Heads First (OO) Design Patterns - Chapter 3 (Decorator Pattern)
 * <p>
 * Extend the <code>java.io</code> classes with our own decorator!!!
 *
 * @author Pete Sattler
 * @version June 2020
 */
final class LowerCaseInputStreamTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LowerCaseInputStreamTest.class);

    @Test
    void testDecorator() {
        try (InputStream inputStream = new LowerCaseInputStream(
                                           new BufferedInputStream(
                                               getClass().getClassLoader().getResourceAsStream("decorator-io.txt")))) {
            int c;
            final StringBuilder result = new StringBuilder();
            while ((c = inputStream.read()) >= 0)
                result.append((char) c);
            LOGGER.info(result.toString());
        }
        catch(IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
