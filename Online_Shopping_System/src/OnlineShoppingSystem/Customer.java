package OnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private int customerId;
    private List<Product> cart;

    public Customer(String name, String email, String password, int customerId) {
        super(name, email, password);
        this.customerId = customerId;
        this.cart = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void addToCart(Product product) {
        cart.add(product);
    }

    public void removeFromCart(Product product) {
        cart.remove(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : cart) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public List<Product> getCart() {
        return cart;
    }
}
