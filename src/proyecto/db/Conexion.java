package proyecto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static final String url = "jdbc:postgresql://ec2-107-22-14-60.compute-1.amazonaws.com/d999dad0i99uem?ssl=false";
    private static final String user = "trcbdkcrlblbbb";
    private static final String password = "3bb2aa10550e4e359680c06e26242ad7e3746bee685b715525b02f9a0e438fab";
    
    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado a la base de datos");
            conexion.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conexion;
    }
}
