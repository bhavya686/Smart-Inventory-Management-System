package service;

import model.Product;
import exception.DuplicateProductException;
import exception.InvalidProductException;

import java.util.ArrayList;

public class InventoryService {

    private ArrayList<Product> products;

    // Constructor
    public InventoryService() {
        products = util.FileUtil.loadProducts();
    }

    // Add Product
    public void addProduct(Product product)
            throws DuplicateProductException,
            InvalidProductException {

        // Validate price
        if (product.getPrice() <= 0) {
            throw new InvalidProductException(
                    "Price cannot be zero or negative.");
        }

        // Validate quantity
        if (product.getQuantity() < 0) {
            throw new InvalidProductException(
                    "Quantity cannot be negative.");
        }

        // Check duplicate ID
        for (Product p : products) {

            if (p.getId() == product.getId()) {

                throw new DuplicateProductException(
                        "Product ID already exists.");
            }
        }

        products.add(product);
        util.FileUtil.saveProducts(products);

        System.out.println("Product added successfully.");
    }

    // Update Product Quantity
    public void updateProductQuantity(
            int productId,
            int newQuantity) {

        boolean found = false;

        for (Product p : products) {

            if (p.getId() == productId) {

                p.setQuantity(newQuantity);

                found = true;

                util.FileUtil.saveProducts(products);

                System.out.println(
                        "Product quantity updated.");

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Product not found.");
        }
    }

    // Update Product Price
    public void updateProductPrice(
            int productId,
            double newPrice) {

        boolean found = false;

        for (Product p : products) {

            if (p.getId() == productId) {

                p.setPrice(newPrice);

                found = true;

                util.FileUtil.saveProducts(products);

                System.out.println(
                        "Product price updated.");

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Product not found.");
        }
    }

    // Delete Product
    public void deleteProduct(int productId) {

        Product productToRemove = null;

        for (Product p : products) {

            if (p.getId() == productId) {

                productToRemove = p;

                break;
            }
        }

        if (productToRemove != null) {

            products.remove(productToRemove);

            util.FileUtil.saveProducts(products);

            System.out.println(
                    "Product deleted successfully.");
        }

        else {

            System.out.println(
                    "Product not found.");
        }
    }

    // Search Product By ID
    public void searchProductById(int productId) {

        boolean found = false;

        for (Product p : products) {

            if (p.getId() == productId) {

                p.displayDetails();

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Product not found.");
        }
    }

    // Search Product By Name
    public void searchProductByName(
            String productName) {

        boolean found = false;

        for (Product p : products) {

            if (p.getName()
                    .equalsIgnoreCase(productName)) {

                p.displayDetails();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "Product not found.");
        }
    }

    // View all products
    public void displayAllProducts() {

        for (Product p : products) {
            p.displayDetails();

            System.out.println();
        }
    }

    // Getter
    public ArrayList<Product> getProducts() {
        return products;
    }
}