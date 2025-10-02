package org.ecommerce.Model;

public class DigitalProduct extends Product {
    private double fileSize;

    public DigitalProduct() {}

    public DigitalProduct( String name, String description, double price, int stock, double fileSize) {
        super( name, description, price, stock);
        this.fileSize = fileSize;
    }

    @Override
    public String getProductType() {
        return "Digital";
    }

    @Override
    public double calculateShippingCost() {
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Tamaño del archivo: " + fileSize + " MB" +
                " | Envío: N/A";
    }
    public double getFileSize() { return fileSize; }
    public void setFileSize(double fileSize) { this.fileSize = fileSize; }
}
