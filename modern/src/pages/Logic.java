package pages;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Logic {
    public Logic(JFrame window) {
        GamePanel gamePanel = new GamePanel();
        LoginPage loginPage = new LoginPage(new Dimension(gamePanel.screenWidthForMax, gamePanel.screenHeightForMax));
        window.add(gamePanel);

        if (gamePanel.fullScreenOn)
            window.setUndecorated(true);

        gamePanel.add(loginPage);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
