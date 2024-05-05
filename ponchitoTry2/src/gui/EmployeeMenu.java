package gui;

import javax.swing.*;
import java.awt.*;

public class EmployeeMenu {
    public Window window;
    protected static Gui gui;
    public TransactionMySQL transactionMySQL;
    public String sharedDbUsername;

    public EmployeeMenu(Window window, Gui gui, TransactionMySQL transactionMySQL, String sharedDbUsername) {
        this.window = window;
        LoginPage.gui = gui;
        this.transactionMySQL = transactionMySQL;
        this.sharedDbUsername = sharedDbUsername;

        loadMenuScene();
    }

    public void loadMenuScene() {
        //centered panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setPreferredSize(new Dimension(400, 400));
        centerPanel.setBackground(Color.gray);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        window.add(centerPanel);

        //buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        // Add some empty space above the buttonPanel to center vertically
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add Show Circuits button
        JButton showCircuitsButton = new JButton("Reserve trip");
        showCircuitsButton.addActionListener(e -> {
            // Handle Show Circuits button action here
        });
        //margin buttons
        Dimension buttonSizePreference = new Dimension(150, 35);
        showCircuitsButton.setPreferredSize(buttonSizePreference);
        showCircuitsButton.setMaximumSize(buttonSizePreference);
        showCircuitsButton.setMinimumSize(buttonSizePreference);
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(showCircuitsButton);

        // Add Query Options button
        JButton queryOptionsButton = new JButton("Make simulation");
        queryOptionsButton.addActionListener(e -> {
            // Handle Query Options button action here
        });
        queryOptionsButton.setPreferredSize(buttonSizePreference);
        queryOptionsButton.setMaximumSize(buttonSizePreference);
        queryOptionsButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(queryOptionsButton);

        // Add Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            this.window.dispose();
            gui = new Gui(1, sharedDbUsername);
        });
        exitButton.setPreferredSize(buttonSizePreference);
        exitButton.setMaximumSize(buttonSizePreference);
        exitButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(exitButton);



        // Add buttonPanel to centerPanel
        centerPanel.add(buttonPanel, gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add some empty space below the buttonPanel
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        buttonPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(sharedDbUsername),
                        BorderFactory.createEmptyBorder(
                                5,5,5,5)));



        window.pack();
        window.setVisible(true);
    }
}
