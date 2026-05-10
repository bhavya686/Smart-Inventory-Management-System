package model;

public class Electronics extends Product {

    private int warrantyPeriod;

    public Electronics(int id, String name, String category,
                       double price, int quantity,
                       int warrantyPeriod) {

        super(id, name, category, price, quantity);

        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public void displayDetails() {

        System.out.println("Electronics Product");

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Warranty: " + warrantyPeriod + " months");
    }
}