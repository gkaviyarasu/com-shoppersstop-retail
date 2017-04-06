package com.shoppersstop.retail.discount;

import com.shoppersstop.retail.utils.DataProvider;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class PremiumDiscountCalculator extends RegularDiscountCalculator implements DiscountCalculator {

    private final static DiscountCalculator instance = new PremiumDiscountCalculator();

    public static DiscountCalculator getInstance() {
        return instance;
    }

    public PremiumDiscountCalculator() {
        super(DataProvider.getDiscountInfos(true));
    }
}
