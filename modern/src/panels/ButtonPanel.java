package panels;

import graphix.RoundedBorder;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public JPanel obtainedResult;
    protected Color panelColor;


    public ButtonPanel(JPanel father, int iconCase) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        panelColor = father.getBackground();
        this.setBackground(panelColor);
        this.setLayout(gridBagLayout);

        obtainedResult = new JPanel(new GridBagLayout());
        iconButton(iconCase);

        this.add(obtainedResult);
    }

    private void iconButton(int iconCase) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(40, 40));
        button.setBackground(panelColor);
        button.setBorder(new RoundedBorder(20));
        switch (iconCase) {
            case 0:
                //Register Icon;
            case 1:
                //Readme Icon;
        }
        obtainedResult.add(button);
    }

}
