package org.ecommerce.Service;

import org.ecommerce.Exception.InsufficientInventory;
import org.ecommerce.Model.Cart;
import org.ecommerce.Model.CartItem;
import org.ecommerce.Model.Product;
import org.ecommerce.Model.User;

public class CartService {

    private static int nextCartId = 1; // Generador de IDs para carritos

    public Cart createCart(User user) {
        Cart cart = new Cart(nextCartId++, user);
        System.out.println("🛒 Nuevo carrito creado para: " + user.getName());
        return cart;
    }


    public void addProductToCart(Cart cart, Product product, int quantity) throws InsufficientInventory {
        if (product.getStock() < quantity) {
            throw new InsufficientInventory("Stock insuficiente para: " + product.getName());
        }
        cart.addProduct(product, quantity);

        System.out.println("Producto agregado al carrito: " + product.getName() + " x" + quantity);
    }

    public void showCart(Cart cart) {
        System.out.println("\nCarrito de " + cart.getUser().getName() + ":");
        if (cart.getItems().isEmpty()) {
            System.out.println("⚠El carrito está vacío.");
        } else {
            for (CartItem item : cart.getItems()) {
                System.out.println("- " + item.getProduct().getName() +
                        " x" + item.getQuantity() +
                        " = $" + (item.getProduct().getPrice() * item.getQuantity()));
            }
            System.out.println("Total: $" + cart.calculateTotal());
        }
    }
}
