package org.ecommerce.Model;

import org.ecommerce.Exception.InsufficientInventory;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private User user;
    private String name;
    private List<CartItem> items = new ArrayList<>();

    // Constructores
    public Cart() {}

    public Cart(int id, User user) {
        this.id = id;
        this.user = user;
    }

    public Cart(int id, User user, List<CartItem> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    public Cart(int id, User user, String name, List<CartItem> items) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.items = items;
    }

    // ✅ Agregar producto al carrito
    public void addProduct(Product product, int quantity) throws InsufficientInventory {
        if (product.getStock() < quantity) {
            throw new InsufficientInventory("❌ Inventario insuficiente para: " + product.getName());
        }

        // Reducimos el stock del producto
        product.setStock(product.getStock() - quantity);

        // Si el producto ya está en el carrito, simplemente aumentamos la cantidad
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }

        // Si no está en el carrito, lo agregamos como nuevo CartItem
        items.add(new CartItem(product, quantity));
    }

    // ✅ Eliminar producto por ID
    public void removeProduct(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    // ✅ Calcular total del carrito
    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    // ✅ Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + (user != null ? user.getName() : "N/A") +
                ", total=$" + calculateTotal() +
                ", items=" + items.size() +
                '}';
    }
}