package gui;

import javax.swing.*;
import java.awt.*;

public class UserMenu {
    public Window window;
    protected Gui gui;
    public TransactionMySQL transactionMySQL;
    public String sharedDbUsername;
    public String viewAs;

    public UserMenu(Window window, Gui gui, TransactionMySQL transactionMySQL, String sharedDbUsername, String viewAs) {
        this.window = window;
        this.gui = gui;
        this.transactionMySQL = transactionMySQL;
        this.sharedDbUsername = sharedDbUsername;
        this.viewAs = viewAs;
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

        //add view as text
        JLabel label = new JLabel("view as: " + viewAs);
        centerPanel.add(label, gridBagConstraints);
        gridBagConstraints.gridy++;


        //buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        // Add some empty space above the buttonPanel to center vertically
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        gridBagConstraints.gridy++;

        Dimension buttonSizePreference = new Dimension(150, 35);

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
            gui = new Gui(1, sharedDbUsername, null);
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
