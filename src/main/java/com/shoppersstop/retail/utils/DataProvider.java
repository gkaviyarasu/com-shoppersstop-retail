package com.shoppersstop.retail.utils;

import com.shoppersstop.retail.discount.DiscountInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class DataProvider {
    private static final List<DiscountInfo> discountInfos = new ArrayList<DiscountInfo>();

    static {
        discountInfos.add(getDiscountInfoObject(0.10f, 0, 5000, true));
        discountInfos.add(getDiscountInfoObject(0.20f, 5001, 10000, true));
        discountInfos.add(getDiscountInfoObject(0.30f, 10001, -1, true));
        discountInfos.add(getDiscountInfoObject(0.10f, 5001, 10000, false));
        discountInfos.add(getDiscountInfoObject(0.20f, 10001, -1, false));
    }

    private static DiscountInfo getDiscountInfoObject(float discount, double fromAmount, double toAmount, boolean premium) {
        DiscountInfo d = new DiscountInfo();
        d.setDiscount(discount);
        d.setFromAmount(fromAmount);
        d.setToAmount(toAmount);
        d.setMaxDiscount(-1);
        d.setPremiumDiscount(premium);
        d.setValidTill(new Date(new Date().getTime() + 100000));
        return d;
    }


    public static List<DiscountInfo> getDiscountInfos(final boolean isPremium) {
        return discountInfos.stream().filter(
                (DiscountInfo d) -> d.isPremiumDiscount() == isPremium && d.getValidTill().after(new Date()))
                .collect(Collectors.toList());
    }
}
