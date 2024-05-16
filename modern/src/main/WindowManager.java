package main;

import pages.Logic;

import javax.swing.*;

public class WindowManager {
    public WindowManager(JFrame window) {
        window.setResizable(false);
        window.setVisible(true);
        new Logic(window);
        window.setLocationRelativeTo(null);
    }
}
