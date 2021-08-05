package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Emerson
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        // Dados da conex�o
        String driver = "mysql";
        String dbAddress = "localhost";
        String dbName = "dio";
        String user = "root";
        String password = "";

        // Url para a conex�o
        StringBuilder urlConnection = new StringBuilder( "jdbc:" );
        urlConnection.append( driver ).append( "://" );
        urlConnection.append( dbAddress ).append( "/" );
        urlConnection.append( dbName );

        // Conex�o
        Connection con = null;
        try {
            con = DriverManager.getConnection(
                    urlConnection.toString(),
                    user,
                    password);
        } catch (SQLException sqlExc) {
            String errorMsg = "Conexao negada: " + sqlExc;
            throw new Error( errorMsg );
        }

        return con;
    }
}
