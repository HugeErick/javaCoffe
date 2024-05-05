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
        this.sharedDbUsername = sharedDbUsername;
        loadPrivilegeMultiplexorScene();
    }

    public void loadPrivilegeMultiplexorScene() {
        String viewAsUser = "User";
        String viewAsEmployee = "Employee";
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

        JButton userModeButton = new JButton(viewAsUser);
        userModeButton.addActionListener(e -> {
            this.window.dispose();
            gui = new Gui(4, sharedDbUsername, viewAsUser);
        });
        userModeButton.setPreferredSize(buttonSizePreference);
        userModeButton.setMaximumSize(buttonSizePreference);
        userModeButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(userModeButton);

        JButton employeeModeButton = new JButton(viewAsEmployee);
        employeeModeButton.addActionListener(e -> {
            this.window.dispose();
            this.gui = new Gui(3, sharedDbUsername, viewAsEmployee);
        });
        employeeModeButton.setPreferredSize(buttonSizePreference);
        employeeModeButton.setMaximumSize(buttonSizePreference);
        employeeModeButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(employeeModeButton);


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
