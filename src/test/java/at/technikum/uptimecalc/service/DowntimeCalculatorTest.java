package at.technikum.uptimecalc.service;

import at.technikum.uptimecalc.model.Downtime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DowntimeCalculatorTest {

    private final DowntimeCalculator downtimeCalculator = new DowntimeCalculator();

    @Test
    void percent9999() {
        // Arrange
        float percent = 99.99f;

        // Act
        Downtime dt = downtimeCalculator.calc(percent);

        // Assert
        assertEquals("0d 0h 0m 8s", dt.getDaily());
        assertEquals("0d 0h 0m 56s", dt.getWeekly());
        assertEquals("0d 0h 4m 0s", dt.getMonthly());
        assertEquals("0d 0h 12m 8s", dt.getQuarterly());
        assertEquals("0d 0h 48m 40s", dt.getYearly());
    }

    @Test
    void percent999() {
        float percent = 99.90f;

        Downtime dt = downtimeCalculator.calc(percent);

        assertEquals("0d 0h 1m 26s", dt.getDaily());
        assertEquals("0d 0h 10m 2s", dt.getWeekly());
        assertEquals("0d 0h 43m 0s", dt.getMonthly());
        assertEquals("0d 2h 10m 26s", dt.getQuarterly());
        assertEquals("0d 8h 43m 10s", dt.getYearly());
    }

    @Test
    void percent0() {
        float percent = 0.00f;

        Downtime dt = downtimeCalculator.calc(percent);

        assertEquals("1d 0h 0m 0s", dt.getDaily());
        assertEquals("7d 0h 0m 0s", dt.getWeekly());
        assertEquals("30d 0h 0m 0s", dt.getMonthly());
        assertEquals("91d 0h 0m 0s", dt.getQuarterly());
        assertEquals("365d 0h 0m 0s", dt.getYearly());
    }

}