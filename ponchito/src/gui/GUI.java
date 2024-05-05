package gui;


import login.User;
import main.TransactionMySQL;

import javax.swing.*;
import java.awt.*;

public class GUI  {
    public JPanel buttonPanel;

    public GUI() {
        TransactionMySQL transactionMySQL = new TransactionMySQL();
        int numberOfButtonsAtStartMenu = 4;

        Window window = new Window("Ponchito me la pela", 500, 500);

        //centered panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        window.add(centerPanel);

        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        // Add some empty space above the buttonPanel to center vertically
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        gridBagConstraints.gridy++;

        //adding buttons
        ButtonHandler buttonHandler = new ButtonHandler();
        buttonHandler.createButtons(numberOfButtonsAtStartMenu);
        addButtons(buttonHandler.buttons);

        // adding button panel
        centerPanel.add(buttonPanel, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);

        centerPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(transactionMySQL.username),
                        BorderFactory.createEmptyBorder(
                                15,15,6,6)));

        // packing
        window.pack();
        window.setVisible(true);
    }
    public void addButtons(@org.jetbrains.annotations.NotNull JButton[] buttons) {
        for (JButton button : buttons) {
            buttonPanel.add(button);
            buttonPanel.add(Box.createVerticalStrut(14));
        }
    }
}
