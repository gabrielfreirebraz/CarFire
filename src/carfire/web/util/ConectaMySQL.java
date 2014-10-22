package carfire.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectaMySQL {

	
    // -----------------------------------------------------------
    // Carrega driver JDBC
    //
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
	
	// -----------------------------------------------------------
	public static Connection getConexao() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://localhost:3306/carfire?user=root&password=Mysql");
	}
		

}
