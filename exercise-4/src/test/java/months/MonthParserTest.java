package months;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MonthParserTest {
    MonthParser monthParser;

    @Before
    public void initializeMonthParser() {
        monthParser = new MonthParser();
    }

    @Test
    public void parseJanuary() {
        assertTrue(monthParser.parseMonth(1).name == "January");
        assertEquals("Wrong number of days", monthParser.parseMonth(1).days,31);
    }

    @Test
    public void parseFebruary() {
        assertTrue(monthParser.parseMonth(2).name == "February");
        assertEquals("Wrong number of days", monthParser.parseMonth(2).days, 28);
    }

    @Test
    public void parseMarch() {
        assertTrue(monthParser.parseMonth(3).name == "March");
        assertEquals("Wrong number of days", monthParser.parseMonth(3).days, 31);
    }

    @Test
    public void parseApril() {
        assertTrue(monthParser.parseMonth(4).name == "April");
        assertEquals("Wrong number of days", monthParser.parseMonth(4).days, 30);
    }

    @Test
    public void parseMay() {
        assertTrue(monthParser.parseMonth(5).name == "May");
        assertEquals("Wrong number of days", monthParser.parseMonth(5).days,31);
    }

    @Test
    public void parseJune() {
        assertTrue(monthParser.parseMonth(6).name == "June");
        assertEquals("Wrong number of days", monthParser.parseMonth(6).days, 30);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseNegativeMonthNumber() {
        monthParser.parseMonth(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseZeroMonthNumber() {
        monthParser.parseMonth(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canNotParseTooHighMonthNumber() {
        monthParser.parseMonth(13);
    }

}
