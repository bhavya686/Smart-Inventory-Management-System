package main;

import ui.LoginFrame;

import thread.StockMonitorThread;

import util.AppSession;

public class Main {

    public static void main(String[] args) {

        // Start Background Thread
        StockMonitorThread monitor =
                new StockMonitorThread(
                        AppSession
                                .inventoryService
                                .getProducts()
                );

        monitor.start();

        // Launch GUI
        new LoginFrame();
    }
}