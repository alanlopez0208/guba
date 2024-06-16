package operaciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.CarrerasModelo;
import operaciones.conexion.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;

public class OpCarreras {

    Connection conn;

    public OpCarreras() {
        conn = new Conexion().connect();
    }

   public ArrayList<CarrerasModelo> getAllCarreras()  {
        ArrayList<CarrerasModelo> carreras = new ArrayList<>();
        try {
            String senteica = "SELECT * FROM Carreras";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(senteica);
            while (rs.next()) {
                carreras.add(mapResultSetToCarrera(rs));
            }
                 conn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener materias por la carrera y semestre " + e.getMessage() + "\n" + e.getSQLState());

        }
   
        return carreras;

    }

    // Método para mapear un ResultSet a un objeto GrupoModelo
    private CarrerasModelo mapResultSetToCarrera(ResultSet rs) throws SQLException {
        CarrerasModelo carrera = new CarrerasModelo();

        carrera.setCreditos(rs.getString("Creditos"));
        carrera.setIdCarrera(rs.getString("IdCarrera"));
        carrera.setIdClave(rs.getString("Clave"));
        carrera.setNombre(rs.getString("Nombre"));
        carrera.setHbca(rs.getString("HBCA"));
        carrera.setHti(rs.getString("HTI"));
        carrera.setCreditos(rs.getString("Creditos"));
        carrera.setTotalHoras(rs.getString("TotalHoras"));
        carrera.setModalidad(rs.getString("Modalidad"));
        carrera.setTotalAsignaturas(rs.getString("TotalAsignatuas"));

        return carrera;
    }

}
