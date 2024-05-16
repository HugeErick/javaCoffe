package panels;

import javax.swing.*;
import java.awt.*;

public class RightSidePanel extends JPanel {
    public RightSidePanel(JPanel parent, Dimension dimension) {
        super();
        this.setPreferredSize(dimension);
        this.setBackground(parent.getBackground());
        this.setLayout(new GridBagLayout());
    }
}
