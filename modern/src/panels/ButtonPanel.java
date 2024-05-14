package panels;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public JPanel obtainedResult;
    private final GridBagConstraints gridBagConstraints;
    public ButtonPanel(int numButtons, String[] buttonTitle) {
        this.setPreferredSize(new Dimension(100, 200));
        this.setBackground(Color.CYAN);

        obtainedResult = new JPanel(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        this.add(obtainedResult);

        if (numButtons == 1)
            oneButtonPanel(buttonTitle);
        else if (numButtons == 2) {
            ;
        }
    }

    private void oneButtonPanel(String[] buttonsTitles) {
        JButton buttonA;
        if (!buttonsTitles[0].isEmpty()) {
            buttonA = new JButton(buttonsTitles[0]);
        } else {
            buttonA = new JButton("Button A");
        }
        obtainedResult.add(buttonA, gridBagConstraints);
    }
}
