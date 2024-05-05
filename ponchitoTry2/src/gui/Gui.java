package gui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gui  {
    protected int scene;
    private String dbName;
    private String dbPassword;
    private String dbUrl;
    private String dbUser;
    public Gui(int whatScene) {

        scene = whatScene;
        switch (scene) {
        case 0:
            Window window0 = new Window("Ponchito me la pela", 500, 500);
            new LoginPage(window0, this);
            break;
        case 1:
            //autenticamos
            Properties properties = readPropertiesFile("ponchitoTry2/src/properties/db.properties");
            if (properties != null) {
                dbName = properties.getProperty("db.name");
                dbPassword = properties.getProperty("db.password");
                dbUrl = properties.getProperty("db.url");
                dbUser = properties.getProperty("db.user");

                System.out.println("dbname: " + dbName);
                System.out.println("dbpassword: " + dbPassword);
                System.out.println("dburl: " + dbUrl);
                System.out.println("dbuser: " + dbUser);

            } else {
                System.err.println("Failed to read properties file.");
            }
            //comenzamos transaccion
            TransactionMySQL transactionMySQL = new TransactionMySQL(dbUrl, dbUser, dbPassword);
            Window window1 = new Window("Ponchito me la pela", 500, 500);
            new Home(window1, this);
            break;
        default:
            System.out.println("no scene for this");
            System.exit(1);
        }
    }
    public Properties readPropertiesFile(String filename) {
        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Ignore comments and empty lines
                if (!line.trim().startsWith("#") && !line.trim().isEmpty()) {
                    // Replace escaped characters
                    line = line.replaceAll("\\\\", "");
                    // Use regular expression to split key-value pairs
                    Pattern pattern = Pattern.compile("^([^=]*)=(.*)$");
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        String key = matcher.group(1).trim();
                        String value = matcher.group(2).trim();
                        properties.setProperty(key, value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return properties;
    }
}
