package com.shoppersstop.retail.product;

/**
 * Created by kaviyarasug on 24/03/17.
 *
 * Product is a final class which defines the list of products in the shop
 */
public final class Product {
    final private String productName;
    final private double productPrice;
    final private String productDescription;

    public Product(String productName, double productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
