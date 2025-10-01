package org.ecommerce.Service;

import org.ecommerce.Model.Cart;
import org.ecommerce.Model.Product;
import org.ecommerce.Model.User;

public class CartService {

    public Cart createCart(User user) {
        return new Cart(1, user);
    }

    public void addProductToCart(Cart cart, Product product, int quantity) {
        if (product.getStock() < quantity) {
            System.out.println(" Stock insuficiente para " + product.getName());
            return;
        }
        cart.addProduct(product, quantity);
        product.setStock(product.getStock() - quantity);
        System.out.println(" Producto agregado: " + product.getName());
    }

    public void showCart(Cart cart) {
        System.out.println("\n Carrito de " + cart.getUser().getName() + ":");
        cart.getItems().forEach(item ->
                System.out.println("- " + item.getProduct().getName() + " x" + item.getQuantity() +
                        " = $" + (item.getProduct().getPrice() * item.getQuantity()))
        );
        System.out.println(" Total: $" + cart.calculateTotal());
    }
}