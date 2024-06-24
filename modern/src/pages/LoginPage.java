package pages;

import main.MainPanel;
import panels.ButtonPanel;
import panels.CenterPanel;
import panels.LeftSidePanel;
import panels.RightSidePanel;

import javax.swing.*;
import java.awt.*;

import static graphix.icons.IconsMultiplexor.getReadMeIcon;
import static graphix.icons.IconsMultiplexor.getRegisterIcon;

public class LoginPage extends JPanel {
    private final Dimension loginPageDimension;
    private final int ymargin = 20;
    private final int xmargin = 5;

    public LoginPage(MainPanel mainPanel) {
        loginPageDimension = new Dimension(mainPanel.screenWidthForMax, mainPanel.screenHeightForMax);
        this.setPreferredSize(loginPageDimension);
        this.setBackground(mainPanel.getBackground());
        this.setLayout(new GridBagLayout());
        startLoginPage();
    }

    private void startLoginPage() {
        int sidePanelWidth = loginPageDimension.width / 6;
        Dimension dimension = new Dimension(sidePanelWidth, loginPageDimension.height);

        // left panel
        LeftSidePanel leftSidePanel = new LeftSidePanel(this, dimension);
        this.add(leftSidePanel, leftPanelConstrains());
        addIcon(leftSidePanel, getRegisterIcon());

        //center & button panel
        CenterPanel centerPanel = new CenterPanel(30);
        this.add(centerPanel, centerPanelConstrains());

        //right side panel
        RightSidePanel rightSidePanel = new RightSidePanel(this, dimension);
        this.add(rightSidePanel, rightPanelConstrains());
        addIcon(rightSidePanel, getReadMeIcon());
    }

    private void addIcon(JPanel panel, int iconCase) {
        ButtonPanel sampleButton = new ButtonPanel(panel, iconCase);
        panel.add(sampleButton, iconLayoutConstrains());
    }

    private GridBagConstraints iconLayoutConstrains() {
        GridBagConstraints iconLayoutConstrains = new GridBagConstraints();
        iconLayoutConstrains.gridx = 0;
        iconLayoutConstrains.gridy = 1;
        iconLayoutConstrains.weightx = 1.0;
        iconLayoutConstrains.weighty = 1.0;
        iconLayoutConstrains.anchor = GridBagConstraints.SOUTH;
        iconLayoutConstrains.fill = GridBagConstraints.HORIZONTAL;
        iconLayoutConstrains.insets =  new Insets(0, 0 , 50, 0);
        return iconLayoutConstrains;
    }

    private GridBagConstraints rightPanelConstrains() {
        GridBagConstraints rightPanelConstrains =  new GridBagConstraints();
        rightPanelConstrains.fill = GridBagConstraints.BOTH;
        rightPanelConstrains.gridx = 3;
        rightPanelConstrains.gridy = 0;
        rightPanelConstrains.weightx = 0.2;
        rightPanelConstrains.weighty = 1.0;
        rightPanelConstrains.insets = new Insets(ymargin, 0, ymargin, xmargin);
        return rightPanelConstrains;
    }

    private GridBagConstraints leftPanelConstrains() {
        GridBagConstraints leftPanelConstrains =  new GridBagConstraints();
        leftPanelConstrains.fill = GridBagConstraints.BOTH;
        leftPanelConstrains.gridx = 1;
        leftPanelConstrains.gridy = 0;
        leftPanelConstrains.weightx = 0.2;
        leftPanelConstrains.weighty = 1.0;
        leftPanelConstrains.insets = new Insets(ymargin, xmargin, ymargin, 0);
        return leftPanelConstrains;
    }

    private GridBagConstraints centerPanelConstrains() {
        GridBagConstraints centerPanelConstrains =  new GridBagConstraints();
        centerPanelConstrains.fill = GridBagConstraints.BOTH;
        centerPanelConstrains.gridx = 2;
        centerPanelConstrains.gridy = 0;
        centerPanelConstrains.weightx = 0.8;
        centerPanelConstrains.weighty = 1.0;
        centerPanelConstrains.insets = new Insets(ymargin, 0, ymargin, 0);
        return centerPanelConstrains;
    }
}
