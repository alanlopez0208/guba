package operaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.MaestroModelo;
import operaciones.conexion.Conexion;

public class OpMaestro {

    private Connection conn;

    public OpMaestro() {
        conn = new Conexion().connect();
    }

    // Obtener todos los docentes
    public ArrayList<MaestroModelo> getDocentes() {
        ArrayList<MaestroModelo> lista = new ArrayList<>();
        String sql = "SELECT RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, CV, GradoEstudios, "
                + "PasswordTemporal, Foto FROM Docentes";

        try (PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
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
    public ArrayList<MaestroModelo> buscarDocentes(String filtro) {
        ArrayList<MaestroModelo> resultados = new ArrayList<>();
        String sql = "SELECT RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, CV, GradoEstudios, "
                + "PasswordTemporal, Foto FROM Docentes WHERE RFC LIKE ? OR Nombre LIKE ? "
                + "OR ApellidoPaterno LIKE ? OR ApellidoMaterno LIKE ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String likeParam = "%" + filtro + "%";
            for (int i = 1; i <= 4; i++) {
                pstmt.setString(i, likeParam);
            }

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

    // Mapear ResultSet a DocenteModelo
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

        return maestro;

    }

    // Actualizar un docente
    public boolean updateDocente(MaestroModelo docenteModelo) {
        String sql = "UPDATE Docentes SET CURP = ?, Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Genero = ?, "
                + "CorreoPersonal = ?, CorreoInstitucional = ?, Domicilio = ?, Celular = ?, Estado = ?, Municipio = ?, CV = ?, GradoEstudios = ?"
                + (docenteModelo.getFoto() != null ? ", Foto = ? " : "")
                + " WHERE RFC = ?";
        
    

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, docenteModelo.getCurp());
            pstmt.setString(2, docenteModelo.getNombre());
            pstmt.setString(3, docenteModelo.getApPat());
            pstmt.setString(4, docenteModelo.getApMat());
            pstmt.setString(5, docenteModelo.getGenero());
            pstmt.setString(6, docenteModelo.getCorreoPer());
            pstmt.setString(7, docenteModelo.getCorreoIns());
            pstmt.setString(8, docenteModelo.getDomicilio());
            pstmt.setString(9, docenteModelo.getCelular());
            pstmt.setString(10, docenteModelo.getEstado());
            pstmt.setString(11, docenteModelo.getMunicipio());
            pstmt.setString(12, docenteModelo.getCv());
            pstmt.setString(13, docenteModelo.getGrado());
            if (docenteModelo.getFoto() != null) {
                pstmt.setString(14, docenteModelo.getFoto());
                pstmt.setString(15, docenteModelo.getRfc());
            } else {
                pstmt.setString(14, docenteModelo.getRfc());
            }

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar docente", e);
        }
    }

    // Eliminar un docente
    public boolean deleteDocente(String rfc) {
        String sql = "DELETE FROM Docentes WHERE RFC = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rfc);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar docente", e);
        }
    }

    // Recuperar un docente por RFC
    public MaestroModelo retornarDocente(String rfc) {
        String sql = "SELECT RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, CV, GradoEstudios, "
                + "PasswordTemporal, Foto FROM Docentes WHERE RFC = ?";
        MaestroModelo docente = null;

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
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

    // Método para agregar un nuevo docente
    public boolean crearDocente(MaestroModelo docenteModelo) {
        String sql = "INSERT INTO Docentes (RFC, CURP, Nombre, ApellidoPaterno, ApellidoMaterno, Genero, CorreoPersonal, "
                + "CorreoInstitucional, Domicilio, Celular, Estado, Municipio, CV, GradoEstudios, PasswordTemporal"
                + (docenteModelo.getFoto() != null ? ", Foto" : "")
                + " ) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
                + (docenteModelo.getFoto() != null ? ", ?" : "")
                + " )";

        System.out.println(sql);

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, docenteModelo.getRfc());
            pstmt.setString(2, docenteModelo.getCurp());
            pstmt.setString(3, docenteModelo.getNombre());
            pstmt.setString(4, docenteModelo.getApPat());
            pstmt.setString(5, docenteModelo.getApMat());
            pstmt.setString(6, docenteModelo.getGenero());
            pstmt.setString(7, docenteModelo.getCorreoPer());
            pstmt.setString(8, docenteModelo.getCorreoIns());
            pstmt.setString(9, docenteModelo.getDomicilio());
            pstmt.setString(10, docenteModelo.getCelular());
            pstmt.setString(11, docenteModelo.getEstado());
            pstmt.setString(12, docenteModelo.getMunicipio());
            pstmt.setString(13, docenteModelo.getCv());
            pstmt.setString(14, docenteModelo.getGrado());
            pstmt.setString(15, docenteModelo.getRfc());
            if (docenteModelo.getFoto() != null) {
                pstmt.setString(16, docenteModelo.getFoto());
            }

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear docente", e);
        }
    }
}
