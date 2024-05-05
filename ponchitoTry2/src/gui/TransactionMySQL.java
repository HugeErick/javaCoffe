package gui;

import java.sql.*;
import java.io.*;

public class TransactionMySQL {
    public Connection conn;
    Statement stmt;
    BufferedReader in;
    public String username;


    public TransactionMySQL(String url, String username, String passw) {
        System.out.print( "Connecting to the database... " );

        // set up the connection with the DB
        try {
            conn = DriverManager.getConnection(url, username, passw);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println( "connected\n\n" );

        try {
            conn.setAutoCommit( false );         // inicio de la 1a transacción
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        in = new BufferedReader( new InputStreamReader(System.in) );
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }
    public void dumpResultSet( ResultSet rset ) throws SQLException {

        ResultSetMetaData rsetmd = rset.getMetaData();
        int i = rsetmd.getColumnCount();

        while( rset.next() ) {

            for( int j = 1; j <= i; j++ ) {
                System.out.print( rset.getString(j) + "\t" );
            }
            System.out.println();
        }
    }

    public void query( String statement ) throws SQLException {

        ResultSet rset = stmt.executeQuery( statement );
        System.out.println( "Results:" );
        dumpResultSet( rset );

        System.out.println();
        rset.close();
    }

    public void close() throws SQLException {
        stmt.close();
        conn.close();
    }

    public boolean menu() throws SQLException, IOException {

        String statement;

        System.out.println( "\nNivel de aislamiento = " + conn.getTransactionIsolation() + "\n" );
        System.out.println( "(1) Lista completa\n" );
        System.out.println( "(2) Lista restringida\n" );
        System.out.println( "(3) Insertar un empleado\n" );
        System.out.println( "(4) Borrar un empleado\n" );
        System.out.println( "(5) Modificar el salario de un empleado\n" );
        System.out.println( "(6) Validar todas operaciones\n" );
        System.out.println( "(7) Abortar todas las operaciones\n" );
        System.out.println( "(8) Cambiar nivel de aislamiento\n" );
        System.out.println( "(9) Salir\n\n" );
        System.out.print( "Option: " );

        switch( Integer.parseInt( "0" + in.readLine() ) ) {

            case 1:	query( "select * from emp" );
                break;

            case 2:	System.out.println( "\nPredicado?" );
                query( "select * from emp where " + in.readLine() );
                break;

            case 3:	statement = "insert into EMP values ( ";

                System.out.println( "\nNumero?" );
                statement += in.readLine();

                System.out.println( "Nombre?" );
                statement += ", '" + in.readLine() + "', 'SALESMAN', ";

                System.out.println( "Jefe?" );
                statement += in.readLine() + ", '12-NOV-05', 1250.00,  500.00, 40 )";

                stmt.executeUpdate( statement );
                break;

            case 4:	System.out.println( "\nNombre?" );
                stmt.executeUpdate( "delete from emp where ename = '" + in.readLine() + "'" );
                break;

            case 5:	statement = "update emp set ";

                System.out.println( "\n<Atributo> = <Valor>?" );
                statement += in.readLine();

                System.out.println( "Predicado?" );
                statement += " where " + in.readLine();

                stmt.executeUpdate( statement );
                break;

            case 6:	conn.commit();      // fin de la transacción e inicio de la siguiente
                break;

            case 7:	conn.rollback();    // fin de la transacción e inicio de la siguiente
                break;

            case 8:	System.out.println();

                System.out.println( conn.TRANSACTION_NONE + " = TRANSACTION_NONE" );
                System.out.println( conn.TRANSACTION_READ_UNCOMMITTED + " = TRANSACTION_READ_UNCOMMITTED" );
                System.out.println( conn.TRANSACTION_READ_COMMITTED + " = TRANSACTION_READ_COMMITTED" );
                System.out.println( conn.TRANSACTION_REPEATABLE_READ + " = TRANSACTION_REPEATABLE_READ" );
                System.out.println( conn.TRANSACTION_SERIALIZABLE + " = TRANSACTION_SERIALIZABLE\n\n" );

                System.out.println( "Nivel?" );
                conn.setTransactionIsolation( Integer.parseInt( in.readLine() ) );
                break;

            case 9:	return false;
        }

        return true;
    }

}

