package com.shoppersstop.retail.customer;

/**
 * Created by kaviyarasug on 20/03/17.
 */
public class Customer {
    final String customerName;
    final Long customerId;
    final boolean isPremiumCustomer;

    public Customer(final String customerName, final Long customerId, Boolean isPremiumCustomer) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.isPremiumCustomer = isPremiumCustomer;
    }

    public Customer(final String customerName, final Long customerId) {
        this(customerName, customerId, false);
    }

    public String getCustomerName() {
        return customerName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public boolean isPremiumCustomer() {
        return isPremiumCustomer;
    }
}
