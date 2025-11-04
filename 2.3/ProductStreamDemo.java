//3part
import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - ₹" + price;
    }
}

public class ProductStreamDemo {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 75000, "Electronics"),
            new Product("Phone", 50000, "Electronics"),
            new Product("TV", 60000, "Electronics"),
            new Product("Rice", 1500, "Grocery"),
            new Product("Wheat", 1200, "Grocery"),
            new Product("Jeans", 2500, "Clothing"),
            new Product("Shirt", 1800, "Clothing")
        );

        // 1️⃣ Group by Category
        Map<String, List<Product>> byCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        System.out.println("\nProducts Grouped by Category:");
        byCategory.forEach((cat, list) -> {
            System.out.println(cat + " -> " + list);
        });

        // 2️⃣ Most Expensive Product per Category
        Map<String, Optional<Product>> mostExpensive = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));
        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensive.forEach((cat, prod) -> 
            System.out.println(cat + " -> " + prod.get())
        );

        // 3️⃣ Average Price of All Products
        double avgPrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: ₹" + avgPrice);
    }
}
