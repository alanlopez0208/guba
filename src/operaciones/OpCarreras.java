package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.CarrerasModelo;
import operaciones.conexion.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import modelos.MateriaModelo;

public class OpCarreras {

    Connection conn;

    public OpCarreras() {

    }

    //Obtener todas las carreras
    public ArrayList<CarrerasModelo> getAllCarreras() {
        ArrayList<CarrerasModelo> carreras = new ArrayList<>();
        try {
            conn = new Conexion().connect();
            String senteica = "SELECT * FROM Carreras";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(senteica);
            while (rs.next()) {
                carreras.add(mapResultSetToCarrera(rs));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener carreras " + e.getMessage() + "\n" + e.getSQLState());

        }

        return carreras;

    }

    //Insertar Carrera
    public boolean insertCarrera(CarrerasModelo carrera) {
        String sentencia = "INSERT INTO Carreras (Clave ,Nombre, HBCA, HTI, Creditos, TotalHoras, Modalidad, TotalAsignaturas ) VALUES (?,?,?,?,?,?,?,?)";
        //  String sentencia = "UPDATE Materias set Nombre = ?, HBCA = ?, HTI = ? , Semestre = ? , Creditos = ? , IdCarrera = ? WHERE IdMateria = ?";
        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sentencia);
            pstmt.setString(1, carrera.getIdClave());
            pstmt.setString(2, carrera.getNombre());
            pstmt.setString(3, carrera.getHbca());
            pstmt.setString(4, carrera.getHti());
            pstmt.setString(5, carrera.getCreditos());
            pstmt.setString(6, carrera.getTotalHoras());
            pstmt.setString(7, carrera.getModalidad());
            pstmt.setString(8, carrera.getTotalAsignaturas());

            int rowAfecteds = pstmt.executeUpdate();
            conn.close();
            return rowAfecteds > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la carrera" + e.getMessage() + "\n" + e.getSQLState());
            return false;
        }
    }

    //Actualizar Mateira 
    public boolean updateCarrera(CarrerasModelo carrera) {
        //  String sentencia = "INSERT INTO MATERIAS (Nombre, HBCA, HTI, Semestre, Creditos, IdCarrera) VALUES (?,?,?,?,?,?)";
        String sentencia = "UPDATE Carreras SET Clave = ?,Nombre = ?, HBCA = ?, HTI = ?, Creditos = ?, TotalHoras = ?, Modalidad = ?, TotalAsignaturas = ? WHERE IdCarrera = ?;";
        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sentencia);

            pstmt.setString(1, carrera.getIdClave());
            pstmt.setString(2, carrera.getNombre());
            pstmt.setString(3, carrera.getHbca());
            pstmt.setString(4, carrera.getHti());
            pstmt.setString(5, carrera.getCreditos());
            pstmt.setString(6, carrera.getTotalHoras());
            pstmt.setString(7, carrera.getModalidad());
            pstmt.setString(8, carrera.getTotalAsignaturas());
            pstmt.setString(9, carrera.getIdCarrera());

            int rowAfecteds = pstmt.executeUpdate();
            conn.close();
            return rowAfecteds > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la carrera" + e.getMessage() + "\n" + e.getSQLState());
            return false;
        }
    }

    //Metodo para eliminar Carrera
    public boolean eliminarCarrera(String id) {
        conn = new Conexion().connect();
        String sql = "DELETE FROM Carreras WHERE IdCarrera = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            int affectedRows = pstmt.executeUpdate();
            conn.close();
            return affectedRows > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la carrera", e);
        }

    }

    //Obtener la carrera de acuerdo a su Id
    public CarrerasModelo getMateriaById(String id) {
        CarrerasModelo carreras = new CarrerasModelo();
        String sql = "SELECT * FROM Carreras WHERE IdCarrera = ?";

        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                carreras = mapResultSetToCarrera(rs);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la carrera" + e.getMessage());
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
        carrera.setTotalAsignaturas(rs.getString("TotalAsignaturas"));

        return carrera;
    }

    public ArrayList<CarrerasModelo> buscarCarreras(String where, String filtro) {
        ArrayList<CarrerasModelo> resultados = new ArrayList<>();
        String sql = "SELECT * FROM Carreras WHERE " + where + " LIKE ?";

        conn = new Conexion().connect();

        if (conn == null) {
            throw new RuntimeException("No se pudo conectar a la base de datos");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filtro + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CarrerasModelo carrera = mapResultSetToCarrera(rs);
                    resultados.add(carrera);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar las carreras ", e);
        } finally {

            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return resultados;
    }
}
