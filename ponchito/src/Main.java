import java.sql.SQLException;

public class Main {
    public static void main(String[] arg) throws Exception {
        TransactionMySQL transaction = new TransactionMySQL();
        new GUI();
        System.exit(0);
            while( true )
                try {
                    if( ! transaction.menu() )
                        break;
                } catch( Exception e ) {

                    System.err.println( "failed" );
                    e.printStackTrace( System.err );
                }
            try {
                transaction.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
