package com.shoppersstop.retail;

import com.shoppersstop.retail.customer.Customer;
import com.shoppersstop.retail.discount.PremiumDiscountCalculator;
import com.shoppersstop.retail.discount.RegularDiscountCalculator;
import com.shoppersstop.retail.product.Product;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

 import static org.junit.Assert.assertEquals;
 import static org.junit.Assert.assertTrue;

/**
 * Created by kaviyarasug on 25/03/17.
 */
public class ShoppingCartTest {

    private static final List<Product> products = new ArrayList<>();
    private static final Customer premiumCustomer = new Customer("Premium Customer", 1l, true);
    private static final Customer ordinaryCustomer = new Customer("Ordinary Customer", 2l);

    @BeforeClass
    public static void prePopulateProducts() {
        products.add(addProduct("Product100", 100));
        products.add(addProduct("Product200", 200));
        products.add(addProduct("Product300", 300));
        products.add(addProduct("Product400", 400));
        products.add(addProduct("Product500", 500));
        products.add(addProduct("Product600", 600));
        products.add(addProduct("Product700", 700));
        products.add(addProduct("Product800", 800));
        products.add(addProduct("Product900", 900));
        products.add(addProduct("Product1000", 1000));
    }

    private static Product addProduct(String product, double price) {
        return new Product(product, price, product);
    }

