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
    String rutaBD = "jdbc:sqlite:"+ config.obtenerConfiguracion("01 RUTA BD");
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
            for (int i = 0; i < calificaciones.length(); i++) {
                JSONObject row = calificaciones.getJSONObject(i);
                int idCalificacion = row.getInt("IdCalificacion");

                if (recordExists(conn, selectSQL, idCalificacion)) {
                    updateRecord(conn, updateSQL, row, idCalificacion);
                } else {
                    insertRecord(conn, insertSQL, row);
                }
            }
            System.out.println("Datos insertados/actualizados con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
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
        stmt.setInt(1, row.getInt("IdCalificacion"));
        stmt.setObject(2, row.opt("IdAlumno") != null ? row.optInt("IdAlumno") : null);
        stmt.setObject(3, row.opt("IdDocente") != null ? row.optInt("IdDocente") : null);
        stmt.setObject(4, row.opt("IdMateria") != null ? row.optInt("IdMateria") : null);
        stmt.setObject(5, row.opt("IdPeriodo") != null ? row.optInt("IdPeriodo") : null);
        stmt.setObject(6, row.opt("P1U1"));
        stmt.setObject(7, row.opt("P2U1"));
        stmt.setObject(8, row.opt("P3U1"));
        stmt.setObject(9, row.opt("P4U1"));
        stmt.setObject(10, row.opt("P1U2"));
        stmt.setObject(11, row.opt("P2U2"));
        stmt.setObject(12, row.opt("P3U2"));
        stmt.setObject(13, row.opt("P4U2"));
        stmt.setObject(14, row.opt("TB"));
        stmt.setObject(15, row.opt("P1U3"));
        stmt.setObject(16, row.opt("P2U3"));
        stmt.setObject(17, row.opt("P3U3"));
        stmt.setObject(18, row.opt("P4U3"));
        stmt.setObject(19, row.opt("P1U4"));
        stmt.setObject(20, row.opt("P2U4"));
        stmt.setObject(21, row.opt("P3U4"));
        stmt.setObject(22, row.opt("P4U4"));
    }

}
