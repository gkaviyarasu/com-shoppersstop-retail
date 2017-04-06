package com.shoppersstop.retail.discount;

import com.shoppersstop.retail.utils.DataProvider;

import java.util.List;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class RegularDiscountCalculator implements DiscountCalculator {

    List<DiscountInfo> discountInfos;

    private final static DiscountCalculator instance = new RegularDiscountCalculator();

    public static DiscountCalculator getInstance() {
        return instance;
    }

    public RegularDiscountCalculator() {
        this(DataProvider.getDiscountInfos(false));
    }

    protected RegularDiscountCalculator(List<DiscountInfo> discountInfos) {
        this.discountInfos = discountInfos;
    }


    public double calculateDiscountedPrice(double totalPrice) {
        final DiscountAmount discountAmount = new DiscountAmount();
        discountInfos.forEach((DiscountInfo discountInfo) -> {
            double applicableAmt = (discountInfo.getToAmount() == -1) ||
                    (discountInfo.getToAmount() > totalPrice) ? totalPrice - discountInfo.getFromAmount()
                    : discountInfo.getToAmount() - discountInfo.getFromAmount();
            if (applicableAmt > 0) {
                double discount = applicableAmt * discountInfo.getDiscount();
                discountAmount.addAmount(discountInfo.getMaxDiscount() <0 || (discount < discountInfo.getMaxDiscount()) ?
                        discount : discountInfo.getMaxDiscount());
            }
        });
        return totalPrice - discountAmount.getAmount();
    }

    private class DiscountAmount {
        private double amount = 0;

        public double getAmount() {
            return amount;
        }

        public void addAmount(double amount) {
            this.amount += amount;
        }
    }
}
