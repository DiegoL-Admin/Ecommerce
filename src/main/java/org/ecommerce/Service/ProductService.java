package org.ecommerce.Service;


import org.ecommerce.Model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Productos iniciales de ejemplo
        products.add(new Product(1, "Laptop", "Laptop i7 16GB RAM", 1200.0, 10));
        products.add(new Product(2, "Smartphone", "Android 5G", 800.0, 20));
        products.add(new Product(3, "Mouse", "Mouse inalámbrico", 25.0, 50));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}