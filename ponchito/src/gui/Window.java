package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
