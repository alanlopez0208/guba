/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.TitulacionModelo;
import operaciones.conexion.Conexion;

public class OpTitulacion {

    public TitulacionModelo getTitulacionByIdAlumno(String idAlumno) {
        String sql = "SELECT * FROM Titulacion WHERE IdAlumno = ? LIMIT 1";
        TitulacionModelo titulacion = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idAlumno);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                titulacion = new TitulacionModelo();
                titulacion.setIdTitulacion(rs.getString("IdTitulacion"));
                titulacion.setIdAlumno(rs.getString("IdAlumno"));
                titulacion.setNumero(rs.getString("Numero"));
                titulacion.setRegistro(rs.getString("Registro"));
                titulacion.setLibro(rs.getString("Libro"));
                titulacion.setFoja(rs.getString("Foja"));
                titulacion.setFolio(rs.getString("Folio"));
                titulacion.setAcuerdo(rs.getString("Acuerdo"));
                titulacion.setTipoExamen(rs.getString("TipoExamen"));
                titulacion.setFechaAcuerdo(rs.getString("FechaAcuerdo"));
                titulacion.setHoraAplicacion(rs.getString("HoraAplicacion"));
                titulacion.setDuracion(rs.getString("Duracion"));
                titulacion.setHoraFinalizacion(rs.getString("HoraFinalizacion"));
                titulacion.setPresidente(rs.getString("Presidente"));
                titulacion.setSecretario(rs.getString("Secretario"));
                titulacion.setVocal(rs.getString("Vocal"));
                titulacion.setNombre(rs.getString("Nombre"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener titulacion por IdAlumno", e);
        }

        return titulacion;
    }

    // Actualizar un registro por IdAlumno
    public boolean updateTitulacionByIdAlumno(TitulacionModelo titulacionModelo) {
        String sql = "UPDATE Titulacion SET Numero = ?, Registro = ?, Libro = ?, Foja = ?, Folio = ?, "
                + "Acuerdo = ?, TipoExamen = ?, FechaAcuerdo = ?, FechaAplicacion = ?, HoraAplicacion = ?, "
                + "Duracion = ?, HoraFinalizacion = ?, Presidente = ?, Secretario = ?, Vocal = ?, Nombre = ? "
                + "WHERE IdAlumno = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulacionModelo.getNumero());
            pstmt.setString(2, titulacionModelo.getRegistro());
            pstmt.setString(3, titulacionModelo.getLibro());
            pstmt.setString(4, titulacionModelo.getFoja());
            pstmt.setString(5, titulacionModelo.getFolio());
            pstmt.setString(6, titulacionModelo.getAcuerdo());
            pstmt.setString(7, titulacionModelo.getTipoExamen());
            pstmt.setString(8, titulacionModelo.getFechaAcuerdo());
            pstmt.setString(9, titulacionModelo.getFechaAplicacion());
            pstmt.setString(10, titulacionModelo.getHoraAplicacion());
            pstmt.setString(11, titulacionModelo.getDuracion());
            pstmt.setString(12, titulacionModelo.getHoraFinalizacion());
            pstmt.setString(13, titulacionModelo.getPresidente());
            pstmt.setString(14, titulacionModelo.getSecretario());
            pstmt.setString(15, titulacionModelo.getVocal());
            pstmt.setString(16, titulacionModelo.getNombre());
            pstmt.setString(17, titulacionModelo.getIdAlumno());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar titulacion por IdAlumno", e);
        }
    }

    // Eliminar un registro por IdAlumno
    public boolean deleteTitulacionByIdAlumno(String idAlumno) {
        String sql = "DELETE FROM Titulacion WHERE IdAlumno = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idAlumno);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar titulacion por IdAlumno", e);
        }
    }

    public boolean crearTitulacion(TitulacionModelo titulacionModelo) {
        String sql = "INSERT INTO Titulacion (IdAlumno, Numero, Registro, Libro, Foja, Folio, Acuerdo, TipoExamen, FechaAcuerdo, FechaAplicacion, "
                + "HoraAplicacion, Duracion, HoraFinalizacion, Presidente, Secretario, Vocal, Nombre) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, titulacionModelo.getIdAlumno());
            pstmt.setString(2, titulacionModelo.getNumero());
            pstmt.setString(3, titulacionModelo.getRegistro());
            pstmt.setString(4, titulacionModelo.getLibro());
            pstmt.setString(5, titulacionModelo.getFoja());
            pstmt.setString(6, titulacionModelo.getFolio());
            pstmt.setString(7, titulacionModelo.getAcuerdo());
            pstmt.setString(8, titulacionModelo.getTipoExamen());
            pstmt.setString(9, titulacionModelo.getFechaAcuerdo());
            pstmt.setString(10, titulacionModelo.getFechaAplicacion());
            pstmt.setString(11, titulacionModelo.getHoraAplicacion());
            pstmt.setString(12, titulacionModelo.getDuracion());
            pstmt.setString(13, titulacionModelo.getHoraFinalizacion());
            pstmt.setString(14, titulacionModelo.getPresidente());
            pstmt.setString(15, titulacionModelo.getSecretario());
            pstmt.setString(16, titulacionModelo.getVocal());
            pstmt.setString(17, titulacionModelo.getNombre());
           
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear titulacion", e);
        }
    }

}
