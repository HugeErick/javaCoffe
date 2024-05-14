package main;

import javax.swing.*;

public class StartGame {
    public static JFrame window;

    public StartGame() {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("GUI skeleton");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        if (gamePanel.fullScreenOn)
            window.setUndecorated(true);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.setUpGame();
        gamePanel.startGameThread();
    }
}
