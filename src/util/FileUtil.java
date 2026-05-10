package util;

import model.Product;
import model.Electronics;
import model.Grocery;
import model.Clothing;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    private static final String FILE_PATH =
            "data/products.txt";

    // Save Products
    public static void saveProducts(
            ArrayList<Product> products) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_PATH)
                    );

            for(Product p : products) {

                String line = "";

                if(p instanceof Electronics e) {

                    line =
                            "Electronics," +
                            e.getId() + "," +
                            e.getName() + "," +
                            e.getCategory() + "," +
                            e.getPrice() + "," +
                            e.getQuantity() + "," +
                            e.getWarrantyPeriod();

                }

                else if(p instanceof Grocery g) {

                    line =
                            "Grocery," +
                            g.getId() + "," +
                            g.getName() + "," +
                            g.getCategory() + "," +
                            g.getPrice() + "," +
                            g.getQuantity() + "," +
                            g.getExpiryDate();

                }

                else if(p instanceof Clothing c) {

                    line =
                            "Clothing," +
                            c.getId() + "," +
                            c.getName() + "," +
                            c.getCategory() + "," +
                            c.getPrice() + "," +
                            c.getQuantity() + "," +
                            c.getSize();
                }

                writer.write(line);

                writer.newLine();
            }

            writer.close();

            System.out.println(
                    "Products saved to file."
            );

        }

        catch(IOException e) {

            System.out.println(
                    "File Save Error: "
                    + e.getMessage()
            );
        }
    }

    // Load Products
    public static ArrayList<Product> loadProducts() {

        ArrayList<Product> products =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String type = data[0];

                int id =
                        Integer.parseInt(data[1]);

                String name = data[2];

                String category = data[3];

                double price =
                        Double.parseDouble(data[4]);

                int quantity =
                        Integer.parseInt(data[5]);

                switch(type) {

                    case "Electronics":

                        int warranty =
                                Integer.parseInt(data[6]);

                        products.add(
                                new Electronics(
                                        id,
                                        name,
                                        category,
                                        price,
                                        quantity,
                                        warranty
                                )
                        );

                        break;

                    case "Grocery":

                        String expiryDate =
                                data[6];

                        products.add(
                                new Grocery(
                                        id,
                                        name,
                                        category,
                                        price,
                                        quantity,
                                        expiryDate
                                )
                        );

                        break;

                    case "Clothing":

                        String size =
                                data[6];

                        products.add(
                                new Clothing(
                                        id,
                                        name,
                                        category,
                                        price,
                                        quantity,
                                        size
                                )
                        );

                        break;
                }
            }

            reader.close();

            System.out.println(
                    "Products loaded from file."
            );
        }

        catch(IOException e) {

            System.out.println(
                    "No existing product file found."
            );
        }

        return products;
    }
}