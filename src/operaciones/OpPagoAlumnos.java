package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.EstudianteModelo;
import modelos.PagoAlumnosModelo;
import operaciones.conexion.Conexion;

public class OpPagoAlumnos {

    // Obtener todos los pagos
    public ArrayList<PagoAlumnosModelo> getPagos() {
        ArrayList<PagoAlumnosModelo> lista = new ArrayList<>();
        String sql = "SELECT IdPago, IdAlumno, Fecha, Cantidad, Concepto FROM PagoAlumnos";
        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PagoAlumnosModelo pago = mapResultSetToPago(rs);
                lista.add(pago);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar pagos", e);
        }
        return lista;
    }

    // Buscar pagos por filtro
    public ArrayList<PagoAlumnosModelo> buscarPagos(String where, String filtro) {
        ArrayList<PagoAlumnosModelo> resultados = new ArrayList<>();
        String sql = "SELECT idPago, idAlumno, fecha, cantidad, concepto FROM PagoAlumnos WHERE " + where + " LIKE ?";
        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, filtro + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PagoAlumnosModelo pago = mapResultSetToPago(rs);
                    resultados.add(pago);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar pagos", e);
        }
        return resultados;
    }

    // Actualizar un pago
    public boolean updatePago(PagoAlumnosModelo pagoModelo) {
        String sql = "UPDATE PagoAlumnos SET IdAlumno = ?, Fecha = ?, Cantidad = ?, Concepto = ? WHERE IdPago = ?";
        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pagoModelo.getIdAlumno());
            pstmt.setString(2, pagoModelo.getFecha());
            pstmt.setString(3, pagoModelo.getCantidad());
            pstmt.setString(4, pagoModelo.getConcepto());
            pstmt.setString(5, pagoModelo.getIdPago());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar pago", e);
        }
    }

    // Eliminar un pago
    public boolean deletePago(String idPago) {
        String sql = "DELETE FROM PagoAlumnos WHERE IdPago = ?";
        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idPago);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar pago", e);
        }
    }

    // Recuperar un pago por ID
    public PagoAlumnosModelo retornarPago(String idPago) {
        String sql = "SELECT IdPago, IdAlumno, Fecha, Cantidad, Concepto FROM PagoAlumnos WHERE IdPago = ?";
        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idPago);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPago(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar pago", e);
        }
        return null;
    }

    // Método para agregar un nuevo pago
    public boolean crearPago(PagoAlumnosModelo pagoModelo) {
        String sql = "INSERT INTO PagoAlumnos (IdPago, IdAlumno,Fecha, Cantidad, Concepto) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pagoModelo.getIdPago());
            pstmt.setString(2, pagoModelo.getIdAlumno());
            pstmt.setString(3, pagoModelo.getFecha());
            pstmt.setString(4, pagoModelo.getCantidad());
            pstmt.setString(5, pagoModelo.getConcepto());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear pago", e);
        }
    }

    // Mapear ResultSet a PagoAlumnosModelo
    private PagoAlumnosModelo mapResultSetToPago(ResultSet rs) throws SQLException {
        PagoAlumnosModelo pago = new PagoAlumnosModelo();
        pago.setIdPago(rs.getString("IdPago"));
        pago.setIdAlumno(rs.getString("IdAlumno"));
        pago.setFecha(rs.getString("Fecha"));
        pago.setCantidad(rs.getString("Cantidad"));
        pago.setConcepto(rs.getString("Concepto"));

        // Obtener estudiante asociado
        OpAlumno op = new OpAlumno();
        EstudianteModelo estudiante = op.getEstudiante(pago.getIdAlumno());
        pago.setEstudiante(estudiante);

        return pago;
    }
}