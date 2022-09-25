package ch.charlenes.coffeecorner.parser;

import org.junit.Test;

public class OrderParserTest {

    @Test
    public void testParse() {
        OrderParser.parseFullOrder("large coffee with extra milk, small coffee with special roast, bacon roll, orange juice");
    }

}
