package org.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private User user; // el usuario dueño del carrito
    private List<CartItem> items = new ArrayList<>();

    public Cart() {}

    public Cart(int id, User user) {
        this.id = id;
        this.user = user;
    }

    // Métodos para manipular el carrito
    public void addProduct(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeProduct(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    @Override
    public String toString() {
        return "Cart{id=" + id + ", user=" + user.getName() + ", total=" + calculateTotal() + "}";
    }
}
