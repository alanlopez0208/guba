package operaciones.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import operaciones.Config;
import operaciones.web.ApiClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class InsertWeb {

    Config config = new Config();
    String rutaBD = "jdbc:sqlite:" + config.obtenerConfiguracion("01 RUTA BD");
    private final String DB_URL = rutaBD;

    public void insertOrUpdateCalificaciones(JSONArray calificaciones) {
        String selectSQL = "SELECT COUNT(*) FROM Calificaciones WHERE IdCalificacion = ?";
        String insertSQL = "INSERT INTO Calificaciones (IdCalificacion, IdAlumno, IdDocente, IdMateria, IdPeriodo, "
                + "P1U1, P2U1, P3U1, P4U1, P1U2, P2U2, P3U2, P4U2, TB, P1U3, P2U3, P3U3, P4U3, P1U4, P2U4, P3U4, P4U4) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String updateSQL = "UPDATE Calificaciones SET IdAlumno = ?, IdDocente = ?, IdMateria = ?, IdPeriodo = ?, "
                + "P1U1 = ?, P2U1 = ?, P3U1 = ?, P4U1 = ?, P1U2 = ?, P2U2 = ?, P3U2 = ?, P4U2 = ?, TB = ?, "
                + "P1U3 = ?, P2U3 = ?, P3U3 = ?, P4U3 = ?, P1U4 = ?, P2U4 = ?, P3U4 = ?, P4U4 = ? "
                + "WHERE IdCalificacion = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            conn.setAutoCommit(false); // Iniciar la transacción

            for (int i = 0; i < calificaciones.length(); i++) {
                JSONObject row = calificaciones.getJSONObject(i);
                int idCalificacion = row.getInt("IdCalificacion");

                // Verificar si el registro existe y actualizar o insertar según corresponda
                if (recordExists(conn, selectSQL, idCalificacion)) {
                    updateRecord(conn, updateSQL, row, idCalificacion);
                } else {
                    insertRecord(conn, insertSQL, row);
                }
            }

            conn.commit(); // Confirmar la transacción
            System.out.println("Datos insertados/actualizados con éxito.");
        } catch (SQLException e) {
            e.printStackTrace(); // Podrías reemplazar esto por un logger
            try (Connection conn = DriverManager.getConnection(DB_URL)) {
                if (conn != null) {
                    conn.rollback(); // Revertir los cambios en caso de error
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace(); // Manejo del error durante el rollback
            }
        }
    }

    private boolean recordExists(Connection conn, String selectSQL, int idCalificacion) throws SQLException {
        try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
            selectStmt.setInt(1, idCalificacion);
            try (ResultSet rs = selectStmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    private void updateRecord(Connection conn, String updateSQL, JSONObject row, int idCalificacion) throws SQLException {
        try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
            setPreparedStatementParams(updateStmt, row);
            updateStmt.setInt(22, idCalificacion);
            updateStmt.executeUpdate();
        }
    }

    private void insertRecord(Connection conn, String insertSQL, JSONObject row) throws SQLException {
        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
            setPreparedStatementParams(insertStmt, row);
            insertStmt.executeUpdate();
        }
    }

    private void setPreparedStatementParams(PreparedStatement stmt, JSONObject row) throws SQLException {
        // Asignación de IDs, estos siempre deben tener un valor
        stmt.setInt(1, row.optInt("IdCalificacion", 0));  // Columna 'IdCalificacion'
        stmt.setInt(2, row.optInt("IdAlumno", 0));        // Columna 'IdAlumno'
        stmt.setInt(3, row.optInt("IdDocente", 0));       // Columna 'IdDocente'
        stmt.setInt(4, row.optInt("IdMateria", 0));       // Columna 'IdMateria'
        stmt.setInt(5, row.optInt("IdPeriodo", 0));       // Columna 'IdPeriodo'

        // Asignación condicional para las demás columnas
        setConditionalParam(stmt, 6, row.opt("P1U1"));  // Columna 'P1U1'
        setConditionalParam(stmt, 7, row.opt("P2U1"));  // Columna 'P2U1'
        setConditionalParam(stmt, 8, row.opt("P3U1"));  // Columna 'P3U1'
        setConditionalParam(stmt, 9, row.opt("P4U1"));  // Columna 'P4U1'
        setConditionalParam(stmt, 10, row.opt("P1U2")); // Columna 'P1U2'
        setConditionalParam(stmt, 11, row.opt("P2U2")); // Columna 'P2U2'
        setConditionalParam(stmt, 12, row.opt("P3U2")); // Columna 'P3U2'
        setConditionalParam(stmt, 13, row.opt("P4U2")); // Columna 'P4U2'
        setConditionalParam(stmt, 14, row.opt("TB"));   // Columna 'TB'
        setConditionalParam(stmt, 15, row.opt("P1U3")); // Columna 'P1U3'
        setConditionalParam(stmt, 16, row.opt("P2U3")); // Columna 'P2U3'
        setConditionalParam(stmt, 17, row.opt("P3U3")); // Columna 'P3U3'
        setConditionalParam(stmt, 18, row.opt("P4U3")); // Columna 'P4U3'
        setConditionalParam(stmt, 19, row.opt("P1U4")); // Columna 'P1U4'
        setConditionalParam(stmt, 20, row.opt("P2U4")); // Columna 'P2U4'
        setConditionalParam(stmt, 21, row.opt("P3U4")); // Columna 'P3U4'
        setConditionalParam(stmt, 22, row.opt("P4U4")); // Columna 'P4U4'
    }

    private void setConditionalParam(PreparedStatement stmt, int index, Object value) throws SQLException {
        if (value == null || value.toString().trim().isEmpty() || "null".equals(value.toString())) {
            // Si el valor es null, vacío o la cadena es "null", se establece como NULL en la base de datos
            stmt.setNull(index, java.sql.Types.INTEGER);
        } else {
            // Si es un valor válido, se convierte a entero
            stmt.setInt(index, Integer.parseInt(value.toString()));
        }
    }

}
