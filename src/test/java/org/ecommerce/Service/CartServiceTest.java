package org.ecommerce.Service;

import org.ecommerce.Exception.InsufficientInventory;
import org.ecommerce.Model.Cart;
import org.ecommerce.Model.Client;
import org.ecommerce.Model.PhysicalProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    private CartService cartService;
    private Client cliente;
    private PhysicalProduct producto;

    @BeforeEach
    void setup() {
        cartService = new CartService();
        cliente = new Client("Ana", "ana@mail.com", "1234", "Calle 1", "0999999999", true);
        producto = new PhysicalProduct("Laptop", "Gaming", 1200, 10, 2.5, 30, 2, 20);
    }

    @Test
    void agregarProductoCarritoCorrectamente() throws InsufficientInventory {
        Cart cart = cartService.createCart(cliente);
        cartService.addProductToCart(cart, producto, 2);
        assertEquals(2, cart.getItems().get(0).getQuantity());
        assertEquals(8, producto.getStock());
    }

    @Test
    void agregarProductoCarritoStockInsuficiente() {
        Cart cart = cartService.createCart(cliente);
        Exception ex = assertThrows(InsufficientInventory.class, () -> {
            cartService.addProductToCart(cart, producto, 20);
        });
        assertTrue(ex.getMessage().contains("Stock insuficiente"));
    }
}