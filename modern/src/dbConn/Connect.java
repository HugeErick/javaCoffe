package dbConn;

import org.postgresql.ds.PGSimpleDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class Connect {
    protected final String PROPERTIESF = "modern/src/DbConn/db.properties";

    public Connect() {
        Properties properties = new Properties();
        try (BufferedReader reader =  new BufferedReader(new FileReader(PROPERTIESF))) {
            properties.load(reader);
        } catch (Exception e) {
            System.err.println("Error loading file " + e.getMessage());
            return;
        }
        String user = properties.getProperty("USERPOSTGRESQL");
        String psw = properties.getProperty("PSWSQL");

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setURL("jdbc:postgresql://ericks-portafolio-10350.6wr.aws-us-west-2.cockroachlabs.cloud:26257/defaultdb?sslmode=verify-full");
        ds.setUser(user);
        ds.setPassword(psw);

    }

}
