package menu;
import main.TransactionMySQL;
import java.sql.SQLException;
public class OpenTransactionMenu {
    public OpenTransactionMenu() throws Exception {
        TransactionMySQL transaction = new TransactionMySQL();
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
