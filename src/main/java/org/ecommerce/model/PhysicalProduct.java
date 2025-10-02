package org.ecommerce.Model;

public class PhysicalProduct extends Product {
    private double weight;
    private double width;
    private double height;
    private double depth;

    public PhysicalProduct() {}

    public PhysicalProduct(String name, String description, double price, int stock,
                           double weight, double width, double height, double depth) {
        super(name, description, price, stock);
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public String getProductType() {
        return "Físico";
    }

    @Override
    public double calculateShippingCost() {
        double volume = width * height * depth;
        double shippingCost = 5.0 + (weight * 2.5) + (volume * 0.001);
        return Math.round(shippingCost * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Peso: " + weight + "kg" +
                " | Volumen: " + (width * height * depth) + " cm³" +
                " | Envío: $" + calculateShippingCost();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }
}
