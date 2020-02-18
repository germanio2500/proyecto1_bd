/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_bd;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author lv1013
 */
public class MySQLConnectionFactory implements ConnectionFactory {

    private final String connectionString;
    private final String user;
    private final String password;

    public MySQLConnectionFactory(
            String host,
            String database,
            int port,
            String user, 
            String password) {
        this.user = user;
        this.password = password;
        this.connectionString = 
            String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC", 
                    host, port, database);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.connectionString,
                this.user,
                this.password);
    }
    public static Connection conectar() {
		Connection con = null;
		
		String password = "root";
		String user = "root";
		String connectionString = "jdbc:mysql://%s:%d/%s?serverTimezone=UTC" + user
				+ "&password=" + password;
		try {
			con = DriverManager.getConnection(connectionString);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}

   
}
