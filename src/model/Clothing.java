package model;

public class Clothing extends Product {

    private String size;

    public Clothing(int id, String name, String category,
                    double price, int quantity,
                    String size) {

        super(id, name, category, price, quantity);

        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public void displayDetails() {

        System.out.println("Clothing Product");

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Size: " + size);
    }
}