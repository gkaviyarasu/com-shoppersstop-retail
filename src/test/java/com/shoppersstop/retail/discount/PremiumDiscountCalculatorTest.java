package com.shoppersstop.retail.discount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kaviyarasug on 25/03/17.
 */
public class PremiumDiscountCalculatorTest {
    static final DiscountCalculator discountCalculator = PremiumDiscountCalculator.getInstance();

    @Test
    public void testDiscountFor1000() {
        assertEquals("Wrong discount price", 900, discountCalculator.calculateDiscountedPrice(1000), 0.5);
    }

    @Test
    public void testDiscountFor5000() {
        assertEquals("Wrong discount price", 4500, discountCalculator.calculateDiscountedPrice(5000), 0.5);
    }

    @Test
    public void testDiscountFor6000() {
        assertEquals("Wrong discount price", 5300, discountCalculator.calculateDiscountedPrice(6000), 0.5);
    }

    @Test
    public void testDiscountFor10000() {
        assertEquals("Wrong discount price", 8500, discountCalculator.calculateDiscountedPrice(10000), 0.5);
    }

    @Test
    public void testDiscountFor11000() {
        assertEquals("Wrong discount price", 9200, discountCalculator.calculateDiscountedPrice(11000), 0.5);
    }

    @Test
    public void testDiscountFor20000() {
        assertEquals("Wrong discount price", 15500, discountCalculator.calculateDiscountedPrice(20000), 0.5);
    }
}
