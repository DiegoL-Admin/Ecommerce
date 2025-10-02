package org.ecommerce.Service;

import org.ecommerce.Model.Client;
import org.ecommerce.Model.Administrator;
import org.ecommerce.Exception.NotFoundUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService();
        userService.registerClient("Ana", "ana@mail.com", "1234", "Calle 1", "0999999999", true);
        userService.registerAdmin("Admin", "admin@mail.com", "admin123", "superadmin", "TI");
    }

    @Test
    void loginCorrectoCliente() {
        assertDoesNotThrow(() -> {
            assertEquals("Ana", userService.login("Ana", "1234").getName());
        });
    }

    @Test
    void loginIncorrectoPassword() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            userService.login("Ana", "wrongpass");
        });
        assertEquals("Contraseña incorrecta.", ex.getMessage());
    }

    @Test
    void loginUsuarioNoExiste() {
        Exception ex = assertThrows(NotFoundUser.class, () -> {
            userService.login("Pepe", "1234");
        });
        assertTrue(ex.getMessage().contains("Usuario no encontrado"));
    }
}