package operaciones;

import operaciones.conexion.Conexion;
import modelos.GrupoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.CarrerasModelo;
import modelos.MateriaModelo;
import java.sql.*;
import java.util.ArrayList;

public class OpGrupo {

    // Método para mapear un ResultSet a un objeto GrupoModelo
    private GrupoModelo mapResultSetToGrupo(ResultSet rs) throws SQLException {
        GrupoModelo grupo = new GrupoModelo();

        OpCarreras opCarrera = new OpCarreras();
        CarrerasModelo carrera = opCarrera.getCarreraByd(rs.getString("IdCarrera"));

        grupo.setId(rs.getString("IdGrupo"));
        grupo.setNombre(rs.getString("Nombre"));
        grupo.setSemestre(rs.getString("Semestre"));
        grupo.setCarrera(carrera);
        return grupo;
    }

    // Método para obtener todos los grupos
    public ArrayList<GrupoModelo> getGrupos() {
        ArrayList<GrupoModelo> listaGrupos = new ArrayList<>();
        String sql = "SELECT * FROM Grupos";

        try (Connection conn = new Conexion().connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                GrupoModelo grupo = mapResultSetToGrupo(rs);
                listaGrupos.add(grupo);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar todos los grupos: " + e.getMessage());
        }
        return listaGrupos;
    }

    // Método para obtener las materias del grupo
    public ArrayList<MateriaModelo> getMateriasByGrupo(String idGrupo) {
        ArrayList<MateriaModelo> materias = new ArrayList<>();
        String sql = """
                SELECT m.IdMateria, m.IdCarrera, m.Nombre, m.HBCA, m.HTI, m.Semestre, m.Creditos, m.Clave 
                FROM GruposMaterias as gm 
                JOIN Materias as m ON m.IdMateria = gm.IdMateria
                JOIN Grupos as g ON g.IdGrupo = gm.IdGrupo 
                WHERE g.IdGrupo = ?""";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idGrupo);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MateriaModelo materia = new MateriaModelo();
                    materia.setNombre(rs.getString("Nombre"));
                    materia.setIdMateria(rs.getString("IdMateria"));
                    materia.setHcba(rs.getString("HBCA"));
                    materia.setHti(rs.getString("HTI"));
                    materia.setSemestre(rs.getString("Semestre"));
                    materia.setCreditos(rs.getString("Creditos"));
                    materia.setCarrera(rs.getString("IdCarrera"));
                    materia.setClave(rs.getString("Clave"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las materias del grupo: " + e.getMessage());
        }
        return materias;
    }

    // Método para agregar un grupo
    public boolean agregarGrupo(GrupoModelo grupo) {
        String sql = "INSERT INTO Grupos (Nombre, Semestre, IdCarrera) VALUES (?, ?, ?)";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
            pstmt.setString(3, grupo.getCarrera().getIdCarrera());

            int rowAfecteds = pstmt.executeUpdate();
            return rowAfecteds > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un grupo
    public boolean eliminarGrupo(int idGrupo) {
        String sql = "DELETE FROM Grupos WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

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
        String sql = "UPDATE Grupos SET Nombre = ?, Semestre = ?, IdCarrera = ? WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, grupo.getNombre());
            pstmt.setString(2, grupo.getSemestre());
            pstmt.setString(3, grupo.getCarrera().getIdCarrera());
            pstmt.setInt(4, Integer.parseInt(grupo.getId()));

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar todas las materias del grupo
    public boolean eliminarMaterias(String idGrupo) {
        String sql = "DELETE FROM GruposMaterias WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, Integer.parseInt(idGrupo));
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar las materias del Grupo: " + e.getMessage());
            return false;
        }
    }

    // Método para seleccionar un grupo
    public GrupoModelo seleccionarGrupo(int idGrupo) {
        String sql = "SELECT * FROM Grupos WHERE IdGrupo = ?";
        GrupoModelo grupoSeleccionado = null;

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idGrupo);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    grupoSeleccionado = mapResultSetToGrupo(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar grupo: " + e.getMessage());
        }
        return grupoSeleccionado;
    }

    // Buscar grupos por filtro
    public ArrayList<GrupoModelo> buscarGrupos(String where, String filtro) {
        ArrayList<GrupoModelo> resultados = new ArrayList<>();
        String sql = "SELECT * FROM Grupos WHERE " + where + " LIKE ? ";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filtro + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    GrupoModelo grupo = mapResultSetToGrupo(rs);
                    resultados.add(grupo);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar grupos", e);
        }
        return resultados;
    }

    // Obtener grupo por carrera y semestre
    public GrupoModelo getGrupoByCarreraAndSemestre(String idCarrera, String semestre) {
        GrupoModelo grupo = null;
        String sql = "SELECT * FROM Grupos WHERE IdCarrera = ? AND Semestre = ?";

        try (Connection conn = new Conexion().connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idCarrera);
            pstmt.setString(2, semestre);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    grupo = mapResultSetToGrupo(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar el grupo por carrera y semestre: " + e.getMessage());
        }
        return grupo;
    }
}
