package Main;

import gui.Gui;

import javax.swing.*;

public class Main {
    public static void main(String[] arg) {
//        transactionMySQL = new TransactionMySQL(gui);
        SwingUtilities.invokeLater(() -> new Gui(0));
    }
}
