package gui;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class LoginPage {
    public Window window;
    protected static Gui gui;

    public LoginPage(Window window, Gui gui) {
        this.window = window;
        LoginPage.gui = gui;
        loadLoginScene();
    }
    public void loadLoginScene () {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setPreferredSize(new Dimension(400, 400));
        centerPanel.setBackground(Color.gray);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        window.add(centerPanel);
        // Add line of text
        JLabel label = new JLabel("Please insert your localhost of MariaDB data:");
        centerPanel.add(label, gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add text fields
        JTextField databaseField = new JTextField(30);
        JTextField userField = new JTextField(30);
        JPasswordField passwordField = new JPasswordField(30);

        gridBagConstraints.gridy++;
        centerPanel.add(new JLabel("Database name:"), gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(databaseField, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(new JLabel("User:"), gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(userField, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(new JLabel("Password:"), gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(passwordField, gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add some empty space between text fields and buttons
        centerPanel.add(Box.createVerticalStrut(10), gridBagConstraints);
        gridBagConstraints.gridy++;

        //buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        // Add some empty space above the buttonPanel to center vertically
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add log in button
        JButton loginButton = getLogInjButton(databaseField, userField, passwordField);
        buttonPanel.add(loginButton);
        // adding button panel
        centerPanel.add(buttonPanel, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);


        window.pack();
        window.setVisible(true);
    }

    private JButton getLogInjButton(JTextField databaseField, JTextField userField, JPasswordField passwordField) {
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            Properties properties = getProperties(databaseField, userField, passwordField);


            // Write properties to file
            try (PrintWriter writer = new PrintWriter(new FileWriter("ponchitoTry2/src/properties/db.properties"))) {
                properties.store(writer, null);
                System.out.println("sampledb.properties file generated successfully.");
            } catch (IOException IOe) {
                IOe.printStackTrace();
            }
            this.window.dispose();
            gui = new Gui(1, userField.getText(), null);
        });
        return loginButton;
    }

    private static Properties getProperties(JTextField databaseField, JTextField userField, JPasswordField passwordField) {
        String database = databaseField.getText();
        String user = userField.getText();
        String password = new String(passwordField.getPassword());
        String dbUrl = "jdbc:mariadb://localhost:3306/" + database;

        Properties properties = new Properties();
        properties.setProperty("db.url", dbUrl);
        properties.setProperty("db.name", database);
        properties.setProperty("db.user", user);
        properties.setProperty("db.password", password);
        return properties;
    }
}
