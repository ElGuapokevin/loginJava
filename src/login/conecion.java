package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conecion {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/login1"; // Asegúrate de que el puerto es correcto (usualmente 3306).
    private static final String USUARIO = "root";
    private static final String PASS    = "";

    public static Connection obtenerConexion() {
        try {
            System.out.println("conectada papa");
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, PASS);
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el driver de MySQL: " + e);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e);
        }
        return null; // Retornamos null si la conexión falló
    }
}
