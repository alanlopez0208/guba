package operaciones.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import operaciones.Config;

public class Conexion {

    public Connection connect() {
        Config config = new Config();
        String rutaBD = config.obtenerConfiguracion("01 RUTA BD");
        String url = "jdbc:sqlite:" + rutaBD;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión a la base de datos SQLite establecida.");
        } catch (SQLException e) {
            System.out.println("Error al intentar conectar con la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión a la base de datos SQLite. Error: " + e.getMessage(), "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.connect();
    }
}
