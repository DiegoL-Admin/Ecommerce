package org.ecommerce.Model;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private String address;
    private String phoneNumber;
    private boolean premium;
    private List<Cart> carts = new ArrayList<>();

    public Client() {
        super();
    }

    public Client(String name, String email, String password, String address, String phoneNumber, boolean premium) {
        super(name, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.premium = premium;
    }

    public Client(String username, String password) {
        super(username, password);
        this.address = "";
        this.phoneNumber = "";
        this.premium = false;
    }

    public void addCart(Cart cart) {
        if (cart != null) {
            carts.add(cart);
            System.out.println("Carrito añadido correctamente al cliente " + getName());
        }
    }

    // Getters y Setters
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isPremium() { return premium; }
    public void setPremium(boolean premium) { this.premium = premium; }

    public List<Cart> getCarts() { return carts; }
    public void setCarts(List<Cart> carts) { this.carts = carts; }

    public double calculateDiscount(double total) {
        double finalPrice = premium ? total * 0.9 : total;
        System.out.println(premium ? "💎 Descuento premium aplicado (10%)" : "ℹ️ Cliente estándar, sin descuento");
        return finalPrice;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", premium=" + premium +
                ", address='" + address + '\'' +
                ", phone='" + phoneNumber + '\'' +
                ", carts=" + carts.size() +
                '}';
    }
}
