package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.PagoDocentesModelo;
import modelos.MaestroModelo;
import operaciones.conexion.Conexion;

public class OpPagoDocentes {

    // Obtener todos los pagos
    public ArrayList<PagoDocentesModelo> getPagos() {
        ArrayList<PagoDocentesModelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM PagoDocentes";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PagoDocentesModelo pago = mapResultSetToPago(rs);
                lista.add(pago);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar pagos", e);
        }
        return lista;
    }

    // Buscar pagos por filtro
    public ArrayList<PagoDocentesModelo> buscarPagos(String where, String filtro) {
        ArrayList<PagoDocentesModelo> resultados = new ArrayList<>();
        String sql = "SELECT * FROM PagoDocentes WHERE " + where + " LIKE ?";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, filtro + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PagoDocentesModelo pago = mapResultSetToPago(rs);
                    resultados.add(pago);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar pagos", e);
        }
        return resultados;
    }

    // Actualizar un pago
    public boolean updatePago(PagoDocentesModelo pagoModelo) {
        String sql = "UPDATE PagoDocentes SET IdDocente = ?, Fecha = ?, Cantidad = ?, Concepto = ?, Factura = ? WHERE IdPago = ?";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pagoModelo.getIdMaestro());
            pstmt.setString(2, pagoModelo.getFecha());
            pstmt.setString(3, pagoModelo.getCantidad());
            pstmt.setString(4, pagoModelo.getConcepto());
            pstmt.setString(5, pagoModelo.getIdPago());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar pago", e);
        }
    }

    // Eliminar un pago
    public boolean deletePago(String idPago) {
        String sql = "DELETE FROM PagoDocentes WHERE IdPago = ?";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idPago);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar pago", e);
        }
    }

    // Recuperar un pago por ID
    public PagoDocentesModelo retornarPago(String idPago) {
        String sql = "SELECT * Concepto FROM PagoDocentes WHERE IdPago = ?";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
    public boolean crearPago(PagoDocentesModelo pagoModelo) {
        String sql = "INSERT INTO PagoDocentes (IdPago, IdDocente, Fecha, Cantidad, Concepto, Factura) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pagoModelo.getIdPago());
            pstmt.setString(2, pagoModelo.getIdMaestro());
            pstmt.setString(3, pagoModelo.getFecha());
            pstmt.setString(4, pagoModelo.getCantidad());
            pstmt.setString(5, pagoModelo.getConcepto());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear pago", e);
        }
    }

    // Mapear ResultSet a PagoDocentesModelo
    private PagoDocentesModelo mapResultSetToPago(ResultSet rs) throws SQLException {
        PagoDocentesModelo pago = new PagoDocentesModelo();
        pago.setIdPago(rs.getString("IdPago"));
        pago.setIdMaestro(rs.getString("IdDocente"));
        pago.setFecha(rs.getString("Fecha"));
        pago.setCantidad(rs.getString("Cantidad"));
        pago.setConcepto(rs.getString("Concepto"));
        pago.setFactura(rs.getString("Factura"));

        // Obtener maestro asociado
        OpMaestro op = new OpMaestro();
        MaestroModelo maestro = op.obtenerDocente(pago.getIdMaestro());
        pago.setMaestro(maestro);

        return pago;
    }
}
