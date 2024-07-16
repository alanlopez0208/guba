package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.CalificacionModelo;
import modelos.GrupoModelo;
import modelos.MateriaModelo;
import operaciones.conexion.Conexion;

public class OpCalificaciones {

    // Obtener todas las calificaciones
    public ArrayList<CalificacionModelo> obtenerCalificaciones(String idAlumno) {
        ArrayList<CalificacionModelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Calificaciones WHERE IdAlumno = ? ";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, idAlumno);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CalificacionModelo calificacion = mapResultSetToCalificacion(rs);
                lista.add(calificacion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar calificaciones", e);
        }
        return lista;
    }

    //Actualizar la calificacion
    public boolean updateCalificacion(CalificacionModelo calificacion) {
        String sql = "UPDATE Calificaciones SET IdAlumno = ?, IdMateria = ?, IdGrupo = ?, "
                + "P1U1 = ?, P2U1 = ?, P3U1 = ?, P4U1 = ?, "
                + "P1U2 = ?, P2U2 = ?, P3U2 = ?, P4U2 = ?, "
                + "TB = ? "
                + "WHERE IdCalificacion = ?";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, calificacion.getIdAlumno());
        //   pstmt.setInt(2, calificacion.getIdDocente());
            pstmt.setInt(2, Integer.parseInt(calificacion.getMateria().getIdMateria()));
            pstmt.setString(3, calificacion.getGrupo().getId());

            if (calificacion.getP1U1() != null) {
                pstmt.setFloat(4, calificacion.getP1U1());
            } else {
                pstmt.setNull(4, java.sql.Types.FLOAT);
            }
            if (calificacion.getP1U1() != null) {
                pstmt.setFloat(4, calificacion.getP1U1());
            } else {
                pstmt.setNull(4, java.sql.Types.FLOAT);
            }
            if (calificacion.getP2U1() != null) {
                pstmt.setFloat(5, calificacion.getP2U1());
            } else {
                pstmt.setNull(5, java.sql.Types.FLOAT);
            }
            if (calificacion.getP3U1() != null) {
                pstmt.setFloat(6, calificacion.getP3U1());
            } else {
                pstmt.setNull(6, java.sql.Types.FLOAT);
            }
            if (calificacion.getP4U1() != null) {
                pstmt.setFloat(7, calificacion.getP4U1());
            } else {
                pstmt.setNull(7, java.sql.Types.FLOAT);
            }
            if (calificacion.getP1U2() != null) {
                pstmt.setFloat(8, calificacion.getP1U2());
            } else {
                pstmt.setNull(8, java.sql.Types.FLOAT);
            }
            if (calificacion.getP2U2() != null) {
                pstmt.setFloat(9, calificacion.getP2U2());
            } else {
                pstmt.setNull(9, java.sql.Types.FLOAT);
            }
            if (calificacion.getP3U2() != null) {
                pstmt.setFloat(10, calificacion.getP3U2());
            } else {
                pstmt.setNull(10, java.sql.Types.FLOAT);
            }
            if (calificacion.getP4U2() != null) {
                pstmt.setFloat(11, calificacion.getP4U2());
            } else {
                pstmt.setNull(11, java.sql.Types.FLOAT);
            }

            if (calificacion.getTrabjoFinal() != null) {
                pstmt.setFloat(12, calificacion.getTrabjoFinal());
            } else {
                pstmt.setNull(12, java.sql.Types.FLOAT);
            }

            pstmt.setInt(13, calificacion.getIdCalificacion());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la calificación", e);
        }
    }

    //Metodo para eliminarAlumno
    public boolean deleteAlumno(String matricula) {

        return true;
    }

    // Mapear ResultSet a CalificacionModelo
    private CalificacionModelo mapResultSetToCalificacion(ResultSet rs) throws SQLException {
        CalificacionModelo calificacion = new CalificacionModelo();

        OpGrupo opGrupo = new OpGrupo();
        GrupoModelo grupo = opGrupo.seleccionarGrupo(rs.getInt("IdGrupo"));
        OpMaterias opMateria = new OpMaterias();
        MateriaModelo materia = opMateria.getMateria(rs.getString("IdMateria"));
        calificacion.setIdCalificacion(rs.getInt("IdCalificacion"));
        calificacion.setIdAlumno(rs.getInt("IdAlumno"));
        calificacion.setIdDocente(rs.getInt("IdDocente"));
        calificacion.setMateria(materia);
        calificacion.setGrupo(grupo);
        Float p1u1 = rs.getFloat("P1U1");
        calificacion.setP1U1(rs.wasNull() ? null : p1u1);

        Float p2u1 = rs.getFloat("P2U1");
        calificacion.setP2U1(rs.wasNull() ? null : p2u1);

        Float p3u1 = rs.getFloat("P3U1");
        calificacion.setP3U1(rs.wasNull() ? null : p3u1);

        Float p4u1 = rs.getFloat("P4U1");
        calificacion.setP4U1(rs.wasNull() ? null : p4u1);

        Float p1u2 = rs.getFloat("P1U2");
        calificacion.setP1U2(rs.wasNull() ? null : p1u2);

        Float p2u2 = rs.getFloat("P2U2");
        calificacion.setP2U2(rs.wasNull() ? null : p2u2);

        Float p3u2 = rs.getFloat("P3U2");
        calificacion.setP3U2(rs.wasNull() ? null : p3u2);

        Float p4u2 = rs.getFloat("P4U2");
        calificacion.setP4U2(rs.wasNull() ? null : p4u2);

        Float tb = rs.getFloat("TB");
        calificacion.setTrabjoFinal(rs.wasNull() ? null : tb);
        return calificacion;
    }

}
