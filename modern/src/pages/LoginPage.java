package pages;

import panels.ButtonPanel;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private final Dimension loginPageDimension;

    public LoginPage(Dimension dimension) {
        int width = dimension.width - 40;
        int height = dimension.height - 40;
        loginPageDimension = new Dimension(width, height);
        this.setPreferredSize(loginPageDimension);
        this.setBackground(Color.gray);
        startLoginPage();
    }

    private void startLoginPage() {
        String[] buttonsTitle = {"Login"};

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(loginPageDimension);
        mainPanel.setBackground(this.getBackground());

        // Create panels for the sides

        // Adjust side panel width
        int sidePanelWidth = loginPageDimension.width / 6;
        JPanel sidePanelLeft = new JPanel();
        sidePanelLeft.setPreferredSize(new Dimension(sidePanelWidth, loginPageDimension.height));
        sidePanelLeft.setBackground(this.getBackground());

        JPanel sidePanelRight = new JPanel();
        sidePanelRight.setPreferredSize(new Dimension(sidePanelWidth, loginPageDimension.height));
        sidePanelRight.setBackground(this.getBackground());

        ButtonPanel buttonPanel = new ButtonPanel(1, buttonsTitle);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(sidePanelLeft, BorderLayout.WEST);
        mainPanel.add(sidePanelRight, BorderLayout.EAST);

        this.add(mainPanel);
    }
}
