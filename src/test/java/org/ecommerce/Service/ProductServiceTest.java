package org.ecommerce.Service;

import org.ecommerce.Model.DigitalProduct;
import org.ecommerce.Model.PhysicalProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
    }

    @Test
    void agregarYBuscarProductoFisico() {
        PhysicalProduct p = productService.addPhysicalProduct("Laptop", "Gaming", 1200, 10, 2.5, 30, 2, 20);
        assertNotNull(p);
        assertEquals("Laptop", p.getName());
    }

    @Test
    void agregarYBuscarProductoDigital() {
        DigitalProduct p = productService.addDigitalProduct("Curso Java", "Aprende Java", 50, 100, 500);
        assertNotNull(p);
        assertEquals("Curso Java", p.getName());
        assertEquals(0.0, p.calculateShippingCost());
    }
}
