package com.shoppersstop.retail;

import com.shoppersstop.retail.product.Product;

/**
 * Created by kaviyarasug on 24/03/17.
 */
public class CartItem {
    final private Product product;
    private float itemQuantity;
    final private ShoppingCart shoppingCart;
    private double itemTotal;

    public CartItem(Product product, ShoppingCart shoppingCart) {
        this.product = product;
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public String getItemName() {
        return product.getProductName();
    }

    public String getItemDescription() {
        return product.getProductDescription();
    }

    public float getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(float itemQuantity) {
        if(this.itemQuantity > 0) {
            shoppingCart.removeItem(this);
        }
        this.itemQuantity = itemQuantity;
        this.itemTotal = product.getProductPrice()* this.itemQuantity;
        shoppingCart.addItem(this);

    }

    public double getItemPrice() {
        return product.getProductPrice();
    }

    public double getItemTotal() {
        return itemTotal;
    }
}
