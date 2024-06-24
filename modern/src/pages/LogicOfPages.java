package pages;

import main.MainPanel;

import javax.swing.*;

public class LogicOfPages {
    public LogicOfPages(JFrame window) {
        MainPanel mainPanel = new MainPanel();
        LoginPage loginPage = new LoginPage(mainPanel);
        window.add(mainPanel);
        window.add(loginPage);
        window.pack();

        mainPanel.setUpGame();
        mainPanel.startGameThread();
    }
}