    //Test for premium Discounts
    @Test
    public void testPremiumDiscountWithBillAmountLessThan1000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(premiumCustomer);
        addToCart(cart, getProductForPrice(100), 5);
        assertEquals("Total Price mismatch", 500, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 450, cart.getDiscountedPrice(), 0.5d);
        assertTrue("PremiumDiscountCalculator expected", PremiumDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testPremiumDiscountWithBillAmount5000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(premiumCustomer);
        addToCart(cart, getProductForPrice(100), 5);
        addToCart(cart, getProductForPrice(200), 5);
        addToCart(cart, getProductForPrice(300), 5);
        addToCart(cart, getProductForPrice(400), 5);
        assertEquals("Total Price mismatch", 5000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 4500, cart.getDiscountedPrice(), 0.5d);
        assertTrue("PremiumDiscountCalculator expected", PremiumDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testPremiumDiscountWithBillAmount5500() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(premiumCustomer);
        addToCart(cart, getProductForPrice(100), 5);
        addToCart(cart, getProductForPrice(200), 5);
        addToCart(cart, getProductForPrice(300), 5);
        addToCart(cart, getProductForPrice(400), 5);
        addToCart(cart, getProductForPrice(500), 1);
        assertEquals("Total Price mismatch", 5500, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 4900, cart.getDiscountedPrice(), 0.5d);
        assertTrue("PremiumDiscountCalculator expected", PremiumDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testPremiumDiscountWithBillAmount10000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(premiumCustomer);
        //addToCart(cart, getProductForPrice(100), 5); //500
        addToCart(cart, getProductForPrice(200), 5); //1000
        addToCart(cart, getProductForPrice(300), 5); //1500
        addToCart(cart, getProductForPrice(400), 5); //2000
        addToCart(cart, getProductForPrice(500), 5); //2500
        addToCart(cart, getProductForPrice(600), 5); //3000
        assertEquals("Total Price mismatch", 10000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 8500, cart.getDiscountedPrice(), 0.5d);
        assertTrue("PremiumDiscountCalculator expected", PremiumDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testPremiumDiscountWithBillAmount11000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(premiumCustomer);
        addToCart(cart, getProductForPrice(100), 10); //1000
        addToCart(cart, getProductForPrice(200), 5); //1000
        addToCart(cart, getProductForPrice(300), 5); //1500
        addToCart(cart, getProductForPrice(400), 5); //2000
        addToCart(cart, getProductForPrice(500), 5); //2500
        addToCart(cart, getProductForPrice(600), 5); //3000
        assertEquals("Total Price mismatch", 11000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 9200, cart.getDiscountedPrice(), 0.5d);
        assertTrue("PremiumDiscountCalculator expected", PremiumDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testPremiumDiscountWithBillAmount20000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(premiumCustomer);
        addToCart(cart, getProductForPrice(100), 10); //1000
        addToCart(cart, getProductForPrice(200), 5); //1000
        addToCart(cart, getProductForPrice(300), 5); //1500
        addToCart(cart, getProductForPrice(400), 5); //2000
        addToCart(cart, getProductForPrice(500), 5); //2500
        addToCart(cart, getProductForPrice(600), 5); //3000
        addToCart(cart, getProductForPrice(1000), 9); //3000
        assertEquals("Total Price mismatch", 20000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 15500, cart.getDiscountedPrice(), 0.5d);
        assertTrue("PremiumDiscountCalculator expected", PremiumDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    //Test for regular discounts

    @Test
    public void testRegularDiscountWithBillAmountLessThan1000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(ordinaryCustomer);
        addToCart(cart, getProductForPrice(100), 5);
        assertEquals("Total Price mismatch", 500, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 500, cart.getDiscountedPrice(), 0.5d);
        assertTrue("RegularDiscountCalculator expected", RegularDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testRegularDiscountWithBillAmount5000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(ordinaryCustomer);
        addToCart(cart, getProductForPrice(100), 5);
        addToCart(cart, getProductForPrice(200), 5);
        addToCart(cart, getProductForPrice(300), 5);
        addToCart(cart, getProductForPrice(400), 5);
        assertEquals("Total Price mismatch", 5000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 5000, cart.getDiscountedPrice(), 0.5d);
        assertTrue("RegularDiscountCalculator expected", RegularDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testRegularDiscountWithBillAmount5500() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(ordinaryCustomer);
        addToCart(cart, getProductForPrice(100), 5);
        addToCart(cart, getProductForPrice(200), 5);
        addToCart(cart, getProductForPrice(300), 5);
        addToCart(cart, getProductForPrice(400), 5);
        addToCart(cart, getProductForPrice(500), 1);
        assertEquals("Total Price mismatch", 5500, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 5450, cart.getDiscountedPrice(), 0.5d);
        assertTrue("RegularDiscountCalculator expected", RegularDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testRegularDiscountWithBillAmount10000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(ordinaryCustomer);
        //addToCart(cart, getProductForPrice(100), 5); //500
        addToCart(cart, getProductForPrice(200), 5); //1000
        addToCart(cart, getProductForPrice(300), 5); //1500
        addToCart(cart, getProductForPrice(400), 5); //2000
        addToCart(cart, getProductForPrice(500), 5); //2500
        addToCart(cart, getProductForPrice(600), 5); //3000
        assertEquals("Total Price mismatch", 10000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 9500, cart.getDiscountedPrice(), 0.5d);
        assertTrue("RegularDiscountCalculator expected", RegularDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testRegularDiscountWithBillAmount11000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(ordinaryCustomer);
        addToCart(cart, getProductForPrice(100), 10); //1000
        addToCart(cart, getProductForPrice(200), 5); //1000
        addToCart(cart, getProductForPrice(300), 5); //1500
        addToCart(cart, getProductForPrice(400), 5); //2000
        addToCart(cart, getProductForPrice(500), 5); //2500
        addToCart(cart, getProductForPrice(600), 5); //3000
        assertEquals("Total Price mismatch", 11000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 10300, cart.getDiscountedPrice(), 0.5d);
        assertTrue("RegularDiscountCalculator expected", RegularDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    @Test
    public void testRegularDiscountWithBillAmount20000() {
        ShoppingCart cart = ShoppingCartFactory.createShoppingCart(ordinaryCustomer);
        addToCart(cart, getProductForPrice(100), 10); //1000
        addToCart(cart, getProductForPrice(200), 5); //1000
        addToCart(cart, getProductForPrice(300), 5); //1500
        addToCart(cart, getProductForPrice(400), 5); //2000
        addToCart(cart, getProductForPrice(500), 5); //2500
        addToCart(cart, getProductForPrice(600), 5); //3000
        addToCart(cart, getProductForPrice(1000), 9); //3000
        assertEquals("Total Price mismatch", 20000, cart.getTotalPrice(), 0.5d);
        assertEquals("Discounted Price mismatch", 17500, cart.getDiscountedPrice(), 0.5d);
        assertTrue("RegularDiscountCalculator expected", RegularDiscountCalculator.getInstance() == cart.getDiscountCalculator());
    }

    private static Product getProductForPrice(double price) {
        return products.stream().filter((Product p) -> p.getProductPrice() == price).limit(1).findFirst().get();
    }

    private static void addToCart(ShoppingCart shoppingCart, Product product, float quantity) {
        CartItem item = new CartItem(product, shoppingCart);
        item.setItemQuantity(quantity);
    }
}
