package main;
import gui.GUI;
//import menu.OpenTransactionMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] arg) {
        SwingUtilities.invokeLater(GUI::new);
//        new OpenTransactionMenu();
    }
}
