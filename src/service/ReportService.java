package service;

import model.Product;

import java.util.ArrayList;

public class ReportService {

    private ArrayList<Product> products;

    // Constructor
    public ReportService(
            ArrayList<Product> products) {

        this.products = products;
    }

    // Total Inventory Value
    public double calculateTotalInventoryValue() {

        double totalValue = 0;

        for(Product p : products) {

            totalValue +=
                    p.getPrice() *
                    p.getQuantity();
        }

        return totalValue;
    }

    // Total Product Count
    public int getTotalProductCount() {

        return products.size();
    }

    // Low Stock Report
    public void generateLowStockReport() {

        boolean found = false;

        System.out.println(
                "\nLOW STOCK PRODUCTS\n"
        );

        for(Product p : products) {

            if(p.getQuantity() < 10) {

                p.displayDetails();

                System.out.println();

                found = true;
            }
        }

        if(!found) {

            System.out.println(
                    "No low stock products."
            );
        }
    }

    // Category-wise Product Count
    public void generateCategorySummary() {

        int electronics = 0;
        int grocery = 0;
        int clothing = 0;

        for(Product p : products) {

            switch(p.getCategory()) {

                case "Electronics":
                    electronics++;
                    break;

                case "Grocery":
                    grocery++;
                    break;

                case "Clothing":
                    clothing++;
                    break;
            }
        }

        System.out.println(
                "\nCATEGORY SUMMARY\n"
        );

        System.out.println(
                "Electronics Products: "
                        + electronics
        );

        System.out.println(
                "Grocery Products: "
                        + grocery
        );

        System.out.println(
                "Clothing Products: "
                        + clothing
        );
    }
}