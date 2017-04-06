package com.shoppersstop.retail.discount;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class ZeroDiscountCalculator implements DiscountCalculator {

    private final static DiscountCalculator instance = new ZeroDiscountCalculator();

    public static DiscountCalculator getInstance() {
        return instance;
    }

    public double calculateDiscountedPrice(double price) {
        return price;
    }

    protected ZeroDiscountCalculator() {

    }
}
