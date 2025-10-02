package org.ecommerce.Factory;

import org.ecommerce.Model.*;
public class EntityFactory {

    public static Product newProduct(String tipo, String nombre, String descripcion, double precio, int stock, double... datos) {
        return switch (tipo.toLowerCase()) {
            case "fisico" -> new PhysicalProduct( nombre, descripcion, precio, stock, datos[0], datos[1], datos[2], datos[3]);
            case "digital" -> new DigitalProduct(nombre, descripcion, precio, stock, datos[0]);
            default -> throw new IllegalArgumentException("Tipo de producto no reconocido: " + tipo);
        };
    }


    public static User newUser(String tipo, String username, String password) {
        return switch (tipo.toLowerCase()) {
            case "cliente" -> new Client(username, password);
            case "admin" -> new Administrator(username, password);
            default -> throw new IllegalArgumentException("Tipo de usuario no reconocido: " + tipo);
        };
    }
}
