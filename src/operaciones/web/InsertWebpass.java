package operaciones.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.JSONArray;
import org.json.JSONObject;
import operaciones.Config;

public class InsertWebpass {

    Config config = new Config();
    String rutaBD = "jdbc:sqlite:" + config.obtenerConfiguracion("01 RUTA BD");
    private final String DB_URL = rutaBD;

    public void upsertDataToLocalDB(String tableName, JSONArray data, String idColumn, String passwordColumn) {
        String selectSQL = "SELECT COUNT(*) FROM " + tableName + " WHERE " + idColumn + " = ?";
        String insertSQL = "INSERT INTO " + tableName + " (" + idColumn + ", " + passwordColumn + ") VALUES (?, ?)";
        String updateSQL = "UPDATE " + tableName + " SET " + passwordColumn + " = ? WHERE " + idColumn + " = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            for (int i = 0; i < data.length(); i++) {
                JSONObject row = data.getJSONObject(i);
                int id = row.getInt(idColumn);

                try (PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {
                    selectStmt.setInt(1, id);
                    ResultSet rs = selectStmt.executeQuery();

                    if (rs.next() && rs.getInt(1) > 0) {
                        // El registro ya existe, realizar un UPDATE
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
                            updateStmt.setString(1, row.optString(passwordColumn, ""));
                            updateStmt.setInt(2, id);
                            updateStmt.executeUpdate();
                        }
                    } else {
                        // El registro no existe, realizar un INSERT
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
                            insertStmt.setInt(1, id);
                            insertStmt.setString(2, row.optString(passwordColumn, ""));
                            insertStmt.executeUpdate();
                        }
                    }
                }
            }
            System.out.println("Datos de " + tableName.toLowerCase() + " insertados/actualizados con éxito.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
