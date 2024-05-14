package main;

import dbConn.Connect;
import pages.Logic;

import javax.swing.*;

public class StartGame {
    public static JFrame window;

    public StartGame() {

        new Connect();

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("GUI skeleton");

        new Logic(window);

    }
}
