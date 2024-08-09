package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.GrupoModelo;
import modelos.MaestroModelo;
import operaciones.conexion.Conexion;

public class OpMaestro {

    // Obtener todos los docentes
    public ArrayList<MaestroModelo> getDocentes() {
        ArrayList<MaestroModelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Docentes";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                MaestroModelo docente = mapResultSetToDocente(rs);
                lista.add(docente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar docentes", e);
        }
        return lista;
    }

    // Buscar docentes por filtro
    public ArrayList<MaestroModelo> buscarDocentes(String where, String filtro) {
        ArrayList<MaestroModelo> resultados = new ArrayList<>();
        String sql = "SELECT * FROM Docentes WHERE " + where + " LIKE ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, filtro + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MaestroModelo docente = mapResultSetToDocente(rs);
                    resultados.add(docente);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar docentes", e);
        }
        return resultados;
    }

    // Mapear ResultSet a MaestroModelo
    private MaestroModelo mapResultSetToDocente(ResultSet rs) throws SQLException {
        MaestroModelo maestro = new MaestroModelo();
        maestro.setRfc(rs.getString("RFC"));
        maestro.setCurp(rs.getString("CURP"));
        maestro.setNombre(rs.getString("Nombre"));
        maestro.setApPat(rs.getString("ApellidoPaterno"));
        maestro.setApMat(rs.getString("ApellidoMaterno"));
        maestro.setGenero(rs.getString("Genero"));
        maestro.setCorreoPer(rs.getString("CorreoPersonal"));
        maestro.setCorreoIns(rs.getString("CorreoInstitucional"));
        maestro.setDomicilio(rs.getString("Domicilio"));
        maestro.setCelular(rs.getString("Celular"));
        maestro.setEstado(rs.getString("Estado"));
        maestro.setMunicipio(rs.getString("Municipio"));
        maestro.setCv(rs.getString("CV"));
        maestro.setGrado(rs.getString("GradoEstudios"));
        maestro.setPasswordTemp(rs.getString("PasswordTemporal"));
        maestro.setFoto(rs.getString("Foto"));
        maestro.setId(rs.getString("IdDocente"));
        return maestro;
    }

    public boolean updateDocente(MaestroModelo docenteModelo) {
        String sqlDocente = "UPDATE Docentes SET CURP = ?, Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Genero = ?, "
                + "CorreoPersonal = ?, CorreoInstitucional = ?, Domicilio = ?, Celular = ?, Estado = ?, Municipio = ?, CV = ?, GradoEstudios = ?"
                + (docenteModelo.getFoto() != null ? ", Foto = ? " : "")
                + " WHERE RFC = ?";

        try (Connection conn = new Conexion().connect()) {
            conn.setAutoCommit(false);

            try (PreparedStatement pstmtDocente = conn.prepareStatement(sqlDocente)) {
                pstmtDocente.setString(1, docenteModelo.getCurp());
                pstmtDocente.setString(2, docenteModelo.getNombre());
                pstmtDocente.setString(3, docenteModelo.getApPat());
                pstmtDocente.setString(4, docenteModelo.getApMat());
                pstmtDocente.setString(5, docenteModelo.getGenero());
                pstmtDocente.setString(6, docenteModelo.getCorreoPer());
                pstmtDocente.setString(7, docenteModelo.getCorreoIns());
                pstmtDocente.setString(8, docenteModelo.getDomicilio());
                pstmtDocente.setString(9, docenteModelo.getCelular());
                pstmtDocente.setString(10, docenteModelo.getEstado());
                pstmtDocente.setString(11, docenteModelo.getMunicipio());
                pstmtDocente.setString(12, docenteModelo.getCv());
                pstmtDocente.setString(13, docenteModelo.getGrado());
                if (docenteModelo.getFoto() != null) {
                    pstmtDocente.setString(14, docenteModelo.getFoto());
                    pstmtDocente.setString(15, docenteModelo.getRfc());
                } else {
                    pstmtDocente.setString(14, docenteModelo.getRfc());
                }

                int affectedRowsDocente = pstmtDocente.executeUpdate();
                if (affectedRowsDocente == 0) {
                    conn.rollback();
                    throw new SQLException("Error al actualizar el docente, no se actualizó ninguna fila");
                }
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar docente y sus relaciones en DocentesGrupos", e);
        }
    }

    // Eliminar un docente
    public boolean deleteDocente(String rfc) {
        String sql = "DELETE FROM Docentes WHERE RFC = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rfc);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar docente", e);
        }
    }

    // Recuperar un docente por RFC
    public MaestroModelo obtenerDocente(String rfc) {
        String sql = "SELECT * FROM Docentes WHERE RFC = ?";
        MaestroModelo docente = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rfc);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    docente = mapResultSetToDocente(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar docente", e);
        }
        return docente;
    }

    // Recuperar un docente por RFC
    public MaestroModelo obtenerDocentePorId(String rfc) {
        String sql = "SELECT * FROM Docentes WHERE IdDocente = ?";
        MaestroModelo docente = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rfc);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    docente = mapResultSetToDocente(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar docente", e);
        }
        return docente;
    }

    public boolean crearDocente(MaestroModelo docenteModelo) {
        String sqlDocente = "INSERT INTO Docentes (RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, CV, GradoEstudios, PasswordTemporal"
                + (docenteModelo.getFoto() != null ? ", Foto" : "")
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                + (docenteModelo.getFoto() != null ? ", ?" : "")
                + ")";

        try (Connection conn = new Conexion().connect()) {
            conn.setAutoCommit(false);
            int newDocenteId;

            try (PreparedStatement pstmtDocente = conn.prepareStatement(sqlDocente)) {
                pstmtDocente.setString(1, docenteModelo.getRfc());
                pstmtDocente.setString(2, docenteModelo.getCurp());
                pstmtDocente.setString(3, docenteModelo.getNombre());
                pstmtDocente.setString(4, docenteModelo.getApPat());
                pstmtDocente.setString(5, docenteModelo.getApMat());
                pstmtDocente.setString(6, docenteModelo.getGenero());
                pstmtDocente.setString(7, docenteModelo.getCorreoPer());
                pstmtDocente.setString(8, docenteModelo.getCorreoIns());
                pstmtDocente.setString(9, docenteModelo.getDomicilio());
                pstmtDocente.setString(10, docenteModelo.getCelular());
                pstmtDocente.setString(11, docenteModelo.getEstado());
                pstmtDocente.setString(12, docenteModelo.getMunicipio());
                pstmtDocente.setString(13, docenteModelo.getCv());
                pstmtDocente.setString(14, docenteModelo.getGrado());
                pstmtDocente.setString(15, docenteModelo.getPasswordTemp());
                if (docenteModelo.getFoto() != null) {
                    pstmtDocente.setString(16, docenteModelo.getFoto());
                }

                int affectedRows = pstmtDocente.executeUpdate();
                if (affectedRows == 0) {
                    conn.rollback();
                    throw new SQLException("Error al crear docente, no se insertó ninguna fila");
                }
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear docente y sus relaciones en DocentesGrupos", e);
        }
    }

    // Recuperar un docente por IdDocente en GruposMaterias
    public MaestroModelo obtenerDocentePorGrupoYMateria(String idGrupo, String idMateria) {
        String sql = "SELECT d.* FROM Docentes d "
                + "JOIN GruposMaterias gm ON d.IdDocente = gm.IdDocente "
                + "WHERE gm.IdGrupo = ? AND gm.IdMateria = ?";
        MaestroModelo docente = null;

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, idGrupo);
            pstmt.setString(2, idMateria);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    docente = mapResultSetToDocente(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar docente", e);
        }
        return docente;
    }

    /*
    // Método para obtener grupos por RFC
    public ArrayList<GrupoModelo> obtenerGruposPorRFC(String rfc) {
        ArrayList<GrupoModelo> grupos = new ArrayList<>();
        String sql = "SELECT g.* "
                + "FROM Grupos g "
                + "JOIN DocentesGrupos dg ON g.IdGrupo = dg.IdGrupo "
                + "JOIN Docentes d ON dg.IdDocente = d.RFC "
                + "WHERE d.RFC = ?";

        try (Connection conn = new Conexion().connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rfc);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                
                    GrupoModelo grupo = seleccionarGrupo(rs.getInt("IdGrupo"));
                    grupos.add(grupo);
                  
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener grupos por RFC", e);
        }
        return grupos;
    }*/
}
