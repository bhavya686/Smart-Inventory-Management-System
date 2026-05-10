package model;

public class Grocery extends Product {

    private String expiryDate;

    public Grocery(int id, String name, String category,
                   double price, int quantity,
                   String expiryDate) {

        super(id, name, category, price, quantity);

        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void displayDetails() {

        System.out.println("Grocery Product");

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Expiry Date: " + expiryDate);
    }
}