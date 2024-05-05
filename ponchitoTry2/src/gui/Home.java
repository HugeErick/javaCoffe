package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class Home {
    protected Window window;
    protected Gui gui;
    public  TransactionMySQL transactionMySQL;
    public String sharedDbUsername;

    public Home(Window window, Gui gui, TransactionMySQL transactionMySQL) {
        this.window = window;
        this.gui = gui;
        this.transactionMySQL = transactionMySQL;
        sharedDbUsername = transactionMySQL.username;
        loadHomeScene();
    }
    public void loadHomeScene() {
        //centered panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setPreferredSize(new Dimension(400, 400));
        centerPanel.setBackground(Color.gray);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        window.add(centerPanel);

        //buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        // Add some empty space above the buttonPanel to center vertically
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add Show Circuits button
        JButton showCircuitsButton = getjButton();
        //margin buttons
        Dimension buttonSizePreference = new Dimension(150, 35);
        showCircuitsButton.setPreferredSize(buttonSizePreference);
        showCircuitsButton.setMaximumSize(buttonSizePreference);
        showCircuitsButton.setMinimumSize(buttonSizePreference);
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(showCircuitsButton);

        // Add Query Options button
        JButton queryOptionsButton = new JButton("Query Options");
        queryOptionsButton.addActionListener(e -> {
            // Handle Query Options button action here
            this.window.dispose();
            gui = new Gui(2, sharedDbUsername, null);
        });
        queryOptionsButton.setPreferredSize(buttonSizePreference);
        queryOptionsButton.setMaximumSize(buttonSizePreference);
        queryOptionsButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(queryOptionsButton);

        // Add Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            System.exit(0); // For simplicity, exiting the application
        });
        exitButton.setPreferredSize(buttonSizePreference);
        exitButton.setMaximumSize(buttonSizePreference);
        exitButton.setMinimumSize(buttonSizePreference);
        //margin buttons
        buttonPanel.add(Box.createVerticalStrut(14));
        buttonPanel.add(exitButton);



        // Add buttonPanel to centerPanel
        centerPanel.add(buttonPanel, gridBagConstraints);
        gridBagConstraints.gridy++;

        // Add some empty space below the buttonPanel
        centerPanel.add(Box.createVerticalGlue(), gridBagConstraints);
        buttonPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(transactionMySQL.username),
                        BorderFactory.createEmptyBorder(
                                5,5,5,5)));



        window.pack();
        window.setVisible(true);
    }

    private JButton getjButton() {
        JButton showCircuitsButton = new JButton("Show Circuits");
        showCircuitsButton.addActionListener(e -> {
            //show query table in new Jframe
            try {
                ResultSet resultSet;
                try {
                    resultSet = transactionMySQL.executeQuery("select * from Ciudad");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                // Create a new JFrame to display the query results
                JFrame resultFrame = new JFrame("Query Results");
                JTable table = new JTable(buildTableModel(resultSet));
                JScrollPane scrollPane = new JScrollPane(table);
                resultFrame.add(scrollPane);
                resultFrame.pack();
                resultFrame.setVisible(true);

                transactionMySQL.close(); // Close the connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        return showCircuitsButton;
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // Names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // Data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(rs.getObject(columnIndex));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

}
