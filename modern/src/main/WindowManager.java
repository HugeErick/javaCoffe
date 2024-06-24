package main;

import pages.LogicOfPages;

import javax.swing.*;

public class WindowManager {
    public WindowManager(JFrame window) {
        window.setResizable(false);
        window.setVisible(true);

        new LogicOfPages(window);
        window.setLocationRelativeTo(null);
    }
}
