package operaciones;

import operaciones.conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import modelos.GrupoMateriaModelo;
import modelos.MaestroModelo;
import modelos.MateriaModelo;

public class OpGrupoMateria {

    // Método para mapear un ResultSet a un objeto GrupoMateriaModelo
    private GrupoMateriaModelo mapResultSetToGrupoMateria(ResultSet rs) throws SQLException {
        GrupoMateriaModelo grupoMateria = new GrupoMateriaModelo();
        OpMaterias opMaterias = new OpMaterias();
        MateriaModelo materia = opMaterias.getMateria(rs.getString("IdMateria"));
        OpMaestro opMaestros = new OpMaestro();
        MaestroModelo maestro = opMaestros.obtenerDocentePorId(rs.getString("IdDocente"));
        grupoMateria.setIdGrupoMateria(rs.getString("IdGrupoMateria"));

        grupoMateria.setIdGrupo(rs.getString("IdGrupo"));

        grupoMateria.setMateria(materia);
        grupoMateria.setMaestro(maestro);
        grupoMateria.setCursada(rs.getInt("Cursada"));

        return grupoMateria;
    }

    // Método para obtener todas las filas de GruposMaterias
    public ArrayList<GrupoMateriaModelo> getGruposMaterias() {
        ArrayList<GrupoMateriaModelo> listaGruposMaterias = new ArrayList<>();
        String sql = "SELECT * FROM GruposMaterias";

        try (Connection conn = new Conexion().connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                GrupoMateriaModelo grupoMateria = mapResultSetToGrupoMateria(rs);
                listaGruposMaterias.add(grupoMateria);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar todos los grupos de materias: " + e.getMessage());
        }
        return listaGruposMaterias;
    }

    // Método para agregar una fila a GruposMaterias
    public boolean agregarGrupoMateria(GrupoMateriaModelo grupoMateria) {
        String sql = "INSERT INTO GruposMaterias (IdGrupo, IdMateria, IdDocente, Cursada) VALUES (?, ?, ?, ?)";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, grupoMateria.getIdGrupo());
            pstmt.setString(2, grupoMateria.getMateria().getIdMateria());
            pstmt.setString(3, grupoMateria.getMaestro().getId());

            pstmt.setInt(4, grupoMateria.getCursada());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar grupo materia: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una fila de GruposMaterias
    public boolean eliminarGrupoMateria(int idGrupoMateria) {
        String sql = "DELETE FROM GruposMaterias WHERE IdGrupoMateria = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idGrupoMateria);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar grupo materia: " + e.getMessage());
            return false;
        }
    }

    // Método para actualizar una fila en GruposMaterias
    public boolean actualizarGrupoMateria(GrupoMateriaModelo grupoMateria) {
        String sql = "UPDATE GruposMaterias SET IdGrupo = ?, IdMateria = ?, IdDocente = ?, Cursada = ? WHERE IdGrupoMateria = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, grupoMateria.getIdGrupo());
            pstmt.setString(2, grupoMateria.getMateria().getId());
            pstmt.setString(3, grupoMateria.getMaestro().getId());
            pstmt.setInt(5, grupoMateria.getCursada());
            pstmt.setString(6, grupoMateria.getIdGrupoMateria());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error al actualizar grupo materia: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener un GrupoMateria por IdGrupoMateria
    public GrupoMateriaModelo obtenerGrupoMateriaPorId(int idGrupoMateria) {
        GrupoMateriaModelo grupoMateria = null;
        String sql = "SELECT * FROM GruposMaterias WHERE IdGrupoMateria = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idGrupoMateria);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    grupoMateria = mapResultSetToGrupoMateria(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener grupo materia por id: " + e.getMessage());
        }
        return grupoMateria;
    }

    // Método para obtener GruposMaterias donde IdGrupo sea igual al valor proporcionado
    public ArrayList<GrupoMateriaModelo> obtenerGruposMateriasPorIdGrupo(String idGrupo) {
        ArrayList<GrupoMateriaModelo> listaGruposMaterias = new ArrayList<>();
        String sql = "SELECT * FROM GruposMaterias WHERE IdGrupo = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, idGrupo);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    GrupoMateriaModelo grupoMateria = mapResultSetToGrupoMateria(rs);
                    listaGruposMaterias.add(grupoMateria);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener grupos de materias por IdGrupo: " + e.getMessage());
        }
        return listaGruposMaterias;
    }

    public boolean actualizarIdDocente(GrupoMateriaModelo grupoMateriaModelo, String nuevoIdDocente) {
        String sql = "UPDATE GruposMaterias SET IdDocente = ? WHERE IdGrupoMateria = ?";
        String updateCalificaciones = "UPDATE Calificaciones SET IdDocente = ? WHERE IdMateria = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            pstmt.setString(1, nuevoIdDocente);
            pstmt.setString(2, grupoMateriaModelo.getIdGrupoMateria());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Hubo un error al actualizar el profesor");
            }

            try (PreparedStatement pstmtCalificaciones = conn.prepareStatement(updateCalificaciones)) {
                pstmtCalificaciones.setString(1, nuevoIdDocente);
                System.out.println("LA ID MATERIA ES DE " +grupoMateriaModelo.getMateria().getIdMateria() );
                pstmtCalificaciones.setString(2, grupoMateriaModelo.getMateria().getIdMateria());
                rowsAffected = pstmtCalificaciones.executeUpdate();

                if (rowsAffected == 0) {
                    throw new SQLException("Hubo un error al actualizar el profesor en las calificaciones");
                }
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar IdDocente: " + e.getMessage());
            return false;
        }
    }

}
