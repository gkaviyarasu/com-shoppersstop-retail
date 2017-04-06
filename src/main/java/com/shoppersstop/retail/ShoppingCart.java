package com.shoppersstop.retail;

import com.shoppersstop.retail.customer.Customer;
import com.shoppersstop.retail.discount.DiscountCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class ShoppingCart {
    final private List<CartItem> cartItems = new ArrayList<CartItem>();
    final private Customer customer;
    private DiscountCalculator discountCalculator;
    private double totalPrice;

    public ShoppingCart(Customer customer, DiscountCalculator discountCalculator) {
        this.customer = customer;
        this.discountCalculator = discountCalculator;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(CartItem cartItem) {
        removeItem(cartItem);
        cartItems.add(cartItem);
        totalPrice = totalPrice + cartItem.getItemPrice() * cartItem.getItemQuantity();
    }

    public void removeItem(CartItem cartItem) {
        if (cartItems.contains(cartItem)) {
            cartItems.remove(cartItem);
            totalPrice = totalPrice - cartItem.getItemPrice() * cartItem.getItemQuantity();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscountedPrice() {
        return discountCalculator.calculateDiscountedPrice(totalPrice);
    }

    public DiscountCalculator getDiscountCalculator() {
        return discountCalculator;
    }

    public void setDiscountCalculator(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public Customer getCustomer() {
        return customer;
    }
}
