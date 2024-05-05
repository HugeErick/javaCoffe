package gui;


import main.Main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class GUI  {
    public JPanel buttonPanel;
    protected Window window;

    public String theUrlField;
    public String theDbNameField;
    public String theUserField;
    public String thePswField;

    public int scene;

    public GUI(int whatScene) {
        scene = whatScene;
        window = new Window("Ponchito me la pela", 500, 500);
        switch (scene) {
            case 0:
                loadLoginScene();
                break;
            case 1:
                loadStartScene();
                break;
            default:
                System.out.println("no scene for this");
                System.exit(1);
        }
    }

    protected void loadStartScene() {

        int numberOfButtonsAtStartMenu = 4;
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
        ButtonHandler buttonHandler = new ButtonHandler(this, theUrlField, theDbNameField, theUserField, thePswField);
        buttonHandler.createButtons(numberOfButtonsAtStartMenu);
        addButtons(buttonHandler.buttons);

        // adding button panel
        centerPanel.add(buttonPanel, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);

        centerPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(Main.transactionMySQL.username),
                        BorderFactory.createEmptyBorder(
                                15,15,6,6)));

        // packing
        window.pack();
        window.setVisible(true);
    }

    protected void loadLoginScene(){
        int numberOfButtonsAtLogIn = 1;
        JPanel centerPanel = new JPanel(new GridBagLayout());
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
        JTextField urlField = new JTextField(20);
        JTextField databaseField = new JTextField(20);
        JTextField userField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        centerPanel.add(new JLabel("URL:"), gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(urlField, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(new JLabel("Database:"), gridBagConstraints);
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

        // Add DocumentListeners to update the fields when text changes
        urlField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                theUrlField = urlField.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                theUrlField = urlField.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });

        databaseField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                theDbNameField = databaseField.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                theDbNameField = databaseField.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });

        userField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                theUserField = userField.getText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                theUserField = userField.getText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
            }
        });

        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                thePswField = new String(passwordField.getPassword());
           }

           @Override
           public void removeUpdate(DocumentEvent e) {
                thePswField = new String(passwordField.getPassword());
           }

          @Override
          public void changedUpdate(DocumentEvent e) {
                // Plain text components do not fire these events
         }
        });

        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        // Add some empty space above the buttonPanel to center vertically
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        gridBagConstraints.gridy++;

        //adding buttons
        ButtonHandler buttonHandler = new ButtonHandler(this, theUrlField, theDbNameField, theUserField, thePswField);
        buttonHandler.createButtons(numberOfButtonsAtLogIn);
        addButtons(buttonHandler.buttons);


        // adding button panel
        centerPanel.add(buttonPanel, gridBagConstraints);
        gridBagConstraints.gridy++;
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);


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
