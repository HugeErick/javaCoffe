import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //connection var
        Connection mConnection = null;
        // vars
        Statement theStatement = null;
        ResultSet resultSet = null;
        try {
            //dbs credentials
            String url = "jdbc:mariadb://localhost:3306/sample";
            String user = "massiveAnalizer";
            String passw = "Cripsy1Cripsy1";

            //create connection
            mConnection = DriverManager.getConnection(url, user, passw);

            System.out.println("Connected to dbs");

            //create statement
            theStatement = mConnection.createStatement();

            resultSet = theStatement.executeQuery("show tables;");

            //process result set
            System.out.println("tables in dbs:\n");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        } finally {
            //close connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (theStatement != null) {
                    theStatement.close();
                }

                if (mConnection != null) {
                    mConnection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
