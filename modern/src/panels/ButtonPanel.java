package panels;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    public JPanel obtainedResult;

    public ButtonPanel(JPanel father) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setBackground(father.getBackground());
        this.setLayout(gridBagLayout);

        obtainedResult = new JPanel(new GridBagLayout());
        iconButton();

        this.add(obtainedResult);
    }
    public ButtonPanel(int numButtons, String[] buttonTitle, JPanel father) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        this.setBackground(father.getBackground());
        this.setLayout(gridBagLayout);

        obtainedResult = new JPanel(new GridBagLayout());

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
        obtainedResult.add(buttonA);
    }

    private void iconButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(40, 40));
        obtainedResult.add(button);
    }
}
