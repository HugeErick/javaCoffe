package login;

import gui.GUI;

import java.io.*;
import java.util.Properties;
public class User {
    protected GUI gui;
    static String PROPERTIES_FILE = "ponchito/src/properties/erickdb.properties";
    private String url = null;
    private String dbName = null;
    private String user = null;
    private String password = null;
    public boolean creditsPassed = false;
    public boolean loggedIn;
    public User(GUI gui, boolean loggedIn, String filepath){
        this.loggedIn = loggedIn;
        this.gui = gui;
        fetchUserDbData();
        if (!creditsPassed) {
            waitForSceneChangeTo1();
            PROPERTIES_FILE = filepath;
        } else {
            this.gui = new GUI(1);
        }
    }

    public User(GUI gui, boolean loggedIn) {
        this.loggedIn = loggedIn;
        this.gui = gui;
        fetchUserDbData();
        if (!creditsPassed) {
            waitForSceneChangeTo1();
        } else {
            this.gui = new GUI(1);
        }
    }

    public void fetchUserDbData() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(PROPERTIES_FILE));
            creditsPassed = true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, signing up");
            loggedIn = false;
            gui = new GUI(0);
        } catch (IOException e) {
            System.out.println("what?");
            throw new RuntimeException(e);

        }

        // Extract properties
        url = props.getProperty("db.url");
        dbName = props.getProperty("db.name");
        user = props.getProperty("db.user");
        password = props.getProperty("db.password");
    }

    public void waitForSceneChangeTo1() {
        while (!loggedIn) {
            try {
                Thread.sleep(100); // Wait for 100 milliseconds before checking again
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public String getUrl() {
        return url;
    }
    public String getDbName() {
        return dbName;
    }
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
