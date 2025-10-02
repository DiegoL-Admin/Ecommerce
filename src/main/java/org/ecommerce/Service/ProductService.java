package org.ecommerce.Service;

import org.ecommerce.Model.*;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public PhysicalProduct addPhysicalProduct(String name, String desc, double price, int stock,
                                              double weight, double width, double height, double depth) {
        PhysicalProduct p = new PhysicalProduct(name, desc, price, stock, weight, width, height, depth);
        products.add(p);
        System.out.println("Producto físico agregado: " + name);
        return p;
    }

    public DigitalProduct addDigitalProduct(String name, String desc, double price, int stock, double fileSize) {
        DigitalProduct p = new DigitalProduct(name, desc, price, stock, fileSize);
        products.add(p);
        System.out.println("Producto digital agregado: " + name);
        return p;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("⚠No hay productos disponibles.");
        } else {
            System.out.println("\nLista de productos:");
            products.forEach(System.out::println);
        }
    }

    public boolean remove(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        System.out.println(removed ? "🗑Producto eliminado con ID: " + id
                : "Producto no encontrado con ID: " + id);
        return removed;
    }

    // Buscar producto por ID
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
