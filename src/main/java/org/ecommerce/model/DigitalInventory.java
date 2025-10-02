package org.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

public class DigitalInventory extends InventoryManager {

    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        if (product instanceof DigitalProduct) {
            products.add(product);
            System.out.println("Producto digital agregado: " + product.getName());
        } else {
            System.out.println("Solo se aceptan productos digitales en este inventario.");
        }
    }

    @Override
    public boolean removeProduct(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        if (removed) {
            System.out.println("🗑Producto digital eliminado con ID: " + id);
        } else {
            System.out.println("Producto digital no encontrado con ID: " + id);
        }
        return removed;
    }

    @Override
    public void updateStock(int id, int newStock) {
        boolean found = false;
        for (Product p : products) {
            if (p.getId() == id) {
                p.setStock(newStock);
                System.out.println("Stock actualizado para: " + p.getName() + " → " + newStock);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Producto digital no encontrado con ID: " + id);
        }
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No hay productos digitales en el inventario.");
        } else {
            System.out.println("Inventario de productos digitales:");
            for (Product p : products) {
                System.out.println(" - " + p);
            }
        }
    }
}
