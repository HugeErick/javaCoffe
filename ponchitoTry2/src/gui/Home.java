package gui;

import javax.swing.*;
import java.awt.*;

public class Home {
    protected Window window;
    protected Gui gui;

    public Home(Window window, Gui gui) {
        this.window = window;
        this.gui = gui;
        loadHomeScene();
    }
    public void loadHomeScene() {
        //centered panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
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
        JButton showCircuitsButton = new JButton("Show Circuits");
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
        JButton queryOptionsButton = new JButton("Query Options");
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
            System.exit(0); // For simplicity, exiting the application
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
        centerPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("lol"),
                        BorderFactory.createEmptyBorder(
                                15,15,15,15)));



        window.pack();
        window.setVisible(true);
    }
}
