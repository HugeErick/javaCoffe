import javax.swing.*;
import java.awt.*;

public class MyGUI extends JFrame {
    private ButtonHandler[] btnHandlers;

    public MyGUI(int numButtons) {
        super("Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        // Initialize array of ButtonHandlers
        btnHandlers = new ButtonHandler[numButtons];

        // Create buttons and assign ButtonHandlers
        for (int i = 0; i < numButtons; i++) {
            JButton button = new JButton("Button " + (i + 1));
            btnHandlers[i] = new ButtonHandler();
            button.addActionListener(btnHandlers[i]);
            add(button);
        }

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyGUI(3));
    }
}
