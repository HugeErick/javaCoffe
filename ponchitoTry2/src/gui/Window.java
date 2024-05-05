package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(String title, int width, int height) {
        setTitle(title);
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
