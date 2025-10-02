package org.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

public class PhysicalInventory extends InventoryManager {

    private final List<Product> physicalProducts = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        if (product instanceof PhysicalProduct) {
            physicalProducts.add(product);
            System.out.println("Producto físico añadido: " + product.getName());
        } else {
            System.out.println("Solo se pueden añadir productos físicos a este inventario.");
        }
    }

    @Override
    public boolean removeProduct(int id) {
        boolean removed = physicalProducts.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("🗑Producto eliminado con ID: " + id);
        } else {
            System.out.println("Producto no encontrado con ID: " + id);
        }
        return removed;
    }

    @Override
    public void updateStock(int id, int quantity) {
        boolean found = false;
        for (Product product : physicalProducts) {
            if (product.getId() == id) {
                int newStock = product.getStock() + quantity;
                product.setStock(newStock);
                System.out.println("🔄 Stock actualizado para " + product.getName() + ": " + newStock);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Producto no encontrado con ID: " + id);
        }
    }

    public void listProducts() {
        if (physicalProducts.isEmpty()) {
            System.out.println("No hay productos físicos en el inventario.");
        } else {
            System.out.println("Inventario de productos físicos:");
            for (Product p : physicalProducts) {
                System.out.println(" - " + p);
            }
        }
    }
    public void showMessage(String message) {
        System.out.println(message);
    }
}