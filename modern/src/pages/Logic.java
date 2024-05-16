package pages;

import main.MainPanel;

import javax.swing.*;

public class Logic {
    public Logic(JFrame window) {
        MainPanel mainPanel = new MainPanel();
        LoginPage loginPage = new LoginPage(mainPanel);
        window.add(mainPanel);
        window.add(loginPage);
        if (mainPanel.fullScreenOn) {
            window.setUndecorated(true);
        }
        window.pack();

        mainPanel.setUpGame();
        mainPanel.startGameThread();
    }
}
