package main;
import gui.GUI;

import javax.swing.*;

public class Main {
    public static void main(String[] arg)  {
        SwingUtilities.invokeLater(GUI::new);
    }
}
