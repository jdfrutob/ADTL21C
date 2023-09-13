package OnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;


public class Seller extends User {

    private int sellerId;
    private List<Product> products;

    public Seller(String name, String email, String password, int sellerId) {
        super(name, email, password);
        this.sellerId = sellerId;
        this.products = new ArrayList<>();
    }

    public int getSellerId() {
        return sellerId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

