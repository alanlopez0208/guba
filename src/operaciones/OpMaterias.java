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

    public OpMaterias() {
        conn = new Conexion().connect();
    }

    //Obtener todas las materias por la carrera y semestre
    public ArrayList<MateriaModelo> getMateriasByCarreraAndSemestre(String idCarrera, String semestre) {
        ArrayList<MateriaModelo> materias = new ArrayList<>();
        String sentencia = "SELECT * FROM MATERIAS WHERE IdCarrera = ? AND Semestre = ?";
        try {

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
