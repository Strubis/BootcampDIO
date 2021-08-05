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
        // Dados da conexão
        String driver = "mysql";
        String dbAddress = "localhost";
        String dbName = "dio";
        String user = "root";
        String password = "";

        // Url para a conexão
        StringBuilder urlConnection = new StringBuilder( "jdbc:" );
        urlConnection.append( driver ).append( "://" );
        urlConnection.append( dbAddress ).append( "/" );
        urlConnection.append( dbName );

        // Conexão
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
