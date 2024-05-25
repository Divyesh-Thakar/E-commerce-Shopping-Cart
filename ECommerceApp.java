import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {
    private static List<Product> products;
    private static ShoppingCart cart;
    private static Scanner scanner;

    public static void main(String[] args) {
        products = new ArrayList<>();
        cart = new ShoppingCart();
        scanner = new Scanner(System.in);

        initializeProducts();
        showMenu();
    }

    private static void initializeProducts() {
        products.add(new Product(1, "Laptop", 999.99));
        products.add(new Product(2, "Smartphone", 599.99));
        products.add(new Product(3, "Tablet", 299.99));
        products.add(new Product(4, "Headphones", 89.99));
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n1. View Products");
            System.out.println("2. View Cart");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    viewCart();
                    break;
                case 3:
                    addProductToCart();
                    break;
                case 4:
                    removeProductFromCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void viewCart() {
        System.out.println("\nShopping Cart:");
        if (cart.getProducts().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println(cart);
            System.out.println("Total: $" + cart.getTotalPrice());
        }
    }

    private static void addProductToCart() {
        System.out.print("Enter the product ID to add to cart: ");
        int productId = scanner.nextInt();
        Product product = findProductById(productId);
        if (product != null) {
            cart.addProduct(product);
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void removeProductFromCart() {
        System.out.print("Enter the product ID to remove from cart: ");
        int productId = scanner.nextInt();
        Product product = findProductById(productId);
        if (product != null) {
            cart.removeProduct(product);
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void checkout() {
        if (cart.getProducts().isEmpty()) {
            System.out.println("Your cart is empty. Add some products first.");
        } else {
            System.out.println("\nCheckout");
            System.out.println(cart);
            System.out.println("Total: $" + cart.getTotalPrice());
            System.out.print("Do you want to complete the purchase? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                cart.clearCart();
                System.out.println("Purchase completed. Thank you!");
            } else {
                System.out.println("Checkout cancelled.");
            }
        }
    }

    private static Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
