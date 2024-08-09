package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Periodo;
import operaciones.conexion.Conexion;

public class OpPeriodo {

    public boolean crearPeriodo(Periodo periodo) {
        String sqlPeriodo = "INSERT INTO Periodo (Nombre, Inicio, Fin) VALUES (?, ?, ?)";
        String sqlActualizarSemestre = "UPDATE Alumnos SET Semestre = CASE "
                + "WHEN Semestre < 8 THEN Semestre + 1 "
                + "ELSE Semestre "
                + "END";
        String sqlEliminarGruposMaterias = "DELETE FROM GruposMaterias";

        Connection conn = null;
        PreparedStatement pstmtPeriodo = null;
        PreparedStatement pstmtActualizarSemestre = null;
        PreparedStatement pstmtEliminarGruposMaterias = null;

        try {
            conn = new Conexion().connect();
            conn.setAutoCommit(false);

            // Insertar el nuevo periodo
            pstmtPeriodo = conn.prepareStatement(sqlPeriodo);
            pstmtPeriodo.setString(1, periodo.getNombre());
            pstmtPeriodo.setString(2, periodo.getInicio());
            pstmtPeriodo.setString(3, periodo.getFin());
            int affectedRowsPeriodo = pstmtPeriodo.executeUpdate();

            // Actualizar el semestre de los alumnos
            pstmtActualizarSemestre = conn.prepareStatement(sqlActualizarSemestre);
            int affectedRowsSemestre = pstmtActualizarSemestre.executeUpdate();

            // Eliminar registros de la tabla GruposMaterias
            pstmtEliminarGruposMaterias = conn.prepareStatement(sqlEliminarGruposMaterias);
            int affectedRowsGruposMaterias = pstmtEliminarGruposMaterias.executeUpdate();

            // Confirmar la transacción si todas las operaciones fueron exitosas
            if (affectedRowsPeriodo > 0 && affectedRowsSemestre >= 0 && affectedRowsGruposMaterias >= 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.out.println("Error al revertir la transacción: " + rollbackEx.getMessage());
            }
            throw new RuntimeException("Error al crear periodo y actualizar datos", e);
        } finally {
            try {
                if (pstmtPeriodo != null) {
                    pstmtPeriodo.close();
                }
                if (pstmtActualizarSemestre != null) {
                    pstmtActualizarSemestre.close();
                }
                if (pstmtEliminarGruposMaterias != null) {
                    pstmtEliminarGruposMaterias.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public Periodo getPeriodoById(String id) {
        String sql = "SELECT * FROM Periodo WHERE IdPeriodo = ?";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToPeriodo(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener periodo por ID", e);
        }
        return null;
    }

    public Periodo getUltimoPeriodo() {
        String sql = "SELECT * FROM Periodo ORDER BY IdPeriodo DESC LIMIT 1";
        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return mapResultSetToPeriodo(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el último período", e);
        }
        return null;
    }

    private Periodo mapResultSetToPeriodo(ResultSet rs) throws SQLException {
        Periodo periodo = new Periodo();
        periodo.setId(rs.getString("IdPeriodo"));
        periodo.setNombre(rs.getString("Nombre"));
        periodo.setInicio(rs.getString("Inicio"));
        periodo.setFin(rs.getString("Fin"));

        return periodo;
    }
}
