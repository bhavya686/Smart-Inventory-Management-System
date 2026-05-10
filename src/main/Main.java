package main;

import model.Electronics;
import model.Grocery;
import model.Clothing;

import service.InventoryService;
import service.ReportService;

import thread.StockMonitorThread;

public class Main {

        public static void main(String[] args) {

                InventoryService inventory = new InventoryService();

                // Start Background Stock Monitor
                StockMonitorThread monitor = new StockMonitorThread(
                                inventory.getProducts());

                monitor.start();

                try {

                        Electronics e1 = new Electronics(
                                        101,
                                        "Laptop",
                                        "Electronics",
                                        55000,
                                        10,
                                        24);

                        Grocery g1 = new Grocery(
                                        102,
                                        "Rice",
                                        "Grocery",
                                        1200,
                                        25,
                                        "12-12-2026");

                        Clothing c1 = new Clothing(
                                        103,
                                        "T-Shirt",
                                        "Clothing",
                                        799,
                                        15,
                                        "XL");

                        // Add products
                        inventory.addProduct(e1);
                        inventory.addProduct(g1);
                        inventory.addProduct(c1);

                        System.out.println(
                                        "\nALL PRODUCTS\n");

                        inventory.displayAllProducts();

                        // Create Report Service
                        ReportService reports = new ReportService(
                                        inventory.getProducts());

                        System.out.println(
                                        "\nTOTAL INVENTORY VALUE\n");

                        System.out.println(
                                        reports.calculateTotalInventoryValue());

                        System.out.println(
                                        "\nTOTAL PRODUCT COUNT\n");

                        System.out.println(
                                        reports.getTotalProductCount());

                        reports.generateLowStockReport();

                        reports.generateCategorySummary();

                        // Update quantity
                        inventory.updateProductQuantity(
                                        101,
                                        50);

                        // Update price
                        inventory.updateProductPrice(
                                        103,
                                        999);

                        System.out.println(
                                        "\nSEARCH PRODUCT BY ID\n");

                        inventory.searchProductById(101);

                        System.out.println(
                                        "\nSEARCH PRODUCT BY NAME\n");

                        inventory.searchProductByName(
                                        "Rice");

                        // Delete Product
                        inventory.deleteProduct(102);

                        System.out.println(
                                        "\nFINAL PRODUCT LIST\n");

                        inventory.displayAllProducts();
                }

                catch (Exception e) {

                        System.out.println(
                                        "Error: " + e.getMessage());
                }
        }
}