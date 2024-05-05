package gui;

import login.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ButtonHandler implements ActionListener {
    public JButton[] buttons;
    public String filePath = "ponchito/src/properties/erickdb.properties";
    protected GUI gui;
    protected User user;
    private String url;
    private String dbName;
    private String username;
    private String password;
    private final String[] startMenuButtonsLabels = {"See circuits", "Query options", "Help", "Exit"};
    private final String[] LogInButtonsLabels= {"Log in"};
    public ButtonHandler(GUI gui, String urlField, String databaseField, String userField, String passwordField) {
        this.gui = gui;
        this.url = urlField;
        this.dbName = databaseField;
        this.username = userField;
        this.password = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String buttonLabel = clickedButton.getText();

        switch (buttonLabel) {
            case "Log in":
                Properties properties = new Properties();
                properties.setProperty("db.url", gui.theUrlField);
                properties.setProperty("db.name", gui.theDbNameField);
                properties.setProperty("db.user", gui.theUserField);
                properties.setProperty("db.password", gui.thePswField);

                // Create file name based on user input
                String fileName = user + "db.properties";

                // Define file path
                filePath = "ponchito/src/properties/" + fileName;

                // Write properties to file
                try (OutputStream output = new FileOutputStream(filePath)) {
                    properties.store(output, null);
                } catch (IOException IOe) {
                    IOe.printStackTrace();
                }


                user = new User(gui, true, filePath);
                break;
            case "See circuits":
                // Perform action for "See db" button
                System.out.println("See db button clicked!");
                break;
            case "Query options":
                // Perform action for "Make Query" button
                System.out.println("Make Query button clicked!");
                break;
            case "Help":
                // Perform action for "Help" button
                System.out.println("Help button clicked!");
                break;
            case "Exit":
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                // Handle unknown button label
                System.out.println("Unknown button clicked!");
                break;
        }
    }
    public void createButtons(int numberOfButtons) {
        buttons = new JButton[numberOfButtons];
       for (int i = 0; i < numberOfButtons; i++) {
           if (gui.scene == 1) {
               JButton button = new JButton(startMenuButtonsLabels[i]);
               Dimension buttonSizePreference = new Dimension(150, 35);
               button.setPreferredSize(buttonSizePreference);
               button.setMaximumSize(buttonSizePreference);
               button.setMinimumSize(buttonSizePreference);
               buttons[i] = button;
               button.addActionListener(this);
           } else if (gui.scene == 0) {
               JButton button = new JButton(LogInButtonsLabels[i]);
               Dimension buttonSizePreference = new Dimension(150, 35);
               button.setPreferredSize(buttonSizePreference);
               button.setMaximumSize(buttonSizePreference);
               button.setMinimumSize(buttonSizePreference);
               buttons[i] = button;
               button.addActionListener(this);
           }
       }
    }
}
