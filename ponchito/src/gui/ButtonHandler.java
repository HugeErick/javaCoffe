package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {
    public JButton[] buttons;

    private final String[] startMenuButtonsLabels = {"See db", "Make Query", "Help", "Exit"};
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
    public void createButtons(int numberOfButtons) {
        buttons = new JButton[numberOfButtons];
       for (int i = 0; i < numberOfButtons; i++) {
           JButton button = new JButton(startMenuButtonsLabels[i]);
           Dimension buttonSizePreference = new Dimension(150, 35);
           button.setPreferredSize(buttonSizePreference);
           button.setMaximumSize(buttonSizePreference);
           button.setMinimumSize(buttonSizePreference);
           buttons[i] = button;
           button.addActionListener(this);
       }
    }
}
