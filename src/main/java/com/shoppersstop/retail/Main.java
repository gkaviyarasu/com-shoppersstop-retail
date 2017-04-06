package com.shoppersstop.retail;

import com.shoppersstop.retail.customer.Customer;
import com.shoppersstop.retail.product.Product;

import java.io.PrintWriter;

/**
 * Created by kaviyarasug on 20/03/17.
 */
public class Main {

    private final static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String args[]) {

        Product product1 = new Product("Perfume0", 1000, "rose Perfume");

        Customer premiumCustomer = new Customer("Kavi", 1l, true);
        ShoppingCart premiumCart = ShoppingCartFactory.createShoppingCart(premiumCustomer);

        addToCart(premiumCart, product1, 5);
        pw.println(" 1. "+premiumCart.getTotalPrice() + " " + premiumCart.getDiscountedPrice());

        addToCart(premiumCart, product1, 5);
        pw.println(" 2. "+premiumCart.getTotalPrice() + " " + premiumCart.getDiscountedPrice());

        addToCart(premiumCart, product1, 5);
        pw.println(" 3. "+premiumCart.getTotalPrice() + " " + premiumCart.getDiscountedPrice());

        Customer regularCustomer = new Customer("Kavi", 1l);
        ShoppingCart regularCart = ShoppingCartFactory.createShoppingCart(regularCustomer);

        pw.println();
        addToCart(regularCart, product1, 5);
        pw.println(" 1. "+regularCart.getTotalPrice() + " " + regularCart.getDiscountedPrice());

        addToCart(regularCart, product1, 5);
        pw.println(" 2. "+regularCart.getTotalPrice() + " " + regularCart.getDiscountedPrice());

        addToCart(regularCart, product1, 5);
        pw.println(" 3. "+regularCart.getTotalPrice() + " " + regularCart.getDiscountedPrice());

        pw.flush();

    }

    private static void addToCart(ShoppingCart shoppingCart, Product product, float quantity) {
        CartItem item = new CartItem(product, shoppingCart);
        item.setItemQuantity(quantity);
    }

}
