package org.ecommerce.Service;

import org.ecommerce.Exception.NotFoundUser;
import org.ecommerce.Model.*;

import java.util.ArrayList;
import java.util.List;


public class UserService {

    private final List<User> users = new ArrayList<>();

    // ========================
    // Registro de usuarios
    // ========================

    public void registerClient(String name, String email, String password, String address, String phone, boolean premium) {
        Client client = new Client(name, email, password, address, phone, premium);
        users.add(client);
        System.out.println("Cliente registrado: " + client.getName());
    }

    public void registerAdmin(String name, String email, String password, String role, String department) {
        Administrator admin = new Administrator(name, email, password, role, department);
        users.add(admin);
        System.out.println("Administrador registrado: " + admin.getName());
    }

    public User findById(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User findByEmail(String email) {
        if (email == null) return null;
        return users.stream()
                .filter(u -> email.equalsIgnoreCase(u.getEmail()))
                .findFirst()
                .orElse(null);
    }
    public User findByName(String name) {
        if (name == null) return null;
        return users.stream()
                .filter(u -> name.equalsIgnoreCase(u.getEmail()))
                .findFirst()
                .orElse(null);
    }

    public User login(String nameOrEmail, String password) {
        if (nameOrEmail == null || password == null) {
            throw new IllegalArgumentException("Nombre/email y contraseña no pueden ser nulos.");
        }

        // Buscar usuario por nombre o email
        User user = users.stream()
                .filter(u -> nameOrEmail.equalsIgnoreCase(u.getName())
                        || (u.getEmail() != null && nameOrEmail.equalsIgnoreCase(u.getEmail())))
                .findFirst()
                .orElseThrow(() -> new NotFoundUser("Usuario no encontrado: " + nameOrEmail));

        if (!password.equals(user.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta.");
        }

        System.out.println("✅ Inicio de sesión exitoso. Bienvenido, " + user.getName());
        return user;
    }

    public boolean deleteUser(int id) {
        boolean removed = users.removeIf(u -> u.getId() == id);
        System.out.println(removed ? "🗑Usuario eliminado con ID: " + id : "Usuario no encontrado con ID: " + id);
        return removed;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("⚠No hay usuarios registrados.");
        } else {
            System.out.println("\nLista de usuarios:");
            users.forEach(System.out::println);
        }
    }
}

