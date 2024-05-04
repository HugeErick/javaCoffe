package gui;

import javax.swing.*;
import java.awt.*;

public class GUI  {
    int numOfBtns = 3;
    private ButtonHandler[] buttonHandlers;
    public GUI() {
        Window window = new Window("Ponchito me la pela", 900, 900);
        buttonHandlers = new ButtonHandler[numOfBtns];

        for (int i = 0; i < numOfBtns; i++) {
            JButton button = new JButton("Button " + (i+1));
            buttonHandlers[i] = new ButtonHandler();
            button.addActionListener(buttonHandlers[i]);
            window.add(button);
        }

        window.pack();
        window.setVisible(true);
    }
}
