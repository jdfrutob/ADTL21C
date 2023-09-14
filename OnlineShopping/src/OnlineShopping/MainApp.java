package OnlineShopping;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // Create instances of Customer, Seller, and Product classes
        Customer customer1 = new Customer("Jd", "jd@example.com", "password123", 1);
        Seller seller1 = new Seller("Lance", "seller1@example.com", "sellerpassword", 101);
        Product product1 = new Product(1, "Flava Oxbar", 450.0);

        // Add products to the seller's product list
        seller1.addProduct(product1);

        // Add products to the customer's cart
        customer1.addToCart(product1);

        // Create a scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Customer menu
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Cart");
            System.out.println("2. Checkout");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayCart(customer1);
                    break;
                case 2:
                    double totalPrice = customer1.calculateTotalPrice();
                    if (checkout(customer1, totalPrice)) {
                        System.out.println("Checkout successful!");
                    } else {
                        System.out.println("Insufficient balance. Please remove some items from the cart.");
                    }
                    break;
                case 3:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    // Helper method to display the items in the customer's cart
    private static void displayCart(Customer customer) {
        System.out.println("\nItems in Cart:");
        List<Product> cart = customer.getCart();
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Product product : cart) {
                System.out.println("Product ID: " + product.getProductId() +
                        ", Product Name: " + product.getProductName() +
                        ", Price: $" + product.getPrice());
            }
        }
    }

    // Helper method to simulate the checkout process
    private static boolean checkout(Customer customer, double totalPrice) {
        // In a real system, you would deduct the totalPrice from the customer's balance here
        // For this example, let's assume the customer always has enough balance
        List<Product> cart = customer.getCart();
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return false;
        } else {
            // Clear the cart after successful checkout
            cart.clear();
            return true;
        }
    }
}