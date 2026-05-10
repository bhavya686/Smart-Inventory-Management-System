package thread;

import model.Product;

import java.util.ArrayList;

public class StockMonitorThread extends Thread {

    private ArrayList<Product> products;

    // Constructor
    public StockMonitorThread(
            ArrayList<Product> products) {

        this.products = products;
    }

    @Override
    public void run() {

        while(true) {

            try {

                for(Product p : products) {

                    if(p.getQuantity() < 10) {

                        System.out.println(
                                "\nWARNING: Low stock for product -> "
                                        + p.getName()
                        );
                    }
                }

                // Delay for 5 seconds
                Thread.sleep(5000);
            }

            catch(InterruptedException e) {

                System.out.println(
                        "Thread interrupted."
                );
            }
        }
    }
}