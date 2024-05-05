package gui;

import javax.swing.*;
import java.awt.*;

public class PrivilegeMultiplexor {
    protected Gui gui;
    protected Window window;
    public TransactionMySQL transactionMySQL;
    public String sharedDbUsername;

    public PrivilegeMultiplexor(Gui gui, Window window, TransactionMySQL transactionMySQL, String sharedDbUsername) {
        this.gui = gui;
        this.window = window;
        this.transactionMySQL = transactionMySQL;
        sharedDbUsername = sharedDbUsername;
        loadPrivilegeMultiplexorScene();
    }

    public void loadPrivilegeMultiplexorScene() {
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

        Dimension buttonSizePreference = new Dimension(150, 35);

        // Add Query Options button
        JButton userModeButton = new JButton("User");
        userModeButton.addActionListener(e -> {
            this.window.dispose();
            gui = new Gui(4, sharedDbUsername);
        });
        userModeButton.setPreferredSize(buttonSizePreference);
        userModeButton.setMaximumSize(buttonSizePreference);
        userModeButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(userModeButton);


        // Add Query Options button
        JButton employeeModeButton = new JButton("Employee");
        employeeModeButton.addActionListener(e -> {
            this.window.dispose();
            gui = new Gui(3, sharedDbUsername);
        });
        employeeModeButton.setPreferredSize(buttonSizePreference);
        employeeModeButton.setMaximumSize(buttonSizePreference);
        employeeModeButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(employeeModeButton);


        // Add Query Options button
        JButton devModeButton = new JButton("dev");
        devModeButton.addActionListener(e -> {
            this.window.dispose();
            gui = new Gui(3, sharedDbUsername);
        });
        devModeButton.setPreferredSize(buttonSizePreference);
        devModeButton.setMaximumSize(buttonSizePreference);
        devModeButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(devModeButton);

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
