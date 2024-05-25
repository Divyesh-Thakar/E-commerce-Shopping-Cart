import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void clearCart() {
        products.clear();
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }
}
