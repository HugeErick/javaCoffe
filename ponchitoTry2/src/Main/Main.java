package Main;

import gui.Gui;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] arg) {
        String filePath = "ponchitoTry2/src/properties/db.properties";
        File file = new File(filePath);
        if (file.exists()) {
            SwingUtilities.invokeLater(() -> new Gui(1, null, null));
        } else {
            SwingUtilities.invokeLater(() -> new Gui(0, null, null));
        }
    }
}
