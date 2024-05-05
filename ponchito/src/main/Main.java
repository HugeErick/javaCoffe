package main;
import gui.ButtonHandler;
import gui.GUI;

import javax.swing.*;

public class Main {
    public static TransactionMySQL transactionMySQL;
    protected static GUI gui;
    protected static ButtonHandler buttonHandler;
    public static void main(String[] arg) {
        transactionMySQL = new TransactionMySQL(gui);
        SwingUtilities.invokeLater(() -> new GUI(1));
    }
}
