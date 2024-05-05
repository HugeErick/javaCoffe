package login;

import java.io.*;
import java.util.Properties;
public class User {
    static final String PROPERTIES_FILE = "ponchito/src/properties/erickdb.properties";
    private String url = null;
    private String dbName = null;
    private String user = null;
    private String password = null;
    public User(){
        fetchUserDbData();
    }

    private void fetchUserDbData() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(PROPERTIES_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Extract properties
        url = props.getProperty("db.url");
        dbName = props.getProperty("db.name");
        user = props.getProperty("db.user");
        password = props.getProperty("db.password");
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
