import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WindowExample extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Window Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align components inside the panel

        JButton button = new JButton("Click Me");
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
