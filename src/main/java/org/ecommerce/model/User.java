package org.ecommerce.Model;

public class User {
    private static int contadorId = 1;
    private int id;
    private String name;
    private String email;
    private String password;

    public User() {}

    // Constructor completo
    public User(String name, String email, String password) {
        this.id = contadorId++;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Constructor alternativo
    public User(String username, String password) {
        this.id = contadorId++;
        this.name = username;
        this.password = password;
        this.email = "";
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
}