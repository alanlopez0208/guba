package operaciones;

import operaciones.conexion.Conexion;
import modelos.GrupoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OpGrupos {

    // Método para obtener todos los grupos
    public ArrayList<GrupoModelo> getGrupos() {
        ArrayList<GrupoModelo> listaGrupos = new ArrayList<>();
        String sql = "SELECT IdGrupo, Nombre, Semestre, IdMateria FROM Grupos";

        try (Connection conn = new Conexion().connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                GrupoModelo grupo = mapResultSetToGrupo(rs);
                listaGrupos.add(grupo);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar grupos: " + e.getMessage());
        }
        return listaGrupos;
    }

    // Método para mapear un ResultSet a un objeto GrupoModelo
    private GrupoModelo mapResultSetToGrupo(ResultSet rs) throws SQLException {
        return new GrupoModelo(
                rs.getInt("IdGrupo"),
                rs.getString("Nombre")
        );
    }

    // método para agregar un grupo
    public boolean agregarGrupo(GrupoModelo grupo) {
        String sql = "INSERT INTO Grupos (Nombre, Semestre, IdMateria) VALUES (?, ?, ?)";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
         
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un grupo
    public boolean eliminarGrupo(int idGrupo) {
        String sql = "DELETE FROM Grupos WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idGrupo);

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar grupo: " + e.getMessage());
            return false;
        }
    }

// Método para actualizar un grupo
    public boolean actualizarGrupo(GrupoModelo grupo) {
        String sql = "UPDATE Grupos SET Nombre = ?, Semestre = ?, IdMateria = ? WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
          

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar grupo: " + e.getMessage());
            return false;
        }
    }

// Método para seleccionar un grupo 
    public GrupoModelo seleccionarGrupo(int idGrupo) {
        String sql = "SELECT IdGrupo, Nombre, Semestre, IdMateria FROM Grupos WHERE IdGrupo = ?";
        GrupoModelo grupoSeleccionado = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idGrupo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                grupoSeleccionado = mapResultSetToGrupo(rs);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar grupo: " + e.getMessage());
        }
        return grupoSeleccionado;
    }

    public static void main(String[] args) {
        OpGrupos opGrupos = new OpGrupos();

        ArrayList<GrupoModelo> grupos = opGrupos.getGrupos();
        for (GrupoModelo grupo : grupos) {
            System.out.println(grupo);
        }
    }
}
