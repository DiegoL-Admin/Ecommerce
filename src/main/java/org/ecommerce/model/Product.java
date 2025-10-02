package org.ecommerce.Model;

public abstract class Product {
    private static int counterId = 1;
    private int id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Product() {}

    public Product(String name, String description, double price, int stock) {
        this.id = counterId++; // ID autoincremental
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    //  Métodos abstractos (polimorfismo)
    public abstract String getProductType();
    public abstract double calculateShippingCost();

    //  Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + name +
                " | Tipo: " + getProductType() +
                " | Precio: $" + price +
                " | Stock: " + stock;
    }
}

