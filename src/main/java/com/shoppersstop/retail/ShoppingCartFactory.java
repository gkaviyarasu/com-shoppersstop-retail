package com.shoppersstop.retail;

import com.shoppersstop.retail.customer.Customer;
import com.shoppersstop.retail.discount.PremiumDiscountCalculator;
import com.shoppersstop.retail.discount.RegularDiscountCalculator;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class ShoppingCartFactory {
    public static ShoppingCart createShoppingCart(Customer customer) {
        if(customer.isPremiumCustomer()) {
            return new ShoppingCart(customer, PremiumDiscountCalculator.getInstance());
        } else {
            return new ShoppingCart(customer, RegularDiscountCalculator.getInstance());
        }
    }
}