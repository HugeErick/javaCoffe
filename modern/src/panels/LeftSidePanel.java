package panels;

import javax.swing.*;
import java.awt.*;

public class LeftSidePanel extends JPanel {
    public LeftSidePanel(JPanel parent, Dimension dimension) {
        super();
        this.setPreferredSize(dimension);
        this.setBackground(parent.getBackground());
        this.setLayout(new GridBagLayout());
    }
}
