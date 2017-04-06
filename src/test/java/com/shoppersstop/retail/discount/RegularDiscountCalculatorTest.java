package com.shoppersstop.retail.discount;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kaviyarasug on 25/03/17.
 */
public class RegularDiscountCalculatorTest {
    static final DiscountCalculator discountCalculator = RegularDiscountCalculator.getInstance();

    @Test
    public void testDiscountFor1000() {
        assertEquals("Wrong discount price", 1000, discountCalculator.calculateDiscountedPrice(1000), 0.5);
    }

    @Test
    public void testDiscountFor5000() {
        assertEquals("Wrong discount price", 5000, discountCalculator.calculateDiscountedPrice(5000), 0.5);
    }

    @Test
    public void testDiscountFor6000() {
        assertEquals("Wrong discount price", 5900, discountCalculator.calculateDiscountedPrice(6000), 0.5);
    }

    @Test
    public void testDiscountFor10000() {
        assertEquals("Wrong discount price", 9500, discountCalculator.calculateDiscountedPrice(10000), 0.5);
    }

    @Test
    public void testDiscountFor11000() {
        assertEquals("Wrong discount price", 10300, discountCalculator.calculateDiscountedPrice(11000), 0.5);
    }

    @Test
    public void testDiscountFor20000() {
        assertEquals("Wrong discount price", 17500, discountCalculator.calculateDiscountedPrice(20000), 0.5);
    }
}
