package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.MateriaModelo;
import operaciones.conexion.Conexion;

public class OpMaterias {

    Connection conn;

    //Obtener todas las materias
    public ArrayList<MateriaModelo> getMaterias() {
        ArrayList<MateriaModelo> materias = new ArrayList<>();
        String sentencia = "SELECT * FROM MATERIAS";
        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sentencia);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                materias.add(mapResultSetToMateria(rs));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener todas las materias " + e.getMessage() + "\n" + e.getSQLState());
        }

        return materias;

    }

    //Obtener todas las materias por la carrera y semestre
    public ArrayList<MateriaModelo> getMateriasByCarreraAndSemestre(String idCarrera, String semestre) {
        ArrayList<MateriaModelo> materias = new ArrayList<>();
        String sentencia = "SELECT * FROM MATERIAS WHERE IdCarrera = ? AND Semestre = ?";
        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sentencia);
            pstmt.setString(1, idCarrera);
            pstmt.setString(2, semestre);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                materias.add(mapResultSetToMateria(rs));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener materias por la carrera y semestre " + e.getMessage() + "\n" + e.getSQLState());
        }

        return materias;
    }

    public boolean eliminarMateria(String id) {
        conn = new Conexion().connect();
        String sql = "DELETE FROM Materias WHERE IdMateria = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            int affectedRows = pstmt.executeUpdate();
            conn.close();
            return affectedRows > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la materia", e);
        }

    }

    public boolean insertMateria(MateriaModelo materia) {
        String sentencia = "INSERT INTO MATERIAS (Nombre, HBCA, HTI, Semestre, Creditos, IdCarrera) VALUES (?,?,?,?,?,?)";
        //  String sentencia = "UPDATE Materias set Nombre = ?, HBCA = ?, HTI = ? , Semestre = ? , Creditos = ? , IdCarrera = ? WHERE IdMateria = ?";
        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sentencia);
            pstmt.setString(1, materia.getNombre());
            pstmt.setString(2, materia.getHcba());
            pstmt.setString(3, materia.getHti());
            pstmt.setString(4, materia.getSemestre());
            pstmt.setString(5, materia.getCreditos());
            pstmt.setString(6, materia.getCarrera());

            int rowAfecteds = pstmt.executeUpdate();
            conn.close();
            return rowAfecteds > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la materia" + e.getMessage() + "\n" + e.getSQLState());
            return false;
        }
    }

    //Actualizar Mateira 
    public boolean updateMateria(MateriaModelo materia) {
        //  String sentencia = "INSERT INTO MATERIAS (Nombre, HBCA, HTI, Semestre, Creditos, IdCarrera) VALUES (?,?,?,?,?,?)";
        String sentencia = "UPDATE Materias set Nombre = ?, HBCA = ?, HTI = ? , Semestre = ? , Creditos = ? , IdCarrera = ? WHERE IdMateria = ?";
        try {
            conn = new Conexion().connect();
            PreparedStatement pstmt = conn.prepareStatement(sentencia);
            pstmt.setString(1, materia.getNombre());
            pstmt.setString(2, materia.getHcba());
            pstmt.setString(3, materia.getHti());
            pstmt.setString(4, materia.getSemestre());
            pstmt.setString(5, materia.getCreditos());
            pstmt.setString(6, materia.getCarrera());
            pstmt.setString(7, materia.getIdMateria());

            int rowAfecteds = pstmt.executeUpdate();
            conn.close();
            return rowAfecteds > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar la materia" + e.getMessage() + "\n" + e.getSQLState());
            return false;
        }
    }

    // Método para mapear un ResultSet a un objeto MateriaModelo
    private MateriaModelo mapResultSetToMateria(ResultSet rs) throws SQLException {
        MateriaModelo materia = new MateriaModelo();

        materia.setNombre(rs.getString("Nombre"));
        materia.setIdMateria(rs.getString("IdMateria"));
        materia.setHcba(rs.getString("HBCA"));
        materia.setHti(rs.getString("HTI"));
        materia.setSemestre(rs.getString("Semestre"));
        materia.setCreditos(rs.getString("Creditos"));
        materia.setCarrera(rs.getString("IdCarrera"));

        return materia;
    }

    /**
     * public static void main(String[] args) { OpMateria op = new OpMateria();
     *
     *
     *
     * ArrayList<MateriaModelo> materias =
     * op.getMateriasByCarreraAndSemestre("1","I");
     *
     * materias.forEach((materia)->{ System.out.println(materia.getNombre());
     * }); }*
     */
}
