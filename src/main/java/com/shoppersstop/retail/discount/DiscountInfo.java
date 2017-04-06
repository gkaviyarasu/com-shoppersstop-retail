package com.shoppersstop.retail.discount;

import java.util.Date;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class DiscountInfo {
    private double fromAmount;
    private double toAmount;
    private float discount;
    private Date validTill;
    private double maxDiscount;
    private boolean premiumDiscount;

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }

    public double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public boolean isPremiumDiscount() {
        return premiumDiscount;
    }

    public void setPremiumDiscount(boolean premiumDiscount) {
        this.premiumDiscount = premiumDiscount;
    }
}
