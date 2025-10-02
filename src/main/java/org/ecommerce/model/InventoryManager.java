package org.ecommerce.Model;

/**
 * Clase abstracta que define el contrato para la gestión de inventario
 */
public abstract class InventoryManager {
    public abstract void addProduct(Product product);

    public abstract boolean removeProduct(int id);

    public abstract void updateStock(int id, int newStock);

    public void welcomeMessage() {
        System.out.println("📦 Bienvenido al gestor de inventario.");
    }
}