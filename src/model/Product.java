package model;

public abstract class Product {

    protected int id;
    protected String name;
    protected String category;
    protected double price;
    protected int quantity;

    // Constructor
    public Product(int id, String name, String category,
                   double price, int quantity) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Update stock
    public void updateStock(int quantity) {
        this.quantity += quantity;
    }

    // Abstract method
    public abstract void displayDetails();
}