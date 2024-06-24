package main;

import dbConn.Connect;

import javax.swing.*;

public class StartGui {
    public static JFrame window;

    public StartGui() {

        //db connection
        new Connect();

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("GUI skeleton");

        new WindowManager(window);

    }
}
