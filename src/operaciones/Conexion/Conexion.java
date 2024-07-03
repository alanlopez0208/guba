package operaciones.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection connect() {
        String url = "jdbc:sqlite:D:\\Alan Lopez\\Documentos\\NetBeansProjects\\guba\\BD\\BDGUBA.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Conexion app = new Conexion();
        app.connect();
    }
}
